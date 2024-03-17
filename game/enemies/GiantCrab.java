package game.enemies;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.behaviours.DespawnBehaviour;
import game.utils.Status;
import game.actions.DeathAction;
import game.weapons.Pincers;
import static game.utils.RandomNumberGenerator.getRandomInt;

/**
 * An enemy that has a special attack function.
 * Created by:
 * @author Joanne Li Wen Yew
 * Modified By: Incy Lin, Adwait
 */
public class GiantCrab extends Crustacean{


    /**
     * Constructor for the GiantCrab.
     */
    public GiantCrab() {
        super("Giant Crab",'C',407, 318, 4961);
        this.addWeaponToInventory(new Pincers("Pincers", ' ' , 208, "fully slams", 90));
    }

    /**
     * Creates and returns an intrinsic weapon for Giant Crab.
     *
     * @return a freshly-instantiated IntrinsicWeapon
     */

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }



}
