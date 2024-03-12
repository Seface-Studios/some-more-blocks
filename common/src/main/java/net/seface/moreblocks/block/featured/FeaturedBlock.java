package net.seface.moreblocks.block.featured;

import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class FeaturedBlock extends Block {
    public static final BooleanProperty FEATURE_TEXTURE = BooleanProperty.create("needed_feature_enabled");

    private final FeatureFlag wantedFeature;

    public FeaturedBlock(Properties properties, FeatureFlag wantedFeature) {
        super(properties);
        this.defaultBlockState().setValue(FEATURE_TEXTURE, false);
        this.wantedFeature = wantedFeature;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> property) {
        property.add(FEATURE_TEXTURE);
    }

    public BlockState getStateForPlacement(BlockPlaceContext block) {
        FeatureFlagSet features = block.getLevel().enabledFeatures();
        boolean featureTexture = features.contains(this.wantedFeature);

        return this.defaultBlockState().setValue(FEATURE_TEXTURE, featureTexture);
    }
}
