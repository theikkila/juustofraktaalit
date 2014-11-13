/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.hajauttaja;

import java.math.BigDecimal;

/**
 * Hajauttaa TyoMaarauksen TyoOsiin ja kerää valmistuneet työt
 * @author Teemu Heikkilä
 */
public class Hajauttaja {
    private final TyoMaarays tyo;
    public TyoOsa[] osat;
    public Hajauttaja (TyoMaarays fraktaalityo) {
        this.tyo = fraktaalityo;
    }

    /**
     * Hajauttaa työmääräyksen työosiin
     */
    public void hajauta() {
        int hajautus = this.tyo.haeHajautus();
        int tyomaara = hajautus * hajautus; // Työ pilkotaan osiin ja osien lukumäärä on hajautus^2
        // Alustetaan taulukko työn osille
        this.osat = new TyoOsa[tyomaara];
        BigDecimal leveys = this.tyo.alue.haeLeveys().divide(new BigDecimal(hajautus));
        BigDecimal korkeus = this.tyo.alue.haeKorkeus().divide(new BigDecimal(hajautus));
        for (int i = 0; i < tyomaara; i++) {
            int x = i % hajautus;
            int y = i / hajautus;
            BigDecimal a_x = leveys.multiply(new BigDecimal(x));
            BigDecimal a_y = korkeus.multiply(new BigDecimal(y));
            BigDecimal b_x = a_x.add(leveys);
            BigDecimal b_y = a_y.add(korkeus);
            osat[i] = new TyoOsa(this.tyo.haeTyyppi(), new Alue(a_x, a_y, b_x, b_y));
        }
 
    }
    private int indeksi(int x, int y) {
        return x + (y * this.tyo.haeHajautus());
    }
}