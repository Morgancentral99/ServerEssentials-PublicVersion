package me.morgancentral99.essentials.commands.Server;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.morgancentral99.essentials.ServerEssentials;
import me.morgancentral99.essentials.commands.SCommand;
import net.md_5.bungee.api.ChatColor;

public class StopCommand extends SCommand {

	int timer = 60;

	public StopCommand() {
		ArrayList<String> alias = new ArrayList<>();
		alias.add("Shutdown");
		alias.add("Stop");
		name = "Stop Command";
		usage = "/Stop";
		this.alias = alias;
		comm = this;
		permissions.add("ServerEssentials.shutdown");
	}



	@Override
	public void execute(CommandSender s, Player p, String[] args) {
		if(args.length == 0) {
			s.sendMessage(ChatColor.RED + "Sever Shuting down Initiated... (As of now this cant be stopped.)");
			Bukkit.getScheduler().runTaskTimer(ServerEssentials.getInstance(), new Runnable() {
				int i = timer;
				@Override
				public void run() {
					if(i == 60) {
						s.sendMessage(ChatColor.RED + "Sever Shutdown Initated...");
						
					} else if(i == 30) {
						Bukkit.broadcastMessage(ChatColor.GOLD + "Server Shuting down in 30 seconds...");
					} else if(i == 15) {
						Bukkit.broadcastMessage(ChatColor.GOLD + "Server Shuting down in 15 seconds");
					} else if(i == 10) {
						Bukkit.broadcastMessage(ChatColor.GOLD + "Server Shuting down 10 seconds");
					} else if(i == 5) {
						Bukkit.broadcastMessage(ChatColor.GOLD + "Server Shuting down in 4 Seconds");
					} else if(i == 4) {
						Bukkit.broadcastMessage(ChatColor.GOLD + "Server Shuting down in 3 seconds");
					} else if(i == 3) {
						Bukkit.broadcastMessage(ChatColor.GOLD + "Server Shuting down in 2 seconds");
					} else if(i == 2) {
						Bukkit.broadcastMessage(ChatColor.GOLD + "Server Shuting down in 1 second.");
					} else if(i == 1) {
						for(Player p : Bukkit.getOnlinePlayers()) {
							p.kickPlayer(ChatColor.GOLD + "Server Shuting down... Please Wait!");
						}
					} else if(i == 0) {
						Bukkit.spigot().restart();
					}
					
				}
			}, 0, 20);
		} 
		if(args[0].equalsIgnoreCase("now")) {
			for(Player p2 : Bukkit.getOnlinePlayers()) {
				p2.kickPlayer(ChatColor.GOLD + "Server Shuting down... We will be back soon!!");
			}
			Bukkit.spigot().restart();
		}
		
	}
	
	

}
