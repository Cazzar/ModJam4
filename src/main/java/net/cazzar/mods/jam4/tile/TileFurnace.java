package net.cazzar.mods.jam4.tile;

import net.cazzar.mods.jam4.api.IPowerUser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;

public class TileFurnace extends SyncedTileEntity implements IInventory, ISidedInventory, IPowerUser {
    private final static int burnTime = 200;
    public ItemStack[] items;
    public double power;

    public TileFurnace() {
        this.items = new ItemStack[getSizeInventory()];
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        for (int i = 0; i < items.length; i++) {
            tag.getCompoundTag(String.valueOf(i));
            new ItemStack(Blocks.brick_block).readFromNBT(tag);
        }

        power = tag.getDouble("power");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        for (int i = 0; i < items.length; i++) {
            NBTTagCompound compound = new NBTTagCompound();
            if (items[i] != null)
                items[i].writeToNBT(compound);
            tag.setTag(String.valueOf(i), compound);
        }

        tag.setDouble("power", power);
    }

    public double maxPower() {
        return 2000;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int var1) {
        return new int[] {1, 2};
    }

    @Override
    public boolean canInsertItem(int var1, ItemStack var2, int var3) {
        return var1 == 0;
    }

    @Override
    public boolean canExtractItem(int var1, ItemStack var2, int var3) {
        return var1 == 1;
    }

    @Override
    public int getSizeInventory() {
        return 2;
    }

    @Override
    public ItemStack getStackInSlot(int var1) {
        return items[var1];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        if (getStackInSlot(slot).stackSize - amount < 0)
            setInventorySlotContents(slot, null);
        else getStackInSlot(slot).stackSize -= amount;

        return getStackInSlot(slot);
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int var1) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int var1, ItemStack var2) {
        items[var1] = var2;
    }

    @Override
    public String getInventoryName() {
        return "Furnace";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer var1) {
        return true;
    }

    @Override
    public void openInventory() {}

    @Override
    public void closeInventory() {}

    @Override
    public boolean isItemValidForSlot(int var1, ItemStack var2) {
        return FurnaceRecipes.smelting().getSmeltingList().containsKey(var2.getItem()) && var1 == 0;
    }

    @Override
    public boolean canAccept() {
        return power <= maxPower();
    }

    @Override
    public double needsPower() {
        return maxPower() - power;
    }

    @Override
    public double acceptPower(double amount) {
        //TODO: Fix my shit
        final double v = maxPower() - power;

        if (amount > v) {
            power += amount - v;
            return v;
        }

        power += amount;
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        markDirty();
        return amount;
    }
}
