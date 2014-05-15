package net.cazzar.mods.jam4.proxy;

import cpw.mods.fml.common.registry.GameRegistry;
import net.cazzar.mods.jam4.blocks.BlockGenerator;
import net.cazzar.mods.jam4.items.ItemLinker;

public class CommonProxy {
    public BlockGenerator blockGenerator;
    public ItemLinker itemLinker;

    public void initBlocks() {
        blockGenerator = new BlockGenerator();
        GameRegistry.registerBlock(blockGenerator, "generator");
    }

    public void initItems() {
        itemLinker = new ItemLinker();
        GameRegistry.registerItem(itemLinker, "linker");
    }
}
