package game.actions.consumeAction;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.FlaskOfCrimsonTears;

import game.items.GoldenSeeds;


import static game.utils.RuneManager.findIndex;

/**
 * @author Adwait Chooromoney
 *
 */
public class ConsumeGD extends ConsumeAction {

    private FlaskOfCrimsonTears flask;



    public ConsumeGD(Item item){
        super(item);
        this.flask = (FlaskOfCrimsonTears) item;
    }

    /**
     * the execute function returns back the total flask the player has to 2
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the string to display to the user
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        actor.removeItemFromInventory(actor.getItemInventory().get(findIndex(actor,new GoldenSeeds())));

        this.flask.setUsesRemaining(2);

        return actor + " consumed Golden Seeds";
    }


}
