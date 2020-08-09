package poke.mon.mon.domain;

import java.util.ArrayList;
import java.util.List;
import poke.mon.mon.config.BallType;

public class Player {

    private List<CaptureBall>     balls;
    private int           points;
    private List<Monster> capturedMonsterList;

    public Player() {
        this.balls = new ArrayList<>();
        this.capturedMonsterList = new ArrayList<>();
        this.initBalls();
    }

    private void initBalls() {

        for (BallType type : BallType.values()) {
            balls.add(new CaptureBall(type));
        }
    }

    public CaptureBall getChosenBall(BallType type) {

        for (CaptureBall ball : balls) {
            if (ball.getType() == type)
                return ball;
        }
        return null;
    }

    public void reduceBall(BallType type) {
        CaptureBall ball = this.getChosenBall(type);
        ball.reduce();
    }

    public void earnPoints(int points) {
        this.points += points;
    }

    public void addCaputuredMonster(Monster monster) {
        this.capturedMonsterList.add(monster);
    }

    public String getPointsStr() {
      return String.valueOf(this.points);
    }

    public List<CaptureBall> getBalls() {
        return this.balls;
    }

    public List<Monster> getCapturedMonsterList() {
        return this.capturedMonsterList;
    }
}
