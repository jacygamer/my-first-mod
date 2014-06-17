package net.jlccraft.testmod.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.jlccraft.testmod.renderer.tileentity.TileEntityRenderWindmillFloor;
import net.jlccraft.testmod.renderer.tileentity.TileEntityRenderWindmill;
import net.jlccraft.testmod.tileentity.TileEntityWindmill;
import net.jlccraft.testmod.tileentity.TileEntityWindmillFloor;

/**
 * Created by jerrod on 6/3/2014.
 */
public class ClientProxy extends CommonProxy {

    public void registerProxies(){
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindmill.class, new TileEntityRenderWindmill());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindmillFloor.class, new TileEntityRenderWindmillFloor());


    }
}
