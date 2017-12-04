package me.morgancentral99.essentials.commands;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;

public abstract class Command {
	
	public CommandManager commandManager = new CommandManager();
	public ArrayList<String> Commands = new ArrayList<>();
	
	public abstract void execute(CommandSender sender, String[] args);
	
	public abstract void register();

}
