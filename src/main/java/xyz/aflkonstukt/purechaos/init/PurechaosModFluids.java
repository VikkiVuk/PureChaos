
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.fluid.StaravodaFluid;
import xyz.aflkonstukt.purechaos.fluid.RadiationLiquidFluid;
import xyz.aflkonstukt.purechaos.fluid.PeeFluid;
import xyz.aflkonstukt.purechaos.fluid.OrangeFluidFluid;
import xyz.aflkonstukt.purechaos.fluid.OilFluid;
import xyz.aflkonstukt.purechaos.fluid.Milk2Fluid;
import xyz.aflkonstukt.purechaos.fluid.GatoradeFluid;
import xyz.aflkonstukt.purechaos.fluid.CumFluid;
import xyz.aflkonstukt.purechaos.fluid.CobbleFluidFluid;
import xyz.aflkonstukt.purechaos.fluid.CarbonMonoxideFluid;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

public class PurechaosModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, PurechaosMod.MODID);
	public static final RegistryObject<Fluid> PEE = REGISTRY.register("pee", () -> new PeeFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_PEE = REGISTRY.register("flowing_pee", () -> new PeeFluid.Flowing());
	public static final RegistryObject<Fluid> CUM = REGISTRY.register("cum", () -> new CumFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_CUM = REGISTRY.register("flowing_cum", () -> new CumFluid.Flowing());
	public static final RegistryObject<Fluid> STARAVODA = REGISTRY.register("staravoda", () -> new StaravodaFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_STARAVODA = REGISTRY.register("flowing_staravoda", () -> new StaravodaFluid.Flowing());
	public static final RegistryObject<Fluid> ORANGE_FLUID = REGISTRY.register("orange_fluid", () -> new OrangeFluidFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_ORANGE_FLUID = REGISTRY.register("flowing_orange_fluid", () -> new OrangeFluidFluid.Flowing());
	public static final RegistryObject<Fluid> OIL = REGISTRY.register("oil", () -> new OilFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_OIL = REGISTRY.register("flowing_oil", () -> new OilFluid.Flowing());
	public static final RegistryObject<Fluid> GATORADE = REGISTRY.register("gatorade", () -> new GatoradeFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_GATORADE = REGISTRY.register("flowing_gatorade", () -> new GatoradeFluid.Flowing());
	public static final RegistryObject<Fluid> CARBON_MONOXIDE = REGISTRY.register("carbon_monoxide", () -> new CarbonMonoxideFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_CARBON_MONOXIDE = REGISTRY.register("flowing_carbon_monoxide", () -> new CarbonMonoxideFluid.Flowing());
	public static final RegistryObject<Fluid> MILK_2 = REGISTRY.register("milk_2", () -> new Milk2Fluid.Source());
	public static final RegistryObject<Fluid> FLOWING_MILK_2 = REGISTRY.register("flowing_milk_2", () -> new Milk2Fluid.Flowing());
	public static final RegistryObject<Fluid> RADIATION_LIQUID = REGISTRY.register("radiation_liquid", () -> new RadiationLiquidFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_RADIATION_LIQUID = REGISTRY.register("flowing_radiation_liquid", () -> new RadiationLiquidFluid.Flowing());
	public static final RegistryObject<Fluid> COBBLE_FLUID = REGISTRY.register("cobble_fluid", () -> new CobbleFluidFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_COBBLE_FLUID = REGISTRY.register("flowing_cobble_fluid", () -> new CobbleFluidFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(PEE.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_PEE.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(CUM.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_CUM.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(STARAVODA.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_STARAVODA.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(ORANGE_FLUID.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_ORANGE_FLUID.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(OIL.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_OIL.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(GATORADE.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_GATORADE.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(CARBON_MONOXIDE.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_CARBON_MONOXIDE.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(MILK_2.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_MILK_2.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(RADIATION_LIQUID.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_RADIATION_LIQUID.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(COBBLE_FLUID.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_COBBLE_FLUID.get(), renderType -> renderType == RenderType.translucent());
		}
	}
}