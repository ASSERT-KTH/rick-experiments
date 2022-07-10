package org.gephi.layout.plugin.openord;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.lang.reflect.Field;
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
public class TestOpenOrdLayoutRickGen {
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

    private Graph insertPrivateMockField_graph_InOpenOrdLayout(OpenOrdLayout receivingObject) throws Exception {
        Graph mockGraph = Mockito.mock(Graph.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("graph");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockGraph);
        return mockGraph;
    }

    private Control insertPrivateMockField_control_InOpenOrdLayout(OpenOrdLayout receivingObject) throws Exception {
        Control mockControl = Mockito.mock(Control.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("control");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockControl);
        return mockControl;
    }

    @Test
    @DisplayName("initAlgo-1 with parameter oracle, mocking [org.gephi.graph.api.Graph.getNodeCount(), org.gephi.layout.plugin.openord.Control.initParams(org.gephi.layout.plugin.openord.Params,int), org.gephi.layout.plugin.openord.Control.initWorker(org.gephi.layout.plugin.openord.Worker)]")
    public void test_initAlgo_PO_85f725216cd6499ba5dc3c7d81605e53() throws Exception {
        // Arrange
        OpenOrdLayout receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.openord.OpenOrdLayout.initAlgo1-receiving.xml");
        Graph mockGraph = insertPrivateMockField_graph_InOpenOrdLayout(receivingObject);
        Control mockControl = insertPrivateMockField_control_InOpenOrdLayout(receivingObject);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(99);
        // Act
        receivingObject.initAlgo();
        // Assert
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).getNodeCount();
        Mockito.verify(mockControl, Mockito.atLeastOnce()).initParams(any(Params.class),   eq(750));
        Mockito.verify(mockControl, Mockito.atLeastOnce()).initWorker(any(Worker.class));
    }

    @Test
    @DisplayName("initAlgo-1 with call oracle, mocking [org.gephi.graph.api.Graph.getNodeCount(), org.gephi.layout.plugin.openord.Control.initParams(org.gephi.layout.plugin.openord.Params,int), org.gephi.layout.plugin.openord.Control.initWorker(org.gephi.layout.plugin.openord.Worker)]")
    public void test_initAlgo_CO_85f725216cd6499ba5dc3c7d81605e53() throws Exception {
        // Arrange
        OpenOrdLayout receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.openord.OpenOrdLayout.initAlgo1-receiving.xml");
        Graph mockGraph = insertPrivateMockField_graph_InOpenOrdLayout(receivingObject);
        Control mockControl = insertPrivateMockField_control_InOpenOrdLayout(receivingObject);
        Mockito.when(mockGraph.getNodeCount()).thenReturn(99);
        // Act
        receivingObject.initAlgo();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraph, mockControl, mockControl);
        orderVerifier.verify(mockGraph, Mockito.times(1)).getNodeCount();
        orderVerifier.verify(mockControl, Mockito.times(1)).initParams((Params) any(), anyInt());
        orderVerifier.verify(mockControl, Mockito.times(7)).initWorker((Worker) any());
    }
}