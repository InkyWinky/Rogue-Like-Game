package game.player;

import edu.monash.fit2099.engine.actors.Actor;
import game.items.Rune;
import game.weapons.AstrologerStaff;
import game.weapons.GreatKnife;

/**
 * A class that represents the Cage .
 * Created by: Adwait Chooromoney
 * @author Adwait Chooromoney
 * Modified by:
 *
 */

public class Astrologer extends CombatArchetype {
    public Astrologer(){
        super("Astrologer", 396, new AstrologerStaff());
    }
}
