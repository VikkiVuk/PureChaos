
package xyz.vikkivuk.chaosmod.item;

import xyz.vikkivuk.chaosmod.procedures.CocaColaPlayerFinishesUsingItemProcedure;
import xyz.vikkivuk.chaosmod.init.ChaosmodModTabs;
import xyz.vikkivuk.chaosmod.init.ChaosmodModItems;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import java.util.List;

public class CocaColaItem extends Item {
	public CocaColaItem() {
		super(new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB).stacksTo(1).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(8).saturationMod(8f).alwaysEat()

				.build()));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.DRINK;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("coca cola espuma"));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = new ItemStack(ChaosmodModItems.ALMOND_WATER.get());
		super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		CocaColaPlayerFinishesUsingItemProcedure.execute(world, x, y, z);
		if (itemstack.isEmpty()) {
			return retval;
		} else {
			if (entity instanceof Player player && !player.getAbilities().instabuild) {
				if (!player.getInventory().add(retval))
					player.drop(retval, false);
			}
			return itemstack;
		}
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack itemstack, Player entity) {
		CocaColaPlayerFinishesUsingItemProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ());
		return true;
	}
}
