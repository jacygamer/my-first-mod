package net.jlccraft.testmod.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.jlccraft.testmod.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import org.lwjgl.opengl.GL11;

/**
 * Created by jerrod on 6/16/2014.
 */
public class WindmillHighlightEvent {

    @SubscribeEvent
    public void onDrawHighlight(DrawBlockHighlightEvent e) {
        if(e.target.typeOfHit.equals(MovingObjectPosition.MovingObjectType.BLOCK)&& e.player.worldObj.getBlock(e.target.blockX, e.target.blockY, e.target.blockZ).equals(ModBlocks.blockWindmill)){
            if(e.player.worldObj.getBlock(e.target.blockX, e.target.blockY, e.target.blockZ).equals(ModBlocks.blockWindmill)){
                onDrawHighlightWindmill(e);
            }
            if(e.player.worldObj.getBlock(e.target.blockX, e.target.blockY, e.target.blockZ).equals(ModBlocks.blockWindmillGround)){
                onDrawHighlightWindmillFloor(e);
            }
        }
    }
    public void onDrawHighlightWindmill(DrawBlockHighlightEvent event){
        Block block = event.player.worldObj.getBlock(event.target.blockX,event.target.blockY,event.target.blockZ);
        block.setBlockBoundsBasedOnState(event.player.worldObj,event.target.blockX,event.target.blockY,event.target.blockZ);
        event.setCanceled(true);
        double x = event.player.lastTickPosX +(event.player.posX = event.player.lastTickPosX)*event.partialTicks;
        double y = event.player.lastTickPosY +(event.player.posY = event.player.lastTickPosY)*event.partialTicks;
        double z = event.player.lastTickPosZ +(event.player.posZ = event.player.lastTickPosZ)*event.partialTicks;
        float f = 0.002F;
        AxisAlignedBB bounds = block.getSelectedBoundingBoxFromPool(event.player.worldObj,event.target.blockX,event.target.blockY,event.target.blockZ).expand(f,f,f).getOffsetBoundingBox(-x,-y,-z);

        int metadata = event.player.worldObj.getBlockMetadata(event.target.blockX,event.target.blockY,event.target.blockZ);

        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glColor4f(0,1,0,1);
        GL11.glLineWidth(1.5F);

        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawing(GL11.GL_LINES);
        {
            tessellator.addVertex(bounds.minX,bounds.minY+(7-metadata),bounds.minZ);
            tessellator.addVertex(bounds.minX,bounds.maxY-metadata,bounds.minZ);


        }
        tessellator.draw();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
    }
    public void onDrawHighlightWindmillFloor(DrawBlockHighlightEvent event){

        event.setCanceled(true);


    }
}
