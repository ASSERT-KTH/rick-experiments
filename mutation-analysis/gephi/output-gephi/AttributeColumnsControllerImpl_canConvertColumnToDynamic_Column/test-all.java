package org.gephi.datalab.impl;

import com.thoughtworks.xstream.XStream;
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

import java.io.File;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class TestAttributeColumnsControllerImplRickGenCanConvertColumnToDynamic {
    static XStream xStream = new XStream();

    private <T> T deserializeObjectFromString(String serializedObjectString) {
        return (T) xStream.fromXML(serializedObjectString);
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
}