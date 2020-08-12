package poke.mon.mon.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class Console {

    public void showFileContents(Path path) {
        try (Stream<String> lines =  Files.lines(path, StandardCharsets.UTF_8)) {
            lines.forEach(System.out::println);
            this.randomSleep(100);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
        String prompot = String.format("%n%s > ", mess);
        this.out(prompot);
    }

    private boolean isOutOfRange(int number, int min, int max) {
        return number < min || number > max;
    }

    /**
     * 渡された文字列を指定されたスピードで表示する（末尾改行つき）
     * @param mess 表示するメッセージ
     * @param speed 表示スピード指定
     */
    public void typewriter(String mess, int speed) {
        this.typewriterNoLf(mess, speed);
        this.out();
    }

    /**
     * 渡された文字列を指定されたスピードで表示する（末尾改行なし）
     * @param mess 表示するメッセージ
     * @param speed 表示スピード指定
     */
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

    /**
     * かれんとでぃれくと
     * @return
     */
    public String getCurDir() {
      return System.getProperty("user.dir");
    }
}
