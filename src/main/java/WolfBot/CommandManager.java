package WolfBot;

import WolfBot.Commands.Command;
import WolfBot.Commands.DirectHit;
import WolfBot.Commands.Flip;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandManager {
    private final WolfBot wolfBot;
    private Map<String, Command> map;

    CommandManager(WolfBot wolfBot) {
        this.wolfBot = wolfBot;
        map = new HashMap<>();
        initialize(map,
                new Flip(wolfBot),
                new DirectHit(wolfBot));
    }

    private void initialize(Map<String, Command> map, Command... commands) {
        for (Command c: commands) {
            List<String> names = c.getName();
            for (String name: names) {
                map.put(name, c);
            }
        }
        System.out.println("Command Manager Initialized");
    }

    public Command getCommand(String s) {
        return map.get(s.toLowerCase());
    }
}
