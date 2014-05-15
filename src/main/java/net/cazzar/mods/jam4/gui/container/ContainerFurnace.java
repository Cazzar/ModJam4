package net.cazzar.mods.jam4.gui.container;

import net.cazzar.mods.jam4.tile.TileFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerFurnace extends Container {
    public ContainerFurnace(EntityPlayer player, TileFurnace tileEntity) {
    }

    @Override
    public boolean canInteractWith(EntityPlayer var1) {
        return true;
    }
}
