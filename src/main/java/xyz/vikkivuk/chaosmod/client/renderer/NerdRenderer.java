
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.NerdEntity;
import xyz.vikkivuk.chaosmod.client.model.Modelnextbot;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class NerdRenderer extends MobRenderer<NerdEntity, Modelnextbot<NerdEntity>> {
	public NerdRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelnextbot(context.bakeLayer(Modelnextbot.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(NerdEntity entity) {
		return new ResourceLocation("chaosmod:textures/entities/nerd.png");
	}
}
