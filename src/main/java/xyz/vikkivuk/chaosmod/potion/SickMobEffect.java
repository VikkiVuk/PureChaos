
package xyz.vikkivuk.chaosmod.potion;

import xyz.vikkivuk.chaosmod.procedures.SickEffectStartedappliedProcedure;
import xyz.vikkivuk.chaosmod.procedures.SickEffectExpiresProcedure;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class SickMobEffect extends MobEffect {
	public SickMobEffect() {
		super(MobEffectCategory.HARMFUL, -16711885);
	}

	@Override
	public String getDescriptionId() {
		return "effect.chaosmod.sick";
	}

	@Override
	public boolean isInstantenous() {
		return true;
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		SickEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		SickEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
