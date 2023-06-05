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
public class TestRandomAccessInputStreamRickGenAvailable {
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
    @DisplayName("available-1 with output oracle, mocking [org.apache.pdfbox.io.RandomAccessRead.length(), org.apache.pdfbox.io.RandomAccessRead.getPosition()]")
    public void test_available_OO_fb6f2cb527054a08a4f54d3c52922d8e() throws Exception {
        // Arrange
        RandomAccessInputStream receivingObject = deserializeObjectFromFile("org.apache.pdfbox.io.RandomAccessInputStream.available1-receiving.xml");
        RandomAccessRead mockRandomAccessRead = insertPrivateMockField_input_InRandomAccessInputStream(receivingObject);
        Mockito.when(mockRandomAccessRead.length()).thenReturn(2296L);
        Mockito.when(mockRandomAccessRead.getPosition()).thenReturn(2050L);
        // Act
        int actual = receivingObject.available();
        // Assert
        Assertions.assertEquals(246, actual);
    }

    @Test
    @DisplayName("available-1 with parameter oracle, mocking [org.apache.pdfbox.io.RandomAccessRead.length(), org.apache.pdfbox.io.RandomAccessRead.getPosition()]")
    public void test_available_PO_fb6f2cb527054a08a4f54d3c52922d8e() throws Exception {
        // Arrange
        RandomAccessInputStream receivingObject = deserializeObjectFromFile("org.apache.pdfbox.io.RandomAccessInputStream.available1-receiving.xml");
        RandomAccessRead mockRandomAccessRead = insertPrivateMockField_input_InRandomAccessInputStream(receivingObject);
        Mockito.when(mockRandomAccessRead.length()).thenReturn(2296L);
        Mockito.when(mockRandomAccessRead.getPosition()).thenReturn(2050L);
        // Act
        receivingObject.available();
        // Assert
//         Mockito.verify(mockRandomAccessRead, Mockito.atLeastOnce()).length();
//         Mockito.verify(mockRandomAccessRead, Mockito.atLeastOnce()).getPosition();
    }

    @Test
    @DisplayName("available-1 with call oracle, mocking [org.apache.pdfbox.io.RandomAccessRead.length(), org.apache.pdfbox.io.RandomAccessRead.getPosition()]")
    public void test_available_CO_fb6f2cb527054a08a4f54d3c52922d8e() throws Exception {
        // Arrange
        RandomAccessInputStream receivingObject = deserializeObjectFromFile("org.apache.pdfbox.io.RandomAccessInputStream.available1-receiving.xml");
        RandomAccessRead mockRandomAccessRead = insertPrivateMockField_input_InRandomAccessInputStream(receivingObject);
        Mockito.when(mockRandomAccessRead.length()).thenReturn(2296L);
        Mockito.when(mockRandomAccessRead.getPosition()).thenReturn(2050L);
        // Act
        receivingObject.available();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockRandomAccessRead, mockRandomAccessRead);
//         orderVerifier.verify(mockRandomAccessRead, Mockito.times(1)).length();
//         orderVerifier.verify(mockRandomAccessRead, Mockito.times(1)).getPosition();
    }
}