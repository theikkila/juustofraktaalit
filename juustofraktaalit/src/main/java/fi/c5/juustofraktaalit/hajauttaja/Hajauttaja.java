/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.hajauttaja;


import java.util.ArrayList;

/**
 * Hajauttaa TyoMaarauksen TyoOsiin ja kerää valmistuneet työt
 * @author Teemu Heikkilä
 */
public class Hajauttaja{
    private final TyoMaarays tyo;
    public TyoOsa[] osat;
    public ArrayList<Thread> tyot;
    public Hajauttaja (TyoMaarays fraktaalityo) {
        this.tyo = fraktaalityo;
        this.tyot = new ArrayList<>();
    }

    /**
     * Hajauttaa työmääräyksen työosiin
     */
    public void hajauta() {
        int hajautus = this.tyo.haeHajautus();
        int tyomaara = hajautus * hajautus; // Työ pilkotaan osiin ja osien lukumäärä on hajautus^2
        // Alustetaan taulukko työn osille
        this.osat = new TyoOsa[tyomaara];
        Double origo_x = this.tyo.alue.x1;
        Double origo_y = this.tyo.alue.y1;
        Double leveys = this.tyo.alue.haeLeveys()/hajautus;
        Double korkeus = this.tyo.alue.haeKorkeus()/hajautus;
        Kuvapinta k = this.tyo.pinta;
        for (int i = 0; i < tyomaara; i++) {
            int x = (i % hajautus);
            int y = (i / hajautus);
            Double a_x = leveys*x+origo_x;
            Double a_y = korkeus*y+origo_y;
                        System.out.println("("+a_x+","+a_y+")");
            Double b_x = a_x+leveys;
            Double b_y = a_y+korkeus;
            osat[i] = new TyoOsa(this.tyo.haeTyyppi(), new Alue(a_x, a_y, b_x, b_y), new Kuvapinta(k.leveys/hajautus, k.korkeus/hajautus));
        }
    }
    
    public void renderoi() {
        for (TyoOsa osat1 : this.osat) {
            tyot.add(new Thread(osat1));
            tyot.get(tyot.size()-1).start();
        }
        System.out.println("Odotetaan osien valmistumista!");
        while(true) {
            boolean valmis = true;
            for (Thread t : this.tyot) {
                valmis = valmis && !t.isAlive();
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
        System.out.println("Kootaan kuvaa...");
        int hajautus = this.tyo.haeHajautus();
        int leveys = this.tyo.pinta.leveys/hajautus;
        int korkeus = this.tyo.pinta.korkeus/hajautus;
        
        for (int i = 0; i < this.osat.length; i++) {
            System.out.println("Kootaan osaa " + i);
            int x = (i % hajautus) * leveys;
            int y = (i / hajautus) * korkeus;
            System.out.println(x+":"+y);
            this.tyo.pinta.asetaOsa(x, y, this.osat[i].haePinta());
        }
        System.out.println("Kokoaminen valmis!");
    }
    
    private int indeksi(int x, int y) {
        return x + (y * this.tyo.haeHajautus());
    }
}