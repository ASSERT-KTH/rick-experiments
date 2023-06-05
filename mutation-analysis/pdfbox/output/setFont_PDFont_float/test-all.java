package org.apache.pdfbox.pdmodel;

import com.thoughtworks.xstream.XStream;
import converters.FileCleanableConverter;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.util.Scanner;

@ExtendWith(MockitoExtension.class)
public class TestPDPageContentStreamRickGen {
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
    @DisplayName("setFont-1 with parameter oracle, mocking [java.util.Vector.isEmpty(), java.util.Vector.add(java.lang.Object), java.util.Vector.setElementAt(java.lang.Object,int), java.util.Vector.size(), org.apache.pdfbox.pdmodel.font.PDFont.willBeSubset()]")
    public void test_setFont_PO_aa069937c06c4fe5b22a8696fb90aab8() throws Exception {
        // Arrange
        PDPageContentStream receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.PDPageContentStream.setFont1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.PDPageContentStream.setFont1-params.xml");
        float paramObject2 = (Float) paramObjects[1];
        PDFont mockPDFont = Mockito.mock(PDFont.class);
        Mockito.when(mockPDFont.willBeSubset()).thenReturn(false);
        // Act
        receivingObject.setFont(mockPDFont, paramObject2);
        // Assert
        Mockito.verify(mockPDFont, Mockito.atLeastOnce()).willBeSubset();
    }

    @Test
    @DisplayName("setFont-1 with call oracle, mocking [java.util.Vector.isEmpty(), java.util.Vector.add(java.lang.Object), java.util.Vector.setElementAt(java.lang.Object,int), java.util.Vector.size(), org.apache.pdfbox.pdmodel.font.PDFont.willBeSubset()]")
    public void test_setFont_CO_aa069937c06c4fe5b22a8696fb90aab8() throws Exception {
        // Arrange
        PDPageContentStream receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.PDPageContentStream.setFont1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.PDPageContentStream.setFont1-params.xml");
        float paramObject2 = (Float) paramObjects[1];
        PDFont mockPDFont = Mockito.mock(PDFont.class);
        Mockito.when(mockPDFont.willBeSubset()).thenReturn(false);
        // Act
        receivingObject.setFont(mockPDFont, paramObject2);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockPDFont);
        orderVerifier.verify(mockPDFont, Mockito.times(1)).willBeSubset();
    }
}