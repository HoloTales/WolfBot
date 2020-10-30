package WolfBot;

import WolfBot.Commands.Command;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {
    CommandManager commandManager;

    MessageListener(Bot bot) {
        commandManager = new CommandManager(bot);
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        Message message = event.getMessage();
        String messagea = message.getContentRaw();
        Command c = commandManager.getCommand(messagea);
        c.call(message);
    }
}
