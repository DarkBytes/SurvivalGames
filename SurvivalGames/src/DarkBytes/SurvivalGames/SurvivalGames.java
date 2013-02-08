package DarkBytes.SurvivalGames;

import DarkBytes.SurvivalGames.Handlers.CommandListener;
import DarkBytes.SurvivalGames.Handlers.LoginListener;
import DarkBytes.SurvivalGames.Commands.DonatorCommand;

import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class SurvivalGames extends JavaPlugin
{
	CommandListener cmdHandler = new CommandListener();
	LoginListener loginHandler = new LoginListener();
	DonatorCommand DonatorCommand = new DonatorCommand();
	
	@Override
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(cmdHandler, this);
		getServer().getPluginManager().registerEvents(loginHandler, this);
		DonatorCommand.loadDonators();
		
		getLogger().info("SurvivalGames plugin by AssassinsMod Enabled!");		
	}
	
	@Override
	public void onDisable()
	{
		HandlerList.unregisterAll(this);
		DonatorCommand.saveDonators();

		getLogger().info("SurvivalGames plugin by AssassinsMod Disabled!");
	}
}
