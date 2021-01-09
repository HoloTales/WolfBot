package WolfBot.Commands;

import WolfBot.WolfBot;
import net.dv8tion.jda.api.entities.Message;

import java.util.HashMap;
import java.util.Map;

public class DirectHit extends Command {
    String[] levelAlias = new String[] {"lv", "lvl", "l"};

    public DirectHit(WolfBot wolfBot) {
        super(wolfBot, "directhitrate", "dhr", "dh", "directhit");
        description = "Calculates Direct Hit Rate";
        createHelp();
    }

    @Override
    protected void createHelp() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(description);
        stringBuilder.append("\n");
        stringBuilder.append("Alias' for this command: ");
        for (String s: name) {
            stringBuilder.append(s);
        }

        stringBuilder.append("\nHow to use:\n");
        //todo prefix
        stringBuilder.append(">dhr [direct hit] (level)");
        stringBuilder.append("\nPolymorphic Parameters:\n");
        stringBuilder.append("DH:[direct hit]  LVL:[level]");


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
            //if another arg exists try that
            if (args.length > 1) {
                try {
                    dhValue = Integer.parseInt(args[1]);
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
            for (String s: dhAlias) {
                if (argMap.containsKey(s) && dhValue == -1) {
                    dhValue = Integer.parseInt(argMap.get(s));
                } else if (argMap.containsKey(s) && dhValue != -1) {
                    //error here
                }
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
