/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author luckm
 */
public class Nivel3{
    private int nCajas = 36;
    private int golpesCaja = 10;
    private int disparos = 12;
    private int pX = 301;
    private int cX = 275;
    private int cY = 50;

    public int getcY() {
        return cY;
    }
    
    public Image fondo(){
        Image fondo = loadImage("/src/images/unal.jpg"); //Imagen tomada de:  http://unal.edu.co/typo3temp/_processed_/csm_9-img-_bog_mayo6_01_da21e14ea8.jpg
        return fondo;
    }
    
    public Image ad(){
        Image ad = loadImage("/src/images/ad2.jpg");
        return ad;
    }
    
     public Image loadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
    
    public void setcY(int cY) {
        this.cY = cY;
    }

    public int getnCajas() {
        return nCajas;
    }

    public void setnCajas(int nCajas) {
        this.nCajas = nCajas;
    }

    public int getGolpesCaja() {
        return golpesCaja;
    }

    public void setGolpesCaja(int golpesCaja) {
        this.golpesCaja = golpesCaja;
    }

    public int getDisparos() {
        return disparos;
    }

    public void setDisparos(int disparos) {
        this.disparos = disparos;
    }

    public int getpX() {
        return pX;
    }

    public void setpX(int pX) {
        this.pX = pX;
    }

    public int getcX() {
        return cX;
    }

    public void setcX(int cX) {
        this.cX = cX;
    }
    
    
    
    
    
}
