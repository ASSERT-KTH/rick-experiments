package org.gephi.datalab.impl;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.util.Scanner;

import org.gephi.datalab.api.SearchReplaceController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class TestSearchReplaceControllerImplRickGen {
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
    @DisplayName("replaceAll-1 with output oracle, mocking [org.gephi.datalab.api.SearchReplaceController$SearchOptions.resetStatus()]")
    public void test_replaceAll_OO_3ffa029d19364a5caddf91d6d3643ace() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.SearchReplaceControllerImpl/>";
        SearchReplaceControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.datalab.impl.SearchReplaceControllerImpl.replaceAll1-params.xml");
        String paramObject2 = (String) paramObjects[1];
        SearchReplaceController.SearchOptions mockSearchReplaceControllerSearchOptions = Mockito.mock(SearchReplaceController.SearchOptions.class);
        // Act
        int actual = receivingObject.replaceAll(mockSearchReplaceControllerSearchOptions, paramObject2);
        // Assert
        Assertions.assertEquals(3, actual);
    }

    @Test
    @DisplayName("replaceAll-1 with parameter oracle, mocking [org.gephi.datalab.api.SearchReplaceController$SearchOptions.resetStatus()]")
    public void test_replaceAll_PO_3ffa029d19364a5caddf91d6d3643ace() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.SearchReplaceControllerImpl/>";
        SearchReplaceControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.datalab.impl.SearchReplaceControllerImpl.replaceAll1-params.xml");
        String paramObject2 = (String) paramObjects[1];
        SearchReplaceController.SearchOptions mockSearchReplaceControllerSearchOptions = Mockito.mock(SearchReplaceController.SearchOptions.class);
        // Act
        receivingObject.replaceAll(mockSearchReplaceControllerSearchOptions, paramObject2);
        // Assert
        Mockito.verify(mockSearchReplaceControllerSearchOptions, Mockito.atLeastOnce()).resetStatus();
    }

    @Test
    @DisplayName("replaceAll-1 with call oracle, mocking [org.gephi.datalab.api.SearchReplaceController$SearchOptions.resetStatus()]")
    public void test_replaceAll_CO_3ffa029d19364a5caddf91d6d3643ace() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.SearchReplaceControllerImpl/>";
        SearchReplaceControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.datalab.impl.SearchReplaceControllerImpl.replaceAll1-params.xml");
        String paramObject2 = (String) paramObjects[1];
        SearchReplaceController.SearchOptions mockSearchReplaceControllerSearchOptions = Mockito.mock(SearchReplaceController.SearchOptions.class);
        // Act
        receivingObject.replaceAll(mockSearchReplaceControllerSearchOptions, paramObject2);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockSearchReplaceControllerSearchOptions);
        orderVerifier.verify(mockSearchReplaceControllerSearchOptions, Mockito.times(1)).resetStatus();
    }
}