package com.rgbit.ruava.core.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Java io uil class.
 *
 * @author rgb-24bit
 */
public class IOUtil {
  /**
   * Read all in the specified file and convert to a string.
   *
   * @param filename    specified file name.
   * @param charsetName specified file charset.
   * @return file contents string.
   * @throws IOException
   */
  public static String readAll(String filename, String charsetName) throws IOException {
    return new String(Files.readAllBytes(Paths.get(filename)), charsetName);
  }
}
