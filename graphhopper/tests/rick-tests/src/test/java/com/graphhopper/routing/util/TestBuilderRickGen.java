package com.graphhopper.routing.util;
import com.graphhopper.routing.ev.EncodedValue;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Scanner;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class TestBuilderRickGen {
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
    @DisplayName("add-1 with parameter oracle, mocking [com.graphhopper.routing.ev.EncodedValue.getName()]")
    public void test_add_com_graphhopper_routing_ev_EncodedValue_PO_806a5d770a2047db86be84da16bb35b1() throws Exception {
        // Arrange
        com.graphhopper.routing.util.EncodingManager.Builder receivingObject = deserializeObjectFromFile("com.graphhopper.routing.util.EncodingManager$Builder.add_com.graphhopper.routing.ev.EncodedValue1-receiving.xml");
        EncodedValue mockEncodedValue = Mockito.mock(EncodedValue.class);
        Mockito.when(mockEncodedValue.getName()).thenReturn("car_subnetwork");
        // Act
        receivingObject.add(mockEncodedValue);
        // Assert
        Mockito.verify(mockEncodedValue, Mockito.atLeastOnce()).getName();
    }

    @Test
    @DisplayName("add-1 with call oracle, mocking [com.graphhopper.routing.ev.EncodedValue.getName()]")
    public void test_add_com_graphhopper_routing_ev_EncodedValue_CO_806a5d770a2047db86be84da16bb35b1() throws Exception {
        // Arrange
        com.graphhopper.routing.util.EncodingManager.Builder receivingObject = deserializeObjectFromFile("com.graphhopper.routing.util.EncodingManager$Builder.add_com.graphhopper.routing.ev.EncodedValue1-receiving.xml");
        EncodedValue mockEncodedValue = Mockito.mock(EncodedValue.class);
        Mockito.when(mockEncodedValue.getName()).thenReturn("car_subnetwork");
        // Act
        receivingObject.add(mockEncodedValue);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockEncodedValue);
        orderVerifier.verify(mockEncodedValue, Mockito.times(2)).getName();
    }
}