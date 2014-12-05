/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.kali;

import fi.c5.juustofraktaalit.hajauttaja.Koordinaatti;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sienikasvusto
 */
public class SelaimenTilaTest {
    
    @Test
    public void testToString() {
        SelaimenTila i = new SelaimenTila(new Koordinaatti<>(1.0, 2.0), 4);
        SelaimenTila j = new SelaimenTila(new Koordinaatti<>(1.0, 2.0), 4);
        assertEquals(i.toString(), j.toString());
    }

    /**
     * Test of hashCode method, of class SelaimenTila.
     */
    @Test
    public void testHashCode() {
        SelaimenTila i = new SelaimenTila(new Koordinaatti<>(1.0, 2.0), 4);
        SelaimenTila j = new SelaimenTila(new Koordinaatti<>(1.0, 2.0), 4);
        assertEquals(i.hashCode(), j.hashCode());
    }

    /**
     * Test of equals method, of class SelaimenTila.
     */
    @Test
    public void testEquals() {
        SelaimenTila i = new SelaimenTila(new Koordinaatti<>(1.0, 2.0), 4);
        SelaimenTila j = new SelaimenTila(new Koordinaatti<>(1.0, 2.0), 4);
        assertTrue(i.equals(j));
        assertTrue(j.equals(i));
    }
    
}
