package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.DeathAction;
import game.actions.RestAction;
import game.player.Player;
import game.utils.Status;

/**
 * A class that represents cliff
 * Created by:
 * @author Adwait Chooromoney
 * Modified by: Incy Lin
 *
 */
public class Cliff extends Ground {
	public Cliff() {
		super('+');
	}

	/**
	 * This function kills the player if it is on the ground
	 * @param location The location of the Ground
	 */
	public void tick(Location location){
		//If player is on this ground
		if (location.containsAnActor()){
			Actor actor = location.getActor();
			//Check that actor is player
			if (actor.hasCapability(Status.PLAYABLE)){
				String str = new DeathAction(actor).execute(actor, location.map());
			}
		}
	}
}
