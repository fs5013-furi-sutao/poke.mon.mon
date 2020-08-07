

public class CaptureBall {

    static {
        maxIndex = 0;
    }
    private static int maxIndex;
    private int        index;
    private String     name;
    private int        correctRate;
    private int        quantity;

    CaptureBall(BallType type) {
        this.index       = ++maxIndex;
        this.name        = type.getName();
        this.correctRate = type.getCorrectRatee();
        this.quantity    = type.getQuantity();
    }

    public int getIndex() {
        return this.index;
    }

    public String[] infomationAgainstMonster(Monster mon) {

        String[] info = new String[3];
        info[0] = name;
        info[1] = String.valueOf(quantity);
        info[2] = String.valueOf(mon.getCaptureRate() + correctRate);
        return info;
    }
}
