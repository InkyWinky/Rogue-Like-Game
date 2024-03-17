package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SummonAction;
import game.utils.Status;

/**
 * A special type of ground that allows the player to summon either an ally or an invader
 * Created by:
 * @author Joanne Li Wen Yew
 */
public class SummonSign extends Ground {

    /**
     * Constructor.
     */
    public SummonSign() {
        super('=');
    }

    /**
     * If the player
     *
     * @param actor     the Actor acting
     * @param location  the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a new, empty collection of Actions
     */
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actionList = new ActionList();
        if (actor.hasCapability(Status.PLAYABLE)) { //if the actor is a player
            actionList.add(new SummonAction(location));
            return actionList;
        } else {
            actionList.add(new DoNothingAction());
            return actionList;
        }
    }
}

