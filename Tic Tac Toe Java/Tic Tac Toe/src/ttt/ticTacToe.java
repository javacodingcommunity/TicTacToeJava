package ttt;

public class ticTacToe {
	
	public ticTacToe() {
		
		System.out.println("Game is starting, initializing the board!");
		// constructor used to start a new game
		board = new char[3][3];
		for(int i = 0;i<board.length;i++) {
			for(int j = 0;j<board.length;j++) {
				board[i][j] = '-';
				
			}
		}
		
		
	}
	
	 char[][] board; // 2d array representing the board
	
	 static char playerMark = 'x'; // 'x' or 'o', representing the player mark
	 
	 
	

	
	
	// a method that prints out the board at any given time
	public void printBoard() {
		System.out.println("-------------");
	
		for(int i = 0;i<board.length;i++) {
			System.out.print("| ");
			for(int j = 0;j<board.length;j++) {
				System.out.print(board[i][j]);	
				System.out.print(" | ");
			}
			
			System.out.println();
			System.out.println("-------------");
		}
		
	}
	
	
	// prints the current player mark so players know who's turn it is
	public void printCurrentMark() {
		System.out.println("Current player Mark is: "+ playerMark);
	}
	
	
	// A method that sets the current player mark on the open position
	public void setMark(int positionRow, int positionColumn) {
		
		if(board[positionRow-1][positionColumn-1] != '-') {
			System.out.println("That place is already taken. Please check the board again.");
			System.out.println("This is the current board!");
			printBoard();
		}
		
		else {
			if(playerMark == 'x') {
				System.out.println("Setting the 'X' player Mark");
				board[positionRow-1][positionColumn-1] = 'x';
				playerMark = 'o';
			}
			else if(playerMark =='o') {
				System.out.println("Setting the 'O' player Mark");
				board[positionRow-1][positionColumn-1] = 'o';
				playerMark = 'x';
			}
			
			printBoard();
			printCurrentMark();
			
		}
	}
	
	
	// checks for a winner
	public boolean checkForWinner() {
		if(checkRows() == true || checkColumns() == true || checkDiagonals() == true) return true;
		else return false;
	}
	
	// checks rows for a win
	public boolean checkRows() {
	
		for(int i = 0;i<board.length;i++) {
			
			if(board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != '-') {
				return true;
			}
			else return false;
			
		}
		return false;
		
	}
	
	
	// checks columns for a win
	public boolean checkColumns() {
		
		for(int j = 0;j<board.length;j++) {
			
			if(board[0][j] == board[1][j] && board[0][j] == board[2][j] && board[0][j] != '-') {
				return true;
			}
			else return false;
			}
		return false;	
	}
	
	// checks diagonals for a win
	public boolean checkDiagonals() {
		
		if(board[0][0] == board[1][1] && board[0][0] == board[2][2] & board[0][0] != '-') return true;
		else if( board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != '-') return true;
		else return false;
	}
	
	
	public static void main(String[] args) {
		ticTacToe ttt = new ticTacToe();
		ttt.printBoard();
		ttt.setMark(3, 2);
		ttt.setMark(3, 3);
		ttt.setMark(3, 1);
		ttt.setMark(2, 2);
		ttt.setMark(3, 3);
		ttt.setMark(2, 1);
		ttt.setMark(1, 1);
		if(ttt.checkForWinner() == true) System.out.println("Win");
		
		
	}
	

}
