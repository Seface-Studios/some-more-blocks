package net.seface.somemoreblocks.platform;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;
import net.seface.somemoreblocks.SomeMoreBlocks;

public class ForgePlatformHelper implements PlatformHelper {

  @Override
  public String getPlatformName() {
    return "Forge";
  }

  @Override
  public boolean isModLoaded(String id) {
    return ModList.get().isLoaded(SomeMoreBlocks.ID);
  }

  @Override
  public PlatformEnvironment getEnvironment() {
    return !FMLLoader.isProduction() ? PlatformEnvironment.DEVELOPMENT : PlatformEnvironment.PRODUCTION;
  }

  @Override
  public PlatformRegistry getRegistry() {
    return new ForgePlatformRegistry();
  }
}
