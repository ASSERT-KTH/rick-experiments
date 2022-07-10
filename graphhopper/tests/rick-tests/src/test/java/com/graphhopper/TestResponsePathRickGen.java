package com.graphhopper;
import com.graphhopper.util.PointList;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class TestResponsePathRickGen {
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

    private PointList insertPrivateMockField_pointList_InResponsePath(ResponsePath receivingObject) throws Exception {
        PointList mockPointList = Mockito.mock(PointList.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("pointList");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockPointList);
        return mockPointList;
    }

    @Test
    @DisplayName("calcBBox2D-1 with parameter oracle, mocking [com.graphhopper.util.PointList.getLon(int), com.graphhopper.util.PointList.getLat(int)]")
    public void test_calcBBox2D_PO_daf569a4f66e46beaca9bb453ef2a95d() throws Exception {
        // Arrange
        com.graphhopper.ResponsePath receivingObject = deserializeObjectFromFile("com.graphhopper.ResponsePath.calcBBox2D1-receiving.xml");
        PointList mockPointList = insertPrivateMockField_pointList_InResponsePath(receivingObject);
        Mockito.when(mockPointList.getLon(0)).thenReturn(17.6350306);
        Mockito.when(mockPointList.getLat(0)).thenReturn(59.8634294);
        Mockito.when(mockPointList.getLon(1)).thenReturn(17.6349151);
        Mockito.when(mockPointList.getLat(1)).thenReturn(59.8634917);
        Mockito.when(mockPointList.getLon(2)).thenReturn(17.63615);
        Mockito.when(mockPointList.getLat(2)).thenReturn(59.8640177);
        Mockito.when(mockPointList.getLon(3)).thenReturn(17.6363003);
        Mockito.when(mockPointList.getLat(3)).thenReturn(59.8640706);
        Mockito.when(mockPointList.getLon(4)).thenReturn(17.6363644);
        Mockito.when(mockPointList.getLat(4)).thenReturn(59.8640698);
        Mockito.when(mockPointList.getLon(5)).thenReturn(17.6414145);
        Mockito.when(mockPointList.getLat(5)).thenReturn(59.8612819);
        Mockito.when(mockPointList.getLon(6)).thenReturn(17.6421947);
        Mockito.when(mockPointList.getLat(6)).thenReturn(59.8616889);
        Mockito.when(mockPointList.getLon(7)).thenReturn(17.6428848);
        Mockito.when(mockPointList.getLat(7)).thenReturn(59.862006);
        Mockito.when(mockPointList.getLon(8)).thenReturn(17.6443715);
        Mockito.when(mockPointList.getLat(8)).thenReturn(59.8611767);
        Mockito.when(mockPointList.getLon(9)).thenReturn(17.6447794);
        Mockito.when(mockPointList.getLat(9)).thenReturn(59.8610033);
        // Act
        receivingObject.calcBBox2D();
        // Assert
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLon(0);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLat(0);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLon(1);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLat(1);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLon(2);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLat(2);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLon(3);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLat(3);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLon(4);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLat(4);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLon(5);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLat(5);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLon(6);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLat(6);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLon(7);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLat(7);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLon(8);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLat(8);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLon(9);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLat(9);
    }

    @Test
    @DisplayName("calcBBox2D-1 with call oracle, mocking [com.graphhopper.util.PointList.getLon(int), com.graphhopper.util.PointList.getLat(int)]")
    public void test_calcBBox2D_CO_daf569a4f66e46beaca9bb453ef2a95d() throws Exception {
        // Arrange
        com.graphhopper.ResponsePath receivingObject = deserializeObjectFromFile("com.graphhopper.ResponsePath.calcBBox2D1-receiving.xml");
        PointList mockPointList = insertPrivateMockField_pointList_InResponsePath(receivingObject);
        Mockito.when(mockPointList.getLon(0)).thenReturn(17.6350306);
        Mockito.when(mockPointList.getLat(0)).thenReturn(59.8634294);
        Mockito.when(mockPointList.getLon(1)).thenReturn(17.6349151);
        Mockito.when(mockPointList.getLat(1)).thenReturn(59.8634917);
        Mockito.when(mockPointList.getLon(2)).thenReturn(17.63615);
        Mockito.when(mockPointList.getLat(2)).thenReturn(59.8640177);
        Mockito.when(mockPointList.getLon(3)).thenReturn(17.6363003);
        Mockito.when(mockPointList.getLat(3)).thenReturn(59.8640706);
        Mockito.when(mockPointList.getLon(4)).thenReturn(17.6363644);
        Mockito.when(mockPointList.getLat(4)).thenReturn(59.8640698);
        Mockito.when(mockPointList.getLon(5)).thenReturn(17.6414145);
        Mockito.when(mockPointList.getLat(5)).thenReturn(59.8612819);
        Mockito.when(mockPointList.getLon(6)).thenReturn(17.6421947);
        Mockito.when(mockPointList.getLat(6)).thenReturn(59.8616889);
        Mockito.when(mockPointList.getLon(7)).thenReturn(17.6428848);
        Mockito.when(mockPointList.getLat(7)).thenReturn(59.862006);
        Mockito.when(mockPointList.getLon(8)).thenReturn(17.6443715);
        Mockito.when(mockPointList.getLat(8)).thenReturn(59.8611767);
        Mockito.when(mockPointList.getLon(9)).thenReturn(17.6447794);
        Mockito.when(mockPointList.getLat(9)).thenReturn(59.8610033);
        // Act
        receivingObject.calcBBox2D();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockPointList, mockPointList, mockPointList, mockPointList, mockPointList, mockPointList, mockPointList, mockPointList, mockPointList, mockPointList, mockPointList, mockPointList, mockPointList, mockPointList, mockPointList, mockPointList, mockPointList, mockPointList, mockPointList, mockPointList);
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLon(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLat(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLon(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLat(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLon(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLat(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLon(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLat(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLon(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLat(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLon(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLat(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLon(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLat(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLon(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLat(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLon(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLat(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLon(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLat(anyInt());
    }
}