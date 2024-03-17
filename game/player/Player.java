package game.player;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Location;
import game.ResetManager;
import game.Resettable;
import game.actions.consumeAction.*;
import game.items.*;

import game.behaviours.FollowBehaviour;
import game.items.FlaskOfCrimsonTears;
import game.items.GoldenRunes;
import game.utils.Status;
import game.items.Rune;
import game.utils.RuneManager;
import game.actions.AreaAttackAction;
import game.actions.AttackAction;

import javax.net.ssl.SSLContext;
import java.util.List;


/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Adwait Chooromoney, Incy Lin, Joanne Yew
 */
public class Player extends Actor implements Resettable {

	private final Menu menu = new Menu();
	private Location lastVisitedSOLGLoc;
	private FlaskOfCrimsonTears flask;
	private int maxHP;
	private Location prevLocation;
	private int invisble;
	private int turn;


	/**
	 * Constructor for player
	 * @param combatArchetype - Class that user chooses the player will be
	 * @param location - Location that the player is spawned at
	 */
	public Player(CombatArchetype combatArchetype, Location location) {
		super("Tarnished", '@', 0); //Initialise with 0 hitpoints-will change when assign player class
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability(Status.PLAYABLE);
		this.addCapability(Status.FOLLOWABLE);
		FlaskOfCrimsonTears flask = new FlaskOfCrimsonTears();
		this.flask = flask;
		this.addItemToInventory(flask);
		ResetManager.getInstance().registerResettable(this);
		combatArchetype.assignClassToPlayer(this);
		this.addItemToInventory(new Rune());
		this.prevLocation = location;
		this.lastVisitedSOLGLoc = location; //Initialise to spawning location
	}

	/**
	 * Function used at each turn
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return Action
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		RuneManager runeManager = new RuneManager();
		// Handle multi-turn Actions
		// prints the number of runes available
		display.println(name+" "+ printHp()+", "+  runeManager.printRunes(this));
		//Print number of flask uses remaining
		display.println("Flask of Crimson Tears uses remaining: "+ flask.getUsesRemaining());
		if(lastAction instanceof MoveActorAction){ //If player moved, store previous location
			MoveActorAction moveAction = (MoveActorAction) lastAction;
			Location currentLocation = map.locationOf(this);
			prevLocation = currentLocation;
		}
		this.CheckInvisible(display);
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		// checks if GoldenRunes are present in item
		if(CheckInv(this,new GoldenRunes()))
		{actions.add(new ConsumeGoldenRunes(new GoldenRunes()));}
		if(CheckInv(this,new Chest()))
		{actions.add(new ConsumeRChest(new Chest()));}
		if(CheckInv(this,new GoldenSeeds()))
		{actions.add(new ConsumeGD(flask));}
		if(CheckInv(this,new Invisibility()))
		{actions.add(new ConsumeInvisibility(new Invisibility()));}

		if(CheckInv(this,new Rune()) && RuneManager.findNextIndex(this,new Rune())>RuneManager.findIndex(this,new Rune()) )
		{runeManager.addRuneDeath(this);}
		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	/**
	 * The allowable actions
	 * @param otherActor the Actor that might be performing attack
	 * @param direction  String representing the direction of the other Actor
	 * @param map        current GameMap
	 * @return ActionList
	 */
	@Override
	public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
		ActionList actionList = new ActionList();
		if (!otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
			actionList.add(new FollowBehaviour(this).getAction(otherActor,map));
			if (!otherActor.getWeaponInventory().isEmpty()){
				actionList.add(new AttackAction(this,direction, otherActor.getWeaponInventory().get(0))); //attack action using weapon item
			}
			actionList.add(new AttackAction(this,direction)); //attack action using intrinsic weapon
			if (otherActor.hasCapability(Status.SPECIAL_SKILL)) {
				actionList.add(new AreaAttackAction(otherActor.getWeaponInventory().get(0)));
			}


			return actionList;
		}
		else {
			actionList.add(new DoNothingAction());
			return actionList;
		}
	}


	/**
	 * Checks if the player has invisible status and displays how many turns left of invisibility
	 * @param display
	 */
	public void CheckInvisible(Display display)
	{
		if (getInvisble()>0){
			if (!this.hasCapability(Status.INVISIBLE)) {this.addCapability(Status.INVISIBLE);};
			if( (getTurn()-1) == 0) {setInvisble(0);this.removeCapability(Status.INVISIBLE);}
			this.setTurn(getTurn()-1);
			display.println("Number of turns left to be invisible:"+ getTurn());
			}

	}

	/**
	 * Gets the last visited site of lost grace
	 * @return Location of last visited site of lost grace
	 */
	public Location getLastVisitedSOLGLoc() {
		return lastVisitedSOLGLoc;
	}

	/**
	 * Gets the number of turns that invisibility has lasted
	 * @return integer
	 */
	public int getInvisble() {
		return invisble;
	}

	/**
	 * Setter for the number of turns invisibility has lasted
	 * @param invisble
	 */
	public void setInvisble(int invisble) {
		this.invisble = invisble;
	}

	/**
	 * Getter for turn number
	 * @return integer that is turn number
	 */
	public int getTurn() {
		return turn;
	}

	/**
	 * Setter for turn number
	 * @param turn -integer
	 */
	public void setTurn(int turn) {
		this.turn = turn;
	}

	/**
	 * Sets the last visited site of lost grace location
	 * @param lastVisitedSOLGLoc
	 */
	public void setLastVisitedSOLGLoc(Location lastVisitedSOLGLoc) {
		this.lastVisitedSOLGLoc = lastVisitedSOLGLoc;
	}

	@Override
	/**
	 * Reset function to run when resetting game, resets HP to maximum
	 */
	public void reset() {
		this.resetMaxHp(maxHP); //Reset to full health
	}

	/**
	 * Setter for max hp
	 * @param maxHP
	 */
	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	/**
	 * Checks if actor has invisibility potion
	 * @param actor
	 * @param item
	 * @return boolean true or false
	 */
	public Boolean CheckInv(Actor actor, Item item)
	{
		List<Item> a = actor.getItemInventory();
		for(int i =0 ;i<a.size();i++)
		{if(item.toString() == a.get(i).toString()){ return true;}};
		return false;
	}

	/**
	 * Getter for previous location
	 * @return
	 */
	public Location getPrevLocation() {
		return prevLocation;
	}
}
