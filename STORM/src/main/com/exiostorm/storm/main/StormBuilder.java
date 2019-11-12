package com.exiostorm.storm.main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.MultipleFacing;

public class StormBuilder {
	private static Location position;
	private static MultipleFacing directions;
	private Storm plugin;
	public StormBuilder(Storm plugin) {
		System.out.println("StormBuilder class loaded!");
		this.plugin = plugin;
	}

	public static void setBlock(Material m, double x, double y, double z, Location loc, int i, int j, int k) {
		position = loc;
		position.setX(x);
		position.setY(y);
		position.setZ(z);
		//Bukkit.broadcastMessage("SB-world: " + position.getWorld());
		position.getBlock().setType(m);
		BlockData data = position.getBlock().getBlockData();
		//Bukkit.broadcastMessage("StormBuilder: position: " + position);
		if (i<3 && j<3 && k<3) {
		directions = (MultipleFacing) data;
		if (k == -1) {
			directions.setFace(BlockFace.NORTH, true);
			directions.setFace(BlockFace.SOUTH, false);
		}
		if (k == 1) {
			directions.setFace(BlockFace.SOUTH, true);
			directions.setFace(BlockFace.NORTH, false);
		}
		if (k == 0) {
			directions.setFace(BlockFace.NORTH, true);
			directions.setFace(BlockFace.SOUTH, true);
		}
		if (k == 2) {
			directions.setFace(BlockFace.NORTH, false);
			directions.setFace(BlockFace.SOUTH, false);
		}
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		if (j == -1) {
			directions.setFace(BlockFace.DOWN, true);
			directions.setFace(BlockFace.UP, false);
		}
		if (j == 1) {
			directions.setFace(BlockFace.UP, true);
			directions.setFace(BlockFace.DOWN, false);
		}
		if (j == 0) {
			directions.setFace(BlockFace.UP, true);
			directions.setFace(BlockFace.DOWN, true);
		}
		if (j == 2) {
			directions.setFace(BlockFace.UP, false);
			directions.setFace(BlockFace.DOWN, false);
		}
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		if (i == -1) {
			directions.setFace(BlockFace.WEST, true);
			directions.setFace(BlockFace.EAST, false);
		}
		if (i == 1) {
			directions.setFace(BlockFace.EAST, true);
			directions.setFace(BlockFace.WEST, false);
		}
		if (i == 0) {
			directions.setFace(BlockFace.WEST, true);
			directions.setFace(BlockFace.EAST, true);
		}
		if (i == 2) {
			directions.setFace(BlockFace.WEST, false);
			directions.setFace(BlockFace.EAST, false);
		}
		position.getBlock().setBlockData(directions);
		}
	}
}
