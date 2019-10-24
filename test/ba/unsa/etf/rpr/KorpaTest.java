package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorpaTest {

    @Test
    void getArtikli() {
        Korpa nova=new Korpa();
        nova.dodajArtikl(new Artikl("laptop",1800,"1"));
        nova.dodajArtikl(new Artikl("mobitel",750,"2"));
        nova.dodajArtikl(new Artikl("fotoaparat",500,"3"));
        Artikl[] artikli=new Artikl[50];
        artikli[0]=new Artikl("laptop",1800,"1");
        artikli[1]=new Artikl("mobitel",750,"2");
        artikli[2]=new Artikl("fotoaparat",500,"3");
        assertArrayEquals(artikli,nova.getArtikli());
    }

    @Test
    void dodajArtikl() {
        Artikl a=new Artikl("laptop",1800,"1");
        Korpa nova=new Korpa();
        assertTrue(nova.dodajArtikl(a));
    }

    @Test
    void dajUkupnuCijenuArtikala() {
        Korpa nova=new Korpa();
        nova.dodajArtikl(new Artikl("laptop",1800,"1"));
        nova.dodajArtikl(new Artikl("mobitel",750,"2"));
        nova.dodajArtikl(new Artikl("fotoaparat",500,"3"));
        assertEquals(3050,nova.dajUkupnuCijenuArtikala());
    }

    @Test
    void izbaciArtiklSaKodom() {
        Korpa nova=new Korpa();
        nova.dodajArtikl(new Artikl("laptop",1800,"1"));
        nova.dodajArtikl(new Artikl("mobitel",750,"2"));
        nova.dodajArtikl(new Artikl("fotoaparat",500,"3"));
        Artikl a=nova.izbaciArtiklSaKodom("1");
        assertAll("izbacivanje",
                ()->assertEquals("laptop",a.getNaziv()),
                ()->assertEquals(1800,a.getCijena()),
                ()->assertEquals("1",a.getKod()));
    }
}