package net.seface.somemoreblocks.platform;

import lombok.Getter;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.platform.registry.PlatformRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

  public enum Platforms {
    FABRIC(0, "Fabric"),
    FORGE(1, "Forge"),
    NEOFORGE(2, "NeoForge");

    private final int index;

    @Getter
    private final String name;

    Platforms(int index, String name) {
      this.index = index;
      this.name = name;
    }
  }
}
