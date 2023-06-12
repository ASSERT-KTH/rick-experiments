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
public class TestRandomAccessInputStreamRickGenRead {
    static XStream xStream = new XStream();

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
    @DisplayName("read-1 with output oracle, mocking [org.apache.pdfbox.io.RandomAccessRead.isEOF(), org.apache.pdfbox.io.RandomAccessRead.read(byte[],int,int), org.apache.pdfbox.io.RandomAccessRead.getPosition()]")
    public void test_read_byte_arr_int_int_OO_f6c4b371c0de4771b3231ecfdf01afd9() throws Exception {
        // Arrange
        RandomAccessInputStream receivingObject = deserializeObjectFromFile("org.apache.pdfbox.io.RandomAccessInputStream.read_byte_arr_,int,int1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.io.RandomAccessInputStream.read_byte_arr_,int,int1-params.xml");
        byte[] paramObject1 = (byte[]) paramObjects[0];
        int paramObject2 = (Integer) paramObjects[1];
        int paramObject3 = (Integer) paramObjects[2];
        RandomAccessRead mockRandomAccessRead = insertPrivateMockField_input_InRandomAccessInputStream(receivingObject);
        Mockito.lenient().when(mockRandomAccessRead.isEOF()).thenReturn(false);
        Mockito.lenient().when(mockRandomAccessRead.read((byte[]) any(),   eq(0),   eq(4096))).thenReturn(1070);
        // Act
        int actual = receivingObject.read(paramObject1, paramObject2, paramObject3);
        // Assert
//         Assertions.assertEquals(1070, actual);
    }

    @Test
    @DisplayName("read-1 with parameter oracle, mocking [org.apache.pdfbox.io.RandomAccessRead.isEOF(), org.apache.pdfbox.io.RandomAccessRead.read(byte[],int,int), org.apache.pdfbox.io.RandomAccessRead.getPosition()]")
    public void test_read_byte_arr_int_int_PO_f6c4b371c0de4771b3231ecfdf01afd9() throws Exception {
        // Arrange
        RandomAccessInputStream receivingObject = deserializeObjectFromFile("org.apache.pdfbox.io.RandomAccessInputStream.read_byte_arr_,int,int1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.io.RandomAccessInputStream.read_byte_arr_,int,int1-params.xml");
        byte[] paramObject1 = (byte[]) paramObjects[0];
        int paramObject2 = (Integer) paramObjects[1];
        int paramObject3 = (Integer) paramObjects[2];
        RandomAccessRead mockRandomAccessRead = insertPrivateMockField_input_InRandomAccessInputStream(receivingObject);
        Mockito.lenient().when(mockRandomAccessRead.isEOF()).thenReturn(false);
        Mockito.lenient().when(mockRandomAccessRead.read((byte[]) any(),   eq(0),   eq(4096))).thenReturn(1070);
        // Act
        receivingObject.read(paramObject1, paramObject2, paramObject3);
        // Assert
        Mockito.verify(mockRandomAccessRead, Mockito.atLeastOnce()).isEOF();
        Mockito.verify(mockRandomAccessRead, Mockito.atLeastOnce()).read((byte[]) any(),   eq(0),   eq(4096));
    }

    @Test
    @DisplayName("read-1 with call oracle, mocking [org.apache.pdfbox.io.RandomAccessRead.isEOF(), org.apache.pdfbox.io.RandomAccessRead.read(byte[],int,int), org.apache.pdfbox.io.RandomAccessRead.getPosition()]")
    public void test_read_byte_arr_int_int_CO_f6c4b371c0de4771b3231ecfdf01afd9() throws Exception {
        // Arrange
        RandomAccessInputStream receivingObject = deserializeObjectFromFile("org.apache.pdfbox.io.RandomAccessInputStream.read_byte_arr_,int,int1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.io.RandomAccessInputStream.read_byte_arr_,int,int1-params.xml");
        byte[] paramObject1 = (byte[]) paramObjects[0];
        int paramObject2 = (Integer) paramObjects[1];
        int paramObject3 = (Integer) paramObjects[2];
        RandomAccessRead mockRandomAccessRead = insertPrivateMockField_input_InRandomAccessInputStream(receivingObject);
        Mockito.lenient().when(mockRandomAccessRead.isEOF()).thenReturn(false);
        Mockito.lenient().when(mockRandomAccessRead.read((byte[]) any(),   eq(0),   eq(4096))).thenReturn(1070);
        // Act
        receivingObject.read(paramObject1, paramObject2, paramObject3);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockRandomAccessRead, mockRandomAccessRead);
//         orderVerifier.verify(mockRandomAccessRead, Mockito.times(1)).isEOF();
//         orderVerifier.verify(mockRandomAccessRead, Mockito.times(1)).read((byte[]) any(), anyInt(), anyInt());
    }
}