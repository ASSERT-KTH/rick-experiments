package org.apache.pdfbox.contentstream;

import com.thoughtworks.xstream.XStream;
import converters.FileCleanableConverter;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.util.Scanner;

@ExtendWith(MockitoExtension.class)
public class TestPDFStreamEngineRickGen {
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

    @BeforeAll
    public static void setxStream() {
        xStream.registerConverter(new FileCleanableConverter());
    }

    @Test
    @DisplayName("addOperator-1 with parameter oracle, mocking [org.apache.pdfbox.contentstream.operator.OperatorProcessor.getName()]")
    public void test_addOperator_PO_db991bce2164463f985326d9cbdc99c8() throws Exception {
        // Arrange
        org.apache.pdfbox.rendering.PageDrawer receivingObject = deserializeObjectFromFile("org.apache.pdfbox.contentstream.PDFStreamEngine.addOperator1-receiving.xml");
        OperatorProcessor mockOperatorProcessor = Mockito.mock(OperatorProcessor.class);
        Mockito.when(mockOperatorProcessor.getName()).thenReturn("b");
        // Act
        receivingObject.addOperator(mockOperatorProcessor);
        // Assert
//         Mockito.verify(mockOperatorProcessor, Mockito.atLeastOnce()).getName();
    }

    @Test
    @DisplayName("addOperator-1 with call oracle, mocking [org.apache.pdfbox.contentstream.operator.OperatorProcessor.getName()]")
    public void test_addOperator_CO_db991bce2164463f985326d9cbdc99c8() throws Exception {
        // Arrange
        org.apache.pdfbox.rendering.PageDrawer receivingObject = deserializeObjectFromFile("org.apache.pdfbox.contentstream.PDFStreamEngine.addOperator1-receiving.xml");
        OperatorProcessor mockOperatorProcessor = Mockito.mock(OperatorProcessor.class);
        Mockito.when(mockOperatorProcessor.getName()).thenReturn("b");
        // Act
        receivingObject.addOperator(mockOperatorProcessor);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockOperatorProcessor);
        orderVerifier.verify(mockOperatorProcessor, Mockito.times(1)).getName();
    }
}