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
	
	// Creating emptyBoard 
  public static void emptyBoard(int rows, int columns){
	 
	 int j = 0;
	 for(int i = 0; i<rows; i++){
			j = 0;
			board[i][j] = empty;
			for(j = 0; j<columns; j++){
				board[i][j] = empty;			
			}
	 }
  }  
  public static void main(String[] args){
    
    /*------------------------------------------
     * handle command line arguments if any     
     * to determine if the game is human-human  
     * or human-computer                        
     *------------------------------------------*/
    if( args.length > 0){
      /* there are commend line arguments present */
      
      // add your code here
      
	  human_human_game = true;
	  System.out.println();
	  System.out.println("Welcome to tic-tac-toe++");
	  System.out.println("Human vs Human game");
	  
	  
	  
    }else{
      /* there are no command line argument present */
      
      // add your code here
      human_human_game = false;
	  System.out.println();
	  System.out.println("Welcome to tic-tac-toe++");
	  System.out.println("Human vs Computer game");
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
	
	
	
	// initializing flags 
    boolean GamePlay = true,				// Gameplay: true 	= if we are still interested in playing
			win = false,					// win: true		= if one of the member won 
			draw = false,					// draw: true		= if the game went to draw
			user_switch = true,				// switching users after each turn (within 1 game)
			fixed_initial_switch = true;	// switching users after each game
	
	
	
	// initializing counts 
	int TotalGame = 0,						
		player1_won = 0,
		player2_won = 0,
		draw_count = 0;
	
	
	
/////////////////////////////////////////////////////////////////////////////////////
/////////////////////         HUMAN VS HUMAN BEGINS 			/////////////////////
/////////////////////		  HUMAN VS COMPUTER ENDS			/////////////////////
/////////////////////////////////////////////////////////////////////////////////////
	
	if(human_human_game){
		while(GamePlay == true){
			emptyBoard(rows, columns);
		
		 
			// initializing flags to keep-up with user-switch
			boolean player_1 = false; 
			boolean player_2 = false; 
			
			if(user_switch==true){
				System.out.print("player 1 input : ");
				player_1 = true;
				player_2 = false; 
			}
			else {
				System.out.print("player 2 input : ");
				player_2 = true;
				player_1 = false;
			}
			
			// getting user input
			Scanner userInput1 = new Scanner(System.in);
			String user1 = userInput1.nextLine();
			String[] user_split = user1.split(" ");
			
			
			// spliting user input into char/array of string
			char first = user_split[0].charAt(0);
			char second = user_split[2].charAt(0);
			String first_string = " "; 
			String second_string = " "; 
			
			
			boolean user_split_check = true;
			win = false;
			draw = false;
			boolean check_sign = true;
			
			int r = 0;
			int c = 0;
			
			
			
			// checking for win and/or draw game
			while( (!win) && (!draw)){	
			
				
				// checking for valid user-input 
				while(user_split_check){
					
					
					//ERROR: if both the dimensional axis are same
					while (first == second){
						System.out.println("Invalid move. Try again!");
						
						if(user_switch){
							System.out.print("player 1 input : ");
							player_1 = true;
							player_2 = false;
						}
						else {
							System.out.print("player 2 input : ");
							player_2 = true;
							player_1 = false;
				
						}
						
						user1 = userInput1.nextLine();
						user_split = user1.split(" ");
						first = user_split[0].charAt(0);
						second = user_split[2].charAt(0);
						first_string = " "; 
						second_string = " "; 
						
					}
					
					if (first == 'r' || first == 'R'){
						first_string = user_split[0].toLowerCase();
						second_string = user_split[2].toLowerCase();
						r = Integer.parseInt(user_split[1]);
						c = Integer.parseInt(user_split[3]);
					}
					else {
						first_string = user_split[2].toLowerCase();
						second_string = user_split[0].toLowerCase();
						r = Integer.parseInt(user_split[3]);
						c = Integer.parseInt(user_split[1]);
					}
					
					// ERROR: not a valid RR and/or CC 
					if(!((first_string.equals("row") || first_string.equals("r")) && (second_string.equals("column") || second_string.equals("col") || second_string.equals("c")))){
						System.out.println("Invalid move. Try again!");
						
						if(user_switch){
							System.out.print("player 1 input : ");
							player_1 = true;
							player_2 = false;
						}
						
						else {
							System.out.print("player 2 input : ");
							player_2 = true;
							player_1 = false;
						}
						
						user_split_check = true;
						user1 = userInput1.nextLine();
						user_split = user1.split(" ");
						first = user_split[0].charAt(0);
						second = user_split[2].charAt(0);
						first_string = " "; 
						second_string = " "; 
					} 
					
					else {
						user_split_check = false;
					}
					
					
					// ERROR: indices exteed(s) the given row and/or column
					if( r >= rows || c >= columns) {
						user_split_check = true;
						System.out.println("Invalid move. Try again!");
						
						
						if(user_switch){
							System.out.print("player 1 input : ");
							player_1 = true;
							player_2 = false;
						}
						
						else {
							System.out.print("player 2 input : ");
							player_2 = true;
							player_1 = false;
						}
						
						user1 = userInput1.nextLine();
						user_split = user1.split(" ");
						first = user_split[0].charAt(0);
						second = user_split[2].charAt(0);
						first_string = " "; 
						second_string = " "; 	
					}
					
					else {
						
						if ((board[r][c] != empty)){
						
							user_split_check = true;
							System.out.println("Invalid move. Try again!");
							
							if(user_switch){
								System.out.print("player 1 input : ");
								player_1 = true;
								player_2 = false;
							}
							
							else {
								System.out.print("player 2 input : ");
								player_2 = true;
								player_1 = false;
							}
							
							
							user1 = userInput1.nextLine();
							user_split = user1.split(" ");
							first = user_split[0].charAt(0);
							second = user_split[2].charAt(0);
							first_string = " "; 
							second_string = " "; 
							
						}
						
						else {
						}
					}
						
					
					
					
				}
				
				
				// checking for correct sign as well as creating matrix figure
				if(check_sign){
					board[r][c] = ex;
					int j = 0;
					
					
					for(int i = 0; i<rows; i++){
						System.out.println();
						
						for (int k = 0; k<columns; k++){
							if(i>0){
								if (k<columns-1){
									System.out.print("---+");
								}
								else if (k == columns-1){
									System.out.print("---");
								}
							}
						}
						System.out.println();
						
						for(j = 0; j<columns; ++j){
							if (j<columns-1){
								System.out.print(" " + board[i][j] + " |");
							}
							else if(j ==columns-1){
								System.out.print(" " + board[i][j]);
							}
							
						}
					}
					
					user_switch = !user_switch;
					check_sign = !check_sign;
				
				} else {
					board[r][c] = oh;	
					int j = 0;
					
					
					for(int i = 0; i<rows; i++){
						System.out.println();
						for (int k = 0; k<columns; k++){
							if(i>0){
								if (k<columns-1){
									System.out.print("---+");
								}
								else if (k == columns-1){
									System.out.print("---");
								}
							}
						}
						System.out.println();
						for(j = 0; j<columns; ++j){
							
							if (j<columns-1){
								System.out.print(" " + board[i][j] + " |");
							}
							else if(j ==columns-1){
								System.out.print(" " + board[i][j]);
							}	
						}
					}
					user_switch = !user_switch;
					check_sign = !check_sign;
				}
				
				
				// Draw condition
				int check_number = 0;
				int n = 0;
				
				for (int m = 0; m<rows; m++){
					n = 0;
					if (board[m][n] == empty){
						check_number = 1;
					}	
					for(n=0; n<columns; n++){
						if (board[m][n] ==empty){
							check_number = 1;
						}
					}
				}
				
				if (check_number == 0){
					draw = true;
				}
				else {
					draw = false;
				}
				
				
				// win condition 
				int hk,
					hc,
					hr,
					hk_2,
					check_ex = 0,
					check_oh = 0;
				
				// Case:1 HORIZONTAL check
				for (hr = 0; hr < rows; hr++){
					for (hc = 0; hc < columns; hc++){
						
						if (board[hr][hc] == ex) {
							hk = hc;
							hk_2 = hc;
							check_ex = 0;
							check_oh = 0;
							
							for(hk = hc; (hk < columns && (hk_2 + win_condition) <= columns) ; hk++){
		
								if (board[hr][hk] == ex){
									check_ex++;
								}
								if (check_ex == win_condition){
									win = true;
								}
							}
						}
						else if (board[hr][hc] == oh) {
							hk = hc;
							hk_2 = hc;
							check_ex = 0;
							check_oh = 0;
							
							for(hk = hc; (hk < columns && (hk_2 + win_condition) <= columns) ; hk++){
							
								if (board[hr][hk] == oh){
									check_oh++;
								}
								if (check_oh == win_condition){
									win = true;
								}
							}
						}
					}
				}
				
				// Case:2 VERTICAL check
				for (hc = 0; hc < columns; hc++){
					for (hr = 0; hr < rows; hr++){
							
						if (board[hr][hc] == ex) {
							hk = hr;
							hk_2 = hr;
							check_ex = 0;
							check_oh = 0;
							
							for(hk = hr; (hk < rows && (hk_2 + win_condition) <= rows) ; hk++){
								if (board[hk][hc] == ex){
									check_ex++;
								}
								if (check_ex == win_condition){
									win = true;
								}
							}
						}
						else if (board[hr][hc] == oh) {
							hk = hr;
							hk_2 = hr;
							check_ex = 0;
							check_oh = 0;
							
							for(hk = hr; (hk < rows && (hk_2 + win_condition) <= rows) ; hk++){
								if (board[hk][hc] == oh){
									check_oh++;
								}
								if (check_oh == win_condition){
									win = true;
								}
							}
						}
					}
				}
				
				// Case:3.1 DIAGONAL check
				// upper left to lower right 
				for (hr = 0; hr < rows; hr++){
					for (hc = 0; hc < columns; hc++){
							
						if (board[hr][hc] == ex) {
							hk = hc;
							hk_2 = hc;
							check_ex = 0;
							check_oh = 0;
							
							for(hk = 0; (hr + win_condition <=rows )&& (hr + win_condition <=columns ) && (hr + hk < rows) && (hc+hk < columns); hk++){
								if (board[hr+hk][hc+hk] == ex){
									check_ex++;
								}
								if (check_ex == win_condition){
									win = true;
								}
							}
						}
						else if (board[hr][hc] == oh) {
							hk = hc;
							hk_2 = hc;
							check_ex = 0;
							check_oh = 0;
							
							for(hk = 0; (hr + win_condition <=rows )&& (hc + win_condition <=columns ) && (hr + hk < rows) && (hc+hk < columns); hk++){
								if (board[hr+hk][hc + hk] == oh){
									check_oh++;
								}
								if (check_oh == win_condition){
									win = true;
								}
							}
						}
					}
				}
				
				// Case:3.2 DIAGONAL check
				// upper right to lower left
				for (hr = 0; hr < rows; hr++){
					for (hc = 0; hc < columns; hc++){
							
						if (board[hr][hc] == ex) {	
							hk = hc;
							hk_2 = hc;
							check_ex = 0;
							check_oh = 0;
							
							for(hk = 0; (hr + win_condition <=rows )&& (hc - win_condition >= -1 ) && (hr + hk < rows) && (hc - hk >= 0); hk++){
								if (board[hr+hk][hc-hk] == ex){
									check_ex++;	
								}
								if (check_ex == win_condition){
									win = true;
								}
							}
						}
						else if (board[hr][hc] == oh) {
							hk = hc;
							hk_2 = hc;
							check_ex = 0;
							check_oh = 0;
							for(hk = 0; (hr + win_condition <=rows )&& (hc - win_condition >=-1 ) && (hr + hk < rows) && (hc - hk >=0); hk++){
								if (board[hr+hk][hc-hk] == oh){
									check_oh++;
								}
								if (check_oh == win_condition){
									win = true;
								}
							}
						}
					}
				}
				
				
				// switching users within the game when the game is neither won nor drawn 
				if (!draw && !win) {
					
					System.out.println();
					System.out.println();
						if(user_switch){
							
							System.out.print("player 1 input : ");
							player_1 = true;
							player_2 = false;
						}
						else {
						System.out.print("player 2 input : ");
						player_2 = true;
						player_1 = false;
				
						}
						
						user_split_check = true;
						user1 = userInput1.nextLine();
						user_split = user1.split(" ");
						first = user_split[0].charAt(0);
						second = user_split[2].charAt(0);
						first_string = " "; 
						second_string = " "; 
						
				}
			
			
			}
			
			// If WON- 
			if(win){
				System.out.println();
				if(!check_sign){
					if(player_1){
						System.out.println("player 1 wins with " +  win_condition + " symbols !");
						player1_won++;
					}
					else {
						System.out.println("player 2 wins with " +  win_condition + " symbols !");
						player2_won++;
					}
					
				} else {
					if(player_1){
						System.out.println("player 1 wins with " +  win_condition + " symbols !");
						player1_won++;
					}
					else {
						System.out.println("player 2 wins with " +  win_condition + " symbols !");
						player2_won++;
					}	
				}
			} else if (draw){
				System.out.println();
				System.out.println("It's a draw!");
				draw_count++;
			}
			
			
			// Exit Message 
			System.out.println();
			System.out.print("Would you like to play again? ");	
			Scanner user_Final = new Scanner(System.in);
			String user_final = user_Final.next();
			
			
			if (user_final.equals("yes")){
				GamePlay = true;	
			}
			else {
				GamePlay = false;
			}
			
			TotalGame = TotalGame + 1;
			fixed_initial_switch = !fixed_initial_switch;
			
			if(fixed_initial_switch == false){
				user_switch = false;
			}
			else {
				user_switch = true;
			}
			
		  
		  
		
		}
		
	// conclusion message 
	System.out.println();
	System.out.println("Thanks for playing tic-tac-toe++");
	System.out.println();
	System.out.println("total games \t : " + TotalGame);
	System.out.println("player 1 wins \t : " + player1_won);
	System.out.println("player 2 wins \t : " + player2_won);
	System.out.println("draws \t \t : " + draw_count);
	
	if (player1_won > 0 || player2_won > 0) {
		System.out.println("best wins \t : " + win_condition + " symbols");
	}
	else {
		System.out.println("best wins \t : None! (No one won!)");
	}
	
    
    
	
}
	
	
/////////////////////////////////////////////////////////////////////////////////////
/////////////////////         HUMAN VS HUMAN ENDS 				/////////////////////
/////////////////////		 HUMAN VS COMPUTER BEGINS			/////////////////////
/////////////////////////////////////////////////////////////////////////////////////

    
 else {   
	
	
	boolean comp_play = false,
			check_player1 = true,
			check_player2 = true;
	
	while(GamePlay == true && !human_human_game){
		emptyBoard(rows, columns);
	
	 
		boolean player_1 = false, 
				player_2 = false; 
		
		if(user_switch==true){
			System.out.print("player 1 input : ");
			player_1 = true;
			player_2 = false; 
			comp_play = false;
			
		}
		// creating computer random input 
		else {
			System.out.println();
			System.out.print("Computer plays : ");
							
							
			int r = 0 + (int)(Math.random() * ((rows -1 ) + 1));
			int c = 0 + (int)(Math.random() * ((columns -1 ) + 1));
							
			while(board[r][c] != empty){
				r = 0 + (int)(Math.random() * ((rows -1 ) + 1));
				c = 0 + (int)(Math.random() * ((columns -1 ) + 1));
							
			}
				
			System.out.println("r " + r + " c " + c);
			comp_play = true;
		}
			
			
		Scanner userInput1 = new Scanner(System.in);
		String user1 = userInput1.nextLine();
		String[] user_split = user1.split(" ");
		
			
		char first = user_split[0].charAt(0);
		char second = user_split[2].charAt(0);
		String first_string = " "; 
		String second_string = " "; 
		boolean user_split_check = true;
		win = false;
		draw = false;
		boolean check_sign = true;
		
		int r = 0;
		int c = 0;
		check_player1 = true;
		check_player2 = true;		
		
		
		
		while (check_player1 && check_player2){
			
			if(user_switch ==false){
				
				emptyBoard(rows, columns);
				player_1 = false; 
				player_2 = false; 
				System.out.println();
				System.out.print("Computer plays : ");
							
							
				r = 0 + (int)(Math.random() * ((rows -1 ) + 1));
				c = 0 + (int)(Math.random() * ((columns -1 ) + 1));
								
				while(board[r][c] != empty){
					r = 0 + (int)(Math.random() * ((rows -1 ) + 1));
					c = 0 + (int)(Math.random() * ((columns -1 ) + 1));
								
				}
				
				System.out.println("r " + r + " c " + c);
				comp_play = true;
				check_player1 = true;
			}
			
			
			user_split_check = true;
			win = false;
			draw = false;
			check_sign = true;
		
		
		
			while( (!win) && (!draw)){	
			
				while(user_split_check && !comp_play){
					
				
					while (first == second){
						System.out.println("Invalid move. Try again!");
						if(user_switch){
							System.out.print("player 1 input : ");
							player_1 = true;
							player_2 = false;
						}
						else {
							System.out.print("player 2 input : ");
							player_2 = true;
							player_1 = false;
						}
						user1 = userInput1.nextLine();
						user_split = user1.split(" ");
						first = user_split[0].charAt(0);
						second = user_split[2].charAt(0);
						first_string = " "; 
						second_string = " "; 	
						
					}
					
					if (first == 'r' || first == 'R'){
						first_string = user_split[0].toLowerCase();
						second_string = user_split[2].toLowerCase();
						r = Integer.parseInt(user_split[1]);
						c = Integer.parseInt(user_split[3]);
					}
					else {
						first_string = user_split[2].toLowerCase();
						second_string = user_split[0].toLowerCase();
						r = Integer.parseInt(user_split[3]);
						c = Integer.parseInt(user_split[1]);
					}
					
					if(!((first_string.equals("row") || first_string.equals("r")) && (second_string.equals("column") || second_string.equals("col") || second_string.equals("c")))){
						System.out.println("Invalid move. Try again!");
						if(user_switch){
							System.out.print("player 1 input : ");
							player_1 = true;
							player_2 = false;
						}
						else {
							System.out.print("player 2 input : ");
							player_2 = true;
							player_1 = false;
						}
						user_split_check = true;
						user1 = userInput1.nextLine();
						user_split = user1.split(" ");
						first = user_split[0].charAt(0);
						second = user_split[2].charAt(0);
						first_string = " "; 
						second_string = " "; 		
					} 
					else {
						user_split_check = false;
					}
					
					
					if( r >= rows || c >= columns) {
						user_split_check = true;
						System.out.println("Invalid move. Try again!");
						if(user_switch){
							System.out.print("player 1 input : ");
							player_1 = true;
							player_2 = false;
						}
						else {
							System.out.print("player 2 input : ");
							player_2 = true;
							player_1 = false;
						}
						user1 = userInput1.nextLine();
						user_split = user1.split(" ");
						first = user_split[0].charAt(0);
						second = user_split[2].charAt(0);
						first_string = " "; 
						second_string = " "; 
					}
					else {
						if ((board[r][c] != empty)){
							user_split_check = true;
							System.out.println("Invalid move. Try again!");
							if(user_switch){
								System.out.print("player 1 input : ");
								player_1 = true;
								player_2 = false;
							}
							else {
								System.out.print("player 2 input : ");
								player_2 = true;
								player_1 = false;
							}
							user1 = userInput1.nextLine();
							user_split = user1.split(" ");
							first = user_split[0].charAt(0);
							second = user_split[2].charAt(0);
							first_string = " "; 
							second_string = " "; 	
						}
						else {
						}
					}
					
				}
				
				
				
				if(check_sign){
					board[r][c] = ex;
					
					int j = 0;
					for(int i = 0; i<rows; i++){
						System.out.println();
						for (int k = 0; k<columns; k++){
							if(i>0){
								if (k<columns-1){
									System.out.print("---+");
								}
								else if (k == columns-1){
									System.out.print("---");
								}
							}
						}
						System.out.println();
						for(j = 0; j<columns; ++j){
							if (j<columns-1){
								System.out.print(" " + board[i][j] + " |");
							}
							else if(j ==columns-1){
								System.out.print(" " + board[i][j]);
							}	
						}
					}
					user_switch = !user_switch;
					check_sign = !check_sign;
				
				} else {
					
					board[r][c] = oh;
					
					
					int j = 0;
					for(int i = 0; i<rows; i++){
						System.out.println();
						for (int k = 0; k<columns; k++){
							if(i>0){
								if (k<columns-1){
									System.out.print("---+");
								}
								else if (k == columns-1){
									System.out.print("---");
								}
							}
						}
						System.out.println();
						for(j = 0; j<columns; ++j){
							
							if (j<columns-1){
								System.out.print(" " + board[i][j] + " |");
							}
							else if(j ==columns-1){
								System.out.print(" " + board[i][j]);
							}	
						}
					}
					
					user_switch = !user_switch;
					check_sign = !check_sign;
				}
				
				
				// Draw condition
				int check_number = 0;
				int n = 0;
				
				for (int m = 0; m<rows; m++){
					n = 0;
					if (board[m][n] == empty){
						check_number = 1;
					}	
					for(n=0; n<columns; n++){
						if (board[m][n] ==empty){
							check_number = 1;
						}
					}
				}
				
				if (check_number == 0){
					draw = true;
				}
				else {
					draw = false;
				}
				
				
				// initializing/creating temporary variables
				int hk,
					hc,
					hr,
					hk_2,
					check_ex = 0,
					check_oh = 0;
				
				// Case 1: HORIZONTAL check
				for (hr = 0; hr < rows; hr++){
					for (hc = 0; hc < columns; hc++){
						
						if (board[hr][hc] == ex) {
							hk = hc;
							hk_2 = hc;
							check_ex = 0;
							check_oh = 0;
							
							for(hk = hc; (hk < columns && (hk_2 + win_condition) <= columns) ; hk++){
								if (board[hr][hk] == ex){
									check_ex++;	
								}
								if (check_ex == win_condition){
									win = true;
								}
							}
						}
						else if (board[hr][hc] == oh) {
							hk = hc;
							hk_2 = hc;
							check_ex = 0;
							check_oh = 0;
							
							for(hk = hc; (hk < columns && (hk_2 + win_condition) <= columns) ; hk++){
								if (board[hr][hk] == oh){
									check_oh++;
								}
								if (check_oh == win_condition){
									win = true;
								}
							}
						}
					}
			
				}
				
				// Case 2: VERTICAL check
				for (hc = 0; hc < columns; hc++){
					for (hr = 0; hr < rows; hr++){
							
						if (board[hr][hc] == ex) {
							hk = hr;
							hk_2 = hr;
							check_ex = 0;
							check_oh = 0;
							
							for(hk = hr; (hk < rows && (hk_2 + win_condition) <= rows) ; hk++){
								if (board[hk][hc] == ex){
									check_ex++;
								}
								if (check_ex == win_condition){
									win = true;
								}
							}
					
						}
						else if (board[hr][hc] == oh) {
							
							hk = hr;
							hk_2 = hr;
							check_ex = 0;
							check_oh = 0;
							for(hk = hr; (hk < rows && (hk_2 + win_condition) <= rows) ; hk++){
							
								if (board[hk][hc] == oh){
									check_oh++;
								}
								if (check_oh == win_condition){
									win = true;
								}
							}
						}
					}
				}
				
				
				// Case:3.1 DIAGONAL check
				// upper left to lower right 
				for (hr = 0; hr < rows; hr++){
					for (hc = 0; hc < columns; hc++){
							
						if (board[hr][hc] == ex) {
							hk = hc;
							hk_2 = hc;
							check_ex = 0;
							check_oh = 0;
							for(hk = 0; (hr + win_condition <=rows )&& (hr + win_condition <=columns ) && (hr + hk < rows) && (hc+hk < columns); hk++){
								if (board[hr+hk][hc+hk] == ex){
									check_ex++;	
								}
								if (check_ex == win_condition){
									win = true;
								}
							}
						}
						else if (board[hr][hc] == oh) {
							hk = hc;
							hk_2 = hc;
							check_ex = 0;
							check_oh = 0;
							for(hk = 0; (hr + win_condition <=rows )&& (hc + win_condition <=columns ) && (hr + hk < rows) && (hc+hk < columns); hk++){
								if (board[hr+hk][hc + hk] == oh){
									check_oh++;
								}
								if (check_oh == win_condition){
									win = true;
								}
							}
						}
					}
				}
				
				// Case:3.2 DIAGONAL check
				// upper right to lower left
				for (hr = 0; hr < rows; hr++){
					for (hc = 0; hc < columns; hc++){
							
						if (board[hr][hc] == ex) {
							hk = hc;
							hk_2 = hc;
							check_ex = 0;
							check_oh = 0;
							
							for(hk = 0; (hr + win_condition <=rows )&& (hc - win_condition >= -1 ) && (hr + hk < rows) && (hc - hk >= 0); hk++){
								if (board[hr+hk][hc-hk] == ex){
									check_ex++;	
								}
								if (check_ex == win_condition){
									win = true;
								}
							}
						}
						else if (board[hr][hc] == oh) {
							hk = hc;
							hk_2 = hc;
							check_ex = 0;
							check_oh = 0;
							
							for(hk = 0; (hr + win_condition <=rows )&& (hc - win_condition >=-1 ) && (hr + hk < rows) && (hc - hk >=0); hk++){
								if (board[hr+hk][hc-hk] == oh){
									check_oh++;
								}
								if (check_oh == win_condition){
									win = true;
								}
							}
						}
					}
				}
				
				
				
				if(comp_play){
					user_switch = true;
					comp_play = false;
				}
				else{
					comp_play = true;
					user_switch = false;
				}

				if (!draw && !win) {	
					System.out.println();
					System.out.println();
						if(user_switch){
							
							System.out.print("player 1 input : ");
							player_1 = true;
							player_2 = false;
							
							user_split_check = true;
							user1 = userInput1.nextLine();
							user_split = user1.split(" ");
							first = user_split[0].charAt(0);
							second = user_split[2].charAt(0);
							first_string = " "; 
							second_string = " "; 
							comp_play = false;
						}
						else {
							System.out.println();
							System.out.print("Computer plays : ");
									
									
								r = 0 + (int)(Math.random() * ((rows -1 ) + 1));
								c = 0 + (int)(Math.random() * ((columns -1 ) + 1));
											
							while(board[r][c] != empty){
								r = 0 + (int)(Math.random() * ((rows -1 ) + 1));
								c = 0 + (int)(Math.random() * ((columns -1 ) + 1));
											
							}
								
							System.out.println("r " + r + " c " + c);
							comp_play = true;
					
						}
				}
			}
		
		
			if(win){
				System.out.println();
				if(!check_sign){
					if(comp_play){
						System.out.println("player 1 wins with " +  win_condition + " symbols !");
						player1_won++;
					}
					else {
						System.out.println("Computer wins with " +  win_condition + " symbols !");
						player2_won++;
					}
				} 
				else {
					if(comp_play){
						System.out.println("player 1 wins with " +  win_condition + " symbols !");
						player1_won++;
					}
					else {
						System.out.println("Computer wins with " +  win_condition + " symbols !");
						player2_won++;
					}	
				}
			} 
			else if (draw){
				System.out.println();
				System.out.println("It's a draw!");
				draw_count++;	
			}
		
		  
			// Checking GamePlay
			System.out.println();
			System.out.print("Would you like to play again? ");	
			Scanner user_Final = new Scanner(System.in);
			String user_final = user_Final.next();
			
			
			if (user_final.equals("yes")){
				GamePlay = true;	
			}
			else {
				GamePlay = false;
			}
			
			TotalGame = TotalGame + 1;
			fixed_initial_switch = !fixed_initial_switch;
			
			if(fixed_initial_switch == false){
				user_switch = false;
			}
			else {
				user_switch = true;
			}
			//user_switch = !user_switch;
		  
		  
			if (GamePlay == true){
				if (fixed_initial_switch == false){
					check_player1 = true;
					check_player2 = true;
				}
				else{
					check_player1 = false;
					check_player2 = false;
				}	  
			}
			else { 
				check_player1 = false;
				check_player2 = false;
			}
		}
	}
	
	
		System.out.println();
		System.out.println("Thanks for playing tic-tac-toe++");
		System.out.println();
		System.out.println("total games \t : " + TotalGame);
		System.out.println("player 1 wins \t : " + player1_won);
		System.out.println("Computer wins \t : " + player2_won);
		System.out.println("draws \t \t : " + draw_count);
		
		if (player1_won > 0 || player2_won > 0) {
			System.out.println("best wins \t : " + win_condition + " symbols");
		}
		else {
			System.out.println("best wins \t : None! (No one won!)");
		}
	
}

/////////////////////////////////////////////////////////////////////////////////////
/////////////////////         HUMAN VS HUMAN ENDS 				/////////////////////
/////////////////////		 HUMAN VS COMPUTER ENDS				/////////////////////
/////////////////////////////////////////////////////////////////////////////////////
	
  }
  
}