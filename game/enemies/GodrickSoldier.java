package game.enemies;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AreaAttackAction;
import game.actions.AttackAction;
import game.actions.DeathAction;
import game.behaviours.DespawnBehaviour;
import game.utils.Status;
import game.weapons.Grossmesser;
import game.weapons.HeavyCrossbow;

/**
 * An enemy that has a special attack function.
 * Created by:
 * @author Adwait Chooromoney
 * Modified By: Joanne Li Wen Yew
 */
public class GodrickSoldier extends StormveilInhabitants{


    /**
     * Constructor for the Godrick Soldier
     */
    public GodrickSoldier() {
        super("GodrickSoldier",'p',198, 38, 70);
        super.addWeaponToInventory(new HeavyCrossbow());


    }

    /**
     * Creates and returns an intrinsic weapon for Godrick Soldier
     *
     * @return a freshly-instantiated IntrinsicWeapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(64, "shoot", 57);
    }

}
