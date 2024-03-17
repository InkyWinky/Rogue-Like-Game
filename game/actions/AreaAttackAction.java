package game.actions;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.enemies.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Special attack action that causes damage to surrounding actors.
 * Created by:
 * @author Joanne Li Wen Yew
 */
public class AreaAttackAction extends Action {


    /**
     * An array containing the 8 targets surrounding the attacker
     */
    private List<Actor> targets = new ArrayList<>();

    /**
     * Random number generator
     */
    private Random rand = new Random();

    /**
     * Weapon used for the attack
     */
    private Weapon weapon;

    /**
     * Constructor.
     *
     */
    public AreaAttackAction(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * When executed, the chance to hit of the weapon that the Actor used is computed to determine whether
     * the actor will hit the target. If so, deal damage to the target and determine whether the target is killed.
     *
     * @param actor The actor performing the attack action.
     * @param map The map the actor is on.
     * @return the result of the attack, e.g. whether the target is killed, etc.
     * @see DeathAction
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        getTarget(actor,map);
        String result = "\n" + actor + " " + weapon.verb() + " surrounding!\n";
        for (Actor target : targets) {
            if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
                result += actor + " misses.\n";
            } else {
                int damage = weapon.damage();
                target.hurt(damage);
                result += actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.\n" ;
                if (!target.isConscious()) {
                    if ((target instanceof Enemy)) {
                        result += ((Enemy) target).getDeathAction(target, map);
                    } else {
                        result += new DeathAction(target).execute(target, map);
                    }
                }

            }
        }
        return result;
    }

    /**
     * Returns null as AreaAttackAction is not an action that can be performed by player.
     *
     * @param actor The actor performing the action.
     * @return null
     */
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }

    /**
     * Gets the location of the exits surounding the actor and stores all of their locations into a list
     * @param actor
     * @param map
     * @return targets as a list
     */
    public List getTarget (Actor actor, GameMap map){
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                targets.add(destination.getActor());
            }
        }
        return targets;
    }
}

