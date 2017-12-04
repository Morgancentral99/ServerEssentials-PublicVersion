package me.morgancentral99.essentials.commands;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;

import me.morgancentral99.essentials.ServerEssentials;
import net.md_5.bungee.api.ChatColor;

public class EssentialsCore extends Command {

	@Override
	public void execute(CommandSender sender, String[] args) {
		sender.sendMessage(ChatColor.GOLD + "Server Essentials Version: " + ChatColor.GREEN + ServerEssentials.getInstance().getPluginFile().getVersion());
	}

	@Override
	public void register() {
		ArrayList<String> alias = new ArrayList<>();
		alias.add("SE");
		alias.add("Essentials");
		commandManager.register("ServerEssentials", alias, "ServerEssentials", this, "ServerEssentials.Core");
		
	}

}
