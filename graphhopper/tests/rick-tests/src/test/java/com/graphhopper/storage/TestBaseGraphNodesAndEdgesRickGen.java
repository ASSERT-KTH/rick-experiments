package com.graphhopper.storage;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class TestBaseGraphNodesAndEdgesRickGen {
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

    private DataAccess insertPrivateMockField_nodes_InBaseGraphNodesAndEdges(BaseGraphNodesAndEdges receivingObject) throws Exception {
        DataAccess mockDataAccess = Mockito.mock(DataAccess.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("nodes");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockDataAccess);
        return mockDataAccess;
    }

    private DataAccess insertPrivateMockField_edges_InBaseGraphNodesAndEdges(BaseGraphNodesAndEdges receivingObject) throws Exception {
        DataAccess mockDataAccess = Mockito.mock(DataAccess.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("edges");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockDataAccess);
        return mockDataAccess;
    }

    @Test
    @Disabled
    @DisplayName("loadExisting-1 with output oracle, mocking [com.graphhopper.storage.DataAccess.loadExisting(), com.graphhopper.storage.DataAccess.getHeader(int)]")
    public void test_loadExisting_OO_2cbabb84c8514433abb5a6b5ec90cc0a() throws Exception {
        // Arrange
        com.graphhopper.storage.BaseGraphNodesAndEdges receivingObject = deserializeObjectFromFile("com.graphhopper.storage.BaseGraphNodesAndEdges.loadExisting1-receiving.xml");
        DataAccess mockDataAccess = insertPrivateMockField_nodes_InBaseGraphNodesAndEdges(receivingObject);
//        DataAccess mockDataAccess = insertPrivateMockField_edges_InBaseGraphNodesAndEdges(receivingObject);
        Mockito.when(mockDataAccess.loadExisting()).thenReturn(true);
        Mockito.when(mockDataAccess.getHeader(0)).thenReturn(9);
        Mockito.when(mockDataAccess.getHeader(4)).thenReturn(16);
        Mockito.when(mockDataAccess.getHeader(8)).thenReturn(2669740);
        Mockito.when(mockDataAccess.getHeader(12)).thenReturn(101391693);
        Mockito.when(mockDataAccess.getHeader(16)).thenReturn(251965581);
        Mockito.when(mockDataAccess.getHeader(20)).thenReturn(538997012);
        Mockito.when(mockDataAccess.getHeader(24)).thenReturn(690812746);
        Mockito.when(mockDataAccess.getHeader(28)).thenReturn(1);
        Mockito.when(mockDataAccess.getHeader(32)).thenReturn(-43210);
        Mockito.when(mockDataAccess.getHeader(36)).thenReturn(4284790);
        // Act
        boolean actual = receivingObject.loadExisting();
        // Assert
        Assertions.assertEquals(true, actual);
    }

    @Test
    @Disabled
    @DisplayName("loadExisting-1 with parameter oracle, mocking [com.graphhopper.storage.DataAccess.loadExisting(), com.graphhopper.storage.DataAccess.getHeader(int)]")
    public void test_loadExisting_PO_2cbabb84c8514433abb5a6b5ec90cc0a() throws Exception {
        // Arrange
        com.graphhopper.storage.BaseGraphNodesAndEdges receivingObject = deserializeObjectFromFile("com.graphhopper.storage.BaseGraphNodesAndEdges.loadExisting1-receiving.xml");
        DataAccess mockDataAccess = insertPrivateMockField_nodes_InBaseGraphNodesAndEdges(receivingObject);
//        DataAccess mockDataAccess = insertPrivateMockField_edges_InBaseGraphNodesAndEdges(receivingObject);
        Mockito.when(mockDataAccess.loadExisting()).thenReturn(true);
        Mockito.when(mockDataAccess.getHeader(0)).thenReturn(9);
        Mockito.when(mockDataAccess.getHeader(4)).thenReturn(16);
        Mockito.when(mockDataAccess.getHeader(8)).thenReturn(2669740);
        Mockito.when(mockDataAccess.getHeader(12)).thenReturn(101391693);
        Mockito.when(mockDataAccess.getHeader(16)).thenReturn(251965581);
        Mockito.when(mockDataAccess.getHeader(20)).thenReturn(538997012);
        Mockito.when(mockDataAccess.getHeader(24)).thenReturn(690812746);
        Mockito.when(mockDataAccess.getHeader(28)).thenReturn(1);
        Mockito.when(mockDataAccess.getHeader(32)).thenReturn(-43210);
        Mockito.when(mockDataAccess.getHeader(36)).thenReturn(4284790);
        // Act
        receivingObject.loadExisting();
        // Assert
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).loadExisting();
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getHeader(0);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getHeader(4);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getHeader(8);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getHeader(12);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getHeader(16);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getHeader(20);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getHeader(24);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getHeader(28);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getHeader(32);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getHeader(36);
    }

    @Test
    @Disabled
    @DisplayName("loadExisting-1 with call oracle, mocking [com.graphhopper.storage.DataAccess.loadExisting(), com.graphhopper.storage.DataAccess.getHeader(int)]")
    public void test_loadExisting_CO_2cbabb84c8514433abb5a6b5ec90cc0a() throws Exception {
        // Arrange
        com.graphhopper.storage.BaseGraphNodesAndEdges receivingObject = deserializeObjectFromFile("com.graphhopper.storage.BaseGraphNodesAndEdges.loadExisting1-receiving.xml");
        DataAccess mockDataAccess = insertPrivateMockField_nodes_InBaseGraphNodesAndEdges(receivingObject);
//        DataAccess mockDataAccess = insertPrivateMockField_edges_InBaseGraphNodesAndEdges(receivingObject);
        Mockito.when(mockDataAccess.loadExisting()).thenReturn(true);
        Mockito.when(mockDataAccess.getHeader(0)).thenReturn(9);
        Mockito.when(mockDataAccess.getHeader(4)).thenReturn(16);
        Mockito.when(mockDataAccess.getHeader(8)).thenReturn(2669740);
        Mockito.when(mockDataAccess.getHeader(12)).thenReturn(101391693);
        Mockito.when(mockDataAccess.getHeader(16)).thenReturn(251965581);
        Mockito.when(mockDataAccess.getHeader(20)).thenReturn(538997012);
        Mockito.when(mockDataAccess.getHeader(24)).thenReturn(690812746);
        Mockito.when(mockDataAccess.getHeader(28)).thenReturn(1);
        Mockito.when(mockDataAccess.getHeader(32)).thenReturn(-43210);
        Mockito.when(mockDataAccess.getHeader(36)).thenReturn(4284790);
        // Act
        receivingObject.loadExisting();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockDataAccess, mockDataAccess, mockDataAccess, mockDataAccess, mockDataAccess, mockDataAccess, mockDataAccess, mockDataAccess, mockDataAccess, mockDataAccess, mockDataAccess);
        orderVerifier.verify(mockDataAccess, Mockito.times(2)).loadExisting();
        orderVerifier.verify(mockDataAccess, Mockito.times(10)).getHeader(anyInt());
    }
}