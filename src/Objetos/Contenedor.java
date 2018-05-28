/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author luckm
 */
import java.awt.*;
import java.awt.Image;


public class Contenedor {
   int minX, maxX, minY, maxY;  // Box's bounds (package access)
   private Color colorInterno;   // Box's filled color (background)
   private Color colorBorde;   // Box's border color
   private static final Color DEFAULT_COLOR_FILLED = Color.BLACK;
   private static final Color DEFAULT_COLOR_BORDER = Color.GRAY;
   
   
   public Contenedor(int x, int y, int width, int height, Color colorInterno, Color colorBorde) {
      minX = x;
      minY = y;
      maxX = x + width - 1;
      maxY = y + height - 1;
      this.colorInterno = colorInterno;
      this.colorBorde = colorBorde;
   }
   
   
   public Contenedor(int x, int y, int width, int height) {
      this(x, y, width, height, DEFAULT_COLOR_FILLED, DEFAULT_COLOR_BORDER);
   }
   
   
   public void set(int x, int y, int width, int height) {
      minX = x;
      minY = y;
      maxX = x + width - 1;
      maxY = y + height - 1;
   }

   
   public void draw(Graphics g) {
      g.setColor(colorInterno);
      g.fillRect(minX, minY, maxX - minX - 1, maxY - minY - 1);
      g.setColor(colorBorde);
      g.drawRect(minX, minY, maxX - minX - 1, maxY - minY - 1);
   }
}
