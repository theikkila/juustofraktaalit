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
public class Mandelbrot extends Fraktaali{
    private int[] paletti;
    private Alue alue;
    private Kuvapinta kuvapinta;
    public Mandelbrot() {
        this.paletti = new int[]{Tyokalut.rgb(0, 0, 0), Tyokalut.rgb(255, 255, 255)};
    }
    
    public void asetaAlueet(Alue alue, Alue kuvapinta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int laskeVari(int x, int y) {
        return Tyokalut.rgb(x, y, 0);
    }

    /**
     * Palauttaa fraktaalin tyypin
     * @return fraktaalin tyyppi
     */
    @Override
    public FraktaaliTyyppi haeTyyppi() {
        return FraktaaliTyyppi.MANDELBROT;
    }
    /**
     * Asettaa fraktaalin piirtoon tarvittavan väripaletin
     * @param paletti
     */
    public void asetaVaripaletti(int[] paletti) {
        this.paletti = paletti;
    }

    @Override
    public void asetaAlueet(Alue alue, Kuvapinta kuvapinta) {
        this.alue = alue;
        this.kuvapinta = kuvapinta;
    }
    
}
