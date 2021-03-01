package WolfBot;

import WolfBot.Commands.*;

import java.util.*;

public class CommandManager {
    private final WolfBot wolfBot;
    private Map<String, Command> map;
    private List<Command> list;

    CommandManager(WolfBot wolfBot) {
        this.wolfBot = wolfBot;
        map = new HashMap<>();
        list = new LinkedList<>();
        initialize(
                new Help(wolfBot, this),
                new Flip(wolfBot),
                new DirectHit(wolfBot),
                new Teams(wolfBot));
    }

    private void initialize(Command... commands) {
        for (Command c: commands) {
            list.add(c);
            List<String> names = c.getName();
            for (String name: names) {
                map.put(name.toLowerCase(), c);
            }
        }
        System.out.println("Command Manager Initialized");
    }

    public List<Command> getCommands() {
        return list;
    }

    public Command getCommand(String s) {
        return map.get(s.toLowerCase());
    }
}
