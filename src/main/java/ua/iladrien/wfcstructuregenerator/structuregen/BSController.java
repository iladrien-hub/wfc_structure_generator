package ua.iladrien.wfcstructuregenerator.structuregen;


import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SixWayBlock;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.SlabType;

public class BSController {

    public static BlockState upSideSlab(BlockState initial) {
        return initial.with(BlockStateProperties.SLAB_TYPE, SlabType.TOP);
    }

    public static BlockState setAxisByDirection(BlockState initial, Direction dir) {
        if (dir == Direction.WEST || dir == Direction.EAST)
            return initial.with(RotatedPillarBlock.AXIS, net.minecraft.util.Direction.Axis.X);
        return initial.with(RotatedPillarBlock.AXIS, net.minecraft.util.Direction.Axis.Z);
    }

    public static BlockState upSideDown(BlockState initial) {
        return initial.with(BlockStateProperties.HALF, Half.TOP);
    }

    public static BlockState setFacing(BlockState initial, Direction dir) {
        return initial.with(HorizontalBlock.HORIZONTAL_FACING, dir.minecraftValue());
    }

    public static BlockState SixWayBlock2 (BlockState initial, Direction dir) {
        if (dir == Direction.WEST || dir == Direction.EAST)
            return initial.with(SixWayBlock.WEST, true)
                    .with(SixWayBlock.SOUTH, false)
                    .with(SixWayBlock.EAST, true)
                    .with(SixWayBlock.NORTH,false);
        return initial.with(SixWayBlock.WEST, false)
                .with(SixWayBlock.SOUTH, true)
                .with(SixWayBlock.EAST, false)
                .with(SixWayBlock.NORTH,true);
    };

}
