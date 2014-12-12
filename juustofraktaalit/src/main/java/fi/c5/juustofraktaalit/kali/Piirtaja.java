/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.kali;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 * Piirtäjä on Swing-komponentti kuva-datan esittämiseen
 * @author Teemu Heikkilä
 */
public class Piirtaja extends JPanel {

    private Image kuva;

    public Piirtaja(Image kuva) {
        this.kuva = kuva;
    }

    public Piirtaja() {

    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(kuva, 0, 0, null);
    }
    /**
     * Asettaa komponenttiin BufferedImagen
     * @param kuva asetettava kuva
     */
    public void asetaKuva(BufferedImage kuva) {
        this.kuva = kuva;
        Dimension koko = new Dimension(kuva.getWidth(null), kuva.getHeight(null));
        setPreferredSize(koko);
        setMinimumSize(koko);
        setMaximumSize(koko);
        setSize(koko);
        setLayout(null);
        this.repaint();
    }
    /**
     * Palauttaa pinnalle piirretyn kuvan
     * @return kuva
     */
    public Image haeKuva(){
        return this.kuva;
    }
}
