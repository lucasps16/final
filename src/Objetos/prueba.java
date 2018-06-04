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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author luckm
 */
public abstract class prueba extends JPanel implements ActionListener, MouseListener {

    public static  Pelota pelota, pelotaTemp;
    private Contenedor contenedor;
    private Timer timer;
    private int nCajas = 3;
    private Caja[] caja = new Caja[nCajas];
    private MouseEvent e;
    private Graphics g;
    private int disparos = 2;
    public int[] cont = new int[nCajas];
    //Angulo =  Math.toDegrees(Math.atan2(e.getY() -pelota.getY(), (e.getX() - pelota.getX())));
    private double angulo;
    public static int x,y,radio,vel;
    private int puntaje = 0;
    public static boolean click =  false;
    private boolean r = true;
    

    public prueba() {
        addMouseListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.timer = new Timer(30, this);

        radio = 10;
        x = 205;
        y = 570;
        vel = 10;
        pelotaTemp = new Pelota(x, y, radio, vel, 0,Color.white);
        caja[0] = new Caja(200, 100, 25,1, Color.blue, Color.gray);
        caja[1] = new Caja(252, 100, 25, 2, Color.orange, Color.gray);
        caja[2] = new Caja(252, 125, 25, 3, Color.white, Color.gray);
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
        
//        BufferedImage img = null;
//        try {
//             img = ImageIO.read(new URL("https://camo.envatousercontent.com/593f6d8bd17c8d035874b560cbee8f529cd826d5/687474703a2f2f677764616462616e6e6572732e636f6d2f5265662d42616e6e6572732f3030322e6a7067"));
//        } catch (IOException ex) {
//            System.out.println("URL error");
//        }

//********Para cargar un anuncio se llamaria el url del anuncio y se colocaria en pantalla,
//********pero por algun motivo al cargarlo desde una url la jugabilidad del juego diminuye demasiado.
//********entonces unicamente se cargara la imagen desde los archivos del proyecto.
//*********************************************************************************************************
        super.paintComponent(g);
       
        
        
        Image fondo = loadImage("unal_1.jpg");
        Image ad = loadImage("ad2.jpg");
        contenedor.draw(g);
        g.drawImage(ad, 0, 0, null);
        g.drawImage(fondo, 0, 50, null);
        
        //Rectangulo en donde esta la información del juego.
        g.setColor(Color.black);
        g.fillRect(-1, 625, 602, 27);
        g.setColor(Color.white);
        g.fillRect(-1, 582, 602, 5);
        g.fillRect(200, 582, 5, 150);
        g.fillRect(400, 582, 5, 150);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.drawString("Puntaje:" + puntaje, 5, 630);
        g.drawString("Disparos: "+ disparos, 405, 630);
        
        //Rectangulo en donde se muestran los tiros restantes
        
        
        
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
             vel = 0;
             
             
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
        disparos --;
        
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



