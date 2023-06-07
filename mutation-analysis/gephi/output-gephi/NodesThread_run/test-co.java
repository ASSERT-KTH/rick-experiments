package org.gephi.layout.plugin.forceatlas2;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Scanner;

import org.gephi.layout.plugin.forceAtlas2.ForceFactory;
import org.gephi.layout.plugin.forceAtlas2.NodesThread;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class TestNodesThreadRickGen {
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

    private ForceFactory.RepulsionForce insertPrivateMockField_GravityForce_InNodesThread(NodesThread receivingObject) throws Exception {
        ForceFactory.RepulsionForce mockForceFactoryRepulsionForce = Mockito.mock(ForceFactory.RepulsionForce.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("GravityForce");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockForceFactoryRepulsionForce);
        return mockForceFactoryRepulsionForce;
    }

    private ForceFactory.RepulsionForce insertPrivateMockField_Repulsion_InNodesThread(NodesThread receivingObject) throws Exception {
        ForceFactory.RepulsionForce mockForceFactoryRepulsionForce = Mockito.mock(ForceFactory.RepulsionForce.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("Repulsion");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockForceFactoryRepulsionForce);
        return mockForceFactoryRepulsionForce;
    }

    @Test
    @DisplayName("run-3 with parameter oracle, mocking [org.gephi.layout.plugin.forceAtlas2.ForceFactory$RepulsionForce.apply(org.gephi.graph.api.Node,org.gephi.graph.api.Node), org.gephi.layout.plugin.forceAtlas2.ForceFactory$RepulsionForce.apply(org.gephi.graph.api.Node,double)]")
    public void test_run_PO_56f551132db74ce3ac5d11d2b75c084f() throws Exception {
        // Arrange
        NodesThread receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.forceAtlas2.NodesThread.run3-receiving.xml");
        ForceFactory.RepulsionForce mockForceFactoryRepulsionForce = insertPrivateMockField_Repulsion_InNodesThread(receivingObject);
        // Act
        receivingObject.run();
        // Assert
//         Mockito.verify(mockForceFactoryRepulsionForce, Mockito.atLeastOnce()).apply(any(org.gephi.graph.api.Node.class),   any(org.gephi.graph.api.Node.class));
    }

    @Test
    @DisplayName("run-3 with call oracle, mocking [org.gephi.layout.plugin.forceAtlas2.ForceFactory$RepulsionForce.apply(org.gephi.graph.api.Node,org.gephi.graph.api.Node), org.gephi.layout.plugin.forceAtlas2.ForceFactory$RepulsionForce.apply(org.gephi.graph.api.Node,double)]")
    public void test_run_CO_56f551132db74ce3ac5d11d2b75c084f() throws Exception {
        // Arrange
        NodesThread receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.forceAtlas2.NodesThread.run3-receiving.xml");
        ForceFactory.RepulsionForce mockForceFactoryRepulsionForce = insertPrivateMockField_Repulsion_InNodesThread(receivingObject);
        // Act
        receivingObject.run();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockForceFactoryRepulsionForce);
        orderVerifier.verify(mockForceFactoryRepulsionForce, Mockito.times(195)).apply((org.gephi.graph.api.Node) any(), (org.gephi.graph.api.Node) any());
    }
}