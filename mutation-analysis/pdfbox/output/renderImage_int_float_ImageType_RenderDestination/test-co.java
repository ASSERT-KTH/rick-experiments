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

import java.io.File;
import java.util.Scanner;

@ExtendWith(MockitoExtension.class)
public class TestPDFRendererRickGen {
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
    @DisplayName("renderImage-2 with parameter oracle, mocking [org.apache.pdfbox.rendering.ImageType.toBufferedImageType()]")
    public void test_renderImage_int_float_org_apache_pdfbox_rendering_ImageType_org_apache_pdfbox_rendering_RenderDestination_PO_72766de41c1044109d0d525c020cdd77() throws Exception {
        // Arrange
        PDFRenderer receivingObject = deserializeObjectFromFile("org.apache.pdfbox.rendering.PDFRenderer.renderImage_int,float,org.apache.pdfbox.rendering.ImageType,org.apache.pdfbox.rendering.RenderDestination2-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.rendering.PDFRenderer.renderImage_int,float,org.apache.pdfbox.rendering.ImageType,org.apache.pdfbox.rendering.RenderDestination2-params.xml");
        int paramObject1 = (Integer) paramObjects[0];
        float paramObject2 = (Float) paramObjects[1];
        RenderDestination paramObject4 = (RenderDestination) paramObjects[3];
        ImageType mockImageType = Mockito.mock(ImageType.class);
        Mockito.lenient().when(mockImageType.toBufferedImageType()).thenReturn(1);
        // Act
        receivingObject.renderImage(paramObject1, paramObject2, mockImageType, paramObject4);
        // Assert
//         Mockito.verify(mockImageType, Mockito.atLeastOnce()).toBufferedImageType();
    }

    @Test
    @DisplayName("renderImage-2 with call oracle, mocking [org.apache.pdfbox.rendering.ImageType.toBufferedImageType()]")
    public void test_renderImage_int_float_org_apache_pdfbox_rendering_ImageType_org_apache_pdfbox_rendering_RenderDestination_CO_72766de41c1044109d0d525c020cdd77() throws Exception {
        // Arrange
        PDFRenderer receivingObject = deserializeObjectFromFile("org.apache.pdfbox.rendering.PDFRenderer.renderImage_int,float,org.apache.pdfbox.rendering.ImageType,org.apache.pdfbox.rendering.RenderDestination2-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.rendering.PDFRenderer.renderImage_int,float,org.apache.pdfbox.rendering.ImageType,org.apache.pdfbox.rendering.RenderDestination2-params.xml");
        int paramObject1 = (Integer) paramObjects[0];
        float paramObject2 = (Float) paramObjects[1];
        RenderDestination paramObject4 = (RenderDestination) paramObjects[3];
        ImageType mockImageType = Mockito.mock(ImageType.class);
        Mockito.lenient().when(mockImageType.toBufferedImageType()).thenReturn(1);
        // Act
        receivingObject.renderImage(paramObject1, paramObject2, mockImageType, paramObject4);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockImageType);
        orderVerifier.verify(mockImageType, Mockito.times(2)).toBufferedImageType();
    }
}