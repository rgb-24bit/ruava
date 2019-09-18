package com.rgbit.ruava.support.json;


import java.lang.reflect.Type;

/**
 * Json's serialization and deserialization capabilities provided by third-party packages.
 *
 * @author rgb-24bit
 */
public interface JsonProvider {
  /**
   * Serialized object.
   *
   * @param object target object
   * @return Json string
   * @throws JsonCodecException
   */
  String toJson(Object object) throws JsonCodecException;


  /**
   * Deserialize Json strings
   *
   * @param json    Json string
   * @param typeOfT target type
   * @param <T>     target type
   * @return Object
   * @throws JsonCodecException
   */
  <T> T fromJson(String json, Type typeOfT) throws JsonCodecException;

  /**
   * Deserialize Json strings
   *
   * @param json     Json string
   * @param classOfT target class
   * @param <T>      target type
   * @return Object
   * @throws JsonCodecException
   */
  <T> T fromJson(String json, Class<T> classOfT) throws JsonCodecException;
}
