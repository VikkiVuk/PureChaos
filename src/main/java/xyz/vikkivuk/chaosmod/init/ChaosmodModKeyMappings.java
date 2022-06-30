
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import xyz.vikkivuk.chaosmod.network.SummonsusMessage;
import xyz.vikkivuk.chaosmod.ChaosmodMod;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ChaosmodModKeyMappings {
	public static final KeyMapping SUMMONSUS = new KeyMapping("key.chaosmod.summonsus", GLFW.GLFW_KEY_K, "key.categories.o");

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(SUMMONSUS);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == SUMMONSUS.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						ChaosmodMod.PACKET_HANDLER.sendToServer(new SummonsusMessage(0, 0));
						SummonsusMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}
	}
}
