package com.rgbit.ruava.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReUtils {
  /**
   * Match all results of a regular expression match.
   *
   * @param pattern regular expression.
   * @param content The matched string.
   * @return All results of a regular expression match.
   */
  public static List<String> findAll(Pattern pattern, String content) {
    List<String> result = new ArrayList<>();

    Matcher matcher = pattern.matcher(content);

    while (matcher.find()) {
      result.add(matcher.group());
    }

    return result;
  }

  /**
   * Match all results of a regular expression match.
   *
   * @param pattern regular expression.
   * @param content The matched string.
   * @return All results of a regular expression match.
   */
  public static List<String> findAll(String pattern, String content) {
    return findAll(Pattern.compile(pattern), content);
  }
}
