package org.apache.pdfbox.pdmodel.font;

import com.thoughtworks.xstream.XStream;
import converters.FileCleanableConverter;
import org.apache.pdfbox.cos.COSDictionary;
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
public class TestPDFontDescriptorRickGenSetCapHeight {
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
    @DisplayName("setCapHeight-1 with parameter oracle, mocking [org.apache.pdfbox.cos.COSDictionary.setFloat(org.apache.pdfbox.cos.COSName,float)]")
    public void test_setCapHeight_PO_e67dd33358c54b2d9a83c11d36e60618() throws Exception {
        // Arrange
        PDFontDescriptor receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.font.PDFontDescriptor.setCapHeight1-receiving.xml");
        COSDictionary mockCOSDictionary = insertPrivateMockField_dic_InPDFontDescriptor(receivingObject);
        // Act
        receivingObject.setCapHeight(662.0F);
        // Assert
        Mockito.verify(mockCOSDictionary, Mockito.atLeastOnce()).setFloat(any(org.apache.pdfbox.cos.COSName.class),   eq(662.0F));
    }

    @Test
    @DisplayName("setCapHeight-1 with call oracle, mocking [org.apache.pdfbox.cos.COSDictionary.setFloat(org.apache.pdfbox.cos.COSName,float)]")
    public void test_setCapHeight_CO_e67dd33358c54b2d9a83c11d36e60618() throws Exception {
        // Arrange
        PDFontDescriptor receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.font.PDFontDescriptor.setCapHeight1-receiving.xml");
        COSDictionary mockCOSDictionary = insertPrivateMockField_dic_InPDFontDescriptor(receivingObject);
        // Act
        receivingObject.setCapHeight(662.0F);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockCOSDictionary);
//         orderVerifier.verify(mockCOSDictionary, Mockito.times(1)).setFloat((org.apache.pdfbox.cos.COSName) any(), anyFloat());
    }
}