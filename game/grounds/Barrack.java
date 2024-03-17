package game.grounds;

import edu.monash.fit2099.engine.positions.Location;
import game.enemies.GodrickSoldier;
import game.utils.RandomNumberGenerator;

/**
 * A class that represents the Barrack
 * Created by:
 * @author Adwait Chooromoney
 * Modified by:
 *
 */
public class Barrack extends SpawningGround {
    /**
     * The maximum value the random number generator can generate as an integer
     */
    private static final int BOUND = 100;
    /**
     * The spawn chance in Barrack
     */
    private static final int SPAWN_CHANCE = 45;
    /**
     * Constructor.
     */
    public Barrack() {
        super('B');
    }

    /**
     * Method that spawns Godrick Soldiers
     *
     * @param location the location where an actor will be spawned
     */
    @Override
    public void spawn(Location location) {
        int randomInt = RandomNumberGenerator.getRandomInt(BOUND);
        if (randomInt <= SPAWN_CHANCE){
            location.addActor(new GodrickSoldier());
        }
    }
}
