package game.player;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.items.Rune;
import game.weapons.Club;
import game.weapons.GreatKnife;

public class Wretch extends CombatArchetype {
    public Wretch() {
        super("Wretch", 414, new Club());
    }

}