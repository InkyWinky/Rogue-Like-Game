package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 274 damage with 50% hit rate
 * Created by:
 * @author Adwait Chooromoney
 * Modified by:
 *
 */
public class AstrologerStaff extends WeaponItem {



    public static int SellP;
    public static int BuyP;


    /**
     * Constructor
     */
    public AstrologerStaff() {
        super("Astrologer's Staff", 'f', 274, "shoot", 50);
        this.SellP = 100;
        this.BuyP = 800;
    }
}
