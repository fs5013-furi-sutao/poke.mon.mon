package poke.mon.mon;

import java.nio.file.Path;
import java.nio.file.Paths;
import poke.mon.mon.util.Console;

public class App {
    private static final int    NUM_OF_ENCOUNTER_MONSTERS = 10;
    private static final String TITLE_ASCII_FILE_NAME = "title.game";
    private static final String[] dirs = {"src", "poke", "mon", "mon", TITLE_ASCII_FILE_NAME};
    

    public static void main(String... args) {
        
        Console con = new Console();
        Path titleAsciiFilePath = con.concatPath(dirs);
        con = null;

        Playground pg = new Playground.Builder()
                .battleTimes(NUM_OF_ENCOUNTER_MONSTERS)
                .build();
        
        pg.catchTitleFile(titleAsciiFilePath);
        pg.showGameTitle();

        pg.battle();

        pg.showGameResult();
    }
}
