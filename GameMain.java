import java.util.Scanner;
import java.util.ArrayList;
/**
 * Controls user interface and commands, and general game.
 *
 * @author (Thom Ach)
 * @version (30/10/18)
 */
public class GameMain
{    
    ArrayList<Monster> players = new ArrayList<Monster>();

    public static void main(String[] args) {
        GameMain game = new GameMain();
        game.readUserInput();
    }

    /**
     * Decided to use @command as a string rather than and integer. The reason being user can cause problems parsing string values if an integer is expected.
     * Scanner used to read user input. A new instance of board is created.
     * 
     * @name will be the monsters name
     * @command will be the command the user inputs. Switch statement will check which commands to be executed.
     * @quit if not quit loop. If quit command executed, will set to true. Killing the loop.
     */
    public void readUserInput() {
        Scanner userInput = new Scanner(System.in);
        Board board = new Board();

        String name;
        String command;
        String search;

        boolean quit = false;

        printCommands();
        while(!quit) {
            command = userInput.next();
            switch (command) {
                case "1":
                System.out.println("Enter a monsters name:");
                name = userInput.next();
                Monster monster = new Monster(name, board);
                players.add(monster);
                monster.addMonster();
                System.out.println(name + " has been added to the board.");
                break;

                case "2":
                System.out.println("Which monster should attack?:");
                search = userInput.next();
                if(monsterSearch(search) == null) {
                    System.out.println("That monster doesn't exist!");
                } else {
                    board.launchAttack(monsterSearch(search));
                }
                break;

                case "3":
                System.out.println("Board currrently looks like this:");
                board.viewBoard();
                break;

                case "4":
                System.out.println("Whose score shall i display?:");
                search = userInput.next();
                if(monsterSearch(search) == null) {
                    System.out.println("That monster doesn't exist!");
                } else {
                    System.out.println(search + " has a score of " + monsterSearch(search).getScore());
                }
                break;

                case "5":
                printPlayers();

                break;
                case "6":
                System.out.println("I don't blame you.");
                quit = true;
                break;

                default:
                System.out.println("I didn't understand that command, try another one.");
            }
        }
    }

    /**
     * Used in a seperate method to stop code looking like someone dropped spaghetti.
     * Simple enough method, will just print options to the user.
     */
    public void printCommands() {        
        System.out.println("Please select an option from the menu.");
        System.out.println("1. Place a new monster onto the board.");
        System.out.println("2. Attack a monster.");
        System.out.println("3. View the board.");
        System.out.println("4. Retrieve a score from a monster.");
        System.out.println("5. List all players.");
        System.out.println("6. Quit playing.");
    }

    /**
     * Goes through each element in the ArrayList and does two things. One loop will increment a count, telling you the total amount of monsters on the board.
     * The other for loop will go through every element on the ArrayList and call getName(), this will be printed. Thus printing the name of the monster.
     */
    public void printPlayers() {
        int count = 0;
        for(int i = 0; i < players.size(); i++) {
            Monster name = players.get(i);
            count++;
        }
        System.out.println("Amount of players: " +count);

        for(int i = 0; i < players.size(); i++) {
            Monster name = players.get(i);
            System.out.println(name.getName());
        }
    }

    /**
     * Used for doing searches, returns the element that has been searched for.
     */
    public Monster monsterSearch(String search) {
        String match;
        int i;

        for(i = 0; i < players.size(); i++) {
            Monster name = players.get(i);
            match = name.getName();
            if(search.equalsIgnoreCase(match)){
                return players.get(i);
            }
        }
        return null;
    }
}
