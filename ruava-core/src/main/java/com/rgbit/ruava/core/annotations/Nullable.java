package com.rgbit.ruava.core.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Denotes that a parameter, field or method return value can be null.
 *
 * @author rgb-24bit
 */
@Target({METHOD, PARAMETER, FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Nullable {}
