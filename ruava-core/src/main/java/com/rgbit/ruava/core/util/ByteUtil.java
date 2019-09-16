package com.rgbit.ruava.core.util;

/**
 * Java byte util class.
 *
 * @author rgb-24bit
 */
public class ByteUtil {
  private static char[] lowerHexChars = "0123456789abcdef".toCharArray();
  private static char[] upperHexChars = "0123456789ABCDEF".toCharArray();

  /**
   * Convert byte array to lower hex string.
   *
   * @param bytes byte array
   * @return lower hex string
   */
  public static String toLowerHexString(byte[] bytes) {
    return toHexString(bytes, lowerHexChars);
  }

  /**
   * Convert byte array to upper hex string.
   *
   * @param bytes byte array
   * @return upper hex string
   */
  public static String toUpperHexString(byte[] bytes) {
    return toHexString(bytes, upperHexChars);
  }

  private static String toHexString(byte[] bytes, char[] hexChars) {
    char[] chars = new char[bytes.length << 1];
    for (int i = 0; i < bytes.length; i++) {
      int val = bytes[i] & 0xFF;
      chars[i << 1] = hexChars[val >>> 4];
      chars[(i << 1) + 1] = hexChars[val & 0xF];
    }
    return new String(chars);
  }
}
