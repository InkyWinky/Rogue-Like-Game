package game.utils;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.items.Rune;
import game.player.Player;

import java.util.List;

/**
 * Class representing the RuneManager.
 * It is reponsible to print the number if runes , add runes
 * check the rune number and remove runes
 * Created by: Adwait Chooromoney
 * @author Adwait Chooromoney
 * Modified by:
 */
public class RuneManager {

    /**
     * @param actor
     * @return  number of runes
     * this method prints the rune number
     **/





    public static String printRunes(Actor actor)
    {
        List<Item> a = actor.getItemInventory();
        Rune rune = (Rune) a.get(findIndex(actor,new Rune()));
        return  "Rune: "+ rune.getRuneV();
    }

    /**
     * @param actor and n
     * @return  no return
     * this method add runes
     **/
    public  void AddRunes(Actor actor, int n)
    {   List<Item> a = actor.getItemInventory();
        Rune rune = (Rune) a.get(findIndex(actor,new Rune()));
        rune.setRuneV(rune.getRuneV()+n);
    }

    /**
     * @param actor
     * @return  number of runes in integer
     * this method returns the rune number
     **/
    public  Integer RuneNumber(Actor actor)
    {   List<Item> a = actor.getItemInventory();
        Rune rune = (Rune) a.get(findIndex(actor,new Rune()));
        return rune.getRuneV();
    }
    /**
     * @param actor
     * @return  no return
     * this method removes the number of runes
     **/
    public  void RemoveRune(Actor actor, int n)
    {   RuneManager runeManager = new RuneManager();
        List<Item> a = actor.getItemInventory();
        Rune rune = (Rune) a.get(findIndex(actor,new Rune()));
        if(runeManager.RuneNumber(actor)>n)
        {rune.setRuneV(rune.getRuneV()-n);}
    }
    public  void SetRuneValue(Actor actor, int n)
    {   RuneManager runeManager = new RuneManager();
        List<Item> a = actor.getItemInventory();
        Rune rune = (Rune) a.get(findIndex(actor,new Rune()));

        rune.setRuneV(n);
    }
    public static Integer findIndex(Actor actor, Item item)
    {   List<Item> a = actor.getItemInventory();
        int j = 0;
        for(int i =0 ;i<a.size();i++)
        {if(item.toString() == a.get(i).toString()){ j = i; break;}}
        return j;
    }
    public static Integer findNextIndex(Actor actor, Item item)
    {   List<Item> a = actor.getItemInventory();
        int j = 0;
        for(int i =0 ;i<a.size();i++)
        {if(item.toString() == a.get(i).toString()){ j = i;}}
        return j;
    }

    public void addRuneDeath(Actor actor){
        RuneManager runeManager = new RuneManager();
        Rune rune = (Rune) actor.getItemInventory().get(findNextIndex(actor,new Rune()));

        runeManager.AddRunes(actor,rune.getRuneV());
        actor.removeItemFromInventory(actor.getItemInventory().get(findNextIndex(actor,new Rune())));
    }

}
