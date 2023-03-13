
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package xyz.vikkivuk.chaosmod.init;

import xyz.vikkivuk.chaosmod.potion.RadiationPoisioningMobEffect;
import xyz.vikkivuk.chaosmod.potion.HighEffectMobEffect;
import xyz.vikkivuk.chaosmod.potion.FatMobEffect;
import xyz.vikkivuk.chaosmod.potion.BlindMobEffect;
import xyz.vikkivuk.chaosmod.potion.BleachedMobEffect;
import xyz.vikkivuk.chaosmod.ChaosmodMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

public class ChaosmodModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ChaosmodMod.MODID);
	public static final RegistryObject<MobEffect> HIGH_EFFECT = REGISTRY.register("high_effect", () -> new HighEffectMobEffect());
	public static final RegistryObject<MobEffect> BLEACHED = REGISTRY.register("bleached", () -> new BleachedMobEffect());
	public static final RegistryObject<MobEffect> RADIATION_POISIONING = REGISTRY.register("radiation_poisioning", () -> new RadiationPoisioningMobEffect());
	public static final RegistryObject<MobEffect> FAT = REGISTRY.register("fat", () -> new FatMobEffect());
	public static final RegistryObject<MobEffect> BLIND = REGISTRY.register("blind", () -> new BlindMobEffect());
}
