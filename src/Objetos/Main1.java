/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Main1 extends JFrame {
    public Main1(){
        initUI();
    }
    public static void main(String[] args) {
        Main1 ex = new Main1();
        ex.setVisible(true);
    }
    
    private void initUI(){
        
        
        add(new Board());
        setSize(600, 700);
        setTitle("BB");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
}
