/**
 * This a class to store the player information
 * 
 * @author jay
 * @version 1.0
 *
 */

public class Player
{
    // fields
    private String name;
    private int score;

    /**
     * Default constructor which creates the player name and score.
     *
     */
    public Player()
    {
        name = "unknown";
        score = 0;
    }

    /**
     * Non-Default constructor which creates the player name and score.
     *
     * @param name              Accepts the player name as a String.
     *
     */
    public Player(String name)
    {
        this.name = name;
        this.score = 0;
    }

    /**
     * Accessor method to get the player name.
     *
     * @return              The player as a String.
     *
     */
    public String getName()
    {
        return name;
    }

    /**
     * Accessor method to get the highest score of player.
     *
     * @return              The highest score as a int.
     *
     */
    public int getScore()
    {
        return score;
    }

    /**
     * Mutator method to set the Player name.
     *
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Mutator method to set the Player highest score.
     *
     */
    public void setScore(int score)
    {
        if (score >= 0)
            this.score = score;
    }

    public String toString()
    {
        return "name: " + name + ", score: " + score;
    }
}
