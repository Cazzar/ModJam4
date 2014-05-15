package net.cazzar.mods.jam4.api;

import net.cazzar.mods.jam4.blocks.util.BlockCoord;

public interface IPowerProvider {
    public boolean canProvidePower();
    public double getAvailablePower();
    public double drainPower(double needed);
    public boolean addMachine(BlockCoord coord);
}
