package net.seface.somemoreblocks.datagen.providers.data.worldgen.providers;

import lombok.Getter;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFeatureProvider<FC extends FeatureConfiguration> {
  private HolderGetter<ConfiguredFeature<?, ?>> holder;
  private final Feature<FC> feature;
  private List<PlacementModifier> modifier;

  @Getter
  private ResourceKey<PlacedFeature> placedFeatureKey;

  @Getter
  private ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey;

  public AbstractFeatureProvider(Feature<FC> feature) {
    this.feature = feature;
    this.modifier = new ArrayList<>();
  }

  /**
   * All the placed feature configured for this feature.
   * @param modifier The current modifiers.
   */
  protected abstract void placed(List<PlacementModifier> modifier);

  /**
   * All the placed configuration for this feature.
   */
  protected abstract FC configuration();

  /**
   * List all the modifiers used on placed feature configuration.
   */
  public List<PlacementModifier> getModifiers() {
    return this.modifier;
  }

  /**
   * Set the Placed Feature Resource Key.
   * @param key The resource key.
   */
  @SuppressWarnings("unchecked")
  public <T extends AbstractFeatureProvider<?>> T setPlacedFeatureKey(ResourceKey<PlacedFeature> key) {
    this.placedFeatureKey = key;
    return (T) this;
  }

  /**
   * Set the Configured Feature Resource Key.
   * @param key The resource key.
   */
  @SuppressWarnings("unchecked")
  public <T extends AbstractFeatureProvider<?>> T setConfiguredFeatureKey(ResourceKey<ConfiguredFeature<?, ?>> key) {
    this.configuredFeatureKey = key;
    return (T) this;
  }

  /**
   * Get the current placed feature.
   */
  public PlacedFeature getPlacedFeature() {
    this.placed(this.modifier);
    return new PlacedFeature(this.holder.getOrThrow(this.configuredFeatureKey), this.modifier);
  }

  /**
   * Get the current configured feature.
   */
  public ConfiguredFeature<?, ?> getConfiguredFeature() {
    return new ConfiguredFeature<>(this.feature, this.configuration());
  }

  /**
   * Register the Placed Feature to the provider.
   * @param context The bootstrap context to register the Placed Feature.
   */
  public void registerPlaceFeature(BootstapContext<PlacedFeature> context) {
    this.holder = context.lookup(Registries.CONFIGURED_FEATURE);
    context.register(this.placedFeatureKey, this.getPlacedFeature());
  }

  /**
   * Register the Configured Feature to the provider.
   * @param context The bootstrap context to register the Configured Feature.
   */
  public void registerConfiguredFeature(BootstapContext<ConfiguredFeature<?, ?>> context) {
    context.register(this.configuredFeatureKey, this.getConfiguredFeature());
  }
}
