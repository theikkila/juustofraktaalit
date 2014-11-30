/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.kali;

import javax.swing.JTextField;

/**
 * Tilanne toimii tekstikentälle wräpperinä ja päivittää sen sisältöä atomisesti.
 * @author Teemu Heikkilä
 */
public class Tilanne {
    JTextField tilakentta;
    public Tilanne(JTextField tilakentta) {
        this.tilakentta = tilakentta;
    }
    public void asetaTila(String tila){
        tilakentta.setText(tila);
        System.out.println(tila);
    }
}
