
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import xyz.vikkivuk.chaosmod.client.renderer.TridentRenderer;
import xyz.vikkivuk.chaosmod.client.renderer.AentityRenderer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ChaosmodModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ChaosmodModEntities.DEEK.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.AENTITY.get(), AentityRenderer::new);
		event.registerEntityRenderer(ChaosmodModEntities.TRIDENT.get(), TridentRenderer::new);
	}
}
