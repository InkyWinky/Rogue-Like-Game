package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.RandomNumberGenerator;
import game.utils.Status;
import game.actions.AttackAction;

/**
 * An attack behaviour that returns either a normal attack action or an area attack action
 * Created by:
 * @author Joanne Li Wen Yew
 */
public class AttackBehaviour implements Behaviour {

    /**
     * The maximum number the random generator can generate as an integer
     */
    private static final int BOUND = 100;


    /**
     * Determines the targets surrounding the actor. If it has a special skill,
     * there is a 50% chance that an AreaAttackAction is called;
     * if it doesn't have a special attack, a regular AttackAction is called.
     *
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return an AttackAction or AreaAttackAction that actor can perform, or null if actor can't do this.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                Actor target = destination.getActor();
                Location targetLocation = map.locationOf(target);
                int x = targetLocation.x();
                int y = targetLocation.y();
                String direction = "(" + x + "," + y + ")";
                if (actor.hasCapability(Status.SPECIAL_SKILL)) {
                    int specialAttackChance = RandomNumberGenerator.getRandomInt(BOUND);
                    if (specialAttackChance <= 50) {
                        return actor.getWeaponInventory().get(0).getSkill(actor);//returns special skills
                    } else {
                        return isAttackable(actor, target, direction);
                    }//return attack action using intrinsic weapon
                } else {
                    return isAttackable(actor, target, direction);
                }
            }
        }
        return null;
    }

    /**
     * Checks and see if the target is the same kind as the attacker. If it is, it returns an Attack Action, if not it returns nothing.
     *
     * @param actor     the actor performing the attack
     * @param target    the actor getting attacked
     * @param direction the direction of the target in respect to the attacker
     * @return AttackAction
     */
    public Action isAttackable(Actor actor, Actor target, String direction) {
        for (Status attackerStatus : actor.findCapabilitiesByType(Status.class)) {
            if (attackerStatus == target.capabilitiesList().get(0)) {
                return null;
            }
        }
        if( target.hasCapability(Status.INVISIBLE)){return null;} //cant attack player if they have status invisible
        else {
            if (!actor.getWeaponInventory().isEmpty() & !actor.hasCapability(Status.SPECIAL_SKILL)) {
                return new AttackAction(target, direction, actor.getWeaponInventory().get(0));
            } else {
                return new AttackAction(target, direction);
            }
        }
    }
}


