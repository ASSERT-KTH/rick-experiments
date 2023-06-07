package org.gephi.layout.plugin.force;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.util.Scanner;

import org.gephi.graph.api.Node;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyFloat;

@ExtendWith(MockitoExtension.class)
public class TestStepDisplacementRickGen {
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
    @DisplayName("moveNode-1 with parameter oracle, mocking [org.gephi.graph.api.NodeProperties.x(), org.gephi.graph.api.NodeProperties.y(), org.gephi.graph.api.NodeProperties.setX(float), org.gephi.graph.api.NodeProperties.setY(float)]")
    public void test_moveNode_PO_9b888ac8879c4f6383072dc6d8a70054() throws Exception {
        // Arrange
        org.gephi.layout.plugin.force.StepDisplacement receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.force.StepDisplacement.moveNode1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.layout.plugin.force.StepDisplacement.moveNode1-params.xml");
        org.gephi.layout.plugin.force.ForceVector paramObject2 = (org.gephi.layout.plugin.force.ForceVector) paramObjects[1];
        Node mockNodeProperties = Mockito.mock(Node.class);
        Mockito.when(mockNodeProperties.x()).thenReturn(-423.78378F);
        Mockito.when(mockNodeProperties.y()).thenReturn(107.523186F);
        // Act
        receivingObject.moveNode(mockNodeProperties, paramObject2);
        // Assert
        Mockito.verify(mockNodeProperties, Mockito.atLeastOnce()).x();
        Mockito.verify(mockNodeProperties, Mockito.atLeastOnce()).y();
        Mockito.verify(mockNodeProperties, Mockito.atLeastOnce()).setX(-403.92587F);
        Mockito.verify(mockNodeProperties, Mockito.atLeastOnce()).setY(105.14341F);
    }

    @Test
    @DisplayName("moveNode-1 with call oracle, mocking [org.gephi.graph.api.NodeProperties.x(), org.gephi.graph.api.NodeProperties.y(), org.gephi.graph.api.NodeProperties.setX(float), org.gephi.graph.api.NodeProperties.setY(float)]")
    public void test_moveNode_CO_9b888ac8879c4f6383072dc6d8a70054() throws Exception {
        // Arrange
        org.gephi.layout.plugin.force.StepDisplacement receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.force.StepDisplacement.moveNode1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.layout.plugin.force.StepDisplacement.moveNode1-params.xml");
        org.gephi.layout.plugin.force.ForceVector paramObject2 = (org.gephi.layout.plugin.force.ForceVector) paramObjects[1];
        Node mockNodeProperties = Mockito.mock(Node.class);
        Mockito.when(mockNodeProperties.x()).thenReturn(-423.78378F);
        Mockito.when(mockNodeProperties.y()).thenReturn(107.523186F);
        // Act
        receivingObject.moveNode(mockNodeProperties, paramObject2);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockNodeProperties, mockNodeProperties, mockNodeProperties, mockNodeProperties);
        orderVerifier.verify(mockNodeProperties, Mockito.times(1)).x();
        orderVerifier.verify(mockNodeProperties, Mockito.times(1)).y();
        orderVerifier.verify(mockNodeProperties, Mockito.times(1)).setX(anyFloat());
        orderVerifier.verify(mockNodeProperties, Mockito.times(1)).setY(anyFloat());
    }
}