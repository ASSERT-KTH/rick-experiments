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
public class TestFinishInstructionRickGen {
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
    public void test_getTurnDescription_OO_f4925d65c622402e98befa313e740ccb() throws Exception {
        // Arrange
        FinishInstruction receivingObject = deserializeObjectFromFile("com.graphhopper.util.FinishInstruction.getTurnDescription1-receiving.xml");
        Translation mockTranslation = Mockito.mock(Translation.class);
        Mockito.when(mockTranslation.tr(eq("finish"),   (Object[]) any())).thenReturn("arrive at destination");
        // Act
        String actual = receivingObject.getTurnDescription(mockTranslation);
        // Assert
//        Assertions.assertEquals("arrive at destination", actual);
    }

    @Test
    @DisplayName("getTurnDescription-1 with parameter oracle, mocking [com.graphhopper.util.Translation.tr(java.lang.String,java.lang.Object[])]")
    public void test_getTurnDescription_PO_f4925d65c622402e98befa313e740ccb() throws Exception {
        // Arrange
        FinishInstruction receivingObject = deserializeObjectFromFile("com.graphhopper.util.FinishInstruction.getTurnDescription1-receiving.xml");
        Translation mockTranslation = Mockito.mock(Translation.class);
        Mockito.when(mockTranslation.tr(eq("finish"),   (Object[]) any())).thenReturn("arrive at destination");
        // Act
        receivingObject.getTurnDescription(mockTranslation);
        // Assert
//        Mockito.verify(mockTranslation, Mockito.atLeastOnce()).tr(eq("finish"),   (Object[]) any());
    }

    @Test
    @DisplayName("getTurnDescription-1 with call oracle, mocking [com.graphhopper.util.Translation.tr(java.lang.String,java.lang.Object[])]")
    public void test_getTurnDescription_CO_f4925d65c622402e98befa313e740ccb() throws Exception {
        // Arrange
        FinishInstruction receivingObject = deserializeObjectFromFile("com.graphhopper.util.FinishInstruction.getTurnDescription1-receiving.xml");
        Translation mockTranslation = Mockito.mock(Translation.class);
        Mockito.when(mockTranslation.tr(eq("finish"),   (Object[]) any())).thenReturn("arrive at destination");
        // Act
        receivingObject.getTurnDescription(mockTranslation);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockTranslation);
//        orderVerifier.verify(mockTranslation, Mockito.times(1)).tr(anyString(), (Object[]) any());
    }
}