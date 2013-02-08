package DarkBytes.SurvivalGames;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Validater
{
	public boolean isValid(String input)
	{
		if ((input != null) && (input != ""))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isPlayer(CommandSender sender)
	{
		if (sender instanceof Player) { return true; } else { return false; }
	}
}
