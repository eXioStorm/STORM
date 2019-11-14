package com.exiostorm.storm.mods.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.TreeType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.block.Biome;

import com.exiostorm.storm.main.Storm;
import com.exiostorm.storm.mods.structures.BrownMushroomMod;
import com.exiostorm.storm.mods.structures.RedMushroomMod;

public class StructureListener implements Listener {
	@SuppressWarnings("unused")
	private static Storm plugin;
	private Location loc;

	public StructureListener(Storm plugin) {
		StructureListener.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void mushroomTreeEvent(org.bukkit.event.world.StructureGrowEvent e) {
		//System.out.println("event detected!");
		//if (e.getLocation().getBlock().getBiome() == Biome.MUSHROOM_FIELDS
			//	|| e.getLocation().getBlock().getBiome() == Biome.MUSHROOM_FIELD_SHORE) {
			if (e.getSpecies() == TreeType.RED_MUSHROOM || e.getSpecies() == TreeType.BROWN_MUSHROOM) {
				loc = e.getLocation();
				if (e.getSpecies() == TreeType.RED_MUSHROOM) {
						e.setCancelled(true);
						//Bukkit.broadcastMessage("a red mushroom tree has grown @ [" + e.getLocation() + "]!");
						RedMushroomMod.genRedMush(loc);
				}
				if (e.getSpecies() == TreeType.BROWN_MUSHROOM) {
						e.setCancelled(true);
						//Bukkit.broadcastMessage("a brown mushroom tree has grown @ [" + e.getLocation() + "]!");
						BrownMushroomMod.genBrownMush(loc);
				}
			}
		}
	}
//}
