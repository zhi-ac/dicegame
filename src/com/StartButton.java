package com;

import javax.swing.*;

public class StartButton extends JButton implements Runnable {
    Dice[] dices;
    JLabel singleText;
    JTextArea totalText;
    static int index;
    Customer customer;
    JLabel resultText;
    int wonCount;

    public StartButton(ImageIcon imageIcon, Dice[] dices, JLabel singleText, JTextArea totalText, JLabel resultText) {
        super(imageIcon);
        this.singleText = singleText;
        this.totalText = totalText;
        this.dices = dices;
        this.resultText = resultText;
    }

    @Override
    public synchronized void run() {
        String pName = this.getName();
        String image1 = "img/" + this.getName() + "1.png";
        String image2 = "img/" + this.getName() + "2.png";
        ImageIcon imageIcon1 = new ImageIcon(image1);
        ImageIcon imageIcon2 = new ImageIcon(image2);
        this.setIcon(imageIcon2);
        startDicesThread();
        printOne(pName);
        totalPrint();
        this.setIcon(imageIcon1);
    }

    private void startDicesThread() {
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            threads[i] = new Thread(dices[i]);
            threads[i].start();
        }
        try {
            for (int i = 0; i < 3; i++) {
                threads[i].join();
            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    private void totalPrint() {
        totalText.append(customer.toString());
        totalText.append("\r\n");
        resultText.setBounds(10,index * 20 +30, 100, 100);
        resultText.setText("" +
                "<html>" +
                "<font size=6> " +
                "<body>" +
                    "玩了" + index  + "次" + "    赢了：" + wonCount +"次" + "成功率是：" + String.format("%2.2f", (wonCount * 1.0)/index * 100) + "%" +
                "   </body>" +
                "</font>" +
                "</html>");
    }

    private void printOne(String pName) {
        String guess;
        if (pName.equals("b")) guess = "big";
        else guess = "small";
        int dice1 = dices[0].getNum();
        int dice2 = dices[1].getNum();
        int dice3 = dices[2].getNum();
        int sum = dice1 + dice2 + dice3;
        String dicesResult;
        if (sum > 9) {
            dicesResult = "big";
        } else {
            dicesResult = "small";
        }
        String result = (guess == dicesResult ? "won" : "lose");
        if (result == "won") wonCount ++;
        customer = new Customer(index++, guess, dice1 + "  " + dice2 + "  " +dice3, sum, dicesResult, result);
        singleText.setText("" +
                "<html>" +
                    "<font size=6> " +
                        "<body>" +
                            "Three Dice:" + dice1 + "  " + dice2 + "  " + dice3 +  "<br/>" +
                            "The sum of three dice:" + String.format("% 2d", sum) + "     " + dicesResult + "<br/>" +
                            "--------------------" + "<br/>" +
                            "you guess:" + guess + "<br/>" + "The dice result:" + dicesResult + "<br/>" +
                            "The bureau results:" + result + "<br/>" +
                        "</body>" +
                    "</font>" +
                "</html>");
    }
}
