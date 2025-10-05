import java.util.Scanner;

/**
 * This a class to validate all situations player may face in Connections.
 * 
 * @author jay
 * @version 1.0
 *
 */

public class Validation
{
    private String word;    // a word player inputs

    /**
     * Default constructor which initialize the word.
     *
     */
    public Validation()
    {
        word = "";
    }

    /**
     * Non-Default constructor which creates word input.
     *
     * @param word        Accepts the word input as a String.
     *
     */
     public Validation(String word)
     {
        this.word = word;
     }

    /**
     * Accessor method to get the input word.
     *
     * @return              The input word as a String.
     *
     */
    public String getWord()
    {
        return word;
    }

    /**
     * Mutator method to set the input word.
     *
     */
    public void setWord(String word)
    {
        this.word = word;
    }

    /**
     * Check whether this attempt succeeds or not and whether player wants to 
     * play again.
     *
     * @return              Whether the player wants to play again as a boolean.
     *
     */
    public boolean validateAttempt(int wordRemaining, int unsuccessfulAttempt)
    {
        String answer;      // whether player wants to play again
        Scanner console = new Scanner(System.in);
        // game ends since no words remain or no more attempts
        if (wordRemaining == 0 || unsuccessfulAttempt == 2)
        {
            while (true)
            {
                System.out.print("Play again? [y/n] ");
                answer = console.nextLine();
                // game restart
                if (answer.equals("y"))
                    return true;
                // game ends
                else if (answer.equals("n"))
                    return false;
                else
                    System.out.println("Invalid input.");
            }
        }
        return true;
    }

    /**
     * Check whether the words attempted connected as a theme.
     *
     * @return              Whether the words attempted connected as a theme as * a boolean.
     *
     */
    public boolean validateThemeAttempt(String[] wordAttempt)
    {
        WordGroup myWordGroup = new WordGroup();
        String themeAttempt;
        themeAttempt = myWordGroup.checkConnections(wordAttempt);
        // connected
        if (!themeAttempt.equals("no connection"))
        {
            System.out.println("Great work! The word theme is " + themeAttempt);
            return true;
        }
        // not connected
        else
        {
            System.out.println("The three words you entered can not form a connection.");
            return false;
        }
    }

    /**
     * Check whether the word attempted is in the grid.
     *
     * @return              Whether the word attempted is in the grid as a
     * boolean.
     *
     */
    public boolean validateWord(Grid grid)
    {
        boolean flag = false;
        for (int j = 0; j < grid.getGrid().length; j++)
        {
            // word in grid
            if (word.equals(grid.getGrid()[j]))
            {
                flag = true;
            }
        }
        return flag;
    }
}
