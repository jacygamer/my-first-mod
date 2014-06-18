package net.jlccraft.testmod.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import net.jlccraft.testmod.container.ContainerWindmill;
import net.jlccraft.testmod.gui.GuiWindmill;
import net.jlccraft.testmod.tileentity.TileEntityWindmill;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by jerrod on 6/14/2014.
 */
public class TestGuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);

        switch(ID){
            case ModHandlers.guiIDWindmill:
                while(tileEntity instanceof TileEntityWindmill && world.getBlockMetadata(x,y+1,z)<8){
                    y++;


                }
                System.out.println(world.getBlockMetadata(x,y,z));
                return new ContainerWindmill(player.inventory, (TileEntityWindmill)world.getTileEntity(x, y, z)) ;
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);

        switch(ID){
            case ModHandlers.guiIDWindmill:
               while(tileEntity instanceof TileEntityWindmill && world.getBlockMetadata(x,y+1,z)<8){
                    y++;


                }
                System.out.println(world.getBlockMetadata(x,y,z));
                return new GuiWindmill(player.inventory, (TileEntityWindmill)world.getTileEntity(x, y, z)) ;
        }
        return null;
    }
}
