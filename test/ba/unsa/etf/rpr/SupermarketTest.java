package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupermarketTest {

    @Test
    void getArtikli() {
        Supermarket radnja = new Supermarket();
        radnja.dodajArtikl(new Artikl("laptop", 1800, "1"));
        Artikl[] artikli = new Artikl[1000];
        artikli[0] = new Artikl("laptop", 1800, "1");
        assertAll("uporedjivanje",
                () -> assertEquals("laptop", artikli[0].getNaziv()),
                () -> assertEquals(1800, artikli[0].getCijena()),
                () -> assertEquals("1", artikli[0].getKod()));
    }

    @Test
    void dodajArtikl() {
        Supermarket radnja = new Supermarket();
        assertTrue(radnja.dodajArtikl(new Artikl("laptop", 1800, "1")));
    }

    //VERZIJA TESTA AKO SE UKLJUCI METODA KOJA BACA IZUZETAK

    /*@Test
    void dodajArtikl(){
        Supermarket radnja=new Supermarket();
        for(int i=0;i<1000;i++)
            radnja.dodajArtikl(new Artikl("laptop",1800,"1"));
        assertThrows(IllegalArgumentException.class,()->{radnja.dodajArtikl(new Artikl("laptop",1800,"1"));});
    }*/

    @Test
    void dodajArtikl2() {
        Supermarket radnja = new Supermarket();
        for (int i = 0; i < 1000; i++) {
            radnja.dodajArtikl(new Artikl("laptop", 1800, "1"));
        }
        assertFalse(radnja.dodajArtikl(new Artikl("laptop", 1800, "1")));

    }

    @Test
    void izbaciArtiklSaKodom() {
        Supermarket radnja = new Supermarket();
        radnja.dodajArtikl(new Artikl("laptop", 1800, "1"));
        radnja.dodajArtikl(new Artikl("mobitel", 750, "2"));
        radnja.dodajArtikl(new Artikl("fotoaparat", 500, "3"));
        Artikl a = radnja.izbaciArtiklSaKodom("1");
        assertAll("izbacivanje",
                () -> assertEquals("laptop", a.getNaziv()),
                () -> assertEquals(1800, a.getCijena()),
                () -> assertEquals("1", a.getKod()));
    }

    @Test
    void izbaciArtiklSaKodom2() {
        Supermarket radnja = new Supermarket();
        radnja.dodajArtikl(new Artikl("laptop", 1800, "1"));
        radnja.dodajArtikl(new Artikl("mobitel", 750, "2"));
        assertNull(radnja.izbaciArtiklSaKodom("3"));

    }
}