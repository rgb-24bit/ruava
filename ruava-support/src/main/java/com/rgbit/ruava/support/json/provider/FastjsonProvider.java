package com.rgbit.ruava.support.json.provider;

import com.alibaba.fastjson.JSON;
import com.rgbit.ruava.support.json.JsonCodecException;
import com.rgbit.ruava.support.json.JsonProvider;

import java.lang.reflect.Type;

import static com.alibaba.fastjson.JSON.DEFAULT_PARSER_FEATURE;

/**
 * JsonProvider for fastjson
 *
 * @author rgb-24bit
 */
public class FastjsonProvider implements JsonProvider {

  @Override
  public String toJson(Object object) {
    try {
      return JSON.toJSONString(object);
    } catch (Exception e) {
      throw new JsonCodecException(e);
    }
  }

  @Override
  public <T> T fromJson(String json, Type typeOfT) {
    try {
      return JSON.parseObject(json, typeOfT, DEFAULT_PARSER_FEATURE);
    } catch (Exception e) {
      throw new JsonCodecException(e);
    }
  }

  @Override
  public <T> T fromJson(String json, Class<T> classOfT) {
    try {
      return JSON.parseObject(json, classOfT);
    } catch (Exception e) {
      throw new JsonCodecException(e);
    }
  }
}
