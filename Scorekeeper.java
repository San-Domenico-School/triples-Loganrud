/**
 * Write a description of class Scorekeeper here.
 * 
 * @Logan Rudsenske 
 * @01/13/2025
 */
public class Scorekeeper  
{
    private static int deckSize, score;
    private static long startTime = System.currentTimeMillis();
    
    public static void setDeckSize(int newDeckSize)
    {
        deckSize = newDeckSize;
    }
    public static void updateScore()
    {
        score = score + (int)(1000000 / (System.currentTimeMillis() - startTime));
    }
    public static int getScore()
    {
        return score;
    }
}
