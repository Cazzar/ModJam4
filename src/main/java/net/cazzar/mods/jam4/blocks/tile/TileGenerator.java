package net.cazzar.mods.jam4.blocks.tile;

import net.cazzar.mods.jam4.api.IPowerProvider;
import net.cazzar.mods.jam4.api.IPowerUser;
import net.cazzar.mods.jam4.blocks.util.BlockCoord;
import net.minecraft.tileentity.TileEntity;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class TileGenerator extends TileEntity implements IPowerProvider {
    LinkedList<BlockCoord> linkedMachnes = new LinkedList<BlockCoord>();
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

    public void distributePower() {
        final Iterator<BlockCoord> iterator = linkedMachnes.iterator();
        while (iterator.hasNext()) {
            final BlockCoord next = iterator.next();
            final TileEntity tileEntity = worldObj.getTileEntity(next.getX(), next.getY(), next.getZ());

            //vaildate entities;
            if (tileEntity == null || !(tileEntity instanceof IPowerUser))
                iterator.remove();
        }
    }

    @Override
    public void updateEntity() {
        if (worldObj.isDaytime())
            power += getMaxGeneratonAmount();

        distributePower();

        //debug code.
        System.out.println(power);
    }
}
