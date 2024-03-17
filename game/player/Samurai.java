package game.player;

import edu.monash.fit2099.engine.actors.Actor;
import game.items.Rune;
import game.weapons.GreatKnife;
import game.weapons.Uchigatana;

public class Samurai extends CombatArchetype {

    public Samurai(){
        super("Samurai", 455, new Uchigatana());
    }

}
