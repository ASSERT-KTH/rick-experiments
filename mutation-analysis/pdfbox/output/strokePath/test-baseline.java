package org.apache.pdfbox.rendering;

import com.thoughtworks.xstream.XStream;
import converters.FileCleanableConverter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class TestPageDrawerRickGen {
    static XStream xStream = new XStream();

    private <T> T deserializeObjectFromFile(String serializedObjectFilePath) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File serializedObjectFile = new File(classLoader.getResource(serializedObjectFilePath).getFile());
        Scanner scanner = new Scanner(serializedObjectFile);
        String serializedObjectString = scanner.useDelimiter("\\A").next();
        return (T) xStream.fromXML(serializedObjectString);
    }

    private GeneralPath insertPrivateMockField_linePath_InPageDrawer(PageDrawer receivingObject) throws Exception {
        GeneralPath mockPath2DFloat = Mockito.mock(GeneralPath.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("linePath");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockPath2DFloat);
        return mockPath2DFloat;
    }

    @BeforeAll
    public static void setxStream() {
        xStream.registerConverter(new FileCleanableConverter());
    }


    private Graphics2D insertPrivateMockField_graphics_InPageDrawer(PageDrawer receivingObject) throws Exception {
        Graphics2D mockGraphics2D = Mockito.mock(Graphics2D.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("graphics");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockGraphics2D);
        return mockGraphics2D;
    }


    @Test
    @DisplayName("strokePath-1 with parameter oracle, mocking [java.awt.Graphics2D.setComposite(java.awt.Composite), java.awt.Graphics2D.setPaint(java.awt.Paint), java.awt.Graphics2D.setStroke(java.awt.Stroke), java.awt.Graphics2D.draw(java.awt.Shape), java.awt.geom.Path2D.reset()]")
    public void test_strokePath_PO_555753857be74b738a876daa406fdfcf() throws Exception {
        // Arrange
        PageDrawer receivingObject = deserializeObjectFromFile("org.apache.pdfbox.rendering.PageDrawer.strokePath1-receiving.xml");
        Graphics2D mockGraphics2D = insertPrivateMockField_graphics_InPageDrawer(receivingObject);
        Path2D mockPath2D = insertPrivateMockField_linePath_InPageDrawer(receivingObject);
        // Act
        receivingObject.strokePath();
        // Assert
//        Mockito.verify(mockGraphics2D, Mockito.atLeastOnce()).setComposite(any(java.awt.Composite.class));
//        Mockito.verify(mockGraphics2D, Mockito.atLeastOnce()).setPaint(any(java.awt.Paint.class));
//        Mockito.verify(mockGraphics2D, Mockito.atLeastOnce()).setStroke(any(java.awt.Stroke.class));
//        Mockito.verify(mockGraphics2D, Mockito.atLeastOnce()).draw(any(java.awt.Shape.class));
//        Mockito.verify(mockPath2D, Mockito.atLeastOnce()).reset();
    }

    @Test
    @DisplayName("strokePath-1 with call oracle, mocking [java.awt.Graphics2D.setComposite(java.awt.Composite), java.awt.Graphics2D.setPaint(java.awt.Paint), java.awt.Graphics2D.setStroke(java.awt.Stroke), java.awt.Graphics2D.draw(java.awt.Shape), java.awt.geom.Path2D.reset()]")
    public void test_strokePath_CO_555753857be74b738a876daa406fdfcf() throws Exception {
        // Arrange
        PageDrawer receivingObject = deserializeObjectFromFile("org.apache.pdfbox.rendering.PageDrawer.strokePath1-receiving.xml");
        Graphics2D mockGraphics2D = insertPrivateMockField_graphics_InPageDrawer(receivingObject);
        Path2D mockPath2D = insertPrivateMockField_linePath_InPageDrawer(receivingObject);
        // Act
        receivingObject.strokePath();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraphics2D, mockGraphics2D, mockGraphics2D, mockGraphics2D, mockPath2D);
//        orderVerifier.verify(mockGraphics2D, Mockito.times(1)).setComposite((java.awt.Composite) any());
//        orderVerifier.verify(mockGraphics2D, Mockito.times(1)).setPaint((java.awt.Paint) any());
//        orderVerifier.verify(mockGraphics2D, Mockito.times(1)).setStroke((java.awt.Stroke) any());
//        orderVerifier.verify(mockGraphics2D, Mockito.times(1)).draw((java.awt.Shape) any());
//        orderVerifier.verify(mockPath2D, Mockito.times(1)).reset();
    }
}