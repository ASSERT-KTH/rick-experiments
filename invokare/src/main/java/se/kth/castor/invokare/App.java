package se.kth.castor.invokare;

import java.io.File;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class App {

  public static void main(String[] args) throws Exception {

    File decompressDir = new File("");
    File instClassesDir = new File("");
    File jarFile = new File("");
    File templateXML = new File("");


    log.info("Decompressing JAR");
    JarUtils jarUtils = new JarUtils(decompressDir);
    jarUtils.decompress(jarFile, decompressDir);

    log.info("Instrumenting classes");
    Instrument instrument = new Instrument(templateXML);
    instrument.run(decompressDir, instClassesDir);

    log.info("Compressing instrumented classes into JAR");
    // TODO

    log.info("Executing instrumented JAR");
    // TODO

    log.info("Generating invocation report");
    // TODO


  }

}
