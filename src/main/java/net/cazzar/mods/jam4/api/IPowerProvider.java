package net.cazzar.mods.jam4.api;

public interface IPowerProvider {
    public boolean canProvidePower();
    public double getAvailablePower();
    public double drainPower(double needed);
}
