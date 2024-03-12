package net.seface.moreblocks.block.featured;

import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class FeaturedRotatedPillarBlock extends RotatedPillarBlock {
    public static final BooleanProperty FEATURE_TEXTURE = BooleanProperty.create("needed_feature_enabled");

    private final FeatureFlag wantedFeature;

    public FeaturedRotatedPillarBlock(Properties properties, FeatureFlag wantedFeature) {
        super(properties);
        this.defaultBlockState().setValue(FEATURE_TEXTURE, false);
        this.wantedFeature = wantedFeature;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> property) {
        property.add(AXIS, FEATURE_TEXTURE);
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockCtx) {
        FeatureFlagSet features = blockCtx.getLevel().enabledFeatures();
        boolean featureTexture = features.contains(this.wantedFeature);

        return this.defaultBlockState()
                .setValue(AXIS, blockCtx.getClickedFace().getAxis())
                .setValue(FEATURE_TEXTURE, featureTexture);
    }
}
