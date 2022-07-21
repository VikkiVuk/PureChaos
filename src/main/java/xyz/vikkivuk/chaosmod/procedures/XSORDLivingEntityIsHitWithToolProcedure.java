package xyz.vikkivuk.chaosmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class XSORDLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(ChaosmodModMobEffects.RADIATION_POISIONING.get(), 60, 1, (false), (true)));
	}
}