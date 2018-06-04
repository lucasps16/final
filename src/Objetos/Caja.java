/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class Caja {
   int minX, maxX, minY, maxY,contador;  
   private Color colorInterno;   // Box's filled color (background)
   private Color colorBorde;   // Box's border color
   private static final Color DEFAULT_COLOR_FILLED = Color.BLUE;
   private static final Color DEFAULT_COLOR_BORDER = Color.GRAY;
   int lado = 25;

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    
   
   
   public Caja(int x, int y, int lado,int contador, Color colorInterno, Color colorBorde) {
      minX = x;
      minY = y;
      maxX = x + lado- 1;
      maxY = y + lado - 1;
      this.contador = contador;
      this.colorInterno = colorInterno;
      this.colorBorde = colorBorde;
   }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }
    

    public int getMinX() {
        return minX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxY() {
        return maxY;
    }
   
   
   public Caja(int x, int y, int lado, int contador) {
      this(x, y, lado,contador, DEFAULT_COLOR_FILLED, DEFAULT_COLOR_BORDER);
   }
   
   
   public void set(int x, int y, int lado) {
      minX = x;
      minY = y;
      maxX = x + lado ;
      maxY = y + lado ;
   }
   
   public Rectangle getRect(){
       return new Rectangle(minX-5, minY-5, lado +5,lado + 5);
   }
   
   public void draw(Graphics g) {
//       g.setColor(Color.RED);
//      g.fillRect(minX - 5, minY - 5, lado + 10,lado +10);
      g.setColor(colorInterno);
      g.fillRect(minX, minY, maxX - minX - 1, maxY - minY - 1);
      g.setColor(colorBorde);
      g.drawRect(minX, minY, maxX - minX, maxY - minY);
      g.setColor(Color.BLACK);
      g.setFont(new Font("Arial black", Font.PLAIN, 12));
      g.drawString("" + contador, minX + lado/2 - 5, minY + lado/2 + 5);
   }
}

