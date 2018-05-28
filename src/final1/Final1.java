/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final1;

import javax.swing.*;

public class Final1 extends JFrame {
    public Final1() {
        initUI();
    }

    public static void main(String[] args) {
        Final1 ex = new Final1();
        ex.setVisible(true);
    }

    private void initUI() {
        add(new gameBoard());
        setSize(600, 700);
        setTitle("");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

    }

}
