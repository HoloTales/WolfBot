package Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Todo: add implementation of shard configs
 */
public class ConfigReader {
    HashMap<String, String> hashmap = new HashMap<>();

    /**
     *
     * @param filePath
     */
    public ConfigReader(String filePath) {
        File file = new File(filePath);
        try (Scanner in = new Scanner(file)) {
            while (in.hasNextLine()) {
                String s = in.nextLine();
                String[] splitLine = s.split("=");
                String line2 = splitLine[1].replace("\"", "");
                hashmap.put(splitLine[0], line2);
            }
            System.out.println("Config Reader Initialized.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String get(String key) {
        return hashmap.get(key);
    }
}
