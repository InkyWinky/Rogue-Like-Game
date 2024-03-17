package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.utils.RuneManager;
import game.weapons.AxeofGodrick;
import game.weapons.GraftedDragon;

public class ExchangeAction extends Action {
    public Item item;
    public String merchant;
    public ExchangeAction(Item item, String m) {this.item=item;this.merchant=m;};



    @Override
    public String execute(Actor actor, GameMap map) {
        for (int i = 0; i < actor.getItemInventory().size(); i++) {
            if ("Remembrance of the Grafted" == actor.getItemInventory().get(i).toString()) {
                actor.removeItemFromInventory(actor.getItemInventory().get(i));
                if(item.toString() == "Axe of Godrick"){actor.addWeaponToInventory(new AxeofGodrick());}
                if(item.toString() == "Grafted Dragon"){actor.addWeaponToInventory(new GraftedDragon());}
            }

        } return item.toString() + " has been exchanged ";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Hi I am "+this.merchant+", want to exchange a remembrance with a  "+ item.toString()+"?" ;
    }
}