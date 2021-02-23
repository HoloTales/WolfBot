package WolfBot.Commands;

import WolfBot.WolfBot;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.*;

public abstract class Command {
    protected final WolfBot wolfBot;
    protected List<String> name;
    protected String help;
    protected String description;

    public Command(WolfBot wolfBot, String name, String description) {
        this.name = new ArrayList<>();
        this.wolfBot = wolfBot;
        this.name.add(name);
        this.description = description;
    }

    public Command(WolfBot wolfBot, String name, String description, String... names) {
        this(wolfBot, name, description);
        this.name.addAll(Arrays.asList(names));
    }

    public List<String> getName() {
        return name;
    }

    public abstract void call(Message message, String[] args);
    protected abstract void createHelp();

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
                    throw new IllegalArgumentException("Improper Formatting");
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

    protected boolean levelChecker(int level) {
        if (level > wolfBot.modsUtil.getMaxLevel() || level < wolfBot.modsUtil.getMinLevel()) {
            throw new IllegalArgumentException("Level " + level + "is not a currently valid level.");
        }
        return true;
    }

    protected String aliasReader(String[] alias, Map<String, String> argMap) {
        String ret = null;
        for (String s: alias) {
            if (argMap.containsKey(s) && ret == null) {
                ret = argMap.get(s);
            } else if (argMap.containsKey(s) && ret != null) {
                throw new IllegalArgumentException("Duplicate Alias: " + s);
            }
        }
        return ret;
    }

    protected boolean statChecker(int stat) {
        return true;
    }
}
