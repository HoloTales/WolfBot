package WolfBot;

import WolfBot.Commands.Command;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageListener extends ListenerAdapter {
    CommandManager commandManager;
    Pattern prefix;
    WolfBot wolfBot;

    MessageListener(WolfBot wolfBot) {
        commandManager = new CommandManager(wolfBot);
        prefix = Pattern.compile(wolfBot.config.get("prefix"));
        this.wolfBot = wolfBot;
        System.out.println("Message Listener Initialized");
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot() || event.getAuthor().getId().equals(wolfBot.jda.getSelfUser().getId())) return;

        Message message = event.getMessage();
        String messageString = message.getContentRaw();
        Matcher matcher = prefix.matcher(messageString);
        if(!matcher.find()) return;
        messageString = matcher.replaceFirst("");
        String[] messageParts = messageString.split("\\s+");
        Command c = commandManager.getCommand(messageParts[0]);
        if (c == null) return;
        String[] args = new String[messageParts.length-1];
        for (int i = 1; i <= args.length; i++) {
            args[i-1] = messageParts[i];
        }
        c.call(message, args);
    }
}
