package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoom.impl;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.World;
import ua.iladrien.wfcstructuregenerator.structuregen.Generator;
import ua.iladrien.wfcstructuregenerator.structuregen.LazyStuff;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.Tile;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.TileRotation;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.Tiles;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoom.BigRoom;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.misc.Miscellaneous;

public class TileBigSpruceRoom extends BigRoom {

    private static final BlockState SPRUCE_LOG = Blocks.SPRUCE_LOG.getDefaultState();
    private static final BlockState SPRUCE_PLANKS = Blocks.SPRUCE_PLANKS.getDefaultState();

    static Vector3i[] directions = new Vector3i[] {
            new Vector3i(0,0,-1),
            new Vector3i(-1,0,0),
            new Vector3i(0,0,1),
            new Vector3i(1,0,0),
    };

    static Vector3i[] offsets = new Vector3i[] {
            new Vector3i(0,0,1-WIDTH),
            new Vector3i(1-WIDTH,0,0),
            new Vector3i(0,0,WIDTH-1),
            new Vector3i(WIDTH-1,0,0),
    };

    static Tile[] windows = new Tile[] {
            Miscellaneous.Misc_0009,
            Miscellaneous.Misc_0010,
    };

    @Override
    public void placeAt(World world, BlockPos pos, Vector3i generatorPos, Generator generator) {
        super.placeAt(world, pos, generatorPos, generator);
        for (int i = 0; i < 4; i++) {
            Tile tile = generator.getTileAt(LazyStuff.addVectors3(generatorPos, directions[i]));
            if (tile == Tiles.EMPTY_TILE || tile == null)
                windows[RANDOM.nextInt(windows.length)].setRotation(TileRotation.fromAngle(i)).placeAt(world, pos.add(offsets[i]), generatorPos, generator);
        }
    }

    @Override
    public void registerVariants() {
        super.registerVariants();
        // UP
        addVariant_u(Tiles.SIMPLE_SPRUCE_ROOF);
        addVariant_u(Tiles.SIMPLE_SPRUCE_ROOF_90);
        addVariant_u(Tiles.SIMPLE_SPRUCE_ROOF_T);
        addVariant_u(Tiles.SIMPLE_SPRUCE_ROOF_T_90);
        addVariant_u(Tiles.SIMPLE_SPRUCE_ROOF_T_180);
        addVariant_u(Tiles.SIMPLE_SPRUCE_ROOF_T_270);
        //
        addVariant_e(Tiles.BIG_SPRUCE_ROOM);
        addVariant_n(Tiles.BIG_SPRUCE_ROOM);
        addVariant_w(Tiles.BIG_SPRUCE_ROOM);
        addVariant_s(Tiles.BIG_SPRUCE_ROOM);
        //
        addVariant_e(Tiles.EMPTY_TILE);
        addVariant_n(Tiles.EMPTY_TILE);
        addVariant_w(Tiles.EMPTY_TILE);
        addVariant_s(Tiles.EMPTY_TILE);
    }

    public TileBigSpruceRoom() {
        super();
        this.allowedOnGround = false;
    }

