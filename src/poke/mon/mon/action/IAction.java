package poke.mon.mon.action;

import poke.mon.mon.domain.Monster;
import poke.mon.mon.domain.Player;

public interface IAction {

    /**
     * プレーヤーのアクションを実施する
     * @param player
     * @param monster
     * @return アクションの結果 {@code true} ならアクション成功
     */
    boolean action(Player player, Monster monster);
}
