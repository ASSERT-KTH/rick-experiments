package org.apache.pdfbox.pdfwriter;

import com.thoughtworks.xstream.XStream;
import converters.FileCleanableConverter;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestCOSWriterRickGen {
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
    @DisplayName("visitFromName-1 with parameter oracle, mocking [org.apache.pdfbox.cos.COSName.writePDF(java.io.OutputStream)]")
    public void test_visitFromName_PO_b6a6cdb1d2a540f6ab146b740ed191a3() throws Exception {
        // Arrange
        COSWriter receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdfwriter.COSWriter.visitFromName1-receiving.xml");
        COSName mockCOSName = Mockito.mock(COSName.class);
        // Act
        receivingObject.visitFromName(mockCOSName);
        // Assert
        Mockito.verify(mockCOSName, Mockito.atLeastOnce()).writePDF(any(OutputStream.class));
    }

    @Test
    @DisplayName("visitFromName-1 with call oracle, mocking [org.apache.pdfbox.cos.COSName.writePDF(java.io.OutputStream)]")
    public void test_visitFromName_CO_b6a6cdb1d2a540f6ab146b740ed191a3() throws Exception {
        // Arrange
        COSWriter receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdfwriter.COSWriter.visitFromName1-receiving.xml");
        COSName mockCOSName = Mockito.mock(COSName.class);
        // Act
        receivingObject.visitFromName(mockCOSName);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockCOSName);
        orderVerifier.verify(mockCOSName, Mockito.times(1)).writePDF((OutputStream) any());
    }

    private OutputStream insertPrivateMockField_incrementalOutput_InCOSWriter(COSWriter receivingObject) throws Exception {
        OutputStream mockOutputStream = Mockito.mock(OutputStream.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("incrementalOutput");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockOutputStream);
        return mockOutputStream;
    }

    @Test
    @DisplayName("close-4 with parameter oracle, mocking [java.io.OutputStream.close()]")
    public void test_close_PO_e315d9d52149466290d7ba5b2fdb6a93() throws Exception {
        // Arrange
        org.apache.pdfbox.pdfwriter.COSWriter receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdfwriter.COSWriter.close4-receiving.xml");
        OutputStream mockOutputStream = insertPrivateMockField_incrementalOutput_InCOSWriter(receivingObject);
        // Act
        receivingObject.close();
        // Assert
        Mockito.verify(mockOutputStream, Mockito.atLeastOnce()).close();
    }

    @Test
    @DisplayName("close-4 with call oracle, mocking [java.io.OutputStream.close()]")
    public void test_close_CO_e315d9d52149466290d7ba5b2fdb6a93() throws Exception {
        // Arrange
        org.apache.pdfbox.pdfwriter.COSWriter receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdfwriter.COSWriter.close4-receiving.xml");
        OutputStream mockOutputStream = insertPrivateMockField_incrementalOutput_InCOSWriter(receivingObject);
        // Act
        receivingObject.close();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockOutputStream);
        orderVerifier.verify(mockOutputStream, Mockito.times(10)).close();
    }
}