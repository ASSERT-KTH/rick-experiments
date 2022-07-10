package org.apache.pdfbox.pdmodel.font;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Scanner;

import converters.FileCleanableConverter;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class TestPDTrueTypeFontRickGen {
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


    private CmapSubtable insertPrivateMockField_cmapWinUnicode_InPDTrueTypeFont(PDTrueTypeFont receivingObject) throws Exception {
        CmapSubtable mockCmapSubtable = Mockito.mock(CmapSubtable.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("cmapWinUnicode");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockCmapSubtable);
        return mockCmapSubtable;
    }

    private CmapSubtable insertPrivateMockField_cmapMacRoman_InPDTrueTypeFont(PDTrueTypeFont receivingObject) throws Exception {
        CmapSubtable mockCmapSubtable = Mockito.mock(CmapSubtable.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("cmapMacRoman");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockCmapSubtable);
        return mockCmapSubtable;
    }

    private CmapSubtable insertPrivateMockField_cmapWinSymbol_InPDTrueTypeFont(PDTrueTypeFont receivingObject) throws Exception {
        CmapSubtable mockCmapSubtable = Mockito.mock(CmapSubtable.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("cmapWinSymbol");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockCmapSubtable);
        return mockCmapSubtable;
    }

    @Test
    @Disabled
    @DisplayName("codeToGID-1 with output oracle, mocking [org.apache.fontbox.ttf.CmapSubtable.getGlyphId(int), org.apache.fontbox.ttf.TrueTypeFont.nameToGID(java.lang.String)]")
    public void test_codeToGID_OO_021468ed0b2444599e096ca853633767() throws Exception {
        // Arrange
        org.apache.pdfbox.pdmodel.font.PDTrueTypeFont receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.font.PDTrueTypeFont.codeToGID1-receiving.xml");
        CmapSubtable mockCmapSubtable = insertPrivateMockField_cmapWinUnicode_InPDTrueTypeFont(receivingObject);
//        CmapSubtable mockCmapSubtable = insertPrivateMockField_cmapMacRoman_InPDTrueTypeFont(receivingObject);
//        CmapSubtable mockCmapSubtable = insertPrivateMockField_cmapWinSymbol_InPDTrueTypeFont(receivingObject);
        Mockito.when(mockCmapSubtable.getGlyphId(70)).thenReturn(41);
        // Act
        int actual = receivingObject.codeToGID(70);
        // Assert
        Assertions.assertEquals(41, actual);
    }

    @Test
    @Disabled
    @DisplayName("codeToGID-1 with parameter oracle, mocking [org.apache.fontbox.ttf.CmapSubtable.getGlyphId(int), org.apache.fontbox.ttf.TrueTypeFont.nameToGID(java.lang.String)]")
    public void test_codeToGID_PO_021468ed0b2444599e096ca853633767() throws Exception {
        // Arrange
        org.apache.pdfbox.pdmodel.font.PDTrueTypeFont receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.font.PDTrueTypeFont.codeToGID1-receiving.xml");
        CmapSubtable mockCmapSubtable = insertPrivateMockField_cmapWinUnicode_InPDTrueTypeFont(receivingObject);
//        CmapSubtable mockCmapSubtable = insertPrivateMockField_cmapMacRoman_InPDTrueTypeFont(receivingObject);
//        CmapSubtable mockCmapSubtable = insertPrivateMockField_cmapWinSymbol_InPDTrueTypeFont(receivingObject);
        Mockito.when(mockCmapSubtable.getGlyphId(70)).thenReturn(41);
        // Act
        receivingObject.codeToGID(70);
        // Assert
        Mockito.verify(mockCmapSubtable, Mockito.atLeastOnce()).getGlyphId(70);
    }

    @Test
    @Disabled
    @DisplayName("codeToGID-1 with call oracle, mocking [org.apache.fontbox.ttf.CmapSubtable.getGlyphId(int), org.apache.fontbox.ttf.TrueTypeFont.nameToGID(java.lang.String)]")
    public void test_codeToGID_CO_021468ed0b2444599e096ca853633767() throws Exception {
        // Arrange
        org.apache.pdfbox.pdmodel.font.PDTrueTypeFont receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.font.PDTrueTypeFont.codeToGID1-receiving.xml");
        CmapSubtable mockCmapSubtable = insertPrivateMockField_cmapWinUnicode_InPDTrueTypeFont(receivingObject);
//        CmapSubtable mockCmapSubtable = insertPrivateMockField_cmapMacRoman_InPDTrueTypeFont(receivingObject);
//        CmapSubtable mockCmapSubtable = insertPrivateMockField_cmapWinSymbol_InPDTrueTypeFont(receivingObject);
        Mockito.when(mockCmapSubtable.getGlyphId(70)).thenReturn(41);
        // Act
        receivingObject.codeToGID(70);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockCmapSubtable);
        orderVerifier.verify(mockCmapSubtable, Mockito.times(1)).getGlyphId(anyInt());
    }

    private TrueTypeFont insertPrivateMockField_ttf_InPDTrueTypeFont(PDTrueTypeFont receivingObject) throws Exception {
        TrueTypeFont mockTrueTypeFont = Mockito.mock(TrueTypeFont.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("ttf");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockTrueTypeFont);
        return mockTrueTypeFont;
    }

    @Test
    @DisplayName("getWidthFromFont-1 with output oracle, mocking [org.apache.fontbox.ttf.TrueTypeFont.getAdvanceWidth(int), org.apache.fontbox.ttf.TrueTypeFont.getUnitsPerEm()]")
    public void test_getWidthFromFont_OO_117429ea5b5c49138fef41471eaed9a3() throws Exception {
        // Arrange
        org.apache.pdfbox.pdmodel.font.PDTrueTypeFont receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.font.PDTrueTypeFont.getWidthFromFont1-receiving.xml");
        TrueTypeFont mockTrueTypeFont = insertPrivateMockField_ttf_InPDTrueTypeFont(receivingObject);
        Mockito.when(mockTrueTypeFont.getAdvanceWidth(0)).thenReturn(1536);
        Mockito.when(mockTrueTypeFont.getUnitsPerEm()).thenReturn(2048);
        // Act
        float actual = receivingObject.getWidthFromFont(32);
        // Assert
        Assertions.assertEquals(750.0, actual);
    }

    @Test
    @DisplayName("getWidthFromFont-1 with parameter oracle, mocking [org.apache.fontbox.ttf.TrueTypeFont.getAdvanceWidth(int), org.apache.fontbox.ttf.TrueTypeFont.getUnitsPerEm()]")
    public void test_getWidthFromFont_PO_117429ea5b5c49138fef41471eaed9a3() throws Exception {
        // Arrange
        org.apache.pdfbox.pdmodel.font.PDTrueTypeFont receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.font.PDTrueTypeFont.getWidthFromFont1-receiving.xml");
        TrueTypeFont mockTrueTypeFont = insertPrivateMockField_ttf_InPDTrueTypeFont(receivingObject);
        Mockito.when(mockTrueTypeFont.getAdvanceWidth(0)).thenReturn(1536);
        Mockito.when(mockTrueTypeFont.getUnitsPerEm()).thenReturn(2048);
        // Act
        receivingObject.getWidthFromFont(32);
        // Assert
        Mockito.verify(mockTrueTypeFont, Mockito.atLeastOnce()).getAdvanceWidth(0);
        Mockito.verify(mockTrueTypeFont, Mockito.atLeastOnce()).getUnitsPerEm();
    }

    @Test
    @DisplayName("getWidthFromFont-1 with call oracle, mocking [org.apache.fontbox.ttf.TrueTypeFont.getAdvanceWidth(int), org.apache.fontbox.ttf.TrueTypeFont.getUnitsPerEm()]")
    public void test_getWidthFromFont_CO_117429ea5b5c49138fef41471eaed9a3() throws Exception {
        // Arrange
        org.apache.pdfbox.pdmodel.font.PDTrueTypeFont receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.font.PDTrueTypeFont.getWidthFromFont1-receiving.xml");
        TrueTypeFont mockTrueTypeFont = insertPrivateMockField_ttf_InPDTrueTypeFont(receivingObject);
        Mockito.when(mockTrueTypeFont.getAdvanceWidth(0)).thenReturn(1536);
        Mockito.when(mockTrueTypeFont.getUnitsPerEm()).thenReturn(2048);
        // Act
        receivingObject.getWidthFromFont(32);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockTrueTypeFont, mockTrueTypeFont);
        orderVerifier.verify(mockTrueTypeFont, Mockito.times(1)).getAdvanceWidth(anyInt());
        orderVerifier.verify(mockTrueTypeFont, Mockito.times(1)).getUnitsPerEm();
    }
}