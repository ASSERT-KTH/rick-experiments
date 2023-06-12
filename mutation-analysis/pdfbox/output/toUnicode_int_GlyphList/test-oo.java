package org.apache.pdfbox.pdmodel.font;

import com.thoughtworks.xstream.XStream;
import converters.FileCleanableConverter;
import org.apache.pdfbox.pdmodel.font.encoding.Encoding;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class TestPDSimpleFontRickGen {
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

    private Encoding insertMockField_encoding_InPDTrueTypeFont(PDTrueTypeFont receivingObject) {
        Encoding mockEncoding = Mockito.mock(Encoding.class);
        receivingObject.encoding = mockEncoding;
        return mockEncoding;
    }

    @BeforeAll
    public static void setxStream() {
        xStream.registerConverter(new FileCleanableConverter());
    }


    @Test
    @DisplayName("toUnicode-1 with output oracle, mocking [org.apache.pdfbox.pdmodel.font.encoding.Encoding.getName(int)]")
    public void test_toUnicode_int_org_apache_pdfbox_pdmodel_font_encoding_GlyphList_OO_997e2c2e212b42e0aff137fe7962df3e() throws Exception {
        // Arrange
        PDTrueTypeFont receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.font.PDSimpleFont.toUnicode_int,org.apache.pdfbox.pdmodel.font.encoding.GlyphList1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.font.PDSimpleFont.toUnicode_int,org.apache.pdfbox.pdmodel.font.encoding.GlyphList1-params.xml");
        int paramObject1 = (Integer) paramObjects[0];
        org.apache.pdfbox.pdmodel.font.encoding.GlyphList paramObject2 = (org.apache.pdfbox.pdmodel.font.encoding.GlyphList) paramObjects[1];
        Encoding mockEncoding = insertMockField_encoding_InPDTrueTypeFont(receivingObject);
        Mockito.lenient().when(mockEncoding.getName(32)).thenReturn("space");
        // Act
        String actual = receivingObject.toUnicode(paramObject1, paramObject2);
        // Assert
        Assertions.assertEquals(" ", actual);
    }

    @Test
    @DisplayName("toUnicode-1 with parameter oracle, mocking [org.apache.pdfbox.pdmodel.font.encoding.Encoding.getName(int)]")
    public void test_toUnicode_int_org_apache_pdfbox_pdmodel_font_encoding_GlyphList_PO_997e2c2e212b42e0aff137fe7962df3e() throws Exception {
        // Arrange
        PDTrueTypeFont receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.font.PDSimpleFont.toUnicode_int,org.apache.pdfbox.pdmodel.font.encoding.GlyphList1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.font.PDSimpleFont.toUnicode_int,org.apache.pdfbox.pdmodel.font.encoding.GlyphList1-params.xml");
        int paramObject1 = (Integer) paramObjects[0];
        org.apache.pdfbox.pdmodel.font.encoding.GlyphList paramObject2 = (org.apache.pdfbox.pdmodel.font.encoding.GlyphList) paramObjects[1];
        Encoding mockEncoding = insertMockField_encoding_InPDTrueTypeFont(receivingObject);
        Mockito.lenient().when(mockEncoding.getName(32)).thenReturn("space");
        // Act
        receivingObject.toUnicode(paramObject1, paramObject2);
        // Assert
//         Mockito.verify(mockEncoding, Mockito.atLeastOnce()).getName(32);
    }

    @Test
    @DisplayName("toUnicode-1 with call oracle, mocking [org.apache.pdfbox.pdmodel.font.encoding.Encoding.getName(int)]")
    public void test_toUnicode_int_org_apache_pdfbox_pdmodel_font_encoding_GlyphList_CO_997e2c2e212b42e0aff137fe7962df3e() throws Exception {
        // Arrange
        PDTrueTypeFont receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.font.PDSimpleFont.toUnicode_int,org.apache.pdfbox.pdmodel.font.encoding.GlyphList1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.font.PDSimpleFont.toUnicode_int,org.apache.pdfbox.pdmodel.font.encoding.GlyphList1-params.xml");
        int paramObject1 = (Integer) paramObjects[0];
        org.apache.pdfbox.pdmodel.font.encoding.GlyphList paramObject2 = (org.apache.pdfbox.pdmodel.font.encoding.GlyphList) paramObjects[1];
        Encoding mockEncoding = insertMockField_encoding_InPDTrueTypeFont(receivingObject);
        Mockito.lenient().when(mockEncoding.getName(32)).thenReturn("space");
        // Act
        receivingObject.toUnicode(paramObject1, paramObject2);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockEncoding);
//         orderVerifier.verify(mockEncoding, Mockito.times(1)).getName(anyInt());
    }
}