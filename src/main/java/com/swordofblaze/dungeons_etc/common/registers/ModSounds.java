package com.swordofblaze.dungeons_etc.common.registers;

import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DungeonsEtc.MODID);

    public static final RegistryObject<SoundEvent> TEST_SOUND = register("test");

    private static RegistryObject<SoundEvent> register(String name, Supplier<SoundEvent> soundEventSupplier) {
        return SOUNDS.register(name, soundEventSupplier);
    }

    private static RegistryObject<SoundEvent> register(String name) {
        return SOUNDS.register(name, () -> new SoundEvent(DungeonsEtc.resourceLoc(name)));
    }
}
