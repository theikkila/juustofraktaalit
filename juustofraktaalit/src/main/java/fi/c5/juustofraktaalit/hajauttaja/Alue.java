/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.hajauttaja;

import java.util.Objects;

/**
 *
 * @author Teemu Heikkilä
 * @param <T> Alueen koordinaattien tyyppi
 */
public class Alue<T> {
    public T x1;
    public T x2;
    public T y1;
    public T y2;

    /**
     *
     * @param x1 vasemman yläkulman x-koordinaatti
     * @param y1 vasemman yläkulman y-koordinaatti
     * @param x2 oikean alakulman x-koordinaatti
     * @param y2 oikean alakulman y-koordinaatti
     */
    public Alue(T x1, T y1, T x2, T y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.x1);
        hash = 59 * hash + Objects.hashCode(this.x2);
        hash = 59 * hash + Objects.hashCode(this.y1);
        hash = 59 * hash + Objects.hashCode(this.y2);
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
        final Alue<?> other = (Alue<?>) obj;
        if (!Objects.equals(this.x1, other.x1)) {
            return false;
        }
        if (!Objects.equals(this.x2, other.x2)) {
            return false;
        }
        if (!Objects.equals(this.y1, other.y1)) {
            return false;
        }
        if (!Objects.equals(this.y2, other.y2)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return new String("Alue: ("+this.x1+", "+this.y1+") - ("+this.x2+", "+this.y2+")");
    }
}
