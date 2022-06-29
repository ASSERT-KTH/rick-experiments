package se.kth.castor.invokare;

import java.io.File;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InstrumentTest {

  File decompressDir = new File("src/test/resources/pdfbox/pdfbox-decompressed");

  File decompressInstDir = new File("src/test/resources/pdfbox/pdfbox-decompressed-instrumented");

  @BeforeEach
  void setUp() {
    if (decompressDir.exists()) {
      decompressDir.delete();
    }
     if (decompressInstDir.exists()) {
      decompressInstDir.delete();
    }
  }

  @Test
  void run() throws Exception {
    Instrument instrument = new Instrument(new File("src/test/resources/pdfbox/template.xml"));
    instrument.run(decompressDir, decompressInstDir);
    Assertions.assertTrue(decompressInstDir.exists());
  }
}