package game.weapons;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AreaAttackAction;

/**
 * A simple weapon that can be used to attack the enemy.
 * performs spinning attack
 * It deals 115 damage with 85% hit rate
 * Created by:
 * @author Adwait Chooromoney
 * Modified by: Joanne Li Wen Yew
 *
 */
public class Grossmesser extends WeaponItem {
    public static int SellP;

    /**
     * Constructor
     */
    public Grossmesser() {
        super("Grossmesser", '?', 115, "slashes", 85);
        this.SellP = 100;
    }

    @Override
    public Action getSkill(Actor holder) {
        return new AreaAttackAction(this);
    }


}
