package game;

import java.util.ArrayList;
import java.util.List;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Incy Lin
 *
 */
public class ResetManager {
    private List<Resettable> resettables;
    private static ResetManager instance;
    /**
     * HINT 1: where have we seen a private constructor before?
     * HINT 2: see the instance attribute above.
     */
    private ResetManager() {
        this.resettables = new ArrayList<>();
    }

    public void run() {
        //Go through arrayList of resettables and run their reset functions
        for (Resettable resettable: resettables){
            resettable.reset();
        }
        System.out.println("Game has reset");
         }

    public void registerResettable(Resettable resettable) {
        this.resettables.add(resettable);
    }

    public void removeResettable(Resettable resettable) {
        this.resettables.remove(resettable);
    }

    public static ResetManager getInstance(){
        if (instance == null){
            instance = new ResetManager();
        }
        return instance;
    }
}
