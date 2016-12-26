package me._9y0.kitgui.gui;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;

public class GuiManager implements Listener {

	private static final GuiManager instance = new GuiManager();

	private final Set<Gui> guis = new HashSet<>();

	private GuiManager() {
	}

	public static GuiManager getInstance() {
		return instance;
	}

	void addGui(Gui gui) {
		guis.add(gui);
	}

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		handleClick(event);
	}

	@EventHandler
	public void onClick(InventoryDragEvent event) {
		handleClick(event);
	}

	private void handleClick(InventoryInteractEvent event) {
		String inventoryName = event.getWhoClicked().getOpenInventory().getTopInventory().getName();

		for (Gui gui : guis) {
			if (inventoryName.equals(gui.getName())) {
				System.out.println("found interacted gui");
				if (event instanceof InventoryClickEvent)
					gui.onClick((InventoryClickEvent) event);
				else if (event instanceof InventoryDragEvent)
					gui.onDrag((InventoryDragEvent) event);
			}
		}
	}
}
