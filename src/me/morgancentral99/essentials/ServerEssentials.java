package me.morgancentral99.essentials;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.craftbukkit.v1_12_R1.CraftServer;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.morgancentral99.essentials.commands.CommandManager;

public class ServerEssentials extends JavaPlugin {
	
	PluginManager pm = Bukkit.getPluginManager();
	private static ServerEssentials instance;
	private PluginDescriptionFile desc;
	CommandManager manager = new CommandManager();
	CommandMap cmap;

	@Override
	public void onEnable() {
		desc = this.getDescription();
		instance = this;
		if(cmap == null) {
			try {
				if(Bukkit.getServer() instanceof CraftServer) {
					final Field f = CraftServer.class.getDeclaredField("commandMap");
					f.setAccessible(true);
					cmap = (CommandMap)f.get(Bukkit.getServer());
				}
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		}
		Log("Loaded!");
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		getCommandManager().getCommandAlias().clear(); 
		Log("Disabled!");
		super.onDisable();
	}
	
	public CommandMap getCommandMap() {
		return cmap;
	}
	
	public static void Log(String s) {
		System.out.println("Server Essentials: " + s);
	}
	
	public static ServerEssentials getInstance() {
		return instance;
	}
	
	public PluginDescriptionFile getPluginFile() {
		return desc;
	}
	
	public CommandManager getCommandManager() {
		return manager;
	}
}
