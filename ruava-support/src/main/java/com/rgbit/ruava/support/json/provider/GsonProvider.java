package com.rgbit.ruava.support.json.provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.rgbit.ruava.support.json.JsonCodecException;
import com.rgbit.ruava.support.json.JsonProvider;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

/**
 * JsonProvider for gson.
 *
 * @author rgb-24bit
 */
public class GsonProvider implements JsonProvider {
  private static Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateTypeAdapter()).create();

  @Override
  public String toJson(Object object) {
    try {
      return gson.toJson(object);
    } catch (Exception e) {
      throw new JsonCodecException(e);
    }
  }

  @Override
  public <T> T fromJson(String json, Type typeOfT) {
    try {
      return gson.fromJson(json, typeOfT);
    } catch (Exception e) {
      throw new JsonCodecException(e);
    }
  }

  @Override
  public <T> T fromJson(String json, Class<T> classOfT) {
    try {
      return gson.fromJson(json, classOfT);
    } catch (Exception e) {
      throw new JsonCodecException(e);
    }
  }

  /**
   * Time adapter.
   *
   * @author rgb-24bit
   */
  static class DateTypeAdapter implements JsonDeserializer<Date> {

    private DateFormat format;

    DateTypeAdapter() {}

    DateTypeAdapter(DateFormat format) {
      this.format = format;
    }

    @Override
    public synchronized Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
      if (!(json instanceof JsonPrimitive)) {
        throw new JsonParseException("This is not a primitive value");
      }

      String jsonStr = json.getAsString();

      if (Objects.nonNull(format)) {
        try {
          return format.parse(jsonStr);
        } catch (ParseException e) {
          throw new JsonParseException(e);
        }
      }

      return new Date(Long.parseLong(jsonStr));
    }
  }
}
