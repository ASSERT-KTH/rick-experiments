package org.gephi.preview.types;
import com.thoughtworks.xstream.XStream;

import java.awt.*;
import java.io.File;
import java.util.Scanner;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class TestEdgeColorRickGen {
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
    @DisplayName("getColor-1 with parameter oracle, mocking [java.awt.Color.getRed(), java.awt.Color.getGreen(), java.awt.Color.getBlue(), java.awt.Color.getAlpha()]")
    public void test_getColor_PO_0fdd2586263f4a01939a6792f6c26498() throws Exception {
        // Arrange
        EdgeColor receivingObject = deserializeObjectFromFile("org.gephi.preview.types.EdgeColor.getColor1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.preview.types.EdgeColor.getColor1-params.xml");
        java.awt.Color paramObject1 = (java.awt.Color) paramObjects[0];
        java.awt.Color paramObject3 = (java.awt.Color) paramObjects[2];
        Color mockColor = Mockito.mock(Color.class);
        Mockito.when(mockColor.getRed()).thenReturn(0);
        Mockito.when(mockColor.getGreen()).thenReturn(0);
        Mockito.when(mockColor.getBlue()).thenReturn(0);
        Mockito.when(mockColor.getAlpha()).thenReturn(255);
        // Act
        receivingObject.getColor(paramObject1, mockColor, paramObject3);
        // Assert
        Mockito.verify(mockColor, Mockito.atLeastOnce()).getRed();
        Mockito.verify(mockColor, Mockito.atLeastOnce()).getGreen();
        Mockito.verify(mockColor, Mockito.atLeastOnce()).getBlue();
        Mockito.verify(mockColor, Mockito.atLeastOnce()).getAlpha();
    }

    @Test
    @Disabled
    @DisplayName("getColor-1 with call oracle, mocking [java.awt.Color.getRed(), java.awt.Color.getGreen(), java.awt.Color.getBlue(), java.awt.Color.getAlpha()]")
    public void test_getColor_CO_0fdd2586263f4a01939a6792f6c26498() throws Exception {
        // Arrange
        EdgeColor receivingObject = deserializeObjectFromFile("org.gephi.preview.types.EdgeColor.getColor1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.preview.types.EdgeColor.getColor1-params.xml");
        java.awt.Color paramObject1 = (java.awt.Color) paramObjects[0];
        java.awt.Color paramObject3 = (java.awt.Color) paramObjects[2];
        Color mockColor = Mockito.mock(Color.class);
        Mockito.when(mockColor.getRed()).thenReturn(0);
        Mockito.when(mockColor.getGreen()).thenReturn(0);
        Mockito.when(mockColor.getBlue()).thenReturn(0);
        Mockito.when(mockColor.getAlpha()).thenReturn(255);
        // Act
        receivingObject.getColor(paramObject1, mockColor, paramObject3);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockColor, mockColor, mockColor, mockColor);
        orderVerifier.verify(mockColor, Mockito.times(1)).getRed();
        orderVerifier.verify(mockColor, Mockito.times(1)).getGreen();
        orderVerifier.verify(mockColor, Mockito.times(1)).getBlue();
        orderVerifier.verify(mockColor, Mockito.times(1)).getAlpha();
        orderVerifier.verify(mockColor, Mockito.times(1)).getRed();
        orderVerifier.verify(mockColor, Mockito.times(1)).getGreen();
        orderVerifier.verify(mockColor, Mockito.times(1)).getBlue();
        orderVerifier.verify(mockColor, Mockito.times(1)).getAlpha();
        orderVerifier.verify(mockColor, Mockito.times(1)).getRed();
        orderVerifier.verify(mockColor, Mockito.times(1)).getGreen();
        orderVerifier.verify(mockColor, Mockito.times(1)).getBlue();
        orderVerifier.verify(mockColor, Mockito.times(1)).getAlpha();
        orderVerifier.verify(mockColor, Mockito.times(2)).getRed();
        orderVerifier.verify(mockColor, Mockito.times(2)).getGreen();
        orderVerifier.verify(mockColor, Mockito.times(2)).getBlue();
        orderVerifier.verify(mockColor, Mockito.times(2)).getAlpha();
        orderVerifier.verify(mockColor, Mockito.times(1)).getRed();
        orderVerifier.verify(mockColor, Mockito.times(1)).getGreen();
        orderVerifier.verify(mockColor, Mockito.times(1)).getBlue();
        orderVerifier.verify(mockColor, Mockito.times(1)).getAlpha();
    }
}