/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.kali;

import fi.c5.juustofraktaalit.hajauttaja.Koordinaatti;
import java.io.Serializable;

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
}
