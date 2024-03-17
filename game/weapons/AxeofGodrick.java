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
public class AxeofGodrick extends WeaponItem {

    public static int SellP;

    /**
     * Constructor
     */
    public AxeofGodrick() {
        super("Axe of Godrick", 'T', 142, "stabs", 84);
        this.SellP = 100;

    }


}
