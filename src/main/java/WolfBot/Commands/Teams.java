package WolfBot.Commands;

import WolfBot.WolfBot;
import net.dv8tion.jda.api.entities.Message;

public class Teams extends Command {
    public Teams(WolfBot wolfBot) {
        super(wolfBot, "teams","Randomly generate teams for inhouse LoL.", "teamsetup", "team");
        createHelp();
    }

    @Override
    public void call(Message message, String[] args) {
        if (args.length == 10) {
            int[] teams = wolfBot.randomClient.generateTeamInts();
            StringBuilder string = new StringBuilder();
            string.append("The teams are as follows:\n");
            StringBuilder team1 = new StringBuilder("Team 1:\n");
            StringBuilder team2 = new StringBuilder("Team 2:\n");
            for (int i = 0; i < (args.length/2); i++) {
                team1.append(args[teams[i]]).append("\n");
                team2.append(args[teams[i+5]]).append("\n");
            }
            string.append(team1).append("\n").append(team2);
            send(message, string.toString());
        }
    }

    @Override
    protected void createHelp() {
        StringBuilder stringBuilder = new StringBuilder();

        //todo prefix
        stringBuilder.append("Basic Params:\n");
        stringBuilder.append(">>teams [name1] [name2] [name3] [name4] [name5] [name6] [name7] [name8] [name9] [name10]\n");
        help = stringBuilder.toString();

    }
}
