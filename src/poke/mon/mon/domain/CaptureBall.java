package poke.mon.mon.domain;

import java.util.Random;
import poke.mon.mon.config.BallType;
import poke.mon.mon.util.Console;

public class CaptureBall {

    private int      quantity;
    private BallType type;
    private Console  con;

    CaptureBall(BallType type) {
        this.type     = type;
        this.quantity = type.getQuantity();
        this.con      = new Console();
    }

    public String infomationAgainstMonster(Monster mon) {

        String infoFormat = "%sを使う(残り%d個。捕獲成功率:%d%%)";
        String info       = String
                .format(
                        infoFormat,
                        this.type.getName(),
                        quantity,
                        this.getCaptureSuccessRate(mon));
        return info;
    }

    private int getCaptureSuccessRate(Monster mon) {
        return mon.getCaptureRate() + this.type.getCorrectRate();
    }

    public BallType getType() {
        return this.type;
    }

    public void reduce() {
        if (this.quantity == 0) {
            throw new RuntimeException("すでに所持数ゼロにもかかわらず、所持数を減算しようとしています.");
        }
        this.quantity--;
    }

    public String getName() {
        return this.type.getName();
    }

    public int getQuantity() {
        return this.quantity;
    }

    public boolean isNothing() {
        return this.quantity <= 0;
    }

    public boolean getResultUsedBall(Monster mon) {
        boolean isSuccess = false;

        int captureRate = this.getCaptureSuccessRate(mon);

        int chanceNum = this.generateChanceNum();

        if (captureRate < chanceNum) {
            isSuccess = false;
            return isSuccess;
        }

        isSuccess = true;
        return isSuccess;
    }

    private int generateChanceNum() {
        Random    rand       = new Random();
        final int RATE_RANGE = 100;
        return rand.nextInt(RATE_RANGE);
    }

    public void showCapturedSuccess(Monster monster) {
        String mess = String.format("やったー！%S を捕獲した.", monster.getName());
        this.con.typewriter(mess, 50);
    }

    public void showCapturedFailure() {
        this.con.typewriter("捕獲失敗・・・", 100);
    }

    public void showNoBalls() {
        String mess = String.format("%s はもうありません. 他を選択してください.", this.getName());
        con.typewriter(mess, 50);
    }
}
