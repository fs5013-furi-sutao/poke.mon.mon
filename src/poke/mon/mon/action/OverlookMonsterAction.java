package poke.mon.mon.action;

import poke.mon.mon.domain.Monster;
import poke.mon.mon.domain.Player;
import poke.mon.mon.util.Console;

public class OverlookMonsterAction implements IAction {

    private Console con;

    public OverlookMonsterAction() {
        this.con = new Console();
    }

    public boolean action(Player player, Monster monster) {
        String mess = String.format("%sを見逃した", monster.getName());
        con.out(mess);
        return false;
    }
}
