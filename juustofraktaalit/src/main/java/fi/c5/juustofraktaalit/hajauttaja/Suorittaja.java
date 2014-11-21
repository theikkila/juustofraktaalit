/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.hajauttaja;

import fi.c5.juustofraktaalit.kali.Piirtaja;
import fi.c5.juustofraktaalit.kali.Tilanne;
import java.awt.List;
import javax.swing.SwingWorker;

/**
 * Suorittaja on SwingWorker joka suorittaa varsinaisen renderöintityön ja seuraa sen etenemistä.
 * @author Teemu Heikkilä
 */

public class Suorittaja extends SwingWorker<Void, String>{
    private Hajauttaja h;

    @Override
    protected void process(java.util.List<String> tilat) {
        for(String s : tilat) {
            this.t.asetaTila(s);
        }
    }
    private Tilanne t;
    private TyoMaarays tm;
    private Piirtaja piirtaja;
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
    
}
