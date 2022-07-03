package xyz.vikkivuk.chaosmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class HighEffectEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeAllEffects();
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 280, 1, (false), (true)));
	}
}