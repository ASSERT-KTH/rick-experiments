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
public class TestClusteringCoefficientRickGen {
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
    @DisplayName("initStartValues-1 with parameter oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_initStartValues_PO_f29a1b805ab24ee590cd363de4ce23cc() throws Exception {
        // Arrange
        ClusteringCoefficient receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.ClusteringCoefficient.initStartValues1-receiving.xml");
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.lenient().when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.initStartValues(mockGraph);
        // Assert
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).getNodeCount();
    }

    @Test
    @DisplayName("initStartValues-1 with call oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_initStartValues_CO_f29a1b805ab24ee590cd363de4ce23cc() throws Exception {
        // Arrange
        ClusteringCoefficient receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.ClusteringCoefficient.initStartValues1-receiving.xml");
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.lenient().when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.initStartValues(mockGraph);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraph);
        orderVerifier.verify(mockGraph, Mockito.times(1)).getNodeCount();
    }
}