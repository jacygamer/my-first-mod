package net.jlccraft.testmod.events;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by jerrod on 6/16/2014.
 */
public class ModEvents {

    public static void Init(){

        MinecraftForge.EVENT_BUS.register(new WindmillHighlightEvent());



    }
}
