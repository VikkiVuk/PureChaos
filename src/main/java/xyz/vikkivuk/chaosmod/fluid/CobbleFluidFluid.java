
package xyz.vikkivuk.chaosmod.fluid;

public abstract class CobbleFluidFluid extends ForgeFlowingFluid {

	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(ChaosmodModFluids.COBBLE_FLUID,
			ChaosmodModFluids.FLOWING_COBBLE_FLUID,
			FluidAttributes.builder(new ResourceLocation("chaosmod:blocks/cobblestone"), new ResourceLocation("chaosmod:blocks/cobblestone"))

	).explosionResistance(100f)

			.bucket(ChaosmodModItems.COBBLE_FLUID_BUCKET).block(() -> (LiquidBlock) ChaosmodModBlocks.COBBLE_FLUID.get());

	private CobbleFluidFluid() {
		super(PROPERTIES);
	}

	public static class Source extends CobbleFluidFluid {
		public Source() {
			super();
		}

		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends CobbleFluidFluid {
		public Flowing() {
			super();
		}

		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}

}
