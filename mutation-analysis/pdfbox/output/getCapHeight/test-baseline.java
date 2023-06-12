package org.apache.pdfbox.pdmodel.font;

import com.thoughtworks.xstream.XStream;
import converters.FileCleanableConverter;
import org.apache.pdfbox.cos.COSDictionary;
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
public class TestPDFontDescriptorRickGenGetCapHeight {
    static XStream xStream = new XStream();

    private <T> T deserializeObjectFromFile(String serializedObjectFilePath) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File serializedObjectFile = new File(classLoader.getResource(serializedObjectFilePath).getFile());
        Scanner scanner = new Scanner(serializedObjectFile);
        String serializedObjectString = scanner.useDelimiter("\\A").next();
        return (T) xStream.fromXML(serializedObjectString);
    }

    private COSDictionary insertPrivateMockField_dic_InPDFontDescriptor(PDFontDescriptor receivingObject) throws Exception {
        COSDictionary mockCOSDictionary = Mockito.mock(COSDictionary.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("dic");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockCOSDictionary);
        return mockCOSDictionary;
    }

    @BeforeAll
    public static void setxStream() {
        xStream.registerConverter(new FileCleanableConverter());
    }


    @Test
    @DisplayName("getCapHeight-1 with output oracle, mocking [org.apache.pdfbox.cos.COSDictionary.getFloat(org.apache.pdfbox.cos.COSName,float)]")
    public void test_getCapHeight_OO_1f685d88d35a4c82b40d11344f161e40() throws Exception {
        // Arrange
        PDFontDescriptor receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.font.PDFontDescriptor.getCapHeight1-receiving.xml");
        COSDictionary mockCOSDictionary = insertPrivateMockField_dic_InPDFontDescriptor(receivingObject);
        Mockito.lenient().when(mockCOSDictionary.getFloat(any(org.apache.pdfbox.cos.COSName.class),   eq(0.0F))).thenReturn(718.0F);
        // Act
        float actual = receivingObject.getCapHeight();
        // Assert
//        Assertions.assertEquals(718.0, actual);
    }

    @Test
    @DisplayName("getCapHeight-1 with parameter oracle, mocking [org.apache.pdfbox.cos.COSDictionary.getFloat(org.apache.pdfbox.cos.COSName,float)]")
    public void test_getCapHeight_PO_1f685d88d35a4c82b40d11344f161e40() throws Exception {
        // Arrange
        PDFontDescriptor receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.font.PDFontDescriptor.getCapHeight1-receiving.xml");
        COSDictionary mockCOSDictionary = insertPrivateMockField_dic_InPDFontDescriptor(receivingObject);
        Mockito.lenient().when(mockCOSDictionary.getFloat(any(org.apache.pdfbox.cos.COSName.class),   eq(0.0F))).thenReturn(718.0F);
        // Act
        receivingObject.getCapHeight();
        // Assert
//        Mockito.verify(mockCOSDictionary, Mockito.atLeastOnce()).getFloat(any(org.apache.pdfbox.cos.COSName.class),   eq(0.0F));
    }

    @Test
    @DisplayName("getCapHeight-1 with call oracle, mocking [org.apache.pdfbox.cos.COSDictionary.getFloat(org.apache.pdfbox.cos.COSName,float)]")
    public void test_getCapHeight_CO_1f685d88d35a4c82b40d11344f161e40() throws Exception {
        // Arrange
        PDFontDescriptor receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.font.PDFontDescriptor.getCapHeight1-receiving.xml");
        COSDictionary mockCOSDictionary = insertPrivateMockField_dic_InPDFontDescriptor(receivingObject);
        Mockito.lenient().when(mockCOSDictionary.getFloat(any(org.apache.pdfbox.cos.COSName.class),   eq(0.0F))).thenReturn(718.0F);
        // Act
        receivingObject.getCapHeight();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockCOSDictionary);
//        orderVerifier.verify(mockCOSDictionary, Mockito.times(1)).getFloat((org.apache.pdfbox.cos.COSName) any(), anyFloat());
    }
}