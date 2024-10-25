package sh.fyz.icalchecker.events;

import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import sh.fyz.icalchecker.Main;

public class ReadyListener extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        System.out.println("Hello World");
        Main.getJDA().getTextChannelById("1298659145582641244").sendMessage("Donnez moi dla carte graphique dla clé usb").queue();
    }
}
