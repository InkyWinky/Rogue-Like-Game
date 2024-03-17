package game.behaviours;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import game.behaviours.Behaviour;

/**
 * A class that figures out a MoveAction that will move the actor one step 
 * closer to a target Actor.
 * @see edu.monash.fit2099.demo.mars.Application
 *
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 */
public class FollowBehaviour implements Behaviour {

	/**
	 * Actor being followed
	 */
	private final Actor subject;

	/**
	 * Constructor.
	 * 
	 * @param subject the Actor to follow
	 */
	public FollowBehaviour(Actor subject) {
		this.subject = subject;
	}


	/**
	 * Determines the targets surrounding the actor. If the target's location is allows the actor to enter,
	 * a MoveActorAction is called
	 *
	 * @param actor the Actor acting
	 * @param map the GameMap containing the Actor
	 * @return MoveActorAction if it fulfills the conditions, or null otherwise
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		if(!map.contains(subject) || !map.contains(actor))
			return null;
		
		Location here = map.locationOf(actor);
		Location there = map.locationOf(subject);

		int currentDistance = distance(here, there);
		for (Exit exit : here.getExits()) {
			Location destination = exit.getDestination();
			if (destination.canActorEnter(actor)) {
				int newDistance = distance(destination, there);
				if (newDistance < currentDistance) {
					return new MoveActorAction(destination, exit.getName());
				}
			}
		}

		return null;
	}

	/**
	 * Compute the Manhattan distance between two locations.
	 * 
	 * @param a the first location
	 * @param b the first location
	 * @return the number of steps between a and b if you only move in the four cardinal directions.
	 */
	private int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}
}