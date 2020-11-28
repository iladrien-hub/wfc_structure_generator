package ua.iladrien.wfcstructuregenerator.item;

import com.google.common.collect.ImmutableMap;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.Property;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.ChestType;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.state.properties.Half;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;
import ua.iladrien.wfcstructuregenerator.WFCStructureGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class StickSelectorItem extends Item {

    private static final int size = 7;
    private static final int height = 4;

    private BlockPos lastPos = new BlockPos(0,0,0);

    public StickSelectorItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        BlockPos pos = context.getPos();
        World world = context.getWorld();
        if (!pos.equals(lastPos)) {
            lastPos = pos;
            WFCStructureGenerator.log(Level.INFO, pos.getX() + " " + pos.getY() + " " + pos.getZ() );
            WFCStructureGenerator.log(Level.INFO, world.getBlockState(pos).toString() );
            BlockState state = world.getBlockState(pos);
            ImmutableMap<Property<?>, Comparable<?>> values = state.getValues();
            save(pos.add(0,1,0), world);
            for (Map.Entry<Property<?>, Comparable<?>> item: values.entrySet()) {
                WFCStructureGenerator.log(Level.DEBUG, item.getKey().getName() + " " + item.getValue());
            }
        }
        return ActionResultType.PASS;
    }

    public void save(BlockPos pos, World world) {
        try(FileWriter fw = new FileWriter("output.java", false)) {
            fw.write("BlockState[][][] data = new BlockState[HEIGHT][WIDTH][WIDTH];\n");
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < size; x++) {
                    for (int z = 0; z < size; z++) {
                        BlockState state = world.getBlockState(pos.add(x,y,z));
                        if (state != Blocks.AIR.getDefaultState())
                            saveBlock(world.getBlockState(pos.add(x,y,z)), fw, x, y, z);
                    }
                }
            }
            fw.write("return data;\n");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveBlock(BlockState state, FileWriter fw, int x, int y, int z) throws IOException {
        ImmutableMap<Property<?>, Comparable<?>> values = state.getValues();
        String variable = Objects.requireNonNull(state.getBlock().getRegistryName()).toString().split(":")[1].toUpperCase();
        fw.write("data["+y+"]["+x+"]["+z+"] = ");
        fw.write(variable);
        for (Map.Entry<Property<?>, Comparable<?>> item: values.entrySet()) {
            Property<?> key = item.getKey();
            if (key == BlockStateProperties.HORIZONTAL_FACING) {
                fw.write(".with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction." + item.getValue().toString().toUpperCase() + ")");
            } else if (key == BlockStateProperties.FACING) {
                fw.write(".with(BlockStateProperties.FACING, net.minecraft.util.Direction." + item.getValue().toString().toUpperCase() + ")");
            } else if (key == BlockStateProperties.DOUBLE_BLOCK_HALF) {
                fw.write(".with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf." + item.getValue().toString().toUpperCase() + ")");
            } else if (key == BlockStateProperties.HALF) {
                fw.write(".with(BlockStateProperties.HALF, Half." + item.getValue().toString().toUpperCase() + ")");
            } else if (key == BlockStateProperties.AXIS) {
                fw.write(".with(BlockStateProperties.AXIS, net.minecraft.util.Direction.Axis." + item.getValue().toString().toUpperCase() + ")");
            } else if (key == BlockStateProperties.OPEN) {
                fw.write(".with(BlockStateProperties.OPEN, " + item.getValue() + ")");
            } else if (key == BlockStateProperties.SLAB_TYPE) {
                fw.write(".with(BlockStateProperties.SLAB_TYPE, SlabType." + item.getValue().toString().toUpperCase() + ")");
            } else if (key == BlockStateProperties.DOOR_HINGE) {
                fw.write(".with(BlockStateProperties.DOOR_HINGE, DoorHingeSide." + item.getValue().toString().toUpperCase() + ")");
            } else if (key == BlockStateProperties.STAIRS_SHAPE) {
                fw.write(".with(BlockStateProperties.STAIRS_SHAPE, StairsShape." + item.getValue().toString().toUpperCase() + ")");
            } else if (key == BlockStateProperties.CHEST_TYPE) {
                fw.write(".with(BlockStateProperties.CHEST_TYPE, ChestType." + item.getValue().toString().toUpperCase() + ")");
            } else if (key == BlockStateProperties.FACE) {
                fw.write(".with(BlockStateProperties.FACE, AttachFace." + item.getValue().toString().toUpperCase() + ")");
            } else if (key == BlockStateProperties.BELL_ATTACHMENT) {
                fw.write(".with(BlockStateProperties.BELL_ATTACHMENT, BellAttachment." + item.getValue().toString().toUpperCase() + ")");
            } else if (key == BlockStateProperties.field_235909_T_) {
                fw.write(".with(BlockStateProperties.field_235909_T_,  WallHeight." + item.getValue().toString().toUpperCase() + ")");
            } else if (key == BlockStateProperties.NORTH) {
                fw.write(".with(BlockStateProperties.NORTH, " + item.getValue().toString() + ")");
            } else if (key == BlockStateProperties.field_235910_U_) {
                fw.write(".with(BlockStateProperties.field_235910_U_,  WallHeight." + item.getValue().toString().toUpperCase() + ")");
            } else if (key == BlockStateProperties.SOUTH) {
                fw.write(".with(BlockStateProperties.SOUTH, " + item.getValue().toString() + ")");
            } else if (key == BlockStateProperties.field_235908_S_) {
                fw.write(".with(BlockStateProperties.field_235908_S_,  WallHeight." + item.getValue().toString().toUpperCase() + ")");
            } else if (key == BlockStateProperties.EAST) {
                fw.write(".with(BlockStateProperties.EAST, " + item.getValue().toString() + ")");
            } else if (key == BlockStateProperties.field_235911_V_) {
                fw.write(".with(BlockStateProperties.field_235911_V_,  WallHeight." + item.getValue().toString().toUpperCase() + ")");
            } else if (key == BlockStateProperties.WEST) {
                    fw.write(".with(BlockStateProperties.WEST, " + item.getValue().toString() + ")");
            } else if (key == BlockStateProperties.UP) {
                fw.write(".with(BlockStateProperties.UP, " + item.getValue().toString() + ")");
            } else if (key == BlockStateProperties.LIT) {
                fw.write(".with(BlockStateProperties.LIT, " + item.getValue().toString() + ")");
            } else if (key == BlockStateProperties.PERSISTENT) {
                fw.write(".with(BlockStateProperties.PERSISTENT, " + item.getValue().toString() + ")");
            } else if (key == BlockStateProperties.PICKLES_1_4) {
                fw.write(".with(BlockStateProperties.PICKLES_1_4, " + item.getValue().toString() + ")");
            } else if (key == BlockStateProperties.HANGING) {
                fw.write(".with(BlockStateProperties.HANGING, " + item.getValue().toString() + ")");
            } else if (key == BlockStateProperties.AGE_0_3) {
                fw.write(".with(BlockStateProperties.AGE_0_3, " + item.getValue().toString() + ")");
            } else if (key == BlockStateProperties.WATERLOGGED) {
                fw.write(".with(BlockStateProperties.WATERLOGGED, " + item.getValue().toString() + ")");
            } else {
                WFCStructureGenerator.log(Level.WARN, "Uncaught property \""+ key.getName() +"\" = " + item.getValue().toString());
            }
        }
        fw.append(";\n");
    }
}
