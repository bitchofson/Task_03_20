package com.metanit;


import javax.swing.*;

public class Window {

    public static void winMain() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WindowFrame();
            }
        });
    }


    public static void main(String[] args) {
            winMain();
    }

}
