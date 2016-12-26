package me._9y0.kitgui.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;

import me._9y0.kitgui.utils.ChatUtil;

public abstract class Gui {

	protected final Inventory inventory;

	public Gui(String title, int rows) {
		this.inventory = Bukkit.createInventory(null, 9 * rows == 0 ? 9 : 9 * rows, ChatUtil.color(title));
		GuiManager.getInstance().addGui(this);
	}

	public void show(Player player) {
		player.openInventory(inventory);
	}

	public abstract void onClick(InventoryClickEvent event);

	public abstract void onDrag(InventoryDragEvent event);

	public String getName() {
		return inventory.getName();
	}
}
