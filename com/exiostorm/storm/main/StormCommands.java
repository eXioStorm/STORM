package com.exiostorm.storm.main;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.exiostorm.storm.mods.structures.BrownMushroomMod;
import com.exiostorm.storm.mods.structures.IlluminateShore;
import com.exiostorm.storm.mods.structures.MushroomConverter;
import com.exiostorm.storm.mods.structures.RedMushroomMod;

public class StormCommands implements CommandExecutor {
	@SuppressWarnings("unused")
	private Storm plugin;

	public StormCommands(Storm plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("stormtest")) {
			CommandSender p = (Player) sender;
			if (!p.hasPermission("storm.test")) {
				p.sendMessage("You must not be Storm! please elevate your permissions!");
				return true;
			}
			 p.sendMessage("And it's windy weather, boys, stormy weather, boys\nWhen the wind blows, we're all together, boys;\nBlow ye winds westerly, blow ye winds, blow\nJolly sou'wester, boys, steady she goes");
			//RedMushroomMod.genRedMush(p.getServer().getPlayer(p.getName()).getTargetBlockExact(1000).getLocation().add(0, 1, 0).getBlock().getLocation());
			//BrownMushroomMod.genBrownMush(p.getServer().getPlayer(p.getName()).getTargetBlockExact(1000).getLocation().add(0, 1, 0).getBlock().getLocation());
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("bmush")) {
			CommandSender p = (Player) sender;
			if (!p.hasPermission("storm.bmush")) {
				p.sendMessage("You must not be Storm! please elevate your permissions!");
				return true;
			}
			BrownMushroomMod.genBrownMush(p.getServer().getPlayer(p.getName()).getTargetBlockExact(1000).getLocation().add(0, 1, 0).getBlock().getLocation());
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("rmush")) {
			CommandSender p = (Player) sender;
			if (!p.hasPermission("storm.rmush")) {
				p.sendMessage("You must not be Storm! please elevate your permissions!");
				return true;
			}
			RedMushroomMod.genRedMush(p.getServer().getPlayer(p.getName()).getTargetBlockExact(1000).getLocation().add(0, 1, 0).getBlock().getLocation());
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("lmush")) {
			CommandSender p = (Player) sender;
			if (!p.hasPermission("storm.lmush")) {
				p.sendMessage("You must not be Storm! please elevate your permissions!");
				return true;
			}
			MushroomConverter.convertStem(p.getServer().getPlayer(p.getName()).getTargetBlockExact(1000).getLocation().getBlock().getLocation());
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("lshore")) {
			CommandSender p = (Player) sender;
			if (!p.hasPermission("storm.lshore")) {
				p.sendMessage("You must not be Storm! please elevate your permissions!");
				return true;
			}
			IlluminateShore.Scan(p.getServer().getPlayer(p.getName()).getTargetBlockExact(1000).getLocation().getBlock().getLocation());
			return true;
		}
		return true;
	}
}
