/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.kali;

import fi.c5.juustofraktaalit.hajauttaja.Koordinaatti;
import java.io.Serializable;
import java.util.Objects;

/**
 * Tallentaa nykyisen keskipisteen ja zoomin tason
 * @author Teemu Heikkilä
 */
public class SelaimenTila implements Serializable {
    public Koordinaatti<Double> keskipiste;
    public int zoom;
    public SelaimenTila(Koordinaatti<Double> keskipiste, int zoom) {
        this.keskipiste = keskipiste;
        this.zoom = zoom;
    }

    @Override
    public String toString() {
        return "SelaimenTila{" + "keskipiste=" + keskipiste + ", zoom=" + zoom + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.keskipiste);
        hash = 41 * hash + this.zoom;
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
        final SelaimenTila other = (SelaimenTila) obj;
        if (!Objects.equals(this.keskipiste, other.keskipiste)) {
            return false;
        }
        if (this.zoom != other.zoom) {
            return false;
        }
        return true;
    }
}
