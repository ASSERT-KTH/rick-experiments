package org.gephi.preview.plugin.renderers;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.util.Scanner;

import converters.FileCleanableConverter;
import org.gephi.preview.api.PreviewProperties;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class TestNodeRendererRickGen {
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

    @Test
    @DisplayName("getCanvasSize-1 with parameter oracle, mocking [org.gephi.preview.api.PreviewProperties.getFloatValue(java.lang.String)]")
    public void test_getCanvasSize_PO_b286eddbe387428fb752619921096014() throws Exception {
        // Arrange
        NodeRenderer receivingObject = deserializeObjectFromFile("org.gephi.preview.plugin.renderers.NodeRenderer.getCanvasSize1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.preview.plugin.renderers.NodeRenderer.getCanvasSize1-params.xml");
        org.gephi.preview.api.Item paramObject1 = (org.gephi.preview.api.Item) paramObjects[0];
        PreviewProperties mockPreviewProperties = Mockito.mock(PreviewProperties.class);
        Mockito.when(mockPreviewProperties.getFloatValue("node.border.width")).thenReturn(1.0F);
        // Act
        receivingObject.getCanvasSize(paramObject1, mockPreviewProperties);
        // Assert
        Mockito.verify(mockPreviewProperties, Mockito.atLeastOnce()).getFloatValue("node.border.width");
    }

    @Test
    @DisplayName("getCanvasSize-1 with call oracle, mocking [org.gephi.preview.api.PreviewProperties.getFloatValue(java.lang.String)]")
    public void test_getCanvasSize_CO_b286eddbe387428fb752619921096014() throws Exception {
        // Arrange
        NodeRenderer receivingObject = deserializeObjectFromFile("org.gephi.preview.plugin.renderers.NodeRenderer.getCanvasSize1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.preview.plugin.renderers.NodeRenderer.getCanvasSize1-params.xml");
        org.gephi.preview.api.Item paramObject1 = (org.gephi.preview.api.Item) paramObjects[0];
        PreviewProperties mockPreviewProperties = Mockito.mock(PreviewProperties.class);
        Mockito.when(mockPreviewProperties.getFloatValue("node.border.width")).thenReturn(1.0F);
        // Act
        receivingObject.getCanvasSize(paramObject1, mockPreviewProperties);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockPreviewProperties);
        orderVerifier.verify(mockPreviewProperties, Mockito.times(1)).getFloatValue(anyString());
    }

    @Test
    @DisplayName("renderPDF-1 with parameter oracle, mocking [org.gephi.preview.api.PreviewProperties.getFloatValue(java.lang.String), org.gephi.preview.api.PreviewProperties.getBooleanValue(java.lang.String)]")
    public void test_renderPDF_PO_d8eb3a3013c14d05b7e99c12306df548() throws Exception {
        // Arrange
        NodeRenderer receivingObject = deserializeObjectFromFile("org.gephi.preview.plugin.renderers.NodeRenderer.renderPDF1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.preview.plugin.renderers.NodeRenderer.renderPDF1-params.xml");
        org.gephi.preview.api.Item paramObject1 = (org.gephi.preview.api.Item) paramObjects[0];
        org.gephi.preview.api.PDFTarget paramObject2 = (org.gephi.preview.api.PDFTarget) paramObjects[1];
        PreviewProperties mockPreviewProperties = Mockito.mock(PreviewProperties.class);
        Mockito.when(mockPreviewProperties.getFloatValue("node.border.width")).thenReturn(1.0F);
        Mockito.when(mockPreviewProperties.getBooleanValue("node.per.node.opacity")).thenReturn(false);
        Mockito.when(mockPreviewProperties.getFloatValue("node.opacity")).thenReturn(100.0F);
        // Act
        receivingObject.renderPDF(paramObject1, paramObject2, mockPreviewProperties);
        // Assert
        Mockito.verify(mockPreviewProperties, Mockito.atLeastOnce()).getFloatValue("node.border.width");
        Mockito.verify(mockPreviewProperties, Mockito.atLeastOnce()).getBooleanValue("node.per.node.opacity");
        Mockito.verify(mockPreviewProperties, Mockito.atLeastOnce()).getFloatValue("node.opacity");
    }

    @Test
    @DisplayName("renderPDF-1 with call oracle, mocking [org.gephi.preview.api.PreviewProperties.getFloatValue(java.lang.String), org.gephi.preview.api.PreviewProperties.getBooleanValue(java.lang.String)]")
    public void test_renderPDF_CO_d8eb3a3013c14d05b7e99c12306df548() throws Exception {
        // Arrange
        NodeRenderer receivingObject = deserializeObjectFromFile("org.gephi.preview.plugin.renderers.NodeRenderer.renderPDF1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.preview.plugin.renderers.NodeRenderer.renderPDF1-params.xml");
        org.gephi.preview.api.Item paramObject1 = (org.gephi.preview.api.Item) paramObjects[0];
        org.gephi.preview.api.PDFTarget paramObject2 = (org.gephi.preview.api.PDFTarget) paramObjects[1];
        PreviewProperties mockPreviewProperties = Mockito.mock(PreviewProperties.class);
        Mockito.when(mockPreviewProperties.getFloatValue("node.border.width")).thenReturn(1.0F);
        Mockito.when(mockPreviewProperties.getBooleanValue("node.per.node.opacity")).thenReturn(false);
        Mockito.when(mockPreviewProperties.getFloatValue("node.opacity")).thenReturn(100.0F);
        // Act
        receivingObject.renderPDF(paramObject1, paramObject2, mockPreviewProperties);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockPreviewProperties, mockPreviewProperties, mockPreviewProperties);
        orderVerifier.verify(mockPreviewProperties, Mockito.times(1)).getFloatValue(anyString());
        orderVerifier.verify(mockPreviewProperties, Mockito.times(1)).getBooleanValue(anyString());
        orderVerifier.verify(mockPreviewProperties, Mockito.times(1)).getFloatValue(anyString());
    }
}