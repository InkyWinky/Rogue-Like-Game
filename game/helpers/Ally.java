package game.helpers;


import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;

import edu.monash.fit2099.engine.positions.GameMap;
import game.utils.Status;

/**
 * A type of npc summoned by the player that helps them.
 * Created by:
 * @author Joanne Li Wen Yew
 */
public class Ally extends Helper {

    /**
     * Constructor.
     */
    public Ally(Actor actor) {
        super("Ally", 'A', 2,0,0, actor);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
    }

    /**
     * Returns a new collection of the Actions that the otherActor can do to the current Actor.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A collection of Actions.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actionList = new ActionList();
        if (!otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            super.allowableActions(otherActor, direction, map);
    }
        actionList.add(new DoNothingAction());
        return actionList;
    }
}
