package org.gephi.statistics.plugin;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.util.Scanner;

import org.gephi.graph.api.Graph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class TestGraphDensityRickGen {
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
    @DisplayName("calculateDensity-1 with output oracle, mocking [org.gephi.graph.api.Graph.getEdgeCount(), org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_calculateDensity_OO_9cf7c4ae0207460f9c7b5b40964d7783() throws Exception {
        // Arrange
        GraphDensity receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.GraphDensity.calculateDensity1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.statistics.plugin.GraphDensity.calculateDensity1-params.xml");
        boolean paramObject2 = (Boolean) paramObjects[1];
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.lenient().when(mockGraph.getEdgeCount()).thenReturn(3076);
        Mockito.lenient().when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        double actual = receivingObject.calculateDensity(mockGraph, paramObject2);
        // Assert
//         Assertions.assertEquals(0.00308524957823555, actual);
    }

    @Test
    @DisplayName("calculateDensity-1 with parameter oracle, mocking [org.gephi.graph.api.Graph.getEdgeCount(), org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_calculateDensity_PO_9cf7c4ae0207460f9c7b5b40964d7783() throws Exception {
        // Arrange
        GraphDensity receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.GraphDensity.calculateDensity1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.statistics.plugin.GraphDensity.calculateDensity1-params.xml");
        boolean paramObject2 = (Boolean) paramObjects[1];
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.lenient().when(mockGraph.getEdgeCount()).thenReturn(3076);
        Mockito.lenient().when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.calculateDensity(mockGraph, paramObject2);
        // Assert
//         Mockito.verify(mockGraph, Mockito.atLeastOnce()).getEdgeCount();
//         Mockito.verify(mockGraph, Mockito.atLeastOnce()).getNodeCount();
    }

    @Test
    @DisplayName("calculateDensity-1 with call oracle, mocking [org.gephi.graph.api.Graph.getEdgeCount(), org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_calculateDensity_CO_9cf7c4ae0207460f9c7b5b40964d7783() throws Exception {
        // Arrange
        GraphDensity receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.GraphDensity.calculateDensity1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.statistics.plugin.GraphDensity.calculateDensity1-params.xml");
        boolean paramObject2 = (Boolean) paramObjects[1];
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.lenient().when(mockGraph.getEdgeCount()).thenReturn(3076);
        Mockito.lenient().when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.calculateDensity(mockGraph, paramObject2);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraph, mockGraph);
        orderVerifier.verify(mockGraph, Mockito.times(1)).getEdgeCount();
        orderVerifier.verify(mockGraph, Mockito.times(1)).getNodeCount();
    }
}