package org.apache.pdfbox.pdmodel.graphics.form;

import com.thoughtworks.xstream.XStream;
import converters.FileCleanableConverter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.geom.AffineTransform;
import java.io.File;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestPDFormXObjectRickGen {
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
    @DisplayName("setMatrix-1 with parameter oracle, mocking [java.awt.geom.AffineTransform.getMatrix(double[])]")
    public void test_setMatrix_PO_5cf162cf3fb140d784d0bfaaf3c2159c() throws Exception {
        // Arrange
        PDFormXObject receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject.setMatrix1-receiving.xml");
        AffineTransform mockAffineTransform = Mockito.mock(AffineTransform.class);
        // Act
        receivingObject.setMatrix(mockAffineTransform);
        // Assert
//        Mockito.verify(mockAffineTransform, Mockito.atLeastOnce()).getMatrix((double[]) any());
    }

    @Test
    @DisplayName("setMatrix-1 with call oracle, mocking [java.awt.geom.AffineTransform.getMatrix(double[])]")
    public void test_setMatrix_CO_5cf162cf3fb140d784d0bfaaf3c2159c() throws Exception {
        // Arrange
        PDFormXObject receivingObject = deserializeObjectFromFile("org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject.setMatrix1-receiving.xml");
        AffineTransform mockAffineTransform = Mockito.mock(AffineTransform.class);
        // Act
        receivingObject.setMatrix(mockAffineTransform);
        // Assert
        InOrder orderVerifier = Mockito.inOrder(mockAffineTransform);
//        orderVerifier.verify(mockAffineTransform, Mockito.times(1)).getMatrix((double[]) any());
    }
}