package net.jlccraft.testmod.gui;

import net.jlccraft.testmod.container.ContainerWindmill;
import net.jlccraft.testmod.lib.Reference;
import net.jlccraft.testmod.tileentity.TileEntityWindmill;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by jerrod on 6/14/2014.
 */
public class GuiWindmill extends GuiContainer {

    public final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/windmill.png");

    private  TileEntityWindmill windmill;

    public GuiWindmill(InventoryPlayer inventoryPlayer, TileEntityWindmill windmill) {
        super(new ContainerWindmill(inventoryPlayer, windmill));

        this.windmill = windmill;

        this.xSize =176;
        this.ySize =196;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {

        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        drawTexturedModalRect(guiLeft,guiTop, 0,0,xSize,ySize);

        int i1 = this.windmill.getPowerScaled(25);


        drawTexturedModalRect(k + 79,l + 38, 176,18 ,i1,9);



    }
}
