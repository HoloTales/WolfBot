package WolfBot.Commands;

import WolfBot.WolfBot;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;

public class Generate extends Command {
    public Generate(WolfBot wolfBot) {
        super(wolfBot, "generate");
    }

    @Override
    public void call(Message message, String[] args) {
        if (args.length < 2) {
            message.getChannel().sendMessage("Invalid Usage").queue();
        } else {
            String firstArg = args[0];
            if (firstArg.equalsIgnoreCase("save")) {
                boolean complete = generateSave(args[1]);
            } else if (firstArg.equalsIgnoreCase("remove") || firstArg.equalsIgnoreCase("rm")) {
                boolean complete = generateRemove(args[1]);
            } else if (firstArg.equalsIgnoreCase("list")) {
                boolean complete = generateList(args[1]);
            }
        }
    }

    @Override
    protected void createHelp() {

    }

    private boolean generateSave(String string) {
        return false;
    }

    private boolean generateList(String string) {
        return false;
    }

    private boolean generateRemove(String string) {
        return false;

    }

    private boolean generateAct(String string) {
        return false;

    }
}
