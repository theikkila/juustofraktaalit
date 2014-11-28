/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.fraktaalit;

import fi.c5.juustofraktaalit.hajauttaja.Alue;
import fi.c5.juustofraktaalit.hajauttaja.Kuvapinta;

/**
 * Mandelbrot-fraktaali
 * @author Teemu Heikkilä
 */
public class Mandelbrot extends Fraktaali {

    private int[] paletti;
    private Alue alue;
    private Kuvapinta kuvapinta;

    public Mandelbrot() {
        this.paletti = new int[370];
        for (int i = 0; i < 370; i++) {
            paletti[i] = Tyokalut.wavelength_to_rgb(i+380, 0.80);
        }
    }
    @Override
    public int laskeVari(int px, int py) {
        Double x0 = Tyokalut.map(new Double(px), 0.0, new Double(this.kuvapinta.leveys), this.alue.x1, this.alue.x2);
        Double y0 = Tyokalut.map(new Double(py), 0.0, new Double(this.kuvapinta.korkeus), this.alue.y1, this.alue.y2);
        Double x = 0.0;
        Double y = 0.0;
        int iteration = 0;
        int max_iterations = 500;
        // x * x + y * y < 2 * 2 && iteration < max_iterations
        while(x*x+y*y < 4 && iteration < max_iterations) {
            // xtemp = x * x - y * y + x0;
            Double xtemp = x*x - y*y + x0;
            // y = 2 * x * y + y0;
            y = 2*x*y+y0;
            // x = xtemp;
            x = xtemp;
            iteration++;
        }
        /*

        
        */
        return this.paletti[(int) Math.floor(Tyokalut.map((double) iteration, 0.0, (double) max_iterations, 0.0, this.paletti.length-1))];
    }

    /**
     * Asettaa fraktaalin piirtoon tarvittavan väripaletin
     *
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
