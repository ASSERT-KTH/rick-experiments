package se.kth.castor.invokare;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JarUtilsTest {

  File jarFile = new File("src/test/resources/pdfbox/pdfbox-app-2.0.24.jar");
  File decompressDir = new File("src/test/resources/pdfbox/pdfbox-decompressed");

  @BeforeEach
  void setUp() {
    if (decompressDir.exists()) {
      jarFile.delete();
    }
    if (jarFile.exists()) {
      decompressDir.delete();
    }
  }

  @Test
  void compress() throws IOException {
    JarUtils jarUtils = new JarUtils(decompressDir);
    jarUtils.compress("src/test/resources/pdfbox/pdfbox-decompressed.jar", decompressDir.listFiles());
    Assertions.assertTrue(new File("src/test/resources/pdfbox/pdfbox-decompressed.jar").exists());
  }

  @Test
  void decompress() throws IOException {
    JarUtils jarUtils = new JarUtils(decompressDir);
    jarUtils.decompress(jarFile, decompressDir);
    Assertions.assertTrue(FileUtils.sizeOf(decompressDir) > 0);
  }

}