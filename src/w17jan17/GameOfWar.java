package w17jan17;

import java.util.ArrayList;

/**
 *
 * @author JWright
 */
public class GameOfWar {
    private ArrayList<Card> p1Hand, p2Hand;
    
    /**
     * This is the constructor for the GameOfWar class
     */
    public GameOfWar()
    {
        p1Hand = new ArrayList<>();
        p2Hand = new ArrayList<>();
        
        DeckOfCards theDeck = new DeckOfCards();
        theDeck.shuffle();
        
        dealCards(theDeck);
    }   //end of the constructor
    
    
    /**
     * This method will deal all of the cards equally to the 2 players
     */
    private void dealCards(DeckOfCards theDeck)
    {
        for (int cardNum = 0; cardNum < 52; cardNum++)
        {
            if (cardNum % 2 ==  0)
                p1Hand.add(theDeck.dealTopCard());
            else
                p2Hand.add(theDeck.dealTopCard());
        }
    }
    
    /**
     * This method will run the game
     */
    public void playGame()
    {
        while (!p1Hand.isEmpty() && !p2Hand.isEmpty())
        {
            playHand();
        }
        
        if (p1Hand.isEmpty())
            System.out.println("The winner is player 2");
        else
            System.out.println("The winner is player 1");
    }
    
    /**
     * This method will simulate playing a "hand" in the game of war 
     */
    private void playHand()
    {
        if (p1Hand.size() > 0 && p2Hand.size() > 0)
        {
            Card p1Card = p1Hand.remove(0);
            Card p2Card = p2Hand.remove(0);
            
            System.out.printf("Player 1 card: %s, total cards: %d", p1Card, p1Hand.size()+1);
            System.out.printf("\tPlayer 2 card: %s, total cards: %d%n", p2Card, p2Hand.size()+1);
            
            //check if Player 1 had a higher card
            if (p1Card.getFaceValue() > p2Card.getFaceValue())
            {
                p1Hand.add(p1Card);
                p1Hand.add(p2Card);
            }
            //check if Player 2 had a higher card
            else if (p2Card.getFaceValue() > p1Card.getFaceValue())
            {
                p2Hand.add(p1Card);
                p2Hand.add(p2Card);
            }
            //it must be war
            else
            {
                ArrayList<Card> pile = new ArrayList<>();
                pile.add(p1Card);
                pile.add(p2Card);
                playWarHand(pile);
            }
        }
    }   //end of the method playHand()
    
    /**
     * This method will simulate playing a "war" hand
     */
    private void playWarHand(ArrayList<Card> pile)
    {
        //check if player 1 has enough cards for war
        if (p1Hand.size() < 3)
        {
            p2Hand.addAll(p1Hand);
            p1Hand.clear();
            p2Hand.addAll(pile);
            return;
        }
        
        //check if player 2 has enough cards for war
        if (p2Hand.size() < 3)
        {
            p1Hand.addAll(p2Hand);
            p2Hand.clear();
            p1Hand.addAll(pile);
            return;
        }
        
        pile.add(p1Hand.remove(0));
        pile.add(p1Hand.remove(0));
        pile.add(p2Hand.remove(0));
        pile.add(p2Hand.remove(0));
        
        Card p1Card = p1Hand.remove(0);
        Card p2Card = p2Hand.remove(0);
        
        System.out.printf("%n%n~~~~~~~~~~~ WAR ~~~~~~~~~~~~~ %n");
        System.out.printf("Player 1 card: %s, total cards: %d", p1Card, p1Hand.size()+1);
        System.out.printf("\tPlayer 2 card: %s, total cards: %d%n", p2Card, p2Hand.size()+1);
        //if player 1 wins, add all the cards to player 1's hand
        if (p1Card.getFaceValue() > p2Card.getFaceValue())
        {
            pile.add(p1Card);
            pile.add(p2Card);
            p1Hand.addAll(pile);
        }
         //if player 2 wins, add all the cards to player 2's hand
        else if (p2Card.getFaceValue() > p1Card.getFaceValue())
        {
            pile.add(p1Card);
            pile.add(p2Card);
            p2Hand.addAll(pile);
        }
        else
        {
            pile.add(p1Card);
            pile.add(p2Card);
            playWarHand(pile);
        }
    }   //end of method playWarHand()
    
}   //end of the class
