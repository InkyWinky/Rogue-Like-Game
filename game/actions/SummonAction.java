package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.helpers.*;
import game.utils.RandomNumberGenerator;

/**
 * Action that spawns either an ally or an invader around its exits when summoned by the player.
 * Created by:
 * @author Joanne Li Wen Yew
 */
public class SummonAction extends Action{
    /**
     * The maximum number the random generator can generate as an integer
     */
    private static final int BOUND = 100;

    /**
     * The location that allows the player to summon ally or invader
     */
    private Location location;


    /**
     * Constructor for the SummonAction
     * @param location the location of where the summoning occurs
     */
    public SummonAction(Location location) {
        this.location = location;
    }

    /**
     * When executed, either an ally or an invader will be spawn. Both them have a 50% chance.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the result of the summong (eg. whether an ally or an invader is summoned)
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        int randInt = RandomNumberGenerator.getRandomInt(BOUND);
        if (randInt < 50){
            summon(new Ally(actor));
            result = "An Ally is summoned";
        }
        else{
            summon(new Invader(actor));
            result = "An Invader is summoned";
        }
        return result;
    }

    /**
     * Describes if the player wants to summon an ally or enemy
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Want to summon Ally/Invader?: ";
    }

    /**
     * Checks the exits of the location and if it doesn't contain an actor, an ally or an invader will be spawned in that location
     * @param actor the actor performing the action
     */
    public void summon(Actor actor) {
        for (Exit exit : location.getExits()) {
            Location destination = exit.getDestination();
            if (!destination.containsAnActor()) {
                destination.addActor(actor);
                break;
            }
        }
    }
}
