/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit;

import fi.c5.juustofraktaalit.fraktaalit.FraktaaliTyyppi;
import fi.c5.juustofraktaalit.hajauttaja.Alue;
import fi.c5.juustofraktaalit.hajauttaja.Hajauttaja;
import fi.c5.juustofraktaalit.hajauttaja.Kuvapinta;
import fi.c5.juustofraktaalit.hajauttaja.TyoMaarays;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Teemu Heikkilä
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Juustofraktaalit - pääohjelma");
        // Muista käännetty Y-koordinaatti!!!!
        TyoMaarays t = new TyoMaarays(FraktaaliTyyppi.MANDELBROT, null, new Kuvapinta(3000, 2000), 2);
        t.asetaAlue(-1.0, 0.0, 1.5);
        Hajauttaja h = new Hajauttaja(t);
        h.hajauta();
        h.renderoi();
        h.kokoa();
        
        File f = new File("img.png");
        try {
            ImageIO.write(t.pinta.haeKuva(), "PNG", f);
        } catch (IOException e) {
            System.out.println("failll");
        }
    }
}
