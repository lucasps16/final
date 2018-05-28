/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
/**
 *
 * @author luckm
 */


class PelotaTest{
	
	private int radio;
	private Color color;
	public float nextBall;
	private float velX;
	private float velY;
	private float posX;
	private float posY;
	public boolean verificar;
	
	public PelotaTest (float posX, float posY, float velX, float velY, int radio, Color color) {
		
		this.velX = velX;
		this.velY = velY;
		this.posX = posX;
		this.posY = posY;
		this.radio = radio;
		this.color = color;
		verificar = false;
	}
	
	
	
	public int getRadio() {
		return radio;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void movimineto() {
    	setPosicion(this.velX + this.posX, this.velY + this.posY);
    	verificarColision();
    }

	public void setPosicion(float x, float y) {
		this.posX = x;
		this.posY = y;
	}

	public void setVelocidad(float velX, float velY) {
		this.velX = velX;
		this.velY = velY;
	}

	public void verificarColision() {
		if(this.posX - this.radio <= 0) {
			setVelocidad(-1 * this.velX, this.velY);
			this.posX = this.radio;
		}		
		if(this.posX + this.radio >= 600) {
			setVelocidad(-1 * this.velX, this.velY);
			this.posX = 600 - this.radio;
		}
		if(this.posY + this.radio >= 800) {
			setVelocidad(this.velX, -1 * this.velY);
			this.posY = 800 - this.radio;
		}	
		if(pelotaPiso()) {
			setVelocidad(0, 0);			
		}
	}

	public boolean pelotaPiso() {
		if(this.posY - this.radio <= 0) {
			return true;
		}else{
		return false;
	}	
        }
	
	public boolean lugarPelota(float x, float y) {
		return this.posX == x && this.posY == y;
	}

	
}