/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.fraktaalit;

import fi.c5.juustofraktaalit.hajauttaja.Koordinaatti;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Teemu Heikkilä
 */
public class TyokalutTest {
    

    /**
     * Tyokalut-luokan staattisen rgb-metodin testi
     */
    @Test
    public void testRgb() {
        int musta = Tyokalut.rgb(0, 0, 0);
        assertEquals(0, musta);
        
        int valkoinen = Tyokalut.rgb(255, 255, 255);
        assertEquals(16777215, valkoinen);
    }
    @Test
    public void testRgbMuuVari() {
        int muuVari = Tyokalut.rgb(50, 100, 200);
        assertEquals(3302600, muuVari);
    }
    @Test
    public void testRgbEiLukualueella() {
        int edelleenMusta = Tyokalut.rgb(-23, -424, 0);
        assertEquals(0, edelleenMusta);
        
        int edelleenValkoinen = Tyokalut.rgb(252395, 251235, 2132355);
        assertEquals(16777215, edelleenValkoinen);
    }
    @Test
    public void testAallonpituusMuunnos() {
        assertEquals(16760320, Tyokalut.aallonpituus_rgb(600.0, 0.8));
    }
    @Test
    public void testAallonpituusMuunnosNolla() {
        assertEquals(0, Tyokalut.aallonpituus_rgb(0.0, 0.8));
    }
    @Test
    public void testZoom() {
        assertEquals(2.0, Tyokalut.laskeZoom(0), 0.00000001);
        assertEquals(2.0, Tyokalut.laskeZoom(1), 0.00000001);
        assertEquals(2.0, Tyokalut.laskeZoom(4), 0.00000001);
    }
    @Test
    public void testZoomNegatiivinen() {
        assertEquals(0.125, Tyokalut.laskeZoom(-2), 0.00000001);
        assertEquals(0.037037037037037035, Tyokalut.laskeZoom(-3), 0.000000001);
    }
    @Test
    public void testKeskipiste() {
        Koordinaatti<Double> pikseli = new Koordinaatti<>(50.0, 50.0);
        Koordinaatti<Double> kp = new Koordinaatti<>(0.5, 0.5);
        Koordinaatti<Double> uusikp = Tyokalut.laskeKeskipiste(pikseli, kp, 0.1, 100, 100);
        assertEquals(uusikp, new Koordinaatti<Double>(0.5, 0.5));
    }
}
