package org.apache.pdfbox.pdmodel.graphics.color;
import com.thoughtworks.xstream.XStream;

import java.awt.image.WritableRaster;
import java.io.File;
import java.util.Scanner;

import converters.FileCleanableConverter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class TestPDDeviceRGBRickGen {
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

    @BeforeAll
    public static void setxStream() {
        xStream.registerConverter(new FileCleanableConverter());
    }


    @Test
    @DisplayName("toRGBImage-1 with parameter oracle, mocking [java.awt.image.Raster.getWidth(), java.awt.image.Raster.getHeight()]")
    public void test_toRGBImage_PO_26d48267338b49859216278eb4271320() throws Exception {
        // Arrange
        org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.toRGBImage1-receiving.xml");
        WritableRaster mockRaster = Mockito.mock(WritableRaster.class);
        Mockito.when(mockRaster.getWidth()).thenReturn(1);
        Mockito.when(mockRaster.getHeight()).thenReturn(1);
        // Act
        receivingObject.toRGBImage(mockRaster);
        // Assert
        Mockito.verify(mockRaster, Mockito.atLeastOnce()).getWidth();
        Mockito.verify(mockRaster, Mockito.atLeastOnce()).getHeight();
    }

    @Test
    @DisplayName("toRGBImage-1 with call oracle, mocking [java.awt.image.Raster.getWidth(), java.awt.image.Raster.getHeight()]")
    public void test_toRGBImage_CO_26d48267338b49859216278eb4271320() throws Exception {
        // Arrange
        org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB.toRGBImage1-receiving.xml");
        WritableRaster mockRaster = Mockito.mock(WritableRaster.class);
        Mockito.when(mockRaster.getWidth()).thenReturn(1);
        Mockito.when(mockRaster.getHeight()).thenReturn(1);
        // Act
        receivingObject.toRGBImage(mockRaster);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockRaster, mockRaster);
        orderVerifier.verify(mockRaster, Mockito.times(1)).getWidth();
        orderVerifier.verify(mockRaster, Mockito.times(1)).getHeight();
        orderVerifier.verify(mockRaster, Mockito.times(1)).getWidth();
        orderVerifier.verify(mockRaster, Mockito.times(1)).getHeight();
    }
}