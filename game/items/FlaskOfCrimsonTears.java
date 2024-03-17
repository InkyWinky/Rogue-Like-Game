package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.ResetManager;
import game.Resettable;
import game.actions.consumeAction.ConsumeFlask;

/**
 * The flask of Crimson Tears restores 250 hp to the player and can only be used twice
 * @author Incy Lin
 * @version 1
 */
public class FlaskOfCrimsonTears extends Item implements Resettable {
    private int usesRemaining; //Attribute to store uses remaining
    private final int MAX_USES = 2;// Constant for the maximum number of times the flask can be used
    private final int HP_RESTORATION = 250; //Constant for the amount of hp the flask restores

    /**
     * Constructor initialises the flask to start with 2 uses
     */
    public FlaskOfCrimsonTears(){
        super("Flask of Crimson Tears", 'f', false); //False portability since flask cannot be dropped
        this.usesRemaining = MAX_USES;
        super.addAction(new ConsumeFlask(this));
        ResetManager.getInstance().registerResettable(this);
    }

    /**
     * Method called on game reset, resets the uses of the flask to 2
     */
    public void reset(){
        this.usesRemaining = MAX_USES;
    }

    /**
     * Getter for usesRemaining
     * @return number of uses remaining of the flask
     */
    public int getUsesRemaining() {
        return usesRemaining;
    }
    /**
     * Setter for usesRemaining
     * @Param Integer for the uses remaining
     */
    public void setUsesRemaining(int usesRemaining) {
        this.usesRemaining = usesRemaining;
    }

    /**
     * Getter for amount of health the flask restores
     * @return HP_RESTORATION value (integer)
     */
    public int getHP_RESTORATION() {
        return HP_RESTORATION;
    }
}
