import java.util.*;
/**
 * .
 *
 * @author (Thom Ach)
 * @version (30/10/2018)
 */
public class Monster
{
    // instance variables - replace the example below with your own
    private String name;
    private int score = 0;
    private char initial;
    private Board board;
    private int row;
    private int column;
    

    /**
     * Constructor for objects of class Monster
     */
    public Monster (String name, Board board)
    {
        this.name = name;
        this.board = board;
        initial = name.charAt(0);
    }
    
    /**
     * This method adds the monster to the board.
     * It will call the setPosition method with the parameter findPlaceMonster, and its initial.
     */
    public void addMonster() {
        setPosition(board.findPlaceMonster(initial));
    }
    
    /**
     * The first(0th) element of the array will be the row position.
     * the second(1st) element will be the column position.
     */
    public void setPosition(int[] arr) {
        row = arr[0];
        column = arr[1];
    }
    
    /**
     *  Possibility that the monster attacks in several places, meaning multiple points can be scored.
     *  Used a switch statement to add some strings to print.
     *  
     * Thought this would just be a fun idea. Assignment doesn't specify that it can or cannot, so why not.
     *  
     * @int pointsScored will be parsed from the launchAttack() method in board.
     * 
     */
    public void increaseScore(int pointsScored){
        String killstreak;
        switch (pointsScored) {
            default: killstreak = "Missed!";
            break;
            case 1: killstreak = "Hit!";
            break;
            case 2: killstreak = "Double kill!";
            break;
            case 3: killstreak = "Triple kill!";
            break;
            case 4: killstreak = "QUADRUPLE KILL!!!";
        }
        score += pointsScored;
        
        System.out.println(killstreak);
        System.out.println(name + " scored " + pointsScored + " points");
    }
    

    //Just setters and getters from this point.
    public int getScore(){
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public char getInitial() {
        return initial;
    }
    
    public int getRow () {
        return row;
    }
    
    public int getColumn() {
        return column;
    }
        
}
