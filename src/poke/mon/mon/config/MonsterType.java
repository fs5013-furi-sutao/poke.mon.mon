package poke.mon.mon.config;

import java.util.Random;
import poke.mon.mon.util.Console;

public enum MonsterType {
    ZAKOMON("ザコモン", 30, 20, 20, 30, 72, "ᑕꙬ̂ᑐ"), 
    FUTSUMON("フツモン", 50, 20, 30, 30, 50, "(´・с_・｀)"), 
    TSUYOMON("ツヨモン", 100, 50, 30, 25, 28, "(ﾟ益ﾟ)"), 
    BOSSMON("ボスモン", 100, 50, 50, 10, 25, "(・ｘ・)"), 
    RAREMON("レアモン", 150, 100, 100, 5, 14, "(@Θ@)");

    private String name;
    private int    hp;
    private int    power;
    private int    defense;
    private int    encountRate;
    private int    captureRate;
    private String icon;
    private static Console con = new Console();
    private static final int POINT_RATE = 10;

    MonsterType(String name, int hp, int power, int defense, int encountRate, int captureRate, String icon) {
        this.name    = name;
        this.hp      = hp;
        this.power   = power;
        this.defense = defense;
        this.encountRate = encountRate;
        this.captureRate = captureRate;
        this.icon = icon;
    }

    /**
     * 各モンスタに設定された遭遇率から、今回遭遇するモンスタの種類を選出する
     * 
     * @return モンスタの種類 {@code MonsterType}
     */
    public static MonsterType choiceByRate() {

        int           sumEncountRates = sumEncountRates();
        MonsterType[] rateTable       = createRateTable(sumEncountRates);

        MonsterType selectedMonster = rateTable[randomNumberIn(100)];
        return selectedMonster;
    }

    private static int randomNumberIn(int i) {
        Random rand = new Random();
        return rand.nextInt(100);
    }

    private static MonsterType[] createRateTable(int allRange) {
        int           count          = 0;
        MonsterType[] rateTable = new MonsterType[allRange];

        for (MonsterType type : MonsterType.values()) {

            for (int i = 0; i < type.encountRate; i++) {
                rateTable[count] = type;
                count++;
            }
        }
        return rateTable;
    }

    private static int sumEncountRates() {
        int sum = 0;

        for (MonsterType type : MonsterType.values()) {
            sum += type.encountRate;
        }
        return sum;
    }

    public void showMyName() {
        con.out(this.getName());
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return this.hp;
    }

    public int getPower() {
        return this.power;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getEncountRate() {
        return this.encountRate;
    }

    public int getCaptureRate() {
        return this.captureRate;
    }

    public String getIcon() {
        return this.icon;
    }

    public int calcPoints() {
        // (HP+攻撃+防御)*10
      return (this.getHp() + this.getPower() + this.getDefense()) * POINT_RATE;
    }
}
