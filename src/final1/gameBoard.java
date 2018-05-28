
package final1;
import java.awt.geom.Area;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.ArrayList;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class gameBoard extends JPanel implements MouseListener,ActionListener{ 
    private Timer timer;
    float radioPelota = 10;
    float xRef = radioPelota + 190;
    float yRef = radioPelota + 640;
    float velX = 0;
    float velY = 10;
    float xRect = 200;
    float yRect = 100;
    float ladoRect = 25;
    public Rectangle caja, pelota;
    boolean starter = false;
    Thread gameThread;
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillRect(0, 0, 600, 700);
        g.drawRect(0, 0, 600, 700);
        setBackground(new Color(255,255,255));
        
        //Cajas
        caja = new Rectangle((int)xRect,(int)yRect,(int)ladoRect, (int)ladoRect);
        g.setColor(Color.red);
        g.fillRect(200, 100, (int)ladoRect, (int)ladoRect);
        
        //Pelota
        g.setColor(Color.white);
        g.fillOval((int)xRef, (int)yRef,(int) radioPelota,(int) radioPelota);
        pelota = new Rectangle((int)xRef, (int)yRef,(int)radioPelota,(int)radioPelota);
        
        
            
        
    }
    
    public gameBoard(){ 
        
        
       
        gameThread = new Thread(){
            @Override
            public void run(){
                while(true){
                    timer.start();
                    xRef += velX;
                    yRef -= velY;
                    
                    if(xRef - radioPelota < 0){
                        velX = -velX;
                        xRef = radioPelota;
                    } else if(xRef+radioPelota > 600){
                        velX = -velX;
                        xRef = 600-radioPelota;
                    }
                    
                     if(yRef >= 650){
                        velY = 0;
                        velX=0;
                        yRef = yRef;
                    }else if(yRef < 0){
                        velY = -velY;
                    }
                    
                     if(pelota.intersects(caja) && xRef < xRect ){
                         xRef = xRect;
                         velX = -velX;
                     } else if(pelota.intersects(caja)&& xRef>xRect+ladoRect){
                         xRef = xRect +ladoRect;
                         velX = -velX;
                     }else if(pelota.intersects(caja)&& yRef +radioPelota< yRect){
                         System.out.println("Y1");
                         yRef = yRect-radioPelota;
                         velY = -velY;
                         
                     }else if(pelota.intersects(caja)&& yRef > yRect){
                         System.out.println("Y2");
                         yRef = yRect+ladoRect;
                         velY = -velY;
                         
                     }
                     
                     if(pelota.intersects(caja)){
                         xRect = -50;
                         yRect = -50;
                         ladoRect = 0;
                     }
                    repaint();
                    try{
                        Thread.sleep(1000/30);
                    }catch(InterruptedException ex){
                    }
                }
            }
        };
        
    }
    
    


    @Override
    public void mouseClicked(MouseEvent e) {
      starter = true;
        System.out.println("Good");
        gameThread.start();
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        repaint();
    }
}
