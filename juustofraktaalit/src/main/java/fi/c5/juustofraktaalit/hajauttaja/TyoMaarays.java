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
public class TyoMaarays extends Tyo{
    private int hajautus;

    public TyoMaarays(FraktaaliTyyppi fraktaali, Alue<Double> alue) {
        super(fraktaali, alue);
    }

    /**
     *
     * @param fraktaali
     * @param alue
     * @param hajautus
     */
    public TyoMaarays(FraktaaliTyyppi fraktaali, Alue<Double> alue, int hajautus) {
        super(fraktaali, alue);
        this.hajautus = hajautus;
    }
    
}
