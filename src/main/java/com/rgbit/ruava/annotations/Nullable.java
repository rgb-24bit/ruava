package com.rgbit.ruava.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Denotes that a parameter, field or method return value can be null.
 */
@Retention(SOURCE)
@Target({METHOD, PARAMETER, FIELD})
public @interface Nullable {}
