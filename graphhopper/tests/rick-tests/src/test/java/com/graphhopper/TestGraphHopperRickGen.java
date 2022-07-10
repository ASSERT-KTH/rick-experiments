package com.graphhopper;
import com.graphhopper.routing.ch.CHPreparationHandler;
import com.graphhopper.routing.lm.LMPreparationHandler;
import com.graphhopper.routing.util.EncodingManager;
import com.graphhopper.storage.GraphHopperStorage;
import com.graphhopper.storage.LockFactory;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestGraphHopperRickGen {
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

    private LinkedHashMap<?,?> insertPrivateMockField_dataAccessConfig_InGraphHopper(GraphHopper receivingObject) throws Exception {
        LinkedHashMap mockHashMap = Mockito.mock(LinkedHashMap.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("dataAccessConfig");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockHashMap);
        return mockHashMap;
    }

    private CHPreparationHandler insertPrivateMockField_chPreparationHandler_InGraphHopper(GraphHopper receivingObject) throws Exception {
        CHPreparationHandler mockCHPreparationHandler = Mockito.mock(CHPreparationHandler.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("chPreparationHandler");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockCHPreparationHandler);
        return mockCHPreparationHandler;
    }

    private LMPreparationHandler insertPrivateMockField_lmPreparationHandler_InGraphHopper(GraphHopper receivingObject) throws Exception {
        LMPreparationHandler mockLMPreparationHandler = Mockito.mock(LMPreparationHandler.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("lmPreparationHandler");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockLMPreparationHandler);
        return mockLMPreparationHandler;
    }

    @Test
    @DisplayName("init-1 with parameter oracle, mocking [java.util.HashMap.put(java.lang.Object,java.lang.Object), com.graphhopper.routing.ch.CHPreparationHandler.init(com.graphhopper.GraphHopperConfig), com.graphhopper.routing.lm.LMPreparationHandler.init(com.graphhopper.GraphHopperConfig)]")
    public void test_init_PO_7cde10aa3acc45a68ed574c9135894eb() throws Exception {
        // Arrange
        com.graphhopper.GraphHopper receivingObject = deserializeObjectFromFile("com.graphhopper.GraphHopper.init1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("com.graphhopper.GraphHopper.init1-params.xml");
        com.graphhopper.GraphHopperConfig paramObject1 = (com.graphhopper.GraphHopperConfig) paramObjects[0];
        LinkedHashMap mockHashMap = insertPrivateMockField_dataAccessConfig_InGraphHopper(receivingObject);
        CHPreparationHandler mockCHPreparationHandler = insertPrivateMockField_chPreparationHandler_InGraphHopper(receivingObject);
        LMPreparationHandler mockLMPreparationHandler = insertPrivateMockField_lmPreparationHandler_InGraphHopper(receivingObject);
        Mockito.lenient().when(mockHashMap.put(any(java.lang.Object.class),   any(java.lang.Object.class))).thenReturn(null);
        // Act
        receivingObject.init(paramObject1);
        // Assert
//        Mockito.verify(mockHashMap, Mockito.atLeastOnce()).put(any(java.lang.Object.class),   any(java.lang.Object.class));
        Mockito.verify(mockCHPreparationHandler, Mockito.atLeastOnce()).init(any(com.graphhopper.GraphHopperConfig.class));
        Mockito.verify(mockLMPreparationHandler, Mockito.atLeastOnce()).init(any(com.graphhopper.GraphHopperConfig.class));
    }

    @Test
    @DisplayName("init-1 with call oracle, mocking [java.util.HashMap.put(java.lang.Object,java.lang.Object), com.graphhopper.routing.ch.CHPreparationHandler.init(com.graphhopper.GraphHopperConfig), com.graphhopper.routing.lm.LMPreparationHandler.init(com.graphhopper.GraphHopperConfig)]")
    public void test_init_CO_7cde10aa3acc45a68ed574c9135894eb() throws Exception {
        // Arrange
        com.graphhopper.GraphHopper receivingObject = deserializeObjectFromFile("com.graphhopper.GraphHopper.init1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("com.graphhopper.GraphHopper.init1-params.xml");
        com.graphhopper.GraphHopperConfig paramObject1 = (com.graphhopper.GraphHopperConfig) paramObjects[0];
        LinkedHashMap mockHashMap = insertPrivateMockField_dataAccessConfig_InGraphHopper(receivingObject);
        CHPreparationHandler mockCHPreparationHandler = insertPrivateMockField_chPreparationHandler_InGraphHopper(receivingObject);
        LMPreparationHandler mockLMPreparationHandler = insertPrivateMockField_lmPreparationHandler_InGraphHopper(receivingObject);
        Mockito.lenient().when(mockHashMap.put(any(java.lang.Object.class),   any(java.lang.Object.class))).thenReturn(null);
        // Act
        receivingObject.init(paramObject1);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockHashMap, mockCHPreparationHandler, mockLMPreparationHandler);
//        orderVerifier.verify(mockHashMap, Mockito.times(10)).put((java.lang.Object) any(), (java.lang.Object) any());
        orderVerifier.verify(mockCHPreparationHandler, Mockito.times(1)).init((com.graphhopper.GraphHopperConfig) any());
        orderVerifier.verify(mockLMPreparationHandler, Mockito.times(1)).init((com.graphhopper.GraphHopperConfig) any());
    }

    private EncodingManager insertPrivateMockField_encodingManager_InGraphHopper(GraphHopper receivingObject) throws Exception {
        EncodingManager mockEncodingManager = Mockito.mock(EncodingManager.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("encodingManager");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockEncodingManager);
        return mockEncodingManager;
    }

    private LockFactory insertPrivateMockField_lockFactory_InGraphHopper(GraphHopper receivingObject) throws Exception {
        LockFactory mockLockFactory = Mockito.mock(LockFactory.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("lockFactory");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockLockFactory);
        return mockLockFactory;
    }

    private GraphHopperStorage insertPrivateMockField_ghStorage_InGraphHopper(GraphHopper receivingObject) throws Exception {
        GraphHopperStorage mockGraphHopperStorage = Mockito.mock(GraphHopperStorage.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("ghStorage");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockGraphHopperStorage);
        return mockGraphHopperStorage;
    }

    @Test
    @DisplayName("load-1 with output oracle, mocking [com.graphhopper.routing.util.EncodingManager.needsTurnCostsSupport(), com.graphhopper.storage.LockFactory.setLockDir(java.io.File), com.graphhopper.storage.GraphHopperStorage.loadExisting()]")
    public void test_load_OO_9721fc563daa464385c1c43f8c92bc83() throws Exception {
        // Arrange
        com.graphhopper.GraphHopper receivingObject = deserializeObjectFromFile("com.graphhopper.GraphHopper.load1-receiving.xml");
        EncodingManager mockEncodingManager = insertPrivateMockField_encodingManager_InGraphHopper(receivingObject);
        LockFactory mockLockFactory = insertPrivateMockField_lockFactory_InGraphHopper(receivingObject);
        GraphHopperStorage mockGraphHopperStorage = insertPrivateMockField_ghStorage_InGraphHopper(receivingObject);
        Mockito.when(mockEncodingManager.needsTurnCostsSupport()).thenReturn(false);
        Mockito.when(mockGraphHopperStorage.loadExisting()).thenReturn(true);
        // Act
        boolean actual = receivingObject.load();
        // Assert
        Assertions.assertEquals(true, actual);
    }

    @Test
    @DisplayName("load-1 with parameter oracle, mocking [com.graphhopper.routing.util.EncodingManager.needsTurnCostsSupport(), com.graphhopper.storage.LockFactory.setLockDir(java.io.File), com.graphhopper.storage.GraphHopperStorage.loadExisting()]")
    public void test_load_PO_9721fc563daa464385c1c43f8c92bc83() throws Exception {
        // Arrange
        com.graphhopper.GraphHopper receivingObject = deserializeObjectFromFile("com.graphhopper.GraphHopper.load1-receiving.xml");
        EncodingManager mockEncodingManager = insertPrivateMockField_encodingManager_InGraphHopper(receivingObject);
        LockFactory mockLockFactory = insertPrivateMockField_lockFactory_InGraphHopper(receivingObject);
        GraphHopperStorage mockGraphHopperStorage = insertPrivateMockField_ghStorage_InGraphHopper(receivingObject);
        Mockito.when(mockEncodingManager.needsTurnCostsSupport()).thenReturn(false);
        Mockito.when(mockGraphHopperStorage.loadExisting()).thenReturn(true);
        // Act
        receivingObject.load();
        // Assert
        Mockito.verify(mockEncodingManager, Mockito.atLeastOnce()).needsTurnCostsSupport();
        Mockito.verify(mockLockFactory, Mockito.atLeastOnce()).setLockDir(any(java.io.File.class));
        Mockito.verify(mockGraphHopperStorage, Mockito.atLeastOnce()).loadExisting();
    }

    @Test
    @DisplayName("load-1 with call oracle, mocking [com.graphhopper.routing.util.EncodingManager.needsTurnCostsSupport(), com.graphhopper.storage.LockFactory.setLockDir(java.io.File), com.graphhopper.storage.GraphHopperStorage.loadExisting()]")
    public void test_load_CO_9721fc563daa464385c1c43f8c92bc83() throws Exception {
        // Arrange
        com.graphhopper.GraphHopper receivingObject = deserializeObjectFromFile("com.graphhopper.GraphHopper.load1-receiving.xml");
        EncodingManager mockEncodingManager = insertPrivateMockField_encodingManager_InGraphHopper(receivingObject);
        LockFactory mockLockFactory = insertPrivateMockField_lockFactory_InGraphHopper(receivingObject);
        GraphHopperStorage mockGraphHopperStorage = insertPrivateMockField_ghStorage_InGraphHopper(receivingObject);
        Mockito.when(mockEncodingManager.needsTurnCostsSupport()).thenReturn(false);
        Mockito.when(mockGraphHopperStorage.loadExisting()).thenReturn(true);
        // Act
        receivingObject.load();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockEncodingManager, mockLockFactory, mockGraphHopperStorage);
        orderVerifier.verify(mockEncodingManager, Mockito.times(2)).needsTurnCostsSupport();
        orderVerifier.verify(mockLockFactory, Mockito.times(1)).setLockDir((java.io.File) any());
        orderVerifier.verify(mockGraphHopperStorage, Mockito.times(1)).loadExisting();
    }
}