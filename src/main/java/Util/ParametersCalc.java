package Util;

public class ParametersCalc {
    private ModsUtil modUtil;

    public ParametersCalc(ModsUtil modUtil) {
        this.modUtil = modUtil;
        System.out.println("Parameters Calculator Initialized.");
    }

    public double calculateDhr(int dhValue, Integer lvValue) {
        double directHit = (double)dhValue;
        double levelSub = modUtil.getLevelSub(lvValue);
        double levelDiv = modUtil.getLevelDiv(lvValue);
        double dhr = Math.floor(550*(directHit-levelSub)/levelDiv)/10;
        return dhr;
    }

    public double calculateChr(int critValue, Integer lvValue) {
        double criticalHit = (double)critValue;
        double levelSub = modUtil.getLevelSub(lvValue);
        double levelDiv = modUtil.getLevelDiv(lvValue);
        double chr = Math.floor((200*(criticalHit)-levelSub)/(levelDiv+50))/10;
        return chr;
    }

    public double detMod(int detValue, Integer lvValue) {
        return 0.00;
    }
}
