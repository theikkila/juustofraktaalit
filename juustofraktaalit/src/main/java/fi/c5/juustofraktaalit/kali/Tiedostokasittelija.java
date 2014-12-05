/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.kali;

import java.awt.image.RenderedImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Teemu Heikkilä
 */
public class Tiedostokasittelija {

    /**
     * Tallentaa fraktaalin PNG-tiedostoon
     *
     * @param vanhempi
     * @param tila
     * @param piirtaja
     */
    public static void tallennaPNG(JFrame vanhempi, Tilanne tila, Piirtaja piirtaja) {
        final JFileChooser valitsin = new JFileChooser();
        FileNameExtensionFilter filtteri = new FileNameExtensionFilter("PNG kuvat", "png");
        valitsin.setFileFilter(filtteri);
        int palautus = valitsin.showSaveDialog(vanhempi);
        if (palautus == JFileChooser.APPROVE_OPTION) {
            File t = valitsin.getSelectedFile();
            tila.asetaTila("Tallennetaan fraktaalia kuvatiedostoon...");
            try {
                ImageIO.write((RenderedImage) piirtaja.haeKuva(), "PNG", t);
                tila.asetaTila("Fraktaalin kuva tallennettu.");
            } catch (IOException e) {
                tila.asetaTila("Tiedoston tallentaminen ei onnistunut!");
            }

        } else {
            tila.asetaTila("Kuvaa ei tallennettu!");
        }
    }

    public static FileNameExtensionFilter haeFraktaaliFiltteri() {
        return new FileNameExtensionFilter("FTT fraktaalitallennustiedosto", "ftt");
    }

    public static SelaimenTila avaaFraktaali(JFrame vanhempi, Tilanne tila) {
        final JFileChooser valitsin = new JFileChooser();

        valitsin.setFileFilter(haeFraktaaliFiltteri());
        int palautus = valitsin.showOpenDialog(vanhempi);

        if (palautus == JFileChooser.APPROVE_OPTION) {
            File t = valitsin.getSelectedFile();
            tila.asetaTila("Avataan fraktaalia...");
            try {
                SelaimenTila stila = avaaTilaTiedostosta(t);
                tila.asetaTila("Fraktaali ladattu!");
                return stila;
            } catch (IOException ex) {
                tila.asetaTila("Lukuvirhe: fraktaalin lataus epäonnistui!");
            } catch (ClassNotFoundException ex) {
                tila.asetaTila("Fraktaalin lataus epäonnistui, SelaimenTila-luokkaa ei löydetty");
            }

        } else {
            tila.asetaTila("Fraktaalia ei tallennettu!");
        }
        return null;
    }

    public static void tallennaFraktaali(JFrame vanhempi, Tilanne tila, SelaimenTila stila) {
        final JFileChooser valitsin = new JFileChooser();
        valitsin.setFileFilter(haeFraktaaliFiltteri());
        int palautus = valitsin.showSaveDialog(vanhempi);

        if (palautus == JFileChooser.APPROVE_OPTION) {
            File t = valitsin.getSelectedFile();
            tila.asetaTila("Tallennetaan fraktaalia...");
            try {
                tallennaTilaTiedostoon(t, stila);
                tila.asetaTila("Fraktaali tallennettu...");
            } catch (IOException e) {
                tila.asetaTila("Tiedoston tallentaminen ei onnistunut!");
            }

        } else {
            tila.asetaTila("Fraktaalia ei tallennettu!");
        }
    }
    public static SelaimenTila avaaTilaTiedostosta(File t) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream tiedosto = new FileInputStream(t);
        ObjectInputStream avaaja = new ObjectInputStream(tiedosto);
        SelaimenTila stila = (SelaimenTila) avaaja.readObject();
        avaaja.close();
        tiedosto.close();
        return stila;
    }
    public static void tallennaTilaTiedostoon(File t, SelaimenTila stila) throws FileNotFoundException, IOException {
        FileOutputStream tiedosto = new FileOutputStream(t);
        ObjectOutputStream tallennin = new ObjectOutputStream(tiedosto);
        tallennin.writeObject(stila);
        tallennin.close();
        tiedosto.close();
    }

}
