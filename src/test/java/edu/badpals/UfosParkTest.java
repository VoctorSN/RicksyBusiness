package edu.badpals;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;

public class UfosParkTest {

    UfosPark ufos = null;
    String[] ovnis = { "unx", "dox", "trex" };

    @Before
    public void setupUfosPark() {
        ufos = new UfosPark();
        assertNotNull("Parque de UFOS creados", ufos);
        for (String ovni : ovnis) {
			ufos.add(ovni);
        }
    }

    @Test
    public void addUfoTest() {
        Arrays.sort(ovnis);
        assertEquals(List.of(ovnis).toString(), ufos.toString());
        
        List<String> cards = ufos.cardNumbers()
                                .stream()
                                .collect(Collectors.toList());
        assertEquals(ovnis.length, cards.size(), 0);
    }

    @Test
    public void dispatchTest() {
        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        ufos.dispatch(card);
        assertTrue(ufos.containsCard(card.number()));
        List<String> cards = ufos.cardNumbers()
                                    .stream()
                                    .filter(n -> n == card.number())
                                    .collect(Collectors.toList());

        assertEquals(1, cards.size(), 0);
        assertEquals(2500, card.credit(), 0);
    }

    @Test
    public void dispatchNoCreditTest() {
        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        card.pay(3000);
        assertEquals(0, card.credit(), 0);
        ufos.dispatch(card);
        assertFalse(ufos.containsCard(card.number()));
        assertEquals(0, card.credit(), 0);
    }

    @Test
    public void dispatchUfoAlreadyReservedTest() {
        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        ufos.dispatch(card);
        ufos.dispatch(card);
        List<String> cards = ufos.cardNumbers()
                                    .stream()
                                    .filter(n -> n == card.number())
                                    .collect(Collectors.toList());

        assertEquals(1, cards.size(), 0);
        assertEquals(2500, card.credit(), 0);
    }

    @Test
    public void dispatchNoUfoAvaliableTest() {
        CreditCard abradolph = new CreditCard("Abradolf Lincler", "4916119711304546");
        ufos.dispatch(abradolph);
        CreditCard squanchy = new CreditCard("Squanchy", "4444444444444444");
        ufos.dispatch(squanchy);
        CreditCard birdpearson = new CreditCard("Birdpearson", "1111111111111111");
        ufos.dispatch(birdpearson);
        CreditCard morty = new CreditCard("Morty", "0000000000000000");
        ufos.dispatch(morty);

        List<String> cards = ufos.cardNumbers()
                                    .stream()
                                    .filter(n -> n == morty.number())
                                    .collect(Collectors.toList());

        assertEquals(0, cards.size(), 0);
        assertEquals(3000, morty.credit(), 0);
    }

    @Test
    public void getUfoOfTest() {
        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        ufos.dispatch(card);
        assertTrue(ufos.toString().contains(ufos.getUfoOf(card.number())));
        assertEquals(2500, card.credit(), 0);
    }
}
