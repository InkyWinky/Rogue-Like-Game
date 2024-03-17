package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.utils.Status;

/**
 * A class that represents the Golden Fog Door
 * Created by:
 * @author Adwait Chooromoney
 * Modified by:
 *
 */
public class GoldenFogDoor extends Ground {
	public GoldenFogDoor() {
		super('D');
	}

	@Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
	}
}
