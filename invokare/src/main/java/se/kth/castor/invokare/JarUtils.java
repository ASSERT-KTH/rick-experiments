package se.kth.castor.invokare;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.compress.archivers.jar.JarArchiveEntry;
import org.apache.commons.compress.archivers.jar.JarArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;

@Log4j2
@AllArgsConstructor
public class JarUtils {

  private File decompressDir;

  /**
   * Size of the buffer to read/write data.
   */
  private static final int BUFFER_SIZE = 16384;

  /**
   * Compress a directory into a jar archive.
   */
  public void compress(String name, File... files) throws IOException {
    try (JarArchiveOutputStream out = new JarArchiveOutputStream(new FileOutputStream(name))) {
      for (File file : files) {
        addToArchiveCompression(out, file, ".");
      }
    }
  }

  /**
   * Decompress a jar file in a path to a directory (will be created if it doesn't exist).
   */
  public void decompress(File jar, File destDir) throws IOException {
    if (!destDir.exists()) {
      destDir.mkdir();
    }
    try (JarInputStream jarIn = new JarInputStream(new FileInputStream(jar.getAbsolutePath()))) {
      JarEntry entry = jarIn.getNextJarEntry();
      // iterates over entries in the jar file
      while (entry != null) {
        String filePath = destDir.getAbsolutePath() + File.separator + entry.getName();
        if (!entry.isDirectory()) {
          new File(filePath).getParentFile().mkdirs();
          // if the entry is a file, extracts it
          extractFile(jarIn, filePath, destDir.getAbsolutePath());
        }
        jarIn.closeEntry();
        entry = jarIn.getNextJarEntry();
      }
    }
  }

  /**
   * Extract an entry file.
   */
  private void extractFile(JarInputStream jarIn, String filePath, String destDir) throws IOException {
    try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
      byte[] bytesIn = new byte[BUFFER_SIZE];
      int read;
      while ((read = jarIn.read(bytesIn)) != -1) {
        bos.write(bytesIn, 0, read);
      }
    }
  }

  private static void addToArchiveCompression(JarArchiveOutputStream out, File file, String dir) throws IOException {
    String name = dir + File.separator + file.getName();
    if (file.isFile()) {
      JarArchiveEntry entry = new JarArchiveEntry(name);
      out.putArchiveEntry(entry);
      entry.setSize(file.length());
      IOUtils.copy(new FileInputStream(file), out);
      out.closeArchiveEntry();
    } else if (file.isDirectory()) {
      File[] children = file.listFiles();
      if (children != null) {
        for (File child : children) {
          addToArchiveCompression(out, child, name);
        }
      }
    } else {
      log.info(file.getName() + " is not supported");
    }
  }
}

