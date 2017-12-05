package me.morgancentral99.essentials.commands;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.morgancentral99.essentials.ServerEssentials;
import net.md_5.bungee.api.ChatColor;

public abstract class SCommand {
	
	public String name;
	public String usage;
	public ArrayList<String> alias;
	public int args;
	public ArrayList<String> permissions;
	public SCommand comm;
	

	
	public void register(String name, String usage, ArrayList<String> alias, int minArgs, ArrayList<String> permissions, SCommand command) {
		this.name = name;
		this.usage = usage;
		this.alias = alias;
		this.args = minArgs;
		this.permissions = permissions;
		this.comm = command;
		ServerEssentials.getInstance().getCommandManager().getCommandAlias().put(alias, comm);
		
	}

	public String getName() {
		return name;
	}

	public String getUsage() {
		return usage;
	}

	public ArrayList<String> getAlias() {
		return alias;
	}

	public int getArgs() {
		return args;
	}

	public SCommand getComm() {
		return comm;
	}

	public abstract void execute(CommandSender s, Player p, String[] args);

	public ArrayList<String> getPermissions() {
		return permissions;
	}

	
	
}