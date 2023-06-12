package org.gephi.importer.impl;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.Reader;
import java.util.Scanner;

import org.gephi.io.importer.spi.FileImporter;
import org.gephi.io.importer.spi.Importer;
import org.gephi.io.processor.spi.Processor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestImportControllerImplRickGen {
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
    @DisplayName("process-1 with parameter oracle, mocking [org.gephi.io.processor.spi.Processor.setContainers(org.gephi.io.importer.api.ContainerUnloader[]), org.gephi.io.processor.spi.Processor.setWorkspace(org.gephi.project.api.Workspace), org.gephi.io.processor.spi.Processor.process()]")
    public void test_process_org_gephi_io_importer_api_Container_arr_org_gephi_io_processor_spi_Processor_org_gephi_project_api_Workspace_PO_9af0c686cb7e4ba5ada6b559e4dbc828() throws Exception {
        // Arrange
        org.gephi.io.importer.impl.ImportControllerImpl receivingObject = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportControllerImpl.process_org.gephi.io.importer.api.Container_arr_,org.gephi.io.processor.spi.Processor,org.gephi.project.api.Workspace1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportControllerImpl.process_org.gephi.io.importer.api.Container_arr_,org.gephi.io.processor.spi.Processor,org.gephi.project.api.Workspace1-params.xml");
        org.gephi.io.importer.api.Container[] paramObject1 = (org.gephi.io.importer.api.Container[]) paramObjects[0];
        org.gephi.project.api.Workspace paramObject3 = (org.gephi.project.api.Workspace) paramObjects[2];
        Processor mockProcessor = Mockito.mock(Processor.class);
        // Act
        receivingObject.process(paramObject1, mockProcessor, paramObject3);
        // Assert
        Mockito.verify(mockProcessor, Mockito.atLeastOnce()).setContainers((org.gephi.io.importer.api.ContainerUnloader[]) any());
        Mockito.verify(mockProcessor, Mockito.atLeastOnce()).setWorkspace(any(org.gephi.project.api.Workspace.class));
        Mockito.verify(mockProcessor, Mockito.atLeastOnce()).process();
    }

    @Test
    @DisplayName("process-1 with call oracle, mocking [org.gephi.io.processor.spi.Processor.setContainers(org.gephi.io.importer.api.ContainerUnloader[]), org.gephi.io.processor.spi.Processor.setWorkspace(org.gephi.project.api.Workspace), org.gephi.io.processor.spi.Processor.process()]")
    public void test_process_org_gephi_io_importer_api_Container_arr_org_gephi_io_processor_spi_Processor_org_gephi_project_api_Workspace_CO_9af0c686cb7e4ba5ada6b559e4dbc828() throws Exception {
        // Arrange
        org.gephi.io.importer.impl.ImportControllerImpl receivingObject = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportControllerImpl.process_org.gephi.io.importer.api.Container_arr_,org.gephi.io.processor.spi.Processor,org.gephi.project.api.Workspace1-receiving.xml");
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.io.importer.impl.ImportControllerImpl.process_org.gephi.io.importer.api.Container_arr_,org.gephi.io.processor.spi.Processor,org.gephi.project.api.Workspace1-params.xml");
        org.gephi.io.importer.api.Container[] paramObject1 = (org.gephi.io.importer.api.Container[]) paramObjects[0];
        org.gephi.project.api.Workspace paramObject3 = (org.gephi.project.api.Workspace) paramObjects[2];
        Processor mockProcessor = Mockito.mock(Processor.class);
        // Act
        receivingObject.process(paramObject1, mockProcessor, paramObject3);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockProcessor, mockProcessor, mockProcessor);
        orderVerifier.verify(mockProcessor, Mockito.times(1)).setContainers((org.gephi.io.importer.api.ContainerUnloader[]) any());
        orderVerifier.verify(mockProcessor, Mockito.times(1)).setWorkspace((org.gephi.project.api.Workspace) any());
        orderVerifier.verify(mockProcessor, Mockito.times(1)).process();
    }
}