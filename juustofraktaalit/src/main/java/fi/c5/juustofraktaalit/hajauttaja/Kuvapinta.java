/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.hajauttaja;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Kuvapinta on wräpperi BufferedImagen päälle
 * @author Teemu Heikkilä
 */
public class Kuvapinta {
    /**
     * Kuvapinnan leveys pikseleinä
     */
    public int leveys;
    /**
     * Kuvapinnan korkeus pikseleinä
     */
    public int korkeus;
    /**
     * Kuvapinta
     */
    private final BufferedImage kuva;

    /**
     * Kuvapinnan konstruktori
     * @param leveys kuvapinnan leveys pikseleissä
     * @param korkeus kuvapinnan korkeus pikseleissä
     */
    public Kuvapinta(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.kuva = new BufferedImage(leveys, korkeus, BufferedImage.TYPE_INT_RGB);
    }

    /**
     * Asettaa värin pikselille x,y
     * @param x
     * @param y
     * @param vari
     */
    public void asetaPikseli(int x, int y, int vari) {
        this.kuva.setRGB(x, y, vari);
    }
    
    /**
     * Asettaa kuvapinnan osan joksikin toiseksi kuvapinnaksi
     * @param x vasemman yläkulman x-koordinaatti
     * @param y vasemman yläkulman y-koordinaatti
     * @param osa asetettava kuvapinta
     */
    public void asetaOsa(int x, int y, Kuvapinta osa){
        Graphics g = this.kuva.getGraphics();
        g.drawImage(osa.kuva, x, y, null);
    }
    
    /**
     * Palauttaa BufferedImage-kuvan
     * @return kuva
     */
    public BufferedImage haeKuva(){
        return this.kuva;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.leveys;
        hash = 89 * hash + this.korkeus;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kuvapinta other = (Kuvapinta) obj;
        if (this.leveys != other.leveys) {
            return false;
        }
        if (this.korkeus != other.korkeus) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Kuvapinta{" + "leveys=" + leveys + ", korkeus=" + korkeus + '}';
    }
    
}
