/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Main1 extends JFrame {
    
    Inicio inicio = new Inicio();
    Niveles niveles = new Niveles();
    Niveles niveles1;
    public static int  selecNivel = 0;
    public boolean restart = true;
    public Main1() {
        initUI();
    }

    public static void main(String[] args) {
        Main1 ex = new Main1();
        ex.setVisible(true);
    }

    private void initUI() {
        
        add(inicio);
        setSize(600, 700);
        setTitle("Unal Adventure");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setFocusable(true); //Debe estar en modo Focus para que puede detectar el evento
        addKeyListener(new EventosTeclado()); //Inner class que procesa los eventos del teclado
         
        
    }

    public int getSelecNivel() {
        return selecNivel;
    }

    

       private class EventosTeclado extends KeyAdapter {
        //Cuando se suelta una tecla
         @Override
        public void keyReleased(KeyEvent e) {
            
           int key = e.getKeyCode();
           if (key == KeyEvent.VK_1) {
            selecNivel = 1;
            remove(inicio);
            niveles= new Niveles();
            add(niveles);
            revalidate();
           }
           
           if (key == KeyEvent.VK_2) {
            selecNivel = 2;
            remove(inicio);
            niveles= new Niveles();
            add(niveles);
            revalidate();
           }
           if(key == KeyEvent.VK_3){
               selecNivel = 3;
               remove(inicio);
            niveles= new Niveles();
            add(niveles);
            revalidate();
           }
           
            if(key == KeyEvent.VK_R){ //Reinicia el juego.
            remove(niveles);
                System.out.println("Reload");
             inicio = new Inicio();
            add(inicio);
            revalidate();
            selecNivel = 0;
            }
          
        }
        //Cuando se presiona una tecla
        @Override
        public void keyPressed(KeyEvent e) {
           
        }
    }

}
