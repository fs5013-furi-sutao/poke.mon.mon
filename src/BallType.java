public enum BallType {
	NORMAL("ノーマル捕獲玉", 0, 6), 
	SUPER("スーパー捕獲玉", 20, 3), 
	MIRACLE("ミラクル捕獲玉", 50, 1);

	private String name;
	private int captureRate;
	private int quantity;

	BallType(String name, int captureRate, int quantity) {
		this.name = name;
		this.captureRate = captureRate;
		this.quantity = quantity;
	}

	String getName() {
		return this.name;
	}

	int getCaptureRate() {
		return this.captureRate;
	}

	int getQuantity() {
		return this.quantity;
	}
}
