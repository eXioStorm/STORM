package com.exiostorm.storm.mods.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.TreeType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.block.Biome;
import org.bukkit.block.data.MultipleFacing;

import com.exiostorm.storm.main.Storm;
import com.exiostorm.storm.mods.structures.RedMushroomMod;

public class StructureListener implements Listener {
	@SuppressWarnings("unused")
	private static Storm plugin;
	private Location loc;
	MultipleFacing data;

	public StructureListener(Storm plugin) {
		StructureListener.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void mushroomTreeEvent(org.bukkit.event.world.StructureGrowEvent e) {
		if (e.getLocation().getBlock().getBiome() == Biome.MUSHROOM_FIELDS
				|| e.getLocation().getBlock().getBiome() == Biome.MUSHROOM_FIELD_SHORE) {
			if (e.getSpecies() == TreeType.RED_MUSHROOM || e.getSpecies() == TreeType.BROWN_MUSHROOM) {
				loc = e.getLocation();
				data = (MultipleFacing) e.getLocation().getBlock().getBlockData();
				if (e.getSpecies() == TreeType.RED_MUSHROOM) {
					if (!e.isFromBonemeal()) {
						e.setCancelled(true);
						Bukkit.broadcastMessage("a red mushroom tree has grown @ [" + e.getLocation() + "]!");
						RedMushroomMod.genRedMush(loc);
					}
				}
				if (e.getSpecies() == TreeType.BROWN_MUSHROOM) {
					if (!e.isFromBonemeal()) {
						e.setCancelled(true);
						Bukkit.broadcastMessage("a brown mushroom tree has grown @ [" + e.getLocation() + "]!");
					}
				}
			}
		}
	}
}
