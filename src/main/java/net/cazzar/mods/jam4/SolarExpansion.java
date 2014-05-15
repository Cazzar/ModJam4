package net.cazzar.mods.jam4;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.cazzar.mods.jam4.proxy.CommonProxy;

@Mod(modid = "SolarExpansion", version = "1.0")
public class SolarExpansion {
    @Mod.Instance
    public static SolarExpansion instance;

    @SidedProxy(clientSide = "net.cazzar.mods.jam4.proxy.ClientProxy", serverSide = "net.cazzar.mods.jam4.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.initBlocks();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }
}
