package com.rgbit.ruava.collect;

import org.junit.Test;

import static org.junit.Assert.*;

public class PairTest {

  @Test
  public void create() {
    Pair<String, Integer> pair = Pair.create("left", 10);
    assertEquals(pair, pair);
  }
}