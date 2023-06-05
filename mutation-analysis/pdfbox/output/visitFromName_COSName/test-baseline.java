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
public class TestCOSWriterRickGenVisitFromName {
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
//        Mockito.verify(mockCOSName, Mockito.atLeastOnce()).writePDF(any(OutputStream.class));
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
//        orderVerifier.verify(mockCOSName, Mockito.times(1)).writePDF((OutputStream) any());
    }
}