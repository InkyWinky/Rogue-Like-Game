package game.grounds;

import edu.monash.fit2099.engine.positions.Location;
import game.enemies.Dog;
import game.enemies.HeavySkeletalSwordsman;
import game.enemies.SkeletalBandit;
import game.utils.RandomNumberGenerator;

/**
 * A class that represents the Cage .
 * Created by: Adwait Chooromoney
 * @author Adwait Chooromoney
 * Modified by:
 *
 */
public class Cage extends SpawningGround {
    /**
     * The maximum value the random number generator can generate as an integer
     */
    private static final int BOUND = 100;
    /**
     * The spawn chance in cage
     */
    private static final int SPAWN_CHANCE = 37;
    /**
     * Constructor.
     */
    public Cage() {
        super('<');
    }

    /**
     * Method that spawns dogs
     *
     * @param location the location where an actor will be spawned
     */
    @Override
    public void spawn(Location location) {
        int randomInt = RandomNumberGenerator.getRandomInt(BOUND);
        if (randomInt <= SPAWN_CHANCE){
            location.addActor(new Dog());
        }
    }
}
