package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.SkeletalBandit;
import game.utils.RandomNumberGenerator;
import game.enemies.HeavySkeletalSwordsman;

/**
 * A class that represents the Graveyard.
 * Created by:
 * @author Joanne Li Wen Yew
 * Modified by:
 *
 */
public class Graveyard extends SpawningGround {
    /**
     * The maximum value the random number generator can generate as an integer
     */
    private static final int BOUND = 100;
    /**
     * The spawn chance in graveyard
     */
    private static final int SPAWN_CHANCE = 27;
    /**
     * Constructor.
     */
    public Graveyard() {
        super('n');
    }

    /**
     * Method that spawns Heavy Skeletal Swordsman or Skeletal Bandit depending on the location
     * on the map (if it's east or west)
     *
     * @param location the location where an actor will be spawned
     */
    @Override
    public void spawn(Location location) {
        int randomInt = RandomNumberGenerator.getRandomInt(BOUND);
        if (randomInt <= SPAWN_CHANCE){
            int halfWidth = (location.map().getXRange().max())/2;
            if (location.x() <= halfWidth) {
                location.addActor(new HeavySkeletalSwordsman());
            }
            else {
                location.addActor(new SkeletalBandit());
            }
        }
    }
}
