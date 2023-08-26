
package xyz.aflkonstukt.purechaos.item;

import xyz.aflkonstukt.purechaos.init.PurechaosModTabs;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import java.util.List;

public class KentuckyFriedChickenFriesItem extends Item {
	public KentuckyFriedChickenFriesItem() {
		super(new Item.Properties().tab(PurechaosModTabs.TAB_CHAOSTAB).stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.6f)

				.build()));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("MMMMMMMMMMMMM som frays"));
	}
}