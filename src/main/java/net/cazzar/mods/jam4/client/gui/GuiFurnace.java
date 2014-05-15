package net.cazzar.mods.jam4.client.gui;

import net.cazzar.mods.jam4.gui.container.ContainerFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;

public class GuiFurnace extends GuiContainer {
    public GuiFurnace(EntityPlayer player) {
        super(new ContainerFurnace());
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {

    }
}
