package WolfBot;

import Util.ConfigReader;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;
import java.nio.file.Path;

public class Bot {
    //Logger logger;
    public static final ConfigReader config = new ConfigReader("config.txt");

    Bot(String[] args) {
        String BOT_TOKEN = config.get("token");
        try {
            System.out.println(BOT_TOKEN);
            JDA jda = JDABuilder.createDefault(BOT_TOKEN).build();
            jda.addEventListener(new MessageListener(this));
        } catch (LoginException e) {
            log(e.getMessage());
        }
    }
    public void log(String message) {
        System.out.println(message);
    }
}
