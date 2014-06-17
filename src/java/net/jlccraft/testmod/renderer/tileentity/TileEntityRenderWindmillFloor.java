package net.jlccraft.testmod.renderer.tileentity;

import net.jlccraft.testmod.lib.Reference;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by jerrod on 6/7/2014.
 */
public class TileEntityRenderWindmillFloor extends TileEntitySpecialRenderer {


    private final ResourceLocation textureWindmill = new ResourceLocation(Reference.MODID, "textures/model/windmillFloor.png");

    private int textureWidth = 32;
    private int textureHeight = 32;
    private float pixel = 1F/16F;

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glTranslatef((float) x, (float) y, (float) z);

        Tessellator tessellator = Tessellator.instance;
        this.bindTexture(textureWindmill);
        tessellator.startDrawingQuads();
        {
            if (tileEntity.getWorldObj().getBlockMetadata(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord) == 1) {//1
                tessellator.addVertexWithUV(0, pixel*16, 0.5, 1F/textureWidth*(8+16), 1F/textureHeight*(32));
                tessellator.addVertexWithUV(0.5, pixel*16, 0.5, 1F/textureWidth*(32), 1F/textureHeight*(32));
                tessellator.addVertexWithUV(0.5, pixel*16, 0, 1F/textureWidth*(32), 1F/textureHeight*(8+16));
                tessellator.addVertexWithUV(0, pixel*16, 0, 1F/textureWidth*(8+16), 1F/textureHeight*(8+16));
            }
            if (tileEntity.getWorldObj().getBlockMetadata(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord) == 2) {//2
            tessellator.addVertexWithUV(0, pixel*16, 1, 1F/textureWidth*(8+16), 1F/textureHeight*(8+16));
            tessellator.addVertexWithUV(0.5, pixel*16, 1, 1F/textureWidth*(32), 1F/textureHeight*(8+16));
            tessellator.addVertexWithUV(0.5, pixel*16, 0, 1F/textureWidth*(32), 1F/textureHeight*(8+16));
            tessellator.addVertexWithUV(0, pixel*16, 0, 1F/textureWidth*(8+16), 1F/textureHeight*(8+16));
        }
            if (tileEntity.getWorldObj().getBlockMetadata(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord) == 3) {//3
                tessellator.addVertexWithUV(0, pixel*16, 1, 1F/textureWidth*(8+16), 1F/textureHeight*(8+16));
                tessellator.addVertexWithUV(0.5, pixel*16, 1, 1F/textureWidth*(32), 1F/textureHeight*(8+16));
                tessellator.addVertexWithUV(0.5, pixel*16, 0.5, 1F/textureWidth*(32), 1F/textureHeight*(32));
                tessellator.addVertexWithUV(0, pixel*16, 0.5, 1F/textureWidth*(8+16), 1F/textureHeight*(32));
            }
            if (tileEntity.getWorldObj().getBlockMetadata(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord) == 4) {//4
                tessellator.addVertexWithUV(0, pixel*16, 0.5, 1F/textureWidth*(32), 1F/textureHeight*(8+16));
                tessellator.addVertexWithUV(1, pixel*16, 0.5, 1F/textureWidth*(32), 1F/textureHeight*(8+16));
                tessellator.addVertexWithUV(1, pixel*16, 0, 1F/textureWidth*(8+16), 1F/textureHeight*(8+16));
                tessellator.addVertexWithUV(0, pixel*16, 0, 1F/textureWidth*(8+16), 1F/textureHeight*(8+16));
            }
            if (tileEntity.getWorldObj().getBlockMetadata(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord) == 5) {//5
                tessellator.addVertexWithUV(0, pixel*16, 1, 1F/textureWidth*8, 1F/textureHeight*8);
                tessellator.addVertexWithUV(1, pixel*16, 1, 1F/textureWidth*8, 1F/textureHeight*(8+16));
                tessellator.addVertexWithUV(1, pixel*16, 0, 1F/textureWidth*(8+16), 1F/textureHeight*(8+16));
                tessellator.addVertexWithUV(0, pixel*16, 0, 1F/textureWidth*8, 1F/textureHeight*8);
            }
            if (tileEntity.getWorldObj().getBlockMetadata(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord) == 6) {//6
                tessellator.addVertexWithUV(0, pixel*16, 1, 1F/textureWidth*(8+16), 1F/textureHeight*(8+16));
                tessellator.addVertexWithUV(1, pixel*16, 1, 1F/textureWidth*(8+16), 1F/textureHeight*(8+16));
                tessellator.addVertexWithUV(1, pixel*16, 0.5, 1F/textureWidth*(8+16), 1F/textureHeight*(32));
                tessellator.addVertexWithUV(0, pixel*16, 0.5, 1F/textureWidth*(8+16), 1F/textureHeight*32);
            }
            if (tileEntity.getWorldObj().getBlockMetadata(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord) == 7) {//7
                tessellator.addVertexWithUV(0.5, pixel*16, 0.5, 1F/textureWidth*(32), 1F/textureHeight*(32));
                tessellator.addVertexWithUV(1, pixel*16, 0.5, 1F/textureWidth*(32), 1F/textureHeight*(8+16));
                tessellator.addVertexWithUV(1, pixel*16, 0, 1F/textureWidth*(8+16), 1F/textureHeight*(8+16));
                tessellator.addVertexWithUV(0.5, pixel*16, 0, 1F/textureWidth*(8+16), 1F/textureHeight*(32));
            }
            if (tileEntity.getWorldObj().getBlockMetadata(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord) == 8) {//8
                tessellator.addVertexWithUV(0.5, pixel*16,1, 1F/textureWidth*(8+16), 1F/textureHeight*(32));
                tessellator.addVertexWithUV(1, pixel*16, 1, 1F/textureWidth*(8+16), 1F/textureHeight*(8+16));
                tessellator.addVertexWithUV(1, pixel*16, 0, 1F/textureWidth*(8+16), 1F/textureHeight*(8+16));
                tessellator.addVertexWithUV(0.5, pixel*16, 0, 1F/textureWidth*(8+16), 1F/textureHeight*(32));
            }
            if (tileEntity.getWorldObj().getBlockMetadata(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord) == 9) {//9
                tessellator.addVertexWithUV(0.5, pixel*16, 1, 1F/textureWidth*(8+16), 1F/textureHeight*(32));
                tessellator.addVertexWithUV(1, pixel*16, 1, 1F/textureWidth*(8+16), 1F/textureHeight*(8+16));
                tessellator.addVertexWithUV(1, pixel*16, 0.5, 1F/textureWidth*(32), 1F/textureHeight*(8+16));
                tessellator.addVertexWithUV(0.5, pixel*16, 0.5, 1F/textureWidth*(32), 1F/textureHeight*(32));
            }
        }


        tessellator.draw();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();


    }
}
