import java.util.List;
import java.util.Scanner;

public class Playground {

    Console con;
    Player  player;
    int     battleTimes = 0;
    Monster currentMonster;
    List<Monster> monsterHistory;

    public Playground() {
        this.con    = new Console();
        this.player = new Player();
    }

    private Playground(final Builder builder) {
        this();
        this.battleTimes = builder.battleTimes;
    }

    public void startMessage() {
        this.con.out("-----モンスター捕獲ゲーム　スタート！！-----");
    }

    public void battle() {
        while (this.isNotGameEnd()) {

            this.encount();

            this.oneBattleClose();
        }

    }

    private void encount() {
        currentMonster = new Monster();

        currentMonster.decision();
        currentMonster.firstMessage();

        selectAction();

    }

    private void selectAction() {
        con.out("どうする？");
        // try (Scanner scan = new Scanner(System.in);) {
        // }
        int answer = readInt("番号を選択してください", 1, 3);

        drawSelectMenu();

        con.out(String.valueOf(answer));
    }

    private void drawSelectMenu() {

        String menuFormat = "(%s)%sを使う(残り%s個。捕獲成功率:%s%%)";
        String additionalMenu = "(%d)モンスターを見逃す";

        // (1)ノーマル捕獲玉を使う(残り6個。捕獲成功率:28%)

        for (CaptureBall ball : player.balls) {
            String[] info = ball.infomationAgainstMonster(currentMonster); 
            
            

            con.outs(menuFormat, String.valueOf(2), info);
        }
        

    }

    public int readInt(String messageForUsers, int min, int max) {
        int number = 0;

        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
            // 一度実行して、入力が指定された範囲内になるまでループ
            do {
                // ユーザメッセージを表示
                System.out.printf("\n%s > ", messageForUsers);

                // 文字列入力によるプログラムのクラッシュを防止する
                while (!scan.hasNextInt()) {
                    System.out.printf("数字ではありません. もう一度入力してください.");
                    System.out.printf("\n%s > ", messageForUsers);
                    scan.next();
                }

                number = scan.nextInt();

                // 数値が範囲外の場合は、エラーメッセージを表示する
                if (isOutOfRange(number, min, max))
                    System.out.printf("数字が有効な範囲にありません. もう一度入力してください.");

            } while (isOutOfRange(number, min, max));

        return number;
    }

    private boolean isOutOfRange(int number, int min, int max) {
        return number < min || number > max;
    }

    private void oneBattleClose() {
        this.battleTimes--;
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



}
