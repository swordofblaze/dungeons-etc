package com.swordofblaze.dungeons_etc.common.network;

import com.swordofblaze.dungeons_etc.common.capability.Capabilities;
import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent.Context;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class PacketUpdatePlayerStress {

    private final int stress;

    public PacketUpdatePlayerStress(int stress) {
        this.stress = stress;
    }

    @SuppressWarnings("all")
    public static void handle(PacketUpdatePlayerStress message, Supplier<Context> context) {
        context.get().enqueueWork(() -> {
            Minecraft.getInstance().player.getCapability(Capabilities.STRESS_CAPABILITY).ifPresent(iStressCapability -> iStressCapability.setStress(message.stress));
        });
        context.get().setPacketHandled(true);
    }

    public static PacketUpdatePlayerStress decode(PacketBuffer buffer) {
        return new PacketUpdatePlayerStress(buffer.readInt());
    }

    public static void encode(PacketUpdatePlayerStress packet, PacketBuffer buffer) {
        buffer.writeInt(packet.stress);
    }
}
