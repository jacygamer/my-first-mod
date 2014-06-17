package net.jlccraft.testmod.container;

import net.jlccraft.testmod.tileentity.TileEntityWindmill;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

/**
 * Created by jerrod on 6/14/2014.
 */
public class ContainerWindmill extends Container {
    private TileEntityWindmill windmill;

    public ContainerWindmill(InventoryPlayer inventoryPlayer, TileEntityWindmill windmill){
    this.windmill = windmill;

        this.addSlotToContainer(new Slot(windmill, 0, 53,35));
        this.addSlotToContainer(new Slot(windmill, 1, 123,35));

        for(int i = 0; i < 9; i++){
            this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i *18,172));
        }

        for(int i =0; i <3; i++){
            for(int j =0; j < 9; j++){
                this.addSlotToContainer(new Slot(inventoryPlayer,9 + j + i * 9, 8 + 18 * j, 114+ i * 18 ));

            }
        }

    }

    @Override
    public boolean canInteractWith(EntityPlayer var1) {
        return true;
    }
}
