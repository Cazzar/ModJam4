package net.cazzar.mods.jam4.blocks;

import net.cazzar.mods.jam4.blocks.tile.TileGeneratorImpl;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockGenerator extends BlockContainer {
    public BlockGenerator() {
        super(Material.iron);
        setBlockName("solarGenerator");
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileGeneratorImpl();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
                return false;
    }
}
