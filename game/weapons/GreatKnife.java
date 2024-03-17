package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
/**
 * A simple weapon that can be used to attack the enemy.
 * performs stabbing attack
 * It deals 75 damage with 70% hit rate
 * Has special ability : perform "Quickstep" allow user to move away enemy
 * Created by:
 * @author Adwait Chooromoney
 * Modified by:
 *
 */

public class GreatKnife extends WeaponItem {
    public static int SellP;
    public static int BuyP;
    /**
     * Constructor
     */
    public GreatKnife() {
        super("GreatKnife", '/', 75, "stabbing", 70);
        this.SellP = 350;
        this.BuyP = 3500;
    }

}
