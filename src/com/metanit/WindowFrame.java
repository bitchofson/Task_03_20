package com.metanit;

import util.JTableUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.LinkedList;

public class WindowFrame {
    private JPanel FramePanel;
    private JTextField textField1;
    private JTable tableOutput1;
    private JTextField textField2;
    private JButton buttonEx;
    private JTable tableOutput2;
    private JTable tableOutput3;
    private JTable tableOutput4;

     LinkedList<String> resultQueue1 = new LinkedList<>();
     LinkedList<String> resultStack1 = new LinkedList<>();

     LinkedList<String> resultQueue2 = new LinkedList<>();
     LinkedList<String> resultStack2 = new LinkedList<>();


    public WindowFrame() {
        JFrame jfrm = new JFrame();

        jfrm.setTitle("Task_03_20");
        jfrm.setContentPane(FramePanel);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.pack();

        JTableUtils.initJTableForArray(tableOutput1, 100, true, true, false, false);
        JTableUtils.initJTableForArray(tableOutput2, 100, true, true, false, false);
        JTableUtils.initJTableForArray(tableOutput3, 100, true, true, false, false);
        JTableUtils.initJTableForArray(tableOutput4, 100, true, true, false, false);


        jfrm.pack();
        jfrm.setVisible(true);


        buttonEx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                File dir = new File(textField1.getText());

                String ext = textField2.getText();


                Main.searchFilesQueue(dir, ext, resultQueue1);
                Main.searchFilesStack(dir, ext, resultStack1);

                String[] resQ1 = resultQueue1.toArray(new String[0]);
                String[] resS1 = resultStack1.toArray(new String[0]);

                JTableUtils.writeArrayToJTable(tableOutput1, resQ1);
                JTableUtils.writeArrayToJTable(tableOutput2, resS1);


                MainCustom.searchFilesQueue(dir, ext, resultQueue2);
                MainCustom.searchFilesStack(dir, ext, resultStack2);

                String[] resQ2 = resultQueue2.toArray(new String[0]);
                String[] resS2 = resultStack2.toArray(new String[0]);

                JTableUtils.writeArrayToJTable(tableOutput3, resQ2);
                JTableUtils.writeArrayToJTable(tableOutput4, resS2);

            }
        });
    }


}
