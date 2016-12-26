package me._9y0.kitgui.gui.guis;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

import me._9y0.kitgui.gui.Gui;
import me._9y0.kitgui.kit.Kit;
import me._9y0.kitgui.kit.KitManager;
import me._9y0.kitgui.utils.ItemStackBuilder;

public class KitGui extends Gui {

	public KitGui(KitManager kitManager) {
		super("&b&lKies je kit!", kitManager.getKits().size() / 9 + 1);
		for (Kit kit : kitManager.getKits()) {
			inventory.addItem(
					new ItemStackBuilder(kit.getChestPlate()).withLore("&bRechter muisknop voor een preview.").build());
		}
	}

	@Override
	public void onClick(InventoryClickEvent event) {
		if (event.getCurrentItem() == null)
			return;

		Kit kit = KitManager.getInstance().getKit(event.getCurrentItem());
		if (kit == null)
			return;

		event.getWhoClicked().closeInventory();
		if (event.isLeftClick()) {
			kit.giveKit((Player) event.getWhoClicked());
		} else if (event.isRightClick()) {
			kit.getPreviewGui().show((Player) event.getWhoClicked());
		}
	}

	@Override
	public void onDrag(InventoryDragEvent event) {
		event.setCancelled(true);
	}
}
