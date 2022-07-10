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
public class TestEigenvectorCentralityRickGen {
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
    @DisplayName("calculateEigenvectorCentrality-1 with output oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_calculateEigenvectorCentrality_OO_89da1e133bb0494c93295dcc90d608ee() throws Exception {
        // Arrange
        EigenvectorCentrality receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.EigenvectorCentrality.calculateEigenvectorCentrality1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.statistics.plugin.EigenvectorCentrality.calculateEigenvectorCentrality1-params.xml");
        double[] paramObject2 = (double[]) paramObjects[1];
        java.util.HashMap paramObject3 = (java.util.HashMap) paramObjects[2];
        java.util.HashMap paramObject4 = (java.util.HashMap) paramObjects[3];
        boolean paramObject5 = (Boolean) paramObjects[4];
        int paramObject6 = (Integer) paramObjects[5];
        DirectedGraph mockGraph = Mockito.mock(DirectedGraph.class);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        double actual = receivingObject.calculateEigenvectorCentrality(mockGraph, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6);
        // Assert
        Assertions.assertEquals(0.01338322724744468, actual);
    }

    @Test
    @DisplayName("calculateEigenvectorCentrality-1 with parameter oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_calculateEigenvectorCentrality_PO_89da1e133bb0494c93295dcc90d608ee() throws Exception {
        // Arrange
        EigenvectorCentrality receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.EigenvectorCentrality.calculateEigenvectorCentrality1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.statistics.plugin.EigenvectorCentrality.calculateEigenvectorCentrality1-params.xml");
        double[] paramObject2 = (double[]) paramObjects[1];
        java.util.HashMap paramObject3 = (java.util.HashMap) paramObjects[2];
        java.util.HashMap paramObject4 = (java.util.HashMap) paramObjects[3];
        boolean paramObject5 = (Boolean) paramObjects[4];
        int paramObject6 = (Integer) paramObjects[5];
        DirectedGraph mockGraph = Mockito.mock(DirectedGraph.class);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.calculateEigenvectorCentrality(mockGraph, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6);
        // Assert
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).getNodeCount();
    }

    @Test
    @DisplayName("calculateEigenvectorCentrality-1 with call oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_calculateEigenvectorCentrality_CO_89da1e133bb0494c93295dcc90d608ee() throws Exception {
        // Arrange
        EigenvectorCentrality receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.EigenvectorCentrality.calculateEigenvectorCentrality1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.statistics.plugin.EigenvectorCentrality.calculateEigenvectorCentrality1-params.xml");
        double[] paramObject2 = (double[]) paramObjects[1];
        java.util.HashMap paramObject3 = (java.util.HashMap) paramObjects[2];
        java.util.HashMap paramObject4 = (java.util.HashMap) paramObjects[3];
        boolean paramObject5 = (Boolean) paramObjects[4];
        int paramObject6 = (Integer) paramObjects[5];
        DirectedGraph mockGraph = Mockito.mock(DirectedGraph.class);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.calculateEigenvectorCentrality(mockGraph, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraph);
        orderVerifier.verify(mockGraph, Mockito.times(10)).getNodeCount();
    }

    @Test
    @DisplayName("execute-1 with parameter oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_execute_org_gephi_graph_api_Graph_PO_30ddb992f3a94b558263cae9e8e56ab2() throws Exception {
        // Arrange
        EigenvectorCentrality receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.EigenvectorCentrality.execute_org.gephi.graph.api.Graph1-receiving.xml");
        DirectedGraph mockGraph = Mockito.mock(DirectedGraph.class);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.execute(mockGraph);
        // Assert
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).getNodeCount();
    }

    @Test
    @DisplayName("execute-1 with call oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_execute_org_gephi_graph_api_Graph_CO_30ddb992f3a94b558263cae9e8e56ab2() throws Exception {
        // Arrange
        EigenvectorCentrality receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.EigenvectorCentrality.execute_org.gephi.graph.api.Graph1-receiving.xml");
        DirectedGraph mockGraph = Mockito.mock(DirectedGraph.class);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.execute(mockGraph);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraph);
        orderVerifier.verify(mockGraph, Mockito.times(10)).getNodeCount();
    }
}