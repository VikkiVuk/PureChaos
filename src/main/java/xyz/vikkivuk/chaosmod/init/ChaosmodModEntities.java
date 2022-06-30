
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import xyz.vikkivuk.chaosmod.entity.WaterCupEntity;
import xyz.vikkivuk.chaosmod.entity.TridentEntity;
import xyz.vikkivuk.chaosmod.entity.SplankEntity;
import xyz.vikkivuk.chaosmod.entity.KondomnepitajzastoovoradimalispoileralertonimarupuEntity;
import xyz.vikkivuk.chaosmod.entity.JosipdvatockanulaEntity;
import xyz.vikkivuk.chaosmod.entity.JOSIPEntity;
import xyz.vikkivuk.chaosmod.entity.IkeaDeskEntity;
import xyz.vikkivuk.chaosmod.entity.DeekEntity;
import xyz.vikkivuk.chaosmod.entity.AmongUsEntity;
import xyz.vikkivuk.chaosmod.entity.Amogus3Entity;
import xyz.vikkivuk.chaosmod.entity.Amogus2Entity;
import xyz.vikkivuk.chaosmod.entity.AentityEntity;
import xyz.vikkivuk.chaosmod.ChaosmodMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChaosmodModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, ChaosmodMod.MODID);
	public static final RegistryObject<EntityType<DeekEntity>> DEEK = register("projectile_deek",
			EntityType.Builder.<DeekEntity>of(DeekEntity::new, MobCategory.MISC).setCustomClientFactory(DeekEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AentityEntity>> AENTITY = register("aentity",
			EntityType.Builder.<AentityEntity>of(AentityEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(100)
					.setUpdateInterval(3).setCustomClientFactory(AentityEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TridentEntity>> TRIDENT = register("trident",
			EntityType.Builder.<TridentEntity>of(TridentEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(TridentEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AmongUsEntity>> AMONG_US = register("among_us",
			EntityType.Builder.<AmongUsEntity>of(AmongUsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(69)
					.setUpdateInterval(3).setCustomClientFactory(AmongUsEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Amogus2Entity>> AMOGUS_2 = register("amogus_2",
			EntityType.Builder.<Amogus2Entity>of(Amogus2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(Amogus2Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Amogus3Entity>> AMOGUS_3 = register("amogus_3",
			EntityType.Builder.<Amogus3Entity>of(Amogus3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32)
					.setUpdateInterval(3).setCustomClientFactory(Amogus3Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<KondomnepitajzastoovoradimalispoileralertonimarupuEntity>> KONDOMNEPITAJZASTOOVORADIMALISPOILERALERTONIMARUPU = register(
			"projectile_kondomnepitajzastoovoradimalispoileralertonimarupu",
			EntityType.Builder
					.<KondomnepitajzastoovoradimalispoileralertonimarupuEntity>of(KondomnepitajzastoovoradimalispoileralertonimarupuEntity::new,
							MobCategory.MISC)
					.setCustomClientFactory(KondomnepitajzastoovoradimalispoileralertonimarupuEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<WaterCupEntity>> WATER_CUP = register("projectile_water_cup",
			EntityType.Builder.<WaterCupEntity>of(WaterCupEntity::new, MobCategory.MISC).setCustomClientFactory(WaterCupEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SplankEntity>> SPLANK = register("splank",
			EntityType.Builder.<SplankEntity>of(SplankEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(SplankEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<IkeaDeskEntity>> IKEA_DESK = register("ikea_desk",
			EntityType.Builder.<IkeaDeskEntity>of(IkeaDeskEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(IkeaDeskEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<JOSIPEntity>> JOSIP = register("josip",
			EntityType.Builder.<JOSIPEntity>of(JOSIPEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(69)
					.setUpdateInterval(3).setCustomClientFactory(JOSIPEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<JosipdvatockanulaEntity>> JOSIPDVATOCKANULA = register("josipdvatockanula",
			EntityType.Builder.<JosipdvatockanulaEntity>of(JosipdvatockanulaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(100).setUpdateInterval(3).setCustomClientFactory(JosipdvatockanulaEntity::new).fireImmune().sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			AentityEntity.init();
			TridentEntity.init();
			AmongUsEntity.init();
			Amogus2Entity.init();
			Amogus3Entity.init();
			SplankEntity.init();
			IkeaDeskEntity.init();
			JOSIPEntity.init();
			JosipdvatockanulaEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(AENTITY.get(), AentityEntity.createAttributes().build());
		event.put(TRIDENT.get(), TridentEntity.createAttributes().build());
		event.put(AMONG_US.get(), AmongUsEntity.createAttributes().build());
		event.put(AMOGUS_2.get(), Amogus2Entity.createAttributes().build());
		event.put(AMOGUS_3.get(), Amogus3Entity.createAttributes().build());
		event.put(SPLANK.get(), SplankEntity.createAttributes().build());
		event.put(IKEA_DESK.get(), IkeaDeskEntity.createAttributes().build());
		event.put(JOSIP.get(), JOSIPEntity.createAttributes().build());
		event.put(JOSIPDVATOCKANULA.get(), JosipdvatockanulaEntity.createAttributes().build());
	}
}
