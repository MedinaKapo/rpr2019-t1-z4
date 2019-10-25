package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorpaTest {

    @Test
    void getArtikli() {
        Korpa nova = new Korpa();
        nova.dodajArtikl(new Artikl("laptop", 1800, "1"));
        Artikl[] artikli = new Artikl[50];
        artikli[0] = new Artikl("laptop", 1800, "1");
        assertAll("uporedjivanje",
                () -> assertEquals("laptop", artikli[0].getNaziv()),
                () -> assertEquals(1800, artikli[0].getCijena()),
                () -> assertEquals("1", artikli[0].getKod()));
    }

    @Test
    void dodajArtikl() {
        Artikl a = new Artikl("laptop", 1800, "1");
        Korpa nova = new Korpa();
        assertTrue(nova.dodajArtikl(a));
    }

    @Test
    void testDodavanjaArtikla2() {
        Korpa nova = new Korpa();
        for (int i = 0; i < 50; i++) {
            nova.dodajArtikl(new Artikl("laptop", 1000, "1"));
        }
        assertFalse(nova.dodajArtikl(new Artikl("laptop", 1000, "1")));
    }

    @Test
    void dajUkupnuCijenuArtikala() {
        Korpa nova = new Korpa();
        nova.dodajArtikl(new Artikl("laptop", 1800, "1"));
        nova.dodajArtikl(new Artikl("mobitel", 750, "2"));
        nova.dodajArtikl(new Artikl("fotoaparat", 500, "3"));
        assertEquals(3050, nova.dajUkupnuCijenuArtikala());
    }

    @Test
    void dajUkupnuCijenuArtikala2(){
        Korpa nova=new Korpa();
        assertEquals(0,nova.dajUkupnuCijenuArtikala());
    }

    @Test
    void izbaciArtiklSaKodom() {
        Korpa nova = new Korpa();
        nova.dodajArtikl(new Artikl("laptop", 1800, "1"));
        nova.dodajArtikl(new Artikl("mobitel", 750, "2"));
        nova.dodajArtikl(new Artikl("fotoaparat", 500, "3"));
        Artikl a = nova.izbaciArtiklSaKodom("1");
        assertAll("izbacivanje",
                () -> assertEquals("laptop", a.getNaziv()),
                () -> assertEquals(1800, a.getCijena()),
                () -> assertEquals("1", a.getKod()));
    }

    @Test
    void izbacivanjeArtiklaSaKodom2() {
        Korpa nova = new Korpa();
        nova.dodajArtikl(new Artikl("laptop", 1800, "1"));
        nova.dodajArtikl(new Artikl("mobitel", 750, "2"));
        assertNull(nova.izbaciArtiklSaKodom("3"));
    }
}