package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles;

import ua.iladrien.wfcstructuregenerator.structuregen.tile.Tile;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.TileRotation;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoof.impl.SimpleSpruceRoofEdge;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoof.impl.SimpleSpruceRoof;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoof.impl.SimpleSpruceRoof_T;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoom.impl.TileBigSpruceRoom;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.decoration.impl.FancySRWallDecoration;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.decoration.impl.StoneOnGroundSupport;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.smallRoom.impl.FancyStoneRoom;

import java.util.ArrayList;


public class Tiles {

    protected static final ArrayList<Tile> registered = new ArrayList<>();

    public static final Tile EMPTY_TILE = register(new EmptyTile());
    // FANCY_STONE_BASE
    public static final Tile FANCY_STONE_BASE = register(new FancyStoneRoom());
    // BIG_SPRUCE_ROOM
    public static final Tile BIG_SPRUCE_ROOM = register(new TileBigSpruceRoom());
    // SIMPLE_SPRUCE_ROOF
    public static final Tile SIMPLE_SPRUCE_ROOF = register(new SimpleSpruceRoof());
    public static final Tile SIMPLE_SPRUCE_ROOF_90 = register(new SimpleSpruceRoof()).setRotation(TileRotation.ROTATION90);
    // SIMPLE_SPRUCE_ROOF_T
    public static final Tile SIMPLE_SPRUCE_ROOF_T = register(new SimpleSpruceRoof_T());
    public static final Tile SIMPLE_SPRUCE_ROOF_T_90 = register(new SimpleSpruceRoof_T()).setRotation(TileRotation.ROTATION90);
    public static final Tile SIMPLE_SPRUCE_ROOF_T_180 = register(new SimpleSpruceRoof_T()).setRotation(TileRotation.ROTATION180);
    public static final Tile SIMPLE_SPRUCE_ROOF_T_270 = register(new SimpleSpruceRoof_T()).setRotation(TileRotation.ROTATION270);
    // SIMPLE_SPRUCE_ROOF_EDGE
    public static final Tile SIMPLE_SPRUCE_ROOF_EDGE = register(new SimpleSpruceRoofEdge());
    public static final Tile SIMPLE_SPRUCE_ROOF_EDGE_90 = register(new SimpleSpruceRoofEdge()).setRotation(TileRotation.ROTATION90);
    public static final Tile SIMPLE_SPRUCE_ROOF_EDGE_180 = register(new SimpleSpruceRoofEdge()).setRotation(TileRotation.ROTATION180);
    public static final Tile SIMPLE_SPRUCE_ROOF_EDGE_270 = register(new SimpleSpruceRoofEdge()).setRotation(TileRotation.ROTATION270);
    // STONE_ON_GROUND_SUPPORT
    public static final Tile STONE_ON_GROUND_SUPPORT = register(new StoneOnGroundSupport());
    public static final Tile STONE_ON_GROUND_SUPPORT_90 = register(new StoneOnGroundSupport()).setRotation(TileRotation.ROTATION90);
    public static final Tile STONE_ON_GROUND_SUPPORT_180 = register(new StoneOnGroundSupport()).setRotation(TileRotation.ROTATION180);
    public static final Tile STONE_ON_GROUND_SUPPORT_270 = register(new StoneOnGroundSupport()).setRotation(TileRotation.ROTATION270);
    // FANCYSR_WALL_DECORATION
    public static final Tile FANCYSR_WALL_DECORATION = register(new FancySRWallDecoration());
    public static final Tile FANCYSR_WALL_DECORATION_90 = register(new FancySRWallDecoration()).setRotation(TileRotation.ROTATION90);
    public static final Tile FANCYSR_WALL_DECORATION_180 = register(new FancySRWallDecoration()).setRotation(TileRotation.ROTATION180);
    public static final Tile FANCYSR_WALL_DECORATION_270 = register(new FancySRWallDecoration()).setRotation(TileRotation.ROTATION270);


    private static Tile register(Tile asset) {
        registered.add(asset);
        return  asset;
    }

    public static void registerVariants() {
        for(Tile asset: registered)
            asset.registerVariants();
    }

    public static ArrayList<Tile> getRegistered() {
        return new ArrayList<>(registered);
    }
}
