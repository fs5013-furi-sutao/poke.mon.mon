package poke.mon.mon;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import poke.mon.mon.action.IAction;
import poke.mon.mon.action.OverlookMonsterAction;
import poke.mon.mon.action.UseBallAction;
import poke.mon.mon.domain.CaptureBall;
import poke.mon.mon.domain.Monster;
import poke.mon.mon.domain.Player;
import poke.mon.mon.domain.Selection;
import poke.mon.mon.util.Console;

public class Playground {

    Console con;
    Path titleFilePath;
    Player  player;
    Monster currentMonster;
    int     battleTimes = 0;
    int     turn        = 0;

    public Playground() {
        this.con    = new Console();
        this.player = new Player();
    }

    private Playground(final Builder builder) {
        this();
        this.battleTimes = builder.battleTimes;
        this.turn        = 1;
    }

    public void showGameTitle() {
        this.con.showFileContents(this.titleFilePath);
    }

    public void battle() {
        while (this.isNotGameEnd()) {
            this.encount();
            this.oneBattleClose();
        }

    }

    private void encount() {
        this.currentMonster = new Monster();

        this.currentMonster.showEncountMessage(this.turn);
        this.currentMonster.decision();
        this.currentMonster.firstMessage();

        boolean isFail = true;
        while (isFail) {
            Selection yourChoice = selectAction();

            isFail = yourChoice.action(this.player, currentMonster);

            this.initSelection();
        }
    }

    private void initSelection() {
        Selection.initIndex();
        this.con.out();
    }

    private Selection selectAction() {
        String mess = String.format("%s にどうする？", this.currentMonster.getName());
        con.typewriter(mess, 30);
        List<Selection> menu = generateSelectMenu();
        displayOutMenu(menu);

        int answer = this.con.readInt("番号を選択してください", 1, menu.size());

        Selection yourChoice = menu.get(answer - 1);
        return yourChoice;
    }

    private void displayOutMenu(List<Selection> menu) {
        for (Selection line : menu) {
            String mess = String.format("%d : %s", line.getId(), line.getMenuLine());
            con.out(mess);
        }
    }

    private List<Selection> generateSelectMenu() {
        List<Selection> menu = new ArrayList<>();

        for (CaptureBall ball : player.getBalls()) {
            IAction   action   = new UseBallAction(ball);
            String    ballInfo = ball.infomationAgainstMonster(currentMonster);
            Selection sel      = new Selection.Builder().menuLine(ballInfo).action(action).build();
            menu.add(sel);
        }
        String    additionalMenu = "モンスターを見逃す";
        IAction   action         = new OverlookMonsterAction();
        Selection sel            =
                new Selection.Builder().menuLine(additionalMenu).action(action).build();
        menu.add(sel);

        return menu;
    }

    private void oneBattleClose() {
        this.battleTimes--;
        this.turn++;
        this.initSelection();;
    }

    private boolean isNotGameEnd() {
        return this.battleTimes != 0;
    }

    public static class Builder {
        int battleTimes = 0;

        public Builder() {}

        public Builder battleTimes(final int times) {
            this.battleTimes = times;
            return this;
        }

        public Playground build() {
            if (battleTimes == 0) {
                throw new NullPointerException("モンスターの遭遇回数が未設定です.");
            }
            return new Playground(this);
        }

    }

    public void showGameResult() {
        this.con.typewriter(this.player.getPointsStr() + " points.", 50);
        int count = 0;
        for (Monster mon : this.player.getCapturedMonsterList()) {
            count++;
            this.con
                    .typewriter(
                            count + " : " + mon.getName() + " " + mon.getIcon() + " "
                                    + mon.getRecordedPoints() + "points.",
                            50);
        }
    }

    public void catchTitleFile(Path aa) {
        this.titleFilePath = aa;
    }

}
