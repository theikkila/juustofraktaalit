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
public class Tyo {
    private final FraktaaliTyyppi fraktaali;
    public Alue alue;

    /**
     *
     * @param fraktaali Mitä fraktaalia käytetään 
     * @param alue
     */
    public Tyo(FraktaaliTyyppi fraktaali, Alue<Double> alue) {
        this.fraktaali = fraktaali;
        this.alue = alue;
    }
}
