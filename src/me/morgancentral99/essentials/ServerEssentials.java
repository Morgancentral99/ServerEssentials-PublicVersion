package me.morgancentral99.essentials;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.morgancentral99.essentials.commands.CommandManager;

public class ServerEssentials extends JavaPlugin {
	
	PluginManager pm = Bukkit.getPluginManager();
	private static ServerEssentials instance;
	private PluginDescriptionFile desc;
	CommandManager manager = new CommandManager();
	@Override
	public void onEnable() {
		desc = this.getDescription();
		instance = this;
		manager.addCommands();
		System.out.println(manager.commandClasses.toString());
		Log("Loaded!");
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		Log("Disabled!");
		super.onDisable();
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
}
