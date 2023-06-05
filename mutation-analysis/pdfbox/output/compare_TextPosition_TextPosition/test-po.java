package org.apache.pdfbox.text;

import com.thoughtworks.xstream.XStream;
import converters.FileCleanableConverter;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.util.Scanner;

@ExtendWith(MockitoExtension.class)
public class TestTextPositionComparatorRickGen {
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
    @DisplayName("compare-1 with output oracle, mocking [org.apache.pdfbox.text.TextPosition.getDir(), org.apache.pdfbox.text.TextPosition.getYDirAdj()]")
    public void test_compare_OO_d5e017d5af7242fba30ab9c3bcb6f433() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.apache.pdfbox.text.TextPositionComparator/>";
        TextPositionComparator receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.text.TextPositionComparator.compare1-params.xml");
        TextPosition paramObject2 = (TextPosition) paramObjects[1];
        TextPosition mockTextPosition = Mockito.mock(TextPosition.class);
        Mockito.when(mockTextPosition.getDir()).thenReturn(0.0F);
        Mockito.when(mockTextPosition.getYDirAdj()).thenReturn(58.319885F);
        Mockito.when(mockTextPosition.getYDirAdj()).thenReturn(168.89996F);
        // Act
        int actual = receivingObject.compare(mockTextPosition, paramObject2);
        // Assert
//         Assertions.assertEquals(-1, actual);
    }

    @Test
    @DisplayName("compare-1 with parameter oracle, mocking [org.apache.pdfbox.text.TextPosition.getDir(), org.apache.pdfbox.text.TextPosition.getYDirAdj()]")
    public void test_compare_PO_d5e017d5af7242fba30ab9c3bcb6f433() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.apache.pdfbox.text.TextPositionComparator/>";
        TextPositionComparator receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.text.TextPositionComparator.compare1-params.xml");
        TextPosition paramObject2 = (TextPosition) paramObjects[1];
        TextPosition mockTextPosition = Mockito.mock(TextPosition.class);
        Mockito.when(mockTextPosition.getDir()).thenReturn(0.0F);
        Mockito.when(mockTextPosition.getYDirAdj()).thenReturn(58.319885F);
        Mockito.when(mockTextPosition.getYDirAdj()).thenReturn(168.89996F);
        // Act
        receivingObject.compare(mockTextPosition, paramObject2);
        // Assert
        Mockito.verify(mockTextPosition, Mockito.atLeastOnce()).getDir();
        Mockito.verify(mockTextPosition, Mockito.atLeastOnce()).getYDirAdj();
    }

    @Test
    @Disabled
    @DisplayName("compare-1 with call oracle, mocking [org.apache.pdfbox.text.TextPosition.getDir(), org.apache.pdfbox.text.TextPosition.getYDirAdj()]")
    public void test_compare_CO_d5e017d5af7242fba30ab9c3bcb6f433() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.apache.pdfbox.text.TextPositionComparator/>";
        TextPositionComparator receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.text.TextPositionComparator.compare1-params.xml");
        TextPosition paramObject2 = (TextPosition) paramObjects[1];
        TextPosition mockTextPosition = Mockito.mock(TextPosition.class);
        Mockito.when(mockTextPosition.getDir()).thenReturn(0.0F);
        Mockito.when(mockTextPosition.getYDirAdj()).thenReturn(58.319885F);
        Mockito.when(mockTextPosition.getYDirAdj()).thenReturn(168.89996F);
        // Act
        receivingObject.compare(mockTextPosition, paramObject2);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockTextPosition, mockTextPosition);
//         orderVerifier.verify(mockTextPosition, Mockito.times(5)).getDir();
//         orderVerifier.verify(mockTextPosition, Mockito.times(1)).getYDirAdj();
//         orderVerifier.verify(mockTextPosition, Mockito.times(1)).getDir();
//         orderVerifier.verify(mockTextPosition, Mockito.times(1)).getYDirAdj();
    }
}