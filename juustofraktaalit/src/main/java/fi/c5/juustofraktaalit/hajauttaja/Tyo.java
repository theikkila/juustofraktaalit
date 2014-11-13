/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.hajauttaja;

import fi.c5.juustofraktaalit.fraktaalit.FraktaaliTyyppi;

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
}
