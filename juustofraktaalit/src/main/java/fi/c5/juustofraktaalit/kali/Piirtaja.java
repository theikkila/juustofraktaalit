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
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Teemu Heikkilä
 */
public class Piirtaja extends JPanel {

    private Image kuva;

    public Piirtaja(Image kuva) {
        this.kuva = kuva;
    }

    public Piirtaja() {
        /*
         try {                
         kuva = ImageIO.read(new File("fraktaali2.png"));
         Dimension koko = new Dimension(kuva.getWidth(null), kuva.getHeight(null));
         setPreferredSize(koko);
         setMinimumSize(koko);
         setMaximumSize(koko);
         setSize(koko);
         setLayout(null);
         } catch (IOException ex) {
         // handle exception...
         }
         */
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(kuva, 0, 0, null);
    }

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
}
