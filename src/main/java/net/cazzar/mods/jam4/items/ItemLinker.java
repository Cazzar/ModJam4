package net.cazzar.mods.jam4.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemLinker extends Item {
    public ItemLinker() {
        setUnlocalizedName("linker");
        setMaxStackSize(1);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int meta, float hitx, float hity, float hitz) {
        if (stack.getTagCompound() == null) {
            stack.setTagCompound(new NBTTagCompound());
        }

        if (stack.getTagCompound().getBoolean("selecting")) {

        }

        stack.getTagCompound().setInteger("x", x);
        stack.getTagCompound().setInteger("y", y);
        stack.getTagCompound().setInteger("z", z);
        stack.getTagCompound().setBoolean("selecting", true);
        return true;
    }
}
