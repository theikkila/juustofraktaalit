/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.hajauttaja;

import fi.c5.juustofraktaalit.fraktaalit.FraktaaliTyyppi;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sienikasvusto
 */
public class HajauttajaTest {
    
    @Test
    public void testHajauta() {
        Alue a = new Alue(0, 0, 1000, 1000);
        TyoMaarays t = new TyoMaarays(FraktaaliTyyppi.MANDELBROT, a, new Kuvapinta(1000, 1000), 2);
        Hajauttaja h = new Hajauttaja(t);
        h.hajauta();
        Assert.assertEquals(4, h.osat.length);
        
        TyoOsa o = new TyoOsa(FraktaaliTyyppi.MANDELBROT, new Alue(0, 0, 500, 500), new Kuvapinta(500, 500));
        System.out.println(h.osat[0]);
        Assert.assertTrue(h.osat[0].equals(o));
    }
    
}
