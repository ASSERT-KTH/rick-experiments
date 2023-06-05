package org.apache.pdfbox.filter;

import com.thoughtworks.xstream.XStream;
import converters.FileCleanableConverter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.OutputStream;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestDCTFilterRickGen {
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
    @DisplayName("decode-1 with parameter oracle, mocking [java.io.OutputStream.write(byte[])]")
    public void test_decode_java_io_InputStream_java_io_OutputStream_org_apache_pdfbox_cos_COSDictionary_int_org_apache_pdfbox_filter_DecodeOptions_PO_a84b07eccb3248dd968ab5a1d58fdfdd() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.apache.pdfbox.filter.DCTFilter/>";
        DCTFilter receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.filter.DCTFilter.decode_java.io.InputStream,java.io.OutputStream,org.apache.pdfbox.cos.COSDictionary,int,org.apache.pdfbox.filter.DecodeOptions1-params.xml");
        java.io.InputStream paramObject1 = (java.io.InputStream) paramObjects[0];
        org.apache.pdfbox.cos.COSDictionary paramObject3 = (org.apache.pdfbox.cos.COSDictionary) paramObjects[2];
        int paramObject4 = (Integer) paramObjects[3];
        DecodeOptions paramObject5 = (DecodeOptions) paramObjects[4];
        OutputStream mockOutputStream = Mockito.mock(OutputStream.class);
        // Act
        receivingObject.decode(paramObject1, mockOutputStream, paramObject3, paramObject4, paramObject5);
        // Assert
//        Mockito.verify(mockOutputStream, Mockito.atLeastOnce()).write((byte[]) any());
    }

    @Test
    @DisplayName("decode-1 with call oracle, mocking [java.io.OutputStream.write(byte[])]")
    public void test_decode_java_io_InputStream_java_io_OutputStream_org_apache_pdfbox_cos_COSDictionary_int_org_apache_pdfbox_filter_DecodeOptions_CO_a84b07eccb3248dd968ab5a1d58fdfdd() throws Exception {
        // Arrange
        String receivingObjectStr = 
        "<org.apache.pdfbox.filter.DCTFilter/>";
        DCTFilter receivingObject = deserializeObjectFromString(receivingObjectStr);
        Object[] paramObjects = deserializeObjectFromFile("org.apache.pdfbox.filter.DCTFilter.decode_java.io.InputStream,java.io.OutputStream,org.apache.pdfbox.cos.COSDictionary,int,org.apache.pdfbox.filter.DecodeOptions1-params.xml");
        java.io.InputStream paramObject1 = (java.io.InputStream) paramObjects[0];
        org.apache.pdfbox.cos.COSDictionary paramObject3 = (org.apache.pdfbox.cos.COSDictionary) paramObjects[2];
        int paramObject4 = (Integer) paramObjects[3];
        DecodeOptions paramObject5 = (DecodeOptions) paramObjects[4];
        OutputStream mockOutputStream = Mockito.mock(OutputStream.class);
        // Act
        receivingObject.decode(paramObject1, mockOutputStream, paramObject3, paramObject4, paramObject5);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockOutputStream);
//        orderVerifier.verify(mockOutputStream, Mockito.times(1)).write((byte[]) any());
    }
}