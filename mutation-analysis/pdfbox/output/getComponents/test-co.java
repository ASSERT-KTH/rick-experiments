package org.apache.pdfbox.pdmodel.graphics.color;

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

@ExtendWith(MockitoExtension.class)
public class TestPDColorRickGen {
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

    private PDColorSpace insertPrivateMockField_colorSpace_InPDColor(PDColor receivingObject) throws Exception {
        PDColorSpace mockPDColorSpace = Mockito.mock(PDColorSpace.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("colorSpace");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockPDColorSpace);
        return mockPDColorSpace;
    }

    @BeforeAll
    public static void setxStream() {
        xStream.registerConverter(new FileCleanableConverter());
    }


    @Test
    @DisplayName("getComponents-1 with parameter oracle, mocking [org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace.getNumberOfComponents()]")
    public void test_getComponents_PO_35e9d24bf94146c09422d5d8f0936e01() throws Exception {
        // Arrange
        PDColor receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.graphics.color.PDColor.getComponents1-receiving.xml");
        PDColorSpace mockPDColorSpace = insertPrivateMockField_colorSpace_InPDColor(receivingObject);
        Mockito.lenient().when(mockPDColorSpace.getNumberOfComponents()).thenReturn(3);
        // Act
        receivingObject.getComponents();
        // Assert
//         Mockito.verify(mockPDColorSpace, Mockito.atLeastOnce()).getNumberOfComponents();
    }

    @Test
    @DisplayName("getComponents-1 with call oracle, mocking [org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace.getNumberOfComponents()]")
    public void test_getComponents_CO_35e9d24bf94146c09422d5d8f0936e01() throws Exception {
        // Arrange
        PDColor receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.graphics.color.PDColor.getComponents1-receiving.xml");
        PDColorSpace mockPDColorSpace = insertPrivateMockField_colorSpace_InPDColor(receivingObject);
        Mockito.lenient().when(mockPDColorSpace.getNumberOfComponents()).thenReturn(3);
        // Act
        receivingObject.getComponents();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockPDColorSpace);
        orderVerifier.verify(mockPDColorSpace, Mockito.times(1)).getNumberOfComponents();
    }
}