package me.morgancentral99.essentials.commands.Player;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.morgancentral99.essentials.commands.SCommand;
import net.md_5.bungee.api.ChatColor;

public class FeedCommand extends SCommand {

	public FeedCommand() {
		ArrayList<String> alias = new ArrayList<>();
		alias.add("eat");
		alias.add("feed");
		name = "FeedCommand";
		usage = "/feed";
		this.alias = alias;
		comm = this;
		permissions.add("ServerEssentials.Feed");
	}

	@Override
	public void execute(CommandSender s, Player p, String[] args) {
		if (args.length == 0) {
			p.setFoodLevel(20);
			p.sendMessage(ChatColor.GOLD + "Fed: " + p.getDisplayName());
		} else if (args.length == 1) {
			Player p2 = Bukkit.getPlayer(args[0]);
			p.setFoodLevel(20);
			s.sendMessage(ChatColor.GOLD + "Fed: " + p2.getDisplayName());
			p.sendMessage(ChatColor.GOLD + "You have been fed!");
		}

	}

}