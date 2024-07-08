import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DigitalCalculator extends JFrame implements ActionListener {

    // Create a frame
    private JFrame frame;

    // Create a textfield
    private JTextField textfield;

    // Store operator and operands
    private String operator;
    private double num1, num2, result;

    // Create buttons
    private JButton[] numberButtons = new JButton[10];
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton, negButton;
    
    // Create a panel
    private JPanel panel;

    public DigitalCalculator() {
        // Create a frame
        frame = new JFrame("Digital Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(330, 450);
        frame.setLayout(null);
    frame.getContentPane().setBackground(Color.CYAN );

        // Create a textfield
        textfield = new JTextField();
        textfield.setBounds(50, 25, 215, 50);
        textfield.setFont(new Font("Arial", Font.PLAIN, 28));
        textfield.setEditable(false);
        textfield.setBackground(Color.darkGray);
        textfield.setForeground(Color.WHITE);

        // Define buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setBackground(Color.BLACK);
            numberButtons[i].setForeground(Color.WHITE);
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 13));
            numberButtons[i].setFocusable(false);
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        JButton[] functionButtons = {addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton, negButton};
        for (JButton button : functionButtons) {
            button.addActionListener(this);
            button.setBackground(Color.BLACK);
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Arial", Font.BOLD, 13));
            button.setFocusable(false);
        }

        // Create a panel
        panel = new JPanel();
        panel.setBounds(50, 100, 215, 215);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.CYAN);

        // Add buttons to panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Add components to frame
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);

        // Set button positions
        negButton.setBounds(50, 325, 48, 48);
        delButton.setBounds(107, 325, 74, 48);
        clrButton.setBounds(190, 325, 75, 48);

        // Set frame visibility
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new DigitalCalculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = "+";
            textfield.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = "-";
            textfield.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = "*";
            textfield.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = "/";
            textfield.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText());

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textfield.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }
    }
}













