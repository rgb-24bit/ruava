package com.rgbit.ruava.core.lang;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SugarTest {
  @Test
  public void testAs() {
    CharSequence charSequence = "A test string";

    assertThat(Sugar.as(String.class, charSequence).isPresent(), is(true));
    assertThat(Sugar.as(Integer.class, charSequence).isPresent(), is(false));
  }
}
