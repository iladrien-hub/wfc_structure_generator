package ua.iladrien.wfcstructuregenerator.events;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import org.apache.logging.log4j.Level;
import ua.iladrien.wfcstructuregenerator.WFCStructureGenerator;
import ua.iladrien.wfcstructuregenerator.block.TMBlocks;
import ua.iladrien.wfcstructuregenerator.structuregen.Generator;

@Mod.EventBusSubscriber(modid = WFCStructureGenerator.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModEvents {

    public static PlayerEntity PLAYER;

    @SubscribeEvent
    public static void onPlaceBlock(BlockEvent.EntityPlaceEvent event) {
        if ( event.getPlacedBlock() == TMBlocks.STONE_STICK_BLOCK.get().getDefaultState() ){
            PlayerEntity player = (PlayerEntity) event.getEntity();
            PLAYER = player;
            World world = event.getEntity().getEntityWorld();
            BlockPos pos = event.getPos();
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
            // =======================================================================================================
            Generator gen = new Generator();
            gen.generate();
            gen.place(world, pos);
            // =======================================================================================================
            player.sendMessage(new StringTextComponent("Good!"), player.getUniqueID());
        }
    }

    @SubscribeEvent
    public void onServerStart (FMLServerStartingEvent event) {
        WFCStructureGenerator.log(Level.INFO, "Server starting");
        //ModCommands.register(event.getDispatcher());
    }
}
