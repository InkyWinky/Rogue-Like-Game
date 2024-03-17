package game.actions.consumeAction;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

import game.items.Teleport;
import game.utils.RandomNumberGenerator;

import static game.utils.RuneManager.findIndex;

/**
 * @author Adwait Chooromoney
 *
 */
public class ConsumeRTeleport extends ConsumeAction {
    public ConsumeRTeleport(Item item){super(item);}

    /**
     * the execute function returns back the total flask the player has to 2
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the string to display to the user
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        actor.removeItemFromInventory(actor.getItemInventory().get(findIndex(actor,new Teleport())));
        boolean m = isActor(map,actor,1);

        return actor + " has moved to another location";
    }


    public boolean isActor( GameMap map, Actor actor, int a)
    {   if (a == 0 ){return true;}
        else
        {   int x = RandomNumberGenerator.getRandomInt(0,map.getXRange().max());
            int y = RandomNumberGenerator.getRandomInt(0,map.getYRange().max());
            boolean b = map.at(x, y).canActorEnter(actor);
            if( b == true){ isActor(map,actor,1);}
            else {isActor(map,actor,0); map.moveActor(actor,map.at(x,y));}
        }

        return false;
    }
    
}
