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
public class TestCHStorageRickGen {
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

    private DataAccess insertPrivateMockField_nodesCH_InCHStorage(CHStorage receivingObject) throws Exception {
        DataAccess mockDataAccess = Mockito.mock(DataAccess.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("nodesCH");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockDataAccess);
        return mockDataAccess;
    }

    private DataAccess insertPrivateMockField_shortcuts_InCHStorage(CHStorage receivingObject) throws Exception {
        DataAccess mockDataAccess = Mockito.mock(DataAccess.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("shortcuts");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockDataAccess);
        return mockDataAccess;
    }

    @Test
    @Disabled
    @DisplayName("loadExisting-1 with output oracle, mocking [com.graphhopper.storage.DataAccess.loadExisting(), com.graphhopper.storage.DataAccess.getHeader(int), com.graphhopper.storage.DataAccess.getName()]")
    public void test_loadExisting_OO_c5ff9577e65b4d95903622893044ee7e() throws Exception {
        // Arrange
        com.graphhopper.storage.CHStorage receivingObject = deserializeObjectFromFile("com.graphhopper.storage.CHStorage.loadExisting1-receiving.xml");
        DataAccess mockDataAccess = insertPrivateMockField_nodesCH_InCHStorage(receivingObject);
//        DataAccess mockDataAccess = insertPrivateMockField_shortcuts_InCHStorage(receivingObject);
        Mockito.when(mockDataAccess.loadExisting()).thenReturn(true);
        Mockito.when(mockDataAccess.getHeader(0)).thenReturn(0);
        Mockito.when(mockDataAccess.getName()).thenReturn("nodes_ch_car");
        Mockito.when(mockDataAccess.getHeader(4)).thenReturn(2669740);
        Mockito.when(mockDataAccess.getHeader(8)).thenReturn(8);
        Mockito.when(mockDataAccess.getHeader(0)).thenReturn(8);
        Mockito.when(mockDataAccess.getName()).thenReturn("shortcuts_car");
        Mockito.when(mockDataAccess.getHeader(4)).thenReturn(1051276);
        Mockito.when(mockDataAccess.getHeader(8)).thenReturn(20);
        Mockito.when(mockDataAccess.getHeader(12)).thenReturn(0);
        Mockito.when(mockDataAccess.getHeader(16)).thenReturn(0);
        // Act
        boolean actual = receivingObject.loadExisting();
        // Assert
        Assertions.assertEquals(true, actual);
    }

    @Test
    @Disabled
    @DisplayName("loadExisting-1 with parameter oracle, mocking [com.graphhopper.storage.DataAccess.loadExisting(), com.graphhopper.storage.DataAccess.getHeader(int), com.graphhopper.storage.DataAccess.getName()]")
    public void test_loadExisting_PO_c5ff9577e65b4d95903622893044ee7e() throws Exception {
        // Arrange
        com.graphhopper.storage.CHStorage receivingObject = deserializeObjectFromFile("com.graphhopper.storage.CHStorage.loadExisting1-receiving.xml");
        DataAccess mockDataAccess = insertPrivateMockField_nodesCH_InCHStorage(receivingObject);
//        DataAccess mockDataAccess = insertPrivateMockField_shortcuts_InCHStorage(receivingObject);
        Mockito.when(mockDataAccess.loadExisting()).thenReturn(true);
        Mockito.when(mockDataAccess.getHeader(0)).thenReturn(0);
        Mockito.when(mockDataAccess.getName()).thenReturn("nodes_ch_car");
        Mockito.when(mockDataAccess.getHeader(4)).thenReturn(2669740);
        Mockito.when(mockDataAccess.getHeader(8)).thenReturn(8);
        Mockito.when(mockDataAccess.getHeader(0)).thenReturn(8);
        Mockito.when(mockDataAccess.getName()).thenReturn("shortcuts_car");
        Mockito.when(mockDataAccess.getHeader(4)).thenReturn(1051276);
        Mockito.when(mockDataAccess.getHeader(8)).thenReturn(20);
        Mockito.when(mockDataAccess.getHeader(12)).thenReturn(0);
        Mockito.when(mockDataAccess.getHeader(16)).thenReturn(0);
        // Act
        receivingObject.loadExisting();
        // Assert
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).loadExisting();
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getHeader(0);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getName();
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getHeader(4);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getHeader(8);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getHeader(12);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getHeader(16);
    }

    @Test
    @Disabled
    @DisplayName("loadExisting-1 with call oracle, mocking [com.graphhopper.storage.DataAccess.loadExisting(), com.graphhopper.storage.DataAccess.getHeader(int), com.graphhopper.storage.DataAccess.getName()]")
    public void test_loadExisting_CO_c5ff9577e65b4d95903622893044ee7e() throws Exception {
        // Arrange
        com.graphhopper.storage.CHStorage receivingObject = deserializeObjectFromFile("com.graphhopper.storage.CHStorage.loadExisting1-receiving.xml");
        DataAccess mockDataAccess = insertPrivateMockField_nodesCH_InCHStorage(receivingObject);
//        DataAccess mockDataAccess = insertPrivateMockField_shortcuts_InCHStorage(receivingObject);
        Mockito.when(mockDataAccess.loadExisting()).thenReturn(true);
        Mockito.when(mockDataAccess.getHeader(0)).thenReturn(0);
        Mockito.when(mockDataAccess.getName()).thenReturn("nodes_ch_car");
        Mockito.when(mockDataAccess.getHeader(4)).thenReturn(2669740);
        Mockito.when(mockDataAccess.getHeader(8)).thenReturn(8);
        Mockito.when(mockDataAccess.getHeader(0)).thenReturn(8);
        Mockito.when(mockDataAccess.getName()).thenReturn("shortcuts_car");
        Mockito.when(mockDataAccess.getHeader(4)).thenReturn(1051276);
        Mockito.when(mockDataAccess.getHeader(8)).thenReturn(20);
        Mockito.when(mockDataAccess.getHeader(12)).thenReturn(0);
        Mockito.when(mockDataAccess.getHeader(16)).thenReturn(0);
        // Act
        receivingObject.loadExisting();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockDataAccess, mockDataAccess, mockDataAccess, mockDataAccess, mockDataAccess, mockDataAccess, mockDataAccess);
        orderVerifier.verify(mockDataAccess, Mockito.times(2)).loadExisting();
        orderVerifier.verify(mockDataAccess, Mockito.times(1)).getHeader(anyInt());
        orderVerifier.verify(mockDataAccess, Mockito.times(1)).getName();
        orderVerifier.verify(mockDataAccess, Mockito.times(3)).getHeader(anyInt());
        orderVerifier.verify(mockDataAccess, Mockito.times(1)).getName();
        orderVerifier.verify(mockDataAccess, Mockito.times(4)).getHeader(anyInt());
    }
}