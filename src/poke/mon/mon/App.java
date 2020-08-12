package poke.mon.mon;

public class App {
    private static final int    NUM_OF_ENCOUNTER_MONSTERS = 10;

    public static void main(String... args) {

        Playground pg = new Playground.Builder()
                .battleTimes(NUM_OF_ENCOUNTER_MONSTERS)
                .build();

        pg.showGameTitle();

        pg.battle();

        pg.showGameResult();
    }
}
