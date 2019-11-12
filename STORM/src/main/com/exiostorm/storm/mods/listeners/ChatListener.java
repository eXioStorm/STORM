package com.exiostorm.storm.mods.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.BroadcastMessageEvent;

import com.exiostorm.storm.main.*;

public class ChatListener implements Listener {
	private static Storm plugin;
	public ChatListener(Storm plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void messageEvent(org.bukkit.event.server.BroadcastMessageEvent e) {
		if(e.getMessage().contains("§")) {
			e.setMessage(e.getMessage() + "§r");
		}
	}
}
