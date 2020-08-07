

public class Monster {

    Console     con;
    MonsterType type;
    String name;
    private int    hp;
    private int    power;
    private int    defense;
    private int    encountRate;
    private int    captureRate;

    Monster() {
        this.con = new Console();
    }

    public void decision() {
        this.type = MonsterType.choiceByRate();
        this.name = this.type.getName();
        this.power = this.type.getPower();
        this.defense = this.type.getDefense();
        this.encountRate = this.type.getEncountRate();
        this.captureRate = this.type.getCaptureRate();
    }

    public void firstMessage() {
        //ツヨモン(HP:100 攻撃:50 防御:30)が現れた!
        String mess = String.format("%s(HP:%d 攻撃:%d 防御:%d) が現れた！", 
            type.getName(), type.getHp(), type.getPower(), type.getDefense());
        
        con.out(mess);
    }

    public int getCaptureRate() {
        return this.captureRate;
    }
    

}
