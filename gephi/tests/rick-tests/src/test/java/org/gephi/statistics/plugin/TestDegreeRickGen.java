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

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class TestDegreeRickGen {
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
    @DisplayName("execute-1 with parameter oracle, mocking [org.gephi.graph.api.Graph.isDirected(), org.gephi.graph.api.Graph.setAttribute(java.lang.String,java.lang.Object)]")
    public void test_execute_org_gephi_graph_api_Graph_PO_28b577ff98254859875c3c7e7314d536() throws Exception {
        // Arrange
        Degree receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.Degree.execute_org.gephi.graph.api.Graph1-receiving.xml");
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.when(mockGraph.isDirected()).thenReturn(true);
        // Act
        receivingObject.execute(mockGraph);
        // Assert
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).isDirected();
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).setAttribute(eq("avgdegree"),   any(Object.class));
    }

    @Test
    @DisplayName("execute-1 with call oracle, mocking [org.gephi.graph.api.Graph.isDirected(), org.gephi.graph.api.Graph.setAttribute(java.lang.String,java.lang.Object)]")
    public void test_execute_org_gephi_graph_api_Graph_CO_28b577ff98254859875c3c7e7314d536() throws Exception {
        // Arrange
        Degree receivingObject = deserializeObjectFromFile("org.gephi.statistics.plugin.Degree.execute_org.gephi.graph.api.Graph1-receiving.xml");
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.when(mockGraph.isDirected()).thenReturn(true);
        // Act
        receivingObject.execute(mockGraph);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraph, mockGraph);
        orderVerifier.verify(mockGraph, Mockito.times(1)).isDirected();
        orderVerifier.verify(mockGraph, Mockito.times(1)).setAttribute(anyString(), (Object) any());
    }
}