package edu.badpals.ricksy;

import edu.badpals.ricksy.CreditCard;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class CreditCardTest {

    private CreditCard card = null;

    @Before
    public void setupCard() {
        card = new CreditCard("Abradolf Lincler", "4916119711304546");
        assertNotNull("CreditCard creada", card);
    }
    @Test public void constructortest() {  
        assertNotNull("CreditCard creada", card);      
        assertEquals("4916119711304546", card.number());
    }

    @Test
    public void payTestOK() {
        card.pay(3000);
        assertEquals(0, card.credit(), 0);
    }

    @Test
    public void payTestNOTOK() {
        card.pay(4000);
        assertEquals(3000, card.credit(), 0);
    }
}
