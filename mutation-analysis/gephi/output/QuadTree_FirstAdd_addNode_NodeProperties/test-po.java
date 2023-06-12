package org.gephi.layout.plugin.force.quadtree;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.util.Scanner;

import org.gephi.graph.api.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class TestFirstAddRickGen {
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
    @DisplayName("addNode-1 with output oracle, mocking [org.gephi.graph.api.NodeProperties.x(), org.gephi.graph.api.NodeProperties.y()]")
    public void test_addNode_OO_e0615ea14343413da8ca6de8a9a1e2fa() throws Exception {
        // Arrange
        QuadTree.FirstAdd receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.force.quadtree.QuadTree$FirstAdd.addNode1-receiving.xml");
        Node mockNodeProperties = Mockito.mock(Node.class);
        Mockito.lenient().when(mockNodeProperties.x()).thenReturn(-423.78378F);
        Mockito.lenient().when(mockNodeProperties.y()).thenReturn(107.523186F);
        // Act
        boolean actual = receivingObject.addNode(mockNodeProperties);
        // Assert
//         Assertions.assertEquals(true, actual);
    }

    @Test
    @DisplayName("addNode-1 with parameter oracle, mocking [org.gephi.graph.api.NodeProperties.x(), org.gephi.graph.api.NodeProperties.y()]")
    public void test_addNode_PO_e0615ea14343413da8ca6de8a9a1e2fa() throws Exception {
        // Arrange
        QuadTree.FirstAdd receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.force.quadtree.QuadTree$FirstAdd.addNode1-receiving.xml");
        Node mockNodeProperties = Mockito.mock(Node.class);
        Mockito.lenient().when(mockNodeProperties.x()).thenReturn(-423.78378F);
        Mockito.lenient().when(mockNodeProperties.y()).thenReturn(107.523186F);
        // Act
        receivingObject.addNode(mockNodeProperties);
        // Assert
        Mockito.verify(mockNodeProperties, Mockito.atLeastOnce()).x();
        Mockito.verify(mockNodeProperties, Mockito.atLeastOnce()).y();
    }

    @Test
    @DisplayName("addNode-1 with call oracle, mocking [org.gephi.graph.api.NodeProperties.x(), org.gephi.graph.api.NodeProperties.y()]")
    public void test_addNode_CO_e0615ea14343413da8ca6de8a9a1e2fa() throws Exception {
        // Arrange
        QuadTree.FirstAdd receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.force.quadtree.QuadTree$FirstAdd.addNode1-receiving.xml");
        Node mockNodeProperties = Mockito.mock(Node.class);
        Mockito.lenient().when(mockNodeProperties.x()).thenReturn(-423.78378F);
        Mockito.lenient().when(mockNodeProperties.y()).thenReturn(107.523186F);
        // Act
        receivingObject.addNode(mockNodeProperties);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockNodeProperties, mockNodeProperties);
//         orderVerifier.verify(mockNodeProperties, Mockito.times(1)).x();
//         orderVerifier.verify(mockNodeProperties, Mockito.times(1)).y();
    }
}