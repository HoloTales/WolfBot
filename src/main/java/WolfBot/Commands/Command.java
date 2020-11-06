package WolfBot.Commands;

import WolfBot.WolfBot;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.*;

public abstract class Command {
    protected final WolfBot wolfBot;
    protected List<String> name;
    protected String help;

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

    protected void send(Message origination, String sendMessage) {
        MessageChannel channel = origination.getChannel();
        channel.sendMessage(sendMessage).queue();
    }

    protected Map<String, String> splitArgs(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String s: args) {
            if (s.contains(":")) {
                String[] split = s.split(":");
                if (split.length > 2) {
                    throw new IllegalArgumentException("SUn?");
                } else {
                    hashMap.put(split[0], split[1]);
                }
            } else {
                if (!hashMap.containsKey("none")) {
                    hashMap.put("none", s);
                }
            }
        }
        return hashMap;
    }
}
