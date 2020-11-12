package Util.ModsHolder;

public class Mods {
    protected int parseInt(String string) throws NumberFormatException {
        if (string == null) {
            return -1;
        } else {
            return Integer.parseInt(string);
        }
    }
}
