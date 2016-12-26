package me._9y0.kitgui.kit;

import java.util.Optional;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me._9y0.kitgui.gui.Gui;
import me._9y0.kitgui.gui.guis.PreviewGui;

public abstract class Kit {

	private final Gui previewGui;

	private final String name;

	private final ItemStack sword;

	private final Optional<ItemStack> bow;
	private final Optional<ItemStack> arrows;

	private final ItemStack helmet;
	private final ItemStack chestPlate;
	private final ItemStack leggings;
	private final ItemStack boots;

	public Kit(String name, ItemStack sword, Optional<ItemStack> bow, Optional<ItemStack> arrows, ItemStack helmet,
			ItemStack chestPlate, ItemStack leggings, ItemStack boots) {
		this.name = name;
		this.sword = sword;
		this.bow = bow;
		this.arrows = arrows;
		this.helmet = helmet;
		this.chestPlate = chestPlate;
		this.leggings = leggings;
		this.boots = boots;

		this.previewGui = new PreviewGui(this);
	}

	public void giveKit(Player player) {
		player.getInventory().clear();

		player.getInventory().setHelmet(helmet);
		player.getInventory().setChestplate(chestPlate);
		player.getInventory().setLeggings(leggings);
		player.getInventory().setBoots(boots);

		player.getInventory().addItem(sword);
		bow.ifPresent(item -> player.getInventory().addItem(item));
		arrows.ifPresent(item -> player.getInventory().setItem(17, arrows.get()));

		player.updateInventory();
	}

	public Gui getPreviewGui() {
		return previewGui;
	}

	public String getName() {
		return name;
	}

	public ItemStack getSword() {
		return sword;
	}

	public Optional<ItemStack> getBow() {
		return bow;
	}

	public Optional<ItemStack> getArrows() {
		return arrows;
	}

	public ItemStack getHelmet() {
		return helmet;
	}

	public ItemStack getChestPlate() {
		return chestPlate;
	}

	public ItemStack getLeggings() {
		return leggings;
	}

	public ItemStack getBoots() {
		return boots;
	}
}
