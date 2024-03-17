package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.items.Door;

/**
 * The action for passing through a door to another map
 * Created by:
 * @Author Incy Lin
 */
public class EnterDoorAction extends Action {
    private Door entryDoor;//the door that provides this action

    /**
     * Constructor for EnterDoorAction
     * @param entryDoor -the door you enter through
     */
    public EnterDoorAction(Door entryDoor){
        this.entryDoor=entryDoor;
    }

    /**
     * Moves the actor to the exit of the door in the other map
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Location moveToLocation = entryDoor.getExitDoorLocation(); //Get location of exit door
        map.moveActor(actor, moveToLocation);//Move to location of exit door
        return actor + " entered " + entryDoor;
    }

    /**
     * Menu description of this action
     * @param actor The actor performing the action.
     * @return String
     */
    public String menuDescription(Actor actor) {return actor + " enters " + entryDoor;}
}
