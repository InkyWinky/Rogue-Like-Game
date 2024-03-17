package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AreaAttackAction;
import game.actions.AttackAction;
import game.actions.DeathAction;
import game.actions.DespawnAction;
import game.behaviours.Behaviour;
import game.utils.Status;

import java.util.HashMap;
import java.util.Map;

/**
 * An enemy that has a special attack function.
 * Created by:
 * @author Adwait Chooromoney
 * Modified By:
 */
public class GodricktheGrafted extends Actor{
    public Map<Integer, Behaviour> behaviours = new HashMap<>();
    public int max_runes;
    public int min_runes;

    /**
     * Constructor for the Godrick the Grafted
     */
    public GodricktheGrafted() {
        super("Godrick the Grafted",'Y',6080);
        this.min_runes = 20000;
        this.max_runes = 20000;

    }

    /**
     * Creates and returns an intrinsic weapon for Dog
     *
     * @return a freshly-instantiated IntrinsicWeapon
     */

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(101, "Bites", 93);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (this.hasCapability(Status.RESET)){ //Remove enemy when resetting
            return new DespawnAction(this);
        }
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null) {
                return action;
            }
        }
        return new DoNothingAction();
    }

    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actionList = new ActionList();
        if (!otherActor.getWeaponInventory().isEmpty()){
            actionList.add(new AttackAction(this,direction, otherActor.getWeaponInventory().get(0))); //attack action using weapon item
        }
        actionList.add(new AttackAction(this,direction)); //attack action using intrinsic weapon
        if (otherActor.hasCapability(Status.SPECIAL_SKILL)) {
            actionList.add(new AreaAttackAction(otherActor.getWeaponInventory().get(0)));
        }
        return actionList;
    }


    public String getDeathAction(Actor target, GameMap map) {
        return new DeathAction(target).execute(target,map);
    }


}
