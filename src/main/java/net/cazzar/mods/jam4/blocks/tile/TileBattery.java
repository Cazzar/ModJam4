package net.cazzar.mods.jam4.blocks.tile;

import net.cazzar.mods.jam4.api.IPowerUser;
import net.minecraft.tileentity.TileEntity;

public class TileBattery extends TileEntity implements IPowerUser{
    public double maxPower = 2000;
    public double power = 0;

    @Override
    public boolean canAccept() {
        return power >= maxPower;
    }

    @Override
    public double needsPower() {
        return maxPower - power;
    }

    @Override
    public double acceptPower(double amount) {
        final double v = maxPower - power;

        if (amount > v) {
            power += amount - v;
            return v;
        }
        
        power += amount;
        return amount;
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
//        System.out.println("Battery: " + power);
    }
}
