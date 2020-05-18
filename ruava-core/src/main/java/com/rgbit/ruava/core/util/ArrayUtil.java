package com.rgbit.ruava.core.util;

/**
 * Java array util class.
 *
 * @author rgb-24bit
 */
public class ArrayUtil {
  /**
   * Convert primitive array to Object array.
   *
   * @param array primitive array.
   * @return Object array.
   */
  public static Integer[] boxed(int[] array) {
    Integer[] newArray = new Integer[array.length];
    for (int i = 0; i < array.length; ++i) {
      newArray[i] = array[i];
    }
    return newArray;
  }

  /**
   * Convert Object array to primitive array.
   *
   * @param array Object array.
   * @return primitive array.
   */
  public static int[] unboxed(Integer[] array) {
    int[] newArray = new int[array.length];
    for (int i = 0; i < array.length; ++i) {
      newArray[i] = array[i];
    }
    return newArray;
  }

  /**
   * Convert primitive array to Object array.
   *
   * @param array primitive array.
   * @return Object array.
   */
  public static Long[] boxed(long[] array) {
    Long[] newArray = new Long[array.length];
    for (int i = 0; i < array.length; ++i) {
      newArray[i] = array[i];
    }
    return newArray;
  }

  /**
   * Convert Object array to primitive array.
   *
   * @param array Object array.
   * @return primitive array.
   */
  public static long[] unboxed(Long[] array) {
    long[] newArray = new long[array.length];
    for (int i = 0; i < array.length; ++i) {
      newArray[i] = array[i];
    }
    return newArray;
  }

  /**
   * Convert primitive array to Object array.
   *
   * @param array primitive array.
   * @return Object array.
   */
  public static Boolean[] boxed(boolean[] array) {
    Boolean[] newArray = new Boolean[array.length];
    for (int i = 0; i < array.length; ++i) {
      newArray[i] = array[i];
    }
    return newArray;
  }

  /**
   * Convert Object array to primitive array.
   *
   * @param array Object array.
   * @return primitive array.
   */
  public static boolean[] unboxed(Boolean[] array) {
    boolean[] newArray = new boolean[array.length];
    for (int i = 0; i < array.length; ++i) {
      newArray[i] = array[i];
    }
    return newArray;
  }

  /**
   * Convert primitive array to Object array.
   *
   * @param array primitive array.
   * @return Object array.
   */
  public static Character[] boxed(char[] array) {
    Character[] newArray = new Character[array.length];
    for (int i = 0; i < array.length; ++i) {
      newArray[i] = array[i];
    }
    return newArray;
  }

  /**
   * Convert Object array to primitive array.
   *
   * @param array Object array.
   * @return primitive array.
   */
  public static char[] unboxed(Character[] array) {
    char[] newArray = new char[array.length];
    for (int i = 0; i < array.length; ++i) {
      newArray[i] = array[i];
    }
    return newArray;
  }

  /**
   * Convert primitive array to Object array.
   *
   * @param array primitive array.
   * @return Object array.
   */
  public static Double[] boxed(double[] array) {
    Double[] newArray = new Double[array.length];
    for (int i = 0; i < array.length; ++i) {
      newArray[i] = array[i];
    }
    return newArray;
  }

  /**
   * Convert Object array to primitive array.
   *
   * @param array Object array.
   * @return primitive array.
   */
  public static double[] unboxed(Double[] array) {
    double[] newArray = new double[array.length];
    for (int i = 0; i < array.length; ++i) {
      newArray[i] = array[i];
    }
    return newArray;
  }

  /**
   * Convert primitive array to Object array.
   *
   * @param array primitive array.
   * @return Object array.
   */
  public static Float[] boxed(float[] array) {
    Float[] newArray = new Float[array.length];
    for (int i = 0; i < array.length; ++i) {
      newArray[i] = array[i];
    }
    return newArray;
  }

  /**
   * Convert Object array to primitive array.
   *
   * @param array Object array.
   * @return primitive array.
   */
  public static float[] unboxed(Float[] array) {
    float[] newArray = new float[array.length];
    for (int i = 0; i < array.length; ++i) {
      newArray[i] = array[i];
    }
    return newArray;
  }

  /**
   * Convert primitive array to Object array.
   *
   * @param array primitive array.
   * @return Object array.
   */
  public static Byte[] boxed(byte[] array) {
    Byte[] newArray = new Byte[array.length];
    for (int i = 0; i < array.length; ++i) {
      newArray[i] = array[i];
    }
    return newArray;
  }

  /**
   * Convert Object array to primitive array.
   *
   * @param array Object array.
   * @return primitive array.
   */
  public static byte[] unboxed(Byte[] array) {
    byte[] newArray = new byte[array.length];
    for (int i = 0; i < array.length; ++i) {
      newArray[i] = array[i];
    }
    return newArray;
  }

  /**
   * Convert primitive array to Object array.
   *
   * @param array primitive array.
   * @return Object array.
   */
  public static Short[] boxed(short[] array) {
    Short[] newArray = new Short[array.length];
    for (int i = 0; i < array.length; ++i) {
      newArray[i] = array[i];
    }
    return newArray;
  }

  /**
   * Convert Object array to primitive array.
   *
   * @param array Object array.
   * @return primitive array.
   */
  public static short[] unboxed(Short[] array) {
    short[] newArray = new short[array.length];
    for (int i = 0; i < array.length; ++i) {
      newArray[i] = array[i];
    }
    return newArray;
  }
}
