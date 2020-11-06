package WolfBot.Commands;

import WolfBot.WolfBot;
import net.dv8tion.jda.api.entities.Message;

public class DirectHit extends Command {
    public DirectHit(WolfBot wolfBot) {
        super(wolfBot, "directhit", "dh");
        help = "Calculates direct hit.";
    }

    //https://allaganstudies.akhmorning.com/guide/parameters/
    //todo check if is a valid int
    //todo level, sub
    //todo level, div
    private double calculateDh(int dhValue, Integer lvValue) {
        double directHit = Double.parseDouble(String.valueOf(dhValue));
        double end = (55*(directHit-380)/3300);
        return end;
    }
    @Override
    public void call(Message message, String[] args) {
        Integer dhValue =
        double end = calculateDh(args[0]);
        send(message, "Probability = " + end);
    }
}
