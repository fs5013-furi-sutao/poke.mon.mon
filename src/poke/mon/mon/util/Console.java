package poke.mon.mon.util;

import java.util.Random;
import java.util.Scanner;

public class Console {

    public void out(String s) {
        System.out.println(s);
    }

    public void out() {
        System.out.println();
    }

    public void outNoLf(String s) {
        System.out.print(s);
    }

    public int readInt(String messageForUsers, int min, int max) {
        int number = 0;

        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);

        do {
            displayUserPrompt(messageForUsers);

            String input = scan.nextLine();

            // 文字列入力によるプログラムのクラッシュを防止する
            try {
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                outNoLf("数字が入力されていません. もう一度入力してください.");
                continue;
            }

            // 数値が範囲外の場合は、エラーメッセージを表示する
            if (isOutOfRange(number, min, max))
                System.out.printf("数字が有効な範囲にありません. もう一度入力してください.");

        } while (isOutOfRange(number, min, max));

        this.out();
        return number;
    }

    private void displayUserPrompt(String mess) {
        System.out.printf("%n%s > ", mess);
    }

    private boolean isOutOfRange(int number, int min, int max) {
        return number < min || number > max;
    }

    public void typewriter(String mess, int speed) {
        this.typewriterNoLf(mess, speed);
        this.outNoLf("\n");
    }

    public void typewriterNoLf(String mess, int speed) {

        for (char c : mess.toCharArray()) {
            this.outNoLf(String.valueOf(c));
            this.randomSleep(speed);

        }
    }

    private void randomSleep(int speed) {
        Random rand = new Random();
        try {
            Thread.sleep(rand.nextInt(speed));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
