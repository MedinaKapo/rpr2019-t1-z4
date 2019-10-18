package ba.unsa.etf.rpr;

import java.util.Scanner;

public class Korpa {
    private Artikl[] stvari;
    int vel;

    public Korpa() {
        stvari = new Artikl[50];
        vel = 0;
    }

    public Artikl[] getArtikli() {
        return stvari;
    }

    public boolean dodajArtikl(Artikl a) {
        if (vel < 50) {
            stvari[vel] = new Artikl(a.getNaziv(), a.getCijena(), a.getKod());
            vel++;
            return true;
        }
        return false;
    }

    public int dajUkupnuCijenuArtikala() {
        int ukupno = 0;
        for (int i = 0; i < vel; i++) {
            ukupno += stvari[i].getCijena();
        }
        return ukupno;
    }

    public Artikl izbaciArtiklSaKodom(String bar) {
        Artikl izbaci = null;
        for (int i = 0; i < vel; i++) {
            if (stvari[i].kod.equals(bar)) {
                izbaci = stvari[i];
                for (int j = i + 1; j < vel; j++) {
                    stvari[j - 1] = stvari[j];
                }
                stvari[vel - 1] = null;
                --vel;
                --i;
            }
        }

        return izbaci;
    }
}
