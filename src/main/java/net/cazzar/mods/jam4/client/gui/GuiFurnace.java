package net.cazzar.mods.jam4.client.gui;

import net.cazzar.mods.jam4.gui.container.ContainerFurnace;
import net.cazzar.mods.jam4.tile.TileFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import static org.lwjgl.opengl.GL11.glColor4f;

public class GuiFurnace extends GuiContainer {
    public static ResourceLocation location = new ResourceLocation("solarexpansion", "textures/gui/guiFurnace.png");
    public final TileFurnace tile;

    public GuiFurnace(EntityPlayer player, TileFurnace tileEntity) {
        super(new ContainerFurnace(player, tileEntity));
        tile = tileEntity;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        glColor4f(1f, 1f, 1f, 1f);
        mc.renderEngine.bindTexture(location);
        final int xStart = (width - this.xSize) / 2;
        final int yStart = (height - this.ySize) / 2;
        drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);

        int power = (int) (tile.power / tile.maxPower() * 64);

        drawTexturedModalRect(xStart + 6, yStart + 6 + (64 - power), 176, 31, 13, power);
    }
}
