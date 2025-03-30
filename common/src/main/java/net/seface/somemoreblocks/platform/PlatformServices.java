package net.seface.somemoreblocks.platform;

import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.platform.registry.PlatformRegistry;

import java.util.ServiceLoader;

public class PlatformServices {
  public static final PlatformHelper HELPER = tryToLoadService(PlatformHelper.class);
  public static final PlatformRegistry REGISTRY = HELPER.getRegistry();

  public static <T> T tryToLoadService(Class<T> clazz) {
    final T service = ServiceLoader.load(clazz)
      .findFirst()
      .orElseThrow(() -> new NullPointerException("Error trying to load service for >> " + clazz.getName() + " <<"));

    SomeMoreBlocks.LOGGER.info("Loaded service: {}", service);
    return service;
  }
}
