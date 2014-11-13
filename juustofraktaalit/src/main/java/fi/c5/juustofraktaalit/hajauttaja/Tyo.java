/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.hajauttaja;

import fi.c5.juustofraktaalit.fraktaalit.FraktaaliTyyppi;
import java.util.Objects;

/**
 *
 * @author Teemu Heikkilä
 */
public abstract class Tyo {
    private final FraktaaliTyyppi fraktaali;

    /**
     * Alue-muuttujaan on tallennettuna työalue
     */
    public Alue alue;

    /**
     * Työn konstruktori
     * @param fraktaali Mitä fraktaalia käytetään 
     * @param alue Työalue
     */
    public Tyo(FraktaaliTyyppi fraktaali, Alue alue) {
        this.fraktaali = fraktaali;
        this.alue = alue;
    }
    
    /**
     * Palauttaa työn fraktaalityypin
     * @return fraktaalityyppi
     */
    public FraktaaliTyyppi haeTyyppi () {
        return this.fraktaali;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.fraktaali);
        hash = 97 * hash + Objects.hashCode(this.alue);
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
        return true;
    }
    @Override
    public String toString() {
        return "Tyo:" + this.alue;
    }
}
