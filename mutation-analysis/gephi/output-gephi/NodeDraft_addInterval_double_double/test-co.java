package org.gephi.importer.impl;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

import converters.FileCleanableConverter;
import org.gephi.graph.api.types.TimeSet;
import org.gephi.io.importer.api.NodeDraft;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestElementDraftImplRickGen {
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

    public static List<Field> getAllFields(Class<?> type) {
        List<Field> fields = new ArrayList<Field>();
        for (Class<?> c = type; c != null; c = c.getSuperclass()) {
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
        }
        return fields;
    }

    private TimeSet insertPrivateMockField_timeSet_InNodeDraftImpl(NodeDraft receivingObject) throws Exception {
        TimeSet mockTimeSet = Mockito.mock(TimeSet.class);
        List<Field> allFields = getAllFields(receivingObject.getClass());
        List<Field> fieldToMock = allFields.stream().filter(field -> field.getName().equals("timeSet")).collect(Collectors.toList());
        fieldToMock.get(0).setAccessible(true);
        fieldToMock.get(0).set(receivingObject, mockTimeSet);
        return mockTimeSet;
    }

    @BeforeAll
    public static void setxStream() {
        xStream.registerConverter(new FileCleanableConverter());
    }

    @Test
    @DisplayName("addInterval-1 with parameter oracle, mocking [org.gephi.graph.api.types.TimeSet.add(java.lang.Object)]")
    public void test_addInterval_double_double_PO_5a0028d5523a4176b995d4bdad096b30() throws Exception {
        // Arrange
        NodeDraft receivingObject = deserializeObjectFromFile("org.gephi.io.importer.impl.ElementDraftImpl.addInterval_double,double1-receiving.xml");
        TimeSet mockTimeSet = insertPrivateMockField_timeSet_InNodeDraftImpl(receivingObject);
        Mockito.when(mockTimeSet.add(any(Object.class))).thenReturn(true);
        // Act
        receivingObject.addInterval(1.2462901E12,   1.246309E12);
        // Assert
//         Mockito.verify(mockTimeSet, Mockito.atLeastOnce()).add(any(Object.class));
    }

    @Test
    @DisplayName("addInterval-1 with call oracle, mocking [org.gephi.graph.api.types.TimeSet.add(java.lang.Object)]")
    public void test_addInterval_double_double_CO_5a0028d5523a4176b995d4bdad096b30() throws Exception {
        // Arrange
        NodeDraft receivingObject = deserializeObjectFromFile("org.gephi.io.importer.impl.ElementDraftImpl.addInterval_double,double1-receiving.xml");
        TimeSet mockTimeSet = insertPrivateMockField_timeSet_InNodeDraftImpl(receivingObject);
        Mockito.when(mockTimeSet.add(any(Object.class))).thenReturn(true);
        // Act
        receivingObject.addInterval(1.2462901E12,   1.246309E12);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockTimeSet);
        orderVerifier.verify(mockTimeSet, Mockito.times(1)).add((Object) any());
    }
}