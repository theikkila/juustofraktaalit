/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.hajauttaja;

import java.util.Objects;

/**
 * Alue on neliskulmainen alue johon on tallennettu vasemman yläkulman ja oikean alakulman koordinaatit
 * @author Teemu Heikkilä
 */
public class Alue {

    /**
     * vasemman yläkulman x-koordinaatti
     */
    public Double x1;

    /**
     * oikean alakulman x-koordinaatti
     */
    public Double x2;

    /**
     * vasemman yläkulman y-koordinaatti
     */
    public Double y1;

    /**
     * oikean alakulman y-koordinaatti
     */
    public Double y2;

    /**
     * Alueen konstruktori, ottaa parametreinä alueen vasemman yläkulman ja oikean alakulman koordinaatit
     * @param x1 vasemman yläkulman x-koordinaatti
     * @param y1 vasemman yläkulman y-koordinaatti
     * @param x2 oikean alakulman x-koordinaatti
     * @param y2 oikean alakulman y-koordinaatti
     */
    public Alue(Double x1, Double y1, Double x2, Double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    
    /**
     * Alueen int-konstruktori, ottaa parametreinään samat kuin Double-konstruktori mutta doubleina.
     * @param x1 vas. yk. x
     * @param y1 vas. yk. y
     * @param x2 oik. ak. x
     * @param y2 oik. ak. y
     */
    public Alue(int x1, int y1, int x2, int y2) {
        this.x1 = new Double(x1);
        this.y1 = new Double(y1);
        this.x2 = new Double(x2);
        this.y2 = new Double(y2);
    }
    
    /**
     * Konstruktori joka alustaa alueen alkamaan origosta
     * @param leveys alueen leveys
     * @param korkeus alueen korkeus
     */
    public Alue(Double leveys, Double korkeus) {
        this.x1 = new Double(0);
        this.y1 = new Double(0);
        this.x2 = leveys;
        this.y2 = korkeus;
    }
     /**
     * Konstruktori joka alustaa alueen alkamaan origosta (int)
     * @param leveys alueen leveys
     * @param korkeus alueen korkeus
     */
    public Alue(int leveys, int korkeus) {
        this.x1 = new Double(0);
        this.y1 = new Double(0);
        this.x2 = new Double(leveys);
        this.y2 = new Double(korkeus);
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
        final Alue other = (Alue) obj;
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

    /**
     * Hae aleen leveys
     * @return alueen leveys
     */
    public Double haeLeveys() {
        return Math.abs(this.x2 - this.x1);
    }
    
    /**
     * Hae alueen korkeus
     * @return alueen korkeus
     */
    public Double haeKorkeus() {
        return Math.abs(this.y2 - this.y1);
    }
    
    @Override
    public String toString() {
        return "Alue: ("+this.x1+", "+this.y1+") - ("+this.x2+", "+this.y2+")";
    }
}
