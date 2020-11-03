package WolfBot.Commands;

import WolfBot.WolfBot;
import net.dv8tion.jda.api.entities.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Command {
    protected final WolfBot wolfBot;
    protected List<String> name;

    public Command(WolfBot wolfBot, String name) {
        this.name = new ArrayList<>();
        this.wolfBot = wolfBot;
        this.name.add(name);
    }

    public Command(WolfBot wolfBot, String name, String... names) {
        this.name = new ArrayList<>();
        this.wolfBot = wolfBot;
        this.name.add(name);
        this.name.addAll(Arrays.asList(names));
    }

    public List<String> getName() {
        return name;
    }

    public abstract void call(Message message, String[] args);
}
