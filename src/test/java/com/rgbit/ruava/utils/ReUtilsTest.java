package com.rgbit.ruava.utils;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class ReUtilsTest {

  @Test
  public void findAll() {
    String target = "Hello my friend!";
    assertEquals(ReUtils.findAll(Pattern.compile("\\w+"), target).size(), 3);
  }
}