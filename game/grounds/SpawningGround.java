package game.grounds;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;


/**
 * An abstract class that represents the grounds that can spawn actors every turn.
 * Created by:
 * @author Joanne Li Wen Yew
 * Modified by:
 *
 */
public abstract class SpawningGround extends Ground{

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public SpawningGround(char displayChar) {
        super(displayChar);
    }

    /**
     * SpawningGround can also experience the joy of time.
     * At each turn, if the location doesn't already have an actor, an actor will be spawned
     *
     * @param location The location of the SpawningGround
     */
    public void tick(Location location) {

        if (!location.containsAnActor()) {
            spawn(location);
        }
    }

    /**
     * Method that spawns an actor at a location
     * @param location the location where an actor will be spawned
     */
    public abstract void spawn(Location location);

}

