package net.cazzar.mods.jam4.blocks.tile;

import net.cazzar.mods.jam4.api.IPowerProvider;
import net.minecraft.tileentity.TileEntity;

public abstract class TileGenerator extends TileEntity implements IPowerProvider {
    double power = 0;

    @Override
    public boolean canProvidePower() {
        return getAvailablePower() > 0;
    }

    @Override
    public double getAvailablePower() {
        return power;
    }

    public double getMaxGeneratonAmount() {
        return 1.0;
    }

    @Override
    public double drainPower(double needed) {
        if (power < needed) {
            power = 0;
            return power;
        }

        power -= needed;
        return needed;
    }

    @Override
    public void updateEntity() {
        if (worldObj.isDaytime())
            power += getMaxGeneratonAmount();

        //debug code.
        System.out.println(power);
    }
}
