package org.apache.pdfbox.io;

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
import java.lang.reflect.Field;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class TestScratchFileBufferRickGen {
    static XStream xStream = new XStream();

    private <T> T deserializeObjectFromFile(String serializedObjectFilePath) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File serializedObjectFile = new File(classLoader.getResource(serializedObjectFilePath).getFile());
        Scanner scanner = new Scanner(serializedObjectFile);
        String serializedObjectString = scanner.useDelimiter("\\A").next();
        return (T) xStream.fromXML(serializedObjectString);
    }

    private ScratchFile insertPrivateMockField_pageHandler_InScratchFileBuffer(ScratchFileBuffer receivingObject) throws Exception {
        ScratchFile mockScratchFile = Mockito.mock(ScratchFile.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("pageHandler");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockScratchFile);
        return mockScratchFile;
    }

    @BeforeAll
    public static void setxStream() {
        xStream.registerConverter(new FileCleanableConverter());
    }

    @Test
    @DisplayName("seek-6 with parameter oracle, mocking [org.apache.pdfbox.io.ScratchFile.writePage(int,byte[])]")
    public void test_seek_PO_c6a040ebde9a463bb41b7db076b9cec0() throws Exception {
        // Arrange
        ScratchFileBuffer receivingObject = deserializeObjectFromFile("org.apache.pdfbox.io.ScratchFileBuffer.seek6-receiving.xml");
        ScratchFile mockScratchFile = insertPrivateMockField_pageHandler_InScratchFileBuffer(receivingObject);
        // Act
        receivingObject.seek(0L);
        // Assert
//         Mockito.verify(mockScratchFile, Mockito.atLeastOnce()).writePage(eq(1),   (byte[]) any());
    }

    @Test
    @DisplayName("seek-6 with call oracle, mocking [org.apache.pdfbox.io.ScratchFile.writePage(int,byte[])]")
    public void test_seek_CO_c6a040ebde9a463bb41b7db076b9cec0() throws Exception {
        // Arrange
        ScratchFileBuffer receivingObject = deserializeObjectFromFile("org.apache.pdfbox.io.ScratchFileBuffer.seek6-receiving.xml");
        ScratchFile mockScratchFile = insertPrivateMockField_pageHandler_InScratchFileBuffer(receivingObject);
        // Act
        receivingObject.seek(0L);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockScratchFile);
        orderVerifier.verify(mockScratchFile, Mockito.times(1)).writePage(anyInt(), (byte[]) any());
    }
}