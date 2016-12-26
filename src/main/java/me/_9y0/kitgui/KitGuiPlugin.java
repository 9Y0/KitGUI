package me._9y0.kitgui;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me._9y0.kitgui.commands.KitGUICommand;
import me._9y0.kitgui.gui.GuiManager;

public class KitGuiPlugin extends JavaPlugin {

	private static KitGuiPlugin instance;

	public static KitGuiPlugin getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {
		instance = this;

		registerListeners();
		registerCommands();
	}

	private void registerListeners() {
		Bukkit.getPluginManager().registerEvents(GuiManager.getInstance(), this);
	}

	private void registerCommands() {
		getCommand("kitgui").setExecutor(new KitGUICommand());
	}

	@Override
	public void onDisable() {

		instance = null;
	}
}
