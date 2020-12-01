package com.swordofblaze.dungeons_etc.common.capability.stress;

import com.swordofblaze.dungeons_etc.common.capability.Capabilities;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("all")
public class StressCapabilityProvider implements ICapabilitySerializable<CompoundNBT> {

    private final IStressCapability INSTANCE = Capabilities.STRESS_CAPABILITY.getDefaultInstance();
    private final LazyOptional<IStressCapability> optional = LazyOptional.of(() -> INSTANCE);

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return cap == Capabilities.STRESS_CAPABILITY ? optional.cast() : LazyOptional.empty();
    }

    @Override
    public CompoundNBT serializeNBT() {
        return (CompoundNBT) Capabilities.STRESS_CAPABILITY.getStorage().writeNBT(Capabilities.STRESS_CAPABILITY, INSTANCE, null);
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        Capabilities.STRESS_CAPABILITY.getStorage().readNBT(Capabilities.STRESS_CAPABILITY, INSTANCE, null, nbt);
    }
}
