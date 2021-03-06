/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.hajauttaja;

import java.util.Objects;

/**
 * Työ on abstrakti yliluokka joka kuvaa renderöintityötä kokonaisuutena
 * @author Teemu Heikkilä
 */
public abstract class Tyo implements Runnable {
    /**
     * Fraktaalialgoritmin nimi
     */
    private final String fraktaali;

    /**
     * Alue-muuttujaan on tallennettuna työalue
     */
    public Alue alue;
    
    /**
     * Kuvapinta-muuttujaan on tallennettuna kuvapinta jolle fraktaali renderöidään
     */
    public Kuvapinta pinta;
    /**
     * Työn konstruktori
     * @param fraktaali Mitä fraktaalia käytetään 
     * @param alue Työalue
     * @param pinta Kuvapinta
     */
    public Tyo(String fraktaali, Alue alue, Kuvapinta pinta) {
        this.fraktaali = fraktaali;
        this.alue = alue;
        this.pinta = pinta;
    }
    
    /**
     * Palauttaa työn fraktaalin luokkanimen
     * @return fraktaalityyppi
     */
    public String haeTyyppi () {
        return this.fraktaali;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.fraktaali);
        hash = 97 * hash + Objects.hashCode(this.alue);
        hash = 97 * hash + Objects.hashCode(this.pinta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tyo other = (Tyo) obj;
        if (this.fraktaali != other.fraktaali) {
            return false;
        }
        if (!Objects.equals(this.alue, other.alue)) {
            return false;
        }
        if (!Objects.equals(this.pinta, other.pinta)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Tyo:" + this.alue;
    }

    @Override
    public abstract void run();
}
