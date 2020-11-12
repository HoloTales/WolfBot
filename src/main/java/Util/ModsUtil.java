package Util;

import Util.ModsHolder.LevelMods;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ModsUtil {
    List<LevelMods> levelModsList;
    HashMap<Integer, LevelMods> levelModsHashMap;

    public ModsUtil() {
        levelModsList = new ArrayList<>();
        levelModsHashMap = new HashMap<>();
        generateLevelMods(levelModsList);
        System.out.println("Mods Util Initialized.");
    }

    public int getLevelSub(int level) {
        LevelMods levelMods = levelModsHashMap.get(level);
        return levelMods.getSub();
    }

    public int getLevelDiv(int level) {
        return levelModsHashMap.get(level).getDiv();
    }

    private void generateLevelMods(List<LevelMods> levelModsList) {
        List<HashMap<String, String>> hashMapList;
        Integer level = -1;
        try {
            hashMapList = CSVUtil.getHashList(new File("knowledgedb/levelmods.csv"));
            for (HashMap<String, String> hashMap: hashMapList) {
                level = Integer.parseInt(hashMap.get("LV"));
                LevelMods levelMod = new LevelMods(hashMap);
                levelModsHashMap.put(level, levelMod);
                levelModsList.add(levelMod);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error at levelmods level: " + level);
        }  catch (FileNotFoundException e) {
            System.out.println("Error in levelmods: FileNotFound");
        }
    }


    public Integer getMaxLevel() {
        return 80;
    }

    public Integer getMinLevel() {
        return 1;
    }
}
