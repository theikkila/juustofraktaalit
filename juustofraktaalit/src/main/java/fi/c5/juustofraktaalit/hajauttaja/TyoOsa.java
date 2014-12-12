/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.hajauttaja;

import fi.c5.juustofraktaalit.fraktaalit.Fraktaali;
import fi.c5.juustofraktaalit.fraktaalit.FraktaaliTyyppi;
/**
 * Työn osa on työn palanen ja vastaa omalta osaltaan pikseleiden renderöimisestä fraktaalialgoritmilla
 * @author Teemu Heikkilä
 */
public class TyoOsa extends Tyo{
    /**
     * Fraktaalialgoritmi
     */
    Fraktaali f;

    /**
     * Konstruktori TyoOsalle
     * @param fraktaali fraktaalialgoritmi
     * @param alue alue jolta fraktaali renderöidään
     * @param pinta kuvapinta johon renderöidyt pikselit tallennetaan
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public TyoOsa(String fraktaali, Alue alue, Kuvapinta pinta) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        super(fraktaali, alue, pinta);
        Class luokka = Class.forName(FraktaaliTyyppi.haeLuokanNimi(fraktaali));
        f = (Fraktaali) luokka.newInstance();
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
            for (int y = 0; y < this.pinta.korkeus; y++) {
                i++;
                int vari = this.f.laskeVari(x, y);
                this.pinta.asetaPikseli(x, y, vari);
            }
        }
        System.out.println("Työ valmis! "+this.alue+" "+this.pinta);
    }
}
