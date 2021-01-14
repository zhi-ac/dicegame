package com;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SinglePrintPanel extends JPanel {
    int unitWidth,unitHeight;
    JLabel singleText;

    public SinglePrintPanel(int unitWidth, int unitHeight, JLabel singleText) {
        this.unitWidth = unitWidth;
        this.unitHeight = unitHeight;
        this.singleText = singleText;
        setTotalLayout();
    }

    private void setTotalLayout() {
        JPanel innerPanel = new JPanel();
        setInnerPanelLayout(innerPanel);
        setThisLayout(innerPanel);
    }

    private void setThisLayout(JPanel innerPanel) {
        this.setLayout(null);
        this.setBackground(Color.MAGENTA);
        this.setBounds(unitWidth, unitHeight * 6, unitWidth * 6, unitHeight * 3);
        this.add(innerPanel);
        this.setBorder(new TitledBorder(new EtchedBorder()));
    }

    private void setInnerPanelLayout(JPanel innerPanel) {
        innerPanel.setBackground(Color.PINK);
        innerPanel.setBounds(20, 20, unitWidth * 5, (int)(unitHeight * 2.5));
        innerPanel.add(singleText);
        innerPanel.setBorder(new TitledBorder(new EtchedBorder()));
    }
}
