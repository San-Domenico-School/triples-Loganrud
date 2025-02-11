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
    ArrayList<Integer> cardsSelectedIndex = new ArrayList<Integer>();
    Card[] cardsSelected = new Card[82];
    private int numCardsInDeck;
    private int triplesRemaining;
    private boolean shapeType;
    private boolean colorType;
    private boolean shadingType;
    private boolean numOfShapeTypes;
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
        Integer cardsRemaining = new Integer(deck.getNumCardsInDeck());
        Integer score = new Integer(Scorekeeper.getScore());
        getWorld().showText(cardsRemaining.toString(), 312, 470);
        getWorld().showText(score.toString(), 312, 507);
    }
    
    public void endGame()
    {
        if (triplesRemaining == 0)
        {
            Greenfoot.stop();
        }
    }
    
    public void checkIfTriple(Card[] cardsSelected)
    {
        this.cardsSelected = cardsSelected;
        checkShape(cardsSelected);
        //System.out.println("Shape"+ checkShape(cardsSelected));
        checkColor(cardsSelected);
        //System.out.println("Color"+ checkColor(cardsSelected));
        checkShading(cardsSelected);
        //System.out.println("Shading"+ checkShading(cardsSelected));
        checkNumberOfShapes(cardsSelected);
        //System.out.println("NumOfShapes"+ checkNumberOfShapes(cardsSelected));
        if(checkShape(cardsSelected) && checkColor(cardsSelected) 
        && checkShading(cardsSelected) && checkNumberOfShapes(cardsSelected) == true)
        {
            actionIfTriple(cardsSelected);
        }
        else
        {
            Animations.wobble();
        }
    }
    
    public void actionIfTriple(Card[] cardsSelected)
    {
        int[][] cardLocation = new int[5][3];
        for (int i = 0; i < cardsSelected.length; i++) 
        {
            cardLocation[i][0] = cardsSelected[i].getX();  // x-coordinate
            cardLocation[i][1] = cardsSelected[i].getY();  // y-coordinate
        }
        Animations.slideAndTurn();
        // Remove the cards from the board
        for (int i = 0; i < cardsSelected.length; i++) 
        {
            int x = cardLocation[i][0];
            int y = cardLocation[i][1];
            getWorld().removeObject(cardsSelected[i]);
        }

        // Deal new cards and add them to the board
        for (int i = 0; i < cardsSelected.length; i++) 
        {
            int x = cardLocation[i][0];
            int y = cardLocation[i][1];
            Card card = deck.getTopCard();
            getWorld().addObject(card,  x,  y);
        }

        // Decrement triplesRemaining
        triplesRemaining--;
        //Update score
        Scorekeeper.updateScore();
        //update UI
        setUI();
        //check endGame
        endGame();
        
        
    }
    
    public boolean checkShape(Card[] cardsSelected)
    {
        if (cardsSelected[0].getShape() == cardsSelected[1].getShape()  
        && cardsSelected[0].getShape() == cardsSelected[2].getShape())
        {
            shapeType = true;
        }
        else if (cardsSelected[0].getShape() != cardsSelected[1].getShape()  
        && cardsSelected[0].getShape() != cardsSelected[2].getShape()
        && cardsSelected[1].getShape() != cardsSelected[2].getShape())
        {
            shapeType = true;
        }
        else
        {
            shapeType = false;
        }
        return shapeType;
    }
    
    public boolean checkColor(Card[] cardsSelected)
    {
        if (cardsSelected[0].getColor() == cardsSelected[1].getColor()  
        && cardsSelected[0].getColor() == cardsSelected[2].getColor())
        {
            colorType = true;
        }
        else if (cardsSelected[0].getColor() != cardsSelected[1].getColor()  
        && cardsSelected[0].getColor() != cardsSelected[2].getColor()
        && cardsSelected[1].getColor() != cardsSelected[2].getColor())
        {
            colorType = true;
        }
        else
        {
            colorType = false;
        }
        return colorType;
    }
    
    public boolean checkShading(Card[] cardsSelected)
    {
        if (cardsSelected[0].getShading() == cardsSelected[1].getShading()  
        && cardsSelected[0].getShading() == cardsSelected[2].getShading())
        {
            shadingType = true;
        }
        else if (cardsSelected[0].getShading() != cardsSelected[1].getShading()  
        && cardsSelected[0].getShading() != cardsSelected[2].getShading()
        && cardsSelected[1].getShading() != cardsSelected[2].getShading())
        {
            shadingType = true;
        }
        else
        {
            shadingType = false;
        }
        return shadingType;
    }
    
    public boolean checkNumberOfShapes(Card[] cardsSelected)
    {
        if (cardsSelected[0].getNumberOfShapes() == cardsSelected[1].getNumberOfShapes()  
        && cardsSelected[0].getNumberOfShapes() == cardsSelected[2].getNumberOfShapes())
        {
            numOfShapeTypes = true;
        }
        else if (cardsSelected[0].getNumberOfShapes() != cardsSelected[1].getNumberOfShapes()  
        && cardsSelected[0].getNumberOfShapes() != cardsSelected[2].getNumberOfShapes()
        && cardsSelected[1].getNumberOfShapes() != cardsSelected[2].getNumberOfShapes())
        {
            numOfShapeTypes = true;
        }
        else
        {
            numOfShapeTypes = false;
        }
        return numOfShapeTypes;
    }
    
    public void setCardsSelected(ArrayList<Card> cardList, ArrayList<Integer> indexList, Card[] cardArray)
    {
    
    }
}
