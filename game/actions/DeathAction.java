package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.ResetManager;
import game.enemies.Enemy;
import game.items.Rune;
import game.player.Player;
import game.utils.RandomNumberGenerator;
import game.utils.RuneManager;
import game.utils.Status;

/**
 * An action executed if an actor is killed.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Joanne Li Wen Yew
 *
 */
public class DeathAction extends Action {
    /**
     *The actor performing the attack action
     */
    private Actor attacker;
    /**
     *An instance of Display class
     */
    private Display display = new Display();

    /**
     * Constructor for DeathAction
     * @param actor
     */
    public DeathAction(Actor actor) {
        this.attacker = actor;
    }

    /**
     * When the target is killed, the items & weapons carried by target
     * will be dropped to the location in the game map where the target was
     *
     * @param target The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";

        ActionList dropActions = new ActionList();
        RuneManager runeManager = new RuneManager();
        // drop all items

        if (target.hasCapability(Status.PLAYABLE)){ //Check if target is player, if so, reset game
            if (target.hasCapability(Status.RESTING)){ //Remove resting status if player dies
                target.removeCapability(Status.RESTING);
            }
            result = "YOU DIED";
            ResetManager.getInstance().run();//Reset game
            Player player = (Player) target;
            //Dropping rune in previous location
            Rune rune = new Rune();
            rune.togglePortability();
            if (runeManager.RuneNumber(player)>0) {
                rune.setRuneV(runeManager.RuneNumber(player));
                runeManager.SetRuneValue(player, 0);
                player.getPrevLocation().addItem(rune);
            }

            map.removeActor(target);
            map.addActor(target, player.getLastVisitedSOLGLoc());
            return result;
        }

        else{ //If actor is enemy
            for (Item item : target.getItemInventory())
                dropActions.add(item.getDropAction(target));
            for (WeaponItem weapon : target.getWeaponInventory())
                dropActions.add(weapon.getDropAction(target));
            for (Action drop : dropActions)
                drop.execute(target, map);
        }
        // remove actor
        map.removeActor(target);
        result += System.lineSeparator() + menuDescription(target);
        return result;
    }

    /**
     * Describes which target is killed by the attacker
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed\n";
    }
}
