package org.gephi.statistics.plugin;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.util.Scanner;

import org.gephi.graph.api.DirectedGraph;
import org.gephi.graph.api.Graph;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class TestHitsRickGen {
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
    @DisplayName("calculateHits-1 with parameter oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_calculateHits_PO_251f37f2e7be4ff084fb1f1bf02e45fe() throws Exception {
        // Arrange
        Hits receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.Hits.calculateHits1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.statistics.plugin.Hits.calculateHits1-params.xml");
        double[] paramObject2 = (double[]) paramObjects[1];
        double[] paramObject3 = (double[]) paramObjects[2];
        java.util.Map paramObject4 = (java.util.Map) paramObjects[3];
        boolean paramObject5 = (Boolean) paramObjects[4];
        double paramObject6 = (Double) paramObjects[5];
        DirectedGraph mockGraph = Mockito.mock(DirectedGraph.class);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.calculateHits(mockGraph, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6);
        // Assert
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).getNodeCount();
    }

    @Test
    @DisplayName("calculateHits-1 with call oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_calculateHits_CO_251f37f2e7be4ff084fb1f1bf02e45fe() throws Exception {
        // Arrange
        Hits receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.Hits.calculateHits1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.statistics.plugin.Hits.calculateHits1-params.xml");
        double[] paramObject2 = (double[]) paramObjects[1];
        double[] paramObject3 = (double[]) paramObjects[2];
        java.util.Map paramObject4 = (java.util.Map) paramObjects[3];
        boolean paramObject5 = (Boolean) paramObjects[4];
        double paramObject6 = (Double) paramObjects[5];
        DirectedGraph mockGraph = Mockito.mock(DirectedGraph.class);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.calculateHits(mockGraph, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraph);
        orderVerifier.verify(mockGraph, Mockito.times(1)).getNodeCount();
    }

    @Test
    @DisplayName("execute-1 with parameter oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_execute_org_gephi_graph_api_Graph_PO_0d1971289ec8456aa6da5d1654cf4c34() throws Exception {
        // Arrange
        Hits receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.Hits.execute_org.gephi.graph.api.Graph1-receiving.xml");
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.execute(mockGraph);
        // Assert
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).getNodeCount();
    }

    @Test
    @DisplayName("execute-1 with call oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_execute_org_gephi_graph_api_Graph_CO_0d1971289ec8456aa6da5d1654cf4c34() throws Exception {
        // Arrange
        Hits receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.Hits.execute_org.gephi.graph.api.Graph1-receiving.xml");
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.execute(mockGraph);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraph);
        orderVerifier.verify(mockGraph, Mockito.times(2)).getNodeCount();
    }
}