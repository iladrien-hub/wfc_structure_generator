package ua.iladrien.wfcstructuregenerator.item;

import com.google.common.collect.ImmutableMap;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.Property;
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
            switch (item.getKey().getName()) {
                case "facing":
                    fw.write(".with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction." + item.getValue().toString().toUpperCase() + ")");
                    break;
                case "half":
                    fw.write(".with(BlockStateProperties.HALF, Half." + item.getValue().toString().toUpperCase() + ")");
                    break;
                case "axis":
                    fw.write(".with(RotatedPillarBlock.AXIS, net.minecraft.util.Direction.Axis." + item.getValue().toString().toUpperCase() + ")");
                    break;
                case "open":
                    fw.write(".with(TrapDoorBlock.OPEN, " + item.getValue() + ")");
                    break;
                case "type":
                    fw.write(".with(SlabBlock.TYPE, SlabType." + item.getValue().toString().toUpperCase() + ")");
                    break;
                case "hinge":
                    fw.write(".with(DoorBlock.HINGE, DoorHingeSide." + item.getValue().toString().toUpperCase() + ")");
                    break;
                case "shape":
                    fw.write(".with(StairsBlock.SHAPE, StairsShape." + item.getValue().toString().toUpperCase() + ")");
                    break;
                default:
                    WFCStructureGenerator.log(Level.WARN, "Uncaught property \""+ item.getKey().getName() +"\" = " + item.getValue().toString());
            }
        }

        fw.append(";\n");
    }
}
