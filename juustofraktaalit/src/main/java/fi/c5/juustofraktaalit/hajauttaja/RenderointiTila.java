/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.c5.juustofraktaalit.hajauttaja;

/**
 * Rajapinta renderöinnin tilan seuraamiseen
 * @author Teemu Heikkilä
 */
public interface RenderointiTila {
    /**
     * Yhteinen metodi ajetaan kun jokin renderöitävä osa on valmis
     */
    public void osaValmis();
}
