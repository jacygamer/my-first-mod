package net.jlccraft.testmod.handler;

import cpw.mods.fml.common.network.NetworkRegistry;
import net.jlccraft.testmod.TestMod;


/**
 * Created by jerrod on 6/14/2014.
 */
public class ModHandlers {

    public static final int guiIDWindmill =0;



    public static void Init(){

        NetworkRegistry.INSTANCE.registerGuiHandler(TestMod.instance, new TestGuiHandler());




    }
}
