package me.morgancentral99.essentials.commands.Player;

import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.morgancentral99.essentials.commands.Command;
import net.md_5.bungee.api.ChatColor;

public class Gamemode extends Command {

	@Override
	public void execute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		if(args.length == 0) {
			sender.sendMessage(ChatColor.RED + "Not Enough Args");
		}
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

	@Override
	public void register() {
		ArrayList<String> alias = new ArrayList<>();
		alias.add("gm");
		commandManager.register("Gamemode", alias , "Gamemode", this, "Essentials.gamemode");
		
	}

}
