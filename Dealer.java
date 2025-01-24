import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Dealer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dealer extends Actor
{
    private Deck deck;
    ArrayList<Card> cardsOnBoard = new ArrayList<Card>();
    ArrayList<Integer> selectedCardsIndex = new ArrayList<Integer>();
    Card[] cardsSelected = new Card[82];
    private int numCardsInDeck;
    private int triplesRemaining;
    /**
     * Act - do whatever the Dealer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public  Dealer(int numCardsInDeck)
    {
        this.numCardsInDeck = numCardsInDeck;
        triplesRemaining = numCardsInDeck / 3;
        deck = new Deck(numCardsInDeck);
        cardsSelected = new Card[3];
    }
    
    public void addedToWorld(greenfoot.World world)
    {
        dealBoard();
        setUI();
    }
    
    public void dealBoard()
    {
        Greenfoot.playSound("shuffle.wav");
        int rows = 5;
        int cols = 3;
        int boardHeight = 600;
        int boardWidth = 330;
        int cardWidth = 213;
        int cardHeight = 65;
        int horizontalSpacing = (boardWidth - (cols * cardWidth)) / (cols + 1);
        int verticalSpacing = 20;
        int startX = 77;
        int startY = 40;
        
        
        
        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < cols; col++)
            {
                if (deck.getNumCardsInDeck() == 0)
                {
                    return;
                }
                
                int x = startX + col * (cardWidth + horizontalSpacing);
                int y = startY + row * (cardHeight + verticalSpacing);
                
                Card card = deck.getTopCard();
                cardsOnBoard.add(card);
                World world = getWorld();
                if (world != null)
                {
                   world.addObject(card, x, y); 
                }
            }
        }
    }
    
    public void setUI()
    {
        Integer cardsRemaining = new Integer(numCardsInDeck - 15);
        Integer score = new Integer(0);
        getWorld().getBackground().drawString(cardsRemaining.toString(), 305, 475);
        getWorld().getBackground().drawString(score.toString(), 308, 510);
    }
    
    public void endGame()
    {
        
    }
    
    public void checkIfTriple()
    {
        
    }
    
    public void actionIfTriple()
    {
    
    }
    
    public void setCardsSelected(ArrayList<Card> cardList, ArrayList<Integer> indexList, Card[] cardArray)
    {
    
    }
}
