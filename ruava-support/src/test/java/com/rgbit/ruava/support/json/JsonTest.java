package com.rgbit.ruava.support.json;

import org.junit.Test;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class JsonTest {

  @Test
  public void testJson() {
    TestObject testObject = new TestObject();

    testObject.setName("Test");
    testObject.setAge(17);

    TestObject fromJson = Json.fromJson(Json.toJson(testObject), TestObject.class);

    assertThat(fromJson.getName(), equalTo(testObject.getName()));
    assertThat(fromJson.getAge(), equalTo(testObject.getAge()));
  }

  @Test
  public void testJsonWithTypeToken() {
    TestObject testObject = new TestObject();

    testObject.setName("Test");
    testObject.setAge(17);

    List<TestObject> testObjects = Json.fromJson(Json.toJson(Arrays.asList(testObject, testObject, testObject)),
      new TypeToken<List<TestObject>>() {}.getType());

    assertThat(testObjects.size(), equalTo(3));
    System.out.println(testObjects.get(0));
    assertThat(testObjects.get(0).getName(), equalTo("Test"));
    assertThat(testObjects.get(0).getAge(), equalTo(17));
  }

  public static class TestObject {
    private String name;

    private int age;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }
  }
}
