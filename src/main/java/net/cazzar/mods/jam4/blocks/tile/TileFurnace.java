package net.cazzar.mods.jam4.blocks.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileFurnace extends TileEntity implements IInventory, ISidedInventory {
    public ItemStack[] items;

    public TileFurnace() {
        this.items = new ItemStack[getSizeInventory()];
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
        if (getStackInSlot(slot))
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int var1) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int var1, ItemStack var2) {

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
        return 0;
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
