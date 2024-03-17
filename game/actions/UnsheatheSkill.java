package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;

import java.util.Random;

public class UnsheatheSkill extends Action {
    private int damage;
    private Random rand = new Random();
    private Actor target;
    public UnsheatheSkill(Actor target, WeaponItem weaponItem){
        this.damage = weaponItem.damage()*2;
        this.target = target;
    }


    public String execute(Actor actor, GameMap map) {
        if (!(rand.nextInt(100) <= 60)) {
            return actor + " misses " + target + ".";
        }
        String result = actor + "uses unsheathe skill and hits"+ target + " for " + damage + " damage.\n";
        target.hurt(damage);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + "uses unsheathe skill";
    }
}
