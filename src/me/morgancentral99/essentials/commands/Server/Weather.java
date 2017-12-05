package me.morgancentral99.essentials.commands.Server;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.morgancentral99.essentials.commands.SCommand;

public class Weather extends SCommand {

	public Weather() {
		ArrayList<String> alias = new ArrayList<>();
		alias.add("Toggledownfall");
		alias.add("Weather");
		name = "WeatherCommand";
		this.alias = alias;
		usage = "/weather";
		comm = this;
		permissions.add("ServerEssentials.weather");
	}


	@Override
	public void execute(CommandSender s, Player p, String[] args) {
		if(args.length == 0) {
			p.getWorld().setWeatherDuration(0);
		}
		if(args[0].equalsIgnoreCase("sun")) {
			p.getWorld().setWeatherDuration(0);
		}
	}

}
