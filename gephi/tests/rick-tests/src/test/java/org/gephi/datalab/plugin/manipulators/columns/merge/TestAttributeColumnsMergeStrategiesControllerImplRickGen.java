package org.gephi.datalab.plugin.manipulators.columns.merge;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.gephi.datalab.impl.AttributeColumnsMergeStrategiesControllerImpl;
import org.gephi.graph.api.Column;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestAttributeColumnsMergeStrategiesControllerImplRickGen {
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
    @DisplayName("mergeDateColumnsToTimeInterval-1 with parameter oracle, mocking [org.gephi.graph.api.Column.getIndex(), java.text.DateFormat.setTimeZone(java.util.TimeZone)]")
    public void test_mergeDateColumnsToTimeInterval_PO_0fdc275bfe5d438382837f778a4e3eb8() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.AttributeColumnsMergeStrategiesControllerImpl/>";
        AttributeColumnsMergeStrategiesControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.datalab.impl.AttributeColumnsMergeStrategiesControllerImpl.mergeDateColumnsToTimeInterval1-params.xml");
        org.gephi.graph.api.Table paramObject1 = (org.gephi.graph.api.Table) paramObjects[0];
        org.gephi.graph.api.Column paramObject3 = (org.gephi.graph.api.Column) paramObjects[2];
        java.text.SimpleDateFormat paramObject4 = (java.text.SimpleDateFormat) paramObjects[3];
        String paramObject5 = (String) paramObjects[4];
        String paramObject6 = (String) paramObjects[5];
        SimpleDateFormat mockDateFormat = Mockito.mock(SimpleDateFormat.class);
        Column mockColumn = Mockito.mock(Column.class);
        Mockito.when(mockColumn.getIndex()).thenReturn(3);
        Mockito.when(mockColumn.getIndex()).thenReturn(4);
        Mockito.when(mockColumn.getIndex()).thenReturn(2);
        // Act
        receivingObject.mergeDateColumnsToTimeInterval(paramObject1, mockColumn, paramObject3, mockDateFormat, paramObject5, paramObject6);
        // Assert
        Mockito.verify(mockDateFormat, Mockito.atLeastOnce()).setTimeZone(any(java.util.TimeZone.class));
        Mockito.verify(mockColumn, Mockito.atLeastOnce()).getIndex();
    }

    @Test
    @DisplayName("mergeDateColumnsToTimeInterval-1 with call oracle, mocking [org.gephi.graph.api.Column.getIndex(), java.text.DateFormat.setTimeZone(java.util.TimeZone)]")
    public void test_mergeDateColumnsToTimeInterval_CO_0fdc275bfe5d438382837f778a4e3eb8() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.AttributeColumnsMergeStrategiesControllerImpl/>";
        AttributeColumnsMergeStrategiesControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.datalab.impl.AttributeColumnsMergeStrategiesControllerImpl.mergeDateColumnsToTimeInterval1-params.xml");
        org.gephi.graph.api.Table paramObject1 = (org.gephi.graph.api.Table) paramObjects[0];
        org.gephi.graph.api.Column paramObject3 = (org.gephi.graph.api.Column) paramObjects[2];
        java.text.SimpleDateFormat paramObject4 = (java.text.SimpleDateFormat) paramObjects[3];
        String paramObject5 = (String) paramObjects[4];
        String paramObject6 = (String) paramObjects[5];
        SimpleDateFormat mockDateFormat = Mockito.mock(SimpleDateFormat.class);
        Column mockColumn = Mockito.mock(Column.class);
        Mockito.when(mockColumn.getIndex()).thenReturn(3);
        Mockito.when(mockColumn.getIndex()).thenReturn(4);
        Mockito.when(mockColumn.getIndex()).thenReturn(2);
        // Act
        receivingObject.mergeDateColumnsToTimeInterval(paramObject1, mockColumn, paramObject3, mockDateFormat, paramObject5, paramObject6);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockDateFormat, mockColumn);
        orderVerifier.verify(mockDateFormat, Mockito.times(2)).setTimeZone((java.util.TimeZone) any());
        orderVerifier.verify(mockColumn, Mockito.times(10)).getIndex();
    }

    @Test
    @DisplayName("mergeNumericColumnsToTimeInterval-1 with parameter oracle, mocking [org.gephi.graph.api.Column.getIndex()]")
    public void test_mergeNumericColumnsToTimeInterval_PO_e30a6170a94e4ee1b4f910d197dc41d9() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.AttributeColumnsMergeStrategiesControllerImpl/>";
        AttributeColumnsMergeStrategiesControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.datalab.impl.AttributeColumnsMergeStrategiesControllerImpl.mergeNumericColumnsToTimeInterval1-params.xml");
        org.gephi.graph.api.Table paramObject1 = (org.gephi.graph.api.Table) paramObjects[0];
        org.gephi.graph.api.Column paramObject3 = (org.gephi.graph.api.Column) paramObjects[2];
        double paramObject4 = (Double) paramObjects[3];
        double paramObject5 = (Double) paramObjects[4];
        Column mockColumn = Mockito.mock(Column.class);
        Mockito.when(mockColumn.getIndex()).thenReturn(5);
        Mockito.when(mockColumn.getIndex()).thenReturn(6);
        Mockito.when(mockColumn.getIndex()).thenReturn(2);
        // Act
        receivingObject.mergeNumericColumnsToTimeInterval(paramObject1, mockColumn, paramObject3, paramObject4, paramObject5);
        // Assert
        Mockito.verify(mockColumn, Mockito.atLeastOnce()).getIndex();
    }

    @Test
    @DisplayName("mergeNumericColumnsToTimeInterval-1 with call oracle, mocking [org.gephi.graph.api.Column.getIndex()]")
    public void test_mergeNumericColumnsToTimeInterval_CO_e30a6170a94e4ee1b4f910d197dc41d9() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.AttributeColumnsMergeStrategiesControllerImpl/>";
        AttributeColumnsMergeStrategiesControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.datalab.impl.AttributeColumnsMergeStrategiesControllerImpl.mergeNumericColumnsToTimeInterval1-params.xml");
        org.gephi.graph.api.Table paramObject1 = (org.gephi.graph.api.Table) paramObjects[0];
        org.gephi.graph.api.Column paramObject3 = (org.gephi.graph.api.Column) paramObjects[2];
        double paramObject4 = (Double) paramObjects[3];
        double paramObject5 = (Double) paramObjects[4];
        Column mockColumn = Mockito.mock(Column.class);
        Mockito.when(mockColumn.getIndex()).thenReturn(5);
        Mockito.when(mockColumn.getIndex()).thenReturn(6);
        Mockito.when(mockColumn.getIndex()).thenReturn(2);
        // Act
        receivingObject.mergeNumericColumnsToTimeInterval(paramObject1, mockColumn, paramObject3, paramObject4, paramObject5);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockColumn);
        orderVerifier.verify(mockColumn, Mockito.times(10)).getIndex();
    }
}