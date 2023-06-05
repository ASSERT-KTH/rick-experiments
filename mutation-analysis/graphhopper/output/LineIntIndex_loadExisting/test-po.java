package com.graphhopper.storage.index;

import com.graphhopper.storage.DataAccess;
import com.thoughtworks.xstream.XStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class TestLineIntIndexRickGen {
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

    private DataAccess insertMockField_dataAccess_InLineIntIndex(LineIntIndex receivingObject) throws NoSuchFieldException, IllegalAccessException {
        DataAccess mockDataAccess = Mockito.mock(DataAccess.class);
        Field field = receivingObject.getClass().getDeclaredField("dataAccess");
        field.setAccessible(true);
        field.set(receivingObject, mockDataAccess);
        return mockDataAccess;
    }

    @Test
    @DisplayName("loadExisting-1 with output oracle, mocking [com.graphhopper.storage.DataAccess.loadExisting(), com.graphhopper.storage.DataAccess.getHeader(int)]")
    public void test_loadExisting_OO_e5ef2f54a4cc4956be11115f9faf6853() throws Exception {
        // Arrange
        LineIntIndex receivingObject = deserializeObjectFromFile("com.graphhopper.storage.index.LineIntIndex.loadExisting1-receiving.xml");
        DataAccess mockDataAccess = insertMockField_dataAccess_InLineIntIndex(receivingObject);
        Mockito.when(mockDataAccess.loadExisting()).thenReturn(true);
        Mockito.when(mockDataAccess.getHeader(0)).thenReturn(5);
        Mockito.when(mockDataAccess.getHeader(4)).thenReturn(1813699);
        Mockito.when(mockDataAccess.getHeader(8)).thenReturn(300);
        // Act
        boolean actual = receivingObject.loadExisting();
        // Assert
//         Assertions.assertEquals(true, actual);
    }

    @Test
    @DisplayName("loadExisting-1 with parameter oracle, mocking [com.graphhopper.storage.DataAccess.loadExisting(), com.graphhopper.storage.DataAccess.getHeader(int)]")
    public void test_loadExisting_PO_e5ef2f54a4cc4956be11115f9faf6853() throws Exception {
        // Arrange
        LineIntIndex receivingObject = deserializeObjectFromFile("com.graphhopper.storage.index.LineIntIndex.loadExisting1-receiving.xml");
        DataAccess mockDataAccess = insertMockField_dataAccess_InLineIntIndex(receivingObject);
        Mockito.when(mockDataAccess.loadExisting()).thenReturn(true);
        Mockito.when(mockDataAccess.getHeader(0)).thenReturn(5);
        Mockito.when(mockDataAccess.getHeader(4)).thenReturn(1813699);
        Mockito.when(mockDataAccess.getHeader(8)).thenReturn(300);
        // Act
        receivingObject.loadExisting();
        // Assert
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).loadExisting();
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getHeader(0);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getHeader(4);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getHeader(8);
    }

    @Test
    @DisplayName("loadExisting-1 with call oracle, mocking [com.graphhopper.storage.DataAccess.loadExisting(), com.graphhopper.storage.DataAccess.getHeader(int)]")
    public void test_loadExisting_CO_e5ef2f54a4cc4956be11115f9faf6853() throws Exception {
        // Arrange
        LineIntIndex receivingObject = deserializeObjectFromFile("com.graphhopper.storage.index.LineIntIndex.loadExisting1-receiving.xml");
        DataAccess mockDataAccess = insertMockField_dataAccess_InLineIntIndex(receivingObject);
        Mockito.when(mockDataAccess.loadExisting()).thenReturn(true);
        Mockito.when(mockDataAccess.getHeader(0)).thenReturn(5);
        Mockito.when(mockDataAccess.getHeader(4)).thenReturn(1813699);
        Mockito.when(mockDataAccess.getHeader(8)).thenReturn(300);
        // Act
        receivingObject.loadExisting();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockDataAccess, mockDataAccess, mockDataAccess, mockDataAccess);
//         orderVerifier.verify(mockDataAccess, Mockito.times(1)).loadExisting();
//         orderVerifier.verify(mockDataAccess, Mockito.times(3)).getHeader(anyInt());
    }
}