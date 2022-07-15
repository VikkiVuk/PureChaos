
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.StroaterEntity;
import xyz.vikkivuk.chaosmod.client.model.Modelstroater;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class StroaterRenderer extends MobRenderer<StroaterEntity, Modelstroater<StroaterEntity>> {
	public StroaterRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelstroater(context.bakeLayer(Modelstroater.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(StroaterEntity entity) {
		return new ResourceLocation("chaosmod:textures/stroater.png");
	}
}
