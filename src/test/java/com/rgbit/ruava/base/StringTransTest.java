package com.rgbit.ruava.base;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringTransTest {

  @Test
  public void translate() {
    StringTrans trans = StringTrans.maketrans("abc", "def");
    assertEquals(trans.translate("abcderad"), "defderdd");
  }
}