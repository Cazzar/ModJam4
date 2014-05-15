package net.cazzar.mods.jam4;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.cazzar.mods.jam4.proxy.CommonProxy;
import org.apache.logging.log4j.Logger;

@Mod(modid = "SolarExpansion", version = "1.0")
public class SolarExpansion {
    @SidedProxy(clientSide = "net.cazzar.mods.jam4.proxy.ClientProxy", serverSide = "net.cazzar.mods.jam4.proxy.CommonProxy")
    public static CommonProxy proxy;
    @Mod.Instance
    public static SolarExpansion instance;

    public Logger log;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.initBlocks();
        proxy.initItems();
        proxy.initNetwork();
        log = event.getModLog();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }
}
