
package xyz.vikkivuk.chaosmod.world.features.ores;

import xyz.vikkivuk.chaosmod.init.ChaosmodModBlocks;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTestType;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.core.Registry;
import net.minecraft.core.Holder;

import java.util.Set;
import java.util.Random;
import java.util.List;

public class JebBlockFeature extends OreFeature {
	public static JebBlockFeature FEATURE = null;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new JebBlockFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("chaosmod:jeb_block", FEATURE,
				new OreConfiguration(JebBlockFeatureRuleTest.INSTANCE, ChaosmodModBlocks.JEB_BLOCK.get().defaultBlockState(), 16));
		PLACED_FEATURE = PlacementUtils.register("chaosmod:jeb_block", CONFIGURED_FEATURE, List.of(CountPlacement.of(10), InSquarePlacement.spread(),
				HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(64)), BiomeFilter.biome()));
		return FEATURE;
	}

	public static Holder<PlacedFeature> placedFeature() {
		return PLACED_FEATURE;
	}

	public static final Set<ResourceLocation> GENERATE_BIOMES = null;
	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD, Level.NETHER, Level.END,
			ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("chaosmod:peemension")),
			ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("chaosmod:wood_dimension")),
			ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("chaosmod:sus")),
			ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("chaosmod:brazil")),
			ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("chaosmod:cyberspace")),
			ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("chaosmod:cioao")),
			ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("chaosmod:aether")));

	public JebBlockFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;
		return super.place(context);
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	private static class JebBlockFeatureRuleTest extends RuleTest {
		static final JebBlockFeatureRuleTest INSTANCE = new JebBlockFeatureRuleTest();
		private static final com.mojang.serialization.Codec<JebBlockFeatureRuleTest> CODEC = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		private static final RuleTestType<JebBlockFeatureRuleTest> CUSTOM_MATCH = () -> CODEC;

		@SubscribeEvent
		public static void init(FMLCommonSetupEvent event) {
			Registry.register(Registry.RULE_TEST, new ResourceLocation("chaosmod:jeb_block_match"), CUSTOM_MATCH);
		}

		private List<Block> base_blocks = null;

		public boolean test(BlockState blockAt, Random random) {
			if (base_blocks == null) {
				base_blocks = List.of(Blocks.STONE, ChaosmodModBlocks.PEE.get(), ChaosmodModBlocks.PEE_BLOCK.get(), ChaosmodModBlocks.POTATUS.get(),
						ChaosmodModBlocks.DEATH.get(), ChaosmodModBlocks.SA_DS.get(), ChaosmodModBlocks.EMEPEE.get(),
						ChaosmodModBlocks.SUS_BLOCK.get(), ChaosmodModBlocks.CUM.get(), ChaosmodModBlocks.STARAVODA.get(),
						ChaosmodModBlocks.TLGHD.get(), ChaosmodModBlocks.ORANGE_FLUID.get(), ChaosmodModBlocks.OIL.get(),
						ChaosmodModBlocks.GATORADE.get(), ChaosmodModBlocks.GREEN_PLANT.get(), ChaosmodModBlocks.TOMBSTONE.get(),
						ChaosmodModBlocks.CARBON_MONOXIDE.get(), ChaosmodModBlocks.YOUTUBE.get(), ChaosmodModBlocks.PLANTE.get(),
						ChaosmodModBlocks.RICKROLL_BLOCK.get(), ChaosmodModBlocks.GRAVE.get(), ChaosmodModBlocks.MILK_2.get(),
						ChaosmodModBlocks.BACKROOMS_LVL_1LIGHT.get(), ChaosmodModBlocks.BACKROOMS_LVL_1_WALL.get(),
						ChaosmodModBlocks.RADIATION_LIQUID.get(), ChaosmodModBlocks.BRAZIL_BLOCK.get(), ChaosmodModBlocks.NOKIA_BLOCK.get(),
						ChaosmodModBlocks.BACKROOMS_LVL_1_FLOOR.get(), ChaosmodModBlocks.SOUTH.get(), ChaosmodModBlocks.DEPRESSION_BLOCK.get(),
						ChaosmodModBlocks.COMUNISAM_BLOCK.get(), ChaosmodModBlocks.POLAND_BLOCK.get(), ChaosmodModBlocks.CYBER_BLOCK.get(),
						ChaosmodModBlocks.COMPUTER.get(), ChaosmodModBlocks.GREENGISCREENDA.get(), ChaosmodModBlocks.COBBLE_FLUID.get(),
						ChaosmodModBlocks.ADIDAS_BLOCK.get(), ChaosmodModBlocks.MISSING_TEXTURE.get(), Blocks.AIR, Blocks.VOID_AIR, Blocks.CAVE_AIR,
						Blocks.STONE, Blocks.STONE_STAIRS, Blocks.STONE_SLAB, Blocks.GRANITE, Blocks.POLISHED_GRANITE, Blocks.GRANITE_STAIRS,
						Blocks.POLISHED_GRANITE_STAIRS, Blocks.GRANITE_SLAB, Blocks.POLISHED_GRANITE_SLAB, Blocks.GRANITE_WALL, Blocks.DIORITE,
						Blocks.DIORITE_STAIRS, Blocks.DIORITE_SLAB, Blocks.DIORITE_WALL, Blocks.POLISHED_DIORITE, Blocks.POLISHED_DIORITE_SLAB,
						Blocks.POLISHED_DIORITE_STAIRS, Blocks.ANDESITE, Blocks.ANDESITE_STAIRS, Blocks.ANDESITE_SLAB, Blocks.ANDESITE_WALL,
						Blocks.POLISHED_ANDESITE, Blocks.POLISHED_ANDESITE_STAIRS, Blocks.POLISHED_ANDESITE_SLAB, Blocks.SMOOTH_STONE,
						Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE, Blocks.COBBLED_DEEPSLATE_STAIRS, Blocks.COBBLED_DEEPSLATE_SLAB,
						Blocks.COBBLED_DEEPSLATE_WALL, Blocks.POLISHED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE_STAIRS, Blocks.POLISHED_DEEPSLATE_SLAB,
						Blocks.POLISHED_DEEPSLATE_WALL, Blocks.DEEPSLATE_TILES, Blocks.DEEPSLATE_TILE_STAIRS, Blocks.DEEPSLATE_TILE_SLAB,
						Blocks.DEEPSLATE_TILE_WALL, Blocks.DEEPSLATE_BRICKS, Blocks.DEEPSLATE_BRICK_STAIRS, Blocks.DEEPSLATE_BRICK_SLAB,
						Blocks.DEEPSLATE_BRICK_WALL, Blocks.CHISELED_DEEPSLATE, Blocks.CRACKED_DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_TILES,
						Blocks.TUFF, Blocks.CALCITE, Blocks.DRIPSTONE_BLOCK, Blocks.POINTED_DRIPSTONE, Blocks.GRASS_BLOCK, Blocks.DIRT_PATH,
						Blocks.MYCELIUM, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL, Blocks.ROOTED_DIRT, Blocks.COBBLESTONE,
						Blocks.MOSSY_COBBLESTONE, Blocks.MOSSY_COBBLESTONE_STAIRS, Blocks.MOSSY_COBBLESTONE_SLAB, Blocks.MOSS_BLOCK,
						Blocks.MOSS_CARPET, Blocks.OAK_PLANKS, Blocks.SPRUCE_PLANKS, Blocks.BIRCH_PLANKS, Blocks.JUNGLE_PLANKS, Blocks.ACACIA_PLANKS,
						Blocks.DARK_OAK_PLANKS, Blocks.CRIMSON_PLANKS, Blocks.WARPED_PLANKS, Blocks.OAK_SAPLING, Blocks.SPRUCE_SAPLING,
						Blocks.BIRCH_SAPLING, Blocks.JUNGLE_SAPLING, Blocks.ACACIA_SAPLING, Blocks.DARK_OAK_SAPLING, Blocks.SUGAR_CANE,
						Blocks.BEDROCK, Blocks.SAND, Blocks.RED_SAND, Blocks.GRAVEL, Blocks.WATER, Blocks.WATER, Blocks.BUBBLE_COLUMN, Blocks.LAVA,
						Blocks.LAVA, Blocks.MAGMA_BLOCK, Blocks.OBSIDIAN, Blocks.CRYING_OBSIDIAN, Blocks.BLACKSTONE, Blocks.BLACKSTONE_STAIRS,
						Blocks.BLACKSTONE_WALL, Blocks.BLACKSTONE_SLAB, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS,
						Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, Blocks.CHISELED_POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICK_SLAB,
						Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS, Blocks.POLISHED_BLACKSTONE_BRICK_WALL, Blocks.POLISHED_BLACKSTONE_STAIRS,
						Blocks.POLISHED_BLACKSTONE_SLAB, Blocks.POLISHED_BLACKSTONE_WALL, Blocks.COAL_ORE, Blocks.IRON_ORE, Blocks.REDSTONE_ORE,
						Blocks.REDSTONE_ORE, Blocks.GOLD_ORE, Blocks.LAPIS_ORE, Blocks.DIAMOND_ORE, Blocks.EMERALD_ORE, Blocks.COPPER_ORE,
						Blocks.DEEPSLATE_COAL_ORE, Blocks.DEEPSLATE_IRON_ORE, Blocks.DEEPSLATE_REDSTONE_ORE, Blocks.DEEPSLATE_GOLD_ORE,
						Blocks.DEEPSLATE_LAPIS_ORE, Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.DEEPSLATE_EMERALD_ORE, Blocks.DEEPSLATE_COPPER_ORE,
						Blocks.NETHER_QUARTZ_ORE, Blocks.NETHER_GOLD_ORE, Blocks.GILDED_BLACKSTONE, Blocks.RAW_IRON_BLOCK, Blocks.RAW_GOLD_BLOCK,
						Blocks.RAW_COPPER_BLOCK, Blocks.COAL_BLOCK, Blocks.IRON_BLOCK, Blocks.COPPER_BLOCK, Blocks.EXPOSED_COPPER,
						Blocks.WEATHERED_COPPER, Blocks.OXIDIZED_COPPER, Blocks.CUT_COPPER, Blocks.EXPOSED_CUT_COPPER, Blocks.WEATHERED_CUT_COPPER,
						Blocks.OXIDIZED_CUT_COPPER, Blocks.CUT_COPPER_STAIRS, Blocks.EXPOSED_CUT_COPPER_STAIRS, Blocks.WEATHERED_CUT_COPPER_STAIRS,
						Blocks.OXIDIZED_CUT_COPPER_STAIRS, Blocks.CUT_COPPER_SLAB, Blocks.EXPOSED_CUT_COPPER_SLAB, Blocks.WEATHERED_CUT_COPPER_SLAB,
						Blocks.OXIDIZED_CUT_COPPER_SLAB, Blocks.WAXED_COPPER_BLOCK, Blocks.WAXED_EXPOSED_COPPER, Blocks.WAXED_WEATHERED_COPPER,
						Blocks.WAXED_OXIDIZED_COPPER, Blocks.WAXED_CUT_COPPER, Blocks.WAXED_EXPOSED_CUT_COPPER, Blocks.WAXED_WEATHERED_CUT_COPPER,
						Blocks.WAXED_OXIDIZED_CUT_COPPER, Blocks.WAXED_CUT_COPPER_STAIRS, Blocks.WAXED_EXPOSED_CUT_COPPER_STAIRS,
						Blocks.WAXED_WEATHERED_CUT_COPPER_STAIRS, Blocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS, Blocks.WAXED_CUT_COPPER_SLAB,
						Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB, Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB, Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB,
						Blocks.REDSTONE_BLOCK, Blocks.GOLD_BLOCK, Blocks.LAPIS_BLOCK, Blocks.DIAMOND_BLOCK, Blocks.EMERALD_BLOCK,
						Blocks.NETHERITE_BLOCK, Blocks.SMOOTH_QUARTZ, Blocks.CHISELED_QUARTZ_BLOCK, Blocks.QUARTZ_PILLAR, Blocks.QUARTZ_BLOCK,
						Blocks.QUARTZ_BRICKS, Blocks.SMOOTH_QUARTZ_STAIRS, Blocks.SMOOTH_QUARTZ_SLAB, Blocks.SLIME_BLOCK, Blocks.ANCIENT_DEBRIS,
						Blocks.AMETHYST_BLOCK, Blocks.BUDDING_AMETHYST, Blocks.AMETHYST_CLUSTER, Blocks.LARGE_AMETHYST_BUD,
						Blocks.MEDIUM_AMETHYST_BUD, Blocks.SMALL_AMETHYST_BUD, Blocks.OAK_LOG, Blocks.OAK_LOG, Blocks.SPRUCE_LOG, Blocks.BIRCH_LOG,
						Blocks.JUNGLE_LOG, Blocks.ACACIA_LOG, Blocks.ACACIA_LOG, Blocks.DARK_OAK_LOG, Blocks.WARPED_STEM, Blocks.CRIMSON_STEM,
						Blocks.STRIPPED_OAK_LOG, Blocks.STRIPPED_SPRUCE_LOG, Blocks.STRIPPED_BIRCH_LOG, Blocks.STRIPPED_JUNGLE_LOG,
						Blocks.STRIPPED_ACACIA_LOG, Blocks.STRIPPED_DARK_OAK_LOG, Blocks.STRIPPED_WARPED_STEM, Blocks.STRIPPED_CRIMSON_STEM,
						Blocks.OAK_WOOD, Blocks.SPRUCE_WOOD, Blocks.BIRCH_WOOD, Blocks.JUNGLE_WOOD, Blocks.ACACIA_WOOD, Blocks.DARK_OAK_WOOD,
						Blocks.WARPED_HYPHAE, Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_OAK_WOOD, Blocks.STRIPPED_SPRUCE_WOOD,
						Blocks.STRIPPED_BIRCH_WOOD, Blocks.STRIPPED_JUNGLE_WOOD, Blocks.STRIPPED_ACACIA_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD,
						Blocks.STRIPPED_WARPED_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE, Blocks.OAK_LEAVES, Blocks.OAK_LEAVES, Blocks.SPRUCE_LEAVES,
						Blocks.BIRCH_LEAVES, Blocks.JUNGLE_LEAVES, Blocks.ACACIA_LEAVES, Blocks.ACACIA_LEAVES, Blocks.DARK_OAK_LEAVES,
						Blocks.AZALEA_LEAVES, Blocks.FLOWERING_AZALEA_LEAVES, Blocks.SPONGE, Blocks.WET_SPONGE, Blocks.SANDSTONE,
						Blocks.CHISELED_SANDSTONE, Blocks.CUT_SANDSTONE, Blocks.SANDSTONE_STAIRS, Blocks.SMOOTH_SANDSTONE,
						Blocks.SMOOTH_SANDSTONE_STAIRS, Blocks.SMOOTH_SANDSTONE_SLAB, Blocks.CUT_SANDSTONE_SLAB, Blocks.SANDSTONE_WALL,
						Blocks.RED_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE, Blocks.CUT_RED_SANDSTONE, Blocks.RED_SANDSTONE_STAIRS,
						Blocks.SMOOTH_RED_SANDSTONE, Blocks.SMOOTH_RED_SANDSTONE_STAIRS, Blocks.SMOOTH_RED_SANDSTONE_SLAB,
						Blocks.CUT_RED_SANDSTONE_SLAB, Blocks.RED_SANDSTONE_WALL, Blocks.NOTE_BLOCK, Blocks.RAIL, Blocks.POWERED_RAIL,
						Blocks.DETECTOR_RAIL, Blocks.ACTIVATOR_RAIL, Blocks.WHITE_BED, Blocks.ORANGE_BED, Blocks.MAGENTA_BED, Blocks.LIGHT_BLUE_BED,
						Blocks.YELLOW_BED, Blocks.LIME_BED, Blocks.PINK_BED, Blocks.GRAY_BED, Blocks.LIGHT_GRAY_BED, Blocks.CYAN_BED,
						Blocks.PURPLE_BED, Blocks.BLUE_BED, Blocks.BROWN_BED, Blocks.GREEN_BED, Blocks.RED_BED, Blocks.BLACK_BED, Blocks.COBWEB,
						Blocks.DEAD_BUSH, Blocks.GRASS, Blocks.DEAD_BUSH, Blocks.GRASS, Blocks.FERN, Blocks.PISTON, Blocks.STICKY_PISTON,
						Blocks.PISTON_HEAD, Blocks.MOVING_PISTON, Blocks.DANDELION, Blocks.POPPY, Blocks.BLUE_ORCHID, Blocks.ALLIUM,
						Blocks.AZURE_BLUET, Blocks.RED_TULIP, Blocks.ORANGE_TULIP, Blocks.WHITE_TULIP, Blocks.PINK_TULIP, Blocks.OXEYE_DAISY,
						Blocks.CORNFLOWER, Blocks.LILY_OF_THE_VALLEY, Blocks.WITHER_ROSE, Blocks.SUNFLOWER, Blocks.LILAC, Blocks.TALL_GRASS,
						Blocks.LARGE_FERN, Blocks.ROSE_BUSH, Blocks.PEONY, Blocks.BROWN_MUSHROOM, Blocks.RED_MUSHROOM, Blocks.WARPED_FUNGUS,
						Blocks.CRIMSON_FUNGUS, Blocks.BROWN_MUSHROOM_BLOCK, Blocks.RED_MUSHROOM_BLOCK, Blocks.WARPED_WART_BLOCK, Blocks.MUSHROOM_STEM,
						Blocks.BRICKS, Blocks.BRICK_WALL, Blocks.TNT, Blocks.BOOKSHELF, Blocks.TORCH, Blocks.WALL_TORCH, Blocks.SOUL_TORCH,
						Blocks.SOUL_WALL_TORCH, Blocks.FIRE, Blocks.SOUL_FIRE, Blocks.LANTERN, Blocks.SOUL_LANTERN, Blocks.CHAIN, Blocks.CAMPFIRE,
						Blocks.SOUL_CAMPFIRE, Blocks.CANDLE, Blocks.WHITE_CANDLE, Blocks.ORANGE_CANDLE, Blocks.MAGENTA_CANDLE,
						Blocks.LIGHT_BLUE_CANDLE, Blocks.YELLOW_CANDLE, Blocks.LIME_CANDLE, Blocks.PINK_CANDLE, Blocks.GRAY_CANDLE,
						Blocks.LIGHT_GRAY_CANDLE, Blocks.CYAN_CANDLE, Blocks.PURPLE_CANDLE, Blocks.BLUE_CANDLE, Blocks.BROWN_CANDLE,
						Blocks.GREEN_CANDLE, Blocks.RED_CANDLE, Blocks.BLACK_CANDLE, Blocks.LIGHT, Blocks.SPAWNER, Blocks.OAK_STAIRS,
						Blocks.SPRUCE_STAIRS, Blocks.BIRCH_STAIRS, Blocks.JUNGLE_STAIRS, Blocks.ACACIA_STAIRS, Blocks.DARK_OAK_STAIRS,
						Blocks.CRIMSON_STAIRS, Blocks.WARPED_STAIRS, Blocks.COBBLESTONE_STAIRS, Blocks.BRICK_STAIRS, Blocks.STONE_BRICK_STAIRS,
						Blocks.NETHER_BRICK_STAIRS, Blocks.QUARTZ_STAIRS, Blocks.PURPUR_STAIRS, Blocks.CHEST, Blocks.TRAPPED_CHEST,
						Blocks.ENDER_CHEST, Blocks.CRAFTING_TABLE, Blocks.WHEAT, Blocks.FARMLAND, Blocks.FURNACE, Blocks.OAK_SIGN, Blocks.SPRUCE_SIGN,
						Blocks.BIRCH_SIGN, Blocks.ACACIA_SIGN, Blocks.JUNGLE_SIGN, Blocks.DARK_OAK_SIGN, Blocks.CRIMSON_SIGN, Blocks.WARPED_SIGN,
						Blocks.OAK_WALL_SIGN, Blocks.SPRUCE_WALL_SIGN, Blocks.BIRCH_WALL_SIGN, Blocks.ACACIA_WALL_SIGN, Blocks.JUNGLE_WALL_SIGN,
						Blocks.DARK_OAK_WALL_SIGN, Blocks.CRIMSON_WALL_SIGN, Blocks.WARPED_WALL_SIGN, Blocks.OAK_DOOR, Blocks.SPRUCE_DOOR,
						Blocks.BIRCH_DOOR, Blocks.JUNGLE_DOOR, Blocks.ACACIA_DOOR, Blocks.DARK_OAK_DOOR, Blocks.CRIMSON_DOOR, Blocks.WARPED_DOOR,
						Blocks.IRON_DOOR, Blocks.OAK_TRAPDOOR, Blocks.SPRUCE_TRAPDOOR, Blocks.BIRCH_TRAPDOOR, Blocks.JUNGLE_TRAPDOOR,
						Blocks.ACACIA_TRAPDOOR, Blocks.DARK_OAK_TRAPDOOR, Blocks.CRIMSON_TRAPDOOR, Blocks.WARPED_TRAPDOOR, Blocks.IRON_TRAPDOOR,
						Blocks.LADDER, Blocks.LEVER, Blocks.STONE_BUTTON, Blocks.POLISHED_BLACKSTONE_BUTTON, Blocks.OAK_BUTTON, Blocks.SPRUCE_BUTTON,
						Blocks.BIRCH_BUTTON, Blocks.JUNGLE_BUTTON, Blocks.ACACIA_BUTTON, Blocks.DARK_OAK_BUTTON, Blocks.CRIMSON_BUTTON,
						Blocks.WARPED_BUTTON, Blocks.OAK_PRESSURE_PLATE, Blocks.SPRUCE_PRESSURE_PLATE, Blocks.BIRCH_PRESSURE_PLATE,
						Blocks.JUNGLE_PRESSURE_PLATE, Blocks.ACACIA_PRESSURE_PLATE, Blocks.DARK_OAK_PRESSURE_PLATE, Blocks.CRIMSON_PRESSURE_PLATE,
						Blocks.WARPED_PRESSURE_PLATE, Blocks.STONE_PRESSURE_PLATE, Blocks.POLISHED_BLACKSTONE_PRESSURE_PLATE,
						Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE, Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, Blocks.TRIPWIRE_HOOK, Blocks.TRIPWIRE,
						Blocks.DAYLIGHT_DETECTOR, Blocks.DAYLIGHT_DETECTOR, Blocks.REDSTONE_TORCH, Blocks.REDSTONE_WALL_TORCH, Blocks.REDSTONE_TORCH,
						Blocks.REDSTONE_WIRE, Blocks.REPEATER, Blocks.REPEATER, Blocks.COMPARATOR, Blocks.COMPARATOR, Blocks.REDSTONE_LAMP,
						Blocks.REDSTONE_LAMP, Blocks.DISPENSER, Blocks.DROPPER, Blocks.OBSERVER, Blocks.HOPPER, Blocks.TARGET, Blocks.LIGHTNING_ROD,
						Blocks.SCULK_SENSOR, Blocks.COMMAND_BLOCK, Blocks.REPEATING_COMMAND_BLOCK, Blocks.CHAIN_COMMAND_BLOCK, Blocks.SNOW,
						Blocks.SNOW_BLOCK, Blocks.POWDER_SNOW, Blocks.ICE, Blocks.PACKED_ICE, Blocks.FROSTED_ICE, Blocks.BLUE_ICE, Blocks.CACTUS,
						Blocks.CLAY, Blocks.JUKEBOX, Blocks.OAK_FENCE, Blocks.SPRUCE_FENCE, Blocks.BIRCH_FENCE, Blocks.JUNGLE_FENCE,
						Blocks.ACACIA_FENCE, Blocks.DARK_OAK_FENCE, Blocks.CRIMSON_FENCE, Blocks.WARPED_FENCE, Blocks.OAK_FENCE_GATE,
						Blocks.SPRUCE_FENCE_GATE, Blocks.BIRCH_FENCE_GATE, Blocks.JUNGLE_FENCE_GATE, Blocks.ACACIA_FENCE_GATE,
						Blocks.DARK_OAK_FENCE_GATE, Blocks.CRIMSON_FENCE_GATE, Blocks.WARPED_FENCE_GATE, Blocks.NETHER_BRICK_FENCE,
						Blocks.NETHER_BRICKS, Blocks.CHISELED_NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS,
						Blocks.NETHER_BRICK_WALL, Blocks.RED_NETHER_BRICK_STAIRS, Blocks.RED_NETHER_BRICK_SLAB, Blocks.RED_NETHER_BRICK_WALL,
						Blocks.NETHERRACK, Blocks.WARPED_NYLIUM, Blocks.CRIMSON_NYLIUM, Blocks.SOUL_SAND, Blocks.SOUL_SOIL, Blocks.GLOWSTONE,
						Blocks.SHROOMLIGHT, Blocks.BONE_BLOCK, Blocks.NETHER_WART, Blocks.NETHER_WART_BLOCK, Blocks.CAKE, Blocks.STONE_BRICKS,
						Blocks.STONE_BRICK_WALL, Blocks.MOSSY_STONE_BRICKS, Blocks.MOSSY_STONE_BRICK_STAIRS, Blocks.MOSSY_STONE_BRICK_SLAB,
						Blocks.MOSSY_STONE_BRICK_WALL, Blocks.CRACKED_STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS, Blocks.IRON_BARS, Blocks.MELON,
						Blocks.MELON_STEM, Blocks.ATTACHED_MELON_STEM, Blocks.PUMPKIN, Blocks.CARVED_PUMPKIN, Blocks.JACK_O_LANTERN,
						Blocks.PUMPKIN_STEM, Blocks.ATTACHED_PUMPKIN_STEM, Blocks.SWEET_BERRY_BUSH, Blocks.VINE, Blocks.GLOW_LICHEN, Blocks.LILY_PAD,
						Blocks.ENCHANTING_TABLE, Blocks.BREWING_STAND, Blocks.CAULDRON, Blocks.WATER_CAULDRON, Blocks.LAVA_CAULDRON,
						Blocks.POWDER_SNOW_CAULDRON, Blocks.END_PORTAL, Blocks.END_PORTAL_FRAME, Blocks.END_GATEWAY, Blocks.END_STONE,
						Blocks.END_STONE_BRICKS, Blocks.END_STONE_BRICK_STAIRS, Blocks.END_STONE_BRICK_SLAB, Blocks.END_STONE_BRICK_WALL,
						Blocks.END_ROD, Blocks.PURPUR_BLOCK, Blocks.PURPUR_PILLAR, Blocks.PURPUR_SLAB, Blocks.PURPUR_SLAB, Blocks.BEETROOTS,
						Blocks.CHORUS_PLANT, Blocks.CHORUS_FLOWER, Blocks.DRAGON_EGG, Blocks.INFESTED_STONE, Blocks.INFESTED_COBBLESTONE,
						Blocks.INFESTED_STONE_BRICKS, Blocks.INFESTED_MOSSY_STONE_BRICKS, Blocks.INFESTED_CRACKED_STONE_BRICKS,
						Blocks.INFESTED_CHISELED_STONE_BRICKS, Blocks.INFESTED_DEEPSLATE, Blocks.OAK_SLAB, Blocks.SPRUCE_SLAB, Blocks.BIRCH_SLAB,
						Blocks.JUNGLE_SLAB, Blocks.ACACIA_SLAB, Blocks.DARK_OAK_SLAB, Blocks.CRIMSON_SLAB, Blocks.WARPED_SLAB,
						Blocks.SMOOTH_STONE_SLAB, Blocks.SANDSTONE_SLAB, Blocks.PETRIFIED_OAK_SLAB, Blocks.COBBLESTONE_SLAB, Blocks.BRICK_SLAB,
						Blocks.STONE_BRICK_SLAB, Blocks.NETHER_BRICK_SLAB, Blocks.QUARTZ_SLAB, Blocks.RED_SANDSTONE_SLAB, Blocks.COCOA,
						Blocks.NETHER_PORTAL, Blocks.ANVIL, Blocks.CHIPPED_ANVIL, Blocks.DAMAGED_ANVIL, Blocks.BEACON, Blocks.COBBLESTONE_WALL,
						Blocks.MOSSY_COBBLESTONE_WALL, Blocks.FLOWER_POT, Blocks.POTTED_OAK_SAPLING, Blocks.POTTED_SPRUCE_SAPLING,
						Blocks.POTTED_BIRCH_SAPLING, Blocks.POTTED_JUNGLE_SAPLING, Blocks.POTTED_ACACIA_SAPLING, Blocks.POTTED_DARK_OAK_SAPLING,
						Blocks.POTTED_FERN, Blocks.POTTED_DANDELION, Blocks.POTTED_POPPY, Blocks.POTTED_BLUE_ORCHID, Blocks.POTTED_ALLIUM,
						Blocks.POTTED_AZURE_BLUET, Blocks.POTTED_RED_TULIP, Blocks.POTTED_ORANGE_TULIP, Blocks.POTTED_WHITE_TULIP,
						Blocks.POTTED_PINK_TULIP, Blocks.POTTED_OXEYE_DAISY, Blocks.POTTED_CORNFLOWER, Blocks.POTTED_LILY_OF_THE_VALLEY,
						Blocks.POTTED_WITHER_ROSE, Blocks.POTTED_RED_MUSHROOM, Blocks.POTTED_BROWN_MUSHROOM, Blocks.POTTED_DEAD_BUSH,
						Blocks.POTTED_CACTUS, Blocks.POTTED_BAMBOO, Blocks.POTTED_CRIMSON_FUNGUS, Blocks.POTTED_WARPED_FUNGUS,
						Blocks.POTTED_CRIMSON_ROOTS, Blocks.POTTED_WARPED_ROOTS, Blocks.POTTED_AZALEA, Blocks.POTTED_FLOWERING_AZALEA, Blocks.CARROTS,
						Blocks.POTATOES, Blocks.HAY_BLOCK, Blocks.SKELETON_SKULL, Blocks.WITHER_SKELETON_SKULL, Blocks.ZOMBIE_HEAD,
						Blocks.PLAYER_HEAD, Blocks.CREEPER_HEAD, Blocks.DRAGON_HEAD, Blocks.SKELETON_WALL_SKULL, Blocks.WITHER_SKELETON_WALL_SKULL,
						Blocks.ZOMBIE_WALL_HEAD, Blocks.PLAYER_WALL_HEAD, Blocks.CREEPER_WALL_HEAD, Blocks.DRAGON_WALL_HEAD, Blocks.WHITE_WOOL,
						Blocks.ORANGE_WOOL, Blocks.MAGENTA_WOOL, Blocks.LIGHT_BLUE_WOOL, Blocks.YELLOW_WOOL, Blocks.LIME_WOOL, Blocks.PINK_WOOL,
						Blocks.GRAY_WOOL, Blocks.LIGHT_GRAY_WOOL, Blocks.CYAN_WOOL, Blocks.PURPLE_WOOL, Blocks.BLUE_WOOL, Blocks.BROWN_WOOL,
						Blocks.GREEN_WOOL, Blocks.RED_WOOL, Blocks.BLACK_WOOL, Blocks.TERRACOTTA, Blocks.WHITE_TERRACOTTA, Blocks.ORANGE_TERRACOTTA,
						Blocks.MAGENTA_TERRACOTTA, Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.YELLOW_TERRACOTTA, Blocks.LIME_TERRACOTTA,
						Blocks.PINK_TERRACOTTA, Blocks.GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.CYAN_TERRACOTTA,
						Blocks.PURPLE_TERRACOTTA, Blocks.BLUE_TERRACOTTA, Blocks.BROWN_TERRACOTTA, Blocks.GREEN_TERRACOTTA, Blocks.RED_TERRACOTTA,
						Blocks.BLACK_TERRACOTTA, Blocks.WHITE_GLAZED_TERRACOTTA, Blocks.ORANGE_GLAZED_TERRACOTTA, Blocks.MAGENTA_GLAZED_TERRACOTTA,
						Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, Blocks.YELLOW_GLAZED_TERRACOTTA, Blocks.LIME_GLAZED_TERRACOTTA,
						Blocks.PINK_GLAZED_TERRACOTTA, Blocks.GRAY_GLAZED_TERRACOTTA, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA,
						Blocks.CYAN_GLAZED_TERRACOTTA, Blocks.PURPLE_GLAZED_TERRACOTTA, Blocks.BLUE_GLAZED_TERRACOTTA, Blocks.BROWN_GLAZED_TERRACOTTA,
						Blocks.GREEN_GLAZED_TERRACOTTA, Blocks.RED_GLAZED_TERRACOTTA, Blocks.BLACK_GLAZED_TERRACOTTA, Blocks.WHITE_CONCRETE_POWDER,
						Blocks.ORANGE_CONCRETE_POWDER, Blocks.MAGENTA_CONCRETE_POWDER, Blocks.LIGHT_BLUE_CONCRETE_POWDER,
						Blocks.YELLOW_CONCRETE_POWDER, Blocks.LIME_CONCRETE_POWDER, Blocks.PINK_CONCRETE_POWDER, Blocks.GRAY_CONCRETE_POWDER,
						Blocks.LIGHT_GRAY_CONCRETE_POWDER, Blocks.CYAN_CONCRETE_POWDER, Blocks.PURPLE_CONCRETE_POWDER, Blocks.BLUE_CONCRETE_POWDER,
						Blocks.BROWN_CONCRETE_POWDER, Blocks.GREEN_CONCRETE_POWDER, Blocks.RED_CONCRETE_POWDER, Blocks.BLACK_CONCRETE_POWDER,
						Blocks.WHITE_CONCRETE, Blocks.ORANGE_CONCRETE, Blocks.MAGENTA_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE, Blocks.YELLOW_CONCRETE,
						Blocks.LIME_CONCRETE, Blocks.PINK_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE, Blocks.CYAN_CONCRETE,
						Blocks.PURPLE_CONCRETE, Blocks.BLUE_CONCRETE, Blocks.BROWN_CONCRETE, Blocks.GREEN_CONCRETE, Blocks.RED_CONCRETE,
						Blocks.BLACK_CONCRETE, Blocks.WHITE_CARPET, Blocks.ORANGE_CARPET, Blocks.MAGENTA_CARPET, Blocks.LIGHT_BLUE_CARPET,
						Blocks.YELLOW_CARPET, Blocks.LIME_CARPET, Blocks.PINK_CARPET, Blocks.GRAY_CARPET, Blocks.LIGHT_GRAY_CARPET,
						Blocks.CYAN_CARPET, Blocks.PURPLE_CARPET, Blocks.BLUE_CARPET, Blocks.BROWN_CARPET, Blocks.GREEN_CARPET, Blocks.RED_CARPET,
						Blocks.BLACK_CARPET, Blocks.GLASS, Blocks.TINTED_GLASS, Blocks.WHITE_STAINED_GLASS, Blocks.ORANGE_STAINED_GLASS,
						Blocks.MAGENTA_STAINED_GLASS, Blocks.LIGHT_BLUE_STAINED_GLASS, Blocks.YELLOW_STAINED_GLASS, Blocks.LIME_STAINED_GLASS,
						Blocks.PINK_STAINED_GLASS, Blocks.GRAY_STAINED_GLASS, Blocks.LIGHT_GRAY_STAINED_GLASS, Blocks.CYAN_STAINED_GLASS,
						Blocks.PURPLE_STAINED_GLASS, Blocks.BLUE_STAINED_GLASS, Blocks.BROWN_STAINED_GLASS, Blocks.GREEN_STAINED_GLASS,
						Blocks.RED_STAINED_GLASS, Blocks.BLACK_STAINED_GLASS, Blocks.GLASS_PANE, Blocks.WHITE_STAINED_GLASS_PANE,
						Blocks.ORANGE_STAINED_GLASS_PANE, Blocks.MAGENTA_STAINED_GLASS_PANE, Blocks.LIGHT_BLUE_STAINED_GLASS_PANE,
						Blocks.YELLOW_STAINED_GLASS_PANE, Blocks.LIME_STAINED_GLASS_PANE, Blocks.PINK_STAINED_GLASS_PANE,
						Blocks.GRAY_STAINED_GLASS_PANE, Blocks.LIGHT_GRAY_STAINED_GLASS_PANE, Blocks.CYAN_STAINED_GLASS_PANE,
						Blocks.PURPLE_STAINED_GLASS_PANE, Blocks.BLUE_STAINED_GLASS_PANE, Blocks.BROWN_STAINED_GLASS_PANE,
						Blocks.GREEN_STAINED_GLASS_PANE, Blocks.RED_STAINED_GLASS_PANE, Blocks.BLACK_STAINED_GLASS_PANE, Blocks.SEA_LANTERN,
						Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS, Blocks.DARK_PRISMARINE, Blocks.PRISMARINE_STAIRS, Blocks.PRISMARINE_BRICK_STAIRS,
						Blocks.DARK_PRISMARINE_STAIRS, Blocks.PRISMARINE_SLAB, Blocks.PRISMARINE_BRICK_SLAB, Blocks.DARK_PRISMARINE_SLAB,
						Blocks.PRISMARINE_WALL, Blocks.SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX,
						Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.PINK_SHULKER_BOX,
						Blocks.GRAY_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX,
						Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.BLACK_SHULKER_BOX,
						Blocks.WHITE_BANNER, Blocks.WHITE_BANNER, Blocks.ORANGE_BANNER, Blocks.MAGENTA_BANNER, Blocks.LIGHT_BLUE_BANNER,
						Blocks.YELLOW_BANNER, Blocks.LIME_BANNER, Blocks.PINK_BANNER, Blocks.GRAY_BANNER, Blocks.LIGHT_GRAY_BANNER,
						Blocks.CYAN_BANNER, Blocks.PURPLE_BANNER, Blocks.BLUE_BANNER, Blocks.BROWN_BANNER, Blocks.GREEN_BANNER, Blocks.RED_BANNER,
						Blocks.BLACK_BANNER, Blocks.WHITE_WALL_BANNER, Blocks.WHITE_WALL_BANNER, Blocks.ORANGE_WALL_BANNER,
						Blocks.MAGENTA_WALL_BANNER, Blocks.LIGHT_BLUE_WALL_BANNER, Blocks.YELLOW_WALL_BANNER, Blocks.LIME_WALL_BANNER,
						Blocks.PINK_WALL_BANNER, Blocks.GRAY_WALL_BANNER, Blocks.LIGHT_GRAY_WALL_BANNER, Blocks.CYAN_WALL_BANNER,
						Blocks.PURPLE_WALL_BANNER, Blocks.BLUE_WALL_BANNER, Blocks.BROWN_WALL_BANNER, Blocks.GREEN_WALL_BANNER,
						Blocks.RED_WALL_BANNER, Blocks.BLACK_WALL_BANNER, Blocks.BARRIER, Blocks.STRUCTURE_VOID, Blocks.STRUCTURE_BLOCK,
						Blocks.STRUCTURE_BLOCK, Blocks.STRUCTURE_BLOCK, Blocks.STRUCTURE_BLOCK, Blocks.STRUCTURE_BLOCK, Blocks.JIGSAW, Blocks.KELP,
						Blocks.KELP_PLANT, Blocks.SEAGRASS, Blocks.TALL_SEAGRASS, Blocks.SEA_PICKLE, Blocks.TURTLE_EGG, Blocks.BAMBOO_SAPLING,
						Blocks.BAMBOO, Blocks.DEAD_TUBE_CORAL_BLOCK, Blocks.DEAD_BRAIN_CORAL_BLOCK, Blocks.DEAD_BUBBLE_CORAL_BLOCK,
						Blocks.DEAD_FIRE_CORAL_BLOCK, Blocks.DEAD_HORN_CORAL_BLOCK, Blocks.TUBE_CORAL_BLOCK, Blocks.BRAIN_CORAL_BLOCK,
						Blocks.BUBBLE_CORAL_BLOCK, Blocks.FIRE_CORAL_BLOCK, Blocks.HORN_CORAL_BLOCK, Blocks.DEAD_TUBE_CORAL, Blocks.DEAD_BRAIN_CORAL,
						Blocks.DEAD_BUBBLE_CORAL, Blocks.DEAD_FIRE_CORAL, Blocks.DEAD_HORN_CORAL, Blocks.TUBE_CORAL, Blocks.BRAIN_CORAL,
						Blocks.BUBBLE_CORAL, Blocks.FIRE_CORAL, Blocks.HORN_CORAL, Blocks.DEAD_TUBE_CORAL_FAN, Blocks.DEAD_BRAIN_CORAL_FAN,
						Blocks.DEAD_BUBBLE_CORAL_FAN, Blocks.DEAD_FIRE_CORAL_FAN, Blocks.DEAD_HORN_CORAL_FAN, Blocks.TUBE_CORAL_FAN,
						Blocks.BRAIN_CORAL_FAN, Blocks.BUBBLE_CORAL_FAN, Blocks.FIRE_CORAL_FAN, Blocks.HORN_CORAL_FAN,
						Blocks.DEAD_TUBE_CORAL_WALL_FAN, Blocks.DEAD_BRAIN_CORAL_WALL_FAN, Blocks.DEAD_BUBBLE_CORAL_WALL_FAN,
						Blocks.DEAD_FIRE_CORAL_WALL_FAN, Blocks.DEAD_HORN_CORAL_WALL_FAN, Blocks.TUBE_CORAL_WALL_FAN, Blocks.BRAIN_CORAL_WALL_FAN,
						Blocks.BUBBLE_CORAL_WALL_FAN, Blocks.FIRE_CORAL_WALL_FAN, Blocks.HORN_CORAL_WALL_FAN, Blocks.DRIED_KELP_BLOCK, Blocks.CONDUIT,
						Blocks.SCAFFOLDING, Blocks.BELL, Blocks.LOOM, Blocks.BARREL, Blocks.SMOKER, Blocks.BLAST_FURNACE, Blocks.CARTOGRAPHY_TABLE,
						Blocks.FLETCHING_TABLE, Blocks.GRINDSTONE, Blocks.LECTERN, Blocks.SMITHING_TABLE, Blocks.STONECUTTER, Blocks.COMPOSTER,
						Blocks.BEEHIVE, Blocks.BEE_NEST, Blocks.HONEY_BLOCK, Blocks.HONEYCOMB_BLOCK, Blocks.BASALT, Blocks.POLISHED_BASALT,
						Blocks.SMOOTH_BASALT, Blocks.WARPED_ROOTS, Blocks.NETHER_SPROUTS, Blocks.WEEPING_VINES, Blocks.WEEPING_VINES_PLANT,
						Blocks.TWISTING_VINES, Blocks.TWISTING_VINES_PLANT, Blocks.CRIMSON_ROOTS, Blocks.RESPAWN_ANCHOR, Blocks.LODESTONE,
						Blocks.CAVE_VINES, Blocks.CAVE_VINES_PLANT, Blocks.SPORE_BLOSSOM, Blocks.AZALEA, Blocks.FLOWERING_AZALEA, Blocks.BIG_DRIPLEAF,
						Blocks.BIG_DRIPLEAF_STEM, Blocks.SMALL_DRIPLEAF, Blocks.HANGING_ROOTS, Blocks.CANDLE_CAKE, Blocks.WHITE_CANDLE_CAKE,
						Blocks.ORANGE_CANDLE_CAKE, Blocks.MAGENTA_CANDLE_CAKE, Blocks.LIGHT_BLUE_CANDLE_CAKE, Blocks.YELLOW_CANDLE_CAKE,
						Blocks.LIME_CANDLE_CAKE, Blocks.PINK_CANDLE_CAKE, Blocks.GRAY_CANDLE_CAKE, Blocks.LIGHT_GRAY_CANDLE_CAKE,
						Blocks.CYAN_CANDLE_CAKE, Blocks.PURPLE_CANDLE_CAKE, Blocks.BLUE_CANDLE_CAKE, Blocks.BROWN_CANDLE_CAKE,
						Blocks.GREEN_CANDLE_CAKE, Blocks.RED_CANDLE_CAKE, Blocks.BLACK_CANDLE_CAKE);
			}
			return base_blocks.contains(blockAt.getBlock());
		}

		protected RuleTestType<?> getType() {
			return CUSTOM_MATCH;
		}
	}
}