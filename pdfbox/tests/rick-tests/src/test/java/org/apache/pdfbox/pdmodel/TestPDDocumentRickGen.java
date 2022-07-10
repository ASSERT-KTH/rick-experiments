package org.apache.pdfbox.pdmodel;
import com.thoughtworks.xstream.XStream;
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
public class TestPDDocumentRickGen {
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
    @DisplayName("importPage-1 with parameter oracle, mocking [org.apache.pdfbox.pdmodel.PDPage.getRotation()]")
    public void test_importPage_PO_2dfeb5f6f94b45ada65f6a41c12d2664() throws Exception {
        // Arrange
        org.apache.pdfbox.pdmodel.PDDocument receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.PDDocument.importPage1-receiving.xml");
        PDPage mockPDPage = Mockito.mock(PDPage.class);
        Mockito.when(mockPDPage.getRotation()).thenReturn(0);
        // Act
        receivingObject.importPage(mockPDPage);
        // Assert
        Mockito.verify(mockPDPage, Mockito.atLeastOnce()).getRotation();
    }

    @Test
    @DisplayName("importPage-1 with call oracle, mocking [org.apache.pdfbox.pdmodel.PDPage.getRotation()]")
    public void test_importPage_CO_2dfeb5f6f94b45ada65f6a41c12d2664() throws Exception {
        // Arrange
        org.apache.pdfbox.pdmodel.PDDocument receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.PDDocument.importPage1-receiving.xml");
        PDPage mockPDPage = Mockito.mock(PDPage.class);
        Mockito.when(mockPDPage.getRotation()).thenReturn(0);
        // Act
        receivingObject.importPage(mockPDPage);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockPDPage);
        orderVerifier.verify(mockPDPage, Mockito.times(1)).getRotation();
    }
}