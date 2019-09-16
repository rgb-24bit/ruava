package com.rgbit.ruava.core.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SystemUtilTest {
  @Test
  public void testExpandVars() {
    String home = System.getenv("JAVA_HOME");

    assertThat(SystemUtil.expandvars("${JAVA_HOME}/FILE").startsWith(home), is(true));
  }
}
