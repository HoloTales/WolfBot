package Util.ModsHolder;

import java.util.HashMap;

public class LevelMods extends Mods {
    private final int level;
    private final int mp;
    private final int main;
    private final int sub;
    private final int div;
    private final int hp;
    private final int elmt;
    private final int threat;

    public LevelMods(HashMap<String, String> hashMap) throws NumberFormatException {
        this.level = parseInt(hashMap.get("LV"));
        this.mp = parseInt(hashMap.get("MP"));
        this.main = parseInt(hashMap.get("MAIN"));
        this.sub = parseInt(hashMap.get("SUB"));
        this.div = parseInt(hashMap.get("DIV"));
        this.hp = parseInt(hashMap.get("HP"));
        this.elmt = parseInt(hashMap.get("ELMT"));
        this.threat = parseInt(hashMap.get("THREAT"));
    }


    public int getLevel() {
        return level;
    }

    public int getMp() {
        return mp;
    }

    public int getMain() {
        return main;
    }

    public int getSub() {
        return sub;
    }

    public int getDiv() {
        return div;
    }

    public int getHp() {
        return hp;
    }

    public int getElmt() {
        return elmt;
    }

    public int getThreat() {
        return threat;
    }
}
