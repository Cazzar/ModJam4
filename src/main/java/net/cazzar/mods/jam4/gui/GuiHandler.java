package net.cazzar.mods.jam4.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import net.cazzar.mods.jam4.tile.TileFurnace;
import net.cazzar.mods.jam4.client.gui.GuiFurnace;
import net.cazzar.mods.jam4.gui.container.ContainerFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
    public static final int GUI_FURNACE = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case GUI_FURNACE:
               return new ContainerFurnace(player, (TileFurnace) world.getTileEntity(x, y, z));
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case GUI_FURNACE:
                return new GuiFurnace(player, (TileFurnace) world.getTileEntity(x, y, z));
        }
        return null;
    }
}
