package com.graphhopper.http;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.util.Scanner;

import io.dropwizard.setup.Bootstrap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestGraphHopperBundleRickGen {
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

    @Test
    @DisplayName("initialize-1 with parameter oracle, mocking [io.dropwizard.setup.Bootstrap.setObjectMapper(com.fasterxml.jackson.databind.ObjectMapper)]")
    public void test_initialize_PO_c48c9c45498d4d70ba51aea95d74a3e6() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<com.graphhopper.http.GraphHopperBundle/>";
        com.graphhopper.http.GraphHopperBundle receivingObject = deserializeObjectFromString(receivingObjectStr);
        Bootstrap mockBootstrap = Mockito.mock(Bootstrap.class);
        // Act
        receivingObject.initialize(mockBootstrap);
        // Assert
        Mockito.verify(mockBootstrap, Mockito.atLeastOnce()).setObjectMapper(any(com.fasterxml.jackson.databind.ObjectMapper.class));
    }

    @Test
    @DisplayName("initialize-1 with call oracle, mocking [io.dropwizard.setup.Bootstrap.setObjectMapper(com.fasterxml.jackson.databind.ObjectMapper)]")
    public void test_initialize_CO_c48c9c45498d4d70ba51aea95d74a3e6() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<com.graphhopper.http.GraphHopperBundle/>";
        com.graphhopper.http.GraphHopperBundle receivingObject = deserializeObjectFromString(receivingObjectStr);
        Bootstrap mockBootstrap = Mockito.mock(Bootstrap.class);
        // Act
        receivingObject.initialize(mockBootstrap);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockBootstrap);
        orderVerifier.verify(mockBootstrap, Mockito.times(1)).setObjectMapper((com.fasterxml.jackson.databind.ObjectMapper) any());
    }
}