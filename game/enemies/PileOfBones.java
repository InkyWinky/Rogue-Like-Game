package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.ResetManager;
import game.Resettable;
import game.actions.AreaAttackAction;
import game.actions.AttackAction;
import game.utils.Status;

/**
 * An actor that can be re-spawned into its original form if not hit within three turns.
 * Created by:
 * @author Joanne Li Wen Yew
 */
public class PileOfBones extends Actor implements Resettable {
    /**
     * Age as an integer keeps track of the age of pile of bones each turn
     */
    private int age = 0;
    /**
     * The enemy that might be re-spawned as an Actor
     */
    private Actor skeletal;
    /**
     * Constructor for the PileOfBones.
     */
    public PileOfBones(Actor skeletal) {
        super("Pile Of Bones",'X',1); //low hit point cause once it is hit once it'll respawn
        this.addCapability(Status.IS_BONES);
        this.skeletal = skeletal;
        this.addWeaponToInventory(skeletal.getWeaponInventory().get(0));
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
            actionList.add(new AttackAction(this,direction, otherActor.getWeaponInventory().get(0)));
        }
        actionList.add(new AttackAction(this,direction));
        if (otherActor.hasCapability(Status.SPECIAL_SKILL)) {
            actionList.add(new AreaAttackAction(otherActor.getWeaponInventory().get(0)));
        }
        return actionList;
    }

    /**
     * Tracks the age of the pile of bones each turn and returns an action.
     * Actor respawns if it is not hit within 3 turns.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        age++;
        if (age >= 3) {
            Location pileOfBonesLocation = map.locationOf(this);
            map.removeActor(this);
            this.skeletal.resetMaxHp(getMaxHp());
            pileOfBonesLocation.addActor(this.skeletal); //respawn heavy skeletal swordsman
            display.println("\n"+this.skeletal + " respawns.\n");

        } else {
            return new DoNothingAction();
        }

        return lastAction;
    }

    public void reset(){
        this.addCapability(Status.RESET);
    }
}



