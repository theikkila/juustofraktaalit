/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.hajauttaja;

import fi.c5.juustofraktaalit.kali.Piirtaja;
import fi.c5.juustofraktaalit.kali.Tilanne;
import javax.swing.SwingWorker;

/**
 * Suorittaja on SwingWorker joka suorittaa varsinaisen renderöintityön ja seuraa sen etenemistä.
 * @author Teemu Heikkilä
 */

public class Suorittaja extends SwingWorker<Void, String> implements RenderointiTila{
    /**
     * Hajauttaja
     */
    private final Hajauttaja h;

    @Override
    protected void process(java.util.List<String> tilat) {
        for(String s : tilat) {
            this.t.asetaTila(s);
        }
    }
    /**
     * Tilanne-olio käyttöliittymästä
     */
    private final Tilanne t;
    /**
     * Alkuperäinen työmääräys
     */
    private final TyoMaarays tm;
    /**
     * Käyttöliittymän elementti johon piirretään
     */
    private final Piirtaja piirtaja;

    /**
     * Luo uuden suorittajan. Suorittaja suorittaa käyttöliittymästä erillään hajauttajan vaiheet
     * @param h Hajauttaja jonka kautta kaikki toiminnot suoritetaan
     * @param t Tilanne käyttöliittymään tilatietoa päivittävä olio
     * @param tm TyöMääräys tälle suoritukselle
     * @param piirtaja Käyttöliittymän objekti johon kuva piirretään
     */
    public Suorittaja (Hajauttaja h, Tilanne t, TyoMaarays tm, Piirtaja piirtaja) {
        this.h = h;
        this.t = t;
        this.tm = tm;
        this.piirtaja = piirtaja;
    }
    
    @Override
    protected Void doInBackground() throws Exception {
        publish("Hajautan työn...");
        if (!isCancelled()) {
            this.h.hajauta();    
            publish("Hajautettu. Renderöidään...");
        }
        
        if (!isCancelled()) {
            this.h.renderoi();
            this.piirtaja.asetaKuva(tm.pinta.haeKuva());
            publish("Fraktaali renderöity. Kootaan tulokset...");
        }
        if (!isCancelled()) {
            this.h.kokoa();
            publish("Fraktaali koottu. Valmis!");
        }
        return null;
    }
    @Override
    public void done() {
        this.piirtaja.asetaKuva(tm.pinta.haeKuva());
        t.asetaTila("Valmis!");
    }

    @Override
    public void osaValmis() {
        this.piirtaja.asetaKuva(tm.pinta.haeKuva());
    }
    
}
