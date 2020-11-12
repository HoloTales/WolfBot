package WolfBot.Commands;

import WolfBot.WolfBot;
import net.dv8tion.jda.api.entities.Message;

public class DirectHit extends Command {
    public DirectHit(WolfBot wolfBot) {
        super(wolfBot, "directhitrate", "dhr");
        help = "Calculates direct hit.";
    }

    //https://allaganstudies.akhmorning.com/guide/parameters/
    private double calculateDhr(int dhValue, Integer lvValue) {
        return wolfBot.parametersCalc.calculateDhr(dhValue, lvValue);
    }

    //todo args
    @Override
    public void call(Message message, String[] args) {
        Integer dhValue = Integer.parseInt(args[0]);
        double end = calculateDhr(dhValue, 80);
        send(message, "Probability of Direct Hit= " + end + "%");
    }
}
