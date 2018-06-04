/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author luckm
 */
public class Inicio extends JPanel{
    //IMagenes tomadas de :
    //https://revistaaxxis.com.co/wp-content/uploads/2016/09/edificio-de-enfermeria-universidad-nacional-revista-axxis-1.jpg
    public Inicio(){
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Color verde = new Color(15, 86, 6);
        Image fondo = loadImage("enfermeria.jpg");
        g.drawImage(fondo, -80, 0, null);
        Image titulo = loadImage("titulo.png");
        g.drawImage(titulo, -60, -150, null);
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.drawString("Seleccione el nivel:", 12, 320);
        g.drawString("Nivel 1: Presione 1", 22, 350);
        g.drawString("Nivel 2: Presione 2", 22, 380);
        g.drawString("Nivel 3: Presione 3", 22, 410);
        g.setColor(verde);
        g.drawString("Seleccione el nivel:", 10, 320);
        g.drawString("Nivel 1: Presione 1", 20, 350);
        g.drawString("Nivel 2: Presione 2", 20, 380);
        g.drawString("Nivel 3: Presione 3", 20, 410);
    }
    
    public Image loadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
}
