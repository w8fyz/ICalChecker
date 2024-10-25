package sh.fyz.icalchecker;

import com.google.common.base.Throwables;
import com.google.gson.Gson;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import sh.fyz.icalchecker.config.BotConfig;
import sh.fyz.icalchecker.events.ReadyListener;
import sh.fyz.icalchecker.utils.Logs;

import javax.security.auth.login.LoginException;

public class Main {

    private static JDA jda;
    private static BotConfig config;
    private static Gson gson = new Gson();
    private static long BOT_UPTIME;

    public static long getBotUptime() {
        return BOT_UPTIME;
    }

    public static String getBotName() {
        return "ICalChecker";
    }

    public static Gson getGson() {
        return gson;
    }

    public static JDA getJDA() {
        return jda;
    }

    public static void main(String args[]) {
        config = new BotConfig();
        BOT_UPTIME = System.currentTimeMillis();
        jda = JDABuilder.createDefault(config.getToken())
                .addEventListeners(new ReadyListener()).build();
    }

}
