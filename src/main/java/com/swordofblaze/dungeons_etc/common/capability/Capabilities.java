package com.swordofblaze.dungeons_etc.common.capability;

import com.swordofblaze.dungeons_etc.common.capability.stress.DefaultStressCapability;
import com.swordofblaze.dungeons_etc.common.capability.stress.IStressCapability;
import com.swordofblaze.dungeons_etc.common.capability.stress.StressCapabilityStorage;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class Capabilities {

    @CapabilityInject(value = IStressCapability.class)
    public static final Capability<IStressCapability> STRESS_CAPABILITY = null;

    public static void registerCapabilities() {
       CapabilityManager.INSTANCE.register(IStressCapability.class, new StressCapabilityStorage(), DefaultStressCapability::new);
    }
}
