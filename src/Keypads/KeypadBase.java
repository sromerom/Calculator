package Keypads;

import javax.swing.*;

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
    private String numPantalla;
    KeypadBase() {
        setNumpadBase(new JPanel());
    }

    public JPanel getNumpadBase() {
        return numpadBase;
    }

    public void setNumpadBase(JPanel numpadBase) {
        this.numpadBase = numpadBase;
    }
}
