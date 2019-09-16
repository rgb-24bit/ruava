package com.rgbit.ruava.core.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class StringUtilTest {
  @Test
  public void testStringTrans() {
    StringUtil.StringTrans trans = StringUtil.StringTrans.maketrans("abc", "def");

    assertThat(trans.translate("abcdefgabc"), equalTo("defdefgdef"));
  }
}
