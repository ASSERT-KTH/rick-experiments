package org.gephi.preview;
import com.thoughtworks.xstream.XStream;

import java.awt.*;
import java.io.File;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class TestSVGRenderTargetImplRickGen {
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
    @DisplayName("toHexString-1 with output oracle, mocking [java.awt.Color.getRGB()]")
    public void test_toHexString_OO_b39626b373c6430bb9b3657fa24481f2() throws Exception {
        // Arrange
        SVGRenderTargetBuilder.SVGRenderTargetImpl receivingObject = deserializeObjectFromFile("org.gephi.preview.SVGRenderTargetBuilder$SVGRenderTargetImpl.toHexString1-receiving.xml");
        Color mockColor = Mockito.mock(Color.class);
        Mockito.when(mockColor.getRGB()).thenReturn(-15703218);
        // Act
        String actual = receivingObject.toHexString(mockColor);
        // Assert
        Assertions.assertEquals("#10634e", actual);
    }

    @Test
    @DisplayName("toHexString-1 with parameter oracle, mocking [java.awt.Color.getRGB()]")
    public void test_toHexString_PO_b39626b373c6430bb9b3657fa24481f2() throws Exception {
        // Arrange
        SVGRenderTargetBuilder.SVGRenderTargetImpl receivingObject = deserializeObjectFromFile("org.gephi.preview.SVGRenderTargetBuilder$SVGRenderTargetImpl.toHexString1-receiving.xml");
        Color mockColor = Mockito.mock(Color.class);
        Mockito.when(mockColor.getRGB()).thenReturn(-15703218);
        // Act
        receivingObject.toHexString(mockColor);
        // Assert
        Mockito.verify(mockColor, Mockito.atLeastOnce()).getRGB();
    }

    @Test
    @Disabled
    @DisplayName("toHexString-1 with call oracle, mocking [java.awt.Color.getRGB()]")
    public void test_toHexString_CO_b39626b373c6430bb9b3657fa24481f2() throws Exception {
        // Arrange
        SVGRenderTargetBuilder.SVGRenderTargetImpl receivingObject = deserializeObjectFromFile("org.gephi.preview.SVGRenderTargetBuilder$SVGRenderTargetImpl.toHexString1-receiving.xml");
        Color mockColor = Mockito.mock(Color.class);
        Mockito.when(mockColor.getRGB()).thenReturn(-15703218);
        // Act
        receivingObject.toHexString(mockColor);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockColor);
        orderVerifier.verify(mockColor, Mockito.times(5)).getRGB();
    }
}