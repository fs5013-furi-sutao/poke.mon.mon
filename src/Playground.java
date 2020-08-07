public class Playground {

    Console con;
    Player player;

    Playground() {
        this.con = new Console();
        this.player = new Player();

    }

    public void startMessage() {
        this.con.out("-----モンスター捕獲ゲーム　スタート！！-----");
    }



}
