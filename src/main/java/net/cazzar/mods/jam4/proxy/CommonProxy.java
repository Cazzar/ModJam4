package net.cazzar.mods.jam4.proxy;

import cpw.mods.fml.common.registry.GameRegistry;
import net.cazzar.mods.jam4.blocks.BlockGenerator;

public class CommonProxy {
    public BlockGenerator blockGenerator;

    public void initBlocks() {
        blockGenerator = new BlockGenerator();
        GameRegistry.registerBlock(blockGenerator, "generator");
    }
}
