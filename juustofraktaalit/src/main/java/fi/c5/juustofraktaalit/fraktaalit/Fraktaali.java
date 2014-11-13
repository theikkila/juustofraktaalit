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
    public abstract FraktaaliTyyppi haeTyyppi();
    public abstract void asetaAlueet(Alue alue, Kuvapinta kuvapinta);
    public abstract int laskeVari(int x, int y);
}
