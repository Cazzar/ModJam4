package net.cazzar.mods.jam4.blocks;

import net.cazzar.mods.jam4.SolarExpansion;
import net.cazzar.mods.jam4.blocks.tile.TileFurnace;
import net.cazzar.mods.jam4.gui.GuiHandler;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockFurnace extends BlockContainer {
    protected BlockFurnace() {
        super(Material.iron);
    }

    @Override
    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (!p_149727_1_.isRemote)  p_149727_5_.openGui(SolarExpansion.instance, GuiHandler.GUI_FURNACE, p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_);

        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileFurnace();
    }
}
