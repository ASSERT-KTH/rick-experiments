package com.graphhopper.util;

import com.thoughtworks.xstream.XStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class TestViaInstructionRickGen {
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
    @DisplayName("getTurnDescription-1 with output oracle, mocking [com.graphhopper.util.Translation.tr(java.lang.String,java.lang.Object[])]")
    public void test_getTurnDescription_OO_8bfef00575ed46db9b0556a65c2636e1() throws Exception {
        // Arrange
        ViaInstruction receivingObject = deserializeObjectFromFile("com.graphhopper.util.ViaInstruction.getTurnDescription1-receiving.xml");
        Translation mockTranslation = Mockito.mock(Translation.class);
        Mockito.when(mockTranslation.tr(eq("stopover"),   (Object[]) any())).thenReturn("waypoint 1");
        // Act
        String actual = receivingObject.getTurnDescription(mockTranslation);
        // Assert
//        Assertions.assertEquals("waypoint 1", actual);
    }

    @Test
    @DisplayName("getTurnDescription-1 with parameter oracle, mocking [com.graphhopper.util.Translation.tr(java.lang.String,java.lang.Object[])]")
    public void test_getTurnDescription_PO_8bfef00575ed46db9b0556a65c2636e1() throws Exception {
        // Arrange
        ViaInstruction receivingObject = deserializeObjectFromFile("com.graphhopper.util.ViaInstruction.getTurnDescription1-receiving.xml");
        Translation mockTranslation = Mockito.mock(Translation.class);
        Mockito.when(mockTranslation.tr(eq("stopover"),   (Object[]) any())).thenReturn("waypoint 1");
        // Act
        receivingObject.getTurnDescription(mockTranslation);
        // Assert
//        Mockito.verify(mockTranslation, Mockito.atLeastOnce()).tr(eq("stopover"),   (Object[]) any());
    }

    @Test
    @DisplayName("getTurnDescription-1 with call oracle, mocking [com.graphhopper.util.Translation.tr(java.lang.String,java.lang.Object[])]")
    public void test_getTurnDescription_CO_8bfef00575ed46db9b0556a65c2636e1() throws Exception {
        // Arrange
        ViaInstruction receivingObject = deserializeObjectFromFile("com.graphhopper.util.ViaInstruction.getTurnDescription1-receiving.xml");
        Translation mockTranslation = Mockito.mock(Translation.class);
        Mockito.when(mockTranslation.tr(eq("stopover"),   (Object[]) any())).thenReturn("waypoint 1");
        // Act
        receivingObject.getTurnDescription(mockTranslation);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockTranslation);
//        orderVerifier.verify(mockTranslation, Mockito.times(1)).tr(anyString(), (Object[]) any());
    }
}