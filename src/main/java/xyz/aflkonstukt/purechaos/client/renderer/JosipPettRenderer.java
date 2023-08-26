
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.JosipPettEntity;
import xyz.aflkonstukt.purechaos.client.model.Modeljosipmmarket;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class JosipPettRenderer extends MobRenderer<JosipPettEntity, Modeljosipmmarket<JosipPettEntity>> {
	public JosipPettRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeljosipmmarket(context.bakeLayer(Modeljosipmmarket.LAYER_LOCATION)), 0.6f);
		this.addLayer(new EyesLayer<JosipPettEntity, Modeljosipmmarket<JosipPettEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("purechaos:textures/entities/mamavoilibebunajvisenasvjetttuunajvisenakurcumamaubijabebu.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(JosipPettEntity entity) {
		return new ResourceLocation("purechaos:textures/entities/mamavoilibebunajvisenasvjetttuunajvisenakurcumamaubijabebu.png");
	}
}