package org.apache.pdfbox.tools;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.util.Scanner;

import converters.FileCleanableConverter;
import org.apache.pdfbox.contentstream.PDFGraphicsStreamEngine;
import org.apache.pdfbox.pdmodel.graphics.image.PDImage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class TestImageGraphicsEngineRickGen {
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
    @DisplayName("drawImage-1 with parameter oracle, mocking [org.apache.pdfbox.pdmodel.graphics.image.PDImage.isStencil()]")
    public void test_drawImage_PO_6f68e8e80ae544919ec11fba613c7b77() throws Exception {
        // Arrange
        PDFGraphicsStreamEngine receivingObject = deserializeObjectFromFile("org.apache.pdfbox.tools.ExtractImages$ImageGraphicsEngine.drawImage1-receiving.xml");
        PDImage mockPDImage = Mockito.mock(PDImage.class);
        Mockito.when(mockPDImage.isStencil()).thenReturn(false);
        // Act
        receivingObject.drawImage(mockPDImage);
        // Assert
        Mockito.verify(mockPDImage, Mockito.atLeastOnce()).isStencil();
    }

    @Test
    @DisplayName("drawImage-1 with call oracle, mocking [org.apache.pdfbox.pdmodel.graphics.image.PDImage.isStencil()]")
    public void test_drawImage_CO_6f68e8e80ae544919ec11fba613c7b77() throws Exception {
        // Arrange
        PDFGraphicsStreamEngine receivingObject = deserializeObjectFromFile("org.apache.pdfbox.tools.ExtractImages$ImageGraphicsEngine.drawImage1-receiving.xml");
        PDImage mockPDImage = Mockito.mock(PDImage.class);
        Mockito.when(mockPDImage.isStencil()).thenReturn(false);
        // Act
        receivingObject.drawImage(mockPDImage);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockPDImage);
        orderVerifier.verify(mockPDImage, Mockito.times(1)).isStencil();
    }
}