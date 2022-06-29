
package xyz.vikkivuk.chaosmod.world.features;

public class PeePoolFeature extends Feature<NoneFeatureConfiguration> {

	public static PeePoolFeature FEATURE = null;
	public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new PeePoolFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("chaosmod:pee_pool", FEATURE, FeatureConfiguration.NONE);
		PLACED_FEATURE = PlacementUtils.register("chaosmod:pee_pool", CONFIGURED_FEATURE, List.of());
		return FEATURE;
	}

	public static Holder<PlacedFeature> placedFeature() {
		return PLACED_FEATURE;
	}

	public static final Set<ResourceLocation> GENERATE_BIOMES = null;

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD);

	private StructureTemplate template = null;

	public PeePoolFeature() {
		super(NoneFeatureConfiguration.CODEC);

	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		if (!generate_dimensions.contains(context.level().getLevel().dimension()))
			return false;

		if (template == null)
			template = context.level().getLevel().getStructureManager().getOrCreate(new ResourceLocation("chaosmod", "peepool"));

		if (template == null)
			return false;

		boolean anyPlaced = false;
		if ((context.random().nextInt(1000000) + 1) <= 20000) {
			int count = context.random().nextInt(1) + 1;
			for (int a = 0; a < count; a++) {
				int i = context.origin().getX() + context.random().nextInt(16);
				int k = context.origin().getZ() + context.random().nextInt(16);

				int j = context.level().getHeight(Heightmap.Types.WORLD_SURFACE_WG, i, k) - 1;

				BlockPos spawnTo = new BlockPos(i + 0, j + 0, k + 0);

				if (template
						.placeInWorld(
								context.level(), spawnTo, spawnTo, new StructurePlaceSettings().setMirror(Mirror.NONE).setRotation(Rotation.NONE)
										.setRandom(context.random()).addProcessor(BlockIgnoreProcessor.AIR).setIgnoreEntities(false),
								context.random(), 2)) {

					anyPlaced = true;
				}
			}
		}

		return anyPlaced;
	}

}
