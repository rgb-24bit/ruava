package com.rgbit.ruava.support.json;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Wrapper for deserializing the target type.
 *
 * @param <T> type parameter
 * @author rgb-24bit
 */
public abstract class TypeToken<T> {
  private final Type type;

  /**
   * Automatically get generic parameters when a subclass instance is created.
   */
  protected TypeToken() {
    this.type = getSuperclassTypeParameter(getClass());
  }

  /**
   * Get the type parameter of the generic parent class.
   */
  private static Type getSuperclassTypeParameter(Class<?> subclass) {
    Type superclass = subclass.getGenericSuperclass();
    if (superclass instanceof Class) {
      throw new RuntimeException("Missing type parameter.");
    }
    ParameterizedType parameterized = (ParameterizedType) superclass;
    return parameterized.getActualTypeArguments()[0];
  }

  public Type getType() {
    return type;
  }
}
