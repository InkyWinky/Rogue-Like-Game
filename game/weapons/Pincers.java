package game.weapons;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AreaAttackAction;
import game.actions.AttackAction;

/**
 * A simple weapon that can be used to attack the enemies is an area attack
 * Can't be dropped by the enemy after it is killed.
 * Created by:
 * @author Joanne Li Wen Yew
 *
 */
public class Pincers extends WeaponItem {
    /**
     * Constructor.
     */
    public Pincers(String name, char displayChar, int damage, String verb, int hitRate) {
        super(name, displayChar, damage, verb, hitRate);
        super.portable = false;
    }

    @Override
    public Action getSkill(Actor holder) {
        return new AreaAttackAction(this);
    }
}
