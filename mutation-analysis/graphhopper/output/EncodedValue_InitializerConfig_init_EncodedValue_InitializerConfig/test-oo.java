package com.graphhopper.routing.ev;

import com.thoughtworks.xstream.XStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class TestIntEncodedValueImplRickGen {
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
    @DisplayName("init-1 with output oracle, mocking [com.graphhopper.routing.ev.EncodedValue$InitializerConfig.next(int)]")
    public void test_init_OO_662703e4e83742d7975c6e2c1fcd6053() throws Exception {
        // Arrange
        SimpleBooleanEncodedValue receivingObject = deserializeObjectFromFile("com.graphhopper.routing.ev.IntEncodedValueImpl.init1-receiving.xml");
        EncodedValue.InitializerConfig mockEncodedValueInitializerConfig = Mockito.mock(EncodedValue.InitializerConfig.class);
        // Act
        int actual = receivingObject.init(mockEncodedValueInitializerConfig);
        // Assert
        Assertions.assertEquals(1, actual);
    }

    @Test
    @DisplayName("init-1 with parameter oracle, mocking [com.graphhopper.routing.ev.EncodedValue$InitializerConfig.next(int)]")
    public void test_init_PO_662703e4e83742d7975c6e2c1fcd6053() throws Exception {
        // Arrange
        SimpleBooleanEncodedValue receivingObject = deserializeObjectFromFile("com.graphhopper.routing.ev.IntEncodedValueImpl.init1-receiving.xml");
        EncodedValue.InitializerConfig mockEncodedValueInitializerConfig = Mockito.mock(EncodedValue.InitializerConfig.class);
        // Act
        receivingObject.init(mockEncodedValueInitializerConfig);
        // Assert
//         Mockito.verify(mockEncodedValueInitializerConfig, Mockito.atLeastOnce()).next(1);
    }

    @Test
    @DisplayName("init-1 with call oracle, mocking [com.graphhopper.routing.ev.EncodedValue$InitializerConfig.next(int)]")
    public void test_init_CO_662703e4e83742d7975c6e2c1fcd6053() throws Exception {
        // Arrange
        SimpleBooleanEncodedValue receivingObject = deserializeObjectFromFile("com.graphhopper.routing.ev.IntEncodedValueImpl.init1-receiving.xml");
        EncodedValue.InitializerConfig mockEncodedValueInitializerConfig = Mockito.mock(EncodedValue.InitializerConfig.class);
        // Act
        receivingObject.init(mockEncodedValueInitializerConfig);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockEncodedValueInitializerConfig);
//         orderVerifier.verify(mockEncodedValueInitializerConfig, Mockito.times(1)).next(anyInt());
    }
}