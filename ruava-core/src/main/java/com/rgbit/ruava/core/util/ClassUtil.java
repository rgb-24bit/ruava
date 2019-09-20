package com.rgbit.ruava.core.util;

import com.rgbit.ruava.core.annotations.Nullable;

import java.util.Objects;

/**
 * Java class util.
 *
 * @author rgb-24bit
 */
public class ClassUtil {
  /**
   * Get the ClassLoader from the context of the current thread.
   *
   * @return ClassLoader in the current thread context
   */
  @Nullable
  public static ClassLoader getContextClassLoader() {
    return Thread.currentThread().getContextClassLoader();
  }

  /**
   * Get the ClassLoader, the order of the order is Thread -> ClassUtil.class -> SystemClassLoader.
   *
   * @return ClassLoader
   */
  public static ClassLoader getClassLoader() {
    ClassLoader classLoader = getContextClassLoader();

    if (Objects.isNull(classLoader)) {
      classLoader = ClassUtil.class.getClassLoader();
      if (Objects.isNull(classLoader)) {
        classLoader = ClassLoader.getSystemClassLoader();
      }
    }

    return classLoader;
  }

  /**
   * Determine if the specified class exists.
   *
   * @param className target class name
   * @return does it exist
   */
  public static boolean exists(String className) {
    try {
      Class.forName(className);
      return true;
    } catch (ClassNotFoundException e) {
      return false;
    }
  }
}
