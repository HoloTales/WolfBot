package WolfBot.Commands;

import WolfBot.WolfBot;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import net.dv8tion.jda.api.entities.Message;

public class Play extends Command {
    public Play(WolfBot wolfBot) {
        super(wolfBot, "Play", "Plays a song on da music bot.", "p");
        AudioPlayerManager playerManager = new DefaultAudioPlayerManager();
        AudioSourceManagers.registerRemoteSources(playerManager);
    }

    @Override
    public void call(Message message, String[] args) {

    }

    @Override
    protected void createHelp() {

    }
}
