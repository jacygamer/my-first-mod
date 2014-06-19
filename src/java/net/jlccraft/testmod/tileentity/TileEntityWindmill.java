package net.jlccraft.testmod.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by jerrod on 6/3/2014.
 */
public class TileEntityWindmill extends TileEntity implements ISidedInventory{
    private ItemStack[] slots = new ItemStack[2];
    public float rotation =0;

    public int maxPower =10000;


    public float power=0;
    public float powerPerRotation= 0.1F;
    protected ForgeDirection orientation;
    protected byte state;
    protected String customName;
    protected String owner;
    public static final String STATE = "teState";
    public static final String CUSTOM_NAME = "CustomName";
    public static final String DIRECTION = "teDirection";
    public static final String OWNER = "owner";

    public TileEntityWindmill()
    {
        orientation = ForgeDirection.SOUTH;
        state = 0;
        customName = "";
        owner = "";
    }

    public ForgeDirection getOrientation()
    {
        return orientation;
    }

    public void setOrientation(ForgeDirection orientation)
    {
        this.orientation = orientation;
    }

    public void setOrientation(int orientation)
    {
        this.orientation = ForgeDirection.getOrientation(orientation);
    }



    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);

        NBTTagList list = nbtTagCompound.getTagList("Slots", 10);
        this.slots = new ItemStack[getSizeInventory()];

        for(int i =0; i < list.tagCount(); i++){
            NBTTagCompound item = list.getCompoundTagAt(i);
            byte b = item.getByte("Item");

            if(b >= 0 && b < this.slots.length) {
                this.slots[b] = ItemStack.loadItemStackFromNBT(item);
            }
        }
        this.power = nbtTagCompound.getInteger("power");

        if(nbtTagCompound.hasKey("CustomName"));

    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);

        nbtTagCompound.setFloat("Power", this.power);

        NBTTagList list = new NBTTagList();

        for(int i =0; 1< this.slots.length; i++){
            if(this.slots[i]!= null){
                NBTTagCompound item = new NBTTagCompound();
                item.setByte("Item", (byte)i);
                this.slots[i].writeToNBT(item);
                list.appendTag(item);
            }
        }
        nbtTagCompound.setTag("Slots", list);

        if(this.hasCustomInventoryName()){
            nbtTagCompound.setString("custom", this.getInventoryName());
        }


    }



    public void updateEntity(){
        if(this.getWorldObj().getBlockMetadata(this.xCoord,this.yCoord,this.zCoord)> 6) {
            rotation++;


            power += powerPerRotation;
            if (power > maxPower) power = maxPower;


        }
    }

    public int getPowerScaled(int scaled){
        return (int) (this.power *scaled /this.maxPower);

    }




    @Override
    public int[] getAccessibleSlotsFromSide(int var1) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int var1, ItemStack var2, int var3) {
        return false;
    }

    @Override
    public boolean canExtractItem(int var1, ItemStack var2, int var3) {
        return false;
    }

    @Override
    public int getSizeInventory() {
        return this.slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return this.slots[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
        if(this.slots[i]!= null){
            ItemStack itemStack;

            if(this.slots[i].stackSize <= j){
                itemStack = this.slots[i];
                this.slots[i]= null;
                return itemStack;
            }else{
                itemStack = this.slots[i].splitStack(j);

                if(this.slots[i].stackSize == 0){
                    this.slots[i] = null;

                }

            }
            return itemStack;
        }

        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        if(this.slots[i] !=null){
            ItemStack itemStack = this.slots[i];
            this.slots[i] = null;
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemStack) {
        this.slots[i]= itemStack;

        if(itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()){
            itemStack.stackSize = this.getInventoryStackLimit();
        }

    }

    @Override
    public String getInventoryName() {
        return null;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    public void setInventoryName(String string){

    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer var1) {
        return false;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int var1, ItemStack var2) {
        return false;
    }


}
