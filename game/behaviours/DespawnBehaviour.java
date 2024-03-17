package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.DespawnAction;

import java.util.Random;

/**
 * Behaviour of an enemy that determines if it can be despawned
 * Created by:
 * @author Joanne Li Wen Yew
 */
public class DespawnBehaviour implements Behaviour {
    /**
     * An instance of the Random class
     */
    private Random rand = new Random();

    /**
     * The chances of the actor being despawned
     */
    private static final int DESPAWN_CHANCE = 10;

    /**
     * The maximum value the random generator can generate
     */
    private static final int BOUND = 100;


    /**
     * Determines whether an actor will be de-spawned this turn by randomly generating a number.
     * If it falls within the de-spawn chance, a DespawnAction will be called.
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return DespawnAction for the actor, or null it's not within the de-spawn chance
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (rand.nextInt(BOUND) <= DESPAWN_CHANCE){
            return new DespawnAction(actor);
        }
        return null;
    }
}

