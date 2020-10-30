package WolfBot.Commands;

import WolfBot.Bot;
import net.dv8tion.jda.api.entities.Invite;
import net.dv8tion.jda.api.entities.Message;

public abstract class Command {
    protected final Bot bot;
    protected String name;

    //todo add support for more variations
    public Command(Bot bot, String name) {
        this.bot = bot;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void call(Message message);
}
