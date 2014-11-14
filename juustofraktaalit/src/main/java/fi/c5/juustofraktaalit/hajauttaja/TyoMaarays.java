/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.hajauttaja;

import fi.c5.juustofraktaalit.fraktaalit.FraktaaliTyyppi;

/**
 *
 * @author Teemu Heikkilä
 */
public class TyoMaarays extends Tyo{
    private int hajautus;

    public TyoMaarays(FraktaaliTyyppi fraktaali, Alue alue, Kuvapinta pinta) {
        super(fraktaali, alue, pinta);
        hajautus = 1;
    }

    /**
     *
     * @param fraktaali
     * @param alue
     * @param pinta
     * @param hajautus
     */
    public TyoMaarays(FraktaaliTyyppi fraktaali, Alue alue, Kuvapinta pinta,  int hajautus) {
        super(fraktaali, alue, pinta);
        this.hajautus = hajautus;
    }
    public void asetaAlue(double x, double y, double zoom) {
        Double zoom_x = zoom * ((double)this.pinta.leveys / (double)this.pinta.korkeus);
        Double x1 = x-zoom_x;
        Double y1 = y-zoom;
        Double x2 = x+zoom_x;
        Double y2 = y+zoom;
        Alue a = new Alue(x1, y1, x2, y2);
        this.alue = a;
    }
    
    /**
     * hajautus oliomuuttujan getteri
     * @return hajautus
     */
    public int haeHajautus(){
        return this.hajautus;
    }
    
    /**
     * hajautus oliomuuttujan setteri
     * @param hajautus Kertoo kuinka moneen osaan työ hajautetaan
     */
    public void asetaHajautus(int hajautus){
        this.hajautus = hajautus;
    }
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
