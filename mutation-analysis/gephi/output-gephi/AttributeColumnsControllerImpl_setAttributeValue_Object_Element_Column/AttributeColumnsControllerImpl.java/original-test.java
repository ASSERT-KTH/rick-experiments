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
public class TestAttributeColumnsControllerImplRickGenSetAttributeValue {
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
    @DisplayName("setAttributeValue-1 with output oracle, mocking [org.gephi.graph.api.Element.setAttribute(org.gephi.graph.api.Column,java.lang.Object)]")
    public void test_setAttributeValue_OO_ba5b7f668e6b4148bc414ade77365be1() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.AttributeColumnsControllerImpl/>";
        AttributeColumnsControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.datalab.impl.AttributeColumnsControllerImpl.setAttributeValue1-params.xml");
        Object paramObject1 = (Object) paramObjects[0];
        Column paramObject3 = (Column) paramObjects[2];
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
        Column paramObject3 = (Column) paramObjects[2];
        Element mockElement = Mockito.mock(Element.class);
        // Act
        receivingObject.setAttributeValue(paramObject1, mockElement, paramObject3);
        // Assert
        Mockito.verify(mockElement, Mockito.atLeastOnce()).setAttribute(any(Column.class),   any(Object.class));
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
        Column paramObject3 = (Column) paramObjects[2];
        Element mockElement = Mockito.mock(Element.class);
        // Act
        receivingObject.setAttributeValue(paramObject1, mockElement, paramObject3);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockElement);
        orderVerifier.verify(mockElement, Mockito.times(1)).setAttribute((Column) any(), (Object) any());
    }
}