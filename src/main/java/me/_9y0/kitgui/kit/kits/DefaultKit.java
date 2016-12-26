package me._9y0.kitgui.kit.kits;

import static org.bukkit.Material.*;
import static org.bukkit.enchantments.Enchantment.*;

import java.util.Optional;

import org.bukkit.Color;

import me._9y0.kitgui.kit.Kit;
import me._9y0.kitgui.utils.ItemStackBuilder;

public class DefaultKit extends Kit {

	public DefaultKit(String name, Color color) {
		super(name,
				new ItemStackBuilder(STONE_SWORD).withName(name).withEnchantment(DURABILITY, 10)
						.withEnchantment(DAMAGE_ALL, 1).build(),
				Optional.of(new ItemStackBuilder(BOW).withName(name).withEnchantment(DURABILITY, 10)
						.withEnchantment(ARROW_DAMAGE, 1).build()),
				Optional.of(new ItemStackBuilder(ARROW).withName(name).withAmount(32).build()),
				new ItemStackBuilder(LEATHER_HELMET).withName(name).withColor(color).clearLore()
						.withEnchantment(DURABILITY, 10).withEnchantment(PROTECTION_FIRE, 1)
						.withEnchantment(PROTECTION_PROJECTILE, 1).build(),
				new ItemStackBuilder(LEATHER_CHESTPLATE).withName(name).withColor(color).clearLore()
						.withEnchantment(DURABILITY, 10).withEnchantment(PROTECTION_FIRE, 1)
						.withEnchantment(PROTECTION_PROJECTILE, 1).build(),
				new ItemStackBuilder(LEATHER_LEGGINGS).withName(name).withColor(color).clearLore()
						.withEnchantment(DURABILITY, 10).withEnchantment(PROTECTION_FIRE, 1)
						.withEnchantment(PROTECTION_PROJECTILE, 1).build(),
				new ItemStackBuilder(LEATHER_BOOTS).withName(name).withColor(color).clearLore()
						.withEnchantment(DURABILITY, 10).withEnchantment(PROTECTION_FIRE, 1)
						.withEnchantment(PROTECTION_PROJECTILE, 1).build());
	}
}
