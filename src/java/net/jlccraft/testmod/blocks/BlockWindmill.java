package net.jlccraft.testmod.blocks;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.jlccraft.testmod.TestMod;
import net.jlccraft.testmod.handler.ModHandlers;
import net.jlccraft.testmod.lib.Reference;
import net.jlccraft.testmod.tileentity.TileEntityWindmill;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by jerrod on 6/3/2014.
 */
public class BlockWindmill extends BlockContainer {
    float pixel =1F/16;
    private final ResourceLocation textureWindmillFront = new ResourceLocation(Reference.MODID, "textures/blocks/windmillfront.png");



    private int textureWidth = 32;
    private int textureHeight = 32;


    //@SideOnly(Side.CLIENT)
    //private IIcon waterGeneratorOutput;
    @SideOnly(Side.CLIENT)
    private IIcon windmillFront;
    public BlockWindmill() {
        super(Material.rock);

        setBlockName("blockWindmill");


        setHardness(5F);
        setResistance(7.0F);


    }
    @Override
    public String getUnlocalizedName()
    {
        return String.format( Reference.MODID + ":"+ "windmill", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }





    public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {
        if(blockAccess.getBlockMetadata(x,y,z)<7)this.setBlockBounds(pixel*4, 0,pixel*4, 1-pixel*4,1, 1-pixel*4);
        else this.setBlockBounds(0,0,0,1,1,1);
    }





    public int getRenderType(){
        return -1;
    }
    public boolean isOpaqueCube(){
        return false;

    }
    public boolean renderAsNormalBlock(){
        return false;
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){

        if(!world.isRemote){


            FMLNetworkHandler.openGui(player, TestMod.instance, ModHandlers.guiIDWindmill, world, x, y, z);



        }

        return false;
    }


    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityWindmill();
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int metadata)
    {
        if(world.getBlock(x,y +1,z).equals(ModBlocks.blockWindmill)|| (world.getBlock(x,y - 1,z).equals(ModBlocks.blockWindmill))){
            world.setBlock(x,y+1,z, Blocks.air);
            world.setBlock(x,y-1,z,Blocks.air);
        }
    }
}
