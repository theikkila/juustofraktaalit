/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.hajauttaja;


import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Hajauttaa TyoMaarauksen TyoOsiin ja kerää valmistuneet työt
 * @author Teemu Heikkilä
 */
public class Hajauttaja{
    /**
    *  Alkuperäinen työmääräys joka hajautetaan
    */
    private final TyoMaarays tyo;
    /**
    * Renderöinnin tila välitetään tämän avulla
    */
    private RenderointiTila t;
    /**
     * Hajautetut työn osat
     */
    public TyoOsa[] osat;
    /**
     * Hajautettujen töiden säielista
     */
    public ArrayList<Thread> tyot;
     /**
     * Hajauttajan konstruktori
     * @param fraktaalityo on koko renderöitävän fraktaalin sisältävä tietorakenne
     */
    public Hajauttaja (TyoMaarays fraktaalityo) {
        this.tyo = fraktaalityo;
        this.tyot = new ArrayList<>();
    }

    /**
     * Hajauttaa työmääräyksen työosiin
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    public void hajauta() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        int hajautus = this.tyo.haeHajautus();
        int tyomaara = hajautus * hajautus; // Työ pilkotaan osiin ja osien lukumäärä on hajautus^2
        // Alustetaan taulukko työn osille
        this.osat = new TyoOsa[tyomaara];
        int leveys = this.tyo.pinta.leveys/hajautus;
        int korkeus = this.tyo.pinta.korkeus/hajautus;
        Kuvapinta k = this.tyo.pinta;
        for (int i = 0; i < tyomaara; i++) {
            int x = (i % hajautus);
            int y = (i / hajautus);
            Alue a = haeAlue(x, y);
            BufferedImage kuva = tyo.pinta.haeKuva().getSubimage(x*leveys, y*korkeus, k.leveys/hajautus, k.korkeus/hajautus);
            Kuvapinta kp = new Kuvapinta(kuva);
            osat[i] = new TyoOsa(this.tyo.haeTyyppi(), a, kp);
        }
    }
    private Alue haeAlue(int x, int y) {
        int hajautus = this.tyo.haeHajautus();
        double leveys = this.tyo.alue.haeLeveys()/hajautus;
        double korkeus = this.tyo.alue.haeKorkeus()/hajautus;
        double origo_x = this.tyo.alue.x1;
        double origo_y = this.tyo.alue.y1;
        double a_x = leveys*x+origo_x;
        double a_y = korkeus*y+origo_y;
        double b_x = a_x+leveys;
        double b_y = a_y+korkeus;
        return new Alue(a_x, a_y, b_x, b_y);
    }
    /**
     * Käynnistää osien renderöinnin
     */
    public void renderoi() {
        for (TyoOsa osat1 : this.osat) {
            tyot.add(new Thread(osat1));
            tyot.get(tyot.size()-1).start();
        }
        System.out.println("Odotetaan osien valmistumista!");
        int mvalmiit = 0;
        while(true) {
            boolean valmis = true;
            int valmiit = 0;
            for (Thread t : this.tyot) {
                valmis = valmis && !t.isAlive();
                if (!t.isAlive()) {
                    valmiit++;
                }
            }
            if (mvalmiit < valmiit) {
                mvalmiit = valmiit;
                if (this.t != null) {
                 t.osaValmis();   
                }
            }
            if (valmis) {
                System.out.println("Kaikki osat valmiina!");
                break;
            }
        }
    }

    /**
     * Kokoaa työn osat yhdelle kuvapinnalle
     */
    public void kokoa(){
        System.out.println("Kokoaminen valmis!");
    }
    /**
     * Tämä asettaa renderöinnin tilan seuraamiseen tarkoitetun kahvan
     * @param t 
     */
    public void asetaTilaKahva(RenderointiTila t) {
     this.t = t;   
    }
    
    private int indeksi(int x, int y) {
        return x + (y * this.tyo.haeHajautus());
    }
}