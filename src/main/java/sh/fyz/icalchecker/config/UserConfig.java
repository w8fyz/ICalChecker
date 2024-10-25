package sh.fyz.icalchecker.config;

import sh.fyz.icalchecker.Main;

public class UserConfig extends Config{

    @ConfigField
    private 

    public UserConfig(String uuid) {
        loadInstance("users/"+uuid, Main.getBotName(), this);
    }
}
