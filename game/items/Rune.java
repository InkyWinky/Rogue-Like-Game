package game.items;

import edu.monash.fit2099.engine.items.Item;

public class Rune extends Item {
    public Integer getRuneV() {
        return RuneV;
    }

    public void setRuneV(Integer runeV) {
        RuneV = runeV;
    }

    public Integer RuneV;

    public Rune() {
        super("Rune", '$',false);
        this.RuneV=0;
    }


}
