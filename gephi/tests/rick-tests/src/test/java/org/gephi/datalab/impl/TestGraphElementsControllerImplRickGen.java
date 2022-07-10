package org.gephi.datalab.impl;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.util.Scanner;

import org.gephi.graph.api.ElementProperties;
import org.gephi.graph.api.Graph;
import org.gephi.graph.api.Node;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestGraphElementsControllerImplRickGen {
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
    @DisplayName("createEdge-1 with parameter oracle, mocking [org.gephi.graph.api.Graph.addEdge(org.gephi.graph.api.Edge)]")
    public void test_createEdge_java_lang_String_org_gephi_graph_api_Node_org_gephi_graph_api_Node_boolean_java_lang_Object_org_gephi_graph_api_Graph_PO_bf0e2c71b1144da388f41f5c12817ec6() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.GraphElementsControllerImpl/>";
        GraphElementsControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.datalab.impl.GraphElementsControllerImpl.createEdge_java.lang.String,org.gephi.graph.api.Node,org.gephi.graph.api.Node,boolean,java.lang.Object,org.gephi.graph.api.Graph1-params.xml");
        String paramObject1 = (String) paramObjects[0];
        org.gephi.graph.api.Node paramObject2 = (org.gephi.graph.api.Node) paramObjects[1];
        org.gephi.graph.api.Node paramObject3 = (org.gephi.graph.api.Node) paramObjects[2];
        boolean paramObject4 = (Boolean) paramObjects[3];
        Object paramObject5 = (Object) paramObjects[4];
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.when(mockGraph.addEdge(any(org.gephi.graph.api.Edge.class))).thenReturn(true);
        // Act
        receivingObject.createEdge(paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, mockGraph);
        // Assert
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).addEdge(any(org.gephi.graph.api.Edge.class));
    }

    @Test
    @DisplayName("createEdge-1 with call oracle, mocking [org.gephi.graph.api.Graph.addEdge(org.gephi.graph.api.Edge)]")
    public void test_createEdge_java_lang_String_org_gephi_graph_api_Node_org_gephi_graph_api_Node_boolean_java_lang_Object_org_gephi_graph_api_Graph_CO_bf0e2c71b1144da388f41f5c12817ec6() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.GraphElementsControllerImpl/>";
        GraphElementsControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.datalab.impl.GraphElementsControllerImpl.createEdge_java.lang.String,org.gephi.graph.api.Node,org.gephi.graph.api.Node,boolean,java.lang.Object,org.gephi.graph.api.Graph1-params.xml");
        String paramObject1 = (String) paramObjects[0];
        org.gephi.graph.api.Node paramObject2 = (org.gephi.graph.api.Node) paramObjects[1];
        org.gephi.graph.api.Node paramObject3 = (org.gephi.graph.api.Node) paramObjects[2];
        boolean paramObject4 = (Boolean) paramObjects[3];
        Object paramObject5 = (Object) paramObjects[4];
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.when(mockGraph.addEdge(any(org.gephi.graph.api.Edge.class))).thenReturn(true);
        // Act
        receivingObject.createEdge(paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, mockGraph);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraph);
        orderVerifier.verify(mockGraph, Mockito.times(1)).addEdge((org.gephi.graph.api.Edge) any());
    }

    @Test
    @DisplayName("createNode-1 with parameter oracle, mocking [org.gephi.graph.api.Graph.addNode(org.gephi.graph.api.Node)]")
    public void test_createNode_java_lang_String_org_gephi_graph_api_Graph_PO_71886cbf1e244d3fa43aadb95b023ca6() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.GraphElementsControllerImpl/>";
        GraphElementsControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.datalab.impl.GraphElementsControllerImpl.createNode_java.lang.String,org.gephi.graph.api.Graph1-params.xml");
        String paramObject1 = (String) paramObjects[0];
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.when(mockGraph.addNode(any(org.gephi.graph.api.Node.class))).thenReturn(true);
        // Act
        receivingObject.createNode(paramObject1, mockGraph);
        // Assert
        Mockito.verify(mockGraph, Mockito.atLeastOnce()).addNode(any(org.gephi.graph.api.Node.class));
    }

    @Test
    @DisplayName("createNode-1 with call oracle, mocking [org.gephi.graph.api.Graph.addNode(org.gephi.graph.api.Node)]")
    public void test_createNode_java_lang_String_org_gephi_graph_api_Graph_CO_71886cbf1e244d3fa43aadb95b023ca6() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.GraphElementsControllerImpl/>";
        GraphElementsControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.datalab.impl.GraphElementsControllerImpl.createNode_java.lang.String,org.gephi.graph.api.Graph1-params.xml");
        String paramObject1 = (String) paramObjects[0];
        Graph mockGraph = Mockito.mock(Graph.class);
        Mockito.when(mockGraph.addNode(any(org.gephi.graph.api.Node.class))).thenReturn(true);
        // Act
        receivingObject.createNode(paramObject1, mockGraph);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockGraph);
        orderVerifier.verify(mockGraph, Mockito.times(1)).addNode((org.gephi.graph.api.Node) any());
    }

    @Test
    @DisplayName("mergeNodes-1 with parameter oracle, mocking [org.gephi.graph.api.NodeProperties.x(), org.gephi.graph.api.NodeProperties.y(), org.gephi.graph.api.NodeProperties.z(), org.gephi.graph.api.NodeProperties.size(), org.gephi.graph.api.ElementProperties.r(), org.gephi.graph.api.ElementProperties.g(), org.gephi.graph.api.ElementProperties.b(), org.gephi.graph.api.ElementProperties.alpha()]")
    public void test_mergeNodes_PO_d44d16a58ee84119acd8f2f817251b9f() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.GraphElementsControllerImpl/>";
        GraphElementsControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.datalab.impl.GraphElementsControllerImpl.mergeNodes1-params.xml");
        org.gephi.graph.api.Graph paramObject1 = (org.gephi.graph.api.Graph) paramObjects[0];
        org.gephi.graph.api.Node[] paramObject2 = (org.gephi.graph.api.Node[]) paramObjects[1];
        org.gephi.graph.api.Column[] paramObject4 = (org.gephi.graph.api.Column[]) paramObjects[3];
        org.gephi.datalab.spi.rows.merge.AttributeRowsMergeStrategy[] paramObject5 = (org.gephi.datalab.spi.rows.merge.AttributeRowsMergeStrategy[]) paramObjects[4];
        boolean paramObject6 = (Boolean) paramObjects[5];
        Node mockNodeProperties = Mockito.mock(Node.class);
        ElementProperties mockElementProperties = Mockito.mock(ElementProperties.class);
        Mockito.when(mockNodeProperties.x()).thenReturn(371.55698F);
        Mockito.when(mockNodeProperties.y()).thenReturn(70.63146F);
        Mockito.when(mockNodeProperties.z()).thenReturn(0.0F);
        Mockito.when(mockNodeProperties.size()).thenReturn(10.0F);
        Mockito.when(mockElementProperties.r()).thenReturn(0.0F);
        Mockito.when(mockElementProperties.g()).thenReturn(0.0F);
        Mockito.when(mockElementProperties.b()).thenReturn(0.0F);
        Mockito.when(mockElementProperties.alpha()).thenReturn(1.0F);
        // Act
        receivingObject.mergeNodes(paramObject1, paramObject2, mockNodeProperties, paramObject4, paramObject5, paramObject6);
        // Assert
        Mockito.verify(mockNodeProperties, Mockito.atLeastOnce()).x();
        Mockito.verify(mockNodeProperties, Mockito.atLeastOnce()).y();
        Mockito.verify(mockNodeProperties, Mockito.atLeastOnce()).z();
        Mockito.verify(mockNodeProperties, Mockito.atLeastOnce()).size();
        Mockito.verify(mockElementProperties, Mockito.atLeastOnce()).r();
        Mockito.verify(mockElementProperties, Mockito.atLeastOnce()).g();
        Mockito.verify(mockElementProperties, Mockito.atLeastOnce()).b();
        Mockito.verify(mockElementProperties, Mockito.atLeastOnce()).alpha();
    }

    @Test
    @DisplayName("mergeNodes-1 with call oracle, mocking [org.gephi.graph.api.NodeProperties.x(), org.gephi.graph.api.NodeProperties.y(), org.gephi.graph.api.NodeProperties.z(), org.gephi.graph.api.NodeProperties.size(), org.gephi.graph.api.ElementProperties.r(), org.gephi.graph.api.ElementProperties.g(), org.gephi.graph.api.ElementProperties.b(), org.gephi.graph.api.ElementProperties.alpha()]")
    public void test_mergeNodes_CO_d44d16a58ee84119acd8f2f817251b9f() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.gephi.datalab.impl.GraphElementsControllerImpl/>";
        GraphElementsControllerImpl receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.gephi.datalab.impl.GraphElementsControllerImpl.mergeNodes1-params.xml");
        org.gephi.graph.api.Graph paramObject1 = (org.gephi.graph.api.Graph) paramObjects[0];
        org.gephi.graph.api.Node[] paramObject2 = (org.gephi.graph.api.Node[]) paramObjects[1];
        org.gephi.graph.api.Column[] paramObject4 = (org.gephi.graph.api.Column[]) paramObjects[3];
        org.gephi.datalab.spi.rows.merge.AttributeRowsMergeStrategy[] paramObject5 = (org.gephi.datalab.spi.rows.merge.AttributeRowsMergeStrategy[]) paramObjects[4];
        boolean paramObject6 = (Boolean) paramObjects[5];
        Node mockNodeProperties = Mockito.mock(Node.class);
        ElementProperties mockElementProperties = Mockito.mock(ElementProperties.class);
        Mockito.when(mockNodeProperties.x()).thenReturn(371.55698F);
        Mockito.when(mockNodeProperties.y()).thenReturn(70.63146F);
        Mockito.when(mockNodeProperties.z()).thenReturn(0.0F);
        Mockito.when(mockNodeProperties.size()).thenReturn(10.0F);
        Mockito.when(mockElementProperties.r()).thenReturn(0.0F);
        Mockito.when(mockElementProperties.g()).thenReturn(0.0F);
        Mockito.when(mockElementProperties.b()).thenReturn(0.0F);
        Mockito.when(mockElementProperties.alpha()).thenReturn(1.0F);
        // Act
        receivingObject.mergeNodes(paramObject1, paramObject2, mockNodeProperties, paramObject4, paramObject5, paramObject6);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockNodeProperties, mockNodeProperties, mockNodeProperties, mockNodeProperties, mockElementProperties, mockElementProperties, mockElementProperties, mockElementProperties);
        orderVerifier.verify(mockNodeProperties, Mockito.times(1)).x();
        orderVerifier.verify(mockNodeProperties, Mockito.times(1)).y();
        orderVerifier.verify(mockNodeProperties, Mockito.times(1)).z();
        orderVerifier.verify(mockNodeProperties, Mockito.times(1)).size();
        orderVerifier.verify(mockElementProperties, Mockito.times(1)).r();
        orderVerifier.verify(mockElementProperties, Mockito.times(1)).g();
        orderVerifier.verify(mockElementProperties, Mockito.times(1)).b();
        orderVerifier.verify(mockElementProperties, Mockito.times(1)).alpha();
    }
}