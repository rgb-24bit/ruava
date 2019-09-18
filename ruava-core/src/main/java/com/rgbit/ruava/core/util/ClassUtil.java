package com.rgbit.ruava.core.util;

/**
 * Java class util.
 *
 * @author rgb-24bit
 */
public class ClassUtil {
  /**
   * Get current class loader.
   *
   * @return current class loader
   */
  public static ClassLoader getClassLoader() {
    ClassLoader classLoader;
    try {
      classLoader = Thread.currentThread().getContextClassLoader();
    } catch (Throwable e) {
      classLoader = ClassUtil.class.getClassLoader();
    }
    return classLoader;
  }
}
