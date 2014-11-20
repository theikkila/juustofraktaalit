/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.fraktaalit;

import fi.c5.juustofraktaalit.hajauttaja.Alue;
import fi.c5.juustofraktaalit.hajauttaja.Kuvapinta;

/**
 * Julia-fraktaali
 * @author Teemu Heikkilä
 */
public class Julia extends Fraktaali{

    public void asetaAlueet(Alue alue, Alue kuvapinta) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int laskeVari(int x, int y) {
        return Tyokalut.rgb(x, y, x);
    }

    @Override
    public void asetaAlueet(Alue alue, Kuvapinta kuvapinta) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
