package WolfBot;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        Message message = event.getMessage();
        String content = message.getContentRaw();
        String prefix = Bot.config.get("prefix");
        if (content.substring(0,prefix.length()).equals(prefix)) {
            String sub = content.replace(prefix, "");
            if (sub.equals("ping") || sub.equals("pong")) {
                MessageChannel channel = event.getChannel();
                channel.sendMessage("Pong!").queue();
            }
        }
    }
}
