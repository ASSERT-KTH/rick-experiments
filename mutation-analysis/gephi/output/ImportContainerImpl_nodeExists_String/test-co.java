package org.gephi.importer.impl;

import com.thoughtworks.xstream.XStream;
import converters.FileCleanableConverter;
import it.unimi.dsi.fastutil.objects.Object2IntFunction;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.gephi.io.importer.api.EdgeDraft;
import org.gephi.io.importer.impl.ImportContainerImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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
public class TestImportContainerImplRickGenNodeExists {
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

    private Object2IntMap insertPrivateMockField_nodeMap_InImportContainerImpl(ImportContainerImpl receivingObject) throws Exception {
        Object2IntMap mockObject2IntMap = Mockito.mock(Object2IntMap.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("nodeMap");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockObject2IntMap);
        return mockObject2IntMap;
    }

    @BeforeAll
    public static void setxStream() {
        xStream.registerConverter(new FileCleanableConverter());
    }

    @Test
    @DisplayName("nodeExists-1 with output oracle, mocking [it.unimi.dsi.fastutil.objects.Object2IntMap.containsKey(java.lang.Object)]")
    public void test_nodeExists_OO_7833ebbee6984fa18d6f565fd004496e() throws Exception {
        // Arrange
        ImportContainerImpl receivingObject = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportContainerImpl.nodeExists1-receiving.xml");
        String paramsObjectStr = 
        "<object-array>" +
        "  <string>1</string>" +
        "</object-array>";
        Object[] paramObjects = deserializeObjectFromString(paramsObjectStr);
        String paramObject1 = (String) paramObjects[0];
        Object2IntMap mockObject2IntMap = insertPrivateMockField_nodeMap_InImportContainerImpl(receivingObject);
        Mockito.lenient().when(mockObject2IntMap.containsKey(any(Object.class))).thenReturn(false);
        // Act
        boolean actual = receivingObject.nodeExists(paramObject1);
        // Assert
//         Assertions.assertEquals(false, actual);
    }

    @Test
    @DisplayName("nodeExists-1 with parameter oracle, mocking [it.unimi.dsi.fastutil.objects.Object2IntMap.containsKey(java.lang.Object)]")
    public void test_nodeExists_PO_7833ebbee6984fa18d6f565fd004496e() throws Exception {
        // Arrange
        ImportContainerImpl receivingObject = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportContainerImpl.nodeExists1-receiving.xml");
        String paramsObjectStr = 
        "<object-array>" +
        "  <string>1</string>" +
        "</object-array>";
        Object[] paramObjects = deserializeObjectFromString(paramsObjectStr);
        String paramObject1 = (String) paramObjects[0];
        Object2IntMap mockObject2IntMap = insertPrivateMockField_nodeMap_InImportContainerImpl(receivingObject);
        Mockito.lenient().when(mockObject2IntMap.containsKey(any(Object.class))).thenReturn(false);
        // Act
        receivingObject.nodeExists(paramObject1);
        // Assert
//         Mockito.verify(mockObject2IntMap, Mockito.atLeastOnce()).containsKey(any(Object.class));
    }

    @Test
    @DisplayName("nodeExists-1 with call oracle, mocking [it.unimi.dsi.fastutil.objects.Object2IntMap.containsKey(java.lang.Object)]")
    public void test_nodeExists_CO_7833ebbee6984fa18d6f565fd004496e() throws Exception {
        // Arrange
        ImportContainerImpl receivingObject = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportContainerImpl.nodeExists1-receiving.xml");
        String paramsObjectStr = 
        "<object-array>" +
        "  <string>1</string>" +
        "</object-array>";
        Object[] paramObjects = deserializeObjectFromString(paramsObjectStr);
        String paramObject1 = (String) paramObjects[0];
        Object2IntMap mockObject2IntMap = insertPrivateMockField_nodeMap_InImportContainerImpl(receivingObject);
        Mockito.lenient().when(mockObject2IntMap.containsKey(any(Object.class))).thenReturn(false);
        // Act
        receivingObject.nodeExists(paramObject1);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockObject2IntMap);
        orderVerifier.verify(mockObject2IntMap, Mockito.times(1)).containsKey((Object) any());
    }
}