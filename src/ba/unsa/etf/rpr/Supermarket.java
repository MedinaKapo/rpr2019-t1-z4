package ba.unsa.etf.rpr;

import java.util.Scanner;

public class Supermarket {
    private Artikl[] artikli;
    int velicina;

    public Supermarket() {
        artikli = new Artikl[1000];
        velicina = 0;
    }

    public Artikl[] getArtikli() {
        return artikli;
    }

    public boolean dodajArtikl(Artikl a) {
        if (velicina < 1000) {
            artikli[velicina] = new Artikl(a.getNaziv(), a.getCijena(), a.getKod());
            velicina++;
            return true;
        }
        return false;
    }

    public Artikl izbaciArtiklSaKodom(String bar) {
        Artikl izbaci = null;
        for (int i = 0; i < velicina; i++) {
            if (artikli[i].kod.equals(bar)) {
                izbaci = artikli[i];
                for (int j = i + 1; j < velicina; j++) {
                    artikli[j - 1] = artikli[j];
                }

                artikli[velicina - 1] = null;
                --velicina;
                --i;
            }
        }
        return izbaci;
    }
}
