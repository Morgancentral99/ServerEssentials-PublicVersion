package me.morgancentral99.essentials.commands.Player;

import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.morgancentral99.essentials.commands.SCommand;
import net.md_5.bungee.api.ChatColor;

public class Gamemode extends SCommand {

	public Gamemode() {
		ArrayList<String> alias = new ArrayList<>();
		alias.add("gm");
		alias.add("Gamemode");
		name = "Gamemode";
		this.alias = alias;
		comm = this;
		args = 1;
		permissions.add("ServerEssentials.Gamemode");
	}


	@Override
	public void execute(CommandSender s, Player p, String[] args) {
		if(args[0].equalsIgnoreCase("c")) {
		p.setGameMode(GameMode.CREATIVE);
		} else if(args[0].equalsIgnoreCase("s")) {
			p.setGameMode(GameMode.SURVIVAL);
		} else if(args[0].equalsIgnoreCase("a")) {
			p.setGameMode(GameMode.ADVENTURE);
		} else if(args[0].equalsIgnoreCase("creative")) {
			p.setGameMode(GameMode.CREATIVE);
		} else if(args[0].equalsIgnoreCase("survival")) {
			p.setGameMode(GameMode.SURVIVAL);
		} else if(args[0].equalsIgnoreCase("adventure")) {
			p.setGameMode(GameMode.ADVENTURE);
		} else if(args[0].equalsIgnoreCase("spectator")) {
			p.setGameMode(GameMode.SPECTATOR);
		}
		
	}

}
