package WolfBot.Commands;

import WolfBot.WolfBot;
import WolfBot.CommandManager;
import net.dv8tion.jda.api.entities.Message;

public class Help extends Command {
    private CommandManager manager;
    public Help(WolfBot wolfBot, CommandManager manager) {
        super(wolfBot, "Help", "Gets Help About Bot.");
        this.manager = manager;
        createHelp();
    }

    @Override
    public void call(Message message, String[] args) {
        StringBuilder helpMessage = new StringBuilder();
        if (args.length == 0) {
            //todo prefix
            helpMessage.append("The following is a list of commands with their descriptions. For aliases and more information do ").append(wolfBot.config.get("prefix")).append("help [command]");
            for (Command c : manager.getCommands()) {
                helpMessage.append("\n").append(c.getName().get(0)).append(" : ").append(c.description).append(".");
            }
        } else {
            Command curr = manager.getCommand(args[0]);
            if (curr == null) {
                helpMessage.append("Error: No command found");
            } else {
                helpMessage.append("Command: ").append(curr.getName().get(0)).append("\n");
                helpMessage.append("Description: ").append(description);
                helpMessage.append("\n");
                helpMessage.append("Alias': ");
                for (String s: curr.getName()) {
                    helpMessage.append(s.toLowerCase()).append(" ");
                }
                helpMessage.append("\nHow to use:\n");
                helpMessage.append(curr.help);
            }
        }
        send(message, helpMessage.toString());
    }

    @Override
    protected void createHelp() {
        StringBuilder stringBuilder = new StringBuilder();

        //todo prefix
        stringBuilder.append(">>help\n");
        stringBuilder.append(">>help [command]");
        help = stringBuilder.toString();
    }
}
