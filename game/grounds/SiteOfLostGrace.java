package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.RestAction;
import game.player.Player;

/**
 * A class that represents Site of Lost Grace
 * Created by:
 * @author Adwait Chooromoney
 * Modified by:
 *
 */
public abstract class SiteOfLostGrace extends Ground {
    private String name;

    public SiteOfLostGrace(String name) {
        super('U');
        this.name = name;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        if (actor instanceof Player){
            Player player = (Player) actor;
            player.setLastVisitedSOLGLoc(location);}
        ActionList actions = new ActionList(new RestAction(this));
        return actions;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
