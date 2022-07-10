package org.gephi.layout.plugin.forceatlas2;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

import org.gephi.graph.api.Graph;
import org.gephi.layout.plugin.forceAtlas2.ForceAtlas2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestForceAtlas2RickGen {
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

    private Graph insertPrivateMockField_graph_InForceAtlas2(ForceAtlas2 receivingObject) throws Exception {
        Graph mockGraph = Mockito.mock(Graph.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("graph");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockGraph);
        return mockGraph;
    }

    @Test
    @DisplayName("initAlgo-1 with parameter oracle, mocking [org.gephi.graph.api.Graph.getDegree(org.gephi.graph.api.Node)]")
    public void test_initAlgo_PO_eb4141c9f7a240ef8280c1ff8e1ad4e9() throws Exception {
        // Arrange
        ForceAtlas2 receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.forceAtlas2.ForceAtlas2.initAlgo1-receiving.xml");
        Graph mockGraph = insertPrivateMockField_graph_InForceAtlas2(receivingObject);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(4);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(1);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(0);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(2);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(8);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(3);
        // Act
        receivingObject.initAlgo();
        // Assert
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).getDegree(any(org.gephi.graph.api.Node.class));
    }

    @Test
    @DisplayName("initAlgo-1 with call oracle, mocking [org.gephi.graph.api.Graph.getDegree(org.gephi.graph.api.Node)]")
    public void test_initAlgo_CO_eb4141c9f7a240ef8280c1ff8e1ad4e9() throws Exception {
        // Arrange
        ForceAtlas2 receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.forceAtlas2.ForceAtlas2.initAlgo1-receiving.xml");
        Graph mockGraph = insertPrivateMockField_graph_InForceAtlas2(receivingObject);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(4);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(1);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(0);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(2);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(8);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(3);
        // Act
        receivingObject.initAlgo();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraph);
        orderVerifier.verify(mockGraph, Mockito.times(10)).getDegree((org.gephi.graph.api.Node) any());
    }

    @Test
    @DisplayName("goAlgo-1 with parameter oracle, mocking [org.gephi.graph.api.Graph.getDegree(org.gephi.graph.api.Node)]")
    public void test_goAlgo_PO_3c2dc05b779e4224aef418ec6e93d188() throws Exception {
        // Arrange
        ForceAtlas2 receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.forceAtlas2.ForceAtlas2.goAlgo1-receiving.xml");
        Graph mockGraph = insertPrivateMockField_graph_InForceAtlas2(receivingObject);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(4);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(1);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(0);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(2);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(8);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(3);
        // Act
        receivingObject.goAlgo();
        // Assert
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).getDegree(any(org.gephi.graph.api.Node.class));
    }

    @Test
    @DisplayName("goAlgo-1 with call oracle, mocking [org.gephi.graph.api.Graph.getDegree(org.gephi.graph.api.Node)]")
    public void test_goAlgo_CO_3c2dc05b779e4224aef418ec6e93d188() throws Exception {
        // Arrange
        ForceAtlas2 receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.forceAtlas2.ForceAtlas2.goAlgo1-receiving.xml");
        Graph mockGraph = insertPrivateMockField_graph_InForceAtlas2(receivingObject);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(4);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(1);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(0);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(2);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(8);
        Mockito.when(mockGraph.getDegree(any(org.gephi.graph.api.Node.class))).thenReturn(3);
        // Act
        receivingObject.goAlgo();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraph);
        orderVerifier.verify(mockGraph, Mockito.times(10)).getDegree((org.gephi.graph.api.Node) any());
    }

    private ExecutorService insertPrivateMockField_pool_InForceAtlas2(ForceAtlas2 receivingObject) throws Exception {
        ExecutorService mockExecutorService = Mockito.mock(ExecutorService.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("pool");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockExecutorService);
        return mockExecutorService;
    }

    @Test
    @DisplayName("endAlgo-1 with parameter oracle, mocking [java.util.concurrent.ExecutorService.shutdown()]")
    public void test_endAlgo_PO_3633b19e6785497688f72f8f09c8efd6() throws Exception {
        // Arrange
        ForceAtlas2 receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.forceAtlas2.ForceAtlas2.endAlgo1-receiving.xml");
        ExecutorService mockExecutorService = insertPrivateMockField_pool_InForceAtlas2(receivingObject);
        // Act
        receivingObject.endAlgo();
        // Assert
        Mockito.verify(mockExecutorService, Mockito.atLeastOnce()).shutdown();
    }

    @Test
    @DisplayName("endAlgo-1 with call oracle, mocking [java.util.concurrent.ExecutorService.shutdown()]")
    public void test_endAlgo_CO_3633b19e6785497688f72f8f09c8efd6() throws Exception {
        // Arrange
        ForceAtlas2 receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.forceAtlas2.ForceAtlas2.endAlgo1-receiving.xml");
        ExecutorService mockExecutorService = insertPrivateMockField_pool_InForceAtlas2(receivingObject);
        // Act
        receivingObject.endAlgo();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockExecutorService);
        orderVerifier.verify(mockExecutorService, Mockito.times(1)).shutdown();
    }
}