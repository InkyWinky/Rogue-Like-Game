package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * An action executed when an actor is despawned.
 * Created by:
 * @author Joanne Li Wen Yew
 */
public class DespawnAction extends Action {
    private Actor actor;

    /**
     * Constructor.
     * @param actor getting de-spawned
     */
    public DespawnAction(Actor actor) {

        this.actor = actor;
    }

    /**
     * When executed, actor is removed from the map
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        return menuDescription(actor);
    }

    /**
     * Describes which actor is removed from the map
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " has been removed from the map.";
    }
}
