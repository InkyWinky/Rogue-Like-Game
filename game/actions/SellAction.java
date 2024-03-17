package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.utils.RuneManager;
import game.utils.Status;
import game.weapons.Club;
import game.weapons.GreatKnife;
import game.weapons.Uchigatana;

public class SellAction extends Action {
    public String item;
    public Integer a;
    public String merchant;
    public SellAction(String item, int a, String m) {
        this.item = item;
    this.a = a;
    this.merchant = m;}



    @Override
    public String execute(Actor actor, GameMap map) {
        RuneManager runeManager = new RuneManager();
        for(int i = 0 ; i< actor.getWeaponInventory().size();i++) {
            if (item == actor.getWeaponInventory().get(i).toString()) {
                actor.removeWeaponFromInventory(actor.getWeaponInventory().get(i));
                runeManager.AddRunes(actor,a);
                break;
            }
        }
        for(int i = 0 ; i< actor.getItemInventory().size();i++) {
            if (item == actor.getItemInventory().get(i).toString()) {
                actor.removeItemFromInventory(actor.getItemInventory().get(i));
                runeManager.AddRunes(actor,a);
                break;
            }
        }


        return item + " has been Sold ";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Hi I am "+this.merchant +", want to sell a "+ item+"?" ;
    }
}