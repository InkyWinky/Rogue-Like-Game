package game.actions.consumeAction;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.FlaskOfCrimsonTears;


/**
 * @author Incy Lin
 * @version 1
 */
public class ConsumeFlask extends ConsumeAction {
    private FlaskOfCrimsonTears flask;

    public String s = "";


    public ConsumeFlask(Item item){
        super(item);

        this.flask = (FlaskOfCrimsonTears) item;

    }

    /**
     * the execute function decreases the uses remaining of the flask by 1 and restores the Player's HP by 250, capped to their max hp.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the string to display to the user
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        int usesRemaining = this.flask.getUsesRemaining();
        if (usesRemaining >0) {
            this.flask.setUsesRemaining(usesRemaining - 1);
            actor.heal(flask.getHP_RESTORATION()); //Heal player for 250 pts, capped at max hp//
            s = actor + " consumes " + flask;}
        else{s =  "No uses of Flask of Crimson Tears left";}
        return s;
    }


}
