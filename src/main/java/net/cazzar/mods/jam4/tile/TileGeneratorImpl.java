package net.cazzar.mods.jam4.tile;

public class TileGeneratorImpl extends TileGenerator {
    @Override
    public double getMaxGenerationAmount() {
        return 1.0;
    }

    @Override
    public double getTransferRate() {
        return 20;
    }
}
