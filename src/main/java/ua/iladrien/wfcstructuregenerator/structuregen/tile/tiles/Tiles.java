package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles;

import ua.iladrien.wfcstructuregenerator.structuregen.tile.Tile;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.TileRotation;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoof.impl.SimpleSpruceRoofEdge;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoof.impl.TileSimpleSpruceRoof;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoof.impl.TileSimpleSpruceRoof_T;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoom.impl.TileBigSpruceRoom;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.decoration.impl.Asset_0006;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.smallRoof.impl.Asset_0005;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.smallRoom.impl.Asset_0004;
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
    public static final Tile SIMPLE_SPRUCE_ROOF = register(new TileSimpleSpruceRoof());
    public static final Tile SIMPLE_SPRUCE_ROOF_90 = register(new TileSimpleSpruceRoof()).setRotation(TileRotation.ROTATION90);
    // SIMPLE_SPRUCE_ROOF_T
    public static final Tile SIMPLE_SPRUCE_ROOF_T = register(new TileSimpleSpruceRoof_T());
    public static final Tile SIMPLE_SPRUCE_ROOF_T_90 = register(new TileSimpleSpruceRoof_T()).setRotation(TileRotation.ROTATION90);
    public static final Tile SIMPLE_SPRUCE_ROOF_T_180 = register(new TileSimpleSpruceRoof_T()).setRotation(TileRotation.ROTATION180);
    public static final Tile SIMPLE_SPRUCE_ROOF_T_270 = register(new TileSimpleSpruceRoof_T()).setRotation(TileRotation.ROTATION270);
    // SIMPLE_SPRUCE_ROOF_EDGE
    public static final Tile SIMPLE_SPRUCE_ROOF_EDGE = register(new SimpleSpruceRoofEdge());
    public static final Tile SIMPLE_SPRUCE_ROOF_EDGE_90 = register(new SimpleSpruceRoofEdge()).setRotation(TileRotation.ROTATION90);
    public static final Tile SIMPLE_SPRUCE_ROOF_EDGE_180 = register(new SimpleSpruceRoofEdge()).setRotation(TileRotation.ROTATION180);
    public static final Tile SIMPLE_SPRUCE_ROOF_EDGE_270 = register(new SimpleSpruceRoofEdge()).setRotation(TileRotation.ROTATION270);
    // ASSET_0004
    public static final Tile ASSET_0004 = register(new Asset_0004());
    // ASSET_0005
    public static final Tile ASSET_0005 = register(new Asset_0005());
    // ASSET_0006
    public static final Tile ASSET_0006 = register(new Asset_0006());
    public static final Tile ASSET_0006_90 = register(new Asset_0006()).setRotation(TileRotation.ROTATION90);
    public static final Tile ASSET_0006_180 = register(new Asset_0006()).setRotation(TileRotation.ROTATION180);
    public static final Tile ASSET_0006_270 = register(new Asset_0006()).setRotation(TileRotation.ROTATION270);

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
