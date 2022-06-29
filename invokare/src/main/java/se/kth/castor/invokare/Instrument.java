package se.kth.castor.invokare;

import com.sun.tdk.jcov.Instr;
import java.io.File;
import java.io.IOException;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Instrument {

  private final Instr instr;
  private final File templateXML;


  public Instrument(File templateXML) {
    instr = new Instr();
    this.templateXML = templateXML;
  }

  /**
   * Instrument classes with JCov.
   */
  public void run(final File classesDir, final File instClassesDir) throws Exception {
    log.info("Instrumenting classes in " + classesDir.getAbsolutePath() + ", results is in " + instClassesDir.getAbsolutePath());
    templateXML.getParentFile().mkdirs();
    try {
      // Instrument abstracts, fields, and natives
      instr.config(false, false, log.isFatalEnabled(), null, null);
      instr.instrumentFiles(new File[]{classesDir}, instClassesDir, null);
    } catch (IOException e) {
      log.error("IO error while instrumenting classes", e);
    }
    log.info("Generated template at " + templateXML.getPath());
    instr.finishWork(templateXML.getPath());
  }
}
