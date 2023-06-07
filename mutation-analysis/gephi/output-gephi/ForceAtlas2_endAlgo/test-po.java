package org.gephi.layout.plugin.forceatlas2;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

import org.gephi.graph.api.Graph;
import org.gephi.layout.plugin.forceAtlas2.ForceAtlas2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestForceAtlas2RickGen {
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

    private ExecutorService insertPrivateMockField_pool_InForceAtlas2(ForceAtlas2 receivingObject) throws Exception {
        ExecutorService mockExecutorService = Mockito.mock(ExecutorService.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("pool");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockExecutorService);
        return mockExecutorService;
    }

    @Test
    @DisplayName("endAlgo-1 with parameter oracle, mocking [java.util.concurrent.ExecutorService.shutdown()]")
    public void test_endAlgo_PO_3633b19e6785497688f72f8f09c8efd6() throws Exception {
        // Arrange
        ForceAtlas2 receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.forceAtlas2.ForceAtlas2.endAlgo1-receiving.xml");
        ExecutorService mockExecutorService = insertPrivateMockField_pool_InForceAtlas2(receivingObject);
        // Act
        receivingObject.endAlgo();
        // Assert
        Mockito.verify(mockExecutorService, Mockito.atLeastOnce()).shutdown();
    }

    @Test
    @DisplayName("endAlgo-1 with call oracle, mocking [java.util.concurrent.ExecutorService.shutdown()]")
    public void test_endAlgo_CO_3633b19e6785497688f72f8f09c8efd6() throws Exception {
        // Arrange
        ForceAtlas2 receivingObject = deserializeObjectFromFile("org.gephi.layout.plugin.forceAtlas2.ForceAtlas2.endAlgo1-receiving.xml");
        ExecutorService mockExecutorService = insertPrivateMockField_pool_InForceAtlas2(receivingObject);
        // Act
        receivingObject.endAlgo();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockExecutorService);
//         orderVerifier.verify(mockExecutorService, Mockito.times(1)).shutdown();
    }
}