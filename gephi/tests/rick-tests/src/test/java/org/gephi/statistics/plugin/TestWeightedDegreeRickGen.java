package org.gephi.statistics.plugin;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.util.Scanner;

import org.gephi.graph.api.DirectedGraph;
import org.gephi.graph.api.Graph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class TestWeightedDegreeRickGen {
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
    @DisplayName("calculateAverageWeightedDegree-1 with output oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_calculateAverageWeightedDegree_OO_93725bb82fc6428cb50f6e2fb652a87e() throws Exception {
        // Arrange
        WeightedDegree receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.WeightedDegree.calculateAverageWeightedDegree1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.statistics.plugin.WeightedDegree.calculateAverageWeightedDegree1-params.xml");
        boolean paramObject2 = (Boolean) paramObjects[1];
        boolean paramObject3 = (Boolean) paramObjects[2];
        DirectedGraph mockGraph = Mockito.mock(DirectedGraph.class);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        double actual = receivingObject.calculateAverageWeightedDegree(mockGraph, paramObject2, paramObject3);
        // Assert
        Assertions.assertEquals(3.079079079079079, actual);
    }

    @Test
    @DisplayName("calculateAverageWeightedDegree-1 with parameter oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_calculateAverageWeightedDegree_PO_93725bb82fc6428cb50f6e2fb652a87e() throws Exception {
        // Arrange
        WeightedDegree receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.WeightedDegree.calculateAverageWeightedDegree1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.statistics.plugin.WeightedDegree.calculateAverageWeightedDegree1-params.xml");
        boolean paramObject2 = (Boolean) paramObjects[1];
        boolean paramObject3 = (Boolean) paramObjects[2];
        DirectedGraph mockGraph = Mockito.mock(DirectedGraph.class);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.calculateAverageWeightedDegree(mockGraph, paramObject2, paramObject3);
        // Assert
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).getNodeCount();
    }

    @Test
    @DisplayName("calculateAverageWeightedDegree-1 with call oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_calculateAverageWeightedDegree_CO_93725bb82fc6428cb50f6e2fb652a87e() throws Exception {
        // Arrange
        WeightedDegree receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.WeightedDegree.calculateAverageWeightedDegree1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.statistics.plugin.WeightedDegree.calculateAverageWeightedDegree1-params.xml");
        boolean paramObject2 = (Boolean) paramObjects[1];
        boolean paramObject3 = (Boolean) paramObjects[2];
        DirectedGraph mockGraph = Mockito.mock(DirectedGraph.class);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.calculateAverageWeightedDegree(mockGraph, paramObject2, paramObject3);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraph);
        orderVerifier.verify(mockGraph, Mockito.times(2)).getNodeCount();
    }

    @Test
    @DisplayName("execute-1 with parameter oracle, mocking [org.gephi.graph.api.Graph.isDirected()]")
    public void test_execute_org_gephi_graph_api_Graph_PO_c8bab684def54b5c8fefc8d09ad3b5c8() throws Exception {
        // Arrange
        WeightedDegree receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.WeightedDegree.execute_org.gephi.graph.api.Graph1-receiving.xml");
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.when(mockGraph.isDirected()).thenReturn(true);
        // Act
        receivingObject.execute(mockGraph);
        // Assert
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).isDirected();
    }

    @Test
    @DisplayName("execute-1 with call oracle, mocking [org.gephi.graph.api.Graph.isDirected()]")
    public void test_execute_org_gephi_graph_api_Graph_CO_c8bab684def54b5c8fefc8d09ad3b5c8() throws Exception {
        // Arrange
        WeightedDegree receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.WeightedDegree.execute_org.gephi.graph.api.Graph1-receiving.xml");
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.when(mockGraph.isDirected()).thenReturn(true);
        // Act
        receivingObject.execute(mockGraph);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraph);
        orderVerifier.verify(mockGraph, Mockito.times(1)).isDirected();
    }
}