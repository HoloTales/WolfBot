package Util.ModsHolder;

public class LevelMods {
    private final int level;
    private final int mp;
    private final int main;
    private final int sub;
    private final int div;
    private final int hp;
    private final int elmt;
    private final int threat;

    public LevelMods(int level, int mp, int main, int sub, int div, int hp, int elmt, int threat) {
        this.level = level;
        this.mp = mp;
        this.main = main;
        this.sub = sub;
        this.div = div;
        this.hp = hp;
        this.elmt = elmt;
        this.threat = threat;
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
