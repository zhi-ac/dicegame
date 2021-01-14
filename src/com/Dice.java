package com;

import javax.swing.*;
import java.sql.Time;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

public class Dice extends JButton implements Runnable{
    private int num;//记录骰子上面的数字

    public Dice(ImageIcon imageIcon) {
        super(imageIcon);
    }

    public int getNum() {
        return num;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            num = (random.nextInt(6) + 1);
            String pName = "img/t" + num + ".png";
            ImageIcon imageIcon = new ImageIcon(pName);
            this.setIcon(imageIcon);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
