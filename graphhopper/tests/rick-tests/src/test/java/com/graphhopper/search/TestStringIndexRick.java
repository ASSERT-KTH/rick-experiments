package com.graphhopper.search;
import com.graphhopper.storage.DataAccess;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class TestStringIndexRick {
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

    private DataAccess insertPrivateMockField_vals_InStringIndex(StringIndex receivingObject) throws Exception {
        DataAccess mockDataAccess = Mockito.mock(DataAccess.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("vals");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockDataAccess);
        return mockDataAccess;
    }

    private DataAccess insertPrivateMockField_keys_InStringIndex(StringIndex receivingObject) throws Exception {
        DataAccess mockDataAccess = Mockito.mock(DataAccess.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("keys");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockDataAccess);
        return mockDataAccess;
    }

    @Test
    @Disabled
    @DisplayName("loadExisting-1 with output oracle, mocking [com.graphhopper.storage.DataAccess.loadExisting(), com.graphhopper.storage.DataAccess.getHeader(int), com.graphhopper.storage.DataAccess.getName(), com.graphhopper.storage.DataAccess.getShort(long), com.graphhopper.storage.DataAccess.getBytes(long,byte[],int), java.util.Map.size(), java.util.List.add(java.lang.Object)]")
    public void test_loadExisting_OO_436074b107ce4ab38c5fc85a79f1ca08() throws Exception {
        // Arrange
        com.graphhopper.search.StringIndex receivingObject = deserializeObjectFromFile("com.graphhopper.search.StringIndex.loadExisting1-receiving.xml");
        DataAccess mockDataAccess = insertPrivateMockField_vals_InStringIndex(receivingObject);
//        DataAccess mockDataAccess = insertPrivateMockField_keys_InStringIndex(receivingObject);
        Mockito.when(mockDataAccess.loadExisting()).thenReturn(true);
        Mockito.when(mockDataAccess.getHeader(0)).thenReturn(6);
        Mockito.when(mockDataAccess.getName()).thenReturn("string_index_keys");
        Mockito.when(mockDataAccess.getName()).thenReturn("string_index_vals");
        Mockito.when(mockDataAccess.getHeader(4)).thenReturn(5340068);
        Mockito.when(mockDataAccess.getHeader(8)).thenReturn(0);
        Mockito.when(mockDataAccess.getShort(0L)).thenReturn((short) 2);
        Mockito.when(mockDataAccess.getShort(2L)).thenReturn((short) 0);
        Mockito.when(mockDataAccess.getShort(4L)).thenReturn((short) 4);
        // Act
        boolean actual = receivingObject.loadExisting();
        // Assert
        Assertions.assertEquals(true, actual);
    }

    @Test
    @Disabled
    @DisplayName("loadExisting-1 with parameter oracle, mocking [com.graphhopper.storage.DataAccess.loadExisting(), com.graphhopper.storage.DataAccess.getHeader(int), com.graphhopper.storage.DataAccess.getName(), com.graphhopper.storage.DataAccess.getShort(long), com.graphhopper.storage.DataAccess.getBytes(long,byte[],int), java.util.Map.size(), java.util.List.add(java.lang.Object)]")
    public void test_loadExisting_PO_436074b107ce4ab38c5fc85a79f1ca08() throws Exception {
        // Arrange
        com.graphhopper.search.StringIndex receivingObject = deserializeObjectFromFile("com.graphhopper.search.StringIndex.loadExisting1-receiving.xml");
        DataAccess mockDataAccess = insertPrivateMockField_vals_InStringIndex(receivingObject);
//        DataAccess mockDataAccess = insertPrivateMockField_keys_InStringIndex(receivingObject);
        Mockito.when(mockDataAccess.loadExisting()).thenReturn(true);
        Mockito.when(mockDataAccess.getHeader(0)).thenReturn(6);
        Mockito.when(mockDataAccess.getName()).thenReturn("string_index_keys");
        Mockito.when(mockDataAccess.getName()).thenReturn("string_index_vals");
        Mockito.when(mockDataAccess.getHeader(4)).thenReturn(5340068);
        Mockito.when(mockDataAccess.getHeader(8)).thenReturn(0);
        Mockito.when(mockDataAccess.getShort(0L)).thenReturn((short) 2);
        Mockito.when(mockDataAccess.getShort(2L)).thenReturn((short) 0);
        Mockito.when(mockDataAccess.getShort(4L)).thenReturn((short) 4);
        // Act
        receivingObject.loadExisting();
        // Assert
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).loadExisting();
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getHeader(0);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getName();
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getHeader(4);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getHeader(8);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getShort(0L);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getShort(2L);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getBytes(eq(4L),   (byte[]) any(),   eq(0));
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getShort(4L);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getBytes(eq(6L),   (byte[]) any(),   eq(4));
    }

    @Test
    @Disabled
    @DisplayName("loadExisting-1 with call oracle, mocking [com.graphhopper.storage.DataAccess.loadExisting(), com.graphhopper.storage.DataAccess.getHeader(int), com.graphhopper.storage.DataAccess.getName(), com.graphhopper.storage.DataAccess.getShort(long), com.graphhopper.storage.DataAccess.getBytes(long,byte[],int), java.util.Map.size(), java.util.List.add(java.lang.Object)]")
    public void test_loadExisting_CO_436074b107ce4ab38c5fc85a79f1ca08() throws Exception {
        // Arrange
        com.graphhopper.search.StringIndex receivingObject = deserializeObjectFromFile("com.graphhopper.search.StringIndex.loadExisting1-receiving.xml");
        DataAccess mockDataAccess = insertPrivateMockField_vals_InStringIndex(receivingObject);
//        DataAccess mockDataAccess = insertPrivateMockField_keys_InStringIndex(receivingObject);
        Mockito.when(mockDataAccess.loadExisting()).thenReturn(true);
        Mockito.when(mockDataAccess.getHeader(0)).thenReturn(6);
        Mockito.when(mockDataAccess.getName()).thenReturn("string_index_keys");
        Mockito.when(mockDataAccess.getName()).thenReturn("string_index_vals");
        Mockito.when(mockDataAccess.getHeader(4)).thenReturn(5340068);
        Mockito.when(mockDataAccess.getHeader(8)).thenReturn(0);
        Mockito.when(mockDataAccess.getShort(0L)).thenReturn((short) 2);
        Mockito.when(mockDataAccess.getShort(2L)).thenReturn((short) 0);
        Mockito.when(mockDataAccess.getShort(4L)).thenReturn((short) 4);
        // Act
        receivingObject.loadExisting();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockDataAccess, mockDataAccess, mockDataAccess, mockDataAccess, mockDataAccess, mockDataAccess, mockDataAccess, mockDataAccess, mockDataAccess, mockDataAccess);
        orderVerifier.verify(mockDataAccess, Mockito.times(2)).loadExisting();
        orderVerifier.verify(mockDataAccess, Mockito.times(2)).getHeader(anyInt());
        orderVerifier.verify(mockDataAccess, Mockito.times(2)).getName();
        orderVerifier.verify(mockDataAccess, Mockito.times(2)).getHeader(anyInt());
        orderVerifier.verify(mockDataAccess, Mockito.times(2)).getShort(anyLong());
        orderVerifier.verify(mockDataAccess, Mockito.times(1)).getBytes(anyLong(), (byte[]) any(), anyInt());
        orderVerifier.verify(mockDataAccess, Mockito.times(1)).getShort(anyLong());
        orderVerifier.verify(mockDataAccess, Mockito.times(1)).getBytes(anyLong(), (byte[]) any(), anyInt());
    }

    @Test
    @DisplayName("get-1 with output oracle, mocking [com.graphhopper.storage.DataAccess.getByte(long), com.graphhopper.storage.DataAccess.getShort(long), com.graphhopper.storage.DataAccess.getBytes(long,byte[],int)]")
    public void test_get_OO_aca48f1dafb44c69991e27af61897227() throws Exception {
        // Arrange
        com.graphhopper.search.StringIndex receivingObject = deserializeObjectFromFile("com.graphhopper.search.StringIndex.get1-receiving.xml");
        String paramsObjectStr = 
        "<object-array>" +
        "  <long>1183750</long>" +
        "  <string>name</string>" +
        "</object-array>";
        Object[] paramObjects = deserializeObjectFromString(paramsObjectStr);
        long paramObject1 = (Long) paramObjects[0];
        java.lang.String paramObject2 = (java.lang.String) paramObjects[1];
        DataAccess mockDataAccess = insertPrivateMockField_vals_InStringIndex(receivingObject);
        Mockito.when(mockDataAccess.getByte(1183750L)).thenReturn((byte) 1);
        Mockito.when(mockDataAccess.getShort(1183751L)).thenReturn((short) 1);
        Mockito.when(mockDataAccess.getByte(1183753L)).thenReturn((byte) 15);
        // Act
        java.lang.String actual = receivingObject.get(paramObject1, paramObject2);
        // Assert
        Assertions.assertEquals("Virebergsvägen", actual);
    }

    @Test
    @DisplayName("get-1 with parameter oracle, mocking [com.graphhopper.storage.DataAccess.getByte(long), com.graphhopper.storage.DataAccess.getShort(long), com.graphhopper.storage.DataAccess.getBytes(long,byte[],int)]")
    public void test_get_PO_aca48f1dafb44c69991e27af61897227() throws Exception {
        // Arrange
        com.graphhopper.search.StringIndex receivingObject = deserializeObjectFromFile("com.graphhopper.search.StringIndex.get1-receiving.xml");
        String paramsObjectStr = 
        "<object-array>" +
        "  <long>1183750</long>" +
        "  <string>name</string>" +
        "</object-array>";
        Object[] paramObjects = deserializeObjectFromString(paramsObjectStr);
        long paramObject1 = (Long) paramObjects[0];
        java.lang.String paramObject2 = (java.lang.String) paramObjects[1];
        DataAccess mockDataAccess = insertPrivateMockField_vals_InStringIndex(receivingObject);
        Mockito.when(mockDataAccess.getByte(1183750L)).thenReturn((byte) 1);
        Mockito.when(mockDataAccess.getShort(1183751L)).thenReturn((short) 1);
        Mockito.when(mockDataAccess.getByte(1183753L)).thenReturn((byte) 15);
        // Act
        receivingObject.get(paramObject1, paramObject2);
        // Assert
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getByte(1183750L);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getShort(1183751L);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getByte(1183753L);
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getBytes(eq(1183754L),   (byte[]) any(),   eq(15));
    }

    @Test
    @DisplayName("get-1 with call oracle, mocking [com.graphhopper.storage.DataAccess.getByte(long), com.graphhopper.storage.DataAccess.getShort(long), com.graphhopper.storage.DataAccess.getBytes(long,byte[],int)]")
    public void test_get_CO_aca48f1dafb44c69991e27af61897227() throws Exception {
        // Arrange
        com.graphhopper.search.StringIndex receivingObject = deserializeObjectFromFile("com.graphhopper.search.StringIndex.get1-receiving.xml");
        String paramsObjectStr = 
        "<object-array>" +
        "  <long>1183750</long>" +
        "  <string>name</string>" +
        "</object-array>";
        Object[] paramObjects = deserializeObjectFromString(paramsObjectStr);
        long paramObject1 = (Long) paramObjects[0];
        java.lang.String paramObject2 = (java.lang.String) paramObjects[1];
        DataAccess mockDataAccess = insertPrivateMockField_vals_InStringIndex(receivingObject);
        Mockito.when(mockDataAccess.getByte(1183750L)).thenReturn((byte) 1);
        Mockito.when(mockDataAccess.getShort(1183751L)).thenReturn((short) 1);
        Mockito.when(mockDataAccess.getByte(1183753L)).thenReturn((byte) 15);
        // Act
        receivingObject.get(paramObject1, paramObject2);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockDataAccess, mockDataAccess, mockDataAccess, mockDataAccess);
        orderVerifier.verify(mockDataAccess, Mockito.times(1)).getByte(anyLong());
        orderVerifier.verify(mockDataAccess, Mockito.times(1)).getShort(anyLong());
        orderVerifier.verify(mockDataAccess, Mockito.times(1)).getByte(anyLong());
        orderVerifier.verify(mockDataAccess, Mockito.times(1)).getBytes(anyLong(), (byte[]) any(), anyInt());
    }

    @Test
    @Disabled
    @DisplayName("close-1 with parameter oracle, mocking [com.graphhopper.storage.DataAccess.close()]")
    public void test_close_PO_6acc20d9f00a4ab2a4dc76ad9ab72a92() throws Exception {
        // Arrange
        com.graphhopper.search.StringIndex receivingObject = deserializeObjectFromFile("com.graphhopper.search.StringIndex.close1-receiving.xml");
        DataAccess mockDataAccess = insertPrivateMockField_keys_InStringIndex(receivingObject);
//        DataAccess mockDataAccess = insertPrivateMockField_vals_InStringIndex(receivingObject);
        // Act
        receivingObject.close();
        // Assert
        Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).close();
    }

    @Test
    @Disabled
    @DisplayName("close-1 with call oracle, mocking [com.graphhopper.storage.DataAccess.close()]")
    public void test_close_CO_6acc20d9f00a4ab2a4dc76ad9ab72a92() throws Exception {
        // Arrange
        com.graphhopper.search.StringIndex receivingObject = deserializeObjectFromFile("com.graphhopper.search.StringIndex.close1-receiving.xml");
        DataAccess mockDataAccess = insertPrivateMockField_keys_InStringIndex(receivingObject);
//        DataAccess mockDataAccess = insertPrivateMockField_vals_InStringIndex(receivingObject);
        // Act
        receivingObject.close();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockDataAccess);
        orderVerifier.verify(mockDataAccess, Mockito.times(2)).close();
    }
}