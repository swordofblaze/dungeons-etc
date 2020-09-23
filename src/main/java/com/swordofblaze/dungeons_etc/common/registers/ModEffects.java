package com.swordofblaze.dungeons_etc.common.registers;

import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import com.swordofblaze.dungeons_etc.common.effects.DeathMarkEffect;
import com.swordofblaze.dungeons_etc.common.effects.StunEffect;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEffects {

    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, DungeonsEtc.MODID);

    public static final RegistryObject<Effect> DEATH_MARK = EFFECTS.register("death_mark", () -> new DeathMarkEffect(EffectType.HARMFUL, 0xC30200));
    public static final RegistryObject<Effect> STUN = EFFECTS.register("stun", () -> new StunEffect(EffectType.HARMFUL, 0xD3B044));
    public static final RegistryObject<Effect> BLEED = EFFECTS.register("bleed", () -> new StunEffect(EffectType.HARMFUL, 0xC20100));
    public static final RegistryObject<Effect> BLIGHT = EFFECTS.register("blight", () -> new StunEffect(EffectType.HARMFUL, 0x6A780E));
    public static final RegistryObject<Effect> HORROR = EFFECTS.register("horror", () -> new StunEffect(EffectType.HARMFUL, 0x232323));
}
