/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit;


import fi.c5.juustofraktaalit.kali.Fraktaaliselain;


/**
 * Pääluokka
 * @author Teemu Heikkilä
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Juustofraktaalit - pääohjelma");
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Fraktaaliselain().setVisible(true);
            }
        });
    }
}
