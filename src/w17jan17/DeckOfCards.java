package w17jan17;

import java.security.SecureRandom;
import java.util.ArrayList;

/**
 *
 * @author jwright
 */
public class DeckOfCards {
    ArrayList<Card> deck;
    
    public DeckOfCards()
    {
        deck = new ArrayList<>();
        
        String[] suits = {"hearts","diamonds","spades","clubs"};
        String[] faceNames = {"two","three","four","five","six","seven","eight",
                              "nine","ten","Jack","Queen","King","Ace"};
        
        for (String suit: suits)
        {
            for (int i=0; i<faceNames.length; i++)
            {
                Card newCard = new Card(faceNames[i], suit, i+2);
                deck.add(newCard);
            }
        }
    }
    
    
    /**
     * This method will simulate shuffling the deck
     */
    public void shuffle()
    {
            SecureRandom rng = new SecureRandom();

            for (int i=0; i < deck.size(); i++)
            {
                Card swapCard = deck.remove(i);
                deck.add(rng.nextInt(52), swapCard);
            }    
    }
    
    /**
     * This method will "deal" the top card from the deck
     */
    public Card dealTopCard()
    {
        if (deck.size() > 0)
            return deck.remove(0);
        return null;
    }
    
    
}
