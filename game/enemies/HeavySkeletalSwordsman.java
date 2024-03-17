package game.enemies;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.DespawnBehaviour;
import game.utils.Status;

import game.weapons.Grossmesser;

/**
 * An enemy that has a special attack function and carries a Grossmesser weapon.
 * Created by:
 * @author Joanne Li Wen Yew
 */
public class HeavySkeletalSwordsman extends Skeletal{
    public static int Rmin;
    public static int Rmax;

    /**
     * Constructor for the HeavySkeletalSwordsman.
     */
    public HeavySkeletalSwordsman() {

        super("Heavy Skeletal Swordsman", 'q', 153, 35, 892);
        super.addWeaponToInventory(new Grossmesser());
    }
    /**
     * Creates and returns an intrinsic weapon for Heavy Skeletal Swordsman.
     *
     * @return a freshly-instantiated IntrinsicWeapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {return new IntrinsicWeapon(115, "slashes", 85);}




}
