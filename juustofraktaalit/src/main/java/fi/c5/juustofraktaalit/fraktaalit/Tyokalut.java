/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.fraktaalit;

/**
 *
 * @author Teemu Heikkilä
 */
public class Tyokalut {
    	public static int rgb(int r, int g, int b) {
		r = Math.min(255, Math.max(r, 0));
		g = Math.min(255, Math.max(g, 0));
		b = Math.min(255, Math.max(b, 0));
		return (r << 16) | (g << 8) | b;
	}
}
