package com;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class DicesPanel extends JPanel{
    Dice[] dices;
    int unitWidth, unitHeight;

    public DicesPanel(int unitWidth, int unitHeight, Dice[] dices) {
        this.unitWidth = unitWidth;
        this.unitHeight = unitHeight;
        this.dices = dices;
        setTotalLayout();
    }

    private void setTotalLayout() {
        this.setBorder(new TitledBorder(new EtchedBorder()));
        this.setLayout(new GridLayout(1,3));
        for (int i = 0; i < 3; i++)
            this.add(dices[i]);
        ImageIcon imageIcon = new ImageIcon("img/t6.png");
        int w = imageIcon.getIconWidth();
        int h = imageIcon.getIconHeight();                         //unitWidth * 4     (int)(unitHeight * 1.5)
        this.setBounds(unitWidth * 2, (int)(unitHeight * (3.5)), w * 3, h);
    }
}
