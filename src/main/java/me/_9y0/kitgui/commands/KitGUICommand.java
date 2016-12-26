package me._9y0.kitgui.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me._9y0.kitgui.kit.KitManager;

public class KitGUICommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		KitManager.getInstance().showGui((Player) sender);
		return true;
	}

}
