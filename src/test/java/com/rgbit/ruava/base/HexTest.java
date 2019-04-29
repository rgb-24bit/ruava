package com.rgbit.ruava.base;

import org.junit.Test;

import static org.junit.Assert.*;

public class HexTest {

  @Test
  public void parseBytes() {
    byte[] bytes = {102, 127, -1};
    assertArrayEquals(bytes, Hex.parseBytes("667FFf"));
  }

  @Test
  public void toLowerString() {
    assertEquals("667fff", Hex.toLowerString(new byte[] {102, 127, -1}));
  }

  @Test
  public void toUpperString() {
    assertEquals("667FFF", Hex.toUpperString(new byte[] {102, 127, -1}));
  }
}