package poke.mon.mon.domain;

import poke.mon.mon.action.IAction;

public class Selection {

    static {
        maxId = 0;
    }

    private static int maxId;

    // @SuppressWarnings("unused")
    private int     id;
    private String  menuLine;
    private IAction action;

    public Selection(Builder builder) {
        this.id       = ++maxId;
        this.menuLine = builder.menuLine;
        this.action   = builder.action;
    }

    public static class Builder {
        private String  menuLine;
        private IAction action;

        public Builder menuLine(String mess) {
            this.menuLine = mess;
            return this;
        }

        public Builder action(IAction action) {
            this.action = action;
            return this;
        }

        public Selection build() {
            return new Selection(this);
        }
    }

    /**
     * プレーヤーのアクションを実施する
     * @param player
     * @param monster
     * @return アクションの結果 {@code true} ならアクション成功
     */
    public boolean action(Player player, Monster monster) {
        return this.action.action(player, monster);
    }

    public int getId() {
        return this.id;
    }

    public String getMenuLine() {
        return this.menuLine;
    }

    public static void initIndex() {
        maxId = 0;
    }
}
