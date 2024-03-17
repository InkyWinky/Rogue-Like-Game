package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AreaAttackAction;

/**
 * A simple weapon that can be used to attack the enemy.
 * performs spinning attack
 * It deals 75 damage with 70% hit rate
 * Created by:
 * @author Adwait Chooromoney
 * Modified by:
 *
 */
public class Scimitar extends WeaponItem {
    public static int SellP;
    public static int BuyP;

    /**
     * Constructor
     */
    public Scimitar() {
        super("Scimitar", 's', 118, "spin attacks", 88);
        this.SellP = 100;
        this.BuyP = 600;
    }

    @Override
    public Action getSkill(Actor holder) {
        return new AreaAttackAction(this);
    }

}
