package sh.fyz.icalchecker.config;

import sh.fyz.icalchecker.Main;

public class BotConfig extends Config{

    public BotConfig() {
        loadInstance("config", Main.getBotName(), this);
    }

    @ConfigField
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
