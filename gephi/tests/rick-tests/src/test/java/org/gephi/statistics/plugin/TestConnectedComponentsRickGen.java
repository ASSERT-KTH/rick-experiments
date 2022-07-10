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
public class TestConnectedComponentsRickGen {
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
    @DisplayName("computeWeaklyConnectedComponents-1 with parameter oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_computeWeaklyConnectedComponents_PO_5f92bbe159c340e6825c0e2c7e5a84cf() throws Exception {
        // Arrange
        ConnectedComponents receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.ConnectedComponents.computeWeaklyConnectedComponents1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.statistics.plugin.ConnectedComponents.computeWeaklyConnectedComponents1-params.xml");
        java.util.HashMap paramObject2 = (java.util.HashMap) paramObjects[1];
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.computeWeaklyConnectedComponents(mockGraph, paramObject2);
        // Assert
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).getNodeCount();
    }

    @Test
    @DisplayName("computeWeaklyConnectedComponents-1 with call oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_computeWeaklyConnectedComponents_CO_5f92bbe159c340e6825c0e2c7e5a84cf() throws Exception {
        // Arrange
        ConnectedComponents receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.ConnectedComponents.computeWeaklyConnectedComponents1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.statistics.plugin.ConnectedComponents.computeWeaklyConnectedComponents1-params.xml");
        java.util.HashMap paramObject2 = (java.util.HashMap) paramObjects[1];
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.computeWeaklyConnectedComponents(mockGraph, paramObject2);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraph);
        orderVerifier.verify(mockGraph, Mockito.times(1)).getNodeCount();
    }

    @Test
    @DisplayName("top_tarjans-1 with parameter oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_top_tarjans_PO_2ea50032a1f144aba3ac58f0d451e49c() throws Exception {
        // Arrange
        ConnectedComponents receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.ConnectedComponents.top_tarjans1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.statistics.plugin.ConnectedComponents.top_tarjans1-params.xml");
        java.util.HashMap paramObject2 = (java.util.HashMap) paramObjects[1];
        DirectedGraph mockGraph = Mockito.mock(DirectedGraph.class);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.top_tarjans(mockGraph, paramObject2);
        // Assert
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).getNodeCount();
    }

    @Test
    @DisplayName("top_tarjans-1 with call oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_top_tarjans_CO_2ea50032a1f144aba3ac58f0d451e49c() throws Exception {
        // Arrange
        ConnectedComponents receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.ConnectedComponents.top_tarjans1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.statistics.plugin.ConnectedComponents.top_tarjans1-params.xml");
        java.util.HashMap paramObject2 = (java.util.HashMap) paramObjects[1];
        DirectedGraph mockGraph = Mockito.mock(DirectedGraph.class);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.top_tarjans(mockGraph, paramObject2);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraph);
        orderVerifier.verify(mockGraph, Mockito.times(1)).getNodeCount();
    }
}