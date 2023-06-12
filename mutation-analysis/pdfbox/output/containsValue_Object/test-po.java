package org.apache.pdfbox.cos;

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

import java.io.File;
import java.util.Map;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestCOSDictionaryRickGen {
    static XStream xStream = new XStream();

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

    private Map insertMockField_items_InCOSDictionary(COSDictionary receivingObject) {
        Map mockMap = Mockito.mock(Map.class);
        receivingObject.items = mockMap;
        return mockMap;
    }

    @Test
    @DisplayName("containsValue-1 with output oracle, mocking [java.util.Map.containsValue(java.lang.Object)]")
    public void test_containsValue_OO_c95180141c994177881533f75c8fc078() throws Exception {
        // Arrange
        COSDictionary receivingObject = deserializeObjectFromFile("org.apache.pdfbox.cos.COSDictionary.containsValue1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.cos.COSDictionary.containsValue1-params.xml");
        Object paramObject1 = (Object) paramObjects[0];
        Map mockMap = insertMockField_items_InCOSDictionary(receivingObject);
        Mockito.lenient().when(mockMap.containsValue(any(Object.class))).thenReturn(false);
        // Act
        boolean actual = receivingObject.containsValue(paramObject1);
        // Assert
//         Assertions.assertEquals(false, actual);
    }

    @Test
    @DisplayName("containsValue-1 with parameter oracle, mocking [java.util.Map.containsValue(java.lang.Object)]")
    public void test_containsValue_PO_c95180141c994177881533f75c8fc078() throws Exception {
        // Arrange
        COSDictionary receivingObject = deserializeObjectFromFile("org.apache.pdfbox.cos.COSDictionary.containsValue1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.cos.COSDictionary.containsValue1-params.xml");
        Object paramObject1 = (Object) paramObjects[0];
        Map mockMap = insertMockField_items_InCOSDictionary(receivingObject);
        Mockito.lenient().when(mockMap.containsValue(any(Object.class))).thenReturn(false);
        // Act
        receivingObject.containsValue(paramObject1);
        // Assert
        Mockito.verify(mockMap, Mockito.atLeastOnce()).containsValue(any(Object.class));
    }

    @Test
    @DisplayName("containsValue-1 with call oracle, mocking [java.util.Map.containsValue(java.lang.Object)]")
    public void test_containsValue_CO_c95180141c994177881533f75c8fc078() throws Exception {
        // Arrange
        COSDictionary receivingObject = deserializeObjectFromFile("org.apache.pdfbox.cos.COSDictionary.containsValue1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.cos.COSDictionary.containsValue1-params.xml");
        Object paramObject1 = (Object) paramObjects[0];
        Map mockMap = insertMockField_items_InCOSDictionary(receivingObject);
        Mockito.lenient().when(mockMap.containsValue(any(Object.class))).thenReturn(false);
        // Act
        receivingObject.containsValue(paramObject1);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockMap);
//         orderVerifier.verify(mockMap, Mockito.times(1)).containsValue((Object) any());
    }
}