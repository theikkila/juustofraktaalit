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
    
}
