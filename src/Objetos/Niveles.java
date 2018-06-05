
package Objetos;



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




public class Niveles extends JPanel implements ActionListener, MouseListener {
    
    Nivel1 nivel1  = new Nivel1();
    Nivel2 nivel2 = new Nivel2();
    Nivel3 nivel3 = new Nivel3();
    Inicio inicio = new Inicio();
    private Pelota pelota;
    private Pelota pelotaTemp;
    private Contenedor contenedor;
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
        contenedor = new Contenedor(0, 0, 600, 700);
        y = 570;
        //Nivel 1
        switch (selecNivel) {
            case 1:
                fondo = nivel1.fondo();
                ad = nivel1.ad();
                disparos = nivel1.getDisparos();
                x = nivel1.getpX();
                posx = nivel1.getcX();
                posy = nivel1.getcY();
                nCajas = nivel1.getnCajas();
                caja = new Caja[nCajas];
                cont = new int[nCajas];
                pelotaTemp = new Pelota(x, y, radio, 10, 0, Color.white);
                for (int i = 0; i < 4; i++) {
                    caja[i] = new Caja(150,posy , 25, nivel1.getGolpesCaja(), Color.white, Color.gray);
                    posy = posy + 25;
                }   posy = nivel1.getcY();
                for (int i = 4; i < 6; i++) {
                    caja[i] = new Caja(posx + 25,posy + 100 , 25, nivel1.getGolpesCaja(), Color.white, Color.gray);
                    posx = posx + 25;
                }   posx = nivel1.getcX();
                for (int i  = 6; i < 10; i++) {
                    caja[i] = new Caja(posx + 75,posy , 25, nivel1.getGolpesCaja(), Color.white, Color.gray);
                    posy = posy + 25;
                }   posx =325;
                posy = 200;
                for (int i = 10; i < 15; i++) {
                    caja[i] = new Caja(posx ,posy , 25, nivel1.getGolpesCaja(), Color.white, Color.gray);
                    posy = posy + 25;
                }   posx = 350;
                posy = 225;
                for (int i = 15; i < 18; i++) {
                    caja[i] = new Caja(posx ,posy , 25, nivel1.getGolpesCaja(), Color.white, Color.gray);
                    posy = posy + 25;
                    posx = posx + 25;
                }   posx = 425;
                posy = 200;
                for (int i = 18; i < 23; i++) {
                    caja[i] = new Caja(posx ,posy , 25, nivel1.getGolpesCaja(), Color.white, Color.gray);
                    posy = posy + 25;
                }   
                break;
            case 2:
                //Nivel 2.
                fondo = nivel2.fondo();
                ad = nivel2.ad();
                disparos = nivel2.getDisparos();
                x = nivel2.getpX();
                posx = nivel2.getcX();
                posy = nivel2.getcY();
                nCajas = nivel2.getnCajas();
                caja = new Caja[nCajas];
                cont = new int[nCajas];
                pelotaTemp = new Pelota(x, y, radio, 10, 0, Color.white);
                for (int i = 0; i < 28; i++) {
                    caja[i] = new Caja(posx ,posy , 25, nivel1.getGolpesCaja(), Color.yellow, Color.gray);
                    posx = posx +25;
                }  
                posx = nivel2.getcX();
                for (int i = 28; i < 56; i++) {
                    caja[i] = new Caja(posx ,posy + 25, 25, nivel1.getGolpesCaja(), Color.yellow, Color.gray);
                    posx = posx +25;
                }   
                posx = nivel2.getcX();
                for (int i = 56; i < 84; i++) {
                    caja[i] = new Caja(posx ,posy + 50, 25, nivel1.getGolpesCaja(), Color.blue, Color.gray);
                    posx = posx +25;
                }  
                posx = nivel2.getcX();
                for (int i = 84; i < 112; i++) {
                    caja[i] = new Caja(posx ,posy + 75, 25, nivel1.getGolpesCaja(), Color.red, Color.gray);
                    posx = posx +25;
                }  
                break;
            case 3:
                //Nivel 3
                
                fondo = nivel3.fondo();
                ad = nivel3.ad();
                disparos = nivel3.getDisparos();
                x = nivel3.getpX();
                posx = nivel3.getcX();
                posy = nivel3.getcY();
                nCajas = nivel3.getnCajas();
                caja = new Caja[nCajas];
                cont = new int[nCajas];
                pelotaTemp = new Pelota(x, y, radio, 10, 0, Color.white);
                
                for (int i = 0; i < 12; i++) {
                    caja[i] = new Caja(posx ,posy , 25, nivel3.getGolpesCaja(), Color.green, Color.gray);
                    posx = posx -25;
                    posy = posy +25;
                }  
                 posx = 300;
                posy = nivel3.getcY();
                
                 for (int i = 12; i < 24; i++) {
                    caja[i] = new Caja(posx ,posy , 25, nivel3.getGolpesCaja(), Color.green, Color.gray);
                    posx = posx +25;
                    posy = posy +25;
                }  
                 posx = 125;
                 posy = nivel3.getcY();
                 
                for (int i = 24; i < 30; i++) {
                    caja[i] = new Caja(posx ,posy , 25, nivel3.getGolpesCaja(), Color.yellow, Color.gray);
                    posx = posx -25;
                    posy = posy +25;
                }  
                
                posx = 450;
                posy = nivel3.getcY();
                
                for (int i = 30; i < 36; i++) {
                    caja[i] = new Caja(posx ,posy , 25, nivel3.getGolpesCaja(), Color.yellow, Color.gray);
                    posx = posx +25;
                    posy = posy +25;
                }  
                
                
                
                
                break;
            default:
                break;
        }
        
        
    }
    
    public void setAngulo(MouseEvent e){
        //Le da el angulo inicial a la pelota
       double angulo = Math.toDegrees(Math.atan2(e.getY()-y, (e.getX()- x)));
        this.angulo = angulo;
       pelota = new Pelota(x, y, radio, 10 , this.angulo, Color.white);
        pelotaTemp = pelota;
    }
    
    @Override
    public void paintComponent(Graphics g){ //Dibuja los componentes de la ventana de de juego
        if(selecNivel > 0){
        super.paintComponent(g);
        contenedor.draw(g);
        Image robot = loadImage("/src/images/robot3.png"); //Robot diseñado por Juan Pablo Perez Figueroa
        g.drawImage(ad, 0, 0, null);
        g.drawImage(fondo, 0, 50, null);
        
        //Imagenes de niveles , if nivel 1,2,3
        g.setColor(Color.black);
        g.fillRect(-1, 580, 602, 138);
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
        g.drawImage(robot, x-64, 430, null);
         if(disparos <= -1){ //Verifica si el jugador se ha quedado sin disparos
             //Y muestra una ventana para reiniciar
            g.setColor(Color.black);
            g.fillRect(0, 0, 600, 750);
            g.setColor(Color.red);
            g.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 40));
            g.drawString("PERDISTE", 200, 325);
            g.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 25));
            g.drawString("Presione 'R' para reiniciar", 125, 350);
         } else if (selecNivel == 0){
             super.paintComponent(g);
             inicio.paintComponent(g);
         }
         
         if(puntaje >= nCajas*100){
              g.setColor(Color.black);
            g.fillRect(0, 0, 600, 750);
            Color dorado = new Color(219, 217, 81);
            g.setColor(dorado);
            g.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 40));
            g.drawString("GANASTE!", 200, 325);
            g.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 25));
            g.drawString("Presione 'R' para reiniciar", 125, 350);
         }
             
             
        }
    }
    
    public Image loadImage(String imageName){ //Carga las Imagenes del juego
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
    
     public void colisionCaja(){ //Verifica que la pelota golpee las cajas
        for(int i = 0; i < caja.length; i++){
        if(pelota.getRect().intersects(caja[i].getRect())){
             pelota.setVelX(-pelota.getVelX());
             pelota.setVelY(-pelota.getVelY());
            if(pelota.getX()<caja[i].getMaxX()){
               pelota.setVelX(pelota.getVelX());
               
            }
            if(pelota.getY()<caja[i].getMaxY()+15){
                pelota.setVelY(pelota.getVelY());
            }
            if(pelota.getX()>caja[i].getMaxX()){
               pelota.setVelX(-pelota.getVelX());
               
            }
            if(pelota.getY()>caja[i].getMaxY() +15){
                pelota.setVelY(-pelota.getVelY());
            }
            caja[i].setContador(caja[i].getContador()-1);
            cont[i]++; //Cuenta el numero de veces que una caja ha sido golpeada
            
            if(caja[i].getContador() <= 0){//Destruye la caja
             caja[i].setMaxX(-35);
             caja[i].setMinX(-35);
             caja[i].setMinY(-35);
             caja[i].setMaxY(-35);
            puntaje = puntaje + 100;
        }
            
      }
    }
    
    }
     
    
    
    
    
    public void gameStart() { //Metodo que inicia el juego
         
     
        
        Thread gameThread = new Thread() {
            
            @Override
            public void run() {
                while (true) {
                    
                    gameUpdate();
                    repaint();

                    try {
                        Thread.sleep(30);//Se usa como repaint();
                        
                    } catch (InterruptedException ex) {
                        System.out.println("Wrong!!");
                    }
                }
               
            }
        };
        gameThread.start();
    }

    public void gameUpdate() {
        MouseEvent e = null;
        pelota.Collision(contenedor);
       // destruirCaja();
        colisionCaja();
        x = (int) pelota.getX();
        y = 570;
        pelota.setVel(10);
        
       
        
      }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
        pelota.setVelX((float) (pelota.getVel() * Math.cos(Math.toRadians(angulo))));
        pelota.setVelY((float) (-pelota.getVel() * (float) Math.sin(Math.toRadians(angulo))));
        gameStart();
        disparos --;
        
 
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
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
