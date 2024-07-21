
package xyz.aflkonstukt.purechaos.network;

import xyz.aflkonstukt.purechaos.procedures.TwoOnKeyPressedProcedure;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record TwoMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<TwoMessage> TYPE = new Type<>(new ResourceLocation(PurechaosMod.MODID, "key_two"));
	public static final StreamCodec<RegistryFriendlyByteBuf, TwoMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, TwoMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new TwoMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<TwoMessage> type() {
		return TYPE;
	}

	public static void handleData(final TwoMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				pressAction(context.player(), message.eventType, message.pressedms);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;
		if (type == 0) {

			TwoOnKeyPressedProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PurechaosMod.addNetworkMessage(TwoMessage.TYPE, TwoMessage.STREAM_CODEC, TwoMessage::handleData);
	}
}
