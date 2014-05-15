package net.cazzar.mods.jam4.blocks;

import net.cazzar.mods.jam4.blocks.tile.TileBattery;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBattery extends BlockContainer {
    protected BlockBattery() {
        super(Material.wood);
        setBlockName("battery");
    }


    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileBattery();
    }
}
