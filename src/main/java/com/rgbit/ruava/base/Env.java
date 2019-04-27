package com.rgbit.ruava.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Env {
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
