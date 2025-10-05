/**
 * This a class to display the grid.
 * 
 * @author jay
 * @version 1.0
 *
 */

public class Grid
{
    private String[] gridString;

    /**
     * Default constructor which creates the words String array.
     *
     */
    public Grid()
    {
        gridString = new String[12];
    }

    /**
     * Non-Default constructor which creates the words String array.
     *
     * @param gridString        Accepts the words in grid as a String array.
     *
     */
    public Grid(String[] gridString)
    {
        this.gridString = gridString;
    }

    /**
     * Calculate the number of words remaining in the grid.
     *
     * @return              The number of words remaining in the grid as an int.
     *
     */
    public int calculateRemainingWord()
    {
        int sum = 0;
        for (int i = 0; i < gridString.length; i++)
        {
            // existing words
            if (gridString[i] != null)
                sum += 1;
        }
        return sum;
    }

    /**
     * Calculate the total length of words in a String array.
     *
     * @return              The total length of words in a String array as an  * int.
     *
     */
    public int calculateSum(int[] wordLength)
    {
        int sum = 0;
        for (int i = 0; i < wordLength.length; i++)
        {
            sum += wordLength[i];
        }
        return sum;
    }

    /**
     * Calculate an array of the longest words in each column of the grid.
     *
     */
    public void calculateWordLength(int[] wordLength)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < gridString.length / 3; j++)
            {
                if (gridString[i + j * 3] == null) continue;
                // choose the word in a column with the longest length
                wordLength[i] = gridString[i + j * 3].length() > wordLength[i] ? gridString[i + j * 3].length() : wordLength[i];
            }
        }
    }

    /**
     * Display the grid in n * 3 format.
     *
     */
    public void display()
    {
        int[] wordLength = {0, 0, 0};
        int totalLength = 0;
        int wordNumber = 0;

        calculateWordLength(wordLength);
        totalLength = calculateSum(wordLength);
        wordNumber = calculateRemainingWord();

        System.out.println("");
        System.out.println("Word Grid");
        printFrame(totalLength);

        // columns
        for (int i = 0; i < wordNumber / 3; i++)
        {
            // lines
            for (int j = 0; j < 3; j++)
            {
                System.out.print("| ");
                // words
                System.out.print(gridString[i * 3 + j]);
                // make all words paralleled
                for (int k = 0; k < wordLength[j] - gridString[i * 3 + j].length(); k++)
                {
                    System.out.print(" ");
                }
                System.out.print(" ");
            }
            System.out.println("|");

            if (i == gridString.length / 3 - 1) break;

            // split all the lines
            for (int j = 0; j < wordLength.length; j++)
            {
                System.out.print("|");
                for (int k = 0; k < wordLength[j] + 2; k++)
                {
                    System.out.print("-");
                }
            }
            System.out.println("|");
        }

        printFrame(totalLength);
    }

    /**
     * Accessor method to get the words in the grid.
     *
     * @return              The grid words as a String array.
     *
     */
    public String[] getGrid()
    {
        return gridString;
    }

    /**
     * Modify the grid to delete the words player has used.
     *
     */
    public void modifyGrid(String[] wordAttempt, int wordRemaining)
    {
        String[] wordName = new String[wordRemaining];
        int k = 0;

        for (int i = 0; i < wordAttempt.length; i++)
        {
            for (int j = 0; j < gridString.length; j++)
            {
                // delete the words used
                if (wordAttempt[i].equals(gridString[j]))
                {
                    gridString[j] = null;
                }
            }
        }

        // reset a new word grid with the remaining words
        for (int i = 0; i < gridString.length; i++)
        {
            if (gridString[i] != null)
            {
                wordName[k] = gridString[i];
                k++;
            }
        }
        setGrid(wordName);
    }

    /**
     * Print the frame of the grid displayed.
     *
     */
    public void printFrame(int totalLength)
    {
        for (int i = 0; i < totalLength + 10; i++)
        {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Mutator method to set the words in the grid.
     *
     */
    public void setGrid(String[] gridString)
    {
        this.gridString = gridString;
    }
}
