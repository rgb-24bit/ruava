package com.rgbit.ruava.core.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PairTest {
  @Test
  public void testHash() {
    Pair<String, String> pairA = Pair.create("Left", "Right");
    Pair<String, String> pairB = Pair.create("Left", "Right");

    assertThat(pairA.equals(pairB), is(true));

    Map<Pair<String, String>, String> pairStringMap = new HashMap<>();

    pairStringMap.put(pairA, "value");

    assertThat(pairStringMap.get(pairB), equalTo("value"));
  }
}
