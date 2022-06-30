
package xyz.vikkivuk.chaosmod.client.renderer;

public class JosipdvatockanulaRenderer extends HumanoidMobRenderer<JosipdvatockanulaEntity, HumanoidModel<JosipdvatockanulaEntity>> {

	public JosipdvatockanulaRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);

		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));

	}

	@Override
	public ResourceLocation getTextureLocation(JosipdvatockanulaEntity entity) {
		return new ResourceLocation("chaosmod:textures/entity02redacted_form_2.png");
	}

}