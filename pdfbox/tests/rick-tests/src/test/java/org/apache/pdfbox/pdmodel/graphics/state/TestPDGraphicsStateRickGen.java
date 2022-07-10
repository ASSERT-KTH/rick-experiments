package org.apache.pdfbox.pdmodel.graphics.state;
import com.thoughtworks.xstream.XStream;
import java.awt.geom.Area;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Scanner;

import converters.FileCleanableConverter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestPDGraphicsStateRickGen {
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


    private Area insertPrivateMockField_clippingPath_InPDGraphicsState(PDGraphicsState receivingObject) throws Exception {
        Area mockArea = Mockito.mock(Area.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("clippingPath");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockArea);
        return mockArea;
    }

    @Test
    @DisplayName("intersectClippingPath-1 with parameter oracle, mocking [java.awt.geom.Area.intersect(java.awt.geom.Area)]")
    public void test_intersectClippingPath_java_awt_geom_Area_PO_3febd04a156f4fd99ce27a0bd156f9c3() throws Exception {
        // Arrange
        org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState.intersectClippingPath_java.awt.geom.Area1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState.intersectClippingPath_java.awt.geom.Area1-params.xml");
        java.awt.geom.Area paramObject1 = (java.awt.geom.Area) paramObjects[0];
        Area mockArea = insertPrivateMockField_clippingPath_InPDGraphicsState(receivingObject);
        // Act
        receivingObject.intersectClippingPath(paramObject1);
        // Assert
        Mockito.verify(mockArea, Mockito.atLeastOnce()).intersect(any(java.awt.geom.Area.class));
    }

    @Test
    @DisplayName("intersectClippingPath-1 with call oracle, mocking [java.awt.geom.Area.intersect(java.awt.geom.Area)]")
    public void test_intersectClippingPath_java_awt_geom_Area_CO_3febd04a156f4fd99ce27a0bd156f9c3() throws Exception {
        // Arrange
        org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState.intersectClippingPath_java.awt.geom.Area1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState.intersectClippingPath_java.awt.geom.Area1-params.xml");
        java.awt.geom.Area paramObject1 = (java.awt.geom.Area) paramObjects[0];
        Area mockArea = insertPrivateMockField_clippingPath_InPDGraphicsState(receivingObject);
        // Act
        receivingObject.intersectClippingPath(paramObject1);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockArea);
        orderVerifier.verify(mockArea, Mockito.times(1)).intersect((java.awt.geom.Area) any());
    }
}