    @Override
    public BlockState[][][] getStructure() {
        BlockState[][][] data = new BlockState[HEIGHT][WIDTH][WIDTH];

        final BlockState SPRUCE_LOG_Z = SPRUCE_LOG.with(RotatedPillarBlock.AXIS, Direction.Axis.Z);
        final BlockState SPRUCE_LOG_X = SPRUCE_LOG.with(RotatedPillarBlock.AXIS, Direction.Axis.X);
        final BlockState SPRUCE_LOG_Y = SPRUCE_LOG.with(RotatedPillarBlock.AXIS, Direction.Axis.Y);

        data[0][0][0] = SPRUCE_LOG_Z;
        data[0][0][1] = SPRUCE_LOG_Z;
        data[0][0][2] = SPRUCE_LOG_Z;
        data[0][0][3] = SPRUCE_LOG_Z;
        data[0][0][4] = SPRUCE_LOG_Z;
        data[0][0][5] = SPRUCE_LOG_Z;
        data[0][0][6] = SPRUCE_LOG_Z;
        data[0][1][0] = SPRUCE_LOG_X;
        data[0][1][6] = SPRUCE_LOG_X;
        data[0][2][0] = SPRUCE_LOG_X;
        data[0][2][6] = SPRUCE_LOG_X;
        data[0][3][0] = SPRUCE_LOG_X;
        data[0][3][6] = SPRUCE_LOG_X;
        data[0][4][0] = SPRUCE_LOG_X;
        data[0][4][6] = SPRUCE_LOG_X;
        data[0][5][0] = SPRUCE_LOG_X;
        data[0][5][6] = SPRUCE_LOG_X;
        data[0][6][0] = SPRUCE_LOG_Z;
        data[0][6][1] = SPRUCE_LOG_Z;
        data[0][6][2] = SPRUCE_LOG_Z;
        data[0][6][3] = SPRUCE_LOG_Z;
        data[0][6][4] = SPRUCE_LOG_Z;
        data[0][6][5] = SPRUCE_LOG_Z;
        data[0][6][6] = SPRUCE_LOG_Z;
        data[1][0][0] = SPRUCE_LOG_Y;
        data[1][0][1] = SPRUCE_PLANKS;
        data[1][0][2] = SPRUCE_LOG_Y;
        data[1][0][3] = SPRUCE_PLANKS;
        data[1][0][4] = SPRUCE_LOG_Y;
        data[1][0][5] = SPRUCE_PLANKS;
        data[1][0][6] = SPRUCE_LOG_Y;
        data[1][1][0] = SPRUCE_PLANKS;
        data[1][1][6] = SPRUCE_PLANKS;
        data[1][2][0] = SPRUCE_LOG_Y;
        data[1][2][6] = SPRUCE_LOG_Y;
        data[1][3][0] = SPRUCE_PLANKS;
        data[1][3][6] = SPRUCE_PLANKS;
        data[1][4][0] = SPRUCE_LOG_Y;
        data[1][4][6] = SPRUCE_LOG_Y;
        data[1][5][0] = SPRUCE_PLANKS;
        data[1][5][6] = SPRUCE_PLANKS;
        data[1][6][0] = SPRUCE_LOG_Y;
        data[1][6][1] = SPRUCE_PLANKS;
        data[1][6][2] = SPRUCE_LOG_Y;
        data[1][6][3] = SPRUCE_PLANKS;
        data[1][6][4] = SPRUCE_LOG_Y;
        data[1][6][5] = SPRUCE_PLANKS;
        data[1][6][6] = SPRUCE_LOG_Y;
        data[2][0][0] = SPRUCE_LOG_Y;
        data[2][0][1] = SPRUCE_PLANKS;
        data[2][0][2] = SPRUCE_LOG_Y;
        data[2][0][3] = SPRUCE_PLANKS;
        data[2][0][4] = SPRUCE_LOG_Y;
        data[2][0][5] = SPRUCE_PLANKS;
        data[2][0][6] = SPRUCE_LOG_Y;
        data[2][1][0] = SPRUCE_PLANKS;
        data[2][1][6] = SPRUCE_PLANKS;
        data[2][2][0] = SPRUCE_LOG_Y;
        data[2][2][6] = SPRUCE_LOG_Y;
        data[2][3][0] = SPRUCE_PLANKS;
        data[2][3][6] = SPRUCE_PLANKS;
        data[2][4][0] = SPRUCE_LOG_Y;
        data[2][4][6] = SPRUCE_LOG_Y;
        data[2][5][0] = SPRUCE_PLANKS;
        data[2][5][6] = SPRUCE_PLANKS;
        data[2][6][0] = SPRUCE_LOG_Y;
        data[2][6][1] = SPRUCE_PLANKS;
        data[2][6][2] = SPRUCE_LOG_Y;
        data[2][6][3] = SPRUCE_PLANKS;
        data[2][6][4] = SPRUCE_LOG_Y;
        data[2][6][5] = SPRUCE_PLANKS;
        data[2][6][6] = SPRUCE_LOG_Y;
        data[3][0][0] = SPRUCE_LOG_Y;
        data[3][0][1] = SPRUCE_PLANKS;
        data[3][0][2] = SPRUCE_LOG_Y;
        data[3][0][3] = SPRUCE_PLANKS;
        data[3][0][4] = SPRUCE_LOG_Y;
        data[3][0][5] = SPRUCE_PLANKS;
        data[3][0][6] = SPRUCE_LOG_Y;
        data[3][1][0] = SPRUCE_PLANKS;
        data[3][1][6] = SPRUCE_PLANKS;
        data[3][2][0] = SPRUCE_LOG_Y;
        data[3][2][6] = SPRUCE_LOG_Y;
        data[3][3][0] = SPRUCE_PLANKS;
        data[3][3][6] = SPRUCE_PLANKS;
        data[3][4][0] = SPRUCE_LOG_Y;
        data[3][4][6] = SPRUCE_LOG_Y;
        data[3][5][0] = SPRUCE_PLANKS;
        data[3][5][6] = SPRUCE_PLANKS;
        data[3][6][0] = SPRUCE_LOG_Y;
        data[3][6][1] = SPRUCE_PLANKS;
        data[3][6][2] = SPRUCE_LOG_Y;
        data[3][6][3] = SPRUCE_PLANKS;
        data[3][6][4] = SPRUCE_LOG_Y;
        data[3][6][5] = SPRUCE_PLANKS;
        data[3][6][6] = SPRUCE_LOG_Y;

        return data;
    }
}
