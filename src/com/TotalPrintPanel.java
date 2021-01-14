package com;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class TotalPrintPanel extends JPanel {
    int unitWidth, unitHeight;
    JTextArea totalText;
    JLabel resultText;

    public TotalPrintPanel(int unitWidth, int unitHeight, JTextArea totalText, JLabel resultText) {
        this.unitWidth = unitWidth;
        this.unitHeight = unitHeight;
        this.totalText = totalText;
        this.resultText = resultText;
        setTotalLayout();
    }

    private void setTotalLayout() {
        setTotalText();
        setThisLayout();
    }

    private void setTotalText() {
        totalText.setBackground(Color.CYAN);
        Font font = new Font("宋体", 1, 20);
        totalText.setFont(font);
        totalText.setBounds(0, 0, unitWidth * 6, unitHeight * 9);
        String str =    String.format("%6s|", "id") + String.format("%10s|", "guess") +
                        String.format("%15s|", "threeDices") + String.format("%10s|", "dicesSum") +
                        String.format("%14s|", "diceResult") + String.format("%10s|", "result");
        totalText.append(str);
        totalText.append("\t\n");
        totalText.setEditable(false);
    }

    private void setThisLayout() {
        this.setBounds(unitWidth * 8, 0, unitWidth * 6, unitHeight * 9);
        this.add(totalText);
        this.setBackground(Color.CYAN);
        this.add(resultText);
        this.setBorder(new TitledBorder(new EtchedBorder()));
    }
}
