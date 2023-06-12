package org.apache.pdfbox.pdmodel.graphics.color;

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

import java.awt.color.ICC_Profile;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Scanner;

@ExtendWith(MockitoExtension.class)
public class TestPDICCBasedRickGen {
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

    private ICC_Profile insertPrivateMockField_iccProfile_InPDICCBased(PDICCBased receivingObject) throws Exception {
        ICC_Profile mockICC_Profile = Mockito.mock(ICC_Profile.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("iccProfile");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockICC_Profile);
        return mockICC_Profile;
    }

    @BeforeAll
    public static void setxStream() {
        xStream.registerConverter(new FileCleanableConverter());
    }


    @Test
    @DisplayName("getNumberOfComponents-1 with output oracle, mocking [java.awt.color.ICC_Profile.getNumComponents()]")
    public void test_getNumberOfComponents_OO_46f03fe75cc849fc8b43f6a47a0c7da7() throws Exception {
        // Arrange
        PDICCBased receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.graphics.color.PDICCBased.getNumberOfComponents1-receiving.xml");
        ICC_Profile mockICC_Profile = insertPrivateMockField_iccProfile_InPDICCBased(receivingObject);
        Mockito.lenient().when(mockICC_Profile.getNumComponents()).thenReturn(3);
        // Act
        int actual = receivingObject.getNumberOfComponents();
        // Assert
//         Assertions.assertEquals(3, actual);
    }

    @Test
    @DisplayName("getNumberOfComponents-1 with parameter oracle, mocking [java.awt.color.ICC_Profile.getNumComponents()]")
    public void test_getNumberOfComponents_PO_46f03fe75cc849fc8b43f6a47a0c7da7() throws Exception {
        // Arrange
        PDICCBased receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.graphics.color.PDICCBased.getNumberOfComponents1-receiving.xml");
        ICC_Profile mockICC_Profile = insertPrivateMockField_iccProfile_InPDICCBased(receivingObject);
        Mockito.lenient().when(mockICC_Profile.getNumComponents()).thenReturn(3);
        // Act
        receivingObject.getNumberOfComponents();
        // Assert
//         Mockito.verify(mockICC_Profile, Mockito.atLeastOnce()).getNumComponents();
    }

    @Test
    @DisplayName("getNumberOfComponents-1 with call oracle, mocking [java.awt.color.ICC_Profile.getNumComponents()]")
    public void test_getNumberOfComponents_CO_46f03fe75cc849fc8b43f6a47a0c7da7() throws Exception {
        // Arrange
        PDICCBased receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.graphics.color.PDICCBased.getNumberOfComponents1-receiving.xml");
        ICC_Profile mockICC_Profile = insertPrivateMockField_iccProfile_InPDICCBased(receivingObject);
        Mockito.lenient().when(mockICC_Profile.getNumComponents()).thenReturn(3);
        // Act
        receivingObject.getNumberOfComponents();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockICC_Profile);
        orderVerifier.verify(mockICC_Profile, Mockito.times(1)).getNumComponents();
    }
}