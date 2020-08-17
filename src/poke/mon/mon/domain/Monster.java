package poke.mon.mon.domain;

import poke.mon.mon.config.MonsterType;
import poke.mon.mon.util.Console;

public class Monster {

    Console     con;
    MonsterType type;
    String      name;
    int recordedPoints;

    public Monster() {
        this.con = new Console();
    }

    public void decision() {
        this.type = MonsterType.choiceByRate();
    }

    public void firstMessage() {
        String mess = String
                .format(
                        "%s(HP:%d 攻撃:%d 防御:%d) が現れた！ ... ",
                        this.type.getName(),
                        this.type.getHp(),
                        this.type.getPower(),
                        this.type.getDefense(),
                        this.type.getIcon());

        con.typewriterNoLf(mess, 30);
        con.typewriter(this.type.getIcon(), 200);
    }

    public String getName() {
        return this.type.getName();
    }

    public String getIcon() {
        return this.type.getIcon();
    }

    public int getCaptureRate() {
        return this.type.getCaptureRate();
    }

    public int getRecordedPoints() {
        return this.recordedPoints;
    }

    public int calcPoints() {
        return this.type.calcPoints();
    }

    public void recordCalcedPoints(int points) {
        this.recordedPoints = points;
    }

    public void showEncountMessage(int turn) {
        String mess = String.format(
            "%d匹目のモンスターが出現... ============================== "
            , turn
        );

        this.con.typewriter(mess, 30);
        this.con.out();
    }
}
