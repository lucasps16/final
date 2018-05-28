/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author luckm
 */
public class Board extends JPanel implements ActionListener, MouseListener {

    private Pelota pelota, pelotaTemp;
    private Contenedor contenedor;
    private Timer timer;
    private int nCajas = 3;
    private Caja[] caja = new Caja[nCajas];
    private MouseEvent e;
    private Graphics g;
    
    public int[] cont = new int[nCajas];
    //Angulo =  Math.toDegrees(Math.atan2(e.getY() -pelota.getY(), (e.getX() - pelota.getX())));
    private double angulo;
    private int x,y,radio,vel;
    public static boolean click =  false;
    

    public Board() {
        addMouseListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.timer = new Timer(30, this);

        radio = 10;
        x = 205;
        y = 650;
        vel = 10;
        pelotaTemp = new Pelota(x, y, radio, vel, 0,Color.white);
        caja[0] = new Caja(200, 100, 25,1, Color.blue, Color.orange);
        caja[1] = new Caja(252, 100, 25, 2, Color.orange, Color.orange);
        caja[2] = new Caja(252, 125, 25, 3, Color.white, Color.orange);
        contenedor = new Contenedor(0, 0, 600, 700);
        
        

        
    }
    
    public void setAngulo(MouseEvent e){
        
       double angulo = Math.toDegrees(Math.atan2(e.getY()-y, (e.getX()- x)));
        this.angulo = angulo;
       pelota = new Pelota(x, y, radio, vel, this.angulo, Color.white);
        pelotaTemp = pelota;
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        
        contenedor.draw(g);
        for (Caja caja1 : caja) {
            caja1.draw(g);  
        }
        pelotaTemp.draw(g);
        g.setColor(Color.WHITE);
      
    }


    
    public void colisionCaja(){
        for(int i = 0; i < caja.length; i++){
        if(pelota.getRect().intersects(caja[i].getRect())){
            if(pelota.getX()<caja[i].getMaxX()+5){
               pelota.setVelX(-pelota.getVelX());
               caja[i].setContador(caja[i].getContador()-1);
                
            }
            if(pelota.getY()<caja[i].getMaxY()+15){
                pelota.setVelY(-pelota.getVelY());
                System.out.println("Devolverse");
            }
            cont[i]++;
            System.out.println(cont[i]);
            if(caja[i].getContador() == 0){//Destruye la caja
             caja[i].setMaxX(0);
             caja[i].setMinX(0);
             caja[i].setMinY(0);
             caja[i].setMaxY(0);
        }
      }
    }
    
//    public void destruirCaja(){
//        for (int i = 0; i < caja.length; i++) {
//            
//        }  
//      }
    }
    
    public void gameStart() {
        Thread gameThread = new Thread() {
            @Override
            public void run() {
                while (click == true) {
                    
                    gameUpdate();
                    repaint();

                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException ex) {
                        System.out.println("Wrong!!");
                    }
                }
               
            }
        };
        gameThread.start();
    }

    public void gameUpdate() {
        
        pelota.Collision(contenedor);
       // destruirCaja();
        colisionCaja();
        x = (int) pelota.getX();
        y = (int) pelota.getY();
             
      }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        pelota.setVelX((float) (vel * Math.cos(Math.toRadians(angulo))));
        pelota.setVelY((float) (-vel * (float) Math.sin(Math.toRadians(angulo))));
        gameStart();
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        click = true;
        System.out.println("Mouse x: " + e.getX() );
        System.out.println("Mouse Y: " + e.getY());
       setAngulo(e);
       System.out.println("Angulo: " + -angulo+ "°");
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
}
