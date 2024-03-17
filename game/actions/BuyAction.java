package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.RuneManager;

public class BuyAction extends Action {
    public WeaponItem weapon1;
    public Integer a;
    public String merchant;
    public BuyAction(WeaponItem weapon, int a,String m) {
        this.weapon1 = weapon;
        this.a = a;
    this.merchant = m;}



    @Override
    public String execute(Actor actor, GameMap map) {
        RuneManager runeManager = new RuneManager();
        String s = " could not be bought";
        if (runeManager.RuneNumber(actor)>a )
        {actor.addWeaponToInventory(weapon1);
        runeManager.RemoveRune(actor,a);
        s = " has been bought";}

        return  weapon1.toString() + s;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Hi I am "+this.merchant+", want to buy a "+ weapon1.toString()+"?" ;
    }
}
