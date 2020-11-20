package ua.iladrien.wfcstructuregenerator.structuregen;


import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockList {

    private static class BlockListNode {
        public int x, y, z;
        public  BlockState blockState;
        private BlockListNode next = null;
        private BlockListNode prev = null;
        private boolean important;

        BlockListNode(int x, int y, int z, BlockState blockState, boolean important) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.blockState = blockState;
            this.important = important;
        }

        public BlockListNode next() {
            return next;
        }

        public int append(BlockListNode item) {
            if (next == null) {
                next = item;
                next.prev = this;
                return ADDED;
            } else if (x == item.x && y == item.y && z == item.z) {
                if (!important || item.important) {
                    this.blockState = item.blockState;
                    this.important = item.important;
                    return REPLACED;
                }
                return REVOKED;
            } else {
                return next.append(item);
            }
        }

        @Override
        public String toString() {
            return "BlockListNode{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    ", blockState=" + blockState.getBlock().getTranslationKey() +
                    '}';
        }
    }

    public static final int ADDED = 1;
    public static final int REPLACED = 2;
    public static final int REVOKED = 3;
    public static final int ERROR = 4;

    private final BlockListNode root = new BlockListNode(255,255,255, null, true);

    public int append(int x, int y, int z, BlockState block, boolean important) {
        if (block != null)
            return root.append(new BlockListNode(x,y,z,block, important));
        return ERROR;
    }

    public int append(int x, int y, int z, BlockState block) {
        return append(x,y,z,block,true);
    }

    public void place(World world, BlockPos pos) {
        BlockListNode block = root.next();
        while (block != null) {
            //TMEvents.PLAYER.sendMessage(new StringTextComponent(block.toString()), TMEvents.PLAYER.getUniqueID());
            world.setBlockState(pos.add(block.x, block.y, block.z), block.blockState);
            block = block.next();
        }
    }

    public int size() {
        int i = 0;
        BlockListNode block = root.next;
        while (block != null) {
            i += 1;
            block = block.next;
        }
        return i;
    }
}