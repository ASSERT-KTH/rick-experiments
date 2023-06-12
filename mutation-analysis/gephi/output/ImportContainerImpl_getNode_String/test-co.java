package org.gephi.importer.impl;

import com.thoughtworks.xstream.XStream;
import converters.FileCleanableConverter;
import it.unimi.dsi.fastutil.objects.Object2IntFunction;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import org.gephi.io.importer.impl.ImportContainerImpl;
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
public class TestImportContainerImplRickGenGetNode {
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
    @DisplayName("getNode-1 with parameter oracle, mocking [it.unimi.dsi.fastutil.objects.Object2IntFunction.getInt(java.lang.Object)]")
    public void test_getNode_PO_1233b2c6a78a4afcbe3bc46773811c0e() throws Exception {
        // Arrange
        ImportContainerImpl receivingObject = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportContainerImpl.getNode1-receiving.xml");
        String paramsObjectStr = 
        "<object-array>" +
        "  <string>1</string>" +
        "</object-array>";
        Object[] paramObjects = deserializeObjectFromString(paramsObjectStr);
        String paramObject1 = (String) paramObjects[0];
        Object2IntFunction mockObject2IntFunction = insertPrivateMockField_nodeMap_InImportContainerImpl(receivingObject);
        Mockito.lenient().when(mockObject2IntFunction.getInt(any(Object.class))).thenReturn(0);
        // Act
        receivingObject.getNode(paramObject1);
        // Assert
//         Mockito.verify(mockObject2IntFunction, Mockito.atLeastOnce()).getInt(any(Object.class));
    }

    @Test
    @DisplayName("getNode-1 with call oracle, mocking [it.unimi.dsi.fastutil.objects.Object2IntFunction.getInt(java.lang.Object)]")
    public void test_getNode_CO_1233b2c6a78a4afcbe3bc46773811c0e() throws Exception {
        // Arrange
        ImportContainerImpl receivingObject = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportContainerImpl.getNode1-receiving.xml");
        String paramsObjectStr = 
        "<object-array>" +
        "  <string>1</string>" +
        "</object-array>";
        Object[] paramObjects = deserializeObjectFromString(paramsObjectStr);
        String paramObject1 = (String) paramObjects[0];
        Object2IntFunction mockObject2IntFunction = insertPrivateMockField_nodeMap_InImportContainerImpl(receivingObject);
        Mockito.lenient().when(mockObject2IntFunction.getInt(any(Object.class))).thenReturn(0);
        // Act
        receivingObject.getNode(paramObject1);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockObject2IntFunction);
        orderVerifier.verify(mockObject2IntFunction, Mockito.times(1)).getInt((Object) any());
    }
}