package org.gephi.datalab.impl;

import com.thoughtworks.xstream.XStream;
import org.gephi.graph.api.Table;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class TestAttributeColumnsControllerImplRickGenAddAttributeValue {
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

    @Test
    @DisplayName("addAttributeColumn-1 with parameter oracle, mocking [org.gephi.graph.api.Table.hasColumn(java.lang.String)]")
    public void test_addAttributeColumn_PO_90d981a76a35484289c1c5306979d22c() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.AttributeColumnsControllerImpl/>";
        AttributeColumnsControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.datalab.impl.AttributeColumnsControllerImpl.addAttributeColumn1-params.xml");
        String paramObject2 = (String) paramObjects[1];
        Class paramObject3 = (Class) paramObjects[2];
        Table mockTable = Mockito.mock(Table.class);
        Mockito.lenient().when(mockTable.hasColumn("type")).thenReturn(false);
        // Act
        receivingObject.addAttributeColumn(mockTable, paramObject2, paramObject3);
        // Assert
        Mockito.verify(mockTable, Mockito.atLeastOnce()).hasColumn("type");
    }

    @Test
    @DisplayName("addAttributeColumn-1 with call oracle, mocking [org.gephi.graph.api.Table.hasColumn(java.lang.String)]")
    public void test_addAttributeColumn_CO_90d981a76a35484289c1c5306979d22c() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.AttributeColumnsControllerImpl/>";
        AttributeColumnsControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.datalab.impl.AttributeColumnsControllerImpl.addAttributeColumn1-params.xml");
        String paramObject2 = (String) paramObjects[1];
        Class paramObject3 = (Class) paramObjects[2];
        Table mockTable = Mockito.mock(Table.class);
        Mockito.lenient().when(mockTable.hasColumn("type")).thenReturn(false);
        // Act
        receivingObject.addAttributeColumn(mockTable, paramObject2, paramObject3);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockTable);
//         orderVerifier.verify(mockTable, Mockito.times(1)).hasColumn(anyString());
    }
}