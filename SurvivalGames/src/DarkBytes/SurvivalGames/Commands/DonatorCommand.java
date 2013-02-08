package DarkBytes.SurvivalGames.Commands;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import DarkBytes.SurvivalGames.CommonMessages;
import DarkBytes.SurvivalGames.ErrorLogger;
import DarkBytes.SurvivalGames.Validater;

import org.bukkit.command.CommandSender;

public class DonatorCommand
{
	private File donatorsFile = new File("SurvivalGames\\donators.txt");
	
	Validater Validater = new Validater();
	CommonMessages messages = new CommonMessages();
	ErrorLogger ErrorLogger = new ErrorLogger();
	
	List<String> donators;
	
	private boolean isDonator(CommandSender sender, String target)
	{
		for (int i = 0; i < donators.size(); i++)
		{
			if (donators.get(i) == target) { return true; }
		}
		return false;
	}
	
	public void loadDonators()
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(donatorsFile));
			donators.clear();
			String line = null;
			while ((line = reader.readLine()) != null) { donators.add(line); }
			reader.close();
		}
		catch (Exception ex)
		{
			ErrorLogger.log(ex.getMessage());
		}
	}
	
	public void saveDonators()
	{
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(donatorsFile));
			for (int i = 0; i < donators.size(); i++) { writer.write(donators.get(i)); }
			writer.close();
		}
		catch (Exception ex)
		{
			ErrorLogger.log(ex.getMessage());
		}
	}
	
	private void toggleDonator(CommandSender sender, String target)
	{
		if (isDonator(sender, target) == true)
		{
			for (int i = 0; i < donators.size(); i++)
			{
				if (donators.get(i) == target) { donators.remove(i); }
			}
		}
		else
		{
			donators.add(target);
		}
		saveDonators();
	}
	
	public void performCommand(CommandSender sender, String[] args)
	{
		String mode = args[0];
		String target = args[1];
		
		// Checks if the command is valid
		if ((Validater.isValid(target) == false) && (Validater.isPlayer(sender) == false))
		{
			sender.sendMessage(messages.wrongSyntax);
			return;
		}
		if (Validater.isValid(target) == false) { target = sender.getName(); }
		if ((Validater.isPlayer(sender)) && sender.hasPermission("survivalgames.donator"));
		
		//Performs the command
		switch (mode)
		{
		case "check":
			if (isDonator(sender, target) == true)
			{ sender.sendMessage(messages.donator_yes(target)); }
			else
			{ sender.sendMessage(messages.donator_no(target)); }
			break;
			
		case "toggle":
			toggleDonator(sender, target);
			break;
			
		default:
			sender.sendMessage(messages.wrongSyntax);
			return;
		}
	}
}
