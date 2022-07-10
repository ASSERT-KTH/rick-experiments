package org.gephi.importer.impl;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Scanner;

import converters.FileCleanableConverter;
import it.unimi.dsi.fastutil.objects.Object2IntFunction;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.gephi.io.importer.api.EdgeDraft;
import org.gephi.io.importer.impl.ElementDraftImpl;
import org.gephi.io.importer.impl.ImportContainerImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class TestImportContainerImplRickGen {
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
        Mockito.when(mockObject2IntMap.containsKey(any(Object.class))).thenReturn(false);
        // Act
        boolean actual = receivingObject.nodeExists(paramObject1);
        // Assert
        Assertions.assertEquals(false, actual);
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
        Mockito.when(mockObject2IntMap.containsKey(any(Object.class))).thenReturn(false);
        // Act
        receivingObject.nodeExists(paramObject1);
        // Assert
        Mockito.verify(mockObject2IntMap, Mockito.atLeastOnce()).containsKey(any(Object.class));
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
        Mockito.when(mockObject2IntMap.containsKey(any(Object.class))).thenReturn(false);
        // Act
        receivingObject.nodeExists(paramObject1);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockObject2IntMap);
        orderVerifier.verify(mockObject2IntMap, Mockito.times(1)).containsKey((Object) any());
    }

    private ObjectList insertPrivateMockField_nodeList_InImportContainerImpl(ImportContainerImpl receivingObject) throws Exception {
        ObjectList mockList = Mockito.mock(ObjectList.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("nodeList");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockList);
        return mockList;
    }

    @Test
    @DisplayName("addNode-1 with parameter oracle, mocking [it.unimi.dsi.fastutil.objects.Object2IntMap.containsKey(java.lang.Object), java.util.List.add(java.lang.Object), it.unimi.dsi.fastutil.objects.Object2IntFunction.put(java.lang.Object,int)]")
    public void test_addNode_PO_022ea0a43645422280137589127ed85b() throws Exception {
        // Arrange
        ImportContainerImpl receivingObject = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportContainerImpl.addNode1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportContainerImpl.addNode1-params.xml");
        org.gephi.io.importer.api.NodeDraft paramObject1 = (org.gephi.io.importer.api.NodeDraft) paramObjects[0];
        Object2IntMap mockObject2IntMap = insertPrivateMockField_nodeMap_InImportContainerImpl(receivingObject);
        ObjectList mockList = insertPrivateMockField_nodeList_InImportContainerImpl(receivingObject);
        Object2IntFunction mockObject2IntFunction = insertPrivateMockField_nodeMap_InImportContainerImpl(receivingObject);
        Mockito.when(mockObject2IntMap.containsKey(any(Object.class))).thenReturn(false);
        Mockito.when(mockList.add(any(Object.class))).thenReturn(true);
        Mockito.when(mockObject2IntFunction.put(any(Object.class),   eq(0))).thenReturn(-1);
        // Act
        receivingObject.addNode(paramObject1);
        // Assert
        Mockito.verify(mockObject2IntMap, Mockito.atLeastOnce()).containsKey(any(Object.class));
        Mockito.verify(mockList, Mockito.atLeastOnce()).add(any(Object.class));
        Mockito.verify(mockObject2IntFunction, Mockito.atLeastOnce()).put(any(Object.class),   eq(0));
    }

    @Test
    @DisplayName("addNode-1 with call oracle, mocking [it.unimi.dsi.fastutil.objects.Object2IntMap.containsKey(java.lang.Object), java.util.List.add(java.lang.Object), it.unimi.dsi.fastutil.objects.Object2IntFunction.put(java.lang.Object,int)]")
    public void test_addNode_CO_022ea0a43645422280137589127ed85b() throws Exception {
        // Arrange
        ImportContainerImpl receivingObject = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportContainerImpl.addNode1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportContainerImpl.addNode1-params.xml");
        org.gephi.io.importer.api.NodeDraft paramObject1 = (org.gephi.io.importer.api.NodeDraft) paramObjects[0];
        Object2IntMap mockObject2IntMap = insertPrivateMockField_nodeMap_InImportContainerImpl(receivingObject);
        ObjectList mockList = insertPrivateMockField_nodeList_InImportContainerImpl(receivingObject);
        Object2IntFunction mockObject2IntFunction = insertPrivateMockField_nodeMap_InImportContainerImpl(receivingObject);
        Mockito.when(mockObject2IntMap.containsKey(any(Object.class))).thenReturn(false);
        Mockito.when(mockList.add(any(Object.class))).thenReturn(true);
        Mockito.when(mockObject2IntFunction.put(any(Object.class),   eq(0))).thenReturn(-1);
        // Act
        receivingObject.addNode(paramObject1);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockObject2IntMap, mockList, mockObject2IntFunction);
        orderVerifier.verify(mockObject2IntMap, Mockito.times(1)).containsKey((Object) any());
        orderVerifier.verify(mockList, Mockito.times(1)).add((Object) any());
        orderVerifier.verify(mockObject2IntFunction, Mockito.times(1)).put((Object) any(), anyInt());
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
        Mockito.when(mockObject2IntFunction.getInt(any(Object.class))).thenReturn(0);
        // Act
        receivingObject.getNode(paramObject1);
        // Assert
        Mockito.verify(mockObject2IntFunction, Mockito.atLeastOnce()).getInt(any(Object.class));
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
        Mockito.when(mockObject2IntFunction.getInt(any(Object.class))).thenReturn(0);
        // Act
        receivingObject.getNode(paramObject1);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockObject2IntFunction);
        orderVerifier.verify(mockObject2IntFunction, Mockito.times(1)).getInt((Object) any());
    }

    private Object2IntMap insertPrivateMockField_edgeMap_InImportContainerImpl(ImportContainerImpl receivingObject) throws Exception {
        Object2IntMap mockObject2IntMap = Mockito.mock(Object2IntMap.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("edgeMap");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockObject2IntMap);
        return mockObject2IntMap;
    }

    private ObjectList insertPrivateMockField_edgeList_InImportContainerImpl(ImportContainerImpl receivingObject) throws Exception {
        ObjectList mockList = Mockito.mock(ObjectList.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("edgeList");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockList);
        return mockList;
    }

    @Test
    @DisplayName("addEdge-1 with parameter oracle, mocking [it.unimi.dsi.fastutil.objects.Object2IntMap.containsKey(java.lang.Object), java.util.List.add(java.lang.Object), it.unimi.dsi.fastutil.objects.Object2IntFunction.put(java.lang.Object,int), org.gephi.io.importer.api.ElementDraft.getId()]")
    public void test_addEdge_PO_31ab0355440e490b85d71648e585de54() throws Exception {
        // Arrange
        ImportContainerImpl receivingObject = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportContainerImpl.addEdge1-receiving.xml");
        EdgeDraft mockElementDraft = Mockito.mock(EdgeDraft.class);
        Object2IntMap mockObject2IntMap = insertPrivateMockField_edgeMap_InImportContainerImpl(receivingObject);
        Object2IntFunction mockObject2IntFunction = insertPrivateMockField_edgeMap_InImportContainerImpl(receivingObject);
        ObjectList mockList = insertPrivateMockField_edgeList_InImportContainerImpl(receivingObject);
        Mockito.when(mockElementDraft.getId()).thenReturn("0");
        Mockito.when(mockObject2IntMap.containsKey(any(Object.class))).thenReturn(false);
        Mockito.when(mockObject2IntFunction.put(any(Object.class),   eq(0))).thenReturn(0);
        Mockito.when(mockList.add(any(Object.class))).thenReturn(true);
        Mockito.when(mockObject2IntFunction.put(any(Object.class),   eq(0))).thenReturn(-1);
        // Act
        receivingObject.addEdge(mockElementDraft);
        // Assert
        Mockito.verify(mockElementDraft, Mockito.atLeastOnce()).getId();
        Mockito.verify(mockObject2IntMap, Mockito.atLeastOnce()).containsKey(any(Object.class));
        Mockito.verify(mockObject2IntFunction, Mockito.atLeastOnce()).put(any(Object.class),   eq(0));
        Mockito.verify(mockList, Mockito.atLeastOnce()).add(any(Object.class));
    }

    @Test
    @DisplayName("addEdge-1 with call oracle, mocking [it.unimi.dsi.fastutil.objects.Object2IntMap.containsKey(java.lang.Object), java.util.List.add(java.lang.Object), it.unimi.dsi.fastutil.objects.Object2IntFunction.put(java.lang.Object,int), org.gephi.io.importer.api.ElementDraft.getId()]")
    public void test_addEdge_CO_31ab0355440e490b85d71648e585de54() throws Exception {
        // Arrange
        ImportContainerImpl receivingObject = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportContainerImpl.addEdge1-receiving.xml");
        EdgeDraft mockElementDraft = Mockito.mock(EdgeDraft.class);
        Object2IntMap mockObject2IntMap = insertPrivateMockField_edgeMap_InImportContainerImpl(receivingObject);
        Object2IntFunction mockObject2IntFunction = insertPrivateMockField_edgeMap_InImportContainerImpl(receivingObject);
        ObjectList mockList = insertPrivateMockField_edgeList_InImportContainerImpl(receivingObject);
        Mockito.when(mockElementDraft.getId()).thenReturn("0");
        Mockito.when(mockObject2IntMap.containsKey(any(Object.class))).thenReturn(false);
        Mockito.when(mockObject2IntFunction.put(any(Object.class),   eq(0))).thenReturn(0);
        Mockito.when(mockList.add(any(Object.class))).thenReturn(true);
        Mockito.when(mockObject2IntFunction.put(any(Object.class),   eq(0))).thenReturn(-1);
        // Act
        receivingObject.addEdge(mockElementDraft);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockElementDraft, mockObject2IntMap, mockObject2IntFunction, mockList);
        orderVerifier.verify(mockElementDraft, Mockito.times(1)).getId();
        orderVerifier.verify(mockObject2IntMap, Mockito.times(2)).containsKey((Object) any());
        orderVerifier.verify(mockObject2IntFunction, Mockito.times(1)).put((Object) any(), anyInt());
        orderVerifier.verify(mockList, Mockito.times(1)).add((Object) any());
        orderVerifier.verify(mockElementDraft, Mockito.times(1)).getId();
        orderVerifier.verify(mockObject2IntFunction, Mockito.times(1)).put((Object) any(), anyInt());
    }

    private Object2IntMap insertPrivateMockField_edgeTypeMap_InImportContainerImpl(ImportContainerImpl receivingObject) throws Exception {
        Object2IntMap mockObject2IntMap = Mockito.mock(Object2IntMap.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("edgeTypeMap");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockObject2IntMap);
        return mockObject2IntMap;
    }

    @Test
    @DisplayName("verify-1 with output oracle, mocking [java.lang.Class.getSimpleName(), it.unimi.dsi.fastutil.objects.Object2IntMap.size()]")
    public void test_verify_OO_dd8042f5945b45f09b42141fd205eac1() throws Exception {
        // Arrange
        // Assert
        // Assert
        ImportContainerImpl receivingObject = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportContainerImpl.verify1-receiving.xml");
        Object2IntMap mockObject2IntMap = insertPrivateMockField_edgeTypeMap_InImportContainerImpl(receivingObject);
        Mockito.when(mockObject2IntMap.size()).thenReturn(1);
        // Act
        boolean actual = receivingObject.verify();
        Assertions.assertEquals(true, actual);
    }

    @Test
    @DisplayName("verify-1 with parameter oracle, mocking [java.lang.Class.getSimpleName(), it.unimi.dsi.fastutil.objects.Object2IntMap.size()]")
    public void test_verify_PO_dd8042f5945b45f09b42141fd205eac1() throws Exception {
        // Arrange
        ImportContainerImpl receivingObject = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportContainerImpl.verify1-receiving.xml");
        Object2IntMap mockObject2IntMap = insertPrivateMockField_edgeTypeMap_InImportContainerImpl(receivingObject);
        Mockito.when(mockObject2IntMap.size()).thenReturn(1);
        // Act
        receivingObject.verify();
        // Assert
        Mockito.verify(mockObject2IntMap, Mockito.atLeastOnce()).size();
    }

    @Test
    @DisplayName("verify-1 with call oracle, mocking [java.lang.Class.getSimpleName(), it.unimi.dsi.fastutil.objects.Object2IntMap.size()]")
    public void test_verify_CO_dd8042f5945b45f09b42141fd205eac1() throws Exception {
        // Arrange
        ImportContainerImpl receivingObject = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportContainerImpl.verify1-receiving.xml");
        Object2IntMap mockObject2IntMap = insertPrivateMockField_edgeTypeMap_InImportContainerImpl(receivingObject);
        Mockito.when(mockObject2IntMap.size()).thenReturn(1);
        // Act
        receivingObject.verify();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockObject2IntMap);
        orderVerifier.verify(mockObject2IntMap, Mockito.times(1)).size();
    }

    private Object2ObjectMap insertPrivateMockField_nodeColumns_InImportContainerImpl(ImportContainerImpl receivingObject) throws Exception {
        Object2ObjectMap mockObject2ObjectMap = Mockito.mock(Object2ObjectMap.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("nodeColumns");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockObject2ObjectMap);
        return mockObject2ObjectMap;
    }

    @Test
    @DisplayName("addNodeColumn-1 with parameter oracle, mocking [it.unimi.dsi.fastutil.objects.Object2ObjectMap.size(), java.lang.Class.getSimpleName()]")
    public void test_addNodeColumn_java_lang_String_java_lang_Class_boolean_PO_0c93cdf1b33a47dfa9ddee7748b06876() throws Exception {
        // Arrange
        ImportContainerImpl receivingObject = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportContainerImpl.addNodeColumn_java.lang.String,java.lang.Class,boolean1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportContainerImpl.addNodeColumn_java.lang.String,java.lang.Class,boolean1-params.xml");
        String paramObject1 = (String) paramObjects[0];
        Class paramObject2 = (Class) paramObjects[1];
        boolean paramObject3 = (Boolean) paramObjects[2];
        Object2ObjectMap mockObject2ObjectMap = insertPrivateMockField_nodeColumns_InImportContainerImpl(receivingObject);
        Mockito.when(mockObject2ObjectMap.size()).thenReturn(0);
        // Act
        receivingObject.addNodeColumn(paramObject1, paramObject2, paramObject3);
        // Assert
        Mockito.verify(mockObject2ObjectMap, Mockito.atLeastOnce()).size();
    }

    @Test
    @DisplayName("addNodeColumn-1 with call oracle, mocking [it.unimi.dsi.fastutil.objects.Object2ObjectMap.size(), java.lang.Class.getSimpleName()]")
    public void test_addNodeColumn_java_lang_String_java_lang_Class_boolean_CO_0c93cdf1b33a47dfa9ddee7748b06876() throws Exception {
        // Arrange
        ImportContainerImpl receivingObject = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportContainerImpl.addNodeColumn_java.lang.String,java.lang.Class,boolean1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportContainerImpl.addNodeColumn_java.lang.String,java.lang.Class,boolean1-params.xml");
        String paramObject1 = (String) paramObjects[0];
        Class paramObject2 = (Class) paramObjects[1];
        boolean paramObject3 = (Boolean) paramObjects[2];
        Object2ObjectMap mockObject2ObjectMap = insertPrivateMockField_nodeColumns_InImportContainerImpl(receivingObject);
        Mockito.when(mockObject2ObjectMap.size()).thenReturn(0);
        // Act
        receivingObject.addNodeColumn(paramObject1, paramObject2, paramObject3);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockObject2ObjectMap);
        orderVerifier.verify(mockObject2ObjectMap, Mockito.times(1)).size();
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