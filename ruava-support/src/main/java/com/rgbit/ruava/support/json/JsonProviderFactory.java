package com.rgbit.ruava.support.json;

/**
 * Factory for creating JsonProvider.
 *
 * @author rgb-24bit
 */
public interface JsonProviderFactory {
  /**
   * Create the JsonProvider.
   *
   * @return JsonProvider instance
   */
  JsonProvider create();
}
