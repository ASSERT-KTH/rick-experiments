package org.gephi.statistics.plugin;
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
@ExtendWith(MockitoExtension.class)
public class TestGraphDistanceRickGen {
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
    @DisplayName("calculateDistanceMetrics-1 with parameter oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_calculateDistanceMetrics_PO_0f51babd20ff473a8ffb0356324f7d4b() throws Exception {
        // Arrange
        GraphDistance receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.GraphDistance.calculateDistanceMetrics1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.statistics.plugin.GraphDistance.calculateDistanceMetrics1-params.xml");
        java.util.HashMap paramObject2 = (java.util.HashMap) paramObjects[1];
        boolean paramObject3 = (Boolean) paramObjects[2];
        boolean paramObject4 = (Boolean) paramObjects[3];
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.calculateDistanceMetrics(mockGraph, paramObject2, paramObject3, paramObject4);
        // Assert
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).getNodeCount();
    }

    @Test
    @DisplayName("calculateDistanceMetrics-1 with call oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_calculateDistanceMetrics_CO_0f51babd20ff473a8ffb0356324f7d4b() throws Exception {
        // Arrange
        GraphDistance receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.GraphDistance.calculateDistanceMetrics1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.statistics.plugin.GraphDistance.calculateDistanceMetrics1-params.xml");
        java.util.HashMap paramObject2 = (java.util.HashMap) paramObjects[1];
        boolean paramObject3 = (Boolean) paramObjects[2];
        boolean paramObject4 = (Boolean) paramObjects[3];
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.calculateDistanceMetrics(mockGraph, paramObject2, paramObject3, paramObject4);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraph);
        orderVerifier.verify(mockGraph, Mockito.times(3)).getNodeCount();
    }

    @Test
    @DisplayName("execute-1 with parameter oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_execute_org_gephi_graph_api_Graph_PO_bb43dde8695241028be25606a7ce8e81() throws Exception {
        // Arrange
        GraphDistance receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.GraphDistance.execute_org.gephi.graph.api.Graph1-receiving.xml");
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.execute(mockGraph);
        // Assert
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).getNodeCount();
    }

    @Test
    @DisplayName("execute-1 with call oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_execute_org_gephi_graph_api_Graph_CO_bb43dde8695241028be25606a7ce8e81() throws Exception {
        // Arrange
        GraphDistance receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.GraphDistance.execute_org.gephi.graph.api.Graph1-receiving.xml");
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.execute(mockGraph);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraph);
        orderVerifier.verify(mockGraph, Mockito.times(4)).getNodeCount();
    }
}