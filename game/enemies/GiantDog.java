package game.enemies;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

import game.actions.DeathAction;
import game.behaviours.DespawnBehaviour;
import game.utils.Status;

/**
 * An enemy that doesn't have a special attack function.
 * Created by:
 * @author Joanne Li Wen Yew
 */
public class GiantDog extends Canine {

    /**
     * Constructor for the GiantDog.
     */
    public GiantDog() {
        super("GiantDog", 'G', 693, 313, 1808);
    }
    /**
     * Creates and returns an intrinsic weapon for Giant Dog.
     *
     * @return a freshly-instantiated IntrinsicWeapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(314, "Slams", 90);
    }



}
