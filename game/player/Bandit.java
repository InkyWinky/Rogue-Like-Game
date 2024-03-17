package game.player;

import edu.monash.fit2099.engine.actors.Actor;
import game.items.Rune;
import game.weapons.GreatKnife;
/**
 * A class that represents the Cage .
 * Created by: Adwait Chooromoney
 * @author Adwait Chooromoney
 * Modified by:Incy
 *
 */
public class Bandit extends CombatArchetype {
    public Bandit(){
        super("Bandit", 414, new GreatKnife());
    }
}
