/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.kali;

import fi.c5.juustofraktaalit.hajauttaja.Koordinaatti;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Teemu Heikkilä
 */
public class TiedostokasittelijaTest {
    public TiedostokasittelijaTest () throws IOException {
        File t = new File("test.ftt");
        SelaimenTila tila = new SelaimenTila(new Koordinaatti<>(4.0, 5.0), 6);
        Tiedostokasittelija.tallennaTilaTiedostoon(t, tila);
    }
    @Test
    public void testAvaaTilaTiedostosta() throws Exception {
        File t = new File("test.ftt");
        SelaimenTila tila = new SelaimenTila(new Koordinaatti<>(4.0, 5.0), 6);
        SelaimenTila ladattu = Tiedostokasittelija.avaaTilaTiedostosta(t);
        assertEquals(tila, ladattu);
    }
    @Test
    public void testTallennaTilaTiedostoon() throws Exception {
        File t = new File("test2.ftt");
        SelaimenTila stila = new SelaimenTila(new Koordinaatti<>(7.0, 8.0), 9);
        Tiedostokasittelija.tallennaTilaTiedostoon(t, stila);
    }
}
