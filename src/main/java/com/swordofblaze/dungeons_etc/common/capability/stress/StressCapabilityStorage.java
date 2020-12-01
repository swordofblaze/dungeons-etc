package com.swordofblaze.dungeons_etc.common.capability.stress;

import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import net.minecraft.nbt.*;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import org.jetbrains.annotations.Nullable;

public class StressCapabilityStorage implements Capability.IStorage<IStressCapability> {

    @Nullable
    @Override
    public INBT writeNBT(Capability<IStressCapability> capability, IStressCapability instance, Direction side) {
        CompoundNBT compoundNBT = new CompoundNBT();
        compoundNBT.putInt("stress", instance.getStress());

        return compoundNBT;
    }

    @Override
    public void readNBT(Capability<IStressCapability> capability, IStressCapability instance, Direction side, INBT nbt) {
        if (nbt.getType() != CompoundNBT.TYPE) {
            DungeonsEtc.LOGGER.error("Failed to read stress capability data! The parsed data must be of type CompoundNBT");
            return;
        }
        instance.setStress(((CompoundNBT) nbt).getInt("stress"));
    }
}
