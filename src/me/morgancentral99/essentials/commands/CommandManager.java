package me.morgancentral99.essentials.commands;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.morgancentral99.essentials.ServerEssentials;
import me.morgancentral99.essentials.commands.Player.FeedCommand;
import me.morgancentral99.essentials.commands.Player.Gamemode;

public class CommandManager implements CommandExecutor{
	private ServerEssentials instance = ServerEssentials.getInstance();
	public HashMap<String, Command> commandClasses = new HashMap<>();
	//Name -> Permission
	private HashMap<String, String> commandPermissions = new HashMap<>();
	
	public void addCommands() {
		new EssentialsCore().register();
		new FeedCommand().register();
		new Gamemode().register();
	}
	
	
	public void register(String name, ArrayList<String> alias, String Maincommand, Command c, String Permissions) {
		c.Commands = alias;
		commandClasses.put(name, c);
		commandPermissions.put(name, Permissions);
		for(int i = 0; i < alias.size(); i++) {
			instance.getCommand(alias.get(i)).setExecutor(this);
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
		if(commandClasses.containsKey(label)) {
			if(sender.hasPermission(commandPermissions.get(label))) {
				Command commands = commandClasses.get(label);
				commands.execute(sender, args);
			}
			sender.sendMessage("No Permissions for " + label);
		}
		sender.sendMessage("No Command Registered");
		return false;
	}
	


}
