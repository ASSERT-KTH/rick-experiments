package org.gephi.layout.plugin.forceatlas;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Scanner;

import org.gephi.graph.api.Graph;
import org.gephi.layout.plugin.forceAtlas.ForceAtlasLayout;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestForceAtlasLayoutRickGen {
    static XStream xStream = new XStream();

    private <T> T deserializeObjectFromString(String serializedObjectString) {
        return (T) xStream.fromXML(serializedObjectString);
    }

    private <T> T deserializeObjectFromFile(String serializedObjectFilePath) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File serializedObjectFile = new File(classLoader.getResource(serializedObjectFilePath).getFile());
        Scanner scanner = new Scanner(serializedObjectFile);
        String serializedObjectString = scanner.useDelimiter("\\A").next();
        return (T) xStream.fromXML(serializedObjectString);
    }

    private Graph insertPrivateMockField_graph_InForceAtlasLayout(ForceAtlasLayout receivingObject) throws Exception {
        Graph mockGraph = Mockito.mock(Graph.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("graph");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockGraph);
        return mockGraph;
    }

    @Test
    @DisplayName("goAlgo-1 with parameter oracle, mocking [org.gephi.graph.api.Graph.getDegree(org.gephi.graph.api.Node)]")
    public void test_goAlgo_PO_99781e1806a64e57860bf422828f5e88() throws Exception {
        // Arrange
        ForceAtlasLayout receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.forceAtlas.ForceAtlasLayout.goAlgo1-receiving.xml");
        Graph mockGraph = insertPrivateMockField_graph_InForceAtlasLayout(receivingObject);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(8);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(3);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(12);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(13);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(21);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(14);
        // Act
        receivingObject.goAlgo();
        // Assert
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).getDegree(any(org.gephi.graph.api.Node.class));
    }

    @Test
    @DisplayName("goAlgo-1 with call oracle, mocking [org.gephi.graph.api.Graph.getDegree(org.gephi.graph.api.Node)]")
    public void test_goAlgo_CO_99781e1806a64e57860bf422828f5e88() throws Exception {
        // Arrange
        ForceAtlasLayout receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.forceAtlas.ForceAtlasLayout.goAlgo1-receiving.xml");
        Graph mockGraph = insertPrivateMockField_graph_InForceAtlasLayout(receivingObject);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(8);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(3);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(12);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(13);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(21);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(14);
        // Act
        receivingObject.goAlgo();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraph);
        orderVerifier.verify(mockGraph, Mockito.times(10)).getDegree((org.gephi.graph.api.Node) any());
    }
}