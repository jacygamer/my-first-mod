package net.jlccraft.testmod.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by jerrod on 6/3/2014.
 */
public class ModTileEntitys {

    public static void Init(){

        GameRegistry.registerTileEntity(TileEntityWindmill.class, "windmill");
        GameRegistry.registerTileEntity(TileEntityWindmillFloor.class, "windmillFloor");



    }
}
