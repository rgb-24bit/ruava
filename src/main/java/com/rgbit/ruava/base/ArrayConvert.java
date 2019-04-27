package com.rgbit.ruava.base;

import java.lang.reflect.Array;

public class ArrayConvert {
  /**
   * Convert primitive array to Object array.
   *
   * @param array primitive array.
   * @return Object array.
   */
  public static Integer[] toObject(int[] array) {
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
  public static int[] toPrimitive(Integer[] array) {
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
  public static Long[] toObject(long[] array) {
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
  public static long[] toPrimitive(Long[] array) {
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
  public static Boolean[] toObject(boolean[] array) {
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
  public static boolean[] toPrimitive(Boolean[] array) {
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
  public static Character[] toObject(char[] array) {
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
  public static char[] toPrimitive(Character[] array) {
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
  public static Double[] toObject(double[] array) {
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
  public static double[] toPrimitive(Double[] array) {
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
  public static Float[] toObject(float[] array) {
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
  public static float[] toPrimitive(Float[] array) {
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
  public static Byte[] toObject(byte[] array) {
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
  public static byte[] toPrimitive(Byte[] array) {
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
  public static Short[] toObject(short[] array) {
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
  public static short[] toPrimitive(Short[] array) {
    short[] newArray = new short[array.length];
    for (int i = 0; i < array.length; ++i) {
      newArray[i] = array[i];
    }
    return newArray;
  }

  /**
   * Conveniently convert arrays of primitive types and wrapper classes types.
   * <p>
   * <p>
   * Use like:
   *
   * <code>
   *   Integer[] integerArr = (Integer[]) arrayConvert(new int[] {1, 2, 3}, Integer.class);
   *   int[] intArr = (int[]) arrayConvert(new Integer[] {1, 2, 3}, int.class);
   * </code>
   *
   * @param array The array to be converted
   * @param clazz type to be converted to
   * @result Converted array
   */
  public static Object arrayConvert(Object array, Class<?> clazz) {
    Object newArray = Array.newInstance(clazz, Array.getLength(array));

    for (int i = 0; i < Array.getLength(array); ++i) {
      Array.set(newArray, i, Array.get(array, i));
    }

    return newArray;
  }
}
