package com.rgbit.ruava.support.json;

import com.rgbit.ruava.core.util.ClassUtil;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.ServiceLoader;

/**
 * Default factory for creating {@link JsonProvider}
 *
 * @author rgb-24bit
 */
public class DefaultJsonProviderFactory implements JsonProviderFactory {
  /**
   * Json mode is supported by default
   */
  private static final Map<String, String> SUPPORTED_PROVIDER = new LinkedHashMap<>();

  static {
    SUPPORTED_PROVIDER.put("com.google.gson.Gson", "com.rgbit.ruava.support.json.provider.GsonProvider");
    SUPPORTED_PROVIDER.put("com.fasterxml.jackson.databind.ObjectMapper", "com.rgbit.ruava.support.json.provider.JacksonProvider");
    SUPPORTED_PROVIDER.put("com.alibaba.fastjson.JSON", "com.rgbit.ruava.support.json.provider.FastjsonProvider");
  }

  @Override
  public JsonProvider create() {
    JsonProvider jsonProvider = getSPIJsonProvider();

    if (Objects.nonNull(jsonProvider)) {
      return jsonProvider;
    }

    Class<JsonProvider> clazz = getJsonProviderClass();

    if (Objects.isNull(clazz)) {
      throw new NullPointerException("JsonProvider cannot be found");
    }

    try {
      jsonProvider = clazz.getDeclaredConstructor().newInstance();
    } catch (Exception e) {
      throw new RuntimeException("JsonProvider instance create failed", e);
    }

    return jsonProvider;
  }

  @SuppressWarnings("unchecked")
  protected Class<JsonProvider> getJsonProviderClass() {
    Class<JsonProvider> clazz = null;

    for (Entry<String, String> entry : SUPPORTED_PROVIDER.entrySet()) {
      try {
        Class.forName(entry.getKey());
        clazz = (Class<JsonProvider>) Class.forName(entry.getValue());
        break;
      } catch (Exception ignore) {
      }
    }

    return clazz;
  }

  protected JsonProvider getSPIJsonProvider() {
    try {
      ServiceLoader<JsonProvider> serviceLoader = ServiceLoader.load(JsonProvider.class, ClassUtil.getClassLoader());
      for (JsonProvider f : serviceLoader) {
        return f;
      }
    } catch (Throwable ignore) {
    }
    return null;
  }
}
