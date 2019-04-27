package com.rgbit.ruava.base;

public class Sugar {
  public static <T> T as(Class<T> clazz, Object o) {
    if (clazz.isInstance(o)) {
      return clazz.cast(o);
    }
    return null;
  }
}
