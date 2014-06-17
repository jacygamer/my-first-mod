package net.jlccraft.testmod.items;

import net.jlccraft.testmod.TestMod;
import net.jlccraft.testmod.blocks.ModBlocks;
import net.jlccraft.testmod.creativetab.ModTabs;
import net.jlccraft.testmod.tileentity.TileEntityWindmill;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by jerrod on 6/3/2014.
 */
public class ItemWindmill extends Item {

    public ItemWindmill() {
        setCreativeTab(ModTabs.MyTab);
        setUnlocalizedName("Windmill");
        setTextureName("diamond");

    }

    public boolean onItemUse(ItemStack ItemStack, EntityPlayer Player, World world, int x, int y, int z, int side, float x2, float y2, float z2){
        if(!world.isRemote){
            if(side==1 && world.getBlock(x,y,z).equals(ModBlocks.blockWindmillGround)&& world.getBlockMetadata(x,y,z)==5){
                boolean notEnoughSpace =false;

                for(int x1 =-1; x1 < 1; x1++){
                    for(int z1 =-1; z1 < 1; z1++){
                        for(int y1 =0; y1 < 7; y1++){
                            if(!world.isAirBlock(x+x1, y+y1+1, z+z1))notEnoughSpace =true;


                        }

                    }
                }

                if(!notEnoughSpace){


                    for(int y1 =0; y1 < 7; y1++){
                        world.setBlock(x, y+y1+1, z, ModBlocks.blockWindmill, (y1+1)==7?(y1+1): (y1+1),2);


                    }
                    return true;
                }




            }

        }


        return false;
    }



}
