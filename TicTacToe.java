
public class TicTacToe {

	//instance variables
	private String[][] board;

	private static final int ROWS = 3;

	private static final int COLS = 3;

	//initializes the board
	public TicTacToe() {

		board = new String[ROWS][COLS];
		for (int x = 0; x < ROWS; x++) {
			for (int y = 0; y < COLS; y++) {
				board[x][y] = " ";
			}
		}

	}

	//sets an x or an o onto the specified position
	//precondition: r and c will be within range
	public void set(int r, int c, String p) {

		if (r >= 0 && r < ROWS && c >= 0 && c < COLS && board[r][c].equals(" ")) {

			board[r][c] = p;

		}

	}
	
	//returns the board
	public String[][] getBoard()
	{
		return board;
	}
	

	//Evenly prints the tic-tac-toe board
	public String toString() {

		String r = "";

		r += "        C C C\n        o o o\n        l l l\n\n        1 2 3\n\n";
		for (int x = 0; x < ROWS; x++) {

			for (int y = 0; y < COLS; y++) {

				if (y == 0)

					r += "Row " + (x + 1) + "  [";

				if (y < COLS - 1)
					r += board[x][y] + " ";

				if (y == COLS - 1)
					r += board[x][y] + "]\n";

			}

		}

		return r;

	}

	//checks if the game is over
	public boolean gameOver() {

		// check for win

		if (checkDown() || checkRight() || checkSW() || checkSE())

			return true;

		else if (catsGame())

			return true;

		else

			return false;

	}

	//checks for a draw
	public boolean catsGame()

	{

		for (int x = 0; x < ROWS; x++)

			for (int y = 0; y < COLS; y++)

				if (board[x][y] == " ")

					return false;

		return true;

	}

	//uses for loop to see if any of the columns have the same string repeated
	private boolean checkDown() {

		String temp = "";

		for (int x = 0; x < COLS; x++) {

			temp = board[0][x];

			for (int y = 0; y < ROWS; y++) {

				if (board[y][x].equals(" ") || !board[y][x].equals(temp))

					break;

				if (y == ROWS - 1)

					return true;

			}

		}

		return false;

	}

	//uses a for loop to check if any row has the same string repeated
	private boolean checkRight() {

		String temp = "";

		for (int x = 0; x < ROWS; x++) {

			temp = board[x][0];

			for (int y = 0; y < COLS; y++) {

				if (board[x][y].equals(" ") || !board[x][y].equals(temp))

					break;

				if (y == ROWS - 1)

					return true;

			}

		}

		return false;

	}

	//checks the SE diagonal
	private boolean checkSE()

	{

		String tL = board[0][0];

		if (tL.equals(" "))
			return false;

		for (int x = 1, y = 1; x < ROWS && y < COLS; x += 1, y++)

		{

			if (board[x][y].equals(" ") || !board[x][y].equals(tL))

				return false;

		}

		return true;

	}

	//checks the South west diagonal
	private boolean checkSW()

	{

		String tR = board[0][2];
		if (tR.equals(" "))
			return false;

		for (int x = 1, y = 1; x < ROWS && y < COLS; x += 1, y--)

		{

			if (board[x][y].equals(" ") || !board[x][y].equals(tR))

				return false;

		}

		return true;

	}

}