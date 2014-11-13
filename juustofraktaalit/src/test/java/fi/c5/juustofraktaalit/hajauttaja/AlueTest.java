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
        Alue a = new Alue(new BigDecimal(1.), new BigDecimal(2.0), new BigDecimal(10.0), new BigDecimal(20.0));
        Assert.assertNotNull(a);
        
        Assert.assertTrue(new BigDecimal(1.).equals(a.x1));
        Assert.assertTrue(new BigDecimal(2.).equals(a.y1));
        Assert.assertTrue(new BigDecimal(10.).equals(a.x2));
        Assert.assertTrue(new BigDecimal(20.).equals(a.y2));
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
        
        Alue c = new Alue(1, 2, 3, 4);
        Alue d = new Alue(new BigDecimal(1), new BigDecimal(2), new BigDecimal(3), new BigDecimal(4));
        Assert.assertTrue(c.hashCode() == d.hashCode());
        
        Alue e = new Alue(0.33, 0.44, 0.01, 42.2);
        Alue f = new Alue(0.33, 0.44, 0.01, 42.2);
        Assert.assertTrue(e.hashCode() == f.hashCode());
    }
    
}
