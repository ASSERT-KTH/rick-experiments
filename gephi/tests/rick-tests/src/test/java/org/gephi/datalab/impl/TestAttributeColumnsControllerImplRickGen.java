package org.gephi.datalab.impl;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.util.Scanner;

import org.gephi.graph.api.Column;
import org.gephi.graph.api.Element;
import org.gephi.graph.api.Table;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class TestAttributeColumnsControllerImplRickGen {
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
    @DisplayName("canClearColumnData-1 with output oracle, mocking [org.gephi.graph.api.Column.getId(), org.gephi.graph.api.Column.isReadOnly()]")
    public void test_canClearColumnData_OO_f4dc0aa00d034745b0a3f656925fec59() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.AttributeColumnsControllerImpl/>";
        AttributeColumnsControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Column mockColumn = Mockito.mock(Column.class);
        Mockito.when(mockColumn.isReadOnly()).thenReturn(true);
        // Act
        boolean actual = receivingObject.canClearColumnData(mockColumn);
        // Assert
        Assertions.assertEquals(false, actual);
    }

    @Test
    @DisplayName("canClearColumnData-1 with parameter oracle, mocking [org.gephi.graph.api.Column.getId(), org.gephi.graph.api.Column.isReadOnly()]")
    public void test_canClearColumnData_PO_f4dc0aa00d034745b0a3f656925fec59() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.AttributeColumnsControllerImpl/>";
        AttributeColumnsControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Column mockColumn = Mockito.mock(Column.class);
        Mockito.when(mockColumn.isReadOnly()).thenReturn(true);
        // Act
        receivingObject.canClearColumnData(mockColumn);
        // Assert
        Mockito.verify(mockColumn, Mockito.atLeastOnce()).isReadOnly();
    }

    @Test
    @DisplayName("canClearColumnData-1 with call oracle, mocking [org.gephi.graph.api.Column.getId(), org.gephi.graph.api.Column.isReadOnly()]")
    public void test_canClearColumnData_CO_f4dc0aa00d034745b0a3f656925fec59() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.AttributeColumnsControllerImpl/>";
        AttributeColumnsControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Column mockColumn = Mockito.mock(Column.class);
        Mockito.when(mockColumn.isReadOnly()).thenReturn(true);
        // Act
        receivingObject.canClearColumnData(mockColumn);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockColumn);
        orderVerifier.verify(mockColumn, Mockito.times(1)).isReadOnly();
    }

    @Test
    @DisplayName("canConvertColumnToDynamic-1 with output oracle, mocking [org.gephi.graph.api.Column.isReadOnly(), org.gephi.graph.api.Column.getTitle()]")
    public void test_canConvertColumnToDynamic_OO_e4997630d1334c0f868c228ee62fdd8f() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.AttributeColumnsControllerImpl/>";
        AttributeColumnsControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Column mockColumn = Mockito.mock(Column.class);
        Mockito.when(mockColumn.isReadOnly()).thenReturn(true);
        // Act
        boolean actual = receivingObject.canConvertColumnToDynamic(mockColumn);
        // Assert
        Assertions.assertEquals(false, actual);
    }

    @Test
    @DisplayName("canConvertColumnToDynamic-1 with parameter oracle, mocking [org.gephi.graph.api.Column.isReadOnly(), org.gephi.graph.api.Column.getTitle()]")
    public void test_canConvertColumnToDynamic_PO_e4997630d1334c0f868c228ee62fdd8f() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.AttributeColumnsControllerImpl/>";
        AttributeColumnsControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Column mockColumn = Mockito.mock(Column.class);
        Mockito.when(mockColumn.isReadOnly()).thenReturn(true);
        // Act
        receivingObject.canConvertColumnToDynamic(mockColumn);
        // Assert
        Mockito.verify(mockColumn, Mockito.atLeastOnce()).isReadOnly();
    }

    @Test
    @DisplayName("canConvertColumnToDynamic-1 with call oracle, mocking [org.gephi.graph.api.Column.isReadOnly(), org.gephi.graph.api.Column.getTitle()]")
    public void test_canConvertColumnToDynamic_CO_e4997630d1334c0f868c228ee62fdd8f() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.AttributeColumnsControllerImpl/>";
        AttributeColumnsControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Column mockColumn = Mockito.mock(Column.class);
        Mockito.when(mockColumn.isReadOnly()).thenReturn(true);
        // Act
        receivingObject.canConvertColumnToDynamic(mockColumn);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockColumn);
        orderVerifier.verify(mockColumn, Mockito.times(1)).isReadOnly();
    }

    @Test
    @DisplayName("setAttributeValue-1 with output oracle, mocking [org.gephi.graph.api.Element.setAttribute(org.gephi.graph.api.Column,java.lang.Object)]")
    public void test_setAttributeValue_OO_ba5b7f668e6b4148bc414ade77365be1() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.AttributeColumnsControllerImpl/>";
        AttributeColumnsControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.datalab.impl.AttributeColumnsControllerImpl.setAttributeValue1-params.xml");
        Object paramObject1 = (Object) paramObjects[0];
        org.gephi.graph.api.Column paramObject3 = (org.gephi.graph.api.Column) paramObjects[2];
        Element mockElement = Mockito.mock(Element.class);
        // Act
        boolean actual = receivingObject.setAttributeValue(paramObject1, mockElement, paramObject3);
        // Assert
        Assertions.assertEquals(true, actual);
    }

    @Test
    @DisplayName("setAttributeValue-1 with parameter oracle, mocking [org.gephi.graph.api.Element.setAttribute(org.gephi.graph.api.Column,java.lang.Object)]")
    public void test_setAttributeValue_PO_ba5b7f668e6b4148bc414ade77365be1() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.AttributeColumnsControllerImpl/>";
        AttributeColumnsControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.datalab.impl.AttributeColumnsControllerImpl.setAttributeValue1-params.xml");
        Object paramObject1 = (Object) paramObjects[0];
        org.gephi.graph.api.Column paramObject3 = (org.gephi.graph.api.Column) paramObjects[2];
        Element mockElement = Mockito.mock(Element.class);
        // Act
        receivingObject.setAttributeValue(paramObject1, mockElement, paramObject3);
        // Assert
        Mockito.verify(mockElement, Mockito.atLeastOnce()).setAttribute(any(org.gephi.graph.api.Column.class),   any(Object.class));
    }

    @Test
    @DisplayName("setAttributeValue-1 with call oracle, mocking [org.gephi.graph.api.Element.setAttribute(org.gephi.graph.api.Column,java.lang.Object)]")
    public void test_setAttributeValue_CO_ba5b7f668e6b4148bc414ade77365be1() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.AttributeColumnsControllerImpl/>";
        AttributeColumnsControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.datalab.impl.AttributeColumnsControllerImpl.setAttributeValue1-params.xml");
        Object paramObject1 = (Object) paramObjects[0];
        org.gephi.graph.api.Column paramObject3 = (org.gephi.graph.api.Column) paramObjects[2];
        Element mockElement = Mockito.mock(Element.class);
        // Act
        receivingObject.setAttributeValue(paramObject1, mockElement, paramObject3);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockElement);
        orderVerifier.verify(mockElement, Mockito.times(1)).setAttribute((org.gephi.graph.api.Column) any(), (Object) any());
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
        Mockito.when(mockTable.hasColumn("type")).thenReturn(false);
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
        Mockito.when(mockTable.hasColumn("type")).thenReturn(false);
        // Act
        receivingObject.addAttributeColumn(mockTable, paramObject2, paramObject3);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockTable);
        orderVerifier.verify(mockTable, Mockito.times(1)).hasColumn(anyString());
    }
}