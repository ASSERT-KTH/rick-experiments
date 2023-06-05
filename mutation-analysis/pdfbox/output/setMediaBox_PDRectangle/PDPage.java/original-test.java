package org.apache.pdfbox.pdmodel;

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

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestPDPageRickGenSetMediaBox {
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

    private COSDictionary insertPrivateMockField_page_InPDPage(PDPage receivingObject) throws Exception {
        COSDictionary mockCOSDictionary = Mockito.mock(COSDictionary.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("page");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockCOSDictionary);
        return mockCOSDictionary;
    }

    @BeforeAll
    public static void setxStream() {
        xStream.registerConverter(new FileCleanableConverter());
    }

    @Test
    @DisplayName("setMediaBox-1 with parameter oracle, mocking [org.apache.pdfbox.cos.COSDictionary.setItem(org.apache.pdfbox.cos.COSName,org.apache.pdfbox.pdmodel.common.COSObjectable)]")
    public void test_setMediaBox_PO_f7a86044d6bc408da39110eb91bfbd73() throws Exception {
        // Arrange
        PDPage receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.PDPage.setMediaBox1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.PDPage.setMediaBox1-params.xml");
        org.apache.pdfbox.pdmodel.common.PDRectangle paramObject1 = (org.apache.pdfbox.pdmodel.common.PDRectangle) paramObjects[0];
        COSDictionary mockCOSDictionary = insertPrivateMockField_page_InPDPage(receivingObject);
        // Act
        receivingObject.setMediaBox(paramObject1);
        // Assert
        Mockito.verify(mockCOSDictionary, Mockito.atLeastOnce()).setItem(any(org.apache.pdfbox.cos.COSName.class),   any(org.apache.pdfbox.pdmodel.common.COSObjectable.class));
    }

    @Test
    @DisplayName("setMediaBox-1 with call oracle, mocking [org.apache.pdfbox.cos.COSDictionary.setItem(org.apache.pdfbox.cos.COSName,org.apache.pdfbox.pdmodel.common.COSObjectable)]")
    public void test_setMediaBox_CO_f7a86044d6bc408da39110eb91bfbd73() throws Exception {
        // Arrange
        PDPage receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.PDPage.setMediaBox1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.PDPage.setMediaBox1-params.xml");
        org.apache.pdfbox.pdmodel.common.PDRectangle paramObject1 = (org.apache.pdfbox.pdmodel.common.PDRectangle) paramObjects[0];
        COSDictionary mockCOSDictionary = insertPrivateMockField_page_InPDPage(receivingObject);
        // Act
        receivingObject.setMediaBox(paramObject1);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockCOSDictionary);
        orderVerifier.verify(mockCOSDictionary, Mockito.times(1)).setItem((org.apache.pdfbox.cos.COSName) any(), (org.apache.pdfbox.pdmodel.common.COSObjectable) any());
    }
}