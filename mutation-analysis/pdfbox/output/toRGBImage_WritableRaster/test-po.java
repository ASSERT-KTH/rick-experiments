package org.apache.pdfbox.pdmodel.graphics.color;

import com.thoughtworks.xstream.XStream;
import converters.FileCleanableConverter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.image.WritableRaster;
import java.io.File;
import java.util.Scanner;

@ExtendWith(MockitoExtension.class)
public class TestPDIndexedRickGen {
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
    public void test_toRGBImage_PO_0b9f7da78f0f40dda41ec490c4ea3164() throws Exception {
        // Arrange
        PDIndexed receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.graphics.color.PDIndexed.toRGBImage1-receiving.xml");
        WritableRaster mockRaster = Mockito.mock(WritableRaster.class);
        Mockito.lenient().when(mockRaster.getWidth()).thenReturn(8);
        Mockito.lenient().when(mockRaster.getHeight()).thenReturn(128);
        // Act
        receivingObject.toRGBImage(mockRaster);
        // Assert
        Mockito.verify(mockRaster, Mockito.atLeastOnce()).getWidth();
        Mockito.verify(mockRaster, Mockito.atLeastOnce()).getHeight();
    }

    @Test
    @DisplayName("toRGBImage-1 with call oracle, mocking [java.awt.image.Raster.getWidth(), java.awt.image.Raster.getHeight()]")
    public void test_toRGBImage_CO_0b9f7da78f0f40dda41ec490c4ea3164() throws Exception {
        // Arrange
        PDIndexed receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.graphics.color.PDIndexed.toRGBImage1-receiving.xml");
        WritableRaster mockRaster = Mockito.mock(WritableRaster.class);
        Mockito.lenient().when(mockRaster.getWidth()).thenReturn(8);
        Mockito.lenient().when(mockRaster.getHeight()).thenReturn(128);
        // Act
        receivingObject.toRGBImage(mockRaster);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockRaster, mockRaster);
//         orderVerifier.verify(mockRaster, Mockito.times(1)).getWidth();
//         orderVerifier.verify(mockRaster, Mockito.times(1)).getHeight();
    }
}