package org.apache.pdfbox.multipdf;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.util.Scanner;

import converters.FileCleanableConverter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyFloat;

@ExtendWith(MockitoExtension.class)
public class TestPDFMergerUtilityRickGen {
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
    @DisplayName("appendDocument-1 with parameter oracle, mocking [org.apache.pdfbox.pdmodel.PDDocument.getVersion(), org.apache.pdfbox.pdmodel.PDDocument.setVersion(float)]")
    public void test_appendDocument_PO_416b19ad41de47b89575ad63ea2351da() throws Exception {
        // Arrange
        org.apache.pdfbox.multipdf.PDFMergerUtility receivingObject = deserializeObjectFromFile("org.apache.pdfbox.multipdf.PDFMergerUtility.appendDocument1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.multipdf.PDFMergerUtility.appendDocument1-params.xml");
        org.apache.pdfbox.pdmodel.PDDocument paramObject2 = (org.apache.pdfbox.pdmodel.PDDocument) paramObjects[1];
        PDDocument mockPDDocument = Mockito.mock(PDDocument.class);
        Mockito.when(mockPDDocument.getVersion()).thenReturn(1.4F);
        // Act
        receivingObject.appendDocument(mockPDDocument, paramObject2);
        // Assert
        Mockito.verify(mockPDDocument, Mockito.atLeastOnce()).getVersion();
    }

    @Test
    @DisplayName("appendDocument-1 with call oracle, mocking [org.apache.pdfbox.pdmodel.PDDocument.getVersion(), org.apache.pdfbox.pdmodel.PDDocument.setVersion(float)]")
    public void test_appendDocument_CO_416b19ad41de47b89575ad63ea2351da() throws Exception {
        // Arrange
        org.apache.pdfbox.multipdf.PDFMergerUtility receivingObject = deserializeObjectFromFile("org.apache.pdfbox.multipdf.PDFMergerUtility.appendDocument1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.multipdf.PDFMergerUtility.appendDocument1-params.xml");
        org.apache.pdfbox.pdmodel.PDDocument paramObject2 = (org.apache.pdfbox.pdmodel.PDDocument) paramObjects[1];
        PDDocument mockPDDocument = Mockito.mock(PDDocument.class);
        Mockito.when(mockPDDocument.getVersion()).thenReturn(1.4F);
        // Act
        receivingObject.appendDocument(mockPDDocument, paramObject2);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockPDDocument);
        orderVerifier.verify(mockPDDocument, Mockito.times(2)).getVersion();
    }
}