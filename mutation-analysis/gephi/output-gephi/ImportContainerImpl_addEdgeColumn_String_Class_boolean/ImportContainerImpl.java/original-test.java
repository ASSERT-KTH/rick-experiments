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
public class TestImportContainerImplRickGenAddEdgeColumn {
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


    private Object2ObjectMap insertPrivateMockField_edgeColumns_InImportContainerImpl(ImportContainerImpl receivingObject) throws Exception {
        Object2ObjectMap mockObject2ObjectMap = Mockito.mock(Object2ObjectMap.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("edgeColumns");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockObject2ObjectMap);
        return mockObject2ObjectMap;
    }

    @Test
    @DisplayName("addEdgeColumn-1 with parameter oracle, mocking [it.unimi.dsi.fastutil.objects.Object2ObjectMap.size(), java.lang.Class.getSimpleName()]")
    public void test_addEdgeColumn_java_lang_String_java_lang_Class_boolean_PO_f1d2935101be4be680b0a91f9291070f() throws Exception {
        // Arrange
        ImportContainerImpl receivingObject = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportContainerImpl.addEdgeColumn_java.lang.String,java.lang.Class,boolean1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportContainerImpl.addEdgeColumn_java.lang.String,java.lang.Class,boolean1-params.xml");
        String paramObject1 = (String) paramObjects[0];
        Class paramObject2 = (Class) paramObjects[1];
        boolean paramObject3 = (Boolean) paramObjects[2];
        Object2ObjectMap mockObject2ObjectMap = insertPrivateMockField_edgeColumns_InImportContainerImpl(receivingObject);
        Mockito.when(mockObject2ObjectMap.size()).thenReturn(0);
        // Act
        receivingObject.addEdgeColumn(paramObject1, paramObject2, paramObject3);
        // Assert
        Mockito.verify(mockObject2ObjectMap, Mockito.atLeastOnce()).size();
    }

    @Test
    @DisplayName("addEdgeColumn-1 with call oracle, mocking [it.unimi.dsi.fastutil.objects.Object2ObjectMap.size(), java.lang.Class.getSimpleName()]")
    public void test_addEdgeColumn_java_lang_String_java_lang_Class_boolean_CO_f1d2935101be4be680b0a91f9291070f() throws Exception {
        // Arrange
        ImportContainerImpl receivingObject = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportContainerImpl.addEdgeColumn_java.lang.String,java.lang.Class,boolean1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportContainerImpl.addEdgeColumn_java.lang.String,java.lang.Class,boolean1-params.xml");
        String paramObject1 = (String) paramObjects[0];
        Class paramObject2 = (Class) paramObjects[1];
        boolean paramObject3 = (Boolean) paramObjects[2];
        Object2ObjectMap mockObject2ObjectMap = insertPrivateMockField_edgeColumns_InImportContainerImpl(receivingObject);
        Mockito.when(mockObject2ObjectMap.size()).thenReturn(0);
        // Act
        receivingObject.addEdgeColumn(paramObject1, paramObject2, paramObject3);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockObject2ObjectMap);
        orderVerifier.verify(mockObject2ObjectMap, Mockito.times(1)).size();
    }
}