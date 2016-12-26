package me._9y0.kitgui.kit.kits;

import static org.bukkit.Material.*;
import static org.bukkit.enchantments.Enchantment.*;

import java.util.Optional;

import org.bukkit.Color;
import org.bukkit.Material;

import me._9y0.kitgui.kit.Kit;
import me._9y0.kitgui.utils.ItemStackBuilder;

public class GoldKit extends Kit {

	public GoldKit(String name, Color color) {
		super(name,
				new ItemStackBuilder(Material.STONE_SWORD).withName(name).withEnchantment(DURABILITY, 10)
						.withEnchantment(DAMAGE_ALL, 2).withEnchantment(KNOCKBACK, 1).build(),
				Optional.empty(), Optional.empty(),
				new ItemStackBuilder(LEATHER_HELMET).withName(name).withColor(color).clearLore()
						.withEnchantment(DURABILITY, 10).withEnchantment(PROTECTION_FIRE, 1)
						.withEnchantment(PROTECTION_PROJECTILE, 2).withEnchantment(PROTECTION_ENVIRONMENTAL, 2).build(),
				new ItemStackBuilder(LEATHER_CHESTPLATE).withName(name).withColor(color).clearLore()
						.withEnchantment(DURABILITY, 10).withEnchantment(PROTECTION_FIRE, 1)
						.withEnchantment(PROTECTION_PROJECTILE, 2).withEnchantment(PROTECTION_ENVIRONMENTAL, 2).build(),
				new ItemStackBuilder(LEATHER_LEGGINGS).withName(name).withColor(color).clearLore()
						.withEnchantment(DURABILITY, 10).withEnchantment(PROTECTION_FIRE, 1)
						.withEnchantment(PROTECTION_PROJECTILE, 2).withEnchantment(PROTECTION_ENVIRONMENTAL, 2).build(),
				new ItemStackBuilder(LEATHER_BOOTS).withName(name).withColor(color).clearLore()
						.withEnchantment(DURABILITY, 10).withEnchantment(PROTECTION_FIRE, 1)
						.withEnchantment(PROTECTION_PROJECTILE, 2).withEnchantment(PROTECTION_ENVIRONMENTAL, 2)
						.build());
	}

}
