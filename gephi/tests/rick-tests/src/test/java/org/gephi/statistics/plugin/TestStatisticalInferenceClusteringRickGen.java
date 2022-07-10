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
public class TestStatisticalInferenceClusteringRickGen {
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
    @DisplayName("execute-1 with parameter oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_execute_org_gephi_graph_api_Graph_PO_640f32335d41424898ebd239b5ff4a68() throws Exception {
        // Arrange
        StatisticalInferenceClustering receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.StatisticalInferenceClustering.execute_org.gephi.graph.api.Graph1-receiving.xml");
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.execute(mockGraph);
        // Assert
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).getNodeCount();
    }

    @Test
    @DisplayName("execute-1 with call oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_execute_org_gephi_graph_api_Graph_CO_640f32335d41424898ebd239b5ff4a68() throws Exception {
        // Arrange
        StatisticalInferenceClustering receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.StatisticalInferenceClustering.execute_org.gephi.graph.api.Graph1-receiving.xml");
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.execute(mockGraph);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraph);
        orderVerifier.verify(mockGraph, Mockito.times(5)).getNodeCount();
    }
}