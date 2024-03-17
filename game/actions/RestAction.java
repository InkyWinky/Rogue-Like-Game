package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ResetManager;
import game.grounds.SiteOfLostGrace;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

public class RestAction extends Action {
    SiteOfLostGrace site;

    public RestAction(SiteOfLostGrace site){
        this.site = site;
    }
    public String execute(Actor player, GameMap map) {
        ResetManager.getInstance().run();
        player.addCapability(Status.RESTING);
        return menuDescription(player);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " rests at " + site;
    }
}
