package net.jlccraft.testmod.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.jlccraft.testmod.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

/**
 * Created by jerrod on 6/3/2014.
 */
public class ModBlocks {


    public static Block blockWindmill = new BlockWindmill();
    public static Block blockWindmillGround = new BlockWindmillGround();




    public static void Init(){

        GameRegistry.registerBlock(blockWindmill, "blockWindmill");
        GameRegistry.registerBlock(blockWindmillGround, "blockWindmillGround");




    }
}
