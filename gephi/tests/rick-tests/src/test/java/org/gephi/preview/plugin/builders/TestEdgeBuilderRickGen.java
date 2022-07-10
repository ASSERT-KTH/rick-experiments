package org.gephi.preview.plugin.builders;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.util.Scanner;

import org.gephi.graph.api.Graph;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestEdgeBuilderRickGen {
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

    @Test
    @DisplayName("getItems-1 with parameter oracle, mocking [org.gephi.graph.api.Graph.getEdgeCount(), org.gephi.graph.api.Graph.isDirected(org.gephi.graph.api.Edge)]")
    public void test_getItems_PO_32dbe480e2ea4c80950e6eb19ac80ebf() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.preview.plugin.builders.EdgeBuilder/>";
        EdgeBuilder receivingObject = deserializeObjectFromString(receivingObjectStr);
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.when(mockGraph.getEdgeCount()).thenReturn(3076);
        Mockito.when(mockGraph.isDirected(any(org.gephi.graph.api.Edge.class))).thenReturn(true);
        // Act
        receivingObject.getItems(mockGraph);
        // Assert
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).getEdgeCount();
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).isDirected(any(org.gephi.graph.api.Edge.class));
    }

    @Test
    @DisplayName("getItems-1 with call oracle, mocking [org.gephi.graph.api.Graph.getEdgeCount(), org.gephi.graph.api.Graph.isDirected(org.gephi.graph.api.Edge)]")
    public void test_getItems_CO_32dbe480e2ea4c80950e6eb19ac80ebf() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.preview.plugin.builders.EdgeBuilder/>";
        EdgeBuilder receivingObject = deserializeObjectFromString(receivingObjectStr);
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.when(mockGraph.getEdgeCount()).thenReturn(3076);
        Mockito.when(mockGraph.isDirected(any(org.gephi.graph.api.Edge.class))).thenReturn(true);
        // Act
        receivingObject.getItems(mockGraph);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraph, mockGraph);
        orderVerifier.verify(mockGraph, Mockito.times(1)).getEdgeCount();
        orderVerifier.verify(mockGraph, Mockito.times(10)).isDirected((org.gephi.graph.api.Edge) any());
    }
}