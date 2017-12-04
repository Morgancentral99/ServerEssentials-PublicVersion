package me.morgancentral99.essentials.commands.Player;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.morgancentral99.essentials.commands.Command;
import net.md_5.bungee.api.ChatColor;

public class FeedCommand extends Command {

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(args.length == 0) {
			Player p = (Player)sender;
		p.setFoodLevel(20);
		p.sendMessage(ChatColor.GOLD + "Fed: " + p.getDisplayName());
		} else if (args.length == 1) {
			Player p = Bukkit.getPlayer(args[0]);
			p.setFoodLevel(20);
			sender.sendMessage(ChatColor.GOLD + "Fed: " + p.getDisplayName());
			p.sendMessage(ChatColor.GOLD + "You have been fed!");
		}
		
	}

	@Override
	public void register() {
		ArrayList<String> alias = new ArrayList<>();
		alias.add("eat");
		alias.add("feed");
		commandManager.register("Feed", alias, "feed", this, "ServerEssentials.Feed");
		
	}

}