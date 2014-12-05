/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.fraktaalit;

import fi.c5.juustofraktaalit.hajauttaja.Koordinaatti;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Työkalut on kokoelma staattisia työkalumetodeja
 *
 * @author Teemu Heikkilä
 */
public class Tyokalut {

    /**
     * Luo kokonaislukumuotoisena arvon värille
     *
     * @param r punaisen komponentin määrä 0-255
     * @param g vihreän komponentin määrä 0-255
     * @param b sinisen komponentin määrä 0-255
     * @return väri kokonaislukuna
     */
    public static int rgb(int r, int g, int b) {
        r = Math.min(255, Math.max(r, 0));
        g = Math.min(255, Math.max(g, 0));
        b = Math.min(255, Math.max(b, 0));
        return (r << 16) | (g << 8) | b;
    }

    /**
     * Siirtää luvun x asteikolta in_min-in_max asteikolle out_min-out_max
     *
     * @param x Mäpättävä luku
     * @param in_min Mäpättävän lukuavaruuden pienin arvo
     * @param in_max Mäpättävän lukuavaruuden suurin arvo
     * @param out_min Ulostulevan lukuavaruuden pienin arvo
     * @param out_max Ulostulevan lukuavaruuden suurin arvo
     * @return
     */
    public static double map(double x, double in_min, double in_max, double out_min, double out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }

    /**
     * Laskee pikseli-koordinaatista zoomatun koordinaatin
     *
     * @param pp Pikselikoordinaatti
     * @param keskipiste Edellinen keskipiste
     * @param zoom Zoom
     * @param leveys Pikselitason leveys
     * @param korkeus Pikselitason korkeus
     * @return uusi keskipiste
     */
    public static Koordinaatti<Double> laskeKeskipiste(Koordinaatti<Double> pp, Koordinaatti<Double> keskipiste, double zoom, double leveys, double korkeus) {
        double suhdeX = pp.x / leveys;
        double suhdeY = pp.y / korkeus;
        keskipiste.x = Tyokalut.map(suhdeX, 0, 1, keskipiste.x - zoom, keskipiste.x + zoom);
        keskipiste.y = Tyokalut.map(suhdeY, 0, 1, keskipiste.y - zoom, keskipiste.y + zoom);
        return keskipiste;
    }

    /**
     * Laskee tasosta zoom-arvon joka on renderöitävän alueen leveys
     *
     * @param taso Zoom-taso
     * @return alueen leveys
     */
    public static double laskeZoom(int taso) {
        taso = Math.min(taso, 0);
        double zoom = 1.0 / Math.abs(taso * taso * taso);
        zoom = Math.min(zoom, 2.0);
        return zoom;
    }

    /**
     * Muuntaa aallonpituuden nanometreissä RGB-väriksi
     *
     * @param aallonpituus aallonpituus
     * @param gamma gamma-arvo
     * @return väri kokonaislukuun pakattuna
     */
    public static int aallonpituus_rgb(double aallonpituus, double gamma) {
        double R, G, B, lisays;
        if (aallonpituus >= 380 && aallonpituus <= 440) {
            lisays = 0.3 + 0.7 * (aallonpituus - 380) / (440 - 380);
            R = Math.pow((-(aallonpituus - 440) / (440 - 380)) * lisays, gamma);
            G = 0.0;
            B = Math.pow(1.0 * lisays, gamma);
        } else if (aallonpituus >= 440 && aallonpituus <= 490) {
            R = 0.0;
            G = Math.pow((aallonpituus - 440) / (490 - 440), gamma);
            B = 1.0;
        } else if (aallonpituus >= 490 && aallonpituus <= 510) {
            R = 0.0;
            G = 1.0;
            B = Math.pow(-(aallonpituus - 510) / (510 - 490), gamma);
        } else if (aallonpituus >= 510 && aallonpituus <= 580) {
            R = Math.pow((aallonpituus - 510) / (580 - 510), gamma);
            G = 1.0;
            B = 0.0;
        } else if (aallonpituus >= 580 && aallonpituus <= 645) {
            R = 1.0;
            G = Math.pow(-(aallonpituus - 645) / (645 - 580), gamma);
            B = 0.0;
        } else if (aallonpituus >= 645 && aallonpituus <= 750) {
            lisays = 0.3 + 0.7 * (750 - aallonpituus) / (750 - 645);
            R = Math.pow((1.0 * lisays), gamma);
            G = 0.0;
            B = 0.0;
        } else {
            R = 0.0;
            G = 0.0;
            B = 0.0;
        }
        R *= 255;
        G *= 255;
        B *= 255;
        return rgb((int) R, (int) G, (int) B);
    }
}
