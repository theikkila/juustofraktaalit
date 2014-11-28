/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.fraktaalit;

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

    public static BigDecimal map(BigDecimal x, BigDecimal in_min, BigDecimal in_max, BigDecimal out_min, BigDecimal out_max) {
        return x.subtract(in_min).multiply(out_max.subtract(out_min)).divide(in_max.subtract(in_min), RoundingMode.HALF_UP).add(out_min);
    }

    /**
     * Muuntaa aallonpituuden nanometreissä RGB-väriksi
     * @param wavelength aallonpituus
     * @param gamma gamma-arvo
     * @return värin kokonaislukuun pakattuna
     */
    public static int wavelength_to_rgb(double wavelength, double gamma) {
        double R, G, B, attenuation;
        if (wavelength >= 380 && wavelength <= 440) {
            attenuation = 0.3 + 0.7 * (wavelength - 380) / (440 - 380);
            R = Math.pow((-(wavelength - 440) / (440 - 380)) * attenuation, gamma);
            G = 0.0;
            B = Math.pow(1.0 * attenuation, gamma);
        } else if (wavelength >= 440 && wavelength <= 490) {
            R = 0.0;
            G = Math.pow((wavelength - 440) / (490 - 440), gamma);
            B = 1.0;
        } else if (wavelength >= 490 && wavelength <= 510) {
            R = 0.0;
            G = 1.0;
            B = Math.pow(-(wavelength - 510) / (510 - 490), gamma);
        } else if (wavelength >= 510 && wavelength <= 580) {
            R = Math.pow((wavelength - 510) / (580 - 510), gamma);
            G = 1.0;
            B = 0.0;
        } else if (wavelength >= 580 && wavelength <= 645) {
            R = 1.0;
            G = Math.pow(-(wavelength - 645) / (645 - 580), gamma);
            B = 0.0;
        } else if (wavelength >= 645 && wavelength <= 750) {
            attenuation = 0.3 + 0.7 * (750 - wavelength) / (750 - 645);
            R = Math.pow((1.0 * attenuation), gamma);
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
