package net.cazzar.mods.jam4.tile;

import net.cazzar.mods.jam4.api.IPowerProvider;
import net.cazzar.mods.jam4.api.IPowerUser;
import net.cazzar.mods.jam4.util.BlockCoord;
import net.minecraft.tileentity.TileEntity;

import java.util.Iterator;
import java.util.LinkedList;

public class TileBattery extends TileEntity implements IPowerUser, IPowerProvider {
    LinkedList<BlockCoord> linkedMachines = new LinkedList<BlockCoord>();
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
        distributePower();
//        System.out.println("Battery: " + power);
    }

    @Override
    public boolean canProvidePower() {
        return power > 0;
    }

    @Override
    public double getAvailablePower() {
        return power;
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
    public boolean addMachine(BlockCoord coord) {
        return linkedMachines.add(coord);
    }

    public void distributePower() {
        final Iterator<BlockCoord> iterator = linkedMachines.iterator();
        while (iterator.hasNext()) {
            final BlockCoord next = iterator.next();
            final TileEntity tileEntity = worldObj.getTileEntity(next.getX(), next.getY(), next.getZ());

            //vaildate entities;
            if (tileEntity == null || !(tileEntity instanceof IPowerUser))
                iterator.remove();


            int dx = xCoord - next.getX();
            int dy = yCoord - next.getY();
            int dz = zCoord - next.getZ();

            final double distanceFrom = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2));

            if (distanceFrom > 10) {
                iterator.remove();
                return;
            }

            IPowerUser user = (IPowerUser) tileEntity;
            //shuddup intelliJ i already checked.
            if (user != null) {
                final double transferRate = getTransferRate();
                if (power < transferRate)
                    power -= user.acceptPower(power);
                else power -= user.acceptPower(transferRate);
            }
        }
    }

    public double getTransferRate() {
        return 20;
    }
}
