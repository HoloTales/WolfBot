package WolfBot;

import Util.ConfigReader;
import Util.ModsUtil;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class WolfBot {
    //Logger logger;
    private final JDA jda;
    public final ConfigReader config = new ConfigReader("config.txt");
    public final ModsUtil modsUtil = new ModsUtil();


    public static void main(String[] args) {
        try {
            WolfBot wolfBot = new WolfBot(args);
        } catch (Exception e) {
            System.out.println("guess i'll crash \\-.-/");
        }
    }

    WolfBot(String[] args) throws LoginException{
        String BOT_TOKEN = config.get("token");
        jda = JDABuilder.createDefault(BOT_TOKEN).build();
        jda.addEventListener(new MessageListener(this));
    }
    public void log(String message) {
        System.out.println(message);
    }
}
