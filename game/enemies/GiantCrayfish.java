package game.enemies;

import edu.monash.fit2099.engine.actors.Actor;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

import game.actions.DeathAction;

import game.behaviours.Behaviour;
import game.behaviours.DespawnBehaviour;
import game.utils.Status;
import game.weapons.Pincers;

import java.util.HashMap;
import java.util.Map;

/**
 * An enemy that has a special attack function.
 * Created by:
 * @author Joanne Li Wen Yew
 */
public class GiantCrayfish extends Crustacean {

    /**
     * Constructor for the GiantCrayfish.
     */
    public GiantCrayfish() {
        super("GiantCrayfish", 'R', 4803, 500, 2374);
        this.addWeaponToInventory(new Pincers("Giant Pincers", ' ' , 527, "fully slams", 100));
    }

    /**
     * Creates and returns an intrinsic weapon for Giant Crayfish.
     *
     * @return a freshly-instantiated IntrinsicWeapon
     */

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(527, "Slams", 100);
    }


}
