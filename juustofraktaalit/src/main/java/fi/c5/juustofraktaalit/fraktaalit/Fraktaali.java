/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.fraktaalit;

import fi.c5.juustofraktaalit.hajauttaja.Alue;

/**
 *
 * @author Teemu Heikkilä
 */
public interface Fraktaali {
    public void asetaAlueet(Alue<Double> alue, Alue<Integer> kuvapinta);
    public int laskeVari(long x, long y);
}
