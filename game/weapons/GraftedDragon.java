package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 103 damage with 80% hit rate
 * Created by:
 * @author Adwait Chooromoney
 * Modified by:
 *
 */
public class GraftedDragon extends WeaponItem {

    public static int SellP;

    /**
     * Constructor
     */
    public GraftedDragon() {
        super("Grafted Dragon", 'N', 89, "stabs", 90);
        this.SellP = 200;

    }


}
