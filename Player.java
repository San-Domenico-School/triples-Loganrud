import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private Dealer dealer;
    Card[] cardsSelected;
    ArrayList<Card> cardsOnBoard = new ArrayList<Card>();
    ArrayList<Integer> selectedCardsIndex = new ArrayList<Integer>();
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Player(Dealer aDealer)
    {
        dealer = aDealer;
        cardsSelected = new Card[2]; 
        cardsOnBoard = new ArrayList<>(); 
        selectedCardsIndex = new ArrayList<>();
    }
    
    public void act()
    {
        selectCards();
        boolean threeCardsHaveBeenSelected = setCardsSelected();
        if (threeCardsHaveBeenSelected)
        {
            dealer.setCardsSelected(cardsOnBoard, selectedCardsIndex, cardsSelected);
            dealer.checkIfTriple();
            resetCardsSelected();
        }
    }
    
    public void addedToWorld(World aWorld)
    {
        cardsOnBoard = (ArrayList) getWorld().getObjects(Card.class);
    }
    
    private void selectCards()
    {
        for (Card card: cardsOnBoard)
        {
            if(Greenfoot.mouseClicked(card))
            {
                if (card.getIsSelected())
                {
                    card.setIsSelected(false);
                    card.setImage(card.getCardImage());
                    selectedCardsIndex.remove(card);
                }
                else
                {
                    card.setIsSelected(true);
                    card.setImage(card.getSelectedCardImage());
                    selectedCardsIndex.add(cardsOnBoard.indexOf(card));
                }
            }
        }
    }
    
    private void resetCardsSelected()
    {
        for (Card card : cardsOnBoard)
        {
            card.setImage(card.getCardImage());
            card.setIsSelected(false);
            selectedCardsIndex.clear();
        }
    }
    private boolean setCardsSelected()
    {
        if (selectedCardsIndex.size() == 3)
        {
            cardsSelected[0] = cardsOnBoard.get(selectedCardsIndex.get(0));
            cardsSelected[1] = cardsOnBoard.get(selectedCardsIndex.get(1));
            cardsSelected[2] = cardsOnBoard.get(selectedCardsIndex.get(2));
            return true;
        }
        else
        {
            return false;
        }
    }
}
