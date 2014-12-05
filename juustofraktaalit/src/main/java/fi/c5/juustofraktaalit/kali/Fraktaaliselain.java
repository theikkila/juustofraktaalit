/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.kali;

import fi.c5.juustofraktaalit.fraktaalit.FraktaaliTyyppi;
import fi.c5.juustofraktaalit.fraktaalit.Tyokalut;
import fi.c5.juustofraktaalit.hajauttaja.Hajauttaja;
import fi.c5.juustofraktaalit.hajauttaja.Koordinaatti;
import fi.c5.juustofraktaalit.hajauttaja.Kuvapinta;
import fi.c5.juustofraktaalit.hajauttaja.Suorittaja;
import fi.c5.juustofraktaalit.hajauttaja.TyoMaarays;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Käyttöliittymän pääkomponentti
 *
 * @author Teemu Heikkilä
 */
public class Fraktaaliselain extends javax.swing.JFrame {

    Double keskipiste_x;
    Double keskipiste_y;
    int zoomTaso;
    Double zoom;

    /**
     * Konstruktori käyttöliittymän pääkomponentille
     */
    public Fraktaaliselain() {
        initComponents();
        this.tila = new Tilanne(this.tilaKentta);
        tila.asetaTila("Valmis!");
        this.keskipiste_x = -1.0;
        this.keskipiste_y = 0.0;
        this.zoomTaso = 0;
        this.zoom = 1.5;

        paivitaLisatiedot();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        asetusPaneeli = new javax.swing.JPanel();
        algoritmiOtsikko = new javax.swing.JLabel();
        algoritmiValinta = new javax.swing.JComboBox();
        hajautusOtsikko = new javax.swing.JLabel();
        renderoiNappi = new javax.swing.JButton();
        hajautusSlideri = new javax.swing.JSlider();
        tilaOtsikko = new javax.swing.JLabel();
        tilaKentta = new javax.swing.JTextField();
        valitonRenderointiCheckbox = new javax.swing.JCheckBox();
        tallennaKuvaNappi = new javax.swing.JButton();
        tallennaFraktaaliNappi = new javax.swing.JButton();
        avaaFraktaaliNappi = new javax.swing.JButton();
        liikuteltavaPaneeli = new javax.swing.JScrollPane();
        piirtaja = new fi.c5.juustofraktaalit.kali.Piirtaja();
        jToolBar1 = new javax.swing.JToolBar();
        keskipisteOtsikko = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        zoomOtsikko = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Juustofraktaalit");

        asetusPaneeli.setBorder(javax.swing.BorderFactory.createTitledBorder("Asetukset"));

        algoritmiOtsikko.setText("Algoritmi");

        algoritmiValinta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mandelbrot", "Hajautustesti" }));

        hajautusOtsikko.setText("Hajautus");

        renderoiNappi.setText("Renderöi");
        renderoiNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renderoiNappiActionPerformed(evt);
            }
        });

        hajautusSlideri.setMaximum(16);
        hajautusSlideri.setMinimum(1);
        hajautusSlideri.setPaintLabels(true);
        hajautusSlideri.setPaintTicks(true);
        hajautusSlideri.setSnapToTicks(true);
        hajautusSlideri.setValue(2);
        hajautusSlideri.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hajautusSlideriStateChanged(evt);
            }
        });

        tilaOtsikko.setText("Tila");

        tilaKentta.setEditable(false);
        tilaKentta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tilaKenttaActionPerformed(evt);
            }
        });

        valitonRenderointiCheckbox.setText("Välitön renderöinti?");
        valitonRenderointiCheckbox.setFocusable(false);
        valitonRenderointiCheckbox.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        valitonRenderointiCheckbox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        tallennaKuvaNappi.setText("Tallenna kuva");
        tallennaKuvaNappi.setActionCommand("tallennaKuva");
        tallennaKuvaNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tallennaKuvaNappiActionPerformed(evt);
            }
        });

        tallennaFraktaaliNappi.setText("Tallenna fraktaali");
        tallennaFraktaaliNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tallennaFraktaaliNappiActionPerformed(evt);
            }
        });

        avaaFraktaaliNappi.setText("Avaa fraktaali");
        avaaFraktaaliNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avaaFraktaaliNappiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout asetusPaneeliLayout = new javax.swing.GroupLayout(asetusPaneeli);
        asetusPaneeli.setLayout(asetusPaneeliLayout);
        asetusPaneeliLayout.setHorizontalGroup(
            asetusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asetusPaneeliLayout.createSequentialGroup()
                .addComponent(algoritmiOtsikko)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(algoritmiValinta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(asetusPaneeliLayout.createSequentialGroup()
                .addGroup(asetusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hajautusOtsikko)
                    .addComponent(tilaOtsikko))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(asetusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(asetusPaneeliLayout.createSequentialGroup()
                        .addComponent(hajautusSlideri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(asetusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(asetusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(asetusPaneeliLayout.createSequentialGroup()
                                    .addComponent(tallennaKuvaNappi)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tallennaFraktaaliNappi))
                                .addGroup(asetusPaneeliLayout.createSequentialGroup()
                                    .addComponent(avaaFraktaaliNappi)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(renderoiNappi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(valitonRenderointiCheckbox))
                        .addGap(47, 47, 47))
                    .addGroup(asetusPaneeliLayout.createSequentialGroup()
                        .addComponent(tilaKentta, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        asetusPaneeliLayout.setVerticalGroup(
            asetusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asetusPaneeliLayout.createSequentialGroup()
                .addGroup(asetusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(algoritmiOtsikko)
                    .addComponent(algoritmiValinta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tallennaKuvaNappi)
                    .addComponent(tallennaFraktaaliNappi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(asetusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(asetusPaneeliLayout.createSequentialGroup()
                        .addGroup(asetusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(avaaFraktaaliNappi)
                            .addComponent(renderoiNappi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valitonRenderointiCheckbox)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(asetusPaneeliLayout.createSequentialGroup()
                        .addGroup(asetusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hajautusOtsikko, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hajautusSlideri, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(asetusPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tilaOtsikko)
                            .addComponent(tilaKentta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        piirtaja.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                piirtajaMouseWheelMoved(evt);
            }
        });
        piirtaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                piirtajaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout piirtajaLayout = new javax.swing.GroupLayout(piirtaja);
        piirtaja.setLayout(piirtajaLayout);
        piirtajaLayout.setHorizontalGroup(
            piirtajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 813, Short.MAX_VALUE)
        );
        piirtajaLayout.setVerticalGroup(
            piirtajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );

        liikuteltavaPaneeli.setViewportView(piirtaja);

        jToolBar1.setRollover(true);

        keskipisteOtsikko.setText("keskipiste");
        jToolBar1.add(keskipisteOtsikko);
        jToolBar1.add(jSeparator1);

        zoomOtsikko.setText("zoom");
        jToolBar1.add(zoomOtsikko);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(asetusPaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(liikuteltavaPaneeli)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(liikuteltavaPaneeli, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(asetusPaneeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void renderoi() {
        tila.asetaTila("Renderöinti aloitettu!");
        TyoMaarays t = new TyoMaarays((String) algoritmiValinta.getSelectedItem(), null, new Kuvapinta(this.piirtaja.getWidth(), this.piirtaja.getHeight()), this.hajautusSlideri.getValue());
        t.asetaAlue(keskipiste_x, keskipiste_y, zoom);
        Hajauttaja h = new Hajauttaja(t);
        Suorittaja v1 = new Suorittaja(h, this.tila, t, this.piirtaja);
        v1.execute();

    }

    private void asetaFraktaaliAlgoritmit() {
        algoritmiValinta.setModel(new javax.swing.DefaultComboBoxModel(FraktaaliTyyppi.haeFraktaaliTyypit()));
    }
    private void renderoiNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renderoiNappiActionPerformed
        renderoi();
    }//GEN-LAST:event_renderoiNappiActionPerformed
    private void paivitaLisatiedot() {
        keskipisteOtsikko.setText("Keskipiste: (" + keskipiste_x + "," + keskipiste_y + ")");
        zoomOtsikko.setText("Zoom: " + zoom + " Taso:" + zoomTaso);
    }
    private void tilaKenttaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tilaKenttaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tilaKenttaActionPerformed

    private void hajautusSlideriStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hajautusSlideriStateChanged
        // TODO add your handling code here:
        tila.asetaTila("Hajautus asetettu arvoon " + hajautusSlideri.getValue() + " -> Renderöitäessä luodaan " + Math.pow(hajautusSlideri.getValue(), 2) + " säiettä.");
    }//GEN-LAST:event_hajautusSlideriStateChanged

    private void piirtajaMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_piirtajaMouseWheelMoved
        zoomTaso += evt.getWheelRotation();
        paivitaZoom();
        paivitaLisatiedot();
    }//GEN-LAST:event_piirtajaMouseWheelMoved

    private void paivitaZoom() {
        zoom = Tyokalut.laskeZoom(zoomTaso);
    }

    private void piirtajaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piirtajaMousePressed
        // TODO add your handling code here:
        maaritaKeskipiste(evt.getX(), evt.getY());
        paivitaLisatiedot();
        if (this.valitonRenderointiCheckbox.isSelected()) {
            renderoi();
        }
    }//GEN-LAST:event_piirtajaMousePressed

    private void tallennaKuvaNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tallennaKuvaNappiActionPerformed
        Tiedostokasittelija.tallennaPNG(this, tila, piirtaja);
    }//GEN-LAST:event_tallennaKuvaNappiActionPerformed

    private void tallennaFraktaaliNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tallennaFraktaaliNappiActionPerformed
        SelaimenTila t = new SelaimenTila(new Koordinaatti<>(keskipiste_x, keskipiste_y), zoomTaso);
        Tiedostokasittelija.tallennaFraktaali(this, tila, t);
    }//GEN-LAST:event_tallennaFraktaaliNappiActionPerformed

    private void avaaFraktaaliNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avaaFraktaaliNappiActionPerformed
        SelaimenTila t = Tiedostokasittelija.avaaFraktaali(this, tila);
        if (t == null) return;
        keskipiste_y = t.keskipiste.y;
        keskipiste_x = t.keskipiste.x;
        zoomTaso = t.zoom;
        paivitaZoom();
        paivitaLisatiedot();
    }//GEN-LAST:event_avaaFraktaaliNappiActionPerformed
    private void maaritaKeskipiste(int uusiPPX, int uusiPPY) {
        Koordinaatti<Double> k = Tyokalut.laskeKeskipiste(new Koordinaatti<>((double)uusiPPX, (double)uusiPPY), new Koordinaatti<>(keskipiste_x, keskipiste_y), zoom, this.piirtaja.getWidth(), this.piirtaja.getHeight());
        keskipiste_x = k.x;
        keskipiste_y = k.y;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel algoritmiOtsikko;
    private javax.swing.JComboBox algoritmiValinta;
    private javax.swing.JPanel asetusPaneeli;
    private javax.swing.JButton avaaFraktaaliNappi;
    private javax.swing.JLabel hajautusOtsikko;
    private javax.swing.JSlider hajautusSlideri;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel keskipisteOtsikko;
    private javax.swing.JScrollPane liikuteltavaPaneeli;
    private fi.c5.juustofraktaalit.kali.Piirtaja piirtaja;
    private javax.swing.JButton renderoiNappi;
    private javax.swing.JButton tallennaFraktaaliNappi;
    private javax.swing.JButton tallennaKuvaNappi;
    private javax.swing.JTextField tilaKentta;
    private javax.swing.JLabel tilaOtsikko;
    private javax.swing.JCheckBox valitonRenderointiCheckbox;
    private javax.swing.JLabel zoomOtsikko;
    // End of variables declaration//GEN-END:variables
    private Tilanne tila;
}
