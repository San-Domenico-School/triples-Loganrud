import greenfoot.*; 

/**
 * Game Board for Triples
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Card extends Actor
{
    public enum Color
    {
        RED, BLUE, GREEN, NO_COLOR
    }
    
    public enum Shape
    {
        SQUARE, CIRCLE, TRIANGLE, NO_SHAPE
    }
    
    private Shape shape;
    private Color color;
    private boolean isSelected;
    private GreenfootImage cardImage, selectedCardImage;
    private int numberOfShapes, shading;
    
    public Card (Shape cardShape, Color cardColor, int cardNumberOfShapes,                   
                  int cardShading, GreenfootImage cardImage, 
                  GreenfootImage selectedCardImage)
    {
        shape = cardShape;
        color = cardColor;
        numberOfShapes = cardNumberOfShapes;
        shading = cardShading;
        this.cardImage = cardImage;
        this.selectedCardImage = selectedCardImage;
        isSelected = false;
        setImage(cardImage);
    }
    
    public Shape getShape()
    {
        return shape;
    }
    
    public void setShape(Shape newShape)
    {
        shape = newShape;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public void setColor(Color newColor)
    {
        color = newColor;
    }
    
    public boolean getIsSelected()
    {
        return isSelected;
    }
    
    public void setIsSelected(boolean isSelected)
    {
        this.isSelected = isSelected;
    }
    
    public GreenfootImage getCardImage()
    {
        return cardImage;
    }
    
    public void setCardImage(GreenfootImage cardImage)
    {
        this.cardImage = cardImage;
    }
    
    public GreenfootImage getSelectedCardImage()
    {
        return selectedCardImage;
    }
    
    public void setSelectedCardImage(GreenfootImage selectedCardImage)
    {
        this.selectedCardImage = selectedCardImage;
    }
    
    public int getNumberOfShapes()
    {
        return numberOfShapes;
    }
    
    public void setNumberOfShapes(int numberOfShapes)
    {
        this.numberOfShapes = numberOfShapes;
    }
    
    public int getShading()
    {
        return shading;
    }
    
    public void setShading(int shading)
    {
        this.shading = shading;
    }
}

