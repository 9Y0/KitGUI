package me._9y0.kitgui.gui.guis;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

import me._9y0.kitgui.gui.Gui;
import me._9y0.kitgui.kit.Kit;
import me._9y0.kitgui.kit.KitManager;
import me._9y0.kitgui.utils.ItemStackBuilder;

public class PreviewGui extends Gui {

	public PreviewGui(Kit kit) {
		super(kit.getName(), 1);
		inventory.addItem(kit.getSword());
		kit.getBow().ifPresent(inventory::addItem);
		inventory.addItem(kit.getHelmet(), kit.getChestPlate(), kit.getLeggings(), kit.getBoots());
		kit.getArrows().ifPresent(inventory::addItem);

		inventory.setItem(8, new ItemStackBuilder(Material.BARRIER).withName("&cGo back!").build());
	}

	@Override
	public void onClick(InventoryClickEvent event) {
		event.setCancelled(true);
		System.out.println("clicked preview");
		if (event.getCurrentItem() == null)
			return;

		if (event.getCurrentItem().getType() == Material.BARRIER)
			KitManager.getInstance().showGui((Player) event.getWhoClicked());
	}

	@Override
	public void onDrag(InventoryDragEvent event) {
		event.setCancelled(true);
	}
}
