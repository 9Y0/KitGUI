package me._9y0.kitgui.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ItemStackBuilder {

	private final ItemStack item;

	public ItemStackBuilder(Material material) {
		this(new ItemStack(material));
	}

	public ItemStackBuilder(ItemStack item) {
		this.item = item.clone();
	}

	public ItemStackBuilder withName(String name) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatUtil.color(name));
		item.setItemMeta(meta);
		return this;
	}

	public ItemStackBuilder withLore(String... lore) {
		ItemMeta meta = item.getItemMeta();
		meta.setLore(colorLore(lore));
		item.setItemMeta(meta);
		return this;
	}

	public ItemStackBuilder addLore(String... lore) {
		ItemMeta meta = item.getItemMeta();
		List<String> loreList = meta.getLore();
		loreList.addAll(colorLore(lore));
		meta.setLore(loreList);
		item.setItemMeta(meta);
		return this;
	}

	public ItemStackBuilder clearLore() {
		ItemMeta meta = item.getItemMeta();
		meta.setLore(new ArrayList<>());
		item.setItemMeta(meta);

		return this;
	}

	public ItemStackBuilder withData(int data) {
		item.setDurability((short) data);
		return this;
	}

	public ItemStackBuilder withAmount(int amount) {
		item.setAmount(amount);
		return this;
	}

	public ItemStack build() {
		return item;
	}

	private List<String> colorLore(String... lore) {
		for (int i = 0; i < lore.length; i++) {
			lore[i] = ChatUtil.color(lore[i]);
		}

		return Arrays.asList(lore);
	}

	public ItemStackBuilder withEnchantment(Enchantment enchantment, int level) {
		item.addUnsafeEnchantment(enchantment, level);
		return this;
	}

	public ItemStackBuilder withColor(Color color) {
		Material type = item.getType();
		if (type == Material.LEATHER_BOOTS || type == Material.LEATHER_CHESTPLATE || type == Material.LEATHER_HELMET
				|| type == Material.LEATHER_LEGGINGS) {
			LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
			meta.setColor(color);
			item.setItemMeta(meta);
			return this;
		} else {
			throw new IllegalArgumentException("withColor is only applicable for leather armor!");
		}
	}
}
