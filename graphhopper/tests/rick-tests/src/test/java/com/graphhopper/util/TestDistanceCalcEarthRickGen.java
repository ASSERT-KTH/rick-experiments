package com.graphhopper.util;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class TestDistanceCalcEarthRickGen {
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
    @DisplayName("calcDistance-1 with output oracle, mocking [com.graphhopper.util.PointList.getLat(int), com.graphhopper.util.PointList.getLon(int), com.graphhopper.util.PointList.getEle(int)]")
    public void test_calcDistance_OO_654ecfef5d1e457ba3752b4682533f2c() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<com.graphhopper.util.DistancePlaneProjection/>";
        com.graphhopper.util.DistancePlaneProjection receivingObject = deserializeObjectFromString(receivingObjectStr);
        PointList mockPointList = Mockito.mock(PointList.class);
        Mockito.when(mockPointList.getLat(0)).thenReturn(59.3602898);
        Mockito.when(mockPointList.getLon(0)).thenReturn(17.9892365);
        Mockito.when(mockPointList.getEle(0)).thenReturn(19.0);
        Mockito.when(mockPointList.getLat(1)).thenReturn(59.3601374);
        Mockito.when(mockPointList.getLon(1)).thenReturn(17.9885961);
        Mockito.when(mockPointList.getEle(1)).thenReturn(20.0);
        // Act
        double actual = receivingObject.calcDistance(mockPointList);
        // Assert
        Assertions.assertEquals(40.06503821537528, actual);
    }

    @Test
    @DisplayName("calcDistance-1 with parameter oracle, mocking [com.graphhopper.util.PointList.getLat(int), com.graphhopper.util.PointList.getLon(int), com.graphhopper.util.PointList.getEle(int)]")
    public void test_calcDistance_PO_654ecfef5d1e457ba3752b4682533f2c() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<com.graphhopper.util.DistancePlaneProjection/>";
        com.graphhopper.util.DistancePlaneProjection receivingObject = deserializeObjectFromString(receivingObjectStr);
        PointList mockPointList = Mockito.mock(PointList.class);
        Mockito.when(mockPointList.getLat(0)).thenReturn(59.3602898);
        Mockito.when(mockPointList.getLon(0)).thenReturn(17.9892365);
        Mockito.when(mockPointList.getEle(0)).thenReturn(19.0);
        Mockito.when(mockPointList.getLat(1)).thenReturn(59.3601374);
        Mockito.when(mockPointList.getLon(1)).thenReturn(17.9885961);
        Mockito.when(mockPointList.getEle(1)).thenReturn(20.0);
        // Act
        receivingObject.calcDistance(mockPointList);
        // Assert
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLat(0);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLon(0);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getEle(0);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLat(1);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getLon(1);
        Mockito.verify(mockPointList, Mockito.atLeastOnce()).getEle(1);
    }

    @Test
    @DisplayName("calcDistance-1 with call oracle, mocking [com.graphhopper.util.PointList.getLat(int), com.graphhopper.util.PointList.getLon(int), com.graphhopper.util.PointList.getEle(int)]")
    public void test_calcDistance_CO_654ecfef5d1e457ba3752b4682533f2c() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<com.graphhopper.util.DistancePlaneProjection/>";
        com.graphhopper.util.DistancePlaneProjection receivingObject = deserializeObjectFromString(receivingObjectStr);
        PointList mockPointList = Mockito.mock(PointList.class);
        Mockito.when(mockPointList.getLat(0)).thenReturn(59.3602898);
        Mockito.when(mockPointList.getLon(0)).thenReturn(17.9892365);
        Mockito.when(mockPointList.getEle(0)).thenReturn(19.0);
        Mockito.when(mockPointList.getLat(1)).thenReturn(59.3601374);
        Mockito.when(mockPointList.getLon(1)).thenReturn(17.9885961);
        Mockito.when(mockPointList.getEle(1)).thenReturn(20.0);
        // Act
        receivingObject.calcDistance(mockPointList);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockPointList, mockPointList, mockPointList, mockPointList, mockPointList, mockPointList);
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLat(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLon(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getEle(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLat(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLon(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getEle(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLat(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getLon(anyInt());
        orderVerifier.verify(mockPointList, Mockito.times(1)).getEle(anyInt());
    }
}