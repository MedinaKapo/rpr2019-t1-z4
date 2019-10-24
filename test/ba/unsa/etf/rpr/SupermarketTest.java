package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupermarketTest {

    @Test
    void getArtikli() {
        Supermarket radnja=new Supermarket();
        radnja.dodajArtikl(new Artikl("laptop",1800,"1"));
        radnja.dodajArtikl(new Artikl("mobitel",750,"2"));
        radnja.dodajArtikl(new Artikl("fotoaparat",500,"3"));
        Artikl[] artikli=new Artikl[1000];
        artikli[0]=new Artikl("laptop",1800,"1");
        artikli[1]=new Artikl("mobitel",750,"2");
        artikli[2]=new Artikl("fotoaparat",500,"3");
        assertArrayEquals(artikli,radnja.getArtikli());
    }

    @Test
    void dodajArtikl() {
        Supermarket radnja=new Supermarket();
        assertTrue(radnja.dodajArtikl(new Artikl("laptop",1800,"1")));
    }

    @Test
    void izbaciArtiklSaKodom() {
        Supermarket radnja=new Supermarket();
        radnja.dodajArtikl(new Artikl("laptop",1800,"1"));
        radnja.dodajArtikl(new Artikl("mobitel",750,"2"));
        radnja.dodajArtikl(new Artikl("fotoaparat",500,"3"));
        Artikl a=radnja.izbaciArtiklSaKodom("1");
        assertAll("izbacivanje",
                ()->assertEquals("laptop",a.getNaziv()),
                ()->assertEquals(1800,a.getCijena()),
                ()->assertEquals("1",a.getKod()));
    }
}