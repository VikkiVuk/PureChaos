
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.LongLegChickenEntity;
import xyz.vikkivuk.chaosmod.client.model.Modellong_leg_chicken;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class LongLegChickenRenderer extends MobRenderer<LongLegChickenEntity, Modellong_leg_chicken<LongLegChickenEntity>> {
	public LongLegChickenRenderer(EntityRendererProvider.Context context) {
		super(context, new Modellong_leg_chicken(context.bakeLayer(Modellong_leg_chicken.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(LongLegChickenEntity entity) {
		return new ResourceLocation("chaosmod:textures/long_leg_chicken.png");
	}
}
