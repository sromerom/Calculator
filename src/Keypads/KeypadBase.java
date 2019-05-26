package Keypads;

import Calculadora.Calculator;
import Calculs.Calcul;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe KeypadBase que ens permet crear un keypad dissenyat especificament per l'opcio base 2, 8 i 16. Aquest Keypad
 * es carrega a la classe Calculator.
 * @author Samuel Romero Marín
 * @version 0.7.0
 * @since 0.7.0
 */
public class KeypadBase extends JPanel {
    private boolean primeraVegada = true;
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
    private JButton corlButton;
    private JButton corrButton;
    private JButton aButton;
    private JButton bButton;
    private JButton cButton;
    private JButton dButton;
    private JButton eButton;
    private JButton fButton;
    private JPanel pantallaConversor;
    private JLabel resDecimal;
    private JLabel resOctal;
    private JLabel resHexadecimal;
    private JLabel resBinari;
    private JTextField pantallaCon;
    private Calcul calcul;
    private String numPantalla;

    /**
     * Constructor KeypadBase que ens permet carregar tots els items del keypadbase i donar funcions a cada un del botons
     * d'aquest keypad.
     * @param jtfOp Parametre JTextField del input on s'ingressa l'operacio a calcular de la classe Calculator.
     * @param jtfRes Parametre JtextField del input on es retorna el resultat que s'ha calculat la classe Calulcator.
     */
    public KeypadBase(JTextField jtfOp, JTextField jtfRes) {

        eqButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPantalla = jtfOp.getText();
                System.out.println("Tipus opcio " + Calculator.opcioBaseElegida);
                calcul = new Calcul(numPantalla, Calculator.opcioBaseElegida);

                //jtfRes.setText(calcul.getResultatString());

                resDecimal.setText(Integer.toString(calcul.getResultatDecimal()));
                resOctal.setText(calcul.getResultatOctal());
                resHexadecimal.setText(calcul.getResultatHexacimal());
                resBinari.setText(calcul.getResultatBinari());

                //pantallaCon.setText(calcul.getResultatConversio());
                numPantalla = "";

            }
        });


        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "0";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "0";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "1";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "1";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "2";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "2";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "3";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "3";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "4";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "4";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "5";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "5";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "6";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "6";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "7";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "7";
                    jtfOp.setText(numPantalla);
                }
            }
        });


        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "8";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "8";
                    jtfOp.setText(numPantalla);
                }
            }
        });


        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "9";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "9";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        sumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
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
            public void actionPerformed(ActionEvent actionEvent) {
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
            public void actionPerformed(ActionEvent actionEvent) {
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
            public void actionPerformed(ActionEvent actionEvent) {
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
            public void actionPerformed(ActionEvent actionEvent) {
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


        DELButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                numPantalla = "";
                jtfOp.setText(numPantalla);
            }
        });

        xButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "!";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "!";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        lnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "ln";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "ln";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "log";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "log";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        sinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "sin";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "sin";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        cosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "cos";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "cos";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        parlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
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
            public void actionPerformed(ActionEvent actionEvent) {
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

        EXPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "exp";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "exp";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        corlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "{";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "{";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        corrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "}";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "}";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        aButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "A";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "A";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        bButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "B";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "B";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "C";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "C";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        dButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "D";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "D";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        eButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "E";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "E";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        fButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "F";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "F";
                    jtfOp.setText(numPantalla);
                }
            }
        });
    }

    /**
     * Metode getter per aconseguir el JPanel principal a on es troben tots els item d'aquest keypad per tal de
     * carregar-ho a la classe Calculator.
     * @return Retorna un JPanel amb tots els items corresponents a aquest keypadbase.
     */
    public JPanel getNumpadBase() {
        return numpadBase;
    }

}
