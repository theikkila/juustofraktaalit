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

/**
 *
 * @author Teemu Heikkilä
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Juustofraktaalit - pääohjelma");
        TyoMaarays t = new TyoMaarays(FraktaaliTyyppi.MANDELBROT, new Alue(0, 0, 1, 1), new Kuvapinta(800, 800), 2);
        Hajauttaja h = new Hajauttaja(t);
        h.hajauta();
        h.renderoi();
        
    }
}
