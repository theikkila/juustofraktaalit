/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.hajauttaja;

import fi.c5.juustofraktaalit.fraktaalit.Fraktaali;
import fi.c5.juustofraktaalit.fraktaalit.FraktaaliTyyppi;
import fi.c5.juustofraktaalit.fraktaalit.Julia;
import fi.c5.juustofraktaalit.fraktaalit.Mandelbrot;

/**
 *
 * @author Teemu Heikkilä
 */
public class TyoOsa extends Tyo{
    Fraktaali f;
    public TyoOsa(FraktaaliTyyppi fraktaali, Alue alue, Kuvapinta pinta) {
        super(fraktaali, alue, pinta);
        if (fraktaali == FraktaaliTyyppi.JULIA) {
            f = new Julia();            
        } else {
            f = new Mandelbrot();
        }
        f.asetaAlueet(alue, pinta);
    }
    
    /**
     * Hakee tallennetun kuvapinnan
     * @return kuvapinta
     */
    public Kuvapinta haePinta() {
        return this.pinta;
    }

    @Override
    public void run() {
        System.out.println("Työ käynnistetty! "+this.alue+" "+this.pinta);
        for (int x = 0; x < this.pinta.leveys; x++) {
            for (int y = 0; y < this.pinta.korkeus; y++) {
                int vari = this.f.laskeVari(x, y);
                this.pinta.asetaPikseli(x, y, vari);
            }
        }
        System.out.println("Työ valmis! "+this.alue+" "+this.pinta);
    }
}
