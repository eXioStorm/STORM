package com.exiostorm.storm.mods.structures;

import org.bukkit.Location;
import org.bukkit.Material;

public class MushroomConverter {
	private static Location genLoc;
	public MushroomConverter() {}
	public static void convertStem(Location pos) {
		genLoc = pos;
		Material mat = Material.GLOWSTONE;
		while(genLoc.getBlock().getType() == Material.MUSHROOM_STEM) {
			genLoc.add(0, 1, 0);
		}
		if (genLoc.getBlock().getType() == Material.BROWN_MUSHROOM_BLOCK || genLoc.getBlock().getType() == Material.RED_MUSHROOM_BLOCK) {
			genLoc.subtract(0, 1, 0);
			genLoc.getBlock().setType(mat);
		}
	}
}
