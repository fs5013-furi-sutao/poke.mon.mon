package poke.mon.mon.config;

public enum BallType {
    NORMAL("ノーマル捕獲玉", 0, 6), 
    SUPER("スーパー捕獲玉", 20, 3), 
    MIRACLE("ミラクル捕獲玉", 50, 1);

    private String name;
    private int    correctRate;
    private int    quantity;

    BallType(String name, int correctRate, int quantity) {
        this.name        = name;
        this.correctRate = correctRate;
        this.quantity    = quantity;
    }

    public String getName() {
        return this.name;
    }

    public int getCorrectRate() {
        return this.correctRate;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
