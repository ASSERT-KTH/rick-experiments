package org.gephi.layout.plugin.scale;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.gephi.graph.api.Graph;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class TestAbstractScaleLayoutRickGen {
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

    public static List<Field> getAllFields(Class<?> type) {
        List<Field> fields = new ArrayList<Field>();
        for (Class<?> c = type; c != null; c = c.getSuperclass()) {
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
        }
        return fields;
    }

    private Graph insertPrivateMockField_graph_InContractLayout(ContractLayout receivingObject) throws Exception {
        Graph mockGraph = Mockito.mock(Graph.class);
        List<Field> allFields = getAllFields(receivingObject.getClass());
        List<Field> fieldToMock = allFields.stream().filter(field -> field.getName().equals("graph")).collect(Collectors.toList());
        fieldToMock.get(0).setAccessible(true);
        fieldToMock.get(0).set(receivingObject, mockGraph);
        return mockGraph;
    }

    @Test
    @DisplayName("goAlgo-1 with parameter oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_goAlgo_PO_46fb8f888c2146728f293a4aa5817f64() throws Exception {
        // Arrange
        ContractLayout receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.scale.AbstractScaleLayout.goAlgo1-receiving.xml");
        Graph mockGraph = insertPrivateMockField_graph_InContractLayout(receivingObject);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.goAlgo();
        // Assert
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).getNodeCount();
    }

    @Test
    @DisplayName("goAlgo-1 with call oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_goAlgo_CO_46fb8f888c2146728f293a4aa5817f64() throws Exception {
        // Arrange
        ContractLayout receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.scale.AbstractScaleLayout.goAlgo1-receiving.xml");
        Graph mockGraph = insertPrivateMockField_graph_InContractLayout(receivingObject);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.goAlgo();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraph);
        orderVerifier.verify(mockGraph, Mockito.times(2)).getNodeCount();
    }

    private Graph insertPrivateMockField_graph_InExpandLayout(ExpandLayout receivingObject) throws Exception {
        Graph mockGraph = Mockito.mock(Graph.class);
        List<Field> allFields = getAllFields(receivingObject.getClass());
        List<Field> fieldToMock = allFields.stream().filter(field -> field.getName().equals("graph")).collect(Collectors.toList());
        fieldToMock.get(0).setAccessible(true);
        fieldToMock.get(0).set(receivingObject, mockGraph);
        return mockGraph;
    }

    @Test
    @DisplayName("goAlgo-2 with parameter oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_goAlgo_PO_4cb273fad91240dea89f4a71102a2dfe() throws Exception {
        // Arrange
        ExpandLayout receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.scale.AbstractScaleLayout.goAlgo2-receiving.xml");
        Graph mockGraph = insertPrivateMockField_graph_InExpandLayout(receivingObject);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.goAlgo();
        // Assert
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).getNodeCount();
    }

    @Test
    @DisplayName("goAlgo-2 with call oracle, mocking [org.gephi.graph.api.Graph.getNodeCount()]")
    public void test_goAlgo_CO_4cb273fad91240dea89f4a71102a2dfe() throws Exception {
        // Arrange
        ExpandLayout receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.scale.AbstractScaleLayout.goAlgo2-receiving.xml");
        Graph mockGraph = insertPrivateMockField_graph_InExpandLayout(receivingObject);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(999);
        // Act
        receivingObject.goAlgo();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraph);
        orderVerifier.verify(mockGraph, Mockito.times(2)).getNodeCount();
    }
}