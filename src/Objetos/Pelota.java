/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import static Objetos.Board.click;
/**
 *
 * @author luckm
 */
public class Pelota {

    float x, y;
    float velX, velY;
    float radio;
    double angulo;
    private Color color;
    private static final Color DEFAUL_COLOR = Color.white;

    public Pelota(float x, float y, float radio, float vel, double angulo, Color color) {
        this.x = x;
        this.y = y;
        this.velX = (float) (vel * Math.cos(Math.toRadians(angulo)));
        this.velY = (float) (-vel * (float) Math.sin(Math.toRadians(angulo)));
        this.radio = 10;
        this.color = color;
        this.angulo = angulo; 
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }

    public float getX() {
        return x;
    }

    public float getVelX() {
        return velX;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public float getRadio() {
        return radio;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public float getY() {
        return y;
    }

    public Pelota(float x, float y, float radio, float vel, float angulo) {
        this(x, y, radio, vel, angulo, DEFAUL_COLOR);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int) (x - radio), (int) (y - radio), (int) (2 * radio), (int) (2 * radio));
//        g.setColor(Color.GREEN);
//        g.fillRect((int)(x-radio),(int)(y-radio),2*(int)radio,2*(int)radio);
    }
    
    public Rectangle getRect(){
        return new Rectangle((int)(x-radio),(int)(y-radio),2*(int)radio,2*(int)radio);
    }

    public void Collision(Contenedor contenedor) {//COlisiones con los bordes de
        //de la vetana
        float pelotaMinX = contenedor.minX + radio;
        float pelotaMinY = contenedor.minY + radio;
        float pelotaMaxX = contenedor.maxX - radio;
        float pelotaMaxY = contenedor.maxY - radio;

        x += velX;
        y -= velY;

        if (x < pelotaMinX) {
            velX = -velX;
            x = pelotaMinX;
        } else if (x > pelotaMaxX) {
            velX = -velX;
            x = pelotaMaxX;
        }

        if (y < pelotaMinY) {
            velY = -velY;
            y=pelotaMinY;
        } else if(y>pelotaMaxY - 25) { //La pelota llega al suelo y se queda quieta
            velY = 0;
            velX=0;
           
            click = false;
        }

    }
    


     }


