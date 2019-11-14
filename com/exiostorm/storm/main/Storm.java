package com.exiostorm.storm.main;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.*;

import com.exiostorm.storm.mods.chat.*;
import com.exiostorm.storm.mods.listeners.ChatListener;
import com.exiostorm.storm.mods.listeners.StructureListener;
import com.exiostorm.storm.mods.structures.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Storm extends JavaPlugin {
	
	@Override
	public void onEnable() {
		this.log("Loading plugin...");
        this.log("Loading config...");
		this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        this.getCommand("stormtest").setExecutor((CommandExecutor)new StormCommands(this));
        this.getCommand("bmush").setExecutor((CommandExecutor)new StormCommands(this));
        this.getCommand("rmush").setExecutor((CommandExecutor)new StormCommands(this));
        this.getCommand("lmush").setExecutor((CommandExecutor)new StormCommands(this));
        this.getCommand("lshore").setExecutor((CommandExecutor)new StormCommands(this));
		//new StormCommands(this);
        new StormBuilder(this);
		new StructureListener(this);
		new ChatListener(this);
	}
	
	@Override
	public void onDisable() {
		
	}
	public void log(final String info) {
        this.getLogger().info(info);
        this.logCustom(info);
    }
	private void logCustom(final String info) {
        try {
            final File dataFolder = this.getDataFolder();
            if (!dataFolder.exists()) {
                dataFolder.mkdir();
            }
            final File saveTo = new File(this.getDataFolder(), "log.txt");
            if (!saveTo.exists()) {
                saveTo.createNewFile();
            }
            final FileWriter fw = new FileWriter(saveTo, true);
            final PrintWriter pw = new PrintWriter(fw);
            pw.println("[" + new SimpleDateFormat("dd.MM.YYYY HH:mm:ss").format(new Date()) + "] " + info);
            pw.flush();
            pw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
