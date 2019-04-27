package com.rgbit.ruava.base;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayConvertTest {

  @Test
  public void toObject() {
    int[] arr = new int[] {1, 2, 3};
    assertEquals(ArrayConvert.toObject(arr).getClass(), Integer[].class);
  }

  @Test
  public void toPrimitive() {
    Integer[] arr = new Integer[] {1, 2, 3};
    assertEquals(ArrayConvert.toPrimitive(arr).getClass(), int[].class);
  }

  @Test
  public void arrayConvert() {
    int[] arr = new int[] {1, 2, 3};
    assertEquals(ArrayConvert.arrayConvert(arr, Integer.class).getClass(), Integer[].class);
  }
}