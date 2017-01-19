package w17jan17;

/**
 *
 * @author jwright
 */
public class Card {
    private String faceName, suit;
    private int faceValue;
    
    public Card(String faceName, String suit, int value)
    {
        this.faceName = faceName;
        setSuit(suit);
        setFaceValue(value);
    }
    
    
    /**
     * This method will validate that card has a value between 2-14
     */
    private  void setFaceValue(int value)
    {
        if (value >= 2 && value <=14)
            faceValue = value;
        else
            throw new IllegalArgumentException("cards must have a value between 2-14");
    }
    
    
    /**
     * This method will validate that the suit is either hearts,
     * diamonds, spades or clubs
     */
    private void setSuit(String suit)
    {
        if (suit.equalsIgnoreCase("hearts") || suit.equalsIgnoreCase("diamonds") ||
            suit.equalsIgnoreCase("spades") || suit.equalsIgnoreCase("clubs"))
            this.suit = suit;
        else
            throw new IllegalArgumentException("Suit must be hearts, diamonds, spades or clubs");
    }

    public String getFaceName() {
        return faceName;
    }

    public String getSuit() {
        return suit;
    }

    /**
     * This returns the value of the card
     * @return 
     */
    public int getFaceValue() {
        return faceValue;
    }
    
    public String toString()
    {
        return faceName + " of " + suit;
    }
}
