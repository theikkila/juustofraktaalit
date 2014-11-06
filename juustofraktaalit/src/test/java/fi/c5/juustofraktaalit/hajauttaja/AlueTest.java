/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.hajauttaja;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Teemu Heikkilä
 */
public class AlueTest {
    
    @Test
    public void testLuoAlue() {
        Alue<Double> a = new Alue(1., 2., 10., 20.);
        Assert.assertNotNull(a);
        Assert.assertTrue(1. == a.x1);
        Assert.assertTrue(2. == a.y1);
        Assert.assertTrue(10. == a.x2);
        Assert.assertTrue(20. == 20.);
    }
    
    @Test
    public void testEquals() {
        Alue<Integer> a = new Alue(0, 0, 0, 0);
        Alue<Integer> b = new Alue(0, 0, 0, 0);
        Assert.assertTrue(a.equals(b));
        
        Alue<Integer> c = new Alue(4, 2, 2, 1);
        Alue<Integer> d = new Alue(4, 2, 2, 1);
        Assert.assertTrue(c.equals(d));
    }
    @Test
    public void testHashCode() {
        Alue<Integer> a = new Alue(4, 2, 6, 8);
        Assert.assertTrue(a.hashCode() == 37194611);
        
        Alue<Integer> b = new Alue(1, 2, 3, 4);
        Assert.assertTrue(b.hashCode() == 36568027);
        
        Alue<Double> c = new Alue(0.33, 0.44, 0.01, 42.2);
        Assert.assertTrue(c.hashCode() == 893449673);
    }
    
}
