package game.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.DeathAction;
import game.utils.Status;

/**
 * A type of enemy that are inhabitants of the Stormveil Castle
 * Created by:
 * @author Joanne Li Wen Yew
 */
public abstract class StormveilInhabitants extends Enemy{
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     * @param min_runes
     * @param max_runes
     */
    public StormveilInhabitants(String name, char displayChar, int hitPoints, int min_runes, int max_runes) {
        super(name, displayChar, hitPoints, min_runes, max_runes);
        this.addCapability(Status.IS_STORMVEIL);
    }

    /**
     * Determines if the target of the enemy has a special death action
     *
     * @param target the target of the attacking enemy
     * @param map the map in which the target is on
     * @return the death action for the target as a string
     */
    @Override
    public String getDeathAction(Actor target, GameMap map) {
        return new DeathAction(target).execute(target,map);
    }
}
