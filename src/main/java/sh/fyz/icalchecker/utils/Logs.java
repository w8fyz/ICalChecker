package sh.fyz.icalchecker.utils;

import sh.fyz.icalchecker.Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logs {


    public static void createLogFile() {
        new File(Main.getBotName() + "/logs/").mkdirs();
        File f = getActualLogFile();
        if (!f.exists())
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private static File getActualLogFile() {
        File file = new File(Main.getBotName() + "/logs/" + Main.getBotUptime() + ".txt");
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    private static void writeToLogs(String line) {
        try (BufferedWriter writer = Files.newBufferedWriter(getActualLogFile().toPath(), StandardCharsets.UTF_8,
                StandardOpenOption.APPEND)) {
            writer.append(line + System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String date() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }

    public static void info(String info) {
        String line = "[" + date() + "][INFO]: " + info;
        System.out.println(line);
        writeToLogs(line);
    }

    public static void warn(String warn) {
        String line = "[" + date() + "][WARN]: " + warn;
        System.out.println(line);
        writeToLogs(line);
    }

    public static void error(String error) {
        String line = "[" + date() + "][ERROR]: " + error;
        System.out.println(line);
        writeToLogs(line);
    }

}
