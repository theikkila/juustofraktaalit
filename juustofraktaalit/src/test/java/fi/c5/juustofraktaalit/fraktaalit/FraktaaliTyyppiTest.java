/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.fraktaalit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Teemu Heikkilä
 */
public class FraktaaliTyyppiTest {
   
    @Test
    public void testHaeLuokanNimi() {
        String fraktaali = "Mandelbrot";
        assertEquals("fi.c5.juustofraktaalit.fraktaalit.Mandelbrot", FraktaaliTyyppi.haeLuokanNimi(fraktaali));
    }
    
}
