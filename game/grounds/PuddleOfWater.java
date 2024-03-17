package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.*;
import game.utils.RandomNumberGenerator;


/**
 * A class that represents the Puddle of Water
 * Created by:
 * @author Joanne Li Wen Yew
 * Modified by:
 *
 */
public class PuddleOfWater extends SpawningGround {
    /**
     * The maximum value the random number generator can generate as an integer
     */
    private static final int BOUND = 100;

    /**
     * The spawn chance in the west side if the puddle of water
     */
    private static final int WEST_SPAWN_CHANCE = 2;
    /**
     * The spawn chance in the east side if the puddle of water
     */
    private static final int EAST_SPAWN_CHANCE = 1;
    /**
     * Constructor.
     */
    public PuddleOfWater() {
        super('~');
    }

    /**
     * Method that spawns Giant Crab or Giant Crayfish depending on the location
     * on the map (if it's east or west)
     *
     * @param location the location where an actor will be spawned
     */
    public void spawn(Location location) {
        int randomInt = RandomNumberGenerator.getRandomInt(BOUND);
        int halfWidth = (location.map().getXRange().max())/2;
        if (location.x() <= halfWidth) {
            if (randomInt <= WEST_SPAWN_CHANCE) {
                location.addActor(new GiantCrab());
            }
        }
        else {
            if (randomInt <= EAST_SPAWN_CHANCE) {
                location.addActor(new GiantCrayfish());
            }
        }
    }
}
