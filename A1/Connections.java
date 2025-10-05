import java.util.*;

/**
 * This a class to operate the Connections Game
 * 
 * @author jay
 * @version 1.0
 *
 * Provided main method to start the game.
 *
 */

public class Connections
{
    private Player player;
    private Grid grid;

    /**
     * Default constructor which creates the object of the class Connections.
     *
     */
    public Connections()
    {
        player = new Player();
        grid = new Grid();
    }

    /**
     * Non-Default constructor which creates the object of the class Connections.
     *
     * @param player        Accepts the player information as a player object.
     * @param grid          Accepts the grid information as a grid object.
     *
     */
    public Connections(Player player, Grid grid)
    {
        this.player = player;
        this.grid = grid;
    }

    /**
     * Judge whether to end the game after the player attempts once and give the player a another try.
     *
     * @return              Whether the player's game should be ended as
     * a boolean.
     *
     */
    public boolean endGame(int wordRemaining, int unsuccessfulAttempt)
    {
        Input myInput = new Input();
        Validation myValidation = new Validation();

        if (wordRemaining == 0)
        {
            myInput.displaySuccess(player);
        }
        else if (unsuccessfulAttempt == 2)
        {
            myInput.displayFailure(player);
        }
        
        return myValidation.validateAttempt(wordRemaining, unsuccessfulAttempt);
    }

    /**
     * Accessor method to get the Player object.
     *
     * @return              The player information as a Player object.
     *
     */
    public Player getPlayer()
    {
        return player;
    }

    /**
     * Accessor method to get the Grid object.
     *
     * @return              The grid information as a Grid object.
     *
     */
    public Grid getGrid()
    {
        return grid;
    }

    /**
     * Method to being the program.
     *
     * @param args          An array of Strings representing command line
     * arguments.
     *
     */
    public static void main(String[] args)
    {   
        Connections myConnections = new Connections();
        myConnections.startGame();
    }

    /**
     * Mutator method to set the Player object.
     *
     */
    public void setPlayer(Player player)
    {
        this.player = player;
    }

    /**
     * Mutator method to set the Grid object.
     *
     */
    public void setGrid(Grid grid)
    {
        this.grid = grid;
    }

    /**
     * Start the game by calling different functions.
     *
     */
    public void startGame()
    {
        // Scanner console = new Scanner(System.in);
        Input myInput = new Input();
        Validation myValidation = new Validation();
        // Display a welcome message on the screen.
        myInput.displayWelcome();
        // console.nextLine();

        // Request the player to enter their name.
        player.setName(myInput.requestPlayerName());
        myInput.displayGreet(player);

        // counts for a single round
        while (true)
        {
            int score = 0;                  // score player get this round
            int successfulAttempt = 0;      // successful attempts player made
            int unsuccessfulAttempt = 0;    // unsuccessful attempts player has
            int attemptCount = 5;           // attempt times remaining
            int wordRemaining = 12;         // words player has not used
            boolean restart = true;         // whether to restart the game

            String[] wordAttempt;           // 3 words input by the player
            String[] themeName;             // 4 themes for this round
            String[] wordName;              // 12 words for this round
            WordGroup myWordGroup = new WordGroup();
            
            // Initialize
            themeName = myWordGroup.getThemes();
            wordName = myWordGroup.generateGroup();
            
            // set grid
            grid.setGrid(wordName);
            // display 4 themes
            myInput.displayTheme(themeName);
            
            // Request the player to enter 3 connected words
            while(wordRemaining > 0 && unsuccessfulAttempt < 2)
            {
                // Display the grid
                grid.display();
                myInput.displayAttempt(attemptCount);

                // Request word input
                wordAttempt = myInput.requestPlayerInput(grid);
                attemptCount -= 1;

                // Check word connection
                if (myValidation.validateThemeAttempt(wordAttempt))
                {
                    // success
                    wordRemaining -= 3;
                    successfulAttempt += 1;
                    grid.modifyGrid(wordAttempt, wordRemaining);
                }
                else
                    // failure
                    unsuccessfulAttempt += 1;
                // calculate and update score
                score = successfulAttempt * 2 - unsuccessfulAttempt;
                if (score > player.getScore())
                    player.setScore(score);
            }
            // whether to end this round and restart the game
            restart = endGame(wordRemaining, unsuccessfulAttempt);
            if (!restart)
                break;
        }
    }
}

