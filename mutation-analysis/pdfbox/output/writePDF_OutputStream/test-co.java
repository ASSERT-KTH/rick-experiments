package org.apache.pdfbox.cos;

import com.thoughtworks.xstream.XStream;
import converters.FileCleanableConverter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.OutputStream;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class TestCOSNameRickGen {
    static XStream xStream = new XStream();

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
    @DisplayName("writePDF-1 with parameter oracle, mocking [java.io.OutputStream.write(int)]")
    public void test_writePDF_PO_3cb151d368894276bf2d23daaaa4d17b() throws Exception {
        // Arrange
        COSName receivingObject = deserializeObjectFromFile("org.apache.pdfbox.cos.COSName.writePDF1-receiving.xml");
        OutputStream mockOutputStream = Mockito.mock(OutputStream.class);
        // Act
        receivingObject.writePDF(mockOutputStream);
        // Assert
//         Mockito.verify(mockOutputStream, Mockito.atLeastOnce()).write(47);
//         Mockito.verify(mockOutputStream, Mockito.atLeastOnce()).write(84);
//         Mockito.verify(mockOutputStream, Mockito.atLeastOnce()).write(121);
//         Mockito.verify(mockOutputStream, Mockito.atLeastOnce()).write(112);
//         Mockito.verify(mockOutputStream, Mockito.atLeastOnce()).write(101);
    }

    @Test
    @DisplayName("writePDF-1 with call oracle, mocking [java.io.OutputStream.write(int)]")
    public void test_writePDF_CO_3cb151d368894276bf2d23daaaa4d17b() throws Exception {
        // Arrange
        COSName receivingObject = deserializeObjectFromFile("org.apache.pdfbox.cos.COSName.writePDF1-receiving.xml");
        OutputStream mockOutputStream = Mockito.mock(OutputStream.class);
        // Act
        receivingObject.writePDF(mockOutputStream);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockOutputStream, mockOutputStream, mockOutputStream, mockOutputStream, mockOutputStream);
        orderVerifier.verify(mockOutputStream, Mockito.times(5)).write(anyInt());
    }
}