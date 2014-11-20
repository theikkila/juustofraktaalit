/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.hajauttaja;

import fi.c5.juustofraktaalit.fraktaalit.FraktaaliTyyppi;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Teemu Heikkilä
 */
public class TyoTest {

    @Test
    public void testHaeTyyppi() {
        TyoImpl tyo = new TyoImpl("Mandelbrot", new Alue(0, 0, 0, 0), new Kuvapinta(100, 100));
        assertEquals("Mandelbrot", tyo.haeTyyppi());
    }

    @Test
    public void testHashCode() {
        TyoImpl tyo = new TyoImpl("Mandelbrot", new Alue(0, 0, 0, 0), new Kuvapinta(100, 100));
        TyoImpl tyo2 = new TyoImpl("Mandelbrot", new Alue(0, 0, 0, 0), new Kuvapinta(100, 100));
        assertTrue(tyo.hashCode() == tyo2.hashCode());
    }

    @Test
    public void testEquals() {
        TyoImpl tyo = new TyoImpl("Mandelbrot", new Alue(0, 0, 0, 0), new Kuvapinta(100, 100));
        TyoImpl tyo2 = new TyoImpl("Mandelbrot", new Alue(0, 0, 0, 0), new Kuvapinta(100, 100));
        assertTrue(tyo.equals(tyo2) && tyo2.equals(tyo));
    }

    public class TyoImpl extends Tyo {

        public TyoImpl(String f, Alue a, Kuvapinta p) {
            super(f, a, p);
        }

        @Override
        public void run() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
