/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.fraktaalit;

import fi.c5.juustofraktaalit.hajauttaja.Alue;
import fi.c5.juustofraktaalit.hajauttaja.Kuvapinta;

/**
 *
 * @author Teemu Heikkilä
 */
public abstract class Fraktaali {
    /**
     * Asettaa fraktaalille renderöitävän alueen
     * @param alue renderöitävä alue
     * @param kuvapinta kuvapinta jolle alue renderöidään
     */
    public abstract void asetaAlueet(Alue alue, Kuvapinta kuvapinta);
    /**
     * Laskee väriarvon pikselille (x, y)
     * @param x pikselin x-koordinaatti
     * @param y pikselin y-koordinaatti
     * @return pikselille laskettu väri
     */
    public abstract int laskeVari(int x, int y);
    /**
    * Palauttaa fraktaalin tyypin
    * @return fraktaalin tyyppi
    */
    public String haeTyyppi(){
       return this.getClass().getSimpleName();
    }
}
