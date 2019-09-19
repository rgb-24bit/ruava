package com.rgbit.ruava.support.json;


import com.rgbit.ruava.core.annotations.Nullable;

import java.lang.reflect.Type;
import java.util.Objects;

/**
 * Encapsulation of third-party Json package functionality
 *
 * @author rgb-24bit
 */
public class Json {
  private static JsonProvider jsonProvider = new DefaultJsonProviderFactory().create();

  /**
   * Serialize the object into a Json string.
   *
   * @param src The object to be serialized
   * @return Serialized Json string
   * @throws JsonCodecException Codec exception
   */
  @Nullable
  public static String toJson(Object src) throws JsonCodecException {
    if (Objects.nonNull(src)) {
      return jsonProvider.toJson(src);
    }
    return null;
  }

  /**
   * Deserialize a Json string into an object.
   * <p>
   * Usage:
   *
   * <pre>
   *   Map<String, String> map = Json.fromJson(json, TypeToken.create());
   * </pre>
   *
   * @param json    Json string
   * @param typeOfT Used to adapt generics
   * @param <T>     Data generic
   * @return Deserialized object
   * @throws JsonCodecException Codec exception
   */
  @Nullable
  public static <T> T fromJson(String json, TypeToken<T> typeOfT) throws JsonCodecException {
    if (isEmptyString(json)) {
      return null;
    }
    return jsonProvider.fromJson(json, typeOfT.getType());
  }

  /**
   * Deserialize a Json string into an object.
   *
   * @param json    Json string
   * @param typeOfT Used to adapt generics
   * @param <T>     Data generic
   * @return Deserialized object
   * @throws JsonCodecException Codec exception
   */
  @Nullable
  public static <T> T fromJson(String json, Type typeOfT) throws JsonCodecException {
    if (isEmptyString(json)) {
      return null;
    }
    return jsonProvider.fromJson(json, typeOfT);
  }

  /**
   * Deserialize a json string into an object.
   *
   * @param json     Json string
   * @param classOfT Type that needs to be deserialized
   * @param <T>      Data generic
   * @return Deserialized object
   * @throws JsonCodecException Codec exception
   */
  @Nullable
  public static <T> T fromJson(String json, Class<T> classOfT) throws JsonCodecException {
    if (isEmptyString(json)) {
      return null;
    }
    return jsonProvider.fromJson(json, classOfT);
  }

  private static boolean isEmptyString(String str) {
    return str == null || str.length() == 0;
  }
}
