package View;

import Exceptions.MissmatchedBracketsException;
import Exceptions.WrongExpressionException;
import ONP.ONP;
import Solver.Solver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {

    private JPanel mainPanel;
    private JTextField textField1;
    private JButton BP;
    private JButton CLR;
    private JButton LeftBracket;
    private JButton RightBracket;
    private JButton Divide;
    private JButton Multiply;
    private JButton Dot;
    private JButton Minus;
    private JButton Plus;
    private JButton Equals;
    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;

    public Gui()
    {
        Dot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {textField1.setText(textField1.getText() +".");}
        });
        Equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ONP onp = new ONP();
                Solver solver = new Solver();
                onp.setInput(textField1.getText());
                try
                {
                    onp.toONP();
                }
                catch (MissmatchedBracketsException ex)
                {
                    String message = "\"Error\"\n"
                            + "An incorrect expression or number of brackets was provided";
                    JOptionPane.showMessageDialog(new JFrame(), message, "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                solver.setOnp(onp.getONP());
                try
                {
                    String tmp = solver.solve().toString();
                    textField1.setText(tmp);
                }
                catch (WrongExpressionException ex)
                {
                    String message = "\"Error\"\n"
                            + "An incorrect expression or number of brackets was provided";
                    JOptionPane.showMessageDialog(new JFrame(), message, "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        });
        BP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField1.getText();
                if(text != null && text.length()>0) {
                    text = text.substring(0, text.length() - 1);
                }
                textField1.setText(text);
            }
        });
        CLR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
            }
        });
        LeftBracket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {textField1.setText(textField1.getText()+ "(");}
        });
        RightBracket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText()+ ")");
            }
        });
        Plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText()+ "+");
            }
        });
        Minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText()+ "-");
            }
        });
        Multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText()+ "*");
            }
        });
        Divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText()+ "/");
            }
        });
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() +"0");
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { textField1.setText(textField1.getText()+ "1");}
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { textField1.setText(textField1.getText()+ "2");}
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText()+ "3");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText()+ "4");
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText()+ "5");
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText()+ "6");
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText()+ "7");
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText()+ "8");
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText()+ "9");
            }
        });
    }
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        UIManager.getInstalledLookAndFeels();
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        JFrame mainFrame = new JFrame("MyCalculator");
        mainFrame.setMinimumSize(new Dimension(250,300));
        Gui form = new Gui();
        mainFrame.setContentPane(form.mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);

    }

}
