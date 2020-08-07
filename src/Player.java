import java.util.ArrayList;
import java.util.List;

public class Player {

    List<CaptureBall> balls;

    Player() {
        this.balls = new ArrayList<>();
        this.initBalls();
    }

    private void initBalls() {

        for (BallType type : BallType.values()) {
            balls.add(new CaptureBall(type));
        }
    }
}
