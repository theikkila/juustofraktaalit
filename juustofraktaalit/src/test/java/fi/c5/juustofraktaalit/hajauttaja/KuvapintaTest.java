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
public class KuvapintaTest {

    @Test
    public void testKuvapinta() {
        Kuvapinta k = new Kuvapinta(10, 10);
        assertTrue(k.leveys == 10);
        assertTrue(k.leveys == 10);
    }

    @Test
    public void testHashCode() {
        assertEquals(new Kuvapinta(100, 100).hashCode(), new Kuvapinta(100, 100).hashCode());
    }


    @Test
    public void testEquals() {
        Kuvapinta a = new Kuvapinta(100, 100);
        Kuvapinta b = new Kuvapinta(100, 100);
        assertTrue(a.equals(b) && b.equals(a));
    }

    @Test
    public void testToString() {
        Kuvapinta k = new Kuvapinta(100, 100);
        String teksti = k.toString();
        assertEquals("Kuvapinta{leveys=100, korkeus=100}", teksti);
    }
    
}
