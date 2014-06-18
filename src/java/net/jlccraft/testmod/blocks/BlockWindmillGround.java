package net.jlccraft.testmod.blocks;


import net.jlccraft.testmod.creativetab.ModTabs;

import net.jlccraft.testmod.lib.Reference;
import net.jlccraft.testmod.tileentity.TileEntityWindmillFloor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by jerrod on 6/3/2014.
 */
public class BlockWindmillGround extends BlockContainer {
    protected BlockWindmillGround() {
        super(Material.ground);
        setBlockName("blockWindmillGround");
        setBlockTextureName(Reference.MODID + ":" + "blockWindmillGround");
        setCreativeTab(ModTabs.MyTab);

        this.setBlockBounds(0, 0, 0, 1, 0.3F, 1);


    }

    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        if (world.getBlockMetadata(x, y, z) == 1) setBlockBounds(0, 0, 0, 1, (1F / 16F) * 14, 1);
        if (world.getBlockMetadata(x, y, z) == 1) setBlockBounds(0, 0, 0, 0.5F, (1F / 16F) * 14, 0.5F);
        if (world.getBlockMetadata(x, y, z) == 2) setBlockBounds(0, 0, 0, 0.5F, (1F / 16F) * 14, 1);
        if (world.getBlockMetadata(x, y, z) == 3) setBlockBounds(0, 0, 0.5F, 0.5F, (1F / 16F) * 14, 1);
        if (world.getBlockMetadata(x, y, z) == 4) setBlockBounds(0, 0, 0, 1, (1F / 16F) * 14, 0.5F);
        if (world.getBlockMetadata(x, y, z) == 5) setBlockBounds(0, 0, 0, 1, (1F / 16F) * 14, 1);
        if (world.getBlockMetadata(x, y, z) == 6) setBlockBounds(0, 0, 0.5F, 1, (1F / 16F) * 14, 1);
        if (world.getBlockMetadata(x, y, z) == 7) setBlockBounds(0.5F, 0, 0, 1, (1F / 16F) * 14, 0.5F);
        if (world.getBlockMetadata(x, y, z) == 8) setBlockBounds(0.5F, 0, 0, 1, (1F / 16F) * 14, 1);
        if (world.getBlockMetadata(x, y, z) == 9) setBlockBounds(0.5F, 0, 0.5F, 1, (1F / 16F) * 14, 1);


    }

    public int getRenderType() {
        return -1;
    }

    public boolean isOpaqueCube() {
        return false;

    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block neighborBlock) {
        updateMultiBlockStructure(world, x, y, z);
    }

    public void onBlockAdded(World world, int x, int y, int z) {
        updateMultiBlockStructure(world, x, y, z);
    }


    public void updateMultiBlockStructure(World world, int x, int y, int z) {
        isMultiBlockStructure(world, x, y, z);


    }

    public boolean isMultiBlockStructure(World world, int x1, int y1, int z1) {

        if(!world.isRemote)
        {
        boolean mStructure = false;
        boolean currentCheckStructure = true;

        for (int x2 = 0; x2 < 3; x2++) {
            for (int z2 = 0; z2 < 3; z2++) {
                if (!mStructure) {
                    currentCheckStructure = true;

                    for (int x3 = 0; x3 < 3; x3++) {
                        for (int z3 = 0; z3 < 3; z3++) {

                            if (currentCheckStructure && !world.getBlock(x1 + x2 - x3, y1, z1 + z2 - z3).equals(ModBlocks.blockWindmillGround)) {

                                currentCheckStructure = false;
                            }
                        }
                    }
                    if (currentCheckStructure) {
                        for (int x3 = 0; x3 < 3; x3++) {
                            for (int z3 = 0; z3 < 3; z3++) {
                                world.setBlockMetadataWithNotify(x1 + x2 - x3, y1, z1 + z2 - z3, x3 * 3 + z3 + 1, 2);
                            }
                        }
                    }
                }

                mStructure = currentCheckStructure;
            }
        }
        if (mStructure) {
            return true;
        } else {
            if (world.getBlockMetadata(x1, y1, z1) > 0) world.setBlockMetadataWithNotify(x1, y1, z1, 0, 3);


            return false;
        }

    }

    return false;
}


    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityWindmillFloor();
    }
}
