
package xyz.vikkivuk.chaosmod.entity;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.material.Material;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundEvent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SpongebobBossEntity extends Monster {

	@SubscribeEvent
	public static void addLivingEntityToBiomes(BiomeLoadingEvent event) {
		event.getSpawns().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ChaosmodModEntities.SPONGEBOB_BOSS.get(), 5, 1, 2));
	}

	private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.YELLOW,
			ServerBossEvent.BossBarOverlay.PROGRESS);

	public SpongebobBossEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(ChaosmodModEntities.SPONGEBOB_BOSS.get(), world);
	}

	public SpongebobBossEntity(EntityType<SpongebobBossEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);

		this.moveControl = new FlyingMoveControl(this, 10, true);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new FlyingPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();

		this.goalSelector.addGoal(1, new Goal() {
			{
				this.setFlags(EnumSet.of(Goal.Flag.MOVE));
			}

			public boolean canUse() {
				if (SpongebobBossEntity.this.getTarget() != null && !SpongebobBossEntity.this.getMoveControl().hasWanted()) {
					return true;
				} else {
					return false;
				}
			}

			@Override
			public boolean canContinueToUse() {
				return SpongebobBossEntity.this.getMoveControl().hasWanted() && SpongebobBossEntity.this.getTarget() != null
						&& SpongebobBossEntity.this.getTarget().isAlive();
			}

			@Override
			public void start() {
				LivingEntity livingentity = SpongebobBossEntity.this.getTarget();
				Vec3 vec3d = livingentity.getEyePosition(1);
				SpongebobBossEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1);
			}

			@Override
			public void tick() {
				LivingEntity livingentity = SpongebobBossEntity.this.getTarget();
				if (SpongebobBossEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
					SpongebobBossEntity.this.doHurtTarget(livingentity);
				} else {
					double d0 = SpongebobBossEntity.this.distanceToSqr(livingentity);
					if (d0 < 16) {
						Vec3 vec3d = livingentity.getEyePosition(1);
						SpongebobBossEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1);
					}
				}
			}
		});
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.8, 20) {

			@Override
			protected Vec3 getPosition() {
				Random random = SpongebobBossEntity.this.getRandom();
				double dir_x = SpongebobBossEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_y = SpongebobBossEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_z = SpongebobBossEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
				return new Vec3(dir_x, dir_y, dir_z);
			}

		});
		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false) {

			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return (double) (4.0 + entity.getBbWidth() * entity.getBbWidth());
			}

		});
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.targetSelector.addGoal(6, new HurtByTargetGoal(this));

	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public boolean causeFallDamage(float l, float d, DamageSource source) {

		return false;
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level.isClientSide());

		super.mobInteract(sourceentity, hand);

		sourceentity.startRiding(this);

		return retval;
	}

	@Override
	public boolean canChangeDimensions() {
		return false;
	}

	@Override
	public void startSeenByPlayer(ServerPlayer player) {
		super.startSeenByPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void stopSeenByPlayer(ServerPlayer player) {
		super.stopSeenByPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	@Override
	public void customServerAiStep() {
		super.customServerAiStep();
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
	}

	@Override
	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	@Override
	public void setNoGravity(boolean ignored) {
		super.setNoGravity(true);
	}

	public void aiStep() {
		super.aiStep();

		this.setNoGravity(true);

	}

	public static void init() {
		SpawnPlacements.register(ChaosmodModEntities.SPONGEBOB_BOSS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> {
					int x = pos.getX();
					int y = pos.getY();
					int z = pos.getZ();
					return

				JosipdvatockanulaNaturalEntitySpawningConditionProcedure.execute(world);
				});

	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 1000);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);

		builder = builder.add(Attributes.FLYING_SPEED, 0.3);

		return builder;
	}

}
