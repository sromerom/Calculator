package Keypads;

import Calculs.Calcul;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeypadBase extends JPanel{
    boolean primeraVegada = true;
    private JPanel numpadBase;
    private JButton a1Button;
    private JButton a4Button;
    private JButton a7Button;
    private JButton a0Button;
    private JButton a2Button;
    private JButton a5Button;
    private JButton a8Button;
    private JButton dotButton;
    private JButton eqButton;
    private JButton a9Button;
    private JButton a6Button;
    private JButton a3Button;
    private JButton EXPButton;
    private JButton mulButton;
    private JButton sumButton;
    private JButton sinButton;
    private JButton cosButton;
    private JButton resButton;
    private JButton divButton;
    private JButton DELButton;
    private JButton xButton;
    private JButton lnButton;
    private JButton logButton;
    private JButton fXButton;
    private JButton parlButton;
    private JButton parrButton;
    private JButton delButton;
    private JButton resetButton;
    private JButton aButton;
    private JButton bButton;
    private JButton cButton;
    private JButton dButton;
    private JButton eButton;
    private JButton fButton;
    private JPanel pantallaConversor;
    private JTextField pantallaCon;
    private Calcul calcul;
    private String numPantalla;
    public KeypadBase(JTextField jtfOp, JTextField jtfRes, String opcioElegida) {

        pantallaCon.setBorder(new EmptyBorder(0,0,0,0));

        eqButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPantalla = jtfOp.getText();
                System.out.println("Tipus opcio " + opcioElegida);
                calcul = new Calcul(numPantalla, opcioElegida);

                jtfRes.setText(calcul.getResultatString());
                pantallaCon.setText(calcul.getResultatConversio());
                numPantalla = "";

            }
        });
    }

    public JPanel getNumpadBase() {
        return numpadBase;
    }

    public void setNumpadBase(JPanel numpadBase) {
        this.numpadBase = numpadBase;
    }
}
