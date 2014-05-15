package net.cazzar.mods.jam4.api;

public interface IPowerUser {
    public boolean canAccept();
    public double needsPower();
    public double acceptPower(double amount);
}
