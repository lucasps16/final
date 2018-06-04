/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;


import static Objetos.prueba.pelotaTemp;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import static Objetos.Main1.selecNivel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author luckm
 */
public class Niveles extends JPanel implements ActionListener, MouseListener {
    
    Nivel1 nivel1  = new Nivel1();
    Pelota pelota;
    private Pelota pelotaTemp;
    private Contenedor contenedor;
    private Timer timer;
    private int nCajas;
    private Caja[] caja;
    private int disparos;
    public int[] cont;
    private double angulo;
    private int x,y;
    private int radio = 10;
    private int vel = 7;
    private int puntaje = 0;
    public static boolean click =  false;
    private boolean r = true;
    private int posx, posy;
    private Image fondo;
    private Image ad;
    
    public Niveles(){
        addMouseListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.timer = new Timer(30, this);
        contenedor = new Contenedor(0, 0, 600, 700);
        y = 570;
        //Nivel 1
        if(selecNivel == 1){
            fondo = nivel1.fondo();
            ad = nivel1.ad();
            disparos = nivel1.getDisparos();
            x = nivel1.getpX();
            posx = nivel1.getcX();
            posy = nivel1.getcY();
            nCajas = nivel1.getnCajas();
            caja = new Caja[nCajas];
            cont = new int[nCajas];
            pelotaTemp = new Pelota(x, y, radio, vel, 0, Color.white);
            for (int i = 0; i < 4; i++) {
                caja[i] = new Caja(150,posy , 25, nivel1.getGolpesCaja(), Color.white, Color.gray);
                posy = posy + 25;
            }
            posy = nivel1.getcY();
            for (int i = 4; i < 6; i++) {
                caja[i] = new Caja(posx + 25,posy + 100 , 25, nivel1.getGolpesCaja(), Color.white, Color.gray);
                posx = posx + 25;
            }
            posx = nivel1.getcX();
            for (int i  = 6; i < 10; i++) {
                caja[i] = new Caja(posx + 75,posy , 25, nivel1.getGolpesCaja(), Color.white, Color.gray);
                posy = posy + 25;
            }
            
            posx =325;
            posy = 200;
            
            for (int i = 10; i < 15; i++) {
                caja[i] = new Caja(posx ,posy , 25, nivel1.getGolpesCaja(), Color.white, Color.gray);
                posy = posy + 25;
            }
            
            posx = 350;
            posy = 225;
            
             for (int i = 15; i < 18; i++) {
                caja[i] = new Caja(posx ,posy , 25, nivel1.getGolpesCaja(), Color.white, Color.gray);
                posy = posy + 25;
                posx = posx + 25;
            }
             
            posx = 425;
            posy = 200;
            
             for (int i = 18; i < 23; i++) {
                caja[i] = new Caja(posx ,posy , 25, nivel1.getGolpesCaja(), Color.white, Color.gray);
                posy = posy + 25;
            }
            
        }
        
        
    }
    
    public void setAngulo(MouseEvent e){
        
       double angulo = Math.toDegrees(Math.atan2(e.getY()-y, (e.getX()- x)));
        this.angulo = angulo;
       pelota = new Pelota(x, y, radio, vel, this.angulo, Color.white);
        pelotaTemp = pelota;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        contenedor.draw(g);
        g.drawImage(ad, 0, 0, null);
        g.drawImage(fondo, 0, 50, null);
        //Imagenes de niveles , if nivel 1,2,3
        g.setColor(Color.black);
        g.fillRect(-1, 625, 602, 27);
        g.setColor(Color.white);
        g.fillRect(-1, 582, 602, 5);
        g.fillRect(200, 582, 5, 150);
        g.fillRect(400, 582, 5, 150);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.drawString("Puntaje:" + puntaje, 5, 630);
        g.drawString("Disparos: "+ disparos, 405, 630);
        //Metodo de niveles
        
         for (Caja caja1 : caja) {
            caja1.draw(g);  
        }
        pelotaTemp.draw(g);
        g.setColor(Color.WHITE);
        
         if(disparos <= -1){
            g.setColor(Color.black);
            g.fillRect(0, 0, 600, 750);
//            try {
//                TimeUnit.SECONDS.sleep(0.1);
//            } catch (InterruptedException ex) {
//            }
            g.setColor(Color.red);
            g.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 40));
            g.drawString("PERDISTE", 200, 325);
            g.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 25));
            g.drawString("Presione 'R' para reiniciar", 125, 350);
           
             
             
        }
    }
    
    public Image loadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
    
     public void colisionCaja(){
        for(int i = 0; i < caja.length; i++){
        if(pelota.getRect().intersects(caja[i].getRect())){
            if(pelota.getX()<caja[i].getMaxX()){
               pelota.setVelX(-pelota.getVelX());
               
            }
            if(pelota.getY()<caja[i].getMaxY()+15){
                pelota.setVelY(-pelota.getVelY());
            }
            if(pelota.getX()>caja[i].getMaxX()){
               pelota.setVelX(pelota.getVelX());
               pelota.setVelY(pelota.getVelY());
            }
            if(pelota.getY()>caja[i].getMaxY()){
                
            }
            caja[i].setContador(caja[i].getContador()-1);
            cont[i]++; //Cuenta el numero de veces que una caja ha sido golpeada
            
            if(caja[i].getContador() <= 0){//Destruye la caja
             caja[i].setMaxX(0);
             caja[i].setMinX(0);
             caja[i].setMinY(0);
             caja[i].setMaxY(0);
             puntaje = puntaje + 100;
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
                while (true) {
                    
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
        pelota.setVelX((float) (10 * Math.cos(Math.toRadians(angulo))));
        pelota.setVelY((float) (-10 * (float) Math.sin(Math.toRadians(angulo))));
        gameStart();
        disparos --;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        click = true;
        System.out.println("Mouse x: " + e.getX() );
        System.out.println("Mouse Y: " + e.getY());
        System.out.println("Vel:" + vel);
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
