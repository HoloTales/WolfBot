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
    private double calculateDh(String value) {
        double entry = Double.parseDouble(value);
        double end = (550*(entry-380)/3300)/10;
        return end;
    }
    @Override
    public void call(Message message, String[] args) {
        double end = calculateDh(args[0]);
        send(message, "Probability = " + end);
    }
}
