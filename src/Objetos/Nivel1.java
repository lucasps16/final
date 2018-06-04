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
public class Nivel1{
    private int nCajas = 23;
    private int golpesCaja = 5;
    private int disparos = 15;
    private int pX = 301;
    private int cX = 150;
    private int cY = 200;

    public int getcY() {
        return cY;
    }
    
    public Image fondo(){
        Image fondo = loadImage("unal_1.jpg");
        return fondo;
    }
    
    public Image ad(){
        Image ad = loadImage("ad2.jpg");
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
