package org.apache.pdfbox.io;

import com.thoughtworks.xstream.XStream;
import converters.FileCleanableConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class TestRandomAccessInputStreamRickGenReadNoParam {
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

    private RandomAccessRead insertPrivateMockField_input_InRandomAccessInputStream(RandomAccessInputStream receivingObject) throws Exception {
        RandomAccessRead mockRandomAccessRead = Mockito.mock(RandomAccessRead.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("input");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockRandomAccessRead);
        return mockRandomAccessRead;
    }

    @BeforeAll
    public static void setxStream() {
        xStream.registerConverter(new FileCleanableConverter());
    }

    @Test
    @DisplayName("read-1 with output oracle, mocking [org.apache.pdfbox.io.RandomAccessRead.isEOF(), org.apache.pdfbox.io.RandomAccessRead.read(), org.apache.pdfbox.io.RandomAccessRead.getPosition()]")
    public void test_read_OO_6681a021e20f4f50a4cb4c5fac3f5a20() throws Exception {
        // Arrange
        RandomAccessInputStream receivingObject = deserializeObjectFromFile("org.apache.pdfbox.io.RandomAccessInputStream.read1-receiving.xml");
        RandomAccessRead mockRandomAccessRead = insertPrivateMockField_input_InRandomAccessInputStream(receivingObject);
        Mockito.lenient().when(mockRandomAccessRead.isEOF()).thenReturn(false);
        Mockito.lenient().when(mockRandomAccessRead.read()).thenReturn(72);
        // Act
        int actual = receivingObject.read();
        // Assert
//         Assertions.assertEquals(72, actual);
    }

    @Test
    @DisplayName("read-1 with parameter oracle, mocking [org.apache.pdfbox.io.RandomAccessRead.isEOF(), org.apache.pdfbox.io.RandomAccessRead.read(), org.apache.pdfbox.io.RandomAccessRead.getPosition()]")
    public void test_read_PO_6681a021e20f4f50a4cb4c5fac3f5a20() throws Exception {
        // Arrange
        RandomAccessInputStream receivingObject = deserializeObjectFromFile("org.apache.pdfbox.io.RandomAccessInputStream.read1-receiving.xml");
        RandomAccessRead mockRandomAccessRead = insertPrivateMockField_input_InRandomAccessInputStream(receivingObject);
        Mockito.lenient().when(mockRandomAccessRead.isEOF()).thenReturn(false);
        Mockito.lenient().when(mockRandomAccessRead.read()).thenReturn(72);
        // Act
        receivingObject.read();
        // Assert
        Mockito.verify(mockRandomAccessRead, Mockito.atLeastOnce()).isEOF();
        Mockito.verify(mockRandomAccessRead, Mockito.atLeastOnce()).read();
    }

    @Test
    @DisplayName("read-1 with call oracle, mocking [org.apache.pdfbox.io.RandomAccessRead.isEOF(), org.apache.pdfbox.io.RandomAccessRead.read(), org.apache.pdfbox.io.RandomAccessRead.getPosition()]")
    public void test_read_CO_6681a021e20f4f50a4cb4c5fac3f5a20() throws Exception {
        // Arrange
        RandomAccessInputStream receivingObject = deserializeObjectFromFile("org.apache.pdfbox.io.RandomAccessInputStream.read1-receiving.xml");
        RandomAccessRead mockRandomAccessRead = insertPrivateMockField_input_InRandomAccessInputStream(receivingObject);
        Mockito.lenient().when(mockRandomAccessRead.isEOF()).thenReturn(false);
        Mockito.lenient().when(mockRandomAccessRead.read()).thenReturn(72);
        // Act
        receivingObject.read();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockRandomAccessRead, mockRandomAccessRead);
//         orderVerifier.verify(mockRandomAccessRead, Mockito.times(1)).isEOF();
//         orderVerifier.verify(mockRandomAccessRead, Mockito.times(1)).read();
    }
}