import javax.swing.*;

public class CalculatorMain {
    public static void main(String[] args) {
        Calculator frame = new Calculator();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
