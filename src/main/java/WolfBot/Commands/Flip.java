package WolfBot.Commands;

import WolfBot.Bot;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;

public class Flip extends Command {
    public Flip(Bot bot) {
        super(bot, "!flipcoin");
    }

    @Override
    public void call(Message message) {
        MessageChannel channel = message.getChannel();
        channel.sendMessage("Flipping coing... \n" +
                "It results in a " + Math.round(Math.random())).queue();
    }
}
