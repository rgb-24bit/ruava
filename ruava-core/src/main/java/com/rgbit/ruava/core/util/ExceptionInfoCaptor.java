package com.rgbit.ruava.core.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Capture exception info.
 *
 * @author rgb-24bit
 */
public class ExceptionInfoCaptor {
  /**
   * exception message
   */
  private String message;

  /**
   * stack trace info
   */
  private List<String> stackTrace;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<String> getStackTrace() {
    return stackTrace;
  }

  public void setStackTrace(List<String> stackTrace) {
    this.stackTrace = stackTrace;
  }

  /**
   * Create {@link ExceptionInfoCaptor} from {@link Throwable}
   *
   * @param ex exception
   * @return ExceptionInfoCaptor
   */
  public static ExceptionInfoCaptor of(Throwable ex) {
    ExceptionInfoCaptor exceptionInfoCaptor = new ExceptionInfoCaptor();

    exceptionInfoCaptor.setMessage(ex.getMessage());

    List<String> stackTrace = new ArrayList<>();
    while (Objects.nonNull(ex)) {
      StackTraceElement stackTraceElement = ex.getStackTrace()[0];

      stackTrace.add(String.format("%s at %s(%s:%d)", stackTraceElement.getClassName(), stackTraceElement.getMethodName(), stackTraceElement.getFileName(),
        stackTraceElement.getLineNumber()));

      ex = ex.getCause();
    }
    exceptionInfoCaptor.setStackTrace(stackTrace);

    return exceptionInfoCaptor;
  }
}
