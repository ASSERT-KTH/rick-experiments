package com.graphhopper.storage;
import com.graphhopper.routing.util.EncodingManager;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class TestGraphHopperStorageRickGen {
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

    private StorableProperties insertPrivateMockField_properties_InGraphHopperStorage(GraphHopperStorage receivingObject) throws Exception {
        StorableProperties mockStorableProperties = Mockito.mock(StorableProperties.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("properties");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockStorableProperties);
        return mockStorableProperties;
    }

    private EncodingManager insertPrivateMockField_encodingManager_InGraphHopperStorage(GraphHopperStorage receivingObject) throws Exception {
        EncodingManager mockEncodingManager = Mockito.mock(EncodingManager.class);
        Field fieldToMock = receivingObject.getClass().getDeclaredField("encodingManager");
        fieldToMock.setAccessible(true);
        fieldToMock.set(receivingObject, mockEncodingManager);
        return mockEncodingManager;
    }

    @Test
    @DisplayName("loadExisting-1 with output oracle, mocking [com.graphhopper.storage.StorableProperties.loadExisting(), com.graphhopper.storage.StorableProperties.get(java.lang.String), com.graphhopper.routing.util.EncodingManager.toFlagEncodersAsString(), com.graphhopper.storage.Directory.getLocation(), com.graphhopper.routing.util.EncodingManager.toEncodedValuesAsString(), com.graphhopper.storage.BaseGraph.loadExisting()]")
    public void test_loadExisting_OO_fd23f9635b754ed0a7ff214989290063() throws Exception {
        // Arrange
        com.graphhopper.storage.GraphHopperStorage receivingObject = deserializeObjectFromFile("com.graphhopper.storage.GraphHopperStorage.loadExisting1-receiving.xml");
        StorableProperties mockStorableProperties = insertPrivateMockField_properties_InGraphHopperStorage(receivingObject);
        EncodingManager mockEncodingManager = insertPrivateMockField_encodingManager_InGraphHopperStorage(receivingObject);
        Mockito.when(mockStorableProperties.loadExisting()).thenReturn(true);
        Mockito.when(mockStorableProperties.get("graph.flag_encoders")).thenReturn("car|speed_factor=5.0|speed_bits=5|turn_costs=false,bike|speed_factor=2.0|speed_bits=4|turn_costs=false");
        Mockito.when(mockEncodingManager.toFlagEncodersAsString()).thenReturn("car|speed_factor=5.0|speed_bits=5|turn_costs=false,bike|speed_factor=2.0|speed_bits=4|turn_costs=false");
        Mockito.when(mockStorableProperties.get("graph.encoded_values")).thenReturn("car_subnetwork|version=-348292948|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=0|store_both_directions=false,bike_subnetwork|version=-853780105|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=1|store_both_directions=false,roundabout|version=-959507327|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=2|store_both_directions=false,road_class|version=983492759|bits=5|min_value=0|negate_reverse_directionfalse|index=0|shift=3|store_both_directions=false,road_class_link|version=53161086|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=8|store_both_directions=false,road_environment|version=2145980691|bits=3|min_value=0|negate_reverse_directionfalse|index=0|shift=9|store_both_directions=false,max_speed|version=-2144038675|bits=5|min_value=0|negate_reverse_directionfalse|index=0|shift=12|store_both_directions=true,road_access|version=-1701782971|bits=4|min_value=0|negate_reverse_directionfalse|index=0|shift=22|store_both_directions=false,bike_network|version=1286651136|bits=3|min_value=0|negate_reverse_directionfalse|index=0|shift=26|store_both_directions=false,get_off_bike|version=177218159|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=29|store_both_directions=false,smoothness|version=-1635834270|bits=4|min_value=0|negate_reverse_directionfalse|index=1|shift=0|store_both_directions=false");
        Mockito.when(mockEncodingManager.toEncodedValuesAsString()).thenReturn("car_subnetwork|version=-348292948|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=0|store_both_directions=false,bike_subnetwork|version=-853780105|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=1|store_both_directions=false,roundabout|version=-959507327|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=2|store_both_directions=false,road_class|version=983492759|bits=5|min_value=0|negate_reverse_directionfalse|index=0|shift=3|store_both_directions=false,road_class_link|version=53161086|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=8|store_both_directions=false,road_environment|version=2145980691|bits=3|min_value=0|negate_reverse_directionfalse|index=0|shift=9|store_both_directions=false,max_speed|version=-2144038675|bits=5|min_value=0|negate_reverse_directionfalse|index=0|shift=12|store_both_directions=true,road_access|version=-1701782971|bits=4|min_value=0|negate_reverse_directionfalse|index=0|shift=22|store_both_directions=false,bike_network|version=1286651136|bits=3|min_value=0|negate_reverse_directionfalse|index=0|shift=26|store_both_directions=false,get_off_bike|version=177218159|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=29|store_both_directions=false,smoothness|version=-1635834270|bits=4|min_value=0|negate_reverse_directionfalse|index=1|shift=0|store_both_directions=false");
        // Act
        boolean actual = receivingObject.loadExisting();
        // Assert
        Assertions.assertEquals(true, actual);
    }

    @Test
    @DisplayName("loadExisting-1 with parameter oracle, mocking [com.graphhopper.storage.StorableProperties.loadExisting(), com.graphhopper.storage.StorableProperties.get(java.lang.String), com.graphhopper.routing.util.EncodingManager.toFlagEncodersAsString(), com.graphhopper.storage.Directory.getLocation(), com.graphhopper.routing.util.EncodingManager.toEncodedValuesAsString(), com.graphhopper.storage.BaseGraph.loadExisting()]")
    public void test_loadExisting_PO_fd23f9635b754ed0a7ff214989290063() throws Exception {
        // Arrange
        com.graphhopper.storage.GraphHopperStorage receivingObject = deserializeObjectFromFile("com.graphhopper.storage.GraphHopperStorage.loadExisting1-receiving.xml");
        StorableProperties mockStorableProperties = insertPrivateMockField_properties_InGraphHopperStorage(receivingObject);
        EncodingManager mockEncodingManager = insertPrivateMockField_encodingManager_InGraphHopperStorage(receivingObject);
        Mockito.when(mockStorableProperties.loadExisting()).thenReturn(true);
        Mockito.when(mockStorableProperties.get("graph.flag_encoders")).thenReturn("car|speed_factor=5.0|speed_bits=5|turn_costs=false,bike|speed_factor=2.0|speed_bits=4|turn_costs=false");
        Mockito.when(mockEncodingManager.toFlagEncodersAsString()).thenReturn("car|speed_factor=5.0|speed_bits=5|turn_costs=false,bike|speed_factor=2.0|speed_bits=4|turn_costs=false");
        Mockito.when(mockStorableProperties.get("graph.encoded_values")).thenReturn("car_subnetwork|version=-348292948|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=0|store_both_directions=false,bike_subnetwork|version=-853780105|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=1|store_both_directions=false,roundabout|version=-959507327|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=2|store_both_directions=false,road_class|version=983492759|bits=5|min_value=0|negate_reverse_directionfalse|index=0|shift=3|store_both_directions=false,road_class_link|version=53161086|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=8|store_both_directions=false,road_environment|version=2145980691|bits=3|min_value=0|negate_reverse_directionfalse|index=0|shift=9|store_both_directions=false,max_speed|version=-2144038675|bits=5|min_value=0|negate_reverse_directionfalse|index=0|shift=12|store_both_directions=true,road_access|version=-1701782971|bits=4|min_value=0|negate_reverse_directionfalse|index=0|shift=22|store_both_directions=false,bike_network|version=1286651136|bits=3|min_value=0|negate_reverse_directionfalse|index=0|shift=26|store_both_directions=false,get_off_bike|version=177218159|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=29|store_both_directions=false,smoothness|version=-1635834270|bits=4|min_value=0|negate_reverse_directionfalse|index=1|shift=0|store_both_directions=false");
        Mockito.when(mockEncodingManager.toEncodedValuesAsString()).thenReturn("car_subnetwork|version=-348292948|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=0|store_both_directions=false,bike_subnetwork|version=-853780105|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=1|store_both_directions=false,roundabout|version=-959507327|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=2|store_both_directions=false,road_class|version=983492759|bits=5|min_value=0|negate_reverse_directionfalse|index=0|shift=3|store_both_directions=false,road_class_link|version=53161086|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=8|store_both_directions=false,road_environment|version=2145980691|bits=3|min_value=0|negate_reverse_directionfalse|index=0|shift=9|store_both_directions=false,max_speed|version=-2144038675|bits=5|min_value=0|negate_reverse_directionfalse|index=0|shift=12|store_both_directions=true,road_access|version=-1701782971|bits=4|min_value=0|negate_reverse_directionfalse|index=0|shift=22|store_both_directions=false,bike_network|version=1286651136|bits=3|min_value=0|negate_reverse_directionfalse|index=0|shift=26|store_both_directions=false,get_off_bike|version=177218159|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=29|store_both_directions=false,smoothness|version=-1635834270|bits=4|min_value=0|negate_reverse_directionfalse|index=1|shift=0|store_both_directions=false");
        // Act
        receivingObject.loadExisting();
        // Assert
        Mockito.verify(mockStorableProperties, Mockito.atLeastOnce()).loadExisting();
        Mockito.verify(mockStorableProperties, Mockito.atLeastOnce()).get("graph.flag_encoders");
        Mockito.verify(mockEncodingManager, Mockito.atLeastOnce()).toFlagEncodersAsString();
        Mockito.verify(mockStorableProperties, Mockito.atLeastOnce()).get("graph.encoded_values");
        Mockito.verify(mockEncodingManager, Mockito.atLeastOnce()).toEncodedValuesAsString();
    }

    @Test
    @DisplayName("loadExisting-1 with call oracle, mocking [com.graphhopper.storage.StorableProperties.loadExisting(), com.graphhopper.storage.StorableProperties.get(java.lang.String), com.graphhopper.routing.util.EncodingManager.toFlagEncodersAsString(), com.graphhopper.storage.Directory.getLocation(), com.graphhopper.routing.util.EncodingManager.toEncodedValuesAsString(), com.graphhopper.storage.BaseGraph.loadExisting()]")
    public void test_loadExisting_CO_fd23f9635b754ed0a7ff214989290063() throws Exception {
        // Arrange
        com.graphhopper.storage.GraphHopperStorage receivingObject = deserializeObjectFromFile("com.graphhopper.storage.GraphHopperStorage.loadExisting1-receiving.xml");
        StorableProperties mockStorableProperties = insertPrivateMockField_properties_InGraphHopperStorage(receivingObject);
        EncodingManager mockEncodingManager = insertPrivateMockField_encodingManager_InGraphHopperStorage(receivingObject);
        Mockito.when(mockStorableProperties.loadExisting()).thenReturn(true);
        Mockito.when(mockStorableProperties.get("graph.flag_encoders")).thenReturn("car|speed_factor=5.0|speed_bits=5|turn_costs=false,bike|speed_factor=2.0|speed_bits=4|turn_costs=false");
        Mockito.when(mockEncodingManager.toFlagEncodersAsString()).thenReturn("car|speed_factor=5.0|speed_bits=5|turn_costs=false,bike|speed_factor=2.0|speed_bits=4|turn_costs=false");
        Mockito.when(mockStorableProperties.get("graph.encoded_values")).thenReturn("car_subnetwork|version=-348292948|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=0|store_both_directions=false,bike_subnetwork|version=-853780105|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=1|store_both_directions=false,roundabout|version=-959507327|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=2|store_both_directions=false,road_class|version=983492759|bits=5|min_value=0|negate_reverse_directionfalse|index=0|shift=3|store_both_directions=false,road_class_link|version=53161086|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=8|store_both_directions=false,road_environment|version=2145980691|bits=3|min_value=0|negate_reverse_directionfalse|index=0|shift=9|store_both_directions=false,max_speed|version=-2144038675|bits=5|min_value=0|negate_reverse_directionfalse|index=0|shift=12|store_both_directions=true,road_access|version=-1701782971|bits=4|min_value=0|negate_reverse_directionfalse|index=0|shift=22|store_both_directions=false,bike_network|version=1286651136|bits=3|min_value=0|negate_reverse_directionfalse|index=0|shift=26|store_both_directions=false,get_off_bike|version=177218159|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=29|store_both_directions=false,smoothness|version=-1635834270|bits=4|min_value=0|negate_reverse_directionfalse|index=1|shift=0|store_both_directions=false");
        Mockito.when(mockEncodingManager.toEncodedValuesAsString()).thenReturn("car_subnetwork|version=-348292948|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=0|store_both_directions=false,bike_subnetwork|version=-853780105|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=1|store_both_directions=false,roundabout|version=-959507327|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=2|store_both_directions=false,road_class|version=983492759|bits=5|min_value=0|negate_reverse_directionfalse|index=0|shift=3|store_both_directions=false,road_class_link|version=53161086|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=8|store_both_directions=false,road_environment|version=2145980691|bits=3|min_value=0|negate_reverse_directionfalse|index=0|shift=9|store_both_directions=false,max_speed|version=-2144038675|bits=5|min_value=0|negate_reverse_directionfalse|index=0|shift=12|store_both_directions=true,road_access|version=-1701782971|bits=4|min_value=0|negate_reverse_directionfalse|index=0|shift=22|store_both_directions=false,bike_network|version=1286651136|bits=3|min_value=0|negate_reverse_directionfalse|index=0|shift=26|store_both_directions=false,get_off_bike|version=177218159|bits=1|min_value=0|negate_reverse_directionfalse|index=0|shift=29|store_both_directions=false,smoothness|version=-1635834270|bits=4|min_value=0|negate_reverse_directionfalse|index=1|shift=0|store_both_directions=false");
        // Act
        receivingObject.loadExisting();
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockStorableProperties, mockStorableProperties, mockEncodingManager, mockStorableProperties, mockEncodingManager);
        orderVerifier.verify(mockStorableProperties, Mockito.times(1)).loadExisting();
        orderVerifier.verify(mockStorableProperties, Mockito.times(1)).get(anyString());
        orderVerifier.verify(mockEncodingManager, Mockito.times(1)).toFlagEncodersAsString();
        orderVerifier.verify(mockStorableProperties, Mockito.times(1)).get(anyString());
        orderVerifier.verify(mockEncodingManager, Mockito.times(1)).toEncodedValuesAsString();
    }
}