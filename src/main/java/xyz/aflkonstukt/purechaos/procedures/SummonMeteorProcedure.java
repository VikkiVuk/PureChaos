package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import java.util.HashMap;

public class SummonMeteorProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity, double radius, double time) {
		if (entity == null)
			return;
		double expx = 0;
		double expz = 0;
		expx = Mth.nextInt(RandomSource.create(), (int) x, (int) (x + 100));
		expz = Mth.nextInt(RandomSource.create(), (int) z, (int) (z + 100));
		if (PurechaosModVariables.WorldVariables.get(world).meteor.size() != 0) {
			if (((new Object() {
				public Vec3 get(HashMap<String, Vec3> hashMap, String key) {
					Vec3 vec3 = hashMap.get(key);
					return vec3 == null ? Vec3.ZERO : vec3;
				}
			}).get(PurechaosModVariables.WorldVariables.get(world).meteor, "details")).x() == 0) {
				PurechaosModVariables.WorldVariables.get(world).meteor.put("details", (new Vec3(time, radius, 0)));
				PurechaosModVariables.WorldVariables.get(world).meteor.put("epos", (new Vec3(expx, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), expz)));
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList()
							.broadcastSystemMessage(Component.literal(("\u00A74Meteor inbound at \u00A72" + Math.round(expx) + ", " + Math.round(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)) + ", " + Math.round(expz)
									+ " \u00A74with the blast radius of " + Math.round(radius) + " blocks. It will go kaboom in " + (time / 20 >= 60 ? Math.floor((time / 20) / 60) : Math.floor(time / 20))
									+ (time / 20 >= 60 ? " minutes." : " seconds."))), false);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Meteor already inbound! Call \u00A72/event meteor cancel \u00A7fif you would like to cancel it."), false);
			}
		} else {
			PurechaosModVariables.WorldVariables.get(world).meteor.put("details", (new Vec3(time, radius, 0)));
			PurechaosModVariables.WorldVariables.get(world).meteor.put("epos", (new Vec3(expx, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), expz)));
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList()
						.broadcastSystemMessage(Component.literal(
								("\u00A74Meteor inbound at \u00A72" + Math.round(expx) + ", " + Math.round(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)) + ", " + Math.round(expz) + " \u00A74with the blast radius of "
										+ Math.round(radius) + " blocks. It will go kaboom in " + (time / 20 >= 60 ? Math.floor((time / 20) / 60) : Math.floor(time / 20)) + (time / 20 >= 60 ? " minutes." : " seconds."))),
								false);
		}
	}
}
