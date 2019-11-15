package com.exiostorm.storm.mods.structures;

import org.bukkit.Location;
import org.bukkit.Material;

public class MushroomConverter {
	private static int h = 0;
	private static int x = 0;
	private static int y = 0;
	private static int z = 0;
	private static Location genLoc;
	private static Location savLoc;

	public MushroomConverter() {
	}

	public static void convertStem(Location pos) {
		genLoc = pos;
		Material mat = Material.GLOWSTONE;
		while (genLoc.getBlock().getType() == Material.MUSHROOM_STEM) {
			genLoc.add(0, 1, 0);
		}
		if (genLoc.getBlock().getType() == Material.BROWN_MUSHROOM_BLOCK
				|| genLoc.getBlock().getType() == Material.RED_MUSHROOM_BLOCK) {
			genLoc.subtract(0, 1, 0);
			genLoc.getBlock().setType(mat);
		}
	}

	public static void convertBMush(Location pos) {
		genLoc = pos;
		savLoc = pos;
		Location getLoc = pos;
		x = savLoc.getBlockX();
		y = savLoc.getBlockY();
		z = savLoc.getBlockZ();
		savLoc = pos;
		Material mat = Material.BROWN_MUSHROOM_BLOCK;
		int h = 0;
		int i = 0;
		while (genLoc.getBlock().getType() == Material.MUSHROOM_STEM) {
			++i;
			genLoc.add(0, 1, 0);
		}
		--i;
		if (genLoc.getBlock().getType() == Material.BROWN_MUSHROOM_BLOCK) {
			//h = ((genLoc.getBlockY()) - (savLoc.getBlockY()));
			//System.out.println(h);
			deletemush(getLoc, i);
			BrownMushroomMod.GenMushroomStem(mat, x, y, z, i, getLoc);
			BrownMushroomMod.GenMushroomCap(mat, x, y, z, i, getLoc);
		}
	}

	private static void deletemush(Location loc, int h) {
		Location deleteloc = loc;
		
			deleteloc.add(0, (h+1), 0);
			if (deleteloc.getBlock().getType() == Material.BROWN_MUSHROOM_BLOCK) {
				
				int zed = 0;
				deleteloc.add(3, 0, 3).getBlock().setType(Material.AIR);
				while (zed < 6) {
					int i = 0;
					while (i < 6) {
						++i;
						deleteloc.subtract(1, 0, 0).getBlock().setType(Material.AIR);
					}
					i = 0;
					deleteloc.subtract(0, 0, 1);
					while (i < 6) {
						deleteloc.add(1, 0, 0);
						++i;
						deleteloc.subtract(1, 0, 0).getBlock().setType(Material.AIR);
					}
				}
			}
		
	}
}
