/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.hajauttaja;

import java.math.BigDecimal;

import org.junit.Assert;

import org.junit.Test;

/**
 *
 * @author Teemu Heikkilä
 */
public class AlueTest {
    
    @Test
    public void testLuoAlue() {
        Alue a = new Alue(1., 2.0, 10.0, 20.0);
        Assert.assertNotNull(a);
        
        Assert.assertTrue(1. == a.x1);
        Assert.assertTrue(2. == a.y1);
        Assert.assertTrue(10. == a.x2);
        Assert.assertTrue(20. == a.y2);
    }
    
    @Test
    public void testEquals() {
        Alue a = new Alue(0., 0., 0., 0.);
        Alue b = new Alue(0., 0., 0., 0.);
        Assert.assertTrue(a.equals(b) && b.equals(a));
        
        Alue c = new Alue(4., 2., 2., 1.);
        Alue d = new Alue(4., 2., 2., 1.);
        Assert.assertTrue(c.equals(d) && d.equals(c));
    }
    @Test
    public void testHashCode() {
        Alue a = new Alue(4, 2, 6, 8);
        Alue b = new Alue(4., 2.0, 6.0, 8.0);
        Assert.assertTrue(a.hashCode() == b.hashCode());
        
        Alue e = new Alue(0.33, 0.44, 0.01, 42.2);
        Alue f = new Alue(0.33, 0.44, 0.01, 42.2);
        Assert.assertTrue(e.hashCode() == f.hashCode());
    }
    @Test
    public void testhaeLeveys() {
        Alue a = new Alue(0, 0, 6, 6);
        Assert.assertTrue(a.haeLeveys() == 6.0);
        
        Alue b = new Alue(0, 0, 6, 8);
        Assert.assertTrue(b.haeLeveys() == 6.0);
        
        Alue c = new Alue(-3, 0, 3, 6);
        Assert.assertTrue(c.haeLeveys() == 6.0);
        
        Alue d = new Alue(-1., 0., 4., 6.);
        Assert.assertTrue(d.haeLeveys() == 5.0);
        
    }
    
    @Test
    public void testhaeKorkeus() {
        Alue a = new Alue(0, 0, 6, 6);
        Assert.assertTrue(a.haeKorkeus() == 6.0);
        
        Alue b = new Alue(0, 0, 4, 8);
        Assert.assertTrue(b.haeKorkeus() == 8.0);
        
        Alue c = new Alue(-3, -3, 3, 3);
        Assert.assertTrue(c.haeLeveys() == 6.0);
        
        Alue d = new Alue(-1., -1., 4., 4.);
        Assert.assertTrue(d.haeLeveys() == 5.0);
        
    }
    
}
