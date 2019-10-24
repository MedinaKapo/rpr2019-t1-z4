package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtiklTest {

    @Test
    void getNaziv() {
        Artikl a=new Artikl("laptop",1800,"1");
        assertEquals("laptop",a.getNaziv());
    }

    @Test
    void getCijena() {
        Artikl a=new Artikl("laptop",1800,"1");
        assertEquals(1800,a.getCijena());
    }

    @Test
    void getKod() {
        Artikl a=new Artikl("laptop",1800,"1");
        assertEquals("1",a.getKod());
    }
}