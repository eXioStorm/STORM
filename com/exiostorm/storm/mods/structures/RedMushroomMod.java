package com.exiostorm.storm.mods.structures;

import org.bukkit.Location;
import org.bukkit.Material;

import com.exiostorm.storm.main.StormBuilder;

public class RedMushroomMod {
	private static int h = 0;
	private static double x = 0;
	private static double y = 0;
	private static double z = 0;
	private static Location genLoc;
	public RedMushroomMod() {

	}

	public static void genRedMush(Location pos) {
		genLoc = pos;
		x = genLoc.getX();
		y = genLoc.getY();
		z = genLoc.getZ();
		Material mat = Material.RED_MUSHROOM_BLOCK;
		h = 0;
		h = generateHeight();
		h = checkHeightClearance(genLoc, 4, h);
		GenMushroomStem(genLoc, h);
		genLoc = pos;
		System.out.println("location after tasks: " + genLoc.toString());
		StormBuilder.setBlock(mat, x, (y+h+1), z, genLoc, 2, 1, 2);//top middle of cap
		//top layer / cap
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		StormBuilder.setBlock(mat, x, (y+h+1), z, genLoc, 2, 1, 2);//top middle of cap
		StormBuilder.setBlock(mat, x, (y+h+1), (z+1), genLoc, 2, 1, 1);//south middle edge of cap(top)
		StormBuilder.setBlock(mat, x, (y+h+1), (z-1), genLoc, 2, 1, -1);//north middle edge of cap(top)
		StormBuilder.setBlock(mat, (x+1), (y+h+1), z, genLoc, 1, 1, 2);//east middle edge of cap(top)
		StormBuilder.setBlock(mat, (x-1), (y+h+1), z, genLoc, -1, 1, 2);//west middle edge of cap(top)
		StormBuilder.setBlock(mat, (x+1), (y+h+1), (z+1), genLoc, 1, 1, 1);//south east corner of cap(top)
		StormBuilder.setBlock(mat, (x+1), (y+h+1), (z-1), genLoc, 1, 1, -1);//north east corner of cap(top)
		StormBuilder.setBlock(mat, (x-1), (y+h+1), (z+1), genLoc, -1, 1, 1);//south west corner of cap(top)
		StormBuilder.setBlock(mat, (x-1), (y+h+1), (z-1), genLoc, -1, 1, -1);//north west corner of cap(top)
		//top of side cap edges
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		StormBuilder.setBlock(mat, x, (y+h), (z+2), genLoc, 2, 1, 1);//south middle edge of top side cap
		StormBuilder.setBlock(mat, x, (y+h), (z-2), genLoc, 2, 1, -1);//north middle edge of top side cap
		StormBuilder.setBlock(mat, (x+2), (y+h), z, genLoc, 1, 1, 2);//east middle edge of top side cap
		StormBuilder.setBlock(mat, (x-2), (y+h), z, genLoc, -1, 1, 2);//west middle edge of top side cap
		//
		StormBuilder.setBlock(mat, (x+2), (y+h), (z+1), genLoc, 1, 1, 1);//south east corner of top side cap(east?)
		StormBuilder.setBlock(mat, (x+2), (y+h), (z-1), genLoc, 1, 1, -1);//north east corner of top side cap(east?)
		StormBuilder.setBlock(mat, (x-2), (y+h), (z+1), genLoc, -1, 1, 1);//south west corner of top side cap(west?)
		StormBuilder.setBlock(mat, (x-2), (y+h), (z-1), genLoc, -1, 1, -1);//north west corner of top side cap(west?)
		//
		StormBuilder.setBlock(mat, (x+1), (y+h), (z+2), genLoc, 1, 1, 1);//south east corner of top side cap()
		StormBuilder.setBlock(mat, (x+1), (y+h), (z-2), genLoc, 1, 1, -1);//north east corner of top side cap()
		StormBuilder.setBlock(mat, (x-1), (y+h), (z+2), genLoc, -1, 1, 1);//south west corner of top side cap()
		StormBuilder.setBlock(mat, (x-1), (y+h), (z-2), genLoc, -1, 1, -1);//north west corner of top side cap()
		//middle of side cap edges
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		StormBuilder.setBlock(mat, x, (y+h-1), (z+2), genLoc, 2,  2, 1);//south middle edge of middle
		StormBuilder.setBlock(mat, x, (y+h-1), (z-2), genLoc, 2, 2, -1);//north middle edge of middle
		StormBuilder.setBlock(mat, (x+2), (y+h-1), z, genLoc, 1, 2, 2);//east middle edge of middle
		StormBuilder.setBlock(mat, (x-2), (y+h-1), z, genLoc, -1, 2, 2);//west middle edge of middle
		
		StormBuilder.setBlock(mat, (x+2), (y+h-1), (z+1), genLoc, 1, 2, 1);//south east corner of middle
		StormBuilder.setBlock(mat, (x+2), (y+h-1), (z-1), genLoc, 1, 2, -1);//north east corner of middle
		StormBuilder.setBlock(mat, (x-2), (y+h-1), (z+1), genLoc, -1, 2, 1);//south west corner of middle
		StormBuilder.setBlock(mat, (x-2), (y+h-1), (z-1), genLoc, -1, 2, -1);//north west corner of middle
		//
		StormBuilder.setBlock(mat, (x+1), (y+h-1), (z+2), genLoc, 1, 2, 1);//south east corner of top side cap()
		StormBuilder.setBlock(mat, (x+1), (y+h-1), (z-2), genLoc, 1, 2, -1);//north east corner of top side cap()
		StormBuilder.setBlock(mat, (x-1), (y+h-1), (z+2), genLoc, -1, 2, 1);//south west corner of top side cap()
		StormBuilder.setBlock(mat, (x-1), (y+h-1), (z-2), genLoc, -1, 2, -1);//north west corner of top side cap()
		//bottom of side cap edges
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		StormBuilder.setBlock(mat, x, (y+h-2), (z+2), genLoc, 2, 2, 1);//south middle edge of middle
		StormBuilder.setBlock(mat, x, (y+h-2), (z-2), genLoc, 2, 2, -1);//north middle edge of middle
		StormBuilder.setBlock(mat, (x+2), (y+h-2), z, genLoc, 1, 2, 2);//east middle edge of middle
		StormBuilder.setBlock(mat, (x-2), (y+h-2), z, genLoc, -1, 2, 2);//west middle edge of middle
		
		StormBuilder.setBlock(mat, (x+2), (y+h-2), (z+1), genLoc, 1, 2, 1);//south east corner of middle
		StormBuilder.setBlock(mat, (x+2), (y+h-2), (z-1), genLoc, 1, 2, -1);//north east corner of middle
		StormBuilder.setBlock(mat, (x-2), (y+h-2), (z+1), genLoc, -1, 2, 1);//south west corner of middle
		StormBuilder.setBlock(mat, (x-2), (y+h-2), (z-1), genLoc, -1, 2, -1);//north west corner of middle
		//
		StormBuilder.setBlock(mat, (x+1), (y+h-2), (z+2), genLoc, 1, 2, 1);//south east corner of top side cap()
		StormBuilder.setBlock(mat, (x+1), (y+h-2), (z-2), genLoc, 1, 2, -1);//north east corner of top side cap()
		StormBuilder.setBlock(mat, (x-1), (y+h-2), (z+2), genLoc, -1, 2, 1);//south west corner of top side cap()
		StormBuilder.setBlock(mat, (x-1), (y+h-2), (z-2), genLoc, -1, 2, -1);//north west corner of top side cap()
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	}
	private static void GenMushroomStem(Location genLoc, int h) {
		int i = 0;
		while (i < h) {
			StormBuilder.setBlock(Material.MUSHROOM_STEM, x, (y+i), z, genLoc, 0, 2, 0);
			i++;
		}
		if (i == h) {
			StormBuilder.setBlock(Material.GLOWSTONE, x, (y+i), z, genLoc, 3, 3, 3);
		}

	}
	private static int generateHeight() {
		int i = 0;
		int f = 0;
		i = generateNumber(1, 12);
		f = generateNumber(3, 6);
		if (i == 12) {
			f = (f * 2);
		}
		return f;
	}
	private static int generateNumber(int minNum, int maxNum) {
		int num = minNum;
		//num = (int) ((Math.random()*((maxNum-minNum)+1))+minNum);
		num = (int) (Math.round((Math.random()*((maxNum-minNum)*100)/100))+minNum);
		return num;
	}
private static int checkHeightClearance(Location genLoc, int min, int max) {
	Location newgenLoc = genLoc;
	int i = 0;
		i = min;
		boolean obstruction = false;
		while(i<max || obstruction) {
			newgenLoc = genLoc;
			newgenLoc.add(0, i, 0);
			if(!newgenLoc.getBlock().isEmpty()) {
				obstruction = true;
			}
			if(obstruction) {
				break;
			}
			i++;
		}
		return i;
	}
}
