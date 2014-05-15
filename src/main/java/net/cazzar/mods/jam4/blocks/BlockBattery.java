package net.cazzar.mods.jam4.blocks;

import net.cazzar.mods.jam4.blocks.tile.TileBattery;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class BlockBattery extends BlockContainer {
    public BlockBattery() {
        super(Material.wood);
        setBlockName("battery");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        final TileEntity tileEntity = world.getTileEntity(x, y, z);
        player.addChatComponentMessage(new ChatComponentTranslation("info.solarExpansion.batteryLevel", ((TileBattery) tileEntity).power));
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileBattery();
    }
}
