package WolfBot.Commands;

import WolfBot.WolfBot;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;

public class Flip extends Command {
    public Flip(WolfBot wolfBot) {
        super(wolfBot, "Flip", "Flips a Coin!", "fc", "flipcoin", "coinflip", "coin", "cf");
        help = "Flips a coin.";
    }

    @Override
    protected void createHelp() {
        //
    }

    private String flip() {
        long i = Math.round(Math.random());
        if (i == 0) {
            return "Heads";
        } else if (i == 1) {
            return "Tails";
        } else {
            return "bruh math broke lmao";
        }

    }

    @Override
    public void call(Message message, String[] args) {
        send(message, flip() + "!");
    }
}
