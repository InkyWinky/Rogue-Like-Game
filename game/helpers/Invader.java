package game.helpers;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.DespawnAction;
import game.behaviours.FollowBehaviour;
import game.helpers.Helper;
import game.player.Player;
import game.utils.Status;

/**
 *
 * A type of npc summoned by the player that can attack them.
 * Created by:
 * @author Joanne Li Wen Yew
 */
public class Invader extends Helper {

    /**
     * Constructor.
     */
    public Invader(Actor actor) {
        super("Invader", 'ඞ', 2,1358,5578, actor);
        this.addCapability(Status.CANNOT_ATTACK_INVADER);

    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (this.hasCapability(Status.RESET)){ //Remove invader when resetting
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
        return super.playTurn(actions, lastAction, map, display);
    }
}

