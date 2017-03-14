package ajstri;

import java.util.HashMap;

import ajstri.Data;
import ajstri.commands.Command;
import ajstri.commands.CommandExecutor;
import ajstri.commands.WelcomeExecutor;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

public class Main {
	public static JDA api;
	public static String id;
	public static HashMap<String, Command> cmds = new HashMap<String, Command>();
	
	public static void main(String[] args) {
		try {
			api = new JDABuilder(AccountType.BOT).setToken(Data.TOKEN).buildBlocking();
			api.getPresence().setGame(Game.of("/info to begin."));
			api.addEventListener(new CommandExecutor());
			api.addEventListener(new WelcomeExecutor());
			api.setAutoReconnect(true);
			id = api.getSelfUser().getId();
		} 
		catch(Exception e) {
		}
		//cmds.put("name", new CommandName());
	}
}
