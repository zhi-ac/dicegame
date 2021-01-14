package com;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel implements ActionListener {
    StartButton[] startButtons;
    int unitWidth, unitHeight;
    Dice[] dices;
    JLabel singleText;
    JTextArea totalText;
    JLabel resultText;

    public StartPanel (int unitWidth, int unitHeight, Dice[] dices, JLabel singleText, JTextArea totalText, JLabel resultText) {
        this.unitWidth = unitWidth;
        this.unitHeight = unitHeight;
        this.dices = dices;
        this.singleText = singleText;
        this.totalText = totalText;
        this.resultText = resultText;
        setTotalLayout();
        installStartButtons();
    }

    private void setTotalLayout() {
        this.setLayout(null);
        this.setBackground(Color.green);
        this.setBounds(unitWidth, unitHeight / 2, unitWidth * 6, (int) (unitHeight * 2.5));
    }

    private void installStartButtons() {
        getStartButtons();
        setButtonLayout();
    }

    private void setButtonLayout() {
        ImageIcon imageIcon = new ImageIcon("img/t6.png");
        int w = imageIcon.getIconWidth();
        int h = imageIcon.getIconHeight();
        startButtons[0].setBounds(unitWidth, (int)(unitHeight * 2.5) - h, w, h);
        startButtons[1].setBounds(unitWidth * 4, (int)(unitHeight * 2.5) - h, w, h);
        this.add(startButtons[0]);
        this.add(startButtons[1]);
        JLabel jLabel = new JLabel("" +
                "<html>" +
                "<font size=10> " +
                "<body>" +
                    "买大还是买小" +
                "</body>" +
                "</font>" +
                "</html>");
        jLabel.setBounds(300, 0, 500, 100);
        this.add(jLabel);
        this.setBorder(new TitledBorder(new EtchedBorder()));
    }

    private void getStartButtons() {
        startButtons = new StartButton[2];
        setSingleButton(0, new ImageIcon("img/b1.png"), "b");
        setSingleButton(1, new ImageIcon("img/s1.png"), "s");
    }

    private void setSingleButton(int buttonIndex, ImageIcon buttonImage, String buttonName) {
        startButtons[buttonIndex] = new StartButton(buttonImage, dices, singleText, totalText, resultText);
        startButtons[buttonIndex].setName(buttonName);
        startButtons[buttonIndex].addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButtons[0]) {
            Thread thread = new Thread(startButtons[0]);
            thread.start();
        } else if (e.getSource() == startButtons[1]) {
            Thread thread = new Thread(startButtons[1]);
            thread.start();
        }
    }
}
