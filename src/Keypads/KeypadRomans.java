package Keypads;

import Calculadora.Calculator;
import Calculs.Calcul;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeypadRomans extends JPanel {
    private JPanel numpadRomans;
    private JButton iButton;
    private JButton ivButton;
    private JButton viiButton;
    private JButton zeroButton;
    private JButton iiButton;
    private JButton vButton;
    private JButton viiiButton;
    private JButton dotButton;
    private JButton eqButton;
    private JButton ixButton;
    private JButton viButton;
    private JButton iiiButton;
    private JButton mulButton;
    private JButton sumButton;
    private JButton resButton;
    private JButton divButton;
    private JButton parlButton;
    private JButton parrButton;
    private JButton delButton;
    private JButton resetButton;

    private Calcul calcul;
    private String numPantalla;
    boolean primeraVegada = true;

    public KeypadRomans(JTextField jtfOp, JTextField jtfRes) {
        eqButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPantalla = jtfOp.getText();
                System.out.println("Tipus opcio " + Calculator.opcioElegida);
                calcul = new Calcul(numPantalla, Calculator.opcioElegida);
                jtfRes.setText(calcul.getResultatString());
                numPantalla = "";

            }
        });

        iButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (primeraVegada) {
                    numPantalla = "I";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "I";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        iiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (primeraVegada) {
                    numPantalla = "II";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "II";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        iiiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (primeraVegada) {
                    numPantalla = "III";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "III";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        ivButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (primeraVegada) {
                    numPantalla = "IV";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "IV";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        vButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (primeraVegada) {
                    numPantalla = "V";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "V";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        viButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (primeraVegada) {
                    numPantalla = "VI";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "VI";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        viiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (primeraVegada) {
                    numPantalla = "VII";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "VII";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        viiiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (primeraVegada) {
                    numPantalla = "VIII";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "VIII";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        ixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (primeraVegada) {
                    numPantalla = "IX";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "IX";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        parlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (primeraVegada) {
                    numPantalla = "(";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "(";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        parrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (primeraVegada) {
                    numPantalla = ")";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += ")";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        sumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (primeraVegada) {
                    numPantalla = "+";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "+";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        resButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (primeraVegada) {
                    numPantalla = "-";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "-";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        mulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (primeraVegada) {
                    numPantalla = "*";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "*";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        divButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (primeraVegada) {
                    numPantalla = "/";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "/";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        dotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (primeraVegada) {
                    numPantalla = ".";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += ".";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                char eliminar = numPantalla.charAt(numPantalla.length() - 1);
                String eliminarString = Character.toString(eliminar);
                String stringNou = numPantalla.replaceAll(eliminarString, "");
                numPantalla = stringNou;
                jtfOp.setText(stringNou);
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                numPantalla = "";
                jtfOp.setText(numPantalla);
            }
        });


    }

    public JPanel getNumpadRomans() {
        return numpadRomans;
    }

    public void setNumpadRomans(JPanel numpadRomans) {
        this.numpadRomans = numpadRomans;
    }
}


