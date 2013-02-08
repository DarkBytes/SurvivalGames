package DarkBytes.SurvivalGames.Handlers;

import DarkBytes.SurvivalGames.Commands.DonatorCommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CommandListener implements Listener
{
	DonatorCommand donatorCommand = new DonatorCommand();
	
	@EventHandler
	public boolean onCommand(CommandSender sender, Command command, String alias, String[] args)
	{
		switch (command.getName())
		{
		case "donator":
			donatorCommand.performCommand(sender, args);
			return true;
			
		default: return false;
		}
	}
}
