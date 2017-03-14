package ajstri.commands.music;

//import java.util.Arrays;
import java.util.List;
//import java.util.stream.Collectors;

import ajstri.Permission;
import ajstri.commands.Command;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class JoinCommand implements Command {

	@Override
	public void execute(MessageReceivedEvent e, String[] args) {
		VoiceChannel targetChannel = null;
		Member m = e.getMember();
		if(args.length == 1) {
			if(m.getVoiceState().inVoiceChannel()) {
				targetChannel = m.getVoiceState().getChannel();
				e.getGuild().getAudioManager().openAudioConnection(targetChannel);
			}
			else {
				//lol u not in channel
			}
		}
		else if(args.length == 2) {
			//String voice = Arrays.stream(args).collect(Collectors.joining(" ")).replace(args[0]+" ", "");
			List<VoiceChannel> channels = e.getGuild().getVoiceChannels();
			if(channels.contains(args[1])) {
				VoiceChannel channel = e.getGuild().getVoiceChannelById(args[1]);
				e.getGuild().getAudioManager().openAudioConnection(channel);
			}
			else {
				//lol that not a channel
			}
		}
	}

	@Override
	public Permission getValidExecutors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
