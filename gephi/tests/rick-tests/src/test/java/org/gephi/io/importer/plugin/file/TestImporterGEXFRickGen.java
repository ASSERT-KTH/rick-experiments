package org.gephi.io.importer.plugin.file;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Scanner;
import javax.xml.stream.XMLStreamReader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class TestImporterGEXFRickGen {
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

    private XMLStreamReader insertPrivateMockField_xmlReader_InImporterGEXF(ImporterGEXF receivingObject) throws Exception {
        XMLStreamReader mockXMLStreamReader = Mockito.mock(XMLStreamReader.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("xmlReader");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockXMLStreamReader);
        return mockXMLStreamReader;
    }

    @Test
    @DisplayName("execute-1 with output oracle, mocking [javax.xml.stream.XMLStreamReader.hasNext(), javax.xml.stream.XMLStreamReader.next(), javax.xml.stream.XMLStreamReader.getLocalName(), javax.xml.stream.XMLStreamReader.close()]")
    public void test_execute_OO_ff17d438970544afacf562bacbe1108b() throws Exception {
        // Arrange
        ImporterGEXF receivingObject = deserializeObjectFromFile("org.gephi.io.importer.plugin.file.ImporterGEXF.execute1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.io.importer.plugin.file.ImporterGEXF.execute1-params.xml");
        org.gephi.io.importer.api.ContainerLoader paramObject1 = (org.gephi.io.importer.api.ContainerLoader) paramObjects[0];
        XMLStreamReader mockXMLStreamReader = insertPrivateMockField_xmlReader_InImporterGEXF(receivingObject);
        Mockito.when(mockXMLStreamReader.hasNext()).thenReturn(true);
        Mockito.when(mockXMLStreamReader.next()).thenReturn(1);
        Mockito.when(mockXMLStreamReader.getLocalName()).thenReturn("gexf");
        Mockito.when(mockXMLStreamReader.next()).thenReturn(4);
        Mockito.when(mockXMLStreamReader.getLocalName()).thenReturn("meta");
        Mockito.when(mockXMLStreamReader.getLocalName()).thenReturn("creator");
        Mockito.when(mockXMLStreamReader.next()).thenReturn(2);
        Mockito.when(mockXMLStreamReader.getLocalName()).thenReturn("description");
        Mockito.when(mockXMLStreamReader.getLocalName()).thenReturn("keywords");
        Mockito.when(mockXMLStreamReader.getLocalName()).thenReturn("graph");
        // Act
        boolean actual = receivingObject.execute(paramObject1);
        // Assert
        Assertions.assertEquals(true, actual);
    }

    @Test
    @DisplayName("execute-1 with parameter oracle, mocking [javax.xml.stream.XMLStreamReader.hasNext(), javax.xml.stream.XMLStreamReader.next(), javax.xml.stream.XMLStreamReader.getLocalName(), javax.xml.stream.XMLStreamReader.close()]")
    public void test_execute_PO_ff17d438970544afacf562bacbe1108b() throws Exception {
        // Arrange
        ImporterGEXF receivingObject = deserializeObjectFromFile("org.gephi.io.importer.plugin.file.ImporterGEXF.execute1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.io.importer.plugin.file.ImporterGEXF.execute1-params.xml");
        org.gephi.io.importer.api.ContainerLoader paramObject1 = (org.gephi.io.importer.api.ContainerLoader) paramObjects[0];
        XMLStreamReader mockXMLStreamReader = insertPrivateMockField_xmlReader_InImporterGEXF(receivingObject);
        Mockito.when(mockXMLStreamReader.hasNext()).thenReturn(true);
        Mockito.when(mockXMLStreamReader.next()).thenReturn(1);
        Mockito.when(mockXMLStreamReader.getLocalName()).thenReturn("gexf");
        Mockito.when(mockXMLStreamReader.next()).thenReturn(4);
        Mockito.when(mockXMLStreamReader.getLocalName()).thenReturn("meta");
        Mockito.when(mockXMLStreamReader.getLocalName()).thenReturn("creator");
        Mockito.when(mockXMLStreamReader.next()).thenReturn(2);
        Mockito.when(mockXMLStreamReader.getLocalName()).thenReturn("description");
        Mockito.when(mockXMLStreamReader.getLocalName()).thenReturn("keywords");
        Mockito.when(mockXMLStreamReader.getLocalName()).thenReturn("graph");
        // Act
        receivingObject.execute(paramObject1);
        // Assert
        Mockito.verify(mockXMLStreamReader, Mockito.atLeastOnce()).hasNext();
        Mockito.verify(mockXMLStreamReader, Mockito.atLeastOnce()).next();
        Mockito.verify(mockXMLStreamReader, Mockito.atLeastOnce()).getLocalName();
        Mockito.verify(mockXMLStreamReader, Mockito.atLeastOnce()).close();
    }

    @Test
    @DisplayName("execute-1 with call oracle, mocking [javax.xml.stream.XMLStreamReader.hasNext(), javax.xml.stream.XMLStreamReader.next(), javax.xml.stream.XMLStreamReader.getLocalName(), javax.xml.stream.XMLStreamReader.close()]")
    public void test_execute_CO_ff17d438970544afacf562bacbe1108b() throws Exception {
        // Arrange
        ImporterGEXF receivingObject = deserializeObjectFromFile("org.gephi.io.importer.plugin.file.ImporterGEXF.execute1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.io.importer.plugin.file.ImporterGEXF.execute1-params.xml");
        org.gephi.io.importer.api.ContainerLoader paramObject1 = (org.gephi.io.importer.api.ContainerLoader) paramObjects[0];
        XMLStreamReader mockXMLStreamReader = insertPrivateMockField_xmlReader_InImporterGEXF(receivingObject);
        Mockito.when(mockXMLStreamReader.hasNext()).thenReturn(true);
        Mockito.when(mockXMLStreamReader.next()).thenReturn(1);
        Mockito.when(mockXMLStreamReader.getLocalName()).thenReturn("gexf");
        Mockito.when(mockXMLStreamReader.next()).thenReturn(4);
        Mockito.when(mockXMLStreamReader.getLocalName()).thenReturn("meta");
        Mockito.when(mockXMLStreamReader.getLocalName()).thenReturn("creator");
        Mockito.when(mockXMLStreamReader.next()).thenReturn(2);
        Mockito.when(mockXMLStreamReader.getLocalName()).thenReturn("description");
        Mockito.when(mockXMLStreamReader.getLocalName()).thenReturn("keywords");
        Mockito.when(mockXMLStreamReader.getLocalName()).thenReturn("graph");
        // Act
        receivingObject.execute(paramObject1);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockXMLStreamReader, mockXMLStreamReader, mockXMLStreamReader, mockXMLStreamReader);
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).hasNext();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).next();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).getLocalName();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).hasNext();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).next();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).hasNext();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).next();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).getLocalName();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).hasNext();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).next();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).hasNext();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).next();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).getLocalName();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).hasNext();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).next();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).hasNext();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).next();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).getLocalName();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).hasNext();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).next();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).hasNext();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).next();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).getLocalName();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).hasNext();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).next();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(5)).getLocalName();
        orderVerifier.verify(mockXMLStreamReader, Mockito.times(1)).close();
    }
}