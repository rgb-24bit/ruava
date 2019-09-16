package com.rgbit.ruava.core.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class ByteUtilTest {
  @Test
  public void testByteArrayToHexString() {
    byte[] bytes = {(byte) 0x66, (byte) 0xCC, (byte) 0xFF};

    assertThat(ByteUtil.toLowerHexString(bytes), equalTo("66ccff"));
    assertThat(ByteUtil.toUpperHexString(bytes), equalTo("66CCFF"));
  }
}
