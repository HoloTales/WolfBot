package WolfBot.Commands;

import WolfBot.WolfBot;
import net.dv8tion.jda.api.entities.Message;

public class Teams extends Command {
    public Teams(WolfBot wolfBot) {
        super(wolfBot, "teams", "teamsetup", "team");
        help = "Sets up some teams";
    }

    @Override
    public void call(Message message, String[] args) {

    }

    @Override
    protected void createHelp() {

    }
}
