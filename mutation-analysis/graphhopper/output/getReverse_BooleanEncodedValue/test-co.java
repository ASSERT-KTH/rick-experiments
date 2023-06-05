package com.graphhopper.routing.querygraph;

import com.graphhopper.routing.ev.BooleanEncodedValue;
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

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class TestVirtualEdgeIteratorStateRickGenGetReverse {
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
    @DisplayName("getReverse-1 with output oracle, mocking [com.graphhopper.routing.ev.BooleanEncodedValue.getBool(boolean,com.graphhopper.storage.IntsRef)]")
    public void test_getReverse_com_graphhopper_routing_ev_BooleanEncodedValue_OO_b12dd3110383436290287c4600ff025e() throws Exception {
        // Arrange
        VirtualEdgeIteratorState receivingObject = deserializeObjectFromFile("com.graphhopper.routing.querygraph.VirtualEdgeIteratorState.getReverse_com.graphhopper.routing.ev.BooleanEncodedValue1-receiving.xml");
        BooleanEncodedValue mockBooleanEncodedValue = Mockito.mock(BooleanEncodedValue.class);
        Mockito.when(mockBooleanEncodedValue.getBool(eq(false),   any(com.graphhopper.storage.IntsRef.class))).thenReturn(true);
        // Act
        boolean actual = receivingObject.getReverse(mockBooleanEncodedValue);
        // Assert
//         Assertions.assertEquals(true, actual);
    }

    @Test
    @DisplayName("getReverse-1 with parameter oracle, mocking [com.graphhopper.routing.ev.BooleanEncodedValue.getBool(boolean,com.graphhopper.storage.IntsRef)]")
    public void test_getReverse_com_graphhopper_routing_ev_BooleanEncodedValue_PO_b12dd3110383436290287c4600ff025e() throws Exception {
        // Arrange
        VirtualEdgeIteratorState receivingObject = deserializeObjectFromFile("com.graphhopper.routing.querygraph.VirtualEdgeIteratorState.getReverse_com.graphhopper.routing.ev.BooleanEncodedValue1-receiving.xml");
        BooleanEncodedValue mockBooleanEncodedValue = Mockito.mock(BooleanEncodedValue.class);
        Mockito.when(mockBooleanEncodedValue.getBool(eq(false),   any(com.graphhopper.storage.IntsRef.class))).thenReturn(true);
        // Act
        receivingObject.getReverse(mockBooleanEncodedValue);
        // Assert
//         Mockito.verify(mockBooleanEncodedValue, Mockito.atLeastOnce()).getBool(eq(false),   any(com.graphhopper.storage.IntsRef.class));
    }

    @Test
    @DisplayName("getReverse-1 with call oracle, mocking [com.graphhopper.routing.ev.BooleanEncodedValue.getBool(boolean,com.graphhopper.storage.IntsRef)]")
    public void test_getReverse_com_graphhopper_routing_ev_BooleanEncodedValue_CO_b12dd3110383436290287c4600ff025e() throws Exception {
        // Arrange
        VirtualEdgeIteratorState receivingObject = deserializeObjectFromFile("com.graphhopper.routing.querygraph.VirtualEdgeIteratorState.getReverse_com.graphhopper.routing.ev.BooleanEncodedValue1-receiving.xml");
        BooleanEncodedValue mockBooleanEncodedValue = Mockito.mock(BooleanEncodedValue.class);
        Mockito.when(mockBooleanEncodedValue.getBool(eq(false),   any(com.graphhopper.storage.IntsRef.class))).thenReturn(true);
        // Act
        receivingObject.getReverse(mockBooleanEncodedValue);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockBooleanEncodedValue);
        orderVerifier.verify(mockBooleanEncodedValue, Mockito.times(1)).getBool(anyBoolean(), (com.graphhopper.storage.IntsRef) any());
    }
}