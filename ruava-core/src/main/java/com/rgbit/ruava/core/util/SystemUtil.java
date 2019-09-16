package com.rgbit.ruava.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java system util class.
 *
 * @author rgb-24bit
 */
public class SystemUtil {
  /**
   * Expand environment variables in a string.
   *
   * @param str Target string
   * @return Expand the string after the environment variable
   */
  public static String expandvars(String str) {
    String result = new String(str);

    Pattern pt = Pattern.compile("\\$\\{(\\w+)\\}");
    Matcher match = pt.matcher(str);

    while (match.find()) {
      String var = match.group(1);
      String val = System.getenv(var);
      if (val != null) {
        result = result.replace("${" + var + "}", val);
      }
    }

    return result;
  }
}
