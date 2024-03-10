package net.seface.moreblocks.mixin;

import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.WallSide;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = WallBlock.class)
public class WallBlockMixin extends Block implements SimpleWaterloggedBlock {
    @Shadow @Final public static BooleanProperty UP;
    @Shadow @Final public static EnumProperty<WallSide> EAST_WALL;
    @Shadow @Final public static EnumProperty<WallSide> NORTH_WALL;
    @Shadow @Final public static EnumProperty<WallSide> SOUTH_WALL;
    @Shadow @Final public static EnumProperty<WallSide> WEST_WALL;
    @Shadow @Final public static BooleanProperty WATERLOGGED;

    @Unique
    private static final BooleanProperty FEATURE_TEXTURE = BooleanProperty.create("needed_feature_enabled");

    /**
     * Control the texture between >1.21 version and <1.21.
     * To not add new blocks, we are using this state to switch between the textures. <br/>
     * The texture only update if the world are using the Update 1.21 Experimental Feature.
     */
    @Unique
    private static final FeatureFlag WANTED_FEATURE = FeatureFlags.UPDATE_1_21;

    public WallBlockMixin(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(UP, true)
                .setValue(NORTH_WALL, WallSide.NONE)
                .setValue(EAST_WALL, WallSide.NONE)
                .setValue(SOUTH_WALL, WallSide.NONE)
                .setValue(WEST_WALL, WallSide.NONE)
                .setValue(WATERLOGGED, false)
                .setValue(FEATURE_TEXTURE, false)
        );
    }

    @Inject(method = "createBlockStateDefinition", at = @At("HEAD"))
    private void $createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> property, CallbackInfo ci) {
        property.add(FEATURE_TEXTURE);
    }

    @Inject(method = "getStateForPlacement", at = @At("RETURN"), cancellable = true)
    private void $getStateForPlacement(BlockPlaceContext blockCtx, CallbackInfoReturnable<BlockState> cir) {
        FeatureFlagSet features = blockCtx.getLevel().enabledFeatures();
        boolean featureTexture = features.contains(WANTED_FEATURE);

        cir.setReturnValue(cir.getReturnValue().setValue(FEATURE_TEXTURE, featureTexture));
    }
}
