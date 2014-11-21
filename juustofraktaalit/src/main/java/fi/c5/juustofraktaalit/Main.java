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
import fi.c5.juustofraktaalit.kali.Fraktaaliselain;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

/**
 *
 * @author Teemu Heikkilä
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Juustofraktaalit - pääohjelma");
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fraktaaliselain().setVisible(true);
            }
        });
    }
}
