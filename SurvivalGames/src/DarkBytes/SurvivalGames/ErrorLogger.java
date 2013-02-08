package DarkBytes.SurvivalGames;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ErrorLogger
{
	static File errorlog = new File("error.log");
	
	public void log(String error)
	{
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(errorlog));
			writer.append(error);
			writer.close();
		}
		catch (Exception ex)
		{
			log(ex.getMessage());
		}
	}
}
