
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package xyz.aflkonstukt.purechaos.init;

import xyz.aflkonstukt.purechaos.PurechaosMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PurechaosModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PurechaosMod.MODID);
	public static final RegistryObject<CreativeModeTab> CHAOSTAB = REGISTRY.register("chaostab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.purechaos.chaostab")).icon(() -> new ItemStack(PurechaosModItems.DIRTSWORD.get())).displayItems((parameters, tabData) -> {
				tabData.accept(PurechaosModItems.DIRTSWORD.get());
				tabData.accept(PurechaosModItems.PEE_BUCKET.get());
				tabData.accept(PurechaosModItems.PEEMENSION.get());
				tabData.accept(PurechaosModBlocks.PEE_BLOCK.get().asItem());
				tabData.accept(PurechaosModItems.AENTITY_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.FOODITEM.get());
				tabData.accept(PurechaosModItems.PICKAX.get());
				tabData.accept(PurechaosModItems.FOOD_ITEM_2.get());
				tabData.accept(PurechaosModBlocks.SA_DS.get().asItem());
				tabData.accept(PurechaosModItems.FOOD_ITEM_3.get());
				tabData.accept(PurechaosModItems.POTATO_SPUDS.get());
				tabData.accept(PurechaosModItems.SPEAR.get());
				tabData.accept(PurechaosModItems.DIPEX.get());
				tabData.accept(PurechaosModBlocks.DEATH.get().asItem());
				tabData.accept(PurechaosModItems.TRIDENT_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.COMICALLY_LARGE_SPOON.get());
				tabData.accept(PurechaosModItems.NETHERIT_PICKAX.get());
				tabData.accept(PurechaosModItems.WOOD_DIMENSION.get());
				tabData.accept(PurechaosModBlocks.SUS_BLOCK.get().asItem());
				tabData.accept(PurechaosModItems.AMONG_US_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.CUM_BUCKET.get());
				tabData.accept(PurechaosModItems.SUS.get());
				tabData.accept(PurechaosModItems.AMOGUS_2_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.AMOGUS_3_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.STARAVODA_BUCKET.get());
				tabData.accept(PurechaosModBlocks.TLGHD.get().asItem());
				tabData.accept(PurechaosModItems.AMUGUS_HELMET.get());
				tabData.accept(PurechaosModItems.AMUGUS_CHESTPLATE.get());
				tabData.accept(PurechaosModItems.AMUGUS_LEGGINGS.get());
				tabData.accept(PurechaosModItems.AMUGUS_BOOTS.get());
				tabData.accept(PurechaosModItems.SUS_SWORD.get());
				tabData.accept(PurechaosModItems.ORANGE_FLUID_BUCKET.get());
				tabData.accept(PurechaosModItems.OIL_BUCKET.get());
				tabData.accept(PurechaosModItems.GATORADE_BUCKET.get());
				tabData.accept(PurechaosModBlocks.GREEN_PLANT.get().asItem());
				tabData.accept(PurechaosModItems.SPLANK_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.FALLGAYS.get());
				tabData.accept(PurechaosModItems.IKEA_DESK_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.SASI_AMANGAS.get());
				tabData.accept(PurechaosModItems.JOSIP_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.BROWN.get());
				tabData.accept(PurechaosModItems.CARBON_MONOXIDE_BUCKET.get());
				tabData.accept(PurechaosModItems.JOSIPDVATOCKANULA_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.BEEF_ARMOR_HELMET.get());
				tabData.accept(PurechaosModItems.BEEF_ARMOR_CHESTPLATE.get());
				tabData.accept(PurechaosModItems.BEEF_ARMOR_LEGGINGS.get());
				tabData.accept(PurechaosModItems.BEEF_ARMOR_BOOTS.get());
				tabData.accept(PurechaosModItems.CORRUPTSTAFF.get());
				tabData.accept(PurechaosModItems.JOSIP_PET_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.TURTLE_ARMOR_CHESTPLATE.get());
				tabData.accept(PurechaosModItems.TURTLE_ARMOR_LEGGINGS.get());
				tabData.accept(PurechaosModItems.TURTLE_ARMOR_BOOTS.get());
				tabData.accept(PurechaosModItems.JOSIP_PETT_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.MOTH_OF_AGGREVATION_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.CURSED_DOG_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.BLAZ_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.SHEP_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.BULLET.get());
				tabData.accept(PurechaosModItems.VIKKIVUK_SPAWN_EGG.get());
				tabData.accept(PurechaosModBlocks.YOUTUBE.get().asItem());
				tabData.accept(PurechaosModBlocks.PLANTE.get().asItem());
				tabData.accept(PurechaosModItems.DREAM_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.MILK_2_BUCKET.get());
				tabData.accept(PurechaosModItems.USE_IN_EMERGENCIES.get());
				tabData.accept(PurechaosModItems.SCRATEST.get());
				tabData.accept(PurechaosModItems.ADOLF_HITLER_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.TESTICLE_ON_STICK.get());
				tabData.accept(PurechaosModBlocks.RICKROLL_BLOCK.get().asItem());
				tabData.accept(PurechaosModItems.METH.get());
				tabData.accept(PurechaosModItems.WALTER_WIGHT_SPAWN_EGG.get());
				tabData.accept(PurechaosModBlocks.GRAVE.get().asItem());
				tabData.accept(PurechaosModItems.COD_BUT_BETTER_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.SSSR.get());
				tabData.accept(PurechaosModItems.STALIN_SPAWN_EGG.get());
				tabData.accept(PurechaosModBlocks.SOUTH.get().asItem());
				tabData.accept(PurechaosModBlocks.COMUNISAM_BLOCK.get().asItem());
				tabData.accept(PurechaosModItems.TO.get());
				tabData.accept(PurechaosModBlocks.POLAND_BLOCK.get().asItem());
				tabData.accept(PurechaosModItems.FASTTOPASS.get());
				tabData.accept(PurechaosModBlocks.NOKIA_BLOCK.get().asItem());
				tabData.accept(PurechaosModItems.IGLA.get());
				tabData.accept(PurechaosModItems.CIOAO.get());
				tabData.accept(PurechaosModItems.RADIATION_LIQUID_BUCKET.get());
				tabData.accept(PurechaosModItems.RICK_ASTLEY_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.FORTNITE_A_1.get());
				tabData.accept(PurechaosModItems.BLEACH.get());
				tabData.accept(PurechaosModBlocks.GREENGISCREENDA.get().asItem());
				tabData.accept(PurechaosModBlocks.BRAZIL_BLOCK.get().asItem());
				tabData.accept(PurechaosModItems.BRAZIL.get());
				tabData.accept(PurechaosModItems.LEGS_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.LONG_LEG_CHICKEN_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.FIREFLY_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.ALMOND_WATER.get());
				tabData.accept(PurechaosModItems.SAMSUNG_NOTE_7.get());
				tabData.accept(PurechaosModBlocks.DEPRESSION_BLOCK.get().asItem());
				tabData.accept(PurechaosModItems.TOTEM_OF_AMOGUS.get());
				tabData.accept(PurechaosModItems.ZENITH.get());
				tabData.accept(PurechaosModItems.T_POSE_ENTITY_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.IMPOSTOR_KNIFE.get());
				tabData.accept(PurechaosModBlocks.CYBER_BLOCK.get().asItem());
				tabData.accept(PurechaosModBlocks.COMPUTER.get().asItem());
				tabData.accept(PurechaosModItems.TOTEM_OF_DREAM.get());
				tabData.accept(PurechaosModItems.STROATER_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.HALF_GOLDEN_APPLE.get());
				tabData.accept(PurechaosModItems.BEEF.get());
				tabData.accept(PurechaosModItems.BAGUETTE.get());
				tabData.accept(PurechaosModItems.OBAMIUM.get());
				tabData.accept(PurechaosModItems.COBBLE_FLUID_BUCKET.get());
				tabData.accept(PurechaosModItems.AMOGUS_3_BLU_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.AMOGUS_3_GRIN_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.LAVA_BOTTLE.get());
				tabData.accept(PurechaosModItems.BEENGOT.get());
				tabData.accept(PurechaosModItems.SPONGEBOB_BOSS_SPAWN_EGG.get());
				tabData.accept(PurechaosModBlocks.ADIDAS_BLOCK.get().asItem());
				tabData.accept(PurechaosModItems.ADIDAS_ARMOR_HELMET.get());
				tabData.accept(PurechaosModItems.ADIDAS_ARMOR_CHESTPLATE.get());
				tabData.accept(PurechaosModItems.ADIDAS_ARMOR_LEGGINGS.get());
				tabData.accept(PurechaosModItems.ADIDAS_ARMOR_BOOTS.get());
				tabData.accept(PurechaosModItems.THE_ROCK_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.XSORD.get());
				tabData.accept(PurechaosModBlocks.MISSING_TEXTURE.get().asItem());
				tabData.accept(PurechaosModItems.XITE.get());
				tabData.accept(PurechaosModItems.EATABLE_COMMAND_BLOCK.get());
				tabData.accept(PurechaosModItems.KENTUCKY_FRIED_CHICKEN.get());
				tabData.accept(PurechaosModItems.KENTUCKY_FRIED_CHICKEN_FRIES.get());
				tabData.accept(PurechaosModItems.BOTTLE_OF_PISS.get());
				tabData.accept(PurechaosModItems.TINTED_GLASS_BOTTLE.get());
				tabData.accept(PurechaosModItems.DORITO_NACHO.get());
				tabData.accept(PurechaosModItems.IRON_EGG.get());
				tabData.accept(PurechaosModItems.DORITO_COOL_RANCH.get());
				tabData.accept(PurechaosModItems.AETHER.get());
				tabData.accept(PurechaosModItems.BIG_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.SPIT_BALL.get());
				tabData.accept(PurechaosModItems.GLOW.get());
				tabData.accept(PurechaosModItems.MERCURY.get());
				tabData.accept(PurechaosModBlocks.JEB_BLOCK.get().asItem());
				tabData.accept(PurechaosModItems.FRYING_PAN.get());
				tabData.accept(PurechaosModItems.APPLE_INGOT.get());
				tabData.accept(PurechaosModItems.TECHNOBLADE_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.CUPCAKKE_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.DINGOT.get());
				tabData.accept(PurechaosModItems.POOP.get());
				tabData.accept(PurechaosModItems.BALDI_MINUS_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.HEROBRINE_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.COMMUNISM_ORB.get());
				tabData.accept(PurechaosModItems.COCA_COLA.get());
				tabData.accept(PurechaosModItems.NERD_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.SUSSY_SUS_STEW.get());
				tabData.accept(PurechaosModItems.IRS_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.FBI_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.AMERICAN_SOLDAT_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.MURICA_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.GRIMACE_SHAKE.get());
				tabData.accept(PurechaosModItems.DEEK.get());
				tabData.accept(PurechaosModItems.WATER_CUP.get());
				tabData.accept(PurechaosModItems.JOSIP_RANGE.get());
				tabData.accept(PurechaosModItems.AK_47.get());
				tabData.accept(PurechaosModItems.AMOGUS_GUN.get());
				tabData.accept(PurechaosModItems.ROCK.get());
				tabData.accept(PurechaosModItems.JAVELIN_LAUNCHER.get());
				tabData.accept(PurechaosModItems.PENSIVE_CUBE_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.PUFFER_BALLOON.get());
				tabData.accept(PurechaosModItems.INFINITE_FUEL.get());
				tabData.accept(PurechaosModItems.GROGGO_SPAWN_EGG.get());
				tabData.accept(PurechaosModItems.BRAKE_FLUID.get());
				tabData.accept(PurechaosModItems.MELATONIN_PILL.get());
			}).withSearchBar().build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(PurechaosModItems.ADIDAS_SWORD.get());
			tabData.accept(PurechaosModItems.KONDOMNEPITAJZASTOOVORADIMALISPOILERALERTONIMARUPU.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(PurechaosModItems.KFCE.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(PurechaosModBlocks.POTATUS.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(PurechaosModItems.ADIDAS_PICKAXE.get());
			tabData.accept(PurechaosModItems.ADIDAS_AXE.get());
			tabData.accept(PurechaosModItems.ADIDAS_SHOVEL.get());
			tabData.accept(PurechaosModItems.ADIDAS_HOE.get());
		}
	}
}
