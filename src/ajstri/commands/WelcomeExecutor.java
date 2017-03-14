package ajstri.commands;

import ajstri.Data;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class WelcomeExecutor extends ListenerAdapter {
	
	public void onGuildMemberJoinEvent(GuildMemberJoinEvent event) {
		String m = event.getMember().getAsMention();
		event.getGuild().getTextChannelById(Data.welcomeID).sendMessage(m + "").queue();
	}
}
