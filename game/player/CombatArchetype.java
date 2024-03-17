package game.player;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public abstract class CombatArchetype {
    private String name;
    private int hitpoints;
    private WeaponItem weapon;
    public CombatArchetype(String name, int hitpoints, WeaponItem weapon){
        this.name = name;
        this.hitpoints = hitpoints;
        this.weapon = weapon;

    }
    public CombatArchetype(String name){
        this.name = name;
    }

    /**
     * This method alters the properties of the player to match the class, it adds the weapon and assigns
     * the hp associated with that class to the player.
     * @param actor -The player
     */
    public void assignClassToActor(Actor actor){
        actor.addWeaponToInventory(weapon);
        actor.resetMaxHp(hitpoints);
    }

    public void assignClassToPlayer(Player player){
        player.addWeaponToInventory(weapon);
        player.resetMaxHp(hitpoints);
        player.setMaxHP(hitpoints);
    }

    public String getName() {
        return name;
    }

}
