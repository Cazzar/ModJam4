package net.cazzar.mods.jam4.items;

import net.cazzar.mods.jam4.api.IPowerProvider;
import net.cazzar.mods.jam4.api.IPowerUser;
import net.cazzar.mods.jam4.util.BlockCoord;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class ItemLinker extends Item {
    public ItemLinker() {
        setUnlocalizedName("linker");
        setMaxStackSize(1);
        setTextureName("solarexpansion:linker");
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int meta, float hitx, float hity, float hitz) {
        if (world.isRemote) return true;

        if (stack.getTagCompound() == null) {
            stack.setTagCompound(new NBTTagCompound());
        }

        final TileEntity tileEntity = world.getTileEntity(x, y, z);

        if (stack.getTagCompound().getBoolean("selecting")) {
            //yaay
            IPowerProvider generator = (IPowerProvider) world.getTileEntity(stack.getTagCompound().getInteger("x"), stack.getTagCompound().getInteger("y"), stack.getTagCompound().getInteger("z"));
            if (tileEntity instanceof IPowerUser) {
                //final IPowerUser entity = (IPowerUser) tileEntity;
                int dx = x - stack.getTagCompound().getInteger("x");
                int dy = y - stack.getTagCompound().getInteger("y");
                int dz = z - stack.getTagCompound().getInteger("z");

                final double distanceFrom = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2));
                if (distanceFrom > 10) {
                    player.addChatComponentMessage(new ChatComponentTranslation("errmsg.solarExpansion.tooLong"));
                    return true;
                }

                generator.addMachine(new BlockCoord(x, y, z));
            }

            stack.getTagCompound().setBoolean("selecting", false);
            return true;
        }

        if (tileEntity == null || !(tileEntity instanceof IPowerProvider)) {
            player.addChatComponentMessage(new ChatComponentTranslation("errmsg.solarExpansion.clickGenerator"));
            return true;
        }

        stack.getTagCompound().setInteger("x", x);
        stack.getTagCompound().setInteger("y", y);
        stack.getTagCompound().setInteger("z", z);
        stack.getTagCompound().setBoolean("selecting", true);
        return true;
    }
}
