package org.apache.pdfbox.pdmodel;

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

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestPDResourcesRickGenGetShading {
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


    private ResourceCache insertPrivateMockField_cache_InPDResources(PDResources receivingObject) throws Exception {
        ResourceCache mockResourceCache = Mockito.mock(ResourceCache.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("cache");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockResourceCache);
        return mockResourceCache;
    }

    @Test
    @DisplayName("getShading-1 with parameter oracle, mocking [org.apache.pdfbox.pdmodel.ResourceCache.put(org.apache.pdfbox.cos.COSObject,org.apache.pdfbox.pdmodel.graphics.shading.PDShading)]")
    public void test_getShading_PO_937e56fb456942fe90e0710baa52f9a1() throws Exception {
        // Arrange
        PDResources receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.PDResources.getShading1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.PDResources.getShading1-params.xml");
        org.apache.pdfbox.cos.COSName paramObject1 = (org.apache.pdfbox.cos.COSName) paramObjects[0];
        ResourceCache mockResourceCache = insertPrivateMockField_cache_InPDResources(receivingObject);
        // Act
        receivingObject.getShading(paramObject1);
        // Assert
//         Mockito.verify(mockResourceCache, Mockito.atLeastOnce()).put(any(org.apache.pdfbox.cos.COSObject.class),   any(org.apache.pdfbox.pdmodel.graphics.shading.PDShading.class));
    }

    @Test
    @DisplayName("getShading-1 with call oracle, mocking [org.apache.pdfbox.pdmodel.ResourceCache.put(org.apache.pdfbox.cos.COSObject,org.apache.pdfbox.pdmodel.graphics.shading.PDShading)]")
    public void test_getShading_CO_937e56fb456942fe90e0710baa52f9a1() throws Exception {
        // Arrange
        PDResources receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.PDResources.getShading1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.PDResources.getShading1-params.xml");
        org.apache.pdfbox.cos.COSName paramObject1 = (org.apache.pdfbox.cos.COSName) paramObjects[0];
        ResourceCache mockResourceCache = insertPrivateMockField_cache_InPDResources(receivingObject);
        // Act
        receivingObject.getShading(paramObject1);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockResourceCache);
        orderVerifier.verify(mockResourceCache, Mockito.times(1)).put((org.apache.pdfbox.cos.COSObject) any(), (org.apache.pdfbox.pdmodel.graphics.shading.PDShading) any());
    }
}