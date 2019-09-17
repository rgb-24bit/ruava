package com.rgbit.ruava.beans;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import com.rgbit.ruava.core.annotations.Nullable;
import net.sf.cglib.beans.BeanCopier;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static java.lang.String.format;

/**
 * Added a cache to a wrapper around BeanCopier.
 *
 * Reference:
 *   https://segmentfault.com/a/1190000006922799
 *
 * @author rgb-24bit
 */
public class WrappedBeanCopier {
  /**
   * Cache for {@link BeanCopier}.
   */
  private static final Map<String, BeanCopier> BEAN_COPIER_CACHE = new ConcurrentHashMap<>();

  /**
   * Cache for {@link ConstructorAccess}.
   */
  private static final Map<String, ConstructorAccess> CONSTRUCTOR_ACCESS_CACHE = new ConcurrentHashMap<>();

  private WrappedBeanCopier() {}

  /**
   * Create an instance of the target type and copy the same name attribute of the source object.
   *
   * @param source      source object
   * @param targetClass target class
   * @param <T>         target type
   * @return copy result
   */
  @Nullable
  public static <T> T copyProperties(Object source, Class<T> targetClass) {
    if (Objects.nonNull(source)) {
      T target = null;
      try {
        target = targetClass.newInstance();
      } catch (InstantiationException | IllegalAccessException e) {
        throw new RuntimeException(format("Create new instance of %s failed: %s", targetClass, e.getMessage()));
      }
      copyProperties(source, target);
      return target;
    }
    return null;
  }

  /**
   * Create a copy of the list object.
   *
   * @param sourceList  source list
   * @param targetClass target class
   * @param <T>         target type
   * @return copy result
   */
  public static <T> List<T> copyPropertiesOfList(List<?> sourceList, Class<T> targetClass) {
    if (sourceList == null || sourceList.size() == 0) {
      return Collections.emptyList();
    }
    ConstructorAccess<T> constructorAccess = getConstructorAccess(targetClass);
    return sourceList.stream().map(item -> {
      T target = constructorAccess.newInstance();
      copyProperties(item, target);
      return target;
    }).collect(Collectors.toList());
  }

  /**
   * Copy object with the same name attribute.
   *
   * @param source source object
   * @param target target object
   * @return target object
   */
  public static Object copyProperties(Object source, Object target) {
    BeanCopier copier = getBeanCopier(source.getClass(), target.getClass());
    copier.copy(source, target, null);
    return target;
  }

  /**
   * Get the {@link BeanCopier} instance, will be put into the cache when it does not exist.
   *
   * @param sourceClass source class
   * @param targetClass target class
   * @return {@link BeanCopier} instance
   */
  private static BeanCopier getBeanCopier(Class sourceClass, Class targetClass) {
    String beanKey = generateKey(sourceClass, targetClass);
    BeanCopier copier = null;
    if (!BEAN_COPIER_CACHE.containsKey(beanKey)) {
      copier = BeanCopier.create(sourceClass, targetClass, false);
      BEAN_COPIER_CACHE.put(beanKey, copier);
    } else {
      copier = BEAN_COPIER_CACHE.get(beanKey);
    }
    return copier;
  }

  /**
   * Generate keys for caching BeanCopier.
   *
   * @param sourceClass source class
   * @param targetClass target class
   * @return cache key
   */
  private static String generateKey(Class<?> sourceClass, Class<?> targetClass) {
    return sourceClass.toString() + targetClass.toString();
  }

  /**
   * Get the constructor access method of the target type.
   *
   * @param targetClass target class
   * @param <T> target type
   * @return Target class's {@link ConstructorAccess}
   */
  private static <T> ConstructorAccess<T> getConstructorAccess(Class<T> targetClass) {
    ConstructorAccess constructorAccess = CONSTRUCTOR_ACCESS_CACHE.get(targetClass.toString());

    if (Objects.nonNull(constructorAccess)) {
      return constructorAccess;
    }

    try {
      constructorAccess = ConstructorAccess.get(targetClass);
      constructorAccess.newInstance();
      CONSTRUCTOR_ACCESS_CACHE.put(targetClass.toString(), constructorAccess);
    } catch (Exception e) {
      throw new RuntimeException(format("Create new instance of %s failed: %s", targetClass, e.getMessage()));
    }
    return constructorAccess;
  }
}
