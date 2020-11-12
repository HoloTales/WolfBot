package Util;

public class ParametersCalc {
    private ModsUtil modUtil;

    public ParametersCalc(ModsUtil modUtil) {
        this.modUtil = modUtil;
    }

    public double calculateDhr(int dhValue, Integer lvValue) {
        double directHit = (double)dhValue;
        double levelSub = modUtil.getLevelSub(lvValue);
        double levelDiv = modUtil.getLevelDiv(lvValue);
        double dhr = (55*(directHit-levelSub)/levelDiv);
        return dhr;
    }
}
