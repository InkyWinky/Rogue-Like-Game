package game.items;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.EnterDoorAction;


/**
 * Class for Door
 * Created by:
 * @Author Incy Lin
 */
public class Door extends Item{
    private Location doorLocation; //Location that the door is at
    private Location exitDoorLocation; //Location that the door leads to

    /**
     * Constructor for door
     * @param name -The name of the door
     * @param location -The location of the door
     * @param exitDoorLocation -The location that the door leads to
     */
    public Door(String name, Location location, Location exitDoorLocation){
        super(name, 'D', false);
        this.doorLocation = location;
        this.exitDoorLocation = exitDoorLocation;
        super.addAction(new EnterDoorAction(this));
    }

    /**
     * Getter fot the location of the door
     * @return doorLocation
     */
    public Location getDoorLocation() {
        return doorLocation;
    }

    /**
     * Getter for the location that the door leads to
     * @return exitDoorLocation
     */
    public Location getExitDoorLocation() {
        return exitDoorLocation;
    }
}
