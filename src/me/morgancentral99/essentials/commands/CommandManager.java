package me.morgancentral99.essentials.commands;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.morgancentral99.essentials.commands.Player.FeedCommand;
import me.morgancentral99.essentials.commands.Player.Gamemode;
import me.morgancentral99.essentials.commands.Server.RestartCommand;
import me.morgancentral99.essentials.commands.Server.StopCommand;
import me.morgancentral99.essentials.commands.Server.Weather;
import net.md_5.bungee.api.ChatColor;

public class CommandManager implements CommandExecutor {
	
	private String name;
	private String usage;
	private HashMap<ArrayList<String>, SCommand> commandAlias = new HashMap<>();
	private int minArgs = 0;
	Player p;
	
	public void onLoad() {
		new EssentialsCore();
		new FeedCommand();
		new Gamemode();
		new RestartCommand();
		new StopCommand();
		new Weather();

	}
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {

			if(getCommandAlias().containsKey(label)) {
				SCommand commandExecute = getCommandAlias().get(label);
				if(checkPermissions(s, commandExecute)) {
				if(args.length > minArgs) {
					if(!(s instanceof Player)) {
						p = Bukkit.getPlayer("SEConsoleUser");
					} else if(s instanceof Player) {
						p = (Player)s;
					}
				
				commandExecute.execute(s, p, args);
				return true;
			 }
				s.sendMessage(ChatColor.GOLD + "Not Enough Args");
				}
			
			}
		return false;
	}
	
	public boolean checkPermissions(CommandSender s, SCommand command) {
		for(int i = 0; i < command.getPermissions().size(); i++) {
			if(s.hasPermission(command.getPermissions().get(i))) {
				return true;
			}
		}
		s.sendMessage(ChatColor.RED + "No Permissions...");
		return false;
	}
/*	private ServerEssentials instance = ServerEssentials.getInstance();
	public HashMap<String, SCommand> commandClasses = new HashMap<>();
	//Name -> Permission
	private HashMap<String, String> commandPermissions = new HashMap<>();
	private static CommandMap cmap;
	private final Command adapted;
	public void onLoad() {
	
		new EssentialsCore().register();
		new FeedCommand().register();
		new Gamemode().register();
		new RestartCommand().register();
		new StopCommand().register();
		new Weather().register();
	}
	
	public void register(@Nonnull SCommand comm) {
		
		
	}
	
/*	public void register(ArrayList<String> alias, String Maincommand, SCommand c, String Permissions) {
		c.Commands = alias;
		commandClasses.put(c.getName(), c);
		commandPermissions.put(c.getName(), Permissions);
		for(int i = 0; i < alias.size(); i++) {
			if(i != alias.size()) {
				System.out.println(alias.get(i));
				Command command = c;
				cmap.register("", command);
			}
		}
		instance.getCommand(Maincommand).setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
		if(commandClasses.containsKey(label)) {
			if(sender.hasPermission(commandPermissions.get(label))) {
				SCommand commands = commandClasses.get(label);
				commands.execute(sender, args);
			}
			sender.sendMessage("No Permissions for " + label);
		}
		sender.sendMessage("No Command Registered");
		return false;
	}
	

	

*/

	/**
	 * @return the commandAlias
	 */
	public HashMap<ArrayList<String>, SCommand> getCommandAlias() {
		return commandAlias;
	}


}
