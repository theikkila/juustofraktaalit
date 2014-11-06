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
public class Mandelbrot implements Fraktaali{
    private int[] paletti;
    
    public Mandelbrot() {
        this.paletti = new int[]{Tyokalut.rgb(0, 0, 0), Tyokalut.rgb(255, 255, 255)};
    }
    
    @Override
    public void asetaAlueet(Alue<Double> alue, Alue<Integer> kuvapinta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int laskeVari(long x, long y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Asettaa fraktaalin piirtoon tarvittavan väripaletin
     * @param paletti
     */
    public void asetaVaripaletti(int[] paletti) {
        this.paletti = paletti;
    }
    
}
