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
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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
        int i = 1;
        for (int x = 0; x < this.pinta.leveys; x++) {
            
                //System.out.println("Työ edistyy..." + (i/(this.pinta.leveys*this.pinta.korkeus))*100);
            
            for (int y = 0; y < this.pinta.korkeus; y++) {
                i++;
                int vari = this.f.laskeVari(x, y);
                this.pinta.asetaPikseli(x, y, vari);
            }
        }
        /*
        File f = new File(this.alue+".png");
        try {
            ImageIO.write(this.pinta.haeKuva(), "PNG", f);
        } catch (IOException e) {
            System.out.println("failll");
        }
                */
        System.out.println("Työ valmis! "+this.alue+" "+this.pinta);
    }
}
