package org.apache.pdfbox.rendering;
import com.thoughtworks.xstream.XStream;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Scanner;

import converters.FileCleanableConverter;
import org.apache.pdfbox.pdmodel.graphics.image.PDImage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class TestPageDrawerRickGen {
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


    @Test
    @DisplayName("appendRectangle-1 with parameter oracle, mocking [java.awt.geom.Path2D$Float.moveTo(float,float), java.awt.geom.Path2D$Float.lineTo(float,float), java.awt.geom.Path2D.closePath(), java.awt.geom.Point2D.getX(), java.awt.geom.Point2D.getY()]")
    public void test_appendRectangle_PO_07c5938e25cd4651a9bd0c76f75e7699() throws Exception {
        // Arrange
        org.apache.pdfbox.rendering.PageDrawer receivingObject = deserializeObjectFromFile("org.apache.pdfbox.rendering.PageDrawer.appendRectangle1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.rendering.PageDrawer.appendRectangle1-params.xml");
        java.awt.geom.Point2D paramObject2 = (java.awt.geom.Point2D) paramObjects[1];
        java.awt.geom.Point2D paramObject3 = (java.awt.geom.Point2D) paramObjects[2];
        java.awt.geom.Point2D paramObject4 = (java.awt.geom.Point2D) paramObjects[3];
        Point2D mockPoint2D = Mockito.mock(Point2D.class);
        Path2D.Float mockPath2DFloat = insertPrivateMockField_linePath_InPageDrawer(receivingObject);
        Path2D mockPath2D = insertPrivateMockField_linePath_InPageDrawer(receivingObject);
        Mockito.when(mockPoint2D.getX()).thenReturn(199.8000030517578);
        Mockito.when(mockPoint2D.getY()).thenReturn(241.5);
        Mockito.when(mockPoint2D.getX()).thenReturn(271.79998779296875);
        Mockito.when(mockPoint2D.getY()).thenReturn(457.5);
        // Act
        receivingObject.appendRectangle(mockPoint2D, paramObject2, paramObject3, paramObject4);
        // Assert
        Mockito.verify(mockPoint2D, Mockito.atLeastOnce()).getX();
        Mockito.verify(mockPoint2D, Mockito.atLeastOnce()).getY();
        Mockito.verify(mockPath2DFloat, Mockito.atLeastOnce()).moveTo(199.8F,   241.5F);
        Mockito.verify(mockPath2DFloat, Mockito.atLeastOnce()).lineTo(271.8F,   241.5F);
        Mockito.verify(mockPath2DFloat, Mockito.atLeastOnce()).lineTo(271.8F,   457.5F);
        Mockito.verify(mockPath2DFloat, Mockito.atLeastOnce()).lineTo(199.8F,   457.5F);
        Mockito.verify(mockPath2D, Mockito.atLeastOnce()).closePath();
    }

    @Test
    @DisplayName("appendRectangle-1 with call oracle, mocking [java.awt.geom.Path2D$Float.moveTo(float,float), java.awt.geom.Path2D$Float.lineTo(float,float), java.awt.geom.Path2D.closePath(), java.awt.geom.Point2D.getX(), java.awt.geom.Point2D.getY()]")
    public void test_appendRectangle_CO_07c5938e25cd4651a9bd0c76f75e7699() throws Exception {
        // Arrange
        org.apache.pdfbox.rendering.PageDrawer receivingObject = deserializeObjectFromFile("org.apache.pdfbox.rendering.PageDrawer.appendRectangle1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.rendering.PageDrawer.appendRectangle1-params.xml");
        java.awt.geom.Point2D paramObject2 = (java.awt.geom.Point2D) paramObjects[1];
        java.awt.geom.Point2D paramObject3 = (java.awt.geom.Point2D) paramObjects[2];
        java.awt.geom.Point2D paramObject4 = (java.awt.geom.Point2D) paramObjects[3];
        Point2D mockPoint2D = Mockito.mock(Point2D.class);
        Path2D.Float mockPath2DFloat = insertPrivateMockField_linePath_InPageDrawer(receivingObject);
        Path2D mockPath2D = insertPrivateMockField_linePath_InPageDrawer(receivingObject);
        Mockito.when(mockPoint2D.getX()).thenReturn(199.8000030517578);
        Mockito.when(mockPoint2D.getY()).thenReturn(241.5);
        Mockito.when(mockPoint2D.getX()).thenReturn(271.79998779296875);
        Mockito.when(mockPoint2D.getY()).thenReturn(457.5);
        // Act
        receivingObject.appendRectangle(mockPoint2D, paramObject2, paramObject3, paramObject4);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockPoint2D, mockPoint2D, mockPath2DFloat, mockPath2DFloat, mockPath2DFloat, mockPath2DFloat, mockPath2D);
        orderVerifier.verify(mockPoint2D, Mockito.times(1)).getX();
        orderVerifier.verify(mockPoint2D, Mockito.times(1)).getY();
        orderVerifier.verify(mockPath2DFloat, Mockito.times(1)).moveTo(anyFloat(), anyFloat());
        orderVerifier.verify(mockPoint2D, Mockito.times(1)).getX();
        orderVerifier.verify(mockPoint2D, Mockito.times(1)).getY();
        orderVerifier.verify(mockPath2DFloat, Mockito.times(1)).lineTo(anyFloat(), anyFloat());
        orderVerifier.verify(mockPoint2D, Mockito.times(1)).getX();
        orderVerifier.verify(mockPoint2D, Mockito.times(1)).getY();
        orderVerifier.verify(mockPath2DFloat, Mockito.times(1)).lineTo(anyFloat(), anyFloat());
        orderVerifier.verify(mockPoint2D, Mockito.times(1)).getX();
        orderVerifier.verify(mockPoint2D, Mockito.times(1)).getY();
        orderVerifier.verify(mockPath2DFloat, Mockito.times(1)).lineTo(anyFloat(), anyFloat());
        orderVerifier.verify(mockPath2D, Mockito.times(1)).closePath();
    }

    private Graphics2D insertPrivateMockField_graphics_InPageDrawer(PageDrawer receivingObject) throws Exception {
        Graphics2D mockGraphics2D = Mockito.mock(Graphics2D.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("graphics");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockGraphics2D);
        return mockGraphics2D;
    }

    @Test
    @DisplayName("fillPath-1 with parameter oracle, mocking [java.awt.Graphics2D.setComposite(java.awt.Composite), java.awt.Graphics2D.setPaint(java.awt.Paint), java.awt.geom.Path2D.setWindingRule(int), java.awt.Graphics2D.setRenderingHint(java.awt.RenderingHints$Key,java.lang.Object), java.awt.Graphics2D.fill(java.awt.Shape), java.awt.geom.Path2D.reset()]")
    public void test_fillPath_PO_43d6ea955a4f4ed9949ef7d2019c5688() throws Exception {
        // Arrange
        org.apache.pdfbox.rendering.PageDrawer receivingObject = deserializeObjectFromFile("org.apache.pdfbox.rendering.PageDrawer.fillPath1-receiving.xml");
        Graphics2D mockGraphics2D = insertPrivateMockField_graphics_InPageDrawer(receivingObject);
        // Act
        receivingObject.fillPath(1);
        // Assert
        Mockito.verify(mockGraphics2D, Mockito.atLeastOnce()).setComposite(any(java.awt.Composite.class));
    }

    @Test
    @DisplayName("fillPath-1 with call oracle, mocking [java.awt.Graphics2D.setComposite(java.awt.Composite), java.awt.Graphics2D.setPaint(java.awt.Paint), java.awt.geom.Path2D.setWindingRule(int), java.awt.Graphics2D.setRenderingHint(java.awt.RenderingHints$Key,java.lang.Object), java.awt.Graphics2D.fill(java.awt.Shape), java.awt.geom.Path2D.reset()]")
    public void test_fillPath_CO_43d6ea955a4f4ed9949ef7d2019c5688() throws Exception {
        // Arrange
        org.apache.pdfbox.rendering.PageDrawer receivingObject = deserializeObjectFromFile("org.apache.pdfbox.rendering.PageDrawer.fillPath1-receiving.xml");
        Graphics2D mockGraphics2D = insertPrivateMockField_graphics_InPageDrawer(receivingObject);
        // Act
        receivingObject.fillPath(1);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraphics2D);
        orderVerifier.verify(mockGraphics2D, Mockito.times(1)).setComposite((java.awt.Composite) any());
    }

    @Test
    @DisplayName("strokePath-1 with parameter oracle, mocking [java.awt.Graphics2D.setComposite(java.awt.Composite), java.awt.Graphics2D.setPaint(java.awt.Paint), java.awt.Graphics2D.setStroke(java.awt.Stroke), java.awt.Graphics2D.draw(java.awt.Shape), java.awt.geom.Path2D.reset()]")
    public void test_strokePath_PO_555753857be74b738a876daa406fdfcf() throws Exception {
        // Arrange
        org.apache.pdfbox.rendering.PageDrawer receivingObject = deserializeObjectFromFile("org.apache.pdfbox.rendering.PageDrawer.strokePath1-receiving.xml");
        Graphics2D mockGraphics2D = insertPrivateMockField_graphics_InPageDrawer(receivingObject);
        Path2D mockPath2D = insertPrivateMockField_linePath_InPageDrawer(receivingObject);
        // Act
        receivingObject.strokePath();
        // Assert
        Mockito.verify(mockGraphics2D, Mockito.atLeastOnce()).setComposite(any(java.awt.Composite.class));
        Mockito.verify(mockGraphics2D, Mockito.atLeastOnce()).setPaint(any(java.awt.Paint.class));
        Mockito.verify(mockGraphics2D, Mockito.atLeastOnce()).setStroke(any(java.awt.Stroke.class));
        Mockito.verify(mockGraphics2D, Mockito.atLeastOnce()).draw(any(java.awt.Shape.class));
        Mockito.verify(mockPath2D, Mockito.atLeastOnce()).reset();
    }

    @Test
    @DisplayName("strokePath-1 with call oracle, mocking [java.awt.Graphics2D.setComposite(java.awt.Composite), java.awt.Graphics2D.setPaint(java.awt.Paint), java.awt.Graphics2D.setStroke(java.awt.Stroke), java.awt.Graphics2D.draw(java.awt.Shape), java.awt.geom.Path2D.reset()]")
    public void test_strokePath_CO_555753857be74b738a876daa406fdfcf() throws Exception {
        // Arrange
        org.apache.pdfbox.rendering.PageDrawer receivingObject = deserializeObjectFromFile("org.apache.pdfbox.rendering.PageDrawer.strokePath1-receiving.xml");
        Graphics2D mockGraphics2D = insertPrivateMockField_graphics_InPageDrawer(receivingObject);
        Path2D mockPath2D = insertPrivateMockField_linePath_InPageDrawer(receivingObject);
        // Act
        receivingObject.strokePath();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraphics2D, mockGraphics2D, mockGraphics2D, mockGraphics2D, mockPath2D);
        orderVerifier.verify(mockGraphics2D, Mockito.times(1)).setComposite((java.awt.Composite) any());
        orderVerifier.verify(mockGraphics2D, Mockito.times(1)).setPaint((java.awt.Paint) any());
        orderVerifier.verify(mockGraphics2D, Mockito.times(1)).setStroke((java.awt.Stroke) any());
        orderVerifier.verify(mockGraphics2D, Mockito.times(1)).draw((java.awt.Shape) any());
        orderVerifier.verify(mockPath2D, Mockito.times(1)).reset();
    }

    @Test
    @DisplayName("drawImage-1 with parameter oracle, mocking [java.awt.Graphics2D.setRenderingHint(java.awt.RenderingHints$Key,java.lang.Object), java.awt.Graphics2D.setComposite(java.awt.Composite), java.awt.Graphics2D.drawImage(java.awt.Image,java.awt.geom.AffineTransform,java.awt.image.ImageObserver), org.apache.pdfbox.pdmodel.graphics.image.PDImage.getInterpolate(), org.apache.pdfbox.pdmodel.graphics.image.PDImage.isStencil()]")
    public void test_drawImage_PO_1e563a915da2443ca43bcfc98ebcd62d() throws Exception {
        // Arrange
        org.apache.pdfbox.rendering.PageDrawer receivingObject = deserializeObjectFromFile("org.apache.pdfbox.rendering.PageDrawer.drawImage1-receiving.xml");
        PDImage mockPDImage = Mockito.mock(PDImage.class);
        Mockito.when(mockPDImage.getInterpolate()).thenReturn(false);
        Mockito.when(mockPDImage.isStencil()).thenReturn(false);
        // Act
        receivingObject.drawImage(mockPDImage);
        // Assert
        Mockito.verify(mockPDImage, Mockito.atLeastOnce()).getInterpolate();
        Mockito.verify(mockPDImage, Mockito.atLeastOnce()).isStencil();
    }

    @Test
    @DisplayName("drawImage-1 with call oracle, mocking [java.awt.Graphics2D.setRenderingHint(java.awt.RenderingHints$Key,java.lang.Object), java.awt.Graphics2D.setComposite(java.awt.Composite), java.awt.Graphics2D.drawImage(java.awt.Image,java.awt.geom.AffineTransform,java.awt.image.ImageObserver), org.apache.pdfbox.pdmodel.graphics.image.PDImage.getInterpolate(), org.apache.pdfbox.pdmodel.graphics.image.PDImage.isStencil()]")
    public void test_drawImage_CO_1e563a915da2443ca43bcfc98ebcd62d() throws Exception {
        // Arrange
        org.apache.pdfbox.rendering.PageDrawer receivingObject = deserializeObjectFromFile("org.apache.pdfbox.rendering.PageDrawer.drawImage1-receiving.xml");
        PDImage mockPDImage = Mockito.mock(PDImage.class);
        Mockito.when(mockPDImage.getInterpolate()).thenReturn(false);
        Mockito.when(mockPDImage.isStencil()).thenReturn(false);
        // Act
        receivingObject.drawImage(mockPDImage);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockPDImage, mockPDImage);
        orderVerifier.verify(mockPDImage, Mockito.times(1)).getInterpolate();
        orderVerifier.verify(mockPDImage, Mockito.times(3)).isStencil();
        orderVerifier.verify(mockPDImage, Mockito.times(1)).getInterpolate();
    }

    @Test
    @Disabled
    @DisplayName("drawPage-1 with parameter oracle, mocking [java.awt.Graphics2D.translate(double,double), java.awt.Graphics2D.scale(double,double)]")
    public void test_drawPage_PO_cbce7bdfd8f24075a8995f7a2a9e8404() throws Exception {
        // Arrange
        org.apache.pdfbox.rendering.PageDrawer receivingObject = deserializeObjectFromFile("org.apache.pdfbox.rendering.PageDrawer.drawPage1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.rendering.PageDrawer.drawPage1-params.xml");
        java.awt.Graphics paramObject1 = (java.awt.Graphics) paramObjects[0];
        org.apache.pdfbox.pdmodel.common.PDRectangle paramObject2 = (org.apache.pdfbox.pdmodel.common.PDRectangle) paramObjects[1];
        Graphics2D mockGraphics2D = insertPrivateMockField_graphics_InPageDrawer(receivingObject);
        // Act
        receivingObject.drawPage(paramObject1, paramObject2);
        // Assert
        Mockito.verify(mockGraphics2D, Mockito.atLeastOnce()).translate(0.0,   792.0);
        Mockito.verify(mockGraphics2D, Mockito.atLeastOnce()).scale(1.0,   -1.0);
        Mockito.verify(mockGraphics2D, Mockito.atLeastOnce()).translate(-0.0,   -0.0);
    }

    @Test
    @Disabled
    @DisplayName("drawPage-1 with call oracle, mocking [java.awt.Graphics2D.translate(double,double), java.awt.Graphics2D.scale(double,double)]")
    public void test_drawPage_CO_cbce7bdfd8f24075a8995f7a2a9e8404() throws Exception {
        // Arrange
        org.apache.pdfbox.rendering.PageDrawer receivingObject = deserializeObjectFromFile("org.apache.pdfbox.rendering.PageDrawer.drawPage1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.rendering.PageDrawer.drawPage1-params.xml");
        java.awt.Graphics paramObject1 = (java.awt.Graphics) paramObjects[0];
        org.apache.pdfbox.pdmodel.common.PDRectangle paramObject2 = (org.apache.pdfbox.pdmodel.common.PDRectangle) paramObjects[1];
        Graphics2D mockGraphics2D = insertPrivateMockField_graphics_InPageDrawer(receivingObject);
        // Act
        receivingObject.drawPage(paramObject1, paramObject2);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraphics2D, mockGraphics2D, mockGraphics2D);
        orderVerifier.verify(mockGraphics2D, Mockito.times(1)).translate(anyDouble(), anyDouble());
        orderVerifier.verify(mockGraphics2D, Mockito.times(1)).scale(anyDouble(), anyDouble());
        orderVerifier.verify(mockGraphics2D, Mockito.times(1)).translate(anyDouble(), anyDouble());
    }

    @Test
    @DisplayName("endPath-1 with parameter oracle, mocking [java.awt.geom.Path2D.setWindingRule(int), java.awt.geom.Path2D.reset()]")
    public void test_endPath_PO_d77007dd58194e4d9785a60c4ffa3dcb() throws Exception {
        // Arrange
        org.apache.pdfbox.rendering.PageDrawer receivingObject = deserializeObjectFromFile("org.apache.pdfbox.rendering.PageDrawer.endPath1-receiving.xml");
        Path2D mockPath2D = insertPrivateMockField_linePath_InPageDrawer(receivingObject);
        // Act
        receivingObject.endPath();
        // Assert
        Mockito.verify(mockPath2D, Mockito.atLeastOnce()).setWindingRule(0);
        Mockito.verify(mockPath2D, Mockito.atLeastOnce()).reset();
    }

    @Test
    @DisplayName("endPath-1 with call oracle, mocking [java.awt.geom.Path2D.setWindingRule(int), java.awt.geom.Path2D.reset()]")
    public void test_endPath_CO_d77007dd58194e4d9785a60c4ffa3dcb() throws Exception {
        // Arrange
        org.apache.pdfbox.rendering.PageDrawer receivingObject = deserializeObjectFromFile("org.apache.pdfbox.rendering.PageDrawer.endPath1-receiving.xml");
        Path2D mockPath2D = insertPrivateMockField_linePath_InPageDrawer(receivingObject);
        // Act
        receivingObject.endPath();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockPath2D, mockPath2D);
        orderVerifier.verify(mockPath2D, Mockito.times(1)).setWindingRule(anyInt());
        orderVerifier.verify(mockPath2D, Mockito.times(1)).reset();
    }
}