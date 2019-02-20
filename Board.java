import java.util.*;
/**
 * You need to complete this class in order for it to 
 * compile function properly
 *
 * @author (Kent UNI, Thom Ach)
 * @version (30/10/18)
 */
public class Board
{
    private final int SIZE = 5;
    public char board [][];
    private Random rand;

    /**
     * Constructor fills the board initially with *
     * and sets up the surrounding edges / hedge "="
     */
    public Board() 
    {
        board = new char [SIZE][SIZE]; 
        rand = new Random();
        int first = 0;
        int last = SIZE-1;

        for (int i = first; i <= last; i++)
        {
            for (int j = first; j <= last; j++)
                board[i][j] = '*';

        }

        for (int i = 0; i < SIZE ; i++)
        {
            board[0][i] = '=';
            board[i][0] = '=';
            board[i][SIZE - 1] = '=';
            board[SIZE - 1][i] = '=';
        }

    }

    /**
     * Prints out each element of the 2D array.
     * Nested for loop here so that it will print out every row and column.
     * 
     * Heard someone use a more simple solution so should revisit this.
     * 
     */
    public void viewBoard()
    {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }

    /**
     * Generate random integers using the size boundary - 1. Have used this instead of an integer so board can be tweaked easier without
     * having to change too much code. Also used 1+ because dont want 0 as a boundary as it will be a hedge.
     * 
     * Done and if statement to check whether the initial is a '*' just incase as well.
     * Set the initial to the monsters initial.
     * 
     * first(0th) element of position will be equal to row, and second(1st) will be equal to column.
     * 
     * @initial is the monsters initial.
     * @return position returns the position. 
     */
    public int [] findPlaceMonster(char initial) {
        Random rand = new Random();
        int row;
        int column;
        boolean finished = false;
        int[] position = new int[2];

        while(!finished) {
            row = 1 + rand.nextInt(SIZE - 1);
            column = 1 + rand.nextInt(SIZE - 1);

            if (board[row][column] == '*') {
                board[row][column] = initial;
                position[0] = row;
                position[1] = column;
                finished = true;
            }

        }
        return position;
    }

/**
 * This was a lil tricky, Method takes a monster as a parameter and gets its position, via row and column.
 * 
 * @int row, monsters row position
 * @int column, monsters column position
 * @int pointsScored, total amount of points the monster has scored from this move.
 * 
 * checks to see if the north, east, south or west positions are occupied by monster chars.
 * If it has a * or a = then it is not. If it doesn't then it must be a monsters char.
 * 
 * Here I have used only if statements because I thought it would be an interesting concept for monsters to be able to get multiple kills.
 * It checks each if one after the other meaning that multiple attacks are possible.
 * 
 * Each time it attacks it will increment the pointsScored and parse this integer to the increaseScore method.
 */
    public void launchAttack(Monster monster) {
        int row = monster.getRow();
        int column = monster.getColumn();
        int pointsScored = 0;

        if (board[row][column+1] != '*' && board[row][column+1] != '=') {
            board[row][column+1] = '*';
            pointsScored++;
        }

        if (board[row][column-1] !='*' && board[row][column-1] != '=') {
            board[row][column-1] = '*';
            pointsScored++;
        }

        if (board[row+1][column] !='*' && board[row+1][column] != '=') {
            board[row+1][column] = '*';
            pointsScored++;
        }
        
        if (board[row-1][column] !='*' && board[row-1][column] != '=') {
            board[row-1][column] = '*';
            pointsScored++;
        }
        
        monster.increaseScore(pointsScored);
    }
}

