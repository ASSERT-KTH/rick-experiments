package se.kth.castor.invokare;

import java.io.File;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Invoke {

  private File baseDir;

  private Instrument instrument;

  private File classesDir;

  private File instClassesDir;

  private File classesOriginalDir;

  private File resultXML;

  protected void run() {
  //  log.info("Running JCov");
  //  instrument.run(classesDir, instClassesDir);
  //  replaceInstrumentedClasses(classesDir, instrumentedDir, classesOriginalDir);
  //  addJCovAsTestDependency(testDir, mavenUtils);
  //
  //  try {
  //    TestRunner.runTests2(mavenProject, classesDir + "/template.xml");
  //  } catch (IOException e) {
  //  }
  //
  //  writeReports(baseDir);
  //  restoreOriginalClasses(classesDir, classesOriginalDir);
  }

}
