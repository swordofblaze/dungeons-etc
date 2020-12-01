package com.swordofblaze.dungeons_etc.common.network;

import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent.Context;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class PacketHandler {

    private static final SimpleChannel handler = createChannel();
    private int index;

    private static SimpleChannel createChannel() {
        return NetworkRegistry.ChannelBuilder
                .named(DungeonsEtc.resourceLoc(DungeonsEtc.MODID))
                .serverAcceptedVersions(getProtocolVersion()::equals)
                .clientAcceptedVersions(getProtocolVersion()::equals)
                .networkProtocolVersion(PacketHandler::getProtocolVersion)
                .simpleChannel();
    }

    public void register() {
        registerServerToClient(PacketUpdatePlayerStress.class, PacketUpdatePlayerStress::encode, PacketUpdatePlayerStress::decode, PacketUpdatePlayerStress::handle);
    }

    private <MSG> void registerClientToServer(Class<MSG> type, BiConsumer<MSG, PacketBuffer> encoder, Function<PacketBuffer, MSG> decoder, BiConsumer<MSG, Supplier<Context>> consumer) {
        this.getChannel().registerMessage(index++, type, encoder, decoder, consumer, Optional.of(NetworkDirection.PLAY_TO_SERVER));
    }

    private <MSG> void registerServerToClient(Class<MSG> type, BiConsumer<MSG, PacketBuffer> encoder, Function<PacketBuffer, MSG> decoder, BiConsumer<MSG, Supplier<Context>> consumer) {
        this.getChannel().registerMessage(index++, type, encoder, decoder, consumer, Optional.of(NetworkDirection.PLAY_TO_CLIENT));
    }

    /**
     * Sends the specified message to the client.
     *
     * @param message The message to send to the client.
     * @param player The player client that should receive this message.
     * @param <MSG> Packet type.
     */
    public <MSG> void sendToClient(MSG message, ServerPlayerEntity player) {
        getChannel().sendTo(message, player.connection.getNetworkManager(), NetworkDirection.PLAY_TO_CLIENT);
    }

    // Return the mod version when mod instance
    // has been initialized.
    private static String getProtocolVersion() {
        return DungeonsEtc.INSTANCE == null ? "0.0.0" : DungeonsEtc.INSTANCE.getModVersion();
    }

    public SimpleChannel getChannel() {
        return handler;
    }
}
