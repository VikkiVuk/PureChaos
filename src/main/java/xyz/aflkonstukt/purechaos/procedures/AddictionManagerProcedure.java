package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AddictionManagerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).meth_addiction == -2) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("bossbar add meth_addiction_" + (entity.getDisplayName().getString()).toLowerCase() + " \"Time until withdrawl from meth\""));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("bossbar set meth_addiction_" + (entity.getDisplayName().getString()).toLowerCase() + " max 1200"));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("bossbar set meth_addiction_" + (entity.getDisplayName().getString()).toLowerCase() + " players " + (entity.getDisplayName().getString()).toLowerCase()));
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.meth_addiction = 0;
				_vars.syncPlayerVariables(entity);
			}
		} else if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).meth_addiction >= 0 && entity.getData(PurechaosModVariables.PLAYER_VARIABLES).meth_addiction <= 1200) {
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.meth_addiction = entity.getData(PurechaosModVariables.PLAYER_VARIABLES).meth_addiction + 1;
				_vars.syncPlayerVariables(entity);
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("bossbar set meth_addiction_" + (entity.getDisplayName().getString()).toLowerCase() + " value " + (1200 - Math.round(entity.getData(PurechaosModVariables.PLAYER_VARIABLES).meth_addiction / 20))));
		} else if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).meth_addiction >= 1200) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Oh no, you didnt use your meth, you will now die :( (unless you're in creative)"), false);
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("purechaos:addiction_death")))), 1);
		}
		if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).alcohol_addiction == -2) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("bossbar add alcohol_addiction_" + (entity.getDisplayName().getString()).toLowerCase() + " \"Time until withdrawl from alcohol\""));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("bossbar set alcohol_addiction_" + (entity.getDisplayName().getString()).toLowerCase() + " max 1200"));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("bossbar set alcohol_addiction_" + (entity.getDisplayName().getString()).toLowerCase() + " players " + (entity.getDisplayName().getString()).toLowerCase()));
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.alcohol_addiction = 0;
				_vars.syncPlayerVariables(entity);
			}
		} else if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).alcohol_addiction >= 0 && entity.getData(PurechaosModVariables.PLAYER_VARIABLES).alcohol_addiction <= 1200) {
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.alcohol_addiction = entity.getData(PurechaosModVariables.PLAYER_VARIABLES).alcohol_addiction + 1;
				_vars.syncPlayerVariables(entity);
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("bossbar set meth_addiction_" + (entity.getDisplayName().getString()).toLowerCase() + " value " + (1200 - Math.round(entity.getData(PurechaosModVariables.PLAYER_VARIABLES).alcohol_addiction / 20))));
		} else if (entity.getData(PurechaosModVariables.PLAYER_VARIABLES).alcohol_addiction >= 1200) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Oh no, you didnt drink alcohol, you will now die :( (unless you're in creative)"), false);
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("purechaos:addiction_death")))), 1);
		}
	}
}
