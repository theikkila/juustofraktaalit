/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.hajauttaja;

import java.io.Serializable;
import java.util.Objects;

/**
 * Koordinaatti-luokka tallentaa x,y-parin
 * @author Teemu Heikkilä
 * @param <K> x ja y-koordinaattien muuttujatyyppi
 */
public class Koordinaatti<K> implements Serializable{
    /**
     * X-koordinaatti
     */
    public K x;
    /**
     * Y-koordinaatti
     */
    public K y;
    /**
     * Koordinaatti-luokan konstruktori
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     */
    public Koordinaatti (K x, K y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Palauttaa X-koordinaatin
     * @return x-koordinaatti
     */
    public K haeX() {
        return x;
    }
    /**
     * Palauttaa Y-koordinaatin
     * @return y-koordinaatti
     */
    public K haeY() {
        return y;
    }
     /**
     * Asettaa X-koordinaatin
     * @param x asetettava x-koordinaatti
     */
    public void asetaX(K x) {
        this.x = x;
    }
     /**
     * Asettaa Y-koordinaatin
     * @param y asetettava y-koordinaatti
     */
    public void asetaY(K y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.x);
        hash = 41 * hash + Objects.hashCode(this.y);
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
        final Koordinaatti<?> other = (Koordinaatti<?>) obj;
        if (!Objects.equals(this.x, other.x)) {
            return false;
        }
        if (!Objects.equals(this.y, other.y)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Koordinaatti{" + "x=" + x + ", y=" + y + '}';
    }
    
}
