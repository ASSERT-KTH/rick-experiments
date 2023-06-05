package org.apache.pdfbox.pdmodel.graphics.shading;

import com.thoughtworks.xstream.XStream;
import converters.FileCleanableConverter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.geom.AffineTransform;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class TestAxialShadingContextRickGen {
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


    private AffineTransform insertPrivateMockField_rat_InAxialShadingContext(AxialShadingContext receivingObject) throws Exception {
        AffineTransform mockAffineTransform = Mockito.mock(AffineTransform.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("rat");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockAffineTransform);
        return mockAffineTransform;
    }

    @Test
    @DisplayName("getRaster-1 with parameter oracle, mocking [java.awt.geom.AffineTransform.transform(float[],int,float[],int,int)]")
    public void test_getRaster_PO_6d366ff78a7c4104a72dd3d8270515cb() throws Exception {
        // Arrange
        AxialShadingContext receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.graphics.shading.AxialShadingContext.getRaster1-receiving.xml");
        AffineTransform mockAffineTransform = insertPrivateMockField_rat_InAxialShadingContext(receivingObject);
        // Act
        receivingObject.getRaster(754,   51,   14,   12);
        // Assert
        Mockito.verify(mockAffineTransform, Mockito.atLeastOnce()).transform((float[]) any(),   eq(0),   (float[]) any(),   eq(0),   eq(1));
    }

    @Test
    @DisplayName("getRaster-1 with call oracle, mocking [java.awt.geom.AffineTransform.transform(float[],int,float[],int,int)]")
    public void test_getRaster_CO_6d366ff78a7c4104a72dd3d8270515cb() throws Exception {
        // Arrange
        AxialShadingContext receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.graphics.shading.AxialShadingContext.getRaster1-receiving.xml");
        AffineTransform mockAffineTransform = insertPrivateMockField_rat_InAxialShadingContext(receivingObject);
        // Act
        receivingObject.getRaster(754,   51,   14,   12);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockAffineTransform);
//         orderVerifier.verify(mockAffineTransform, Mockito.times(168)).transform((float[]) any(), anyInt(), (float[]) any(), anyInt(), anyInt());
    }
}