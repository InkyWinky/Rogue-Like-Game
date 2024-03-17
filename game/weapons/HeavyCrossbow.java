package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 64 damage with 57% hit rate
 * Created by:
 * @author Adwait Chooromoney
 * Modified by:
 *
 */
public class HeavyCrossbow extends WeaponItem {


    /**
     * The selling price of the heavy crossbow
     */
    public static int SellP;

    /**
     * The buying price of the heavy crossbow
     */
    public static int BuyP;


    /**
     * Constructor
     */
    public HeavyCrossbow() {
        super("HeavyCrossbow", '}', 64, "shoot", 57);
        this.SellP = 100;
        this.BuyP = 1500;
    }


}
