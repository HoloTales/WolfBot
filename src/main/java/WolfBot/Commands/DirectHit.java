package WolfBot.Commands;

import WolfBot.WolfBot;
import net.dv8tion.jda.api.entities.Message;

public class DirectHit extends Command {
    public DirectHit(WolfBot wolfBot) {
        super(wolfBot, "directhitrate", "dhr");
        help = "Calculates direct hit.\n";
    }

    //https://allaganstudies.akhmorning.com/guide/parameters/
    private double calculateDhr(int dhValue, Integer lvValue) {
        return wolfBot.parametersCalc.calculateDhr(dhValue, lvValue);
    }

    //todo certain args (ex. LV:60 DH:1200)
    @Override
    public void call(Message message, String[] args) {
        Integer dhValue;
        Integer level = 80;
        String messageStr = "";
        try {
            dhValue = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            messageStr = "Invalid Direct Hit Value.";
            send(message, messageStr);
            return;
        }
        if (args.length > 1) {
            try {
                level = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                messageStr = "Invalid Level Value.";
                send(message, messageStr);
                return;
            }
        }
        if (level > wolfBot.modsUtil.getMaxLevel() || level < wolfBot.modsUtil.getMinLevel()) {
            messageStr = "Level is Out of Range: " + level +".\n" +
                    "Range is above " + wolfBot.modsUtil.getMinLevel() + " and below " + wolfBot.modsUtil.getMaxLevel();
            send(message, messageStr);
            return;
        }
        if (dhValue < wolfBot.modsUtil.getLevelSub(level)) {
            messageStr = "Direct Hit Value Out of Range for Level " + level +".\n" +
                    "Range is above " + wolfBot.modsUtil.getLevelSub(level);
            send(message, messageStr);
            return;
        }
        double end = calculateDhr(dhValue, level);
        send(message, "Probability of Direct Hit= " + end + "%");
    }
}
