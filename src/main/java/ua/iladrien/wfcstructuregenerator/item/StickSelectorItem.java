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
//        File output = new File("/");
//
//        WFCStructureGenerator.log(Level.INFO, output.getAbsolutePath());

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
            Class<?> clazz = item.getKey().getValueClass();
            String name = item.getKey().getName();
            if (clazz == BlockStateProperties.HORIZONTAL_FACING.getValueClass()) {
                fw.write(".with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction." + item.getValue().toString().toUpperCase() + ")");
            }
            else if (clazz == BlockStateProperties.DOUBLE_BLOCK_HALF.getValueClass()) {
                fw.write(".with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf." + item.getValue().toString().toUpperCase() + ")");
            }
            else if (clazz == BlockStateProperties.HALF.getValueClass()) {
                fw.write(".with(BlockStateProperties.HALF, Half." + item.getValue().toString().toUpperCase() + ")");
            }
            else if (clazz == BlockStateProperties.AXIS.getValueClass()) {
                fw.write(".with(BlockStateProperties.AXIS, net.minecraft.util.Direction.Axis." + item.getValue().toString().toUpperCase() + ")");
            }
            else if (name.equals("open")) {
                fw.write(".with(BlockStateProperties.OPEN, " + item.getValue() + ")");
            }
            else if (clazz == BlockStateProperties.SLAB_TYPE.getValueClass()) {
                fw.write(".with(BlockStateProperties.SLAB_TYPE, SlabType." + item.getValue().toString().toUpperCase() + ")");
            }
            else if (clazz == BlockStateProperties.DOOR_HINGE.getValueClass()) {
                fw.write(".with(BlockStateProperties.DOOR_HINGE, DoorHingeSide." + item.getValue().toString().toUpperCase() + ")");
            }
            else if (clazz == BlockStateProperties.STAIRS_SHAPE.getValueClass()) {
                fw.write(".with(BlockStateProperties.STAIRS_SHAPE, StairsShape." + item.getValue().toString().toUpperCase() + ")");
            }
            else if (clazz == BlockStateProperties.CHEST_TYPE.getValueClass()) {
                fw.write(".with(BlockStateProperties.CHEST_TYPE, ChestType." + item.getValue().toString().toUpperCase() + ")");
            }
            else if (name.equals("north")) {
                fw.write(".with(BlockStateProperties.NORTH, " + item.getValue().toString() + ")");
            }
            else if (name.equals("south")) {
                fw.write(".with(BlockStateProperties.SOUTH, " + item.getValue().toString() + ")");
            }
            else if (name.equals("east")) {
                fw.write(".with(BlockStateProperties.EAST, " + item.getValue().toString() + ")");
            }
            else if (name.equals("west")) {
                fw.write(".with(BlockStateProperties.WEST, " + item.getValue().toString() + ")");
            }
            else if (name.equals("persistent")) {
                fw.write(".with(BlockStateProperties.PERSISTENT, " + item.getValue().toString() + ")");
            }
            else {
                WFCStructureGenerator.log(Level.WARN, "Uncaught property \""+ item.getKey().getName() +"\" = " + item.getValue().toString());
            }
            try {
                BlockState bs = Blocks.OAK_LEAVES.getDefaultState();
//                bs = bs.with(BlockStateProperties.CHEST_TYPE, ChestType.SINGLE);
            } catch (Exception exception) { exception.printStackTrace(); }
        }

        fw.append(";\n");
    }
}
