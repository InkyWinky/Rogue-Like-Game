package game.enemies;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.DespawnBehaviour;
import game.utils.Status;
import game.actions.DeathAction;

/**
 * An enemy that doesn't have a special attack function.
 * Created by:
 * @author Joanne Li Wen Yew
 */
public class LoneWolf extends Canine{
    /**
     * Constructor for the Lonewolf.
     */
    public LoneWolf() {
        super("Lone Wolf", 'h', 102, 55, 1470);
    }

    /**
     * Creates and returns an intrinsic weapon for Lone Wolf.
     *
     * @return a freshly-instantiated IntrinsicWeapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }

}
