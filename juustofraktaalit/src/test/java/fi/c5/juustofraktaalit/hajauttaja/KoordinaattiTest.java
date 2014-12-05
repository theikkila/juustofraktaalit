/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.hajauttaja;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Teemu Heikkilä
 */
public class KoordinaattiTest {
    
    @Test
    public void testHaeX() {
        Koordinaatti<Integer> k = new Koordinaatti<>(5, 7);
        assertEquals(5, k.haeX().intValue());
        assertEquals(Integer.valueOf(5), k.haeX());
        Koordinaatti<Double> i = new Koordinaatti<>(1.1, 1.2);
        assertEquals(1.1, i.haeX(), 0.0000000001);
    }
    @Test
    public void testHaeXNolla() {
        Koordinaatti<Integer> k = new Koordinaatti<>(0, 0);
        assertEquals(0, k.haeX().intValue());
        assertEquals(Integer.valueOf(0), k.haeX());
        Koordinaatti<Double> i = new Koordinaatti<>(0.0, 0.0);
        assertEquals(0.0, i.haeX(), 0.0000000001);
    }
    @Test
    public void testHaeXNegatiivinen() {
        Koordinaatti<Integer> k = new Koordinaatti<>(-5, -7);
        assertEquals(-5, k.haeX().intValue());
        assertEquals(Integer.valueOf(-5), k.haeX());
        Koordinaatti<Double> i = new Koordinaatti<>(-1.1, -1.2);
        assertEquals(-1.1, i.haeX(), 0.0000000001);
    }
    @Test
    public void testHaeY() {
        Koordinaatti<Integer> k = new Koordinaatti<>(5, 7);
        assertEquals(7, k.haeY().intValue());
        assertEquals(Integer.valueOf(7), k.haeY());
        Koordinaatti<Double> i = new Koordinaatti<>(1.1, 1.2);
        assertEquals(1.2, i.haeY(), 0.0000000001);
    }
    @Test
    public void testHaeYNolla() {
        Koordinaatti<Integer> k = new Koordinaatti<>(0, 0);
        assertEquals(0, k.haeX().intValue());
        assertEquals(Integer.valueOf(0), k.haeY());
        Koordinaatti<Double> i = new Koordinaatti<>(0.0, 0.0);
        assertEquals(0.0, i.haeY(), 0.0000000001);
    }
    @Test
    public void testHaeYNegatiivinen() {
        Koordinaatti<Integer> k = new Koordinaatti<>(-5, -7);
        assertEquals(-7, k.haeY().intValue());
        assertEquals(Integer.valueOf(-7), k.haeY());
        Koordinaatti<Double> i = new Koordinaatti<>(-1.1, -1.2);
        assertEquals(-1.2, i.haeY(), 0.0000000001);
    }

    @Test
    public void testAsetaX() {
        Koordinaatti<Integer> k = new Koordinaatti<>(5, 7);
        assertEquals(5, k.haeX().intValue());
        assertEquals(Integer.valueOf(5), k.haeX());
        k.asetaX(6);
        assertEquals(6, k.haeX().intValue());
        assertEquals(Integer.valueOf(6), k.haeX());
        Koordinaatti<Double> i = new Koordinaatti<>(1.1, 1.2);
        assertEquals(1.1, i.haeX(), 0.0000000001);
        i.asetaX(3.14);
        assertEquals(3.14, i.haeX(), 0.0000000001);
    }
    @Test
    public void testAsetaXNolla() {
        Koordinaatti<Integer> k = new Koordinaatti<>(1, 1);
        assertEquals(1, k.haeX().intValue());
        assertEquals(Integer.valueOf(1), k.haeX());
        k.asetaX(0);
        assertEquals(0, k.haeX().intValue());
        assertEquals(Integer.valueOf(0), k.haeX());
        Koordinaatti<Double> i = new Koordinaatti<>(1.1, 1.1);
        assertEquals(1.1, i.haeX(), 0.0000000001);
        i.asetaX(0.0);
        assertEquals(0.0, i.haeX(), 0.0000000001);
    }
    @Test
    public void testAsetaXNegatiivinen() {
        Koordinaatti<Integer> k = new Koordinaatti<>(5, 7);
        assertEquals(5, k.haeX().intValue());
        assertEquals(Integer.valueOf(5), k.haeX());
        k.asetaX(-5);
        assertEquals(-5, k.haeX().intValue());
        assertEquals(Integer.valueOf(-5), k.haeX());
        Koordinaatti<Double> i = new Koordinaatti<>(1.1, 1.2);
        assertEquals(1.1, i.haeX(), 0.0000000001);
        i.asetaX(-1.1);
        assertEquals(-1.1, i.haeX(), 0.0000000001);
    }

    @Test
    public void testAsetaY() {
        Koordinaatti<Integer> k = new Koordinaatti<>(5, 7);
        assertEquals(7, k.haeY().intValue());
        assertEquals(Integer.valueOf(7), k.haeY());
        k.asetaY(6);
        assertEquals(6, k.haeY().intValue());
        assertEquals(Integer.valueOf(6), k.haeY());
        Koordinaatti<Double> i = new Koordinaatti<>(1.1, 1.2);
        assertEquals(1.2, i.haeY(), 0.0000000001);
        i.asetaY(3.14);
        assertEquals(3.14, i.haeY(), 0.0000000001);
    }
    @Test
    public void testAsetaYNolla() {
        Koordinaatti<Integer> k = new Koordinaatti<>(1, 1);
        assertEquals(1, k.haeY().intValue());
        assertEquals(Integer.valueOf(1), k.haeY());
        k.asetaY(0);
        assertEquals(0, k.haeY().intValue());
        assertEquals(Integer.valueOf(0), k.haeY());
        Koordinaatti<Double> i = new Koordinaatti<>(1.1, 1.1);
        assertEquals(1.1, i.haeY(), 0.0000000001);
        i.asetaY(0.0);
        assertEquals(0.0, i.haeY(), 0.0000000001);
    }
    @Test
    public void testAsetaYNegatiivinen() {
        Koordinaatti<Integer> k = new Koordinaatti<>(5, 7);
        assertEquals(7, k.haeY().intValue());
        assertEquals(Integer.valueOf(7), k.haeY());
        k.asetaY(-7);
        assertEquals(-7, k.haeY().intValue());
        assertEquals(Integer.valueOf(-7), k.haeY());
        Koordinaatti<Double> i = new Koordinaatti<>(1.1, 1.2);
        assertEquals(1.2, i.haeY(), 0.0000000001);
        i.asetaY(-1.2);
        assertEquals(-1.2, i.haeY(), 0.0000000001);
    }

    @Test
    public void testHashCode() {
        Koordinaatti<Integer> a = new Koordinaatti<>(10, 10);
        Koordinaatti<Integer> b = new Koordinaatti<>(10, 10);
        assertEquals(a.hashCode(), b.hashCode());
        assertEquals(b.hashCode(), a.hashCode());
    }
    
    @Test
    public void testEquals() {
        Koordinaatti<Integer> a = new Koordinaatti<>(10, 10);
        Koordinaatti<Integer> b = new Koordinaatti<>(10, 10);
        assertTrue(a.equals(b));
        assertTrue(b.equals(a));
    }
    @Test
    public void testToString() {
        Koordinaatti<Integer> a = new Koordinaatti<>(10, 10);
        Koordinaatti<Integer> b = new Koordinaatti<>(10, 10);
        assertEquals(a.toString(), b.toString());
    }
    
}
