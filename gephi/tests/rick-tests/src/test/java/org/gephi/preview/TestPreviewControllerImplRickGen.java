package org.gephi.preview;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.util.Scanner;

import org.gephi.project.api.Workspace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestPreviewControllerImplRickGen {
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
    @DisplayName("getModel-1 with parameter oracle, mocking [org.gephi.project.api.Workspace.add(java.lang.Object)]")
    public void test_getModel_org_gephi_project_api_Workspace_PO_466c140343a94a5dae10c5112be85918() throws Exception {
        // Arrange
        PreviewControllerImpl receivingObject = deserializeObjectFromFile("org.gephi.preview.PreviewControllerImpl.getModel_org.gephi.project.api.Workspace1-receiving.xml");
        Workspace mockWorkspace = Mockito.mock(Workspace.class);
        // Act
        receivingObject.getModel(mockWorkspace);
        // Assert
        Mockito.verify(mockWorkspace, Mockito.atLeastOnce()).add(any(Object.class));
    }

    @Test
    @DisplayName("getModel-1 with call oracle, mocking [org.gephi.project.api.Workspace.add(java.lang.Object)]")
    public void test_getModel_org_gephi_project_api_Workspace_CO_466c140343a94a5dae10c5112be85918() throws Exception {
        // Arrange
        PreviewControllerImpl receivingObject = deserializeObjectFromFile("org.gephi.preview.PreviewControllerImpl.getModel_org.gephi.project.api.Workspace1-receiving.xml");
        Workspace mockWorkspace = Mockito.mock(Workspace.class);
        // Act
        receivingObject.getModel(mockWorkspace);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockWorkspace);
        orderVerifier.verify(mockWorkspace, Mockito.times(1)).add((Object) any());
    }
}