import Calculadora.Calculator;

import javax.swing.*;

/**
 * Aquesta classe es qui s'encarrega d'executar el programa. Es el main a on instanciarem la classe calculadora i
 * cridarem alguns metodes com pot ser pack() o setVisisble().
 * @author Samuel Romero Marín
 */
public class CalculatorMain {
    /**
     * Static main per tal d'executar la calculadora
     * @param args
     */
    public static void main(String[] args) {
        //KeypadBasic frame = new KeypadBasic();
        Calculator frame = new Calculator();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(frame.getTotal());
        frame.pack();
        frame.setVisible(true);
    }
}
