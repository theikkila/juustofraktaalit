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
 * @param <K>
 */
public class Koordinaatti<K> implements Serializable{
    public K x;
    public K y;
    public Koordinaatti (K x, K y) {
        this.x = x;
        this.y = y;
    }
    public K haeX() {
        return x;
    }
    public K haeY() {
        return y;
    }
    public void asetaX(K x) {
        this.x = x;
    }
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
