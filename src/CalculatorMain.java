import javax.swing.*;

public class CalculatorMain {
    public static void main(String[] args) {
        //KeypadBasic frame = new KeypadBasic();
        Calculator frame = new Calculator();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(frame.getTotal());
        frame.pack();
        frame.setVisible(true);
    }
}
