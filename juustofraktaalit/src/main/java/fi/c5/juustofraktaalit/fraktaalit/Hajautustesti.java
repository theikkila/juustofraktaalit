/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.fraktaalit;

import fi.c5.juustofraktaalit.hajauttaja.Alue;
import fi.c5.juustofraktaalit.hajauttaja.Kuvapinta;
import java.util.Random;

/**
 * Hajautustesti
 * Visualisoi hajautuksen
 * @author Teemu Heikkilä
 */
public class Hajautustesti extends Fraktaali{
    private int vari = 0;
    public void asetaAlueet(Alue alue, Alue kuvapinta) {
        throw new UnsupportedOperationException("Tämä toiminto ei ole tuettu tässä algoritmissa."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int laskeVari(int x, int y) {
        return vari;
    }

    @Override
    public void asetaAlueet(Alue alue, Kuvapinta kuvapinta) {
        // Generoidaan kaunis väri :)
        Random r = new Random();
        vari = Tyokalut.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }
    
}
