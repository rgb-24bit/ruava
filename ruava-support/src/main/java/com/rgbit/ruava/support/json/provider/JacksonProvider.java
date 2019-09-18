package com.rgbit.ruava.support.json.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.rgbit.ruava.support.json.JsonCodecException;
import com.rgbit.ruava.support.json.JsonProvider;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * JsonProvider for Jackson
 *
 * @author rgb-24bit
 */
public class JacksonProvider implements JsonProvider {
  private ObjectMapper objMapper = new ObjectMapper();

  private TypeFactory typeFactory = TypeFactory.defaultInstance();

  @Override
  public String toJson(Object object) {
    try {
      return objMapper.writeValueAsString(object);
    } catch (IOException e) {
      throw new JsonCodecException(e);
    }
  }

  @Override
  public <T> T fromJson(String json, Type typeOfT) {
    try {
      return objMapper.readValue(json, typeFactory.constructType(typeOfT));
    } catch (IOException e) {
      throw new JsonCodecException(e);
    }
  }

  @Override
  public <T> T fromJson(String json, Class<T> classOfT) {
    try {
      return objMapper.readValue(json, classOfT);
    } catch (IOException e) {
      throw new JsonCodecException(e);
    }
  }
}
