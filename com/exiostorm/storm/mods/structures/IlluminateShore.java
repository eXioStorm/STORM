package com.exiostorm.storm.mods.structures;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;

public class IlluminateShore {
	private static int h = 0;
	private static int ax = 0;
	private static int az = 0;
	private static int sx = 0;
	private static int sz = 0;
	private static int x = 0;
	private static int y = 0;
	private static int z = 0;
	private static boolean cont = false;
	private static boolean east = false;
	private static boolean west = false;
	private static boolean north = false;
	private static boolean south = false;
	private static Location genLoc;
	private static Location savPos;

	public IlluminateShore() {
	}

	public static void Scan(Location pos) {
		genLoc = pos;
		savPos = pos;
		x = genLoc.getBlockX();
		y = genLoc.getBlockY();
		z = genLoc.getBlockZ();
		Material mat = Material.GLOWSTONE;
		h = 0;
		if (genLoc.getBlock().getType() == Material.WATER) {
			cont = true;
			while (cont) {
				cont = false;
				East();
				South();
				West();
				--ax;
				genLoc.subtract(0, 0, 1);
				West();
				North();
				East();
				++az;
				genLoc.add(0, 0, 1);
				if (!east) {
					if (west) {
						if (north) {
							++ax;
							++az;
							genLoc.add(1, 0, 1);
						}
						if (south) {
							++ax;
							--az;
							genLoc.add(1, 0, 0);
							genLoc.subtract(0, 0, 1);
						}
						if (!north && !south) {
							++ax;
							genLoc.add(1, 0, 0);
						}
					}
				}
				if (!west) {
					if (east) {
						if (north) {
							++ax;
							++az;
							genLoc.add(1, 0, 0);
							genLoc.add(0, 0, 1);
						}
						if (south) {
							++ax;
							--az;
							genLoc.add(1, 0, 0);
							genLoc.subtract(0, 0, 1);
						}
						if (!north && !south) {
							--ax;
							genLoc.subtract(1, 0, 0);
						}
					}
				}
				if (!south) {
					if (north) {
						if (west) {
							++az;
							--ax;
							genLoc.add(0, 0, 1);
							genLoc.subtract(1, 0, 0);
							
						}
						if (east) {
							++az;
							++ax;
							genLoc.add(0, 0, 1);
							genLoc.add(1, 0, 0);
							
						}
						if (!north && !south) {
							--az;
							genLoc.subtract(0, 0, 1);
						}
					}
				}
				if (!north) {
					if (south) {
						if (west) {
							--az;
							++ax;
							genLoc.subtract(0, 0, 1);
							genLoc.add(1, 0, 0);
						}
						if (east) {
							--az;
							--ax;
							genLoc.subtract(0, 0, 1);
							genLoc.subtract(1, 0, 0);
						}
						if (!north && !south) {
							++az;
							genLoc.add(0, 0, 1);
						}
					}
				}
				east = false;
				west = false;
				south = false;
				north = false;
				if (genLoc.getWorld().getBiome((x+ax),(z+az)).toString().equalsIgnoreCase(Biome.MUSHROOM_FIELD_SHORE.toString()) || genLoc.getWorld().getBiome((x+ax),(z+az)).toString().equalsIgnoreCase(Biome.MUSHROOM_FIELD_SHORE.toString())) {
					cont = false;
					//return;
				}
				if (!cont) {
					//return;
				}
				if (genLoc == savPos) {
					cont = false;
					//return;
				}
			}
			ax = 0;
			az = 0;
		}
	}

	private static void East() {
		genLoc.add(ax, 0, 0);
		if ((!(genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER))
				&& genLoc.getWorld().getBiome(x + ax, az).toString().equalsIgnoreCase(Biome.MUSHROOM_FIELDS.toString())
				|| genLoc.getWorld().getBiome(x + ax, az).toString()
						.equalsIgnoreCase(Biome.MUSHROOM_FIELD_SHORE.toString())) {
			genLoc.subtract(1, 0, 0);
			if ((genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER)) {
				cont = true;
				east = true;
				while ((genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER)) {
					genLoc.subtract(0, 1, 0);
				}
				genLoc.getBlock().setType(Material.GLOWSTONE);
				genLoc.setY(y);
				// genLoc.add(1, 0, 0);
			}
			++ax;
		}
	}

	private static void West() {
		genLoc.subtract(ax, 0, 0);
		if ((!(genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER))
				&& genLoc.getWorld().getBiome((ax - x), (z)).toString().equalsIgnoreCase(Biome.MUSHROOM_FIELDS.toString())
				|| genLoc.getWorld().getBiome((ax - x), (z)).toString()
						.equalsIgnoreCase(Biome.MUSHROOM_FIELD_SHORE.toString())) {
			genLoc.add(1, 0, 0);
			if ((genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER)) {
				cont = true;
				east = true;
				while ((genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER)) {
					genLoc.subtract(0, 1, 0);
				}
				genLoc.getBlock().setType(Material.GLOWSTONE);
				genLoc.setY(y);
				// genLoc.add(1, 0, 0);
			}
			--ax;
		}
	}

