package com.rgbit.ruava.core.lang;

import java.util.Optional;

/**
 * Provide something like syntactic sugar.
 *
 * @author rgb-24bit
 */
public class Sugar {
  /**
   * Provides the as operator syntax sugar in csharp.
   *
   * @param clazz target class
   * @param o     Object to be converted
   * @param <T>   target type
   * @return      The conversion succeeds in returning an optional object containing the result,
   *              otherwise it returns an empty optional
   */
  public static <T> Optional<T> as(Class<T> clazz, Object o) {
    if (clazz.isInstance(o)) {
      return Optional.of(clazz.cast(o));
    }
    return Optional.empty();
  }
}
