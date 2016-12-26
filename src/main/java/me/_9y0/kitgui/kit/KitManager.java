package me._9y0.kitgui.kit;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me._9y0.kitgui.gui.Gui;
import me._9y0.kitgui.gui.guis.KitGui;
import me._9y0.kitgui.kit.kits.DefaultKit;
import me._9y0.kitgui.kit.kits.GoldKit;

public class KitManager {

	private static final KitManager instance = new KitManager();

	private final Set<Kit> kits = new HashSet<>();

	private Gui kitGui;

	private KitManager() {
		this.kits.add(new DefaultKit("&7&lDefault Kit", Color.fromRGB(128, 128, 128)));
		this.kits.add(new GoldKit("&e&lGold Kit", Color.fromRGB(255, 255, 51)));

		this.kitGui = new KitGui(this);
	}

	public static KitManager getInstance() {
		return instance;
	}

	public Kit getKit(ItemStack chestPlate) {
		for (Kit kit : kits) {
			if (chestPlate.getType() == kit.getChestPlate().getType() && chestPlate.getItemMeta().getDisplayName()
					.equals(kit.getChestPlate().getItemMeta().getDisplayName()))
				return kit;
		}
		return null;
	}

	public Set<Kit> getKits() {
		return kits;
	}

	public void showGui(Player player) {
		kitGui.show(player);
	}
}
