/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.kali;

import fi.c5.juustofraktaalit.fraktaalit.Tyokalut;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 * Piirtäjä on Swing-komponentti kuva-datan esittämiseen
 *
 * @author Teemu Heikkilä
 */
public class Piirtaja extends JPanel {

    /**
     * Tallettaa piirrettävän kuvan
     */
    private Image kuva;
    /**
     * Tallettaa alkuperäisen kuvan
     */
    private Image alkuperainen;
    /**
     * Raahauksen alkupiste
     */
    private Point alku;
    /**
     * Raahauksen päätepiste
     */
    private Point loppu;

    /**
     * Piirtäjän konstruktori
     * @param kuva piirrettävä kuva
     */
    public Piirtaja(Image kuva) {
        this.kuva = kuva;
    }
    /**
     * Piirtäjän konstruktori
     */
    public Piirtaja() {
        TarkennusAdapteri hiiriadapteri = new TarkennusAdapteri();
        addMouseMotionListener(hiiriadapteri);
        addMouseListener(hiiriadapteri);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(kuva, 0, 0, null);
    }

    /**
     * Asettaa komponenttiin BufferedImagen
     *
     * @param kuva asetettava kuva
     */
    public void asetaKuva(BufferedImage kuva) {
        this.kuva = kuva;
        //this.alkuperainen = kuva.getScaledInstance(kuva.getWidth(), kuva.getHeight(), BufferedImage.SCALE_FAST);
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
     *
     * @return kuva
     */
    public Image haeKuva() {
        return this.kuva;
    }

    private void piirraNelio() {
        Graphics g = this.kuva.getGraphics();
        g.drawImage(alkuperainen, 0, 0, null);
        g.setColor(Color.CYAN);
        int x = Math.min(alku.x, loppu.x);
        int y = Math.min(alku.y, loppu.y);
        int leveys = Math.abs(alku.x - loppu.x);
        int korkeus = Math.abs(alku.y - loppu.y);

        g.drawRect(x, y, leveys, korkeus);
        g.dispose();
        repaint();
    }
    /**
     * TarkennusAdapteri on luokka jolla käsitellään tarkennusalan piirtäminen
     */
    private class TarkennusAdapteri extends MouseAdapter {

        @Override
        public void mouseDragged(MouseEvent evt) {
            loppu = evt.getPoint();
            //piirraNelio();
            Piirtaja.this.repaint();
        }

        @Override
        public void mouseReleased(MouseEvent evt) {
            loppu = evt.getPoint();
            //piirraNelio();
            alku = null;
        }

        @Override
        public void mousePressed(MouseEvent mEvt) {
            alku = mEvt.getPoint();
        }
    }
}
