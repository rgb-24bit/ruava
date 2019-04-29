package com.rgbit.ruava.base;

public class Hex {
  public static byte[] parseBytes(String hexString) {
    byte[] bytes = new byte[hexString.length() / 2];

    for (int i = 0; i < bytes.length; i++) {
      int index = i * 2;
      bytes[i] = (byte) Integer.parseInt(hexString.substring(index, index + 2), 16);
    }

    return bytes;
  }

  private static String toString(byte[] bytes, String format) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < bytes.length; ++i) {
      sb.append(String.format(format, bytes[i]));
    }

    return sb.toString();
  }

  public static String toLowerString(byte[] bytes) {
    return toString(bytes, "%02x");
  }

  public static String toUpperString(byte[] bytes) {
    return toString(bytes, "%02X");
  }
}
