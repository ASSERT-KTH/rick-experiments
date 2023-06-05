package com.graphhopper;

import com.graphhopper.routing.ch.CHPreparationHandler;
import com.graphhopper.routing.lm.LMPreparationHandler;
import com.graphhopper.routing.util.EncodingManager;
import com.graphhopper.storage.GraphHopperStorage;
import com.graphhopper.storage.LockFactory;
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
import java.util.LinkedHashMap;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestGraphHopperRickGen {
    static XStream xStream = new XStream();

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
        GraphHopper receivingObject = deserializeObjectFromFile("com.graphhopper.GraphHopper.init1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("com.graphhopper.GraphHopper.init1-params.xml");
        GraphHopperConfig paramObject1 = (GraphHopperConfig) paramObjects[0];
        LinkedHashMap mockHashMap = insertPrivateMockField_dataAccessConfig_InGraphHopper(receivingObject);
        CHPreparationHandler mockCHPreparationHandler = insertPrivateMockField_chPreparationHandler_InGraphHopper(receivingObject);
        LMPreparationHandler mockLMPreparationHandler = insertPrivateMockField_lmPreparationHandler_InGraphHopper(receivingObject);
        Mockito.lenient().when(mockHashMap.put(any(Object.class),   any(Object.class))).thenReturn(null);
        // Act
        receivingObject.init(paramObject1);
        // Assert
//         Mockito.verify(mockCHPreparationHandler, Mockito.atLeastOnce()).init(any(GraphHopperConfig.class));
//         Mockito.verify(mockLMPreparationHandler, Mockito.atLeastOnce()).init(any(GraphHopperConfig.class));
    }

    @Test
    @DisplayName("init-1 with call oracle, mocking [java.util.HashMap.put(java.lang.Object,java.lang.Object), com.graphhopper.routing.ch.CHPreparationHandler.init(com.graphhopper.GraphHopperConfig), com.graphhopper.routing.lm.LMPreparationHandler.init(com.graphhopper.GraphHopperConfig)]")
    public void test_init_CO_7cde10aa3acc45a68ed574c9135894eb() throws Exception {
        // Arrange
        GraphHopper receivingObject = deserializeObjectFromFile("com.graphhopper.GraphHopper.init1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("com.graphhopper.GraphHopper.init1-params.xml");
        GraphHopperConfig paramObject1 = (GraphHopperConfig) paramObjects[0];
        LinkedHashMap mockHashMap = insertPrivateMockField_dataAccessConfig_InGraphHopper(receivingObject);
        CHPreparationHandler mockCHPreparationHandler = insertPrivateMockField_chPreparationHandler_InGraphHopper(receivingObject);
        LMPreparationHandler mockLMPreparationHandler = insertPrivateMockField_lmPreparationHandler_InGraphHopper(receivingObject);
        Mockito.lenient().when(mockHashMap.put(any(Object.class),   any(Object.class))).thenReturn(null);
        // Act
        receivingObject.init(paramObject1);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockHashMap, mockCHPreparationHandler, mockLMPreparationHandler);
        orderVerifier.verify(mockCHPreparationHandler, Mockito.times(1)).init((GraphHopperConfig) any());
        orderVerifier.verify(mockLMPreparationHandler, Mockito.times(1)).init((GraphHopperConfig) any());
    }
}