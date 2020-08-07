import java.util.Random;

public enum MonsterType {
    ZAKOMON("ザコモン", 30, 20, 20, 30, 72), FUTSUMON("フツモン", 50, 20, 30, 30, 50), TSUYOMON("ツヨモン", 100,
            50, 30, 25,
            28), BOSSMON("ボスモン", 100, 50, 50, 10, 25), RAREMON("レアモン", 150, 100, 100, 5, 14);

    private String name;
    private int    hp;
    private int    power;
    private int    defense;
    private int    encountRate;
    private int    captureRate;
    private static Console con = new Console();

    MonsterType(String name, int hp, int power, int defense, int encountRate, int captureRate) {
        this.name    = name;
        this.hp      = hp;
        this.power   = power;
        this.defense = defense;
        this.encountRate = encountRate;
        this.captureRate = captureRate;
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
        return hp;
    }

    public int getPower() {
        return power;
    }

    public int getDefense() {
        return defense;
    }

    public int getEncountRate() {
        return this.encountRate;
    }

    public int getCaptureRate() {
        return captureRate;
    }
}
