/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.fraktaalit;

/**
 * Eri fraktaalityypit tallennetaan haeFraktaaliTyypit-metodiin
 * @author Teemu Heikkilä
 */
public class FraktaaliTyyppi {
    public static String[] haeFraktaaliTyypit() {
        String[] fraktaalit = {"Mandelbrot", "Julia"}; 
        return fraktaalit;
    }

    /**
     * Muodostaa luokan koko nimen syöttämällä fraktaalin nimen
     * @param fraktaali esim "Mandelbrot"
     * @return luokan koko nimi
     */
    public static String haeLuokanNimi(String fraktaali) {
        return "fi.c5.juustofraktaalit.fraktaalit."+fraktaali;
    }
}
