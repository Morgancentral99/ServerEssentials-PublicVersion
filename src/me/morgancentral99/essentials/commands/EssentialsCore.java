package me.morgancentral99.essentials.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.morgancentral99.essentials.ServerEssentials;
import net.md_5.bungee.api.ChatColor;

public class EssentialsCore extends SCommand {


	protected EssentialsCore() {
		name = "Server Essentials";
		usage = "/SE";
		alias.add("ServerEssentials");
		args = 0;
		permissions.add("SE.Core");
		comm = this;
		register(name, usage, alias, args, permissions, this);
		// TODO Auto-generated constructor stub
	}

	
	/*
	 * protected EssentialsCore(String name, String usage, ArrayList<String>
	 * alias, int minArgs, ArrayList<String> permissions, SCommand Command) {
	 * ArrayList<String> alias2 = new ArrayList<>(); alias.add("SE");
	 * alias.add("Essentials"); permissions.add("ServerEssentials.Core"); name =
	 * "Server Essentials"; usage = "/ServerEssentials"; minArgs = 0; Command =
	 * this;
	 * 
	 * }
	 */

	@Override
	public void execute(CommandSender s, Player p, String[] args) {
		s.sendMessage(ChatColor.GOLD + "Server Essentials Version: " + ChatColor.GREEN
				+ ServerEssentials.getInstance().getPluginFile().getVersion());

	}

}
