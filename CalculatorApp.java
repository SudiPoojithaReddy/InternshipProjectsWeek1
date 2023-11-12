import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame {
    private JTextField num1Field, num2Field;
    private JButton addButton, subButton, mulButton, divButton;
    private JLabel resultLabel;

    public CalculatorApp() {
        setTitle("Simple Calculator");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        num1Field = new JTextField();
        num2Field = new JTextField();
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("÷");
        resultLabel = new JLabel("Result: ");

        add(new JLabel("Enter Number 1: "));
        add(num1Field);
        add(new JLabel("Enter Number 2: "));
        add(num2Field);
        add(addButton);
        add(subButton);
        add(mulButton);
        add(divButton);
        add(resultLabel);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('+');
            }
        });

        subButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('-');
            }
        });

        mulButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('*');
            }
        });

        divButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('/');
            }
        });
    }

    private void calculate(char operator) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());

            double result = 0.0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorApp calculator = new CalculatorApp();
            calculator.setVisible(true);
        });
    }
}