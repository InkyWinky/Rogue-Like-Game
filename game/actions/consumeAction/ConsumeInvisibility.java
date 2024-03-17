package game.actions.consumeAction;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

import game.items.Invisibility;
import game.player.Player;

import static game.utils.RuneManager.findIndex;

/**
 * @author Adwait Chooromoney
 *
 */
public class ConsumeInvisibility extends ConsumeAction {


    public ConsumeInvisibility(Item item){super(item);}

    /**
     * the execute function will allow the actor to move 3 turns without being harmed by the enemy
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the string to display to the user
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        actor.removeItemFromInventory(actor.getItemInventory().get(findIndex(actor,new Invisibility())));
        Player player = (Player) actor;
        player.setTurn(4);
        player.setInvisble(1);
        return actor + " consumed the Invisibility Potion";
    }




}
