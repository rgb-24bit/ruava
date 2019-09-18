package com.rgbit.ruava.support.json;

/**
 * An error occurred during Json serialization and serialization.
 *
 * @author rgb-24bit
 */
public class JsonCodecException extends RuntimeException {
  public JsonCodecException() {
    super();
  }

  public JsonCodecException(String message, Throwable cause) {
    super(message, cause);
  }

  public JsonCodecException(String message) {
    super(message);
  }

  public JsonCodecException(Throwable cause) {
    super(cause);
  }
}
