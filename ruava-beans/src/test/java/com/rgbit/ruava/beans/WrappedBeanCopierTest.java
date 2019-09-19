package com.rgbit.ruava.beans;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class WrappedBeanCopierTest {
  @Test
  public void testCopyIsSuccess() {
    SourceObject sourceObject = new SourceObject("String", 7, 13);

    sourceObject.setList(Arrays.asList(sourceObject, sourceObject, sourceObject));
    sourceObject.setObject(new SourceObject());

    TargetObject targetObject = WrappedBeanCopier.copyProperties(sourceObject, TargetObject.class);

    assertThat(targetObject.getString(), equalTo(sourceObject.getString()));
    assertThat(targetObject.getPrimitive(), equalTo(sourceObject.getPrimitive()));
    assertThat(targetObject.getBoxed(), equalTo(sourceObject.getBoxed()));
    assertThat(targetObject.getList().size(), equalTo(sourceObject.getList().size()));
    assertThat(targetObject.getObject().getString(), equalTo(sourceObject.getObject().getString()));
  }

  public static class SourceObject {
    private String string;

    private int primitive;

    private Integer boxed;

    private List<SourceObject> list;

    private SourceObject object;

    public SourceObject() {}

    public SourceObject(String string, int primitive, Integer boxed) {
      this.string = string;
      this.primitive = primitive;
      this.boxed = boxed;
    }

    public String getString() {
      return string;
    }

    public void setString(String string) {
      this.string = string;
    }

    public int getPrimitive() {
      return primitive;
    }

    public void setPrimitive(int primitive) {
      this.primitive = primitive;
    }

    public Integer getBoxed() {
      return boxed;
    }

    public void setBoxed(Integer boxed) {
      this.boxed = boxed;
    }

    public List<SourceObject> getList() {
      return list;
    }

    public void setList(List<SourceObject> list) {
      this.list = list;
    }

    public SourceObject getObject() {
      return object;
    }

    public void setObject(SourceObject object) {
      this.object = object;
    }
  }

  public static class TargetObject {
    private String string;

    private int primitive;

    private Integer boxed;

    private List<TargetObject> list;

    private TargetObject object;

    public TargetObject() {}

    public TargetObject(String string, int primitive, Integer boxed) {
      this.string = string;
      this.primitive = primitive;
      this.boxed = boxed;
    }

    public String getString() {
      return string;
    }

    public void setString(String string) {
      this.string = string;
    }

    public int getPrimitive() {
      return primitive;
    }

    public void setPrimitive(int primitive) {
      this.primitive = primitive;
    }

    public Integer getBoxed() {
      return boxed;
    }

    public void setBoxed(Integer boxed) {
      this.boxed = boxed;
    }

    public List<TargetObject> getList() {
      return list;
    }

    public void setList(List<TargetObject> list) {
      this.list = list;
    }

    public TargetObject getObject() {
      return object;
    }

    public void setObject(TargetObject object) {
      this.object = object;
    }
  }
}
