package com.exiostorm.storm.mods.structures;

import org.bukkit.Location;
import org.bukkit.Material;

import com.exiostorm.storm.main.StormBuilder;

public class BrownMushroomMod {
	private static int h = 0;
	private static int x = 0;
	private static int y = 0;
	private static int z = 0;
	private static Location genLoc;
	public BrownMushroomMod() {
	}

	public static void genBrownMush(Location pos) {
		genLoc = pos;
		x = genLoc.getBlockX();
		y = genLoc.getBlockY();
		z = genLoc.getBlockZ();
		Material mat = Material.BROWN_MUSHROOM_BLOCK;
		h = 0;
		h = generateHeight();
		h = checkHeightClearance(genLoc, 4, h);
		GenMushroomStem(genLoc, h);
		genLoc = pos;
		//top layer
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		StormBuilder.setBlock(mat, x, (y+h+1), z, genLoc, 2, 1, 2, true);//top middle of cap
		StormBuilder.setBlock(mat, x, (y+h+1), (z+1), genLoc, 2, 1, 1, true);//south middle edge of cap(top)
		StormBuilder.setBlock(mat, x, (y+h+1), (z-1), genLoc, 2, 1, -1, true);//north middle edge of cap(top)
		StormBuilder.setBlock(mat, (x+1), (y+h+1), z, genLoc, 1, 1, 2, true);//east middle edge of cap(top)
		StormBuilder.setBlock(mat, (x-1), (y+h+1), z, genLoc, -1, 1, 2, true);//west middle edge of cap(top)
		StormBuilder.setBlock(mat, (x+1), (y+h+1), (z+1), genLoc, 1, 1, 1, true);//south east corner of cap(top)
		StormBuilder.setBlock(mat, (x+1), (y+h+1), (z-1), genLoc, 1, 1, -1, true);//north east corner of cap(top)
		StormBuilder.setBlock(mat, (x-1), (y+h+1), (z+1), genLoc, -1, 1, 1, true);//south west corner of cap(top)
		StormBuilder.setBlock(mat, (x-1), (y+h+1), (z-1), genLoc, -1, 1, -1, true);//north west corner of cap(top)
		//top of side cap edges
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		/* 12 corner blocks
		 * second layer has a gap where the cap is, and edges go out 2 blocks(3)
		 * third layer also has a cap where the cap is, and the edges go out 1 block(2)
		 * stem cap blocks are placed @ height / 2(floor), and only have 1 side not textured(no 2) (south for north, north for south, etc.)
		 */
		//corners?
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		StormBuilder.setBlock(mat, (x+3), (y+h), (z+2), genLoc, 1, 0, 1, true);//south east corner of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x-3), (y+h), (z-2), genLoc, -1, 0, -1, true);//north west corner of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x-3), (y+h), (z+2), genLoc, -1, 0, 1, true);//south west corner of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x+3), (y+h), (z-2), genLoc, 1, 0, -1, true);//north east corner of cap(2nd layer down)
		//^^^^^^^^^^^^^^^^^^^^^^
		StormBuilder.setBlock(mat, (x+2), (y+h), (z+3), genLoc, 1, 0, 1, true);//south east corner of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x-2), (y+h), (z-3), genLoc, -1, 0, -1, true);//north west corner of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x-2), (y+h), (z+3), genLoc, -1, 0, 1, true);//south west corner of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x+2), (y+h), (z-3), genLoc, 1, 0, -1, true);//north east corner of cap(2nd layer down)
		//^^^^^^^^^^^^^^^^^^^^^^
		//###########
		StormBuilder.setBlock(mat, (x+2), (y+h-1), (z+1), genLoc, 1, -1, 1, true);//south east corner of cap(3rd layer down)
		StormBuilder.setBlock(mat, (x-2), (y+h-1), (z-1), genLoc, -1, -1, -1, true);//north west corner of cap(3rd layer down)
		StormBuilder.setBlock(mat, (x-2), (y+h-1), (z+1), genLoc, -1, -1, 1, true);//south west corner of cap(3rd layer down)
		StormBuilder.setBlock(mat, (x+2), (y+h-1), (z-1), genLoc, 1, -1, -1, true);//north east corner of cap(3rd layer down)
		//###########
		//edges
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		StormBuilder.setBlock(mat, (x), (y+h), (z+3), genLoc, 2, 0, 1, true);//south middle edge of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x), (y+h), (z-3), genLoc, 2, 0, -1, true);//north middle edge of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x+3), (y+h), (z), genLoc, 1, 0, 2, true);//east middle edge of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x-3), (y+h), (z), genLoc, -1, 0, 2, true);//west middle edge of cap(2nd layer down)
		//###########
		StormBuilder.setBlock(mat, (x+1), (y+h), (z+3), genLoc, 2, 0, 1, true);//south east middle edge of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x+1), (y+h), (z-3), genLoc, 2, 0, -1, true);//north east middle edge of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x+3), (y+h), (z+1), genLoc, 1, 0, 2, true);//south east middle edge of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x-3), (y+h), (z+1), genLoc, -1, 0, 2, true);//south west middle edge of cap(2nd layer down)
		//###########
		StormBuilder.setBlock(mat, (x-1), (y+h), (z+3), genLoc, 2, 0, 1, true);//south west middle edge of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x-1), (y+h), (z-3), genLoc, 2, 0, -1, true);//north west middle edge of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x+3), (y+h), (z-1), genLoc, 1, 0, 2, true);//north east middle edge of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x-3), (y+h), (z-1), genLoc, -1, 0, 2, true);//north west middle edge of cap(2nd layer down)
		//###########
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		//filler
		//&&&&&&&&&&&&&&&&&&&&&&
		//"corners"
		StormBuilder.setBlock(mat, (x+2), (y+h), (z+2), genLoc, 2, 0, 2, true);//south east corner of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x-2), (y+h), (z-2), genLoc, 2, 0, 2, true);//north west corner of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x-2), (y+h), (z+2), genLoc, 2, 0, 2, true);//south west corner of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x+2), (y+h), (z-2), genLoc, 2, 0, 2, true);//north east corner of cap(2nd layer down)
		//^^^^^^^^^^^^^^^^^^^^^^
		//StormBuilder.setBlock(mat, (x+2), (y+h-1), (z+2), genLoc, 2, -1, 2);//south east corner of cap(2nd layer down)
		//StormBuilder.setBlock(mat, (x-2), (y+h-1), (z-2), genLoc, 2, -1, 2);//north west corner of cap(2nd layer down)
		//StormBuilder.setBlock(mat, (x-2), (y+h-1), (z+2), genLoc, 2, -1, 2);//south west corner of cap(2nd layer down)
		//StormBuilder.setBlock(mat, (x+2), (y+h-1), (z-2), genLoc, 2, -1, 2);//north east corner of cap(2nd layer down)
		//^^^^^^^^^^^^^^^^^^^^^^
		//##########
		StormBuilder.setBlock(mat, (x), (y+h), (z+2), genLoc, 2, 1, 2, true);//south middle edge of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x), (y+h), (z-2), genLoc, 2, 1, 2, true);//north middle edge of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x+2), (y+h), (z), genLoc, 2, 1, 2, true);//east middle edge of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x-2), (y+h), (z), genLoc, 2, 1, 2, true);//west middle edge of cap(2nd layer down)
		//###########
		StormBuilder.setBlock(mat, (x+1), (y+h), (z+2), genLoc, 2, 1, 1, true);//south east middle edge of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x+1), (y+h), (z-2), genLoc, 2, 1, -1, true);//north east middle edge of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x+2), (y+h), (z+1), genLoc, 2, 1, 2, true);//south east middle edge of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x-2), (y+h), (z+1), genLoc, 2, 1, 2, true);//south west middle edge of cap(2nd layer down)
		//###########
		StormBuilder.setBlock(mat, (x-1), (y+h), (z+2), genLoc, 2, 1, 2, true);//south west middle edge of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x-1), (y+h), (z-2), genLoc, 2, 1, 2, true);//north west middle edge of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x+2), (y+h), (z-1), genLoc, 2, 1, 2, true);//north east middle edge of cap(2nd layer down)
		StormBuilder.setBlock(mat, (x-2), (y+h), (z-1), genLoc, 2, 1, 2, true);//north west middle edge of cap(2nd layer down)
		//###########
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		StormBuilder.setBlock(mat, (x), (y+h-1), (z+2), genLoc, 2, -1, 1, true);//south middle edge of cap(3rd layer down)
		StormBuilder.setBlock(mat, (x), (y+h-1), (z-2), genLoc, 2, -1, -1, true);//north middle edge of cap(3rd layer down)
		StormBuilder.setBlock(mat, (x+2), (y+h-1), (z), genLoc, 1, -1, 2, true);//east middle edge of cap(3rd layer down)
		StormBuilder.setBlock(mat, (x-2), (y+h-1), (z), genLoc, -1, -1, 2, true);//west middle edge of cap(3rd layer down)
		//###########
		StormBuilder.setBlock(mat, (x+1), (y+h-1), (z+2), genLoc, 1, -1, 1, true);//south east middle edge of cap(3rd layer down)
		StormBuilder.setBlock(mat, (x+1), (y+h-1), (z-2), genLoc, 1, -1, -1, true);//north east middle edge of cap(3rd layer down)
		StormBuilder.setBlock(mat, (x+2), (y+h-1), (z+1), genLoc, 1, -1, 1, true);//south east middle edge of cap(3rd layer down)
		StormBuilder.setBlock(mat, (x-2), (y+h-1), (z+1), genLoc, -1, -1, 1, true);//south west middle edge of cap(3rd layer down)
		//###########
		StormBuilder.setBlock(mat, (x-1), (y+h-1), (z+2), genLoc, -1, -1, 1, true);//south west middle edge of cap(3rd layer down)
		StormBuilder.setBlock(mat, (x-1), (y+h-1), (z-2), genLoc, -1, -1, -1, true);//north west middle edge of cap(3rd layer down)
		StormBuilder.setBlock(mat, (x+2), (y+h-1), (z-1), genLoc, 1, -1, -1, true);//north east middle edge of cap(3rd layer down)
		StormBuilder.setBlock(mat, (x-2), (y+h-1), (z-1), genLoc, -1, -1, -1, true);//north west middle edge of cap(3rd layer down)
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		StormBuilder.setBlock(mat, (x+1), (y+(Math.floor((h/2))-1)), (z), genLoc, 1, 0, 0, true);
		StormBuilder.setBlock(mat, (x-1), (y+(Math.floor((h/2))-1)), (z), genLoc, -1, 0, 0, true);
		StormBuilder.setBlock(mat, (x), (y+(Math.floor((h/2))-1)), (z+1), genLoc, 0, 0, 1, true);
		StormBuilder.setBlock(mat, (x), (y+(Math.floor((h/2))-1)), (z-1), genLoc, 0, 0, -1, true);
	}
	private static void GenMushroomStem(Location genLoc, int h) {
		int i = 0;
		while (i < h) {
			StormBuilder.setBlock(Material.MUSHROOM_STEM, x, (y+i), z, genLoc, 0, 2, 0, true);
			genLoc.add(0, 1, 0).getBlock().setType(Material.MUSHROOM_STEM);
			i++;
		}
		if (i == h) {
			StormBuilder.setBlock(Material.GLOWSTONE, x, (y+i), z, genLoc, 3, 3, 3, true);
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
			int i = min;
			boolean obstruction = false;
			while(i<max) {
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
