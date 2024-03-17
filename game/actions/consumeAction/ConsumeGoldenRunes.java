package game.actions.consumeAction;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

import game.items.GoldenRunes;
import game.utils.RandomNumberGenerator;
import game.utils.RuneManager;

import static game.utils.RuneManager.findIndex;

/**
 * @author Incy Lin
 * @version 1
 */
public class ConsumeGoldenRunes extends ConsumeAction {

    public GoldenRunes gRunes;
    public String s = "";

    public int a;
    public ConsumeGoldenRunes(Item item){
        super(item);
        {this.gRunes  = (GoldenRunes) item;}
    }

    /**
     * the execute function decreases the uses remaining of the flask by 1 and restores the Player's HP by 250, capped to their max hp.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the string to display to the user
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        RuneManager runeManager = new RuneManager();
        runeManager.AddRunes(actor,RandomNumberGenerator.getRandomInt(200,10000));
        actor.removeItemFromInventory(actor.getItemInventory().get(findIndex(actor,new GoldenRunes())));
        s = actor + " consumes " + gRunes;




        return s;
    }


}
