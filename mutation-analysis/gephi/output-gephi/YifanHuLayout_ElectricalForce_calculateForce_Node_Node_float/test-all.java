package org.gephi.layout.plugin.force.yifanHu;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.util.Scanner;

import org.gephi.graph.api.Node;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class TestElectricalForceRickGen {
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
    @DisplayName("calculateForce-1 with parameter oracle, mocking [org.gephi.graph.api.NodeProperties.x(), org.gephi.graph.api.NodeProperties.y()]")
    public void test_calculateForce_PO_d0210372b49f4df5ae7d0bf8d546afe7() throws Exception {
        // Arrange
        YifanHuLayout.ElectricalForce receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.force.yifanHu.YifanHuLayout$ElectricalForce.calculateForce1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.layout.plugin.force.yifanHu.YifanHuLayout$ElectricalForce.calculateForce1-params.xml");
        org.gephi.graph.api.Node paramObject2 = (org.gephi.graph.api.Node) paramObjects[1];
        float paramObject3 = (Float) paramObjects[2];
        Node mockNodeProperties = Mockito.mock(Node.class);
        Mockito.when(mockNodeProperties.x()).thenReturn(252.96294F);
        Mockito.when(mockNodeProperties.x()).thenReturn(-423.78378F);
        Mockito.when(mockNodeProperties.y()).thenReturn(242.71686F);
        Mockito.when(mockNodeProperties.y()).thenReturn(107.523186F);
        // Act
        receivingObject.calculateForce(mockNodeProperties, paramObject2, paramObject3);
        // Assert
        Mockito.verify(mockNodeProperties, Mockito.atLeastOnce()).x();
        Mockito.verify(mockNodeProperties, Mockito.atLeastOnce()).y();
    }

    @Test
    @Disabled
    @DisplayName("calculateForce-1 with call oracle, mocking [org.gephi.graph.api.NodeProperties.x(), org.gephi.graph.api.NodeProperties.y()]")
    public void test_calculateForce_CO_d0210372b49f4df5ae7d0bf8d546afe7() throws Exception {
        // Arrange
        YifanHuLayout.ElectricalForce receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.force.yifanHu.YifanHuLayout$ElectricalForce.calculateForce1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.layout.plugin.force.yifanHu.YifanHuLayout$ElectricalForce.calculateForce1-params.xml");
        org.gephi.graph.api.Node paramObject2 = (org.gephi.graph.api.Node) paramObjects[1];
        float paramObject3 = (Float) paramObjects[2];
        Node mockNodeProperties = Mockito.mock(Node.class);
        Mockito.when(mockNodeProperties.x()).thenReturn(252.96294F);
        Mockito.when(mockNodeProperties.x()).thenReturn(-423.78378F);
        Mockito.when(mockNodeProperties.y()).thenReturn(242.71686F);
        Mockito.when(mockNodeProperties.y()).thenReturn(107.523186F);
        // Act
        receivingObject.calculateForce(mockNodeProperties, paramObject2, paramObject3);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockNodeProperties, mockNodeProperties);
        orderVerifier.verify(mockNodeProperties, Mockito.times(2)).x();
        orderVerifier.verify(mockNodeProperties, Mockito.times(2)).y();
    }
}