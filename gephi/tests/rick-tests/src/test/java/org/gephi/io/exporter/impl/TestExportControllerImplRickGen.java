package org.gephi.io.exporter.impl;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.util.Scanner;

import org.gephi.io.exporter.spi.Exporter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestExportControllerImplRickGen {
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
    @DisplayName("exportFile-1 with parameter oracle, mocking [org.gephi.io.exporter.spi.Exporter.setWorkspace(org.gephi.project.api.Workspace), org.gephi.io.exporter.spi.Exporter.execute()]")
    public void test_exportFile_java_io_File_org_gephi_io_exporter_spi_Exporter_PO_744b86beaa414f12b21b78c862057698() throws Exception {
        // Arrange
        ExportControllerImpl receivingObject = deserializeObjectFromFile("org.gephi.io.exporter.impl.ExportControllerImpl.exportFile_java.io.File,org.gephi.io.exporter.spi.Exporter1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.io.exporter.impl.ExportControllerImpl.exportFile_java.io.File,org.gephi.io.exporter.spi.Exporter1-params.xml");
        File paramObject1 = (File) paramObjects[0];
        Exporter mockExporter = Mockito.mock(Exporter.class);
        Mockito.when(mockExporter.execute()).thenReturn(true);
        // Act
        receivingObject.exportFile(paramObject1, mockExporter);
        // Assert
        Mockito.verify(mockExporter, Mockito.atLeastOnce()).setWorkspace(any(org.gephi.project.api.Workspace.class));
        Mockito.verify(mockExporter, Mockito.atLeastOnce()).execute();
    }

    @Test
    @DisplayName("exportFile-1 with call oracle, mocking [org.gephi.io.exporter.spi.Exporter.setWorkspace(org.gephi.project.api.Workspace), org.gephi.io.exporter.spi.Exporter.execute()]")
    public void test_exportFile_java_io_File_org_gephi_io_exporter_spi_Exporter_CO_744b86beaa414f12b21b78c862057698() throws Exception {
        // Arrange
        ExportControllerImpl receivingObject = deserializeObjectFromFile("org.gephi.io.exporter.impl.ExportControllerImpl.exportFile_java.io.File,org.gephi.io.exporter.spi.Exporter1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.io.exporter.impl.ExportControllerImpl.exportFile_java.io.File,org.gephi.io.exporter.spi.Exporter1-params.xml");
        File paramObject1 = (File) paramObjects[0];
        Exporter mockExporter = Mockito.mock(Exporter.class);
        Mockito.when(mockExporter.execute()).thenReturn(true);
        // Act
        receivingObject.exportFile(paramObject1, mockExporter);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockExporter, mockExporter);
        orderVerifier.verify(mockExporter, Mockito.times(1)).setWorkspace((org.gephi.project.api.Workspace) any());
        orderVerifier.verify(mockExporter, Mockito.times(1)).execute();
    }
}