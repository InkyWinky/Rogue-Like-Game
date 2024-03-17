package game.merchants;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.BuyAction;
import game.actions.SellAction;
import game.behaviours.Behaviour;
import game.utils.Status;
import game.weapons.*;

import java.util.HashMap;
import java.util.Map;
/**
 * The Trader class extends the actor class , it is responsible for the purchase and sale of weapons
 * Created by: Adwait Chooromoney
 * @author Adwait Chooromoney
 * Modified by:
 */
public class MerchantKale extends Actor {

    private final Map<Integer, Behaviour> behaviours = new HashMap<>();
    public MerchantKale() {
        super("Merchant Kale", 'K', 100);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        return lastAction;
    }

    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();

        // sell action

        for(int i = 0 ; i< otherActor.getWeaponInventory().size();i++)
        {   if("Club" == otherActor.getWeaponInventory().get(i).toString())
        {actions.add(new SellAction(new Club().toString(),Club.SellP,this.name));}
            if("Uchigatana" == otherActor.getWeaponInventory().get(i).toString()) {actions.add(new SellAction(new Uchigatana().toString(),Uchigatana.SellP,this.name));}
            if("GreatKnife" == otherActor.getWeaponInventory().get(i).toString()) {actions.add(new SellAction(new GreatKnife().toString(),GreatKnife.SellP,this.name));}
            if("Grossmesser" == otherActor.getWeaponInventory().get(i).toString()) {actions.add(new SellAction(new Grossmesser().toString(),Grossmesser.SellP,this.name));}
            if("Scimitar" == otherActor.getWeaponInventory().get(i).toString()) {actions.add(new SellAction(new Scimitar().toString(),Scimitar.SellP,this.name));}
        }

        // buy action
          actions.add(new BuyAction(new Uchigatana(), Uchigatana.BuyP,this.name));
          actions.add(new BuyAction(new GreatKnife(),GreatKnife.BuyP,this.name));
          actions.add(new BuyAction(new Club(),Club.BuyP,this.name));
        actions.add(new BuyAction(new Scimitar(),Scimitar.BuyP,this.name));

        return actions;
        }



    }


