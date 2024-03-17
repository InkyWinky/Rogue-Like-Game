package game.actions.consumeAction;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;


/**
 * @author Adwait Chooromoney
 *
 */
public abstract class ConsumeAction extends Action {


    Item item ;


    public ConsumeAction(Item item){this.item = item;}

    /**
     * the execute function returns back the total flask the player has to 2
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the string to display to the user
     */
    @Override
    public String execute(Actor actor, GameMap map) {return null;}

    /**
     * Describe the action in a format suitable for displaying in the menu.
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string, e.g. "Player picks up the rock"
     */
    @Override
    public String menuDescription(Actor actor) {return actor + " consumes "+this.item+"?" ;}
}
