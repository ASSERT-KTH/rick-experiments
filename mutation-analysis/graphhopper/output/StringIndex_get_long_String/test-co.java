package com.graphhopper.search;

import com.graphhopper.storage.DataAccess;
import com.thoughtworks.xstream.XStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class TestStringIndexRickGen {
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
    @DisplayName("get-1 with output oracle, mocking [com.graphhopper.storage.DataAccess.getByte(long), com.graphhopper.storage.DataAccess.getShort(long), com.graphhopper.storage.DataAccess.getBytes(long,byte[],int)]")
    public void test_get_OO_aca48f1dafb44c69991e27af61897227() throws Exception {
        // Arrange
        StringIndex receivingObject = deserializeObjectFromFile("com.graphhopper.search.StringIndex.get1-receiving.xml");
        String paramsObjectStr = 
        "<object-array>" +
        "  <long>1183750</long>" +
        "  <string>name</string>" +
        "</object-array>";
        Object[] paramObjects = deserializeObjectFromString(paramsObjectStr);
        long paramObject1 = (Long) paramObjects[0];
        String paramObject2 = (String) paramObjects[1];
        DataAccess mockDataAccess = insertPrivateMockField_vals_InStringIndex(receivingObject);
        Mockito.when(mockDataAccess.getByte(1183750L)).thenReturn((byte) 1);
        Mockito.when(mockDataAccess.getShort(1183751L)).thenReturn((short) 1);
        Mockito.when(mockDataAccess.getByte(1183753L)).thenReturn((byte) 15);
        // Act
        String actual = receivingObject.get(paramObject1, paramObject2);
        // Assert
//         Assertions.assertEquals("Virebergsvägen", actual);
    }

    @Test
    @DisplayName("get-1 with parameter oracle, mocking [com.graphhopper.storage.DataAccess.getByte(long), com.graphhopper.storage.DataAccess.getShort(long), com.graphhopper.storage.DataAccess.getBytes(long,byte[],int)]")
    public void test_get_PO_aca48f1dafb44c69991e27af61897227() throws Exception {
        // Arrange
        StringIndex receivingObject = deserializeObjectFromFile("com.graphhopper.search.StringIndex.get1-receiving.xml");
        String paramsObjectStr = 
        "<object-array>" +
        "  <long>1183750</long>" +
        "  <string>name</string>" +
        "</object-array>";
        Object[] paramObjects = deserializeObjectFromString(paramsObjectStr);
        long paramObject1 = (Long) paramObjects[0];
        String paramObject2 = (String) paramObjects[1];
        DataAccess mockDataAccess = insertPrivateMockField_vals_InStringIndex(receivingObject);
        Mockito.when(mockDataAccess.getByte(1183750L)).thenReturn((byte) 1);
        Mockito.when(mockDataAccess.getShort(1183751L)).thenReturn((short) 1);
        Mockito.when(mockDataAccess.getByte(1183753L)).thenReturn((byte) 15);
        // Act
        receivingObject.get(paramObject1, paramObject2);
        // Assert
//         Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getByte(1183750L);
//         Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getShort(1183751L);
//         Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getByte(1183753L);
//         Mockito.verify(mockDataAccess, Mockito.atLeastOnce()).getBytes(eq(1183754L),   (byte[]) any(),   eq(15));
    }

    @Test
    @DisplayName("get-1 with call oracle, mocking [com.graphhopper.storage.DataAccess.getByte(long), com.graphhopper.storage.DataAccess.getShort(long), com.graphhopper.storage.DataAccess.getBytes(long,byte[],int)]")
    public void test_get_CO_aca48f1dafb44c69991e27af61897227() throws Exception {
        // Arrange
        StringIndex receivingObject = deserializeObjectFromFile("com.graphhopper.search.StringIndex.get1-receiving.xml");
        String paramsObjectStr = 
        "<object-array>" +
        "  <long>1183750</long>" +
        "  <string>name</string>" +
        "</object-array>";
        Object[] paramObjects = deserializeObjectFromString(paramsObjectStr);
        long paramObject1 = (Long) paramObjects[0];
        String paramObject2 = (String) paramObjects[1];
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
}