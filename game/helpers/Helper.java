package game.helpers;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ResetManager;
import game.Resettable;
import game.actions.AreaAttackAction;
import game.actions.AttackAction;
import game.actions.DespawnAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import game.display.ChooseClassMenu;
import game.player.CombatArchetype;
import game.utils.Status;
import java.util.TreeMap;

/**
 * A Helper that can be summoned by the player.
 * Created by:
 * @author Joanne Li Wen Yew
 */
public abstract class Helper extends Actor implements Resettable {

    /**
     * The different behaviours a Helper have stored in a treemap
     */
    protected TreeMap<Integer, Behaviour> behaviours = new TreeMap<>();
    /**
     * An instance of the ChooseClassMenu class
     */
    private ChooseClassMenu chooseClassMenu = new ChooseClassMenu();
    private int max_runes;
    private int min_runes;
    private Actor player;

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Helper(String name, char displayChar, int hitPoints, int min_runes, int max_runes, Actor actor) {
        super(name, displayChar,hitPoints);
        CombatArchetype combatArchetype = chooseClassMenu.randomArchetype();
        combatArchetype.assignClassToActor(this);
        this.behaviours.put(3, new WanderBehaviour());
        this.behaviours.put(1, new AttackBehaviour());
        this.player = actor;
        ResetManager.getInstance().registerResettable(this);
        this.min_runes = min_runes;
        this.max_runes = max_runes;
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
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (this.hasCapability(Status.RESET)){ //Remove Helper when resetting
            return new DespawnAction(this);
        }
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null) {
                return action;
            }
        }
        return new DoNothingAction();
    }
    public void reset(){
        if (!this.player.hasCapability(Status.RESTING)){
            this.addCapability(Status.RESET);//Add capability reset only if player is not resting (player died)
        }
    }
}