	private static void South() {
		genLoc.add(0, 0, az);
		if ((!(genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER))
				&& genLoc.getWorld().getBiome(x, z + az).toString().equalsIgnoreCase(Biome.MUSHROOM_FIELDS.toString())
				|| genLoc.getWorld().getBiome(x, z + az).toString()
						.equalsIgnoreCase(Biome.MUSHROOM_FIELD_SHORE.toString())) {
			genLoc.subtract(0, 0, 1);
			if ((genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER)) {
				cont = true;
				east = true;
				while ((genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER)) {
					genLoc.subtract(0, 1, 0);
				}
				genLoc.getBlock().setType(Material.GLOWSTONE);
				genLoc.setY(y);
				// genLoc.add(1, 0, 0);
			}
			++az;
		}
	}

	private static void North() {
		genLoc.subtract(0, 0, az);
		if ((!(genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER))
				&& genLoc.getWorld().getBiome(x, z + az).toString().equalsIgnoreCase(Biome.MUSHROOM_FIELDS.toString())
				|| genLoc.getWorld().getBiome(x, z + az).toString()
						.equalsIgnoreCase(Biome.MUSHROOM_FIELD_SHORE.toString())) {
			genLoc.add(0, 0, 1);
			if ((genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER)) {
				cont = true;
				east = true;
				while ((genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER)) {
					genLoc.subtract(0, 1, 0);
				}
				genLoc.getBlock().setType(Material.GLOWSTONE);
				genLoc.setY(y);
				// genLoc.add(1, 0, 0);
			}
			--az;
		}
	}

	private static void sEast() {
		genLoc.add(sx, 0, 0);
		if ((!(genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER))
				&& genLoc.getWorld().getBiome(x + sx, sz).toString().equalsIgnoreCase(Biome.MUSHROOM_FIELDS.toString())
				|| genLoc.getWorld().getBiome(x + sx, sz).toString()
						.equalsIgnoreCase(Biome.MUSHROOM_FIELD_SHORE.toString())) {
			genLoc.subtract(1, 0, 0);
			if ((genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER)) {
				cont = true;
				east = true;
				while ((genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER)) {
					genLoc.subtract(0, 1, 0);
				}
				genLoc.getBlock().setType(Material.GLOWSTONE);
				genLoc.setY(y);
				// genLoc.add(1, 0, 0);
			}
			++sx;
		}
	}

	private static void sWest() {
		genLoc.subtract(sx, 0, 0);
		if ((!(genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER))
				&& genLoc.getWorld().getBiome((sx - x), (z)).toString().equalsIgnoreCase(Biome.MUSHROOM_FIELDS.toString())
				|| genLoc.getWorld().getBiome((sx - x), (z)).toString()
						.equalsIgnoreCase(Biome.MUSHROOM_FIELD_SHORE.toString())) {
			genLoc.add(1, 0, 0);
			if ((genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER)) {
				cont = true;
				east = true;
				while ((genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER)) {
					genLoc.subtract(0, 1, 0);
				}
				genLoc.getBlock().setType(Material.GLOWSTONE);
				genLoc.setY(y);
				// genLoc.add(1, 0, 0);
			}
			--sx;
		}
	}

	private static void sSouth() {
		genLoc.add(0, 0, sz);
		if ((!(genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER))
				&& genLoc.getWorld().getBiome(x, z + sz).toString().equalsIgnoreCase(Biome.MUSHROOM_FIELDS.toString())
				|| genLoc.getWorld().getBiome(x, z + sz).toString()
						.equalsIgnoreCase(Biome.MUSHROOM_FIELD_SHORE.toString())) {
			genLoc.subtract(0, 0, 1);
			if ((genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER)) {
				cont = true;
				east = true;
				while ((genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER)) {
					genLoc.subtract(0, 1, 0);
				}
				genLoc.getBlock().setType(Material.GLOWSTONE);
				genLoc.setY(y);
				// genLoc.add(1, 0, 0);
			}
			++sz;
		}
	}

	private static void sNorth() {
		genLoc.subtract(0, 0, sz);
		if ((!(genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER))
				&& genLoc.getWorld().getBiome(x, z + sz).toString().equalsIgnoreCase(Biome.MUSHROOM_FIELDS.toString())
				|| genLoc.getWorld().getBiome(x, z + sz).toString()
						.equalsIgnoreCase(Biome.MUSHROOM_FIELD_SHORE.toString())) {
			genLoc.add(0, 0, 1);
			if ((genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER)) {
				cont = true;
				east = true;
				while ((genLoc.getWorld().getHighestBlockAt(genLoc).getType() == Material.WATER)) {
					genLoc.subtract(0, 1, 0);
				}
				genLoc.getBlock().setType(Material.GLOWSTONE);
				genLoc.setY(y);
				// genLoc.add(1, 0, 0);
			}
			--sz;
		}
	}
}
