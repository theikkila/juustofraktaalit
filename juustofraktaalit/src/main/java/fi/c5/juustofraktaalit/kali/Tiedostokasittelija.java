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
 * Sisältää kokoelman staattisia metodeita jotka liittyvät käyttöliittymän
 * tiedostonkäsittelyyn.
 *
 * @author Teemu Heikkilä
 */
public class Tiedostokasittelija {

    /**
     * Tallentaa fraktaalin PNG-tiedostoon
     *
     * @param vanhempi Käyttöliittymä
     * @param tila Käyttöliittymän tilaolio
     * @param piirtaja Käyttöliittymän piirto-olio
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

    /**
     * Palauttaa tallennustiedoston tyyppifiltterin
     */
    private static FileNameExtensionFilter haeFraktaaliFiltteri() {
        return new FileNameExtensionFilter("FTT fraktaalitallennustiedosto", "ftt");
    }

    /**
     * Avaa fraktaalin ftt-tiedostosta (juustofraktaaligeneraattorin oma muoto)
     *
     * @param vanhempi Käyttöliittymä
     * @param tila Käyttöliittymän tilaolio
     * @return Fraktaaliselaimen tila joka on ladattu tiedostosta
     */
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

    /**
     * Tallentaa fraktaalin ftt-tiedostoon (juustofraktaaligeneraattorin oma
     * muoto)
     *
     * @param vanhempi Käyttöliittymä
     * @param tila Käyttöliittymän tilaolio
     * @param stila Fraktaaliselaimen tila joka on tallennetaan tiedostoon
     */
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

    /**
     * Avaa ftt-tiedoston ja purkaa SelaimenTila-objektin
     * (juustofraktaaligeneraattorin oma muoto)
     *
     * @param t Avattava tiedosto
     * @return Fraktaaliselaimen tila joka on ladattu tiedostosta
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.IOException
     */
    public static SelaimenTila avaaTilaTiedostosta(File t) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream tiedosto = new FileInputStream(t);
        ObjectInputStream avaaja = new ObjectInputStream(tiedosto);
        SelaimenTila stila = (SelaimenTila) avaaja.readObject();
        avaaja.close();
        tiedosto.close();
        return stila;
    }

    /**
     * Tallentaa ftt-tiedoston ja serialisoi SelaimenTila-objektin
     * (juustofraktaaligeneraattorin oma muoto)
     *
     * @param t Tallennettava tiedosto
     * @param stila Fraktaaliselaimen tila joka serialisoidaan ja tallennetaan
     * tiedostoon
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public static void tallennaTilaTiedostoon(File t, SelaimenTila stila) throws FileNotFoundException, IOException {
        FileOutputStream tiedosto = new FileOutputStream(t);
        ObjectOutputStream tallennin = new ObjectOutputStream(tiedosto);
        tallennin.writeObject(stila);
        tallennin.close();
        tiedosto.close();
    }

}
