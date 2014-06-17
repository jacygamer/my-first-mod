package net.jlccraft.testmod.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.jlccraft.testmod.TestMod;
import net.jlccraft.testmod.blocks.ModBlocks;
import net.jlccraft.testmod.lib.Reference;
import net.jlccraft.testmod.tileentity.TileEntityWindmill;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

/**
 * Created by jerrod on 6/3/2014.
 */
public class TileEntityRenderWindmill extends TileEntitySpecialRenderer {


    private final ResourceLocation textureWindmill = new ResourceLocation(Reference.MODID, "textures/model/windmill.png");
    private final ResourceLocation textureWindmillFront = new ResourceLocation(Reference.MODID, "textures/blocks/windmill.png");



    private int textureWidth = 32;
    private int textureHeight = 32;
    private float pixel = 1F / 16;


    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
        int x1 = tileEntity.xCoord;
        int y1 = tileEntity.yCoord;
        int z1 = tileEntity.zCoord;
        while (tileEntity.getWorldObj().getBlockMetadata(x1, y1, z1) < 40 && tileEntity.getWorldObj().getBlock(x1, y1, z1).equals(ModBlocks.blockWindmill)) {
            y1++;
        }
        int direction = tileEntity.getWorldObj().getBlockMetadata(x1, y1, z1) - 7;
        int metadata = tileEntity.getWorldObj().getBlockMetadata(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord);

        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glTranslatef((float) x, (float) y, (float) z);
        GL11.glTranslatef(0.5F, 0, 0.5F);
        /*if(metadata ==4) {
            GL11.glRotatef(direction*90,0,1,0);
        }*/
        GL11.glTranslatef(-0.5F, 0, -0.5F);

