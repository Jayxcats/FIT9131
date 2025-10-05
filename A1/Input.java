import java.util.Scanner;

public class Input
{
    private String name;
    private String[] wordAttempt;

    /**
     * Default constructor which initialize name and wordAttempt.
     *
     */
    public Input()
    {
        name = "unknown";
        wordAttempt = new String[3];
    }

    /**
     * Non-Default constructor which creates the object of the class Connections.
     *
     * @param name          Accepts the player name as a String.
     * @param wordAttempt   Accepts the 3 words as a String Array.
     *
     */
    public Input(String name, String[] wordAttempt)
    {
        this.name = name;
        this.wordAttempt = wordAttempt;
    }

    /**
     * Displays the number of attempts remaining.
     *
     */
    public void displayAttempt(int attemptCount)
    {
        System.out.println("Remaining attempts: " + attemptCount);
        System.out.println();
    }

    /**
     * Displays the score after success.
     *
     */
    public void displaySuccess(Player player)
    {
        System.out.println();
        System.out.println("Game finished. It is brilliant of you to find out all the connecitons! Congratulations!!!");
        System.out.println();
        System.out.println("Your highest score is " + player.getScore());
        System.out.println();
    }

    /**
     * Displays the score after failure.
     *
     */
    public void displayFailure(Player player)
    {
        System.out.println();
        System.out.println("Game finished due to more than one failed attempt.");
        System.out.println();
        System.out.println("Your highest score is: " + player.getScore());
        System.out.println();
    }

    /**
     * Displays the 4 themes.
     *
     */
    public void displayTheme(String[] themeName)
    {
        System.out.println("The 4 themes are used in this round: ");
        for (int i = 0; i < 4; i++)
        {
            System.out.println(themeName[i]);
        }
    }

    /**
     * Displays the messages to welcome the player.
     *
     */
    public void displayWelcome()
    {
        // Display a welcome message on the screen.
        System.out.println("Welcome to the Java Connections Game."); 
        System.out.println("All work and no play makes Tim a dull boy!!");
        System.out.println();
    }

    /**
     * Displays the messages to greet the player.
     *
     */
    public void displayGreet(Player player)
    {
        // Display a greet message on the screen.
        System.out.println("Hello, " + player.getName());
        System.out.println();
    }

    /**
     * Accessor method to get the player name.
     *
     * @return              The player name as a String.
     *
     */
    public String getName()
    {
        return name;
    }

    /**
     * Accessor method to get the words attempted.
     *
     * @return              The words attempted as a String array.
     *
     */
    public String[] getWordAttempt()
    {
        return wordAttempt;
    }

    /**
     * Get the 3 word inputs from the user and check whether the word is in the grid.
     *
     * @return              The 3 words the user inputs as a String array.
     *
     */
    public String[] requestPlayerInput(Grid grid)
    {
        int i = 0;
        boolean flag;
        Scanner console = new Scanner(System.in);
        Validation myValidation = new Validation();
        
        System.out.println("Please enter 3 connected words:");
        while (i < wordAttempt.length)
        {
            // display message and accepts a word
            System.out.print("Word " + (i + 1) + ": ");
            wordAttempt[i] = console.nextLine();
            myValidation.setWord(wordAttempt[i]);
            // validate if in grid
            flag = myValidation.validateWord(grid);
            if (!flag)
            {
                System.out.println("The word " + wordAttempt[i] + " is not in the grid, please re-enter:");
                continue;
            }
            i++;
        }

        return wordAttempt;
    }

    /**
     * Get the user name from the user and check whether the name has an alphabetic character as the first character and is of a length between 4 and 8.
     *
     */
    public String requestPlayerName()
    {
        String playerName;
        int playerNameLength;
        Scanner console = new Scanner(System.in);

        do
        {
            // input the player name
            System.out.print("Enter your name: ");
            playerName = console.nextLine();
            playerNameLength = playerName.length();
            // player name is between 4 and 8
            if (playerNameLength < 4 || playerNameLength > 8)
                System.out.println("Error: numbers of charaters should be between 4 to 8.");
            // player name is alphabetic
            else if (!((playerName.charAt(0) >= 'a' && 
                        playerName.charAt(0) <= 'z')||
                       (playerName.charAt(0) >= 'A' && 
                        playerName.charAt(0) <= 'Z')))
                System.out.println("First character must be an alphabetic character.");
            else
                break;
                
        }while (true);

        return playerName;
    }

    /**
     * Mutator method to set the player name.
     *
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Mutator method to set the words attempted.
     *
     */
    public void setWordAttempt(String[] wordAttempt)
    {
        this.wordAttempt = wordAttempt;
    }
}
