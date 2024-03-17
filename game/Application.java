package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;
import game.display.ChooseClassMenu;
import game.enemies.GodrickSoldier;
import game.enemies.GodricktheGrafted;
import game.enemies.LoneWolf;
import game.grounds.*;
import game.items.Door;
import game.items.GoldenRunes;
import game.items.RemembranceofGrafted;
import game.items.*;
import game.merchants.FingerReaderEnia;
import game.merchants.MerchantKale;
import game.player.CombatArchetype;
import game.player.Player;
import game.display.FancyMessage;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Incy Lin, Adwait, Joanne Yew
 *
 */
public class Application {

	public static void main(String[] args) {

		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new GustOfWind(), new PuddleOfWater(), new Graveyard(), new TheFirstStep(), new Cliff(), new SummonSign(), new Cage(), new Barrack());
		List<String> limgraveMap = Arrays.asList(
				"......................#.............#..........................+++.........",
				"......................#.............#.......................+++++..........",
				"......................#..___....____#.........................+++++........",
				"......................#...........__#............................++........",
				"......................#_____........#.............................+++......",
				"......................#............_#..............................+++.....",
				"......................######...######......................................",
				"...........................................................................",
				"...........................=...............................................",
				"........++++......................###___###................................",
				"........+++++++...................________#................................",
				"..........+++.....................#__U_____................................",
				"............+++...................#_______#................................",
				".............+....................###___###................................",
				"............++......................#___#..................................",
				"..............+...................=........................................",
				"..............++.................................................=.........",
				"..............................................++...........................",
				"..................++++......................+++...............######..##...",
				"#####___######....++...........................+++............#....____....",
				"_____________#.....++++..........................+..............__.....#...",
				"_____________#.....+....++........................++.........._.....__.#...",
				"_____________#.........+..+.....................+++...........###..__###...",
				"_____________#.............++..............................................");
		GameMap limgrave = new GameMap(groundFactory, limgraveMap);
		world.addGameMap(limgrave);
		limgrave.at(23, 17).addActor(new LoneWolf());
		limgrave.at(36,11).addItem(new RemembranceofGrafted());
		limgrave.at(36,9).addActor(new GodrickSoldier());
		limgrave.at(34,9).addActor(new GodrickSoldier());
		//STORMVEIL CASTLE
		List<String> stormveilCastleMap = Arrays.asList(
				"...........................................................................",
				"..................<...............<........................................",
				"...........................................................................",
				"##############################################...##########################",
				"............................#................#.......B..............B......",
				".....B...............B......#................#.............................",
				"...............................<.........<.................................",
				".....B...............B......#................#.......B..............B......",
				"............................#................#.............................",
				"#####################..#############...############.####..#########...#####",
				"...............#++++++++++++#................#++++++++++++#................",
				"...............#++++++++++++...<.........<...#++++++++++++#................",
				"...............#++++++++++++..................++++++++++++#................",
				"...............#++++++++++++#................#++++++++++++#................",
				"#####...##########.....#############...#############..#############...#####",
				".._______........................B......B........................B.....B...",
				"_____..._..____....&&........<..............<..............................",
				".........____......&&......................................................",
				"...._______..................<..............<....................<.....<...",
				"#####....##...###..#####...##########___###############......##.....####...",
				"+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++....................#+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++#....................+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++");
		GameMap stormveilCastle = new GameMap(groundFactory, stormveilCastleMap);
		world.addGameMap(stormveilCastle);

		//ROUNDTABLE HOLD
		List<String> roundtableHoldMap = Arrays.asList(
				"##################",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"########___#######");
		GameMap roundtableHold = new GameMap(groundFactory, roundtableHoldMap);
		world.addGameMap(roundtableHold);

		//BOSS ROOM
		List<String> bossRoomMap = Arrays.asList(
				"+++++++++++++++++++++++++",
				".........................",
				"..=......................",
				".........................",
				".........................",
				".........................",
				".........................",
				".........................",
				"+++++++++++++++++++++++++");
		GameMap bossRoom = new GameMap(groundFactory, bossRoomMap);
		world.addGameMap(bossRoom);


		//Add doors
		//Set Door locations
		Location limgraveDoor1Loc =limgrave.at(1, 10);
		Location limgraveDoor2Loc =limgrave.at(50, 15);
		Location stormveilDoor1Loc = stormveilCastle.at(36, 0);
		Location stormveilDoor2Loc = stormveilCastle.at(40, 0);
		Location roundtableDoorLoc = roundtableHold.at(10, 10);
		Location bossRoomLoc = bossRoom.at(2, 1);

		limgraveDoor1Loc.addItem(new Door("door to Roundtable Hold", limgraveDoor1Loc, roundtableDoorLoc));
		limgraveDoor2Loc.addItem(new Door("door to Roundtable Hold", limgraveDoor2Loc, stormveilDoor1Loc));
		stormveilDoor1Loc.addItem(new Door("door to Limgrave", stormveilDoor1Loc, limgraveDoor2Loc));
		stormveilDoor2Loc.addItem(new Door("door to the Boss Room", stormveilDoor2Loc, bossRoomLoc));
		roundtableDoorLoc.addItem(new Door("door to Limgrave", roundtableDoorLoc, limgraveDoor1Loc));


		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		limgrave.at(36,11).addItem(new RemembranceofGrafted());
		limgrave.at(28,10).addItem(new Invisibility());





		//Display menu for choosing player class (combat archetype) to the user
		ChooseClassMenu chooseClass = new ChooseClassMenu();
		CombatArchetype playerClass = chooseClass.run();
		//Create player of that combat archetype
		Location location = limgrave.at(36, 10);
		Player player = new Player(playerClass, location);
		world.addPlayer(player, location);

		world.run();
	}
}
