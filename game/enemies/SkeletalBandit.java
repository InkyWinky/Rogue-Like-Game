package game.enemies;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.DespawnBehaviour;
import game.utils.Status;


import game.weapons.Scimitar;


/**
 * An enemy that has a special attack function and carries a Scimitar.
 * Created by:
 * @author Joanne Li Wen Yew
 */
public class SkeletalBandit extends Skeletal {

    /**
     * Constructor for the SkeletalBandit.
     */
    public SkeletalBandit() {
        super("SkeletalBandit", 'b', 184, 35, 892);
        this.addWeaponToInventory(new Scimitar());
    }
    /**
     * Creates and returns an intrinsic weapon for Skeletal Bandit.
     *
     * @return a freshly-instantiated IntrinsicWeapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {return new IntrinsicWeapon(118, "slashes", 88);}





}
