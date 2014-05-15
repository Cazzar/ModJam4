package net.cazzar.mods.jam4.client.gui;

import net.cazzar.mods.jam4.blocks.tile.TileFurnace;
import net.cazzar.mods.jam4.gui.container.ContainerFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import static org.lwjgl.opengl.GL11.glColor4f;

public class GuiFurnace extends GuiContainer {
    public static ResourceLocation location = new ResourceLocation("solarexpansion", "textures/gui/guiFurnace.png");

    public GuiFurnace(EntityPlayer player, TileFurnace tileEntity) {
        super(new ContainerFurnace(player, tileEntity));
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        glColor4f(1f, 1f, 1f, 1f);
        mc.renderEngine.bindTexture(location);
        final int xSize = (width - this.xSize) / 2;
        final int ySize = (height - this.ySize) / 2;
    }
}
