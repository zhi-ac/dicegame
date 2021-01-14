package com;

import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;

public class GameFrame {
    JFrame jFrame;
//    Container contentPane;
    JLayeredPane contentPane;
    int w, h;
    int unitWidth, unitHeight;
    Dice[] dices;
    JLabel singleText;
    JLabel resultText;
    JTextArea totalText;
    JLayeredPane jLayeredPane;

    public GameFrame() {
        setJFrame();//设置外部窗体
        getContainer();//获得外部窗体的容器
        setLayout();//设置自定义布局
        jFrame.setVisible(true);
    }

    private void setJFrame() {
        jFrame = new JFrame("大赌怡情，小赌伤身");
        getWidthAndHeight();//获得屏幕的宽和高
        jFrame.setSize(w, h);
        jFrame.setLayout(null);//布局
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void getWidthAndHeight() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        w = toolkit.getScreenSize().width;
        h = toolkit.getScreenSize().height;
        unitHeight = h / 10;
        unitWidth = w / 15;
    }

    private void getContainer() {
//        contentPane = jFrame.getContentPane();
        contentPane = jFrame.getLayeredPane();
        jLayeredPane = jFrame.getLayeredPane();
        ImageIcon background = new ImageIcon("img/bj2.jpg");
        JLabel jLabel = new JLabel(background);
        jLabel.setSize(w, h);

        contentPane.setBackground(Color.BLACK);
//        contentPane.add(jLabel, new Integer(-100));
    }

    public void setLayout() {
        addDices();
        addSinglePrint();
        addTotalPrint();
        addStartPanel();
    }

    public void addStartPanel() {
        StartPanel startPanel = new StartPanel(unitWidth, unitHeight,dices, singleText, totalText, resultText);
        contentPane.add(startPanel);
    }

    public void addDices() {
        dices = getDices();
        DicesPanel dicesPanel = new DicesPanel(unitWidth, unitHeight, dices);
        contentPane.add(dicesPanel);
    }

    private Dice[] getDices() {
        Dice[] dices = new Dice[3];
        ImageIcon imageIcon = new ImageIcon("img/t6.png");
        for (int i = 0; i < 3; i++)
            dices[i] = new Dice(imageIcon);
        return dices;
    }

    public void addSinglePrint() {
        singleText = new JLabel("");
        SinglePrintPanel singlePrint = new SinglePrintPanel(unitWidth, unitHeight, singleText);
        contentPane.add(singlePrint);
    }

    private void addTotalPrint() {
        totalText = new JTextArea();
        resultText = new JLabel();
        TotalPrintPanel totalPrint = new TotalPrintPanel(unitWidth, unitHeight, totalText, resultText);
        contentPane.add(totalPrint);
    }

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
    }
}
