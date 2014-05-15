package net.cazzar.mods.jam4.proxy;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.cazzar.mods.jam4.SolarExpansion;
import net.cazzar.mods.jam4.blocks.BlockBattery;
import net.cazzar.mods.jam4.blocks.BlockFurnace;
import net.cazzar.mods.jam4.blocks.BlockGenerator;
import net.cazzar.mods.jam4.tile.TileBattery;
import net.cazzar.mods.jam4.tile.TileFurnace;
import net.cazzar.mods.jam4.tile.TileGeneratorImpl;
import net.cazzar.mods.jam4.gui.GuiHandler;
import net.cazzar.mods.jam4.items.ItemLinker;

public class CommonProxy {
    public BlockGenerator blockGenerator;
    public ItemLinker itemLinker;
    public BlockBattery blockBattery;
    public BlockFurnace blockFurnace;

    public void initBlocks() {
        blockGenerator = new BlockGenerator();
        blockBattery = new BlockBattery();
        blockFurnace = new BlockFurnace();
        GameRegistry.registerBlock(blockGenerator, "generator");
        GameRegistry.registerBlock(blockBattery, "battery");
        GameRegistry.registerBlock(blockFurnace, "furnace");

        GameRegistry.registerTileEntity(TileBattery.class, "battery");
        GameRegistry.registerTileEntity(TileGeneratorImpl.class, "generatorBase");
        GameRegistry.registerTileEntity(TileFurnace.class, "furnace");
    }

    public void initItems() {
        itemLinker = new ItemLinker();
        GameRegistry.registerItem(itemLinker, "linker");
    }

    public void initNetwork() {
        NetworkRegistry.INSTANCE.registerGuiHandler(SolarExpansion.instance, new GuiHandler());
    }
}
