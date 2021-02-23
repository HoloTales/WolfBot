package WolfBot;

import Util.ConfigReader;
import Util.ModsUtil;
import Util.ParametersCalc;
import Util.RandomClient;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class WolfBot {
    //Logger logger;
    public final JDA jda;
    public final ConfigReader config;
    public final ModsUtil modsUtil;
    public final ParametersCalc parametersCalc;
    public final RandomClient randomClient;

    public static void main(String[] args) {
        try {
            WolfBot wolfBot = new WolfBot(args);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("guess i'll crash \\-.-/");
        }
    }

    WolfBot(String[] args) throws LoginException{
        this.config = new ConfigReader("config.txt");
        String BOT_TOKEN = config.get("token");
        jda = JDABuilder.createDefault(BOT_TOKEN).build();
        jda.addEventListener(new MessageListener(this));
        this.modsUtil = new ModsUtil();
        this.parametersCalc = new ParametersCalc(modsUtil);
        this.randomClient = new RandomClient(config.get("randomapi"));
        //System.out.println(Arrays.toString(randomClient.generateTeamInts()));
    }

    public void log(String message) {
        System.out.println(message);
    }
}
