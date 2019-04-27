package com.rgbit.ruava.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class SugarTest {

  @Test
  public void as() {
    List<Integer> list = new ArrayList<>();

    assertNotNull(Sugar.as(ArrayList.class, list));
    assertNull(Sugar.as(LinkedList.class, list));
  }
}