        Tessellator tessellator = Tessellator.instance;
        this.bindTexture(textureWindmill);
        tessellator.startDrawingQuads();
        {


            if (metadata > 0 && metadata < 7) {
                tessellator.addVertexWithUV((16 - 8) / 2 * pixel, 0, 1 - (16 - 8) / 2 * pixel, 8 * (1F / textureWidth), 1 * (1F / textureHeight));
                tessellator.addVertexWithUV((16 - 8) / 2 * pixel, 1, 1 - (16 - 8) / 2 * pixel, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV((16 - 8) / 2 * pixel, 1, (16 - 8) / 2 * pixel, 0 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV((16 - 8) / 2 * pixel, 0, (16 - 8) / 2 * pixel, 0 * (1F / textureWidth), 1 * (1F / textureHeight));

                tessellator.addVertexWithUV(1 - (16 - 8) / 2 * pixel, 0, 1 - (16 - 8) / 2 * pixel, 8 * (1F / textureWidth), 1 * (1F / textureHeight));
                tessellator.addVertexWithUV(1 - (16 - 8) / 2 * pixel, 1, 1 - (16 - 8) / 2 * pixel, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV((16 - 8) / 2 * pixel, 1, 1 - (16 - 8) / 2 * pixel, 0 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV((16 - 8) / 2 * pixel, 0, 1 - (16 - 8) / 2 * pixel, 0 * (1F / textureWidth), 1 * (1F / textureHeight));

                tessellator.addVertexWithUV((16 - 8) / 2 * pixel, 0, (16 - 8) / 2 * pixel, 8 * (1F / textureWidth), 1 * (1F / textureHeight));
                tessellator.addVertexWithUV((16 - 8) / 2 * pixel, 1, (16 - 8) / 2 * pixel, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(1 - (16 - 8) / 2 * pixel, 1, (16 - 8) / 2 * pixel, 0 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(1 - (16 - 8) / 2 * pixel, 0, (16 - 8) / 2 * pixel, 0 * (1F / textureWidth), 1 * (1F / textureHeight));

                tessellator.addVertexWithUV(1 - (16 - 8) / 2 * pixel, 0, (16 - 8) / 2 * pixel, 8 * (1F / textureWidth), 1 * (1F / textureHeight));
                tessellator.addVertexWithUV(1 - (16 - 8) / 2 * pixel, 1, (16 - 8) / 2 * pixel, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(1 - (16 - 8) / 2 * pixel, 1, 1 - (16 - 8) / 2 * pixel, 0 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(1 - (16 - 8) / 2 * pixel, 0, 1 - (16 - 8) / 2 * pixel, 0 * (1F / textureWidth), 1 * (1F / textureHeight));
            }

            if(metadata == 7){
                this.bindTexture(textureWindmillFront);
                tessellator.addVertexWithUV(0,0,1, 1,1);
                tessellator.addVertexWithUV(0,1,1, 1, 0);
                tessellator.addVertexWithUV(0,1,0, 0, 0);
                tessellator.addVertexWithUV(0,0,0, 0, 1);
            }

            tessellator.draw();
            if (metadata > 6) drawRotor(tileEntity);





            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glPopMatrix();


        }
    }
        private void drawRotor(TileEntity tileEntity){
            TileEntityWindmill windmill = (TileEntityWindmill) tileEntity.getWorldObj().getTileEntity(tileEntity.xCoord,tileEntity.yCoord,tileEntity.zCoord);
            GL11.glTranslatef(0,0.5F,0.5F);
            GL11.glRotatef(windmill.rotation,1,0,0);

            GL11.glTranslatef(0,-0.5F,-0.5F);
            GL11.glColor3f(5,8,9);
        Tessellator tessellator = Tessellator.instance;
        this.bindTexture(textureWindmill);
        tessellator.startDrawingQuads();
        {
                //front rotor
                tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 1 * pixel + 0.5F, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
                tessellator.addVertexWithUV(-2 * pixel, 7.5F, 1 * pixel+0.5F, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(-2 * pixel, 7.5F, -1 * pixel+0.5F, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, -1 * pixel+0.5F, 8 * (1F / textureWidth), 1 * (1F / textureHeight));

                tessellator.addVertexWithUV(-2 * pixel, -7.5F, 1 * pixel + 0.5F, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
                tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, 1 * pixel + 0.5F, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, -1 * pixel + 0.5F, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(-2 * pixel, -7.5F, -1 * pixel + 0.5F, 8 * (1F / textureWidth), 1 * (1F / textureHeight));

                tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, 7.5F, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
                tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 7.5F, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 0.5F + 1 * pixel, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, 0.5F + 1 * pixel, 8 * (1F / textureWidth), 1 * (1F / textureHeight));


                tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, 0.5F - 1 * pixel, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
                tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 0.5F - 1 * pixel, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, -7.5F, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, -7.5F, 8 * (1F / textureWidth), 1 * (1F / textureHeight));

                //back rotor

                tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, -1 * pixel + 0.5F, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
               tessellator.addVertexWithUV(-2 * pixel, 7.5F, -1 * pixel+0.5F, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(-2 * pixel, 7.5F, 1 * pixel+0.5F, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 1 * pixel+0.5F, 8 * (1F / textureWidth), 1 * (1F / textureHeight));

                tessellator.addVertexWithUV(-2 * pixel, -7.5F, -1 * pixel + 0.5F, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
                tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, -1 * pixel + 0.5F, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, +1 * pixel + 0.5F, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(-2 * pixel, -7.5F, +1 * pixel + 0.5F, 8 * (1F / textureWidth), 1 * (1F / textureHeight));

                tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 7.5F, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
                tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, 7.5F, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, 0.5F + 1 * pixel, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 0.5F + 1 * pixel, 8 * (1F / textureWidth), 1 * (1F / textureHeight));


                tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 0.5F - 1 * pixel, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
                tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, 0.5F - 1 * pixel, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, -7.5F, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, -7.5F, 8 * (1F / textureWidth), 1 * (1F / textureHeight));
            }

            tessellator.draw();

    }



    }

