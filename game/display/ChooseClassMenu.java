package game.display;
import edu.monash.fit2099.engine.actors.Actor;
import game.player.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import edu.monash.fit2099.engine.displays.Display;
import game.utils.RandomNumberGenerator;
/**
 * @author Incy Lin
 * @Version 1
 */
public class ChooseClassMenu {
    private final Map<String, CombatArchetype> classes = new HashMap<String, CombatArchetype>(); //Map containing available classes to choose from
    private final String prompt = "Select player class:"; //Prompt to ask user to select class
    private Map<Integer, CombatArchetype> selectionMap = new HashMap<Integer, CombatArchetype>(); //Hashmap to map selection number to class type
    private int numberOfClasses=0;
    /**
     * @return integer of selection
     */
    public ChooseClassMenu(){
        //Add available classes
        addClass(new Samurai());
        addClass(new Bandit());
        addClass(new Wretch());
        addClass(new Astrologer());
        int i = 0;
        //Fill out selection map (selectionMap maps the menu item number to the class)
        for (String className : classes.keySet()) {
            i++;
            selectionMap.put(i, classes.get(className)); //Add selection to selectionMap
        }
    }
    public CombatArchetype run(){
        Scanner input = new Scanner(System.in);
        Display display = new Display();
        int choice = 0;
        while (choice==0) {
            display.println(prompt);
            //Print out menu items for each class available to choose form
            int i = 0;
            //Display menu items
            for (String className : classes.keySet()) {
                i++;
                display.println(i + ") " + className);
            }
            //Parse input (Check if input is an integer and within the bounds)
            try {
                choice = Integer.parseInt(input.nextLine());
                if (choice <=0 || choice > classes.size()){
                    choice = 0;
                    throw new NumberFormatException();
                }
                display.println("Your choice:" + choice);


            } catch (NumberFormatException e) {
                display.println("Please enter an integer between 1 and " + classes.size());
            }
        }
        return selectionMap.get(choice); //Return the player class that the user chose
    }

    /**
     * This method adds a class to the available classes that the user can select from, this allows adding
     * classes to be easier in the future
     * @param playerClass is the class that you wish to add
     */
    public void addClass(CombatArchetype playerClass){
        classes.put(playerClass.getName(), playerClass);
        this.numberOfClasses++;
    }

    /**
     * This function returns a random archetype
     * @return
     */
    public CombatArchetype randomArchetype(){
        //Generate a random number
        int randNo = RandomNumberGenerator.getRandomInt(1,numberOfClasses);
        return selectionMap.get(randNo);
    }
}