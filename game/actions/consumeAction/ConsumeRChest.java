package game.actions.consumeAction;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

import game.items.Chest;

import game.utils.RandomNumberGenerator;
import game.weapons.*;



import static game.utils.RuneManager.findIndex;


/**
 * @author Adwait Chooromoney
 *
 */
public class ConsumeRChest extends ConsumeAction {

    public ConsumeRChest(Item item){super(item);}

    /**
     * the execute function gives the player a random weapons
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the string to display to the user
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        actor.removeItemFromInventory(actor.getItemInventory().get(findIndex(actor,new Chest())));
        String ws ="";
        int a = RandomNumberGenerator.getRandomInt(0,8);
        if(a==0){actor.addWeaponToInventory(new AstrologerStaff());ws = new AstrologerStaff().toString();}
        if(a==1){actor.addWeaponToInventory(new AxeofGodrick());ws = new AxeofGodrick().toString();}
        if(a==2){actor.addWeaponToInventory(new Club());ws = new Club().toString();}
        if(a==3){actor.addWeaponToInventory(new GraftedDragon());ws = new GraftedDragon().toString();}
        if(a==4){actor.addWeaponToInventory(new GreatKnife());ws = new GreatKnife().toString();}
        if(a==5){actor.addWeaponToInventory(new Grossmesser());ws = new Grossmesser().toString();}
        if(a==6){actor.addWeaponToInventory(new HeavyCrossbow());ws = new HeavyCrossbow().toString();}
        if(a==7){actor.addWeaponToInventory(new Scimitar());ws = new Scimitar().toString();}
        if(a==8){actor.addWeaponToInventory(new Uchigatana());ws = new Uchigatana().toString();}

        return ws + " was added to " + actor;
    }


}
