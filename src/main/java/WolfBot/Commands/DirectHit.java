package WolfBot.Commands;

import WolfBot.WolfBot;
import net.dv8tion.jda.api.entities.Message;

import java.util.HashMap;
import java.util.Map;

public class DirectHit extends Command {
    String[] levelAlias = new String[] {"lv", "lvl", "l"};

    public DirectHit(WolfBot wolfBot) {
        super(wolfBot, "dhr", "Calculates Direct Hit Rate", "directhitrate", "dh", "directhit");
        createHelp();
    }

    @Override
    protected void createHelp() {
        StringBuilder stringBuilder = new StringBuilder();

        //todo prefix
        stringBuilder.append("Basic Params:\n");
        stringBuilder.append(">dhr [direct hit] (level)");
        stringBuilder.append("\nPolymorphic Parameters:\n");
        stringBuilder.append("DH:[direct hit]  [LVL/L/lv]:[level]");
        help = stringBuilder.toString();

    }

    //https://allaganstudies.akhmorning.com/guide/parameters/
    private double calculateDhr(int dhValue, Integer lvValue) {
        return wolfBot.parametersCalc.calculateDhr(dhValue, lvValue);
    }

    //todo certain args (ex. LV:60 DH:1200)
    @Override
    public void call(Message message, String[] args) {
        if (args.length < 1) return;
        Integer dhValue = -1;
        Integer level = -1;
        String messageStr = "";
        Map<String, String> argMap = splitArgs(args);

        String[] levelAlias = new String[] {"lv", "lvl", "l"};
        String[] dhAlias = new String[] {"dh"};

        if (argMap.containsKey("none")) {
            //if no args are special formatted, go to normal format
            //level solver
            if (args.length > 1) {
                try {
                    level = Integer.parseInt(args[1]);
                    System.out.println(level);
                } catch (NumberFormatException e) {
                    messageStr = "Invalid Direct Hit Value.";
                    send(message, messageStr);
                    return;
                }
                //if no more args exist then its just 80 as it is max level
            } else {
                level = 80;
            }
            //dh solver
            try {
                dhValue = Integer.parseInt(args[0]);
                System.out.println(dhValue);
            } catch (NumberFormatException e) {
                //todo add some more checks
                messageStr = "Invalid Direct Hit Value.";
                send(message, messageStr);
                return;
            }
        } else {
            //if args exist then do special formatting
            String levelAliass = aliasReader(levelAlias, argMap);
            if (levelAliass != null) {
                try {
                    level = Integer.parseInt(levelAliass);
                } catch (NumberFormatException e) {
                    //todo error goes here
                }
            } else {
                level = 80;
            }

            String dh = aliasReader(dhAlias, argMap);
            if (dh != null) {
                try {
                    dhValue = Integer.parseInt(dh);
                } catch (NumberFormatException e) {
                    //todo error goes here
                }
            } else {
                //todo error goes here
            }

        }
        double end = calculateDhr(dhValue, level);
        send(message, "Level: " + level + ". Direct Hit: " + dhValue + ".\n" +
                "Direct Hit Probability: " + end + "%");
    }
}
