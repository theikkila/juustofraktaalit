/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.fraktaalit;

import fi.c5.juustofraktaalit.hajauttaja.Alue;
import fi.c5.juustofraktaalit.hajauttaja.Kuvapinta;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sienikasvusto
 */
public class FraktaaliTest {
    
    public FraktaaliTest() {
        Fraktaali f = new FraktaaliImpl();
        System.out.println(f.haeTyyppi());
    }

    @Test
    public void testHaeTyyppi() {
        
        Fraktaali f = new FraktaaliImpl();
        assertEquals("FraktaaliImpl", f.haeTyyppi());
    }

    public class FraktaaliImpl extends Fraktaali {

        @Override
        public void asetaAlueet(Alue alue, Kuvapinta kuvapinta) {
        }

        @Override
        public int laskeVari(int x, int y) {
            return 0;
        }
    }
    
}
