package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
/**
 * A simple weapon that can be used to attack the enemy.
 * performs slicing attack
 * It deals 115 damage with 80% hit rate
 * Has special ability : perform "Unsheathe" (230 damage and 60% hit rate)
 * Created by:
 * @author Adwait Chooromoney
 * Modified by:
 *
 */
public class Uchigatana extends WeaponItem {
    public static int SellP;
    public static int BuyP;
    /**
     * Constructor
     */
    public Uchigatana() {
        super("Uchigatana", ')', 115, "Slice", 80);
        this.SellP = 500;
        this.BuyP = 5000;
    }

}
