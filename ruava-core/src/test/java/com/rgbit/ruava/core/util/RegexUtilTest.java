package com.rgbit.ruava.core.util;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class RegexUtilTest {
  @Test
  public void testFindAll() {
    List<String> words = RegexUtil.findAll("\\w+", "This is a test string.");

    assertThat(words.size(), equalTo(5));
  }
}
