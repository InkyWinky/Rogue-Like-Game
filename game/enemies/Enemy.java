
package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.capabilities.CapabilitySet;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.ResetManager;
import game.actions.AreaAttackAction;
import game.player.Player;
import game.actions.AttackAction;
import game.actions.DespawnAction;
import game.behaviours.*;
import game.Resettable;
import game.utils.Status;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;

/**
 * An actor that has a list of behaviours it can take based on priority. Some have special death actions.
 * Created by:
 * @author Joanne Li Wen Yew
 * Modified By: Incy Lin
 */
public abstract class Enemy extends Actor implements Resettable{ private final CapabilitySet capabilitySet = new CapabilitySet();
    /**
     * The different behaviours an enemy have stored in a treemap
     */
    public TreeMap<Integer, Behaviour> behaviours = new TreeMap<>();

    private int max_runes;
    private int min_runes;

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Enemy(String name, char displayChar, int hitPoints, int min_runes, int max_runes) {
        super(name, displayChar, hitPoints);
        this.behaviours.put(1, new AttackBehaviour());
        this.behaviours.put(3, new DespawnBehaviour());
        this.behaviours.put(4, new WanderBehaviour());
        this.max_runes = max_runes;
        this.min_runes = min_runes;
        ResetManager.getInstance().registerResettable(this);
    }

    /**
     * Returns a new collection of the Actions that the otherActor can do to the current Actor.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A collection of Actions.
     */
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actionList = new ActionList();
        if (!otherActor.getWeaponInventory().isEmpty()){
            actionList.add(new AttackAction(this,direction, otherActor.getWeaponInventory().get(0))); //attack action using weapon item
        }
        actionList.add(new AttackAction(this,direction)); //attack action using intrinsic weapon
        if (otherActor.hasCapability(Status.SPECIAL_SKILL)) {
            actionList.add(new AreaAttackAction(otherActor.getWeaponInventory().get(0)));
        }
        return actionList;
    }


    /**
     * Select and return an action to perform on the current turn.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
     */
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (this.hasCapability(Status.RESET)){ //Remove enemy when resetting
            return new DespawnAction(this);
        }

        if (!this.behaviours.containsKey(2)) //if the enemy is not already following a player
        {
            for (Exit exit : map.locationOf(this).getExits()) {
                Location destination = exit.getDestination();
                if (destination.containsAnActor()) {
                    Actor subject = destination.getActor();
                    if (subject.hasCapability(Status.FOLLOWABLE)) {
                        this.behaviours.put(2, new FollowBehaviour(subject));
                        break;
                    }
                }
            }
        }

        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null) {
                return action;
            }
        }

        return new DoNothingAction();
    }

    /**
     * Creates and returns an intrinsic weapon.
     *
     * @return a freshly-instantiated IntrinsicWeapon
     */
    public abstract IntrinsicWeapon getIntrinsicWeapon();

    /**
     * Determines if the target of the enemy has a special death action
     *
     * @param target the target of the attacking enemy
     * @param map the map in which the target is on
     * @return the death action for the target as a string
     */
    public abstract String getDeathAction(Actor target,GameMap map);

    public int getMax_runes() {
        return max_runes;
    }

    public void setMax_runes(int max_runes) {
        this.max_runes = max_runes;
    }

    public int getMin_runes() {
        return min_runes;
    }

    public void setRunes(int min_runes) {
        this.min_runes = min_runes;
    }

    public void reset(){
        this.addCapability(Status.RESET);
    }
}


