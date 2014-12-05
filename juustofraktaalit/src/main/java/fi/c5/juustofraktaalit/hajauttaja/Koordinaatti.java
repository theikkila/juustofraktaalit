/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.hajauttaja;

import java.io.Serializable;

/**
 * Koordinaatit
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
}
