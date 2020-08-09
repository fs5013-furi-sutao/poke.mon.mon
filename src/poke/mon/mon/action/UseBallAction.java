package poke.mon.mon.action;

import poke.mon.mon.domain.CaptureBall;
import poke.mon.mon.domain.Monster;
import poke.mon.mon.domain.Player;
import poke.mon.mon.util.Console;

public class UseBallAction implements IAction {

    private CaptureBall ball;
    private Console     con;

    /**
     * 
     * @param ball
     */
    public UseBallAction(CaptureBall ball) {
        this.ball = ball;
        this.con  = new Console();
    }

    /**
     * プレーヤーのアクションを実施する
     * @param player
     * @param monster
     * @return アクションの結果 {@code true} ならアクション成功
     */
    public boolean action(Player player, Monster monster) {

        boolean isFailedAction = false;

        CaptureBall playerStockBall = player.getChosenBall(this.ball.getType());

        if (playerStockBall.isNothing()) {
            this.ball.showNoBalls();
            return isFailedAction = true;
        }

        this.con.typewriterNoLf("ボールを投げた ", 20);
        this.con.typewriterNoLf("......................... ", 50);

        boolean isSuccess = this.ball.getResultUsedBall(monster);
        this.drawIconCaptureOrNot(isSuccess, monster);
        this.showResultMessage(isSuccess, monster);

        player.reduceBall(this.ball.getType());

        if (!isSuccess) 
            return isFailedAction = false;

        int points = this.calcPoints(monster);
        monster.recordCalcedPoints(points);
        this.showEarnPoints(points);

        player.earnPoints(points);
        player.addCaputuredMonster(monster);

        return isFailedAction;
    }

    private void drawIconCaptureOrNot(boolean isSuccess, Monster monster) {
        if (isSuccess) this.drawBeforeCrushingMonster();
        if (isSuccess) this.con.typewriterNoLf(monster.getIcon(), 20);
        if (isSuccess) this.drawAfterCrushingMonster();
        if (!isSuccess) this.drawAfterFailedCaptureMonster();
    }

    private void drawAfterFailedCaptureMonster() {
        this.con.typewriterNoLf(" Oops", 10);
        this.con.typewriter(", Failed... ", 100);
    }

    private void drawBeforeCrushingMonster() {
        String crushArt = "  *･ﾟ  ";
        this.con.typewriterNoLf(crushArt, 50);
    }

    private void drawAfterCrushingMonster() {
        String crushArt = "  * :.｡ ..｡.:* ･ﾟ  Captured!";
        this.con.typewriter(crushArt, 100);
    }

    private void showEarnPoints(int points) {
        String mess = String.format("%d ポイントを獲得.", points);
        this.con.typewriter(mess, 50);
    }

    private int calcPoints(Monster monster) {
        return monster.calcPoints();
    }

    private void showResultMessage(boolean isSuccess, Monster monster) {
        if (isSuccess)
            this.ball.showCapturedSuccess(monster);
        if (!isSuccess)
            this.ball.showCapturedFailure();
    }
}
