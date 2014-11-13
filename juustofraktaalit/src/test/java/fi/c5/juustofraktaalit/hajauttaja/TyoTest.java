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
 * @author sienikasvusto
 */
public class TyoTest {
    

    @Test
    public void testHaeTyyppi() {
        TyoImpl tyo = new TyoImpl(FraktaaliTyyppi.MANDELBROT, new Alue(0,0,0,0));
        assertEquals(FraktaaliTyyppi.MANDELBROT, tyo.haeTyyppi());
    }

    @Test
    public void testHashCode() {
        TyoImpl tyo = new TyoImpl(FraktaaliTyyppi.MANDELBROT, new Alue(0,0,0,0));
        TyoImpl tyo2 = new TyoImpl(FraktaaliTyyppi.MANDELBROT, new Alue(0,0,0,0));
        assertTrue(tyo.hashCode() == tyo2.hashCode());
    }

    @Test
    public void testEquals() {
        TyoImpl tyo = new TyoImpl(FraktaaliTyyppi.MANDELBROT, new Alue(0,0,0,0));
        TyoImpl tyo2 = new TyoImpl(FraktaaliTyyppi.MANDELBROT, new Alue(0,0,0,0));
        assertTrue(tyo.equals(tyo2) && tyo2.equals(tyo));
    }

    public class TyoImpl extends Tyo {

        public TyoImpl(FraktaaliTyyppi f, Alue a) {
            super(f, a);
        }
    }
    
}
