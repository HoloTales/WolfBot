package WolfBot;

import WolfBot.Commands.Command;
import WolfBot.Commands.Flip;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private final Bot bot;
    private Map<String, Command> map;

    CommandManager(Bot bot) {
        this.bot = bot;
        map = new HashMap<>();
        initialize(map,
                new Flip(bot));
    }

    private void initialize(Map<String, Command> map, Command... commands) {
        for (Command c: commands) {
            map.put(c.getName(), c);
        }
    }

    public Command getCommand(String s) {
        return map.get(s);
    }
}
