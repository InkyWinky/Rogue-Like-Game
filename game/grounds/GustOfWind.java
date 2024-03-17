package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.*;
import game.utils.RandomNumberGenerator;

/**
 * A class that represents the Gust of Wind.
 * Created by:
 * @author Joanne Li Wen Yew
 * Modified by:
 *
 */
public class GustOfWind extends SpawningGround {
    /**
     * The maximum value the random number generator can generate as an integer
     */
    private static final int BOUND = 100;
    /**
     * The spawn chance in the west side if the gust of wind
     */
    private static final int WEST_SPAWN_CHANCE = 33;
    /**
     * The spawn chance in the east side if the gust of wind
     */
    private static final int EAST_SPAWN_CHANCE = 4;

    /**
     * Constructor.
     *
     */
    public GustOfWind() {
        super('&');
    }

    /**
     * Method that spawns Lone Wolf or Giant Dog depending on the location
     * on the map (if it's east or west)
     *
     * @param location the location where an actor will be spawned
     */
    public void spawn(Location location) {
        int randomInt = RandomNumberGenerator.getRandomInt(BOUND);
        int halfWidth = (location.map().getXRange().max())/2;
        if (location.x() <= halfWidth) {
            if (randomInt <= WEST_SPAWN_CHANCE) {
                location.addActor(new LoneWolf());
            }
        }
        else {
            if (randomInt <= EAST_SPAWN_CHANCE) {
                location.addActor(new GiantDog());
            }
        }
    }
}

