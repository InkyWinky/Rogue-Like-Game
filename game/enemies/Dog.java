package game.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.DeathAction;
import game.behaviours.DespawnBehaviour;
import game.utils.Status;
import game.weapons.Pincers;

/**
 * An enemy that has a special attack function.
 * Created by:
 * @author Adwait Chooromoney
 * Modified By: Joanne Li Wen Yew
 */
public class Dog extends StormveilInhabitants{


    /**
     * Constructor for the Dog
     */
    public Dog() {
        super("Dog",'a',104, 52, 1390);
    }

    /**
     * Creates and returns an intrinsic weapon for Dog
     *
     * @return a freshly-instantiated IntrinsicWeapon
     */

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(101, "Bites", 93);
    }


}
