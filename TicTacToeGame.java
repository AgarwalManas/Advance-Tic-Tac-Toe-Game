/** COMP 1006/1406
  * Summer 2017
  * 
  * Assignment 1
  */

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

public class TicTacToeGame{
  /** symbol for X */
  public static final Character ex = 'X';
  
  /** symbol for O */
  public static final Character oh = 'O';

  /** symbol for empty grid element */
  public static final Character empty = ' ';
  
  /** board is the grid that the game is played on; 
    * each element must be one of ex, oh or empty*/
  public static Character[][] board;
  
  
  /** rows is the number of rows (N) in the game board */
  public static int rows;
    
  /** columns is the number of columns (M) in the game board */
  public static int columns;
  
  /** win_condition is the value of K, the winning condition of the game */
  public static int win_condition; 
  
  /** specifies if the game is 1p (human-human) or 2p (human-computer) */
  public static boolean human_human_game;
  
  
  /** Checks for a win based on the last symbol played in the game
   * 
   * It is assumed that the position specified by the last_row_played
   * and last_column_played is valid and that the symbol in the board
   * at that position is not empty. (It must be <em>ex</em> or <em>oh</em>)
   * 
   * @param last_row_played is the row of the last symbol played
   * @param last_column_played is the column of the last symbol played
   * @return the length of the winning row/column/diagonal of symbols 
   * if the last move is a winning move, or -1 if the last move is not 
   * a winning move.
   */
  public static int win(int last_row_played, int last_column_played){
    // add your code and change the return value
    return -2;
  }
  
  /** main method to run the game 
    * 
    * @param args optional command line arguments to 
    * specify if the game is 1p (human-computer) or
    * 2p (human-human). Expect the string "2p" if any
    * command line argument is given.
    */
  public static void main(String[] args){
    
    /*------------------------------------------
     * handle command line arguments if any     
     * to determine if the game is human-human  
     * or human-computer                        
     *------------------------------------------*/
    if( args.length > 0){
      /* there are commend line arguments present */
      
      // add your code here
      
    }else{
      /* there are no command line argument present */
      
      // add your code here
      
    }
    
    /*------------------------------------
     * read N-M-K data from init file   
     * N = rows                         
     * M = columns                      
     * K = win_condition                
     *------------------------------------*/
    
    /*-------------------------------------
     *-------------------------------------
     * BEGIN : Do NOT change the code here
     *-------------------------------------*/
    BufferedReader file_input;
    FileReader     file;
    String         file_name = "init"; 
    String         line;
    
    try{
      file = new FileReader(file_name);
      file_input = new BufferedReader(file);
      
      line = file_input.readLine();
      rows = Integer.parseInt(line);
      
      line = file_input.readLine();
      columns = Integer.parseInt(line);
      
      line = file_input.readLine();
      win_condition = Integer.parseInt(line);
      
      /* always close your files you are done with them! */
      file_input.close();
      
    }catch(Exception e){
      /* somethine went wrong! */
      System.err.println("Failure to read data from init file properly");
      System.err.println(e);
      System.err.println("Program ending");
      return;
    }

    
    /*-------------------------------------
     * END : Do NOT change the code here
     *------------------------------------- 
     *-------------------------------------*/

    
    /* create and initialize the game board */
    
    /* allocate memory for the board array */
    board = new Character[rows][columns];
    
    // add code to initialize all elements to empty
    
    
    /* code to drive the game */
    
    // add your code here
    
    
  }
  
}