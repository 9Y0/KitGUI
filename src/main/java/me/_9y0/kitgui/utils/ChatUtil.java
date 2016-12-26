package me._9y0.kitgui.utils;

import org.bukkit.ChatColor;

public class ChatUtil {

	public static String color(String input) {
		return ChatColor.translateAlternateColorCodes('&', input);
	}

